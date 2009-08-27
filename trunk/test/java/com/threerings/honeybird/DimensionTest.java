package com.threerings.honeybird;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DimensionTest
    implements Sources
{
    @Test
    public void testAndWithDimension ()
    {
        assertEquals("ga:source==(direct);ga:goal1Starts<=50",
            SOURCE.eq("(direct)").and(GOAL1_STARTS.lte(50)).makeFilter());
    }
}
