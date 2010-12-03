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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gdata.client.Query;
import com.google.gdata.client.analytics.AnalyticsService;
import com.google.gdata.client.analytics.DataQuery;
import com.google.gdata.data.analytics.DataFeed;
import com.google.gdata.util.common.base.Join;

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
     * Sorts the results from this query in ascending order by the given sources, in the order
     * that the sources are given. If the query already contains sort sources, these sources are
     * applied after the existing sources.
     */
    public QueryBuilder sort (Source<?>... sources)
    {
        for (Source<?> source : sources) {
            if (!_sorts.contains(source.getName())) {
                _sorts.add(source.getName());
                addSource(source);
            }
        }
        return this;
    }

    /**
     * Sorts the results from this query in descending order by the given sources, in the order
     * that the sources are given. If the query already contains sort sources, these sources are
     * applied after the existing sources.
     */
    public QueryBuilder sortDescending (Source<?>... sources)
    {
        for (Source<?> source : sources) {
            String sort = "-" + source.getName();
            if (!_sorts.contains(sort)) {
                _sorts.add(sort);
                addSource(source);
            }
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
     * Sets the start day for the query to the specified day in the specified month and year.
     *
     * @param year a regular year value, like 1900
     * @param month a 0-based month value, like {@link Calendar#JANUARY}
     * @param day a regular day of the month value, like 31
     */
    public QueryBuilder from (int year, int month, int day)
    {
        return from(makeDate(year, month, day));
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
     * Sets the end day for the query to the specified day in the specified month and year.
     *
     * @param year a regular year value, like 1900
     * @param month a 0-based month value, like {@link Calendar#JANUARY}
     * @param day a regular day of the month value, like 31
     */
    public QueryBuilder to (int year, int month, int day)
    {
        return to(makeDate(year, month, day));
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
     * Sets the query to consist only of the specified day in the specified month and year.
     *
     * @param year a regular year value, like 1900
     * @param month a 0-based month value, like {@link Calendar#JANUARY}
     * @param day a regular day of the month value, like 31
     */
    public QueryBuilder on (int year, int month, int day)
    {
        return on(makeDate(year, month, day));
    }

    /**
     * Sets the index in the full set of results to start with for this particular query. Results
     * start with index 1, and if no start index is supplied, the query goes from 1.
     */
    public QueryBuilder startIndex (int index)
    {
        _startIndex = index;
        return this;
    }

    /**
     * Sets the maximum number of results to return from a single query. The default is 1,000, and
     * no more than 10,000 can be returned in a request.
     */
    public QueryBuilder maxResults (int max)
    {
        _maxResults = max;
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
        _query.setMetrics(Join.join(",", _metrics));
        _query.setDimensions(Join.join(",", _dimensions));
        _query.setSort(Join.join(",", _sorts));
        DateFormat queryDayFormat = new SimpleDateFormat("yyyy-MM-dd");
        _query.setStartDate(queryDayFormat.format(_start));
        _query.setEndDate(queryDayFormat.format(_end));
        _query.setStartIndex(_startIndex);
        _query.setMaxResults(_maxResults);
    }

    protected Date makeDate (int year, int month, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal.getTime();
    }

    protected void addSource (Source<?> source)
    {
        if (source.isDimension()) {
            _dimensions.add(source.getName());
        } else {
            _metrics.add(source.getName());
        }
    }

    protected int _startIndex = Query.UNDEFINED, _maxResults = Query.UNDEFINED;

    protected Filter _filter;

    protected Date _start, _end;

    protected final DataQuery _query;

    protected final Set<String> _dimensions = Sets.newHashSet();

    protected final Set<String> _metrics = Sets.newHashSet();

    // Store sort sources in a List as their order matters
    protected final List<String> _sorts = Lists.newArrayList();

    protected final AnalyticsService _service;
}
