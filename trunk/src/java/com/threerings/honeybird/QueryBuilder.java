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

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gdata.client.analytics.DataQuery;
import com.google.gdata.data.analytics.DataFeed;

public class QueryBuilder
{
    public QueryBuilder (Analytics analytics, DataQuery query)
    {
        _analytics = analytics;
        _query = query;
    }

    /**
     * Adds the given Dimensions or Metrics to the results from this query.
     */
    public QueryBuilder add (Source... sources)
    {
        for (Source source : sources) {
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

    protected String constructQueryString (Collection<String> pieces)
    {
        return Analytics.join(pieces.toArray(new String[pieces.size()]), ",");
    }


    protected void fillInQuery ()
    {
        if (_filter != null) {
            _query.setFilters(_filter.makeFilter());
        }
        List<String> metrics = new ArrayList<String>();
        List<String> dimensions = new ArrayList<String>();
        for (Source source : _sources) {
            if(source instanceof Dimension) {
                dimensions.add(source._name);
            } else {
                metrics.add(source._name);
            }
        }
        _query.setMetrics(constructQueryString(metrics));
        _query.setDimensions(constructQueryString(dimensions));
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
    public DataFeed query ()
    {
        _analytics.waitForQuota();
        fillInQuery();

//        log.info("Running query", "dimensions", _query.getDimensions(), "metrics",
//            _query.getMetrics(), "filters", _query.getFilters(), "day", _query.getStartDate());
        return _analytics.getFeed(_query);
    }

    protected Filter _filter;

    protected final DataQuery _query;

    protected final Set<Source> _sources = new HashSet<Source>();

    protected final Analytics _analytics;
}
