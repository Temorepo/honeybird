/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Analytics.java

   Copyright 2009 Three Rings Design, Inc.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.threerings.honeybird;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.google.gdata.client.analytics.AnalyticsService;
import com.google.gdata.client.analytics.DataQuery;
import com.google.gdata.data.analytics.DataFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.common.base.Charsets;

public class Analytics
{
    public static Analytics createWithClasspathAuth ()
        throws IOException, AuthenticationException
    {
        ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = contextLoader.getResourceAsStream("gdata-auth.properties");
        Properties props = new Properties();
        props.load(new InputStreamReader(in, Charsets.UTF_8));
        return new Analytics(props.getProperty("analyticsId"),
            props.getProperty("username"),
            props.getProperty("password"));
    }

    public Analytics (String analyticsId, String username, String password)
        throws AuthenticationException
    {
        _service = new AnalyticsService("analytics");
        _service.setUserCredentials(username, password);
        _analyticsId = "ga:" + analyticsId;
    }

    protected void waitForQuota ()
    {
        synchronized (this) {
            // Keep from going over Google's quota
            long current = System.currentTimeMillis();
            if (current - _lastQuery < MILLIS_BETWEEN_QUERIES) {
                try {
                    Thread.sleep(MILLIS_BETWEEN_QUERIES - (current - _lastQuery));
                } catch (InterruptedException e) {}
            }
            _lastQuery = System.currentTimeMillis();
        }
    }

    public QueryBuilder makeQuery (Date day)
    {
        String queryDay = _queryDayFormat.format(day);
        DataQuery query;
        try {
            query = new DataQuery(new URL("https://www.google.com/analytics/feeds/data"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Code to get the account table id used in setIds below
        // AccountFeed feed = as.getFeed(new URL(
        // "https://www.google.com/analytics/feeds/accounts/default"), AccountFeed.class);
        // String id = Iterables.getOnlyElement(feed.getEntries()).getTableId().getValue();

        query.setIds(_analyticsId);
        query.setStartDate(queryDay);
        query.setEndDate(queryDay);
        return new QueryBuilder(this, query);
    }

    public DataFeed getFeed (DataQuery _query)
    {
        try {
            return _service.getFeed(_query, DataFeed.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static String join (String[] values, String separator)
    {
        if (values.length == 0) {
            return "";
        }
        StringBuilder buf = new StringBuilder();
        for (String val : values) {
            buf.append(val).append(separator);
        }
        buf.setLength(buf.length() - separator.length());
        return buf.toString();
    }

    protected final String _analyticsId;

    protected long _lastQuery;

    protected final SimpleDateFormat _queryDayFormat = new SimpleDateFormat("yyyy-MM-dd");

    protected final AnalyticsService _service;

    protected static final long MILLIS_BETWEEN_QUERIES = 1000;
}
