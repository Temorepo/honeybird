package com.threerings.honeybird;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetricTest
    implements Metrics, Dimensions
{
    @Test
    public void testOrWithMetric ()
    {
        assertEquals("ga:pageviews>1000,ga:pagePath=@/honey",
            PAGEVIEWS.gt(1000).or(PAGE_PATH.contains("/honey")).makeFilter());
    }

    @Test
    public void testOrNestings ()
    {
        String expected = "ga:pageviews>1000,ga:bounces<100,ga:exits>=10";
        assertEquals(expected,
            PAGEVIEWS.gt(1000).or(BOUNCES.lt(100).or(EXITS.gte(10))).makeFilter());
        assertEquals(expected,
            PAGEVIEWS.gt(1000).or(BOUNCES.lt(100)).or(EXITS.gte(10)).makeFilter());
    }
}
