package example;

import java.io.IOException;
import java.util.Properties;

import com.google.gdata.client.analytics.AnalyticsService;
import com.google.gdata.util.AuthenticationException;

import com.threerings.honeybird.QueryBuilder;
import com.threerings.honeybird.QueryResult;
import com.threerings.honeybird.QueryResults;
import com.threerings.honeybird.Sources;

public class HoneybirdExample
    implements Sources
{
    public static void main (String[] args)
        throws IOException, AuthenticationException
    {
        // Setup the analytics service
        AnalyticsService service = new AnalyticsService("honeybird-example");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        props.load(loader.getResourceAsStream("honeybird.properties"));
        service.setUserCredentials(props.getProperty("username"), props.getProperty("password"));
        String id = props.getProperty("profileId");

        // Execute a query
        QueryResults results = new QueryBuilder(id, service).
            filter(VISITOR_TYPE.isNew()).
            add(PAGE_PATH).
            sortDescending(PAGEVIEWS).maxResults(10).query();

        // Extract the results
        System.out.println("Total new visitor pageviews: " + results.getAggregate(PAGEVIEWS));
        for (QueryResult result : results) {
            System.out.println("Views for " + result.getValue(PAGE_PATH) + ": "
                + result.getValue(PAGEVIEWS));
        }
    }
}
