/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Metric.java

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

/**
 * Base class for metrics.
 */
public abstract class Metric<T> extends FilterSource<T>
{
    protected Metric (String name)
    {
        super(name);
    }

    /**
     * Allows through any value greater than the given value.
     */
    public Filter gt (T value)
    {
        return expr(">", value);
    }

    /**
     * Allows through any value less than the given value.
     */
    public Filter lt (T value)
    {
        return expr("<", value);
    }

    /**
     * Allows through any value greater than or equal to the given value.
     */
    public Filter gte (T value)
    {
        return expr(">=", value);
    }

    /**
     * Allows through any value less than or equal to the given value.
     */
    public Filter lte (T value)
    {
        return expr("<=", value);
    }

    public boolean isDimension ()
    {
        return false;
    }

    /**
     * Returns the aggregate value for this metric's result type from the given metric.
     */
    public abstract T extractValue (com.google.gdata.data.analytics.Metric aggMetric);
}
