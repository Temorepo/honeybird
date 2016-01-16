Honeybird builds on the Google Analytics API to fluently express queries and process their results, all while providing compile-time checks for valid queries.  For example, this is a query using the raw Analytics API:

```
DataQuery query = new DataQuery(ANALYTICS_URL);
query.setIds(PROFILE_ID);
query.setDimensions("ga:source,ga:medium");
query.setMetrics("ga:visits,ga:bounces");
query.setSort("-ga:visits");
query.setFilters("ga:medium==referral");
query.setMaxResults(100);
query.setStartDate("2008-10-01");
query.setEndDate("2008-10-31");
```

and this constructs the same query using honeybird:

```
QueryBuilder builder = new QueryBuilder(PROFILE_ID, service).maxResults(100).
    add(SOURCE, BOUNCES).
    filter(MEDIUM.eq("referral")).
    sortDescending(VISITS).
    from(2008, Calendar.OCTOBER, 1).to(2008, Calendar.OCTOBER, 31);
```

It exposes the returned data in a similarly concise fashion.  The following code prints the total visits from the previous query using the Analytics API:

```
DataFeed feed = service.getFeed(query, DataFeed.class);
for (Metric metric : feed.getAggregates().getMetrics()) {
    if (metric.getName().equals("ga:visits")) {
        System.out.println("Total Visits: " + metric.longValue());
    }
}
```

and this does the same using honeybird:

```
System.out.println("Total Visits:" + builder.query().getAggregate(VISITS));
```

To get started, check out a [full example](http://code.google.com/p/honeybird/source/browse/trunk/example/java/example/HoneybirdExample.java), download the [GData client library](http://code.google.com/p/gdata-java-client/downloads/list), and [grab honeybird](http://honeybird.googlecode.com/files/honeybird-0.1.zip).

Honeybird was developed by [Three Rings](http://www.threerings.net) to make writing Analytics queries a little more pleasant.  It's named for the [African Honeybird](http://en.wikipedia.org/wiki/Greater_Honeyguide), a bird that leads larger animals like the Honey Badger to bee colonies, lets the larger animal break open the colony, and then enjoys the contents of the hive itself.  In a similar fashion, this project attempts to direct the brute strength of the Analytics API and then enjoy the sweet, sweet data that flows out.