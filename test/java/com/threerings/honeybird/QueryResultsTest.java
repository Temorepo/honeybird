package com.threerings.honeybird;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.google.gdata.client.analytics.AnalyticsService;
import com.google.gdata.data.ParseSource;
import com.google.gdata.data.analytics.DataFeed;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.Charsets;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.AltRegistry;
import com.google.gdata.wireformats.input.InputParser;
import com.google.gdata.wireformats.input.InputProperties;
import com.google.gdata.wireformats.input.InputPropertiesBuilder;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;

public class QueryResultsTest implements Sources
{
    @Test
    public void testExposingResults() throws IOException, ServiceException {

        AnalyticsService as = new AnalyticsService("honeybird-test");
        AltRegistry reg = as.getAltRegistry();
        // This is going to be a DataFeed as that's what AnalyticsService is for
        @SuppressWarnings("unchecked")
        InputParser<DataFeed> parser = (InputParser<DataFeed>)reg.getParser(AltFormat.ATOM);
        InputProperties props =
            new InputPropertiesBuilder().setExtensionProfile(as.getExtensionProfile()).build();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream is = loader.getResourceAsStream("com/threerings/honeybird/sample_feed.xml");
        DataFeed parsed = parser.parse(new ParseSource(new InputStreamReader(is, Charsets.UTF_8)),
            props, DataFeed.class);
        QueryResults results = new QueryResults(parsed);
        assertEquals(101535, results.getAggregate(BOUNCES));
        assertEquals(136540, results.getAggregate(VISITS));
        assertEquals(0, results.getCondfidenceInterval(BOUNCES));
        Map<String, Integer> visits = Maps.newHashMap();
        Map<String, Integer> bounces = Maps.newHashMap();
        visits.put("blogger.com", 68140);
        visits.put("google.com", 29666);
        visits.put("stumbleupon.com", 4012);
        visits.put("google.co.uk", 2968);
        visits.put("google.co.in", 2793);
        bounces.put("blogger.com", 61095);
        bounces.put("google.com", 14979);
        bounces.put("stumbleupon.com", 848);
        bounces.put("google.co.uk", 2084);
        bounces.put("google.co.in", 1891);
        for (QueryResult result : results) {
            assertEquals("referral", result.getValue(MEDIUM));
            assertEquals(visits.remove(result.getValue(SOURCE)), result.getValue(VISITS));
            assertEquals(bounces.remove(result.getValue(SOURCE)), result.getValue(BOUNCES));
        }

        // Ensure that all of the expected values were checked
        assertTrue(visits.isEmpty());
        assertTrue(bounces.isEmpty());
    }

}
