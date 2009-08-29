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
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.google.common.collect.Sets;
import com.google.gdata.client.analytics.AnalyticsService;
import com.google.gdata.client.analytics.DataQuery;
import com.google.gdata.data.analytics.DataFeed;
import com.google.gdata.util.common.base.Joiner;

/**
 * Constructs queries using the google analytics API and conveniently exposes their results.
 */
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
        _service = service;
        try {
            _query = new DataQuery(new URL("https://www.google.com/analytics/feeds/data"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        _query.setIds(profileId);
        on(new Date());
    }

    /**
     * Adds the given dimensions or metrics to the results from this query.
     */
    public QueryBuilder add (Source<?>... sources)
    {
        for (Source<?> source : sources) {
            addSource(source);
        }
        return this;
    }

    /**
     * Filters the data from this query through the given operation. If a filter is already set,
     * it's and'd with the given filter. If the filters reference sources not currently in the
     * query, those sources are added to the results.
     */
    public QueryBuilder filter (Filter filter)
    {
        for (Source<?> source: filter.getSources()) {
            addSource(source);
        }
        if (_filter == null) {
            _filter = filter;
        } else {
            _filter = _filter.and(filter);
        }
        return this;
    }

    /**
     * Sets the start day for the query.
     */
    public QueryBuilder from (Date date)
    {
        _start = date;
        return this;
    }

    /**
     * Sets the end day for the query.
     */
    public QueryBuilder to (Date date)
    {
        _end = date;
        return this;
    }

    /**
     * Sets the query to consist only of the given day.
     */
    public QueryBuilder on (Date date)
    {
        _start = _end = date;
        return this;
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

    protected void fillInQuery ()
    {
        if (_filter != null) {
            _query.setFilters(_filter.makeFilter());
        }
        _query.setMetrics(Joiner.on(",").join(_metrics));
        _query.setDimensions(Joiner.on(",").join(_dimensions));
        DateFormat queryDayFormat = new SimpleDateFormat("yyyy-MM-dd");
        _query.setStartDate(queryDayFormat.format(_start));
        _query.setEndDate(queryDayFormat.format(_end));
    }

    protected void addSource (Source<?> source)
    {
        if (source.isDimension()) {
            _dimensions.add(source.getName());
        } else {
            _metrics.add(source.getName());
        }
    }

    protected Filter _filter;

    protected Date _start, _end;

    protected final DataQuery _query;

    protected final Set<String> _dimensions = Sets.newHashSet();

    protected final Set<String> _metrics = Sets.newHashSet();

    protected final AnalyticsService _service;
}
