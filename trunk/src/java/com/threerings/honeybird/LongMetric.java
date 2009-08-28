/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/LongMetric.java

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
 * A metric that operates on long values.
 */
public class LongMetric extends Metric<Long>
{
    protected LongMetric (String name)
    {
        super(name);
    }

    /**
     * Allows through any value greater than the given value.
     */
    public Filter gt (int value)
    {
        return gt((long)value);
    }

    /**
     * Allows through any value less than the given value.
     */
    public Filter lt (int value)
    {
        return lt((long)value);
    }

    /**
     * Allows through any value greater than or equal to the given value.
     */
    public Filter gte (int value)
    {
        return gte((long)value);
    }

    /**
     * Allows through any value less than or equal to the given value.
     */
    public Filter lte (int value)
    {
        return lte((long)value);
    }

    /**
     * Allows through any value equal to the given value.
     */
    public Filter eq (int value)
    {
        return eq((long)value);
    }

    /**
     * Allows through any value not equal to the given value.
     */
    public Filter neq (int value)
    {
        return neq((long)value);
    }

    @Override
    public Long extractValue (com.google.gdata.data.analytics.Metric aggMetric)
    {
        return aggMetric.longValue();
    }

    public Long extractValue (DataEntry entry)
    {
        return entry.longValueOf(getName());
    }
}
