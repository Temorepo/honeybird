/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/QueryResults.java

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

import java.util.Iterator;

import com.google.gdata.data.analytics.Aggregates;
import com.google.gdata.data.analytics.DataEntry;
import com.google.gdata.data.analytics.DataFeed;


public class QueryResults implements Iterable<QueryResult>
{
    public QueryResults (DataFeed result)
    {
        _result = result;
    }

    public <V> V getAggregate (Metric<V> source)
    {
        Aggregates aggs = _result.getAggregates();
        for (com.google.gdata.data.analytics.Metric aggMetric : aggs.getMetrics()) {
            if (aggMetric.getName().equals(source.getName())) {
                return source.extractValue(aggMetric);
            }
        }
        throw new IllegalArgumentException(source.getName() + " wasn't included in this query!");
    }

    public Iterator<QueryResult> iterator ()
    {
        final Iterator<DataEntry> source = _result.getEntries().iterator();
        return new Iterator<QueryResult>() {
            public boolean hasNext () {
                return source.hasNext();
            }

            public QueryResult next () {
                return new QueryResult(source.next());
            }

            public void remove () {
                throw new UnsupportedOperationException("Can't remove from Results");
            }
        };
    }

    protected final DataFeed _result;
}
