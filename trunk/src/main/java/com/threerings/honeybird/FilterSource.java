/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/FilterSource.java

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
 * Base class for sources that support eq and neq ie dimensions on String and metrics on double or
 * long.
 */
public abstract class FilterSource<T>
    implements Source<T>
{
    protected FilterSource (String name)
    {
        _name = name;
    }

    /**
     * Allows only values through that are exactly the given value.
     */
    public Filter eq (T value)
    {
        return expr("==", value);
    }

    /**
     *  Allows any value through that isn't the given value.
     */
    public Filter neq (T value)
    {
        return expr("!=", value);
    }

    public String getName ()
    {
        return _name;
    }

    /**
     * Returns a FilterExpression for this source's name using the given operation on the given
     * value.  The value is converted for use in the expression by calling toString on it.
     */
    protected FilterExpression expr (String op, T value)
    {
        return new FilterExpression(this, op, value.toString());
    }

    protected final String _name;
}
