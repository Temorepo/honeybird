/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Filter.java

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

import java.util.Set;

/**
 * Restricts the results from a query.
 */
public interface Filter
{
    /**
     * Returns the representation of this filter for inclusion in the query.
     */
    String makeFilter ();

    /**
     * Returns the sources that this filter restricts.
     */
    Set<Source<?>> getSources ();

    /**
     * Combines this filter with the given filter and restricts results such that both must accept
     * an item to include it. This has a lower precedence than {@link #or} if an or is also
     * included in a filter.
     */
    Filter and(Filter additional);

    /**
     * Combines this filter with the given filter and allows an item through if either accepts it.
     * This has a higher precedence than {@link #and} if an and is also included in a filter.
     */
    Filter or (Filter additional);
}