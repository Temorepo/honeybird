/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Dimension.java

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
 * Represents a dimension that can be represented as a String.
 */
public class Dimension extends FilterSource<String>
{
    public Dimension (String name)
    {
        super(name);
    }

    public boolean isDimension ()
    {
        return true;
    }

    public String extractValue (DataEntry entry)
    {
        return entry.stringValueOf(getName());
    }

    /**
     * Allows only dimensions that match the given regular expression in the query's results.
     */
    public Filter matches (String value)
    {
        return expr("=~", value);
    }

    /**
     * Allows only dimensions that don't match the given regular expression in the query's results.
     */
    public Filter nmatches (String value)
    {
        return expr("!~", value);
    }

    /**
     * Allows only dimensions that contain the given String in the query's results.
     */
    public Filter contains (String value)
    {
        return expr("=@", value);
    }

    /**
     * Allows only dimensions that don't contain the given String in the query's results.
     */
    public Filter ncontains (String value)
    {
        return expr("!@", value);
    }
}
