/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/QueryResult.java

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

import com.google.gdata.data.analytics.DataEntry;

/**
 * Wraps a result for a single dimension combination from an analytics query.
 */
public class QueryResult
{
    /**
     * Wraps the given entry.
     */
    public QueryResult (DataEntry entry)
    {
        _entry = entry;
    }

    /**
     * Returns the value for the given metric or dimension. If the metric or dimension isn't
     * present, an IllegalArgumentException is thrown.
     */
    public <V> V getValue (Source<V> metric)
    {
        V result = metric.extractValue(_entry);
        if (result == null) {
            throw new IllegalArgumentException(metric.getName() + " wasn't present in the result");
        }
        return result;
    }

    protected final DataEntry _entry;
}
