/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Filters.java

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

import java.util.HashSet;
import java.util.Set;

import com.google.gdata.util.common.base.Joiner;

/**
 * Contains implementations for and and or filters. These should normally be accessed through the
 * and and or methods on {@link Filter}.
 */
public class Filters
{
    public static Filter AND (final Filter... filters)
    {
        return new BooleanFilter(filters, ";");
    }

    public static Filter OR (final Filter... filters)
    {
        return new BooleanFilter(filters, ",");
    }

    protected static final class BooleanFilter
        implements Filter
    {
        public final Filter[] filters;

        public final String joiner;

        public BooleanFilter (Filter[] filters, String joiner)
        {
            this.filters = filters;
            this.joiner = joiner;
        }

        public String makeFilter ()
        {
            String[] pieces = new String[filters.length];
            for (int ii = 0; ii < pieces.length; ii++) {
                pieces[ii] = filters[ii].makeFilter();
            }
            return Joiner.on(joiner).join(pieces);
        }

        public Set<Source<?>> getSources ()
        {
            Set<Source<?>> sources = new HashSet<Source<?>>();
            for (Filter filter : filters) {
                sources.addAll(filter.getSources());
            }
            return sources;
        }

        public Filter and (Filter additional)
        {
            return Filters.AND(this, additional);
        }

        public Filter or (Filter additional)
        {
            return Filters.OR(this, additional);
        }
    }
}
