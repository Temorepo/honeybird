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

public class Source
{
    protected Source (String name)
    {
        _name = name;
    }

    public Filter eq (String value)
    {
        return expr("==", value);
    }

    public Filter neq (String value)
    {
        return expr("!=", value);
    }

    protected FilterExpression expr (String op, String value)
    {
        return new FilterExpression(this, op, value);
    }

    @Override
    public boolean equals (Object other)
    {
        if (other == this) {
            return true;
        }
        if (other instanceof Source) {
            return ((Source)other)._name.equals(_name);
        }
        return false;
    }

    @Override
    public int hashCode ()
    {
        return _name.hashCode();
    }

    protected final String _name;
}
