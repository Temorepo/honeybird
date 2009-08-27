package com.threerings.honeybird;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueryBuilderTest
    implements Sources
{
    @Test
    public void testProperSources ()
    {
        QueryBuilder builder = new QueryBuilder(null, null).add(PAGEVIEWS);
        builder.filter(VISITOR_TYPE.isNew().and(PAGE_PATH.contains("/index.xhtml")));
        builder.fillInQuery();
        assertTrue(builder._query.getDimensions().contains(PAGE_PATH.getName()));
        assertTrue(builder._query.getMetrics().contains(PAGEVIEWS.getName()));
    }

    @Test
    public void testDefaultToToday ()
    {
        QueryBuilder builder = new QueryBuilder(null, null);
        builder.fillInQuery();
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        assertEquals(today, builder._query.getStartDate());
        assertEquals(today, builder._query.getEndDate());
    }

}
