/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Source.java

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
 * A basic data source from the analytics API.
 *
 * @param <V> - the type of value for this source.
 */
public interface Source<V>
{
    /**
     * Returns the name for this source as used in queries eg <code>ga:pagePath</code>.
     */
    String getName();

    /**
     * Returns the value of this source contained in the given entry or null if it isn't present.
     */
    V extractValue(DataEntry entry);

    /**
     * Returns true if this source is a dimension, false if it's a metric.
     */
    boolean isDimension();
}
