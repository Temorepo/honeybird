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
        assertEquals(101535, results.getAggregate(BOUNCES), 0.0);
        assertEquals(136540, results.getAggregate(VISITS), 0.0);
        assertEquals(0, results.getCondfidenceInterval(BOUNCES), 0.0);
        Map<String, Long> visits = Maps.newHashMap();
        Map<String, Long> bounces = Maps.newHashMap();
        visits.put("blogger.com", 68140l);
        visits.put("google.com", 29666l);
        visits.put("stumbleupon.com", 4012l);
        visits.put("google.co.uk", 2968l);
        visits.put("google.co.in", 2793l);
        bounces.put("blogger.com", 61095l);
        bounces.put("google.com", 14979l);
        bounces.put("stumbleupon.com", 848l);
        bounces.put("google.co.uk", 2084l);
        bounces.put("google.co.in", 1891l);
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
