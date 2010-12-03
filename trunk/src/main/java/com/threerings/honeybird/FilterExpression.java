/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/FilterExpression.java

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

import com.google.common.collect.Sets;

/**
 * Filters a specific source using a fixed operator and restriction. These are created
 * automatically by using a function that creates a Filter on a metric or a dimension.
 */
public class FilterExpression
    implements Filter
{
    protected final Source<?> toFilter;

    protected final String operator, restriction;

    public FilterExpression (Source<?> toFilter, String operator, String restriction)
    {
        this.toFilter = toFilter;
        this.operator = operator;
        this.restriction = restriction;
    }

    public String makeFilter ()
    {
        return toFilter.getName() + operator + restriction;
    }

    public Set<Source<?>> getSources ()
    {
        Set<Source<?>> sources =  Sets.newHashSet();
        sources.add(toFilter);
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