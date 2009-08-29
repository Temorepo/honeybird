package com.threerings.honeybird;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.google.gdata.client.Query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueryBuilderTest
    implements Sources
{
    @Test
    public void testProperSources ()
    {
        QueryBuilder builder = new QueryBuilder(null, null).add(PAGEVIEWS);
        builder.filter(VISITOR_TYPE.isNew().and(PAGE_PATH.contains("/index.xhtml"))).startIndex(15);

        builder.fillInQuery();
        assertTrue(builder._query.getDimensions().contains(PAGE_PATH.getName()));
        assertEquals(PAGEVIEWS.getName(), builder._query.getMetrics());
        assertEquals("", builder._query.getSort());
        assertEquals(15, builder._query.getStartIndex());
    }

    @Test
    public void testSort ()
    {
        QueryBuilder builder = new QueryBuilder(null, null);
        builder.sort(PAGE_PATH, PAGEVIEWS).sort(PAGEVIEWS, PAGE_PATH); // adding it again is a noop
        builder.maxResults(7500);
        builder.fillInQuery();
        assertEquals(PAGE_PATH.getName() + "," + PAGEVIEWS.getName(), builder._query.getSort());
        assertTrue(builder._query.getDimensions().contains(PAGE_PATH.getName()));
        assertTrue(builder._query.getMetrics().contains(PAGEVIEWS.getName()));
        assertEquals(Query.UNDEFINED, builder._query.getStartIndex());
        assertEquals(7500, builder._query.getMaxResults());
    }

    @Test
    public void testSortDescending ()
    {
        QueryBuilder builder = new QueryBuilder(null, null);
        builder.sortDescending(PAGE_TITLE);
        builder.sort(VISITS);
        builder.fillInQuery();
        assertEquals("-" + PAGE_TITLE.getName() + "," + VISITS.getName(), builder._query.getSort());
    }

    @Test
    public void testSettingDates ()
    {
        QueryBuilder builder = new QueryBuilder(null, null);
        builder.fillInQuery();
        // Defaults to today
        assertEquals(formatter.format(new Date()), builder._query.getStartDate());
        assertEquals(formatter.format(new Date()), builder._query.getEndDate());
        Calendar cal = Calendar.getInstance();

        // Using on sets start and end
        cal.add(Calendar.DATE, -2);
        builder.on(cal.getTime()).fillInQuery();
        assertEquals(formatter.format(cal.getTime()), builder._query.getStartDate());
        assertEquals(formatter.format(cal.getTime()), builder._query.getEndDate());

        // Using from sets start only
        String previousEnd = builder._query.getEndDate();
        cal.add(Calendar.DATE, -2);
        builder.from(cal.getTime()).fillInQuery();
        assertEquals(formatter.format(cal.getTime()), builder._query.getStartDate());
        assertEquals(previousEnd, builder._query.getEndDate());

        // Using to sets end only
        String previousStart = builder._query.getStartDate();
        cal.add(Calendar.DATE, 1);
        builder.to(cal.getTime()).fillInQuery();
        assertEquals(previousStart, builder._query.getStartDate());
        assertEquals(formatter.format(cal.getTime()), builder._query.getEndDate());
    }

    @Test
    public void testSettingIntDates ()
    {
        QueryBuilder builder = new QueryBuilder(null, null);

        // Using on sets start and end
        builder.on(2009, Calendar.SEPTEMBER, 15).fillInQuery();
        assertEquals("2009-09-15", builder._query.getStartDate());
        assertEquals("2009-09-15", builder._query.getEndDate());

        // Using from sets start only
        builder.from(2008, Calendar.JULY, 15).fillInQuery();
        assertEquals("2008-07-15", builder._query.getStartDate());
        assertEquals("2009-09-15", builder._query.getEndDate());

        // Using to sets end only
        builder.to(2010, 1, 20).fillInQuery();
        assertEquals("2008-07-15", builder._query.getStartDate());
        assertEquals("2010-02-20", builder._query.getEndDate());
    }

    protected final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
}
