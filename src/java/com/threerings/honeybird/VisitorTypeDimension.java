/*
 * honeybird - Fluent queries for Google Analytics
 * src/java/com/threerings/honeybird/VisitorTypeDimension.java
 *
 * Copyright 2009 Three Rings Design, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.threerings.honeybird;

import com.google.gdata.data.analytics.DataEntry;

/**
 * Distinguishes between visitors in their first visit to a site, and visitors that have been
 * there previously.
 */
public class VisitorTypeDimension
    implements Source<VisitorType>
{
    /**
     * Allows values through for visitors in their first visit to the site.
     */
    public Filter isNew ()
    {
        return new FilterExpression(this, "==", VisitorType.NEW.value);
    }

    /**
     * Allows values through for visitors that have been to the site before their current visit.
     */
    public Filter isReturning ()
    {
        return new FilterExpression(this, "==", VisitorType.RETURNING.value);
    }

    public String getName ()
    {
        return "ga:visitorType";
    }

    public VisitorType extractValue (DataEntry entry)
    {
        return VisitorType.get(entry.stringValueOf(getName()));
    }

    public boolean isDimension ()
    {
        return true;
    }
}
