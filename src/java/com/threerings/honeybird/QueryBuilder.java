/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/QueryBuilder.java

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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gdata.client.analytics.AnalyticsService;
import com.google.gdata.client.analytics.DataQuery;
import com.google.gdata.data.analytics.DataFeed;


public class QueryBuilder
{
    /**
     * Creates a QueryBuilder for the current day.
     *
     * @param profileId -Google Analytics profile ID, prefixed by 'ga:'
     * @param service - An AnalyticsService configured with permission to access the given profile
     */
    public QueryBuilder (String profileId, AnalyticsService service)
    {
        this(profileId, service, new Date());
    }

    /**
     * Creates a QueryBuilder for the given day.
     *
     * @param profileId -Google Analytics profile ID, prefixed by 'ga:'
     * @param service - An AnalyticsService configured with permission to access the given profile
     */
    public QueryBuilder (String profileId, AnalyticsService service, Date onDay)
    {
        this(profileId, service, onDay, onDay);
    }

    /**
     * Creates a QueryBuilder from <code>fromDay<code> to <code>toDay</code>, inclusive on both
     * ends.
     *
     * @param profileId -Google Analytics profile ID, prefixed by 'ga:'
     * @param service - An AnalyticsService configured with permission to access the given profile
     */
    public QueryBuilder (String profileId, AnalyticsService service, Date fromDay,
            Date toDay)
    {
        _service = service;
        try {
            _query = new DataQuery(new URL("https://www.google.com/analytics/feeds/data"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        _query.setIds(profileId);
        DateFormat queryDayFormat = new SimpleDateFormat("yyyy-MM-dd");
        _query.setStartDate(queryDayFormat.format(fromDay));
        _query.setEndDate(queryDayFormat.format(toDay));
    }

    /**
     * Adds the given Dimensions or Metrics to the results from this query.
     */
    public QueryBuilder add (Source<?>... sources)
    {
        for (Source<?> source : sources) {
            _sources.add(source);
        }
        return this;
    }

    /**
     * Filters the data from this query through the given operation. If a filter is already set,
     * it's and'd with the given filter. If the filters reference sources not currently in the
     * query, those sources are added.
     */
    public QueryBuilder filter (Filter filter)
    {
        _sources.addAll(filter.getSources());
        if (_filter == null) {
            _filter = filter;
        } else {
            _filter = _filter.and(filter);
        }
        return this;
    }

    /**
     * Returns the URI for the query as it currently stands.
     */
    public URI getQueryURI() {
        fillInQuery();
        return _query.getQueryUri();
    }

    /**
     * Returns the results for the query as it currently stands.
     */
    public QueryResults query ()
    {
        fillInQuery();

        try {
            return new QueryResults(_service.getFeed(_query, DataFeed.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String constructQueryString (Collection<String> pieces)
    {
        return join(pieces.toArray(new String[pieces.size()]), ",");
    }

    protected void fillInQuery ()
    {
        if (_filter != null) {
            _query.setFilters(_filter.makeFilter());
        }
        List<String> metrics = new ArrayList<String>();
        List<String> dimensions = new ArrayList<String>();
        for (Source<?> source : _sources) {
            if (source.isDimension()) {
                dimensions.add(source.getName());
            } else {
                metrics.add(source.getName());
            }
        }
        _query.setMetrics(constructQueryString(metrics));
        _query.setDimensions(constructQueryString(dimensions));
    }

    public static String join (String[] values, String separator)
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

    protected Filter _filter;

    protected final DataQuery _query;

    protected final Set<Source<?>> _sources = new HashSet<Source<?>>();

    protected final AnalyticsService _service;
}
