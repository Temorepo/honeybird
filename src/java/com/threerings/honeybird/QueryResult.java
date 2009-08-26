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


public class QueryResult
{
    public QueryResult (DataEntry next)
    {
        _entry = next;
    }

    public <V> V getValue (Source<V> metric) {
        return metric.extractValue(_entry);
    }

    protected final DataEntry _entry;
}
