/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Metrics.java

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

public interface Metrics
{
    /**
     * The total number of single-page visits to your site.
     */
    public static final LongMetric BOUNCES = new LongMetric("ga:bounces");

    /**
     * The number of entrances to your site. The value will always be equal to the number of visits
     * when aggregated over your entire website. Thus, this metric is most useful when combined with
     * dimensions such as <code>ga:landingPagePath</code>, at which point entrances as a metric
     * indicates the number of times a particular page served as an entrance to your site.
     */
    public static final LongMetric ENTRANCES = new LongMetric("ga:entrances");

    /**
     * The number of exits from your site. As with entrances, it will always be equal to the number
     * of visits when aggregated over your entire website. Use this metric in combination with
     * content dimensions such as <code>ga:exitPagePath</code> in order to determine the number of
     * times a particular page was the last one viewed by visitors.
     */
    public static final LongMetric EXITS = new LongMetric("ga:exits");

    /**
     * The number of visitors whose visit to your site was marked as a first-time visit.
     */
    public static final LongMetric NEW_VISITS = new LongMetric("ga:newVisits");

    /**
     * The total number of pageviews for your site when aggregated over the selected dimension. For
     * example, if you select this metric together with <code>ga:pagePath</code>, it will return the
     * number of page views for each URI.
     */
    public static final LongMetric PAGEVIEWS = new LongMetric("ga:pageviews");

    /**
     * How long a visitor spent on a particular page or set of pages. Calculated by subtracting the
     * initial view time for a particular page from the initial view time for a subsequent page.
     * Thus, this metric does not apply to exit pages for your site. The value from this metric is
     * returned in the XML as a string, with the value represented in total seconds. Different
     * client libraries have various ways of representing this value, such as a double, float, long,
     * or string.
     */
    public static final SecondsMetric TIME_ON_PAGE = new SecondsMetric("ga:timeOnPage");

    /**
     * The total duration of visitor sessions over the selected dimension. For example, suppose you
     * combine this field with a particular ad campaign. In this case, the metric will display the
     * total duration of all visitor sessions for those visitors who came to your site via a
     * particular ad campaign. You could then compare this metric to the duration of all visitors
     * who came to your site through means other than the particular ad campaign. This would then
     * give you a side-by-side comparison and a means to calculate the boost in visit duration
     * provided by a particular campaign. The value from this metric is returned in the XML as a
     * string, with the value represented in total seconds. Different client libraries have various
     * ways of representing this value, such as a double, float, long, or string.
     */
    public static final SecondsMetric TIME_ON_SITE = new SecondsMetric("ga:timeOnSite");

    /**
     * Total number of visitors to your site for the requested time period. When requesting this
     * metric, you can only combine it with time dimensions such as <code>ga:hour</code> or
     * <code>ga:year</code>.
     */
    public static final LongMetric VISITORS = new LongMetric("ga:visitors");

    /**
     * The total number of visits over the selected dimension. A visit consists of a single-user
     * session, which times out automatically after 30 minutes unless the visitor continues activity
     * on your site, or unless you have adjusted the user session in the <code>ga.js</code> tracking
     * for your site. See <a
     * href="http://code.google.com/apis/analytics/docs/tracking/gaTrackingVisitors.html#userSession">Adjusting
     * the User Session</a> for more information.
     */
    public static final LongMetric VISITS = new LongMetric("ga:visits");

    /**
     * The total number of times users have clicked on an ad to reach your site.
     */
    public static final LongMetric AD_CLICKS = new LongMetric("ga:adClicks");

    /**
     * Derived cost for the advertising campaign. The currency for this value is based on the
     * currency that you set in your AdWords account.
     */
    public static final CurrencyMetric AD_COST = new CurrencyMetric("ga:adCost");

    /**
     * Cost to advertiser per click.
     */
    public static final CurrencyMetric CPC = new CurrencyMetric("ga:CPC");

    /**
     * Cost per thousand impressions.
     */
    public static final CurrencyMetric CPM = new CurrencyMetric("ga:CPM");

    /**
     * Click-through-rate for your ad. This is equal to the number of clicks divided by the number
     * of impressions for your ad (e.g. how many times users clicked on one of your ads where that
     * ad appeared).
     */
    public static final PercentageMetric CTR = new PercentageMetric("ga:CTR");

    /**
     * Total number of campaign impressions.
     */
    public static final LongMetric IMPRESSIONS = new LongMetric("ga:impressions");

    /**
     * The number of different (unique) pages within a visit, summed up across all visits
     */
    public static final LongMetric UNIQUE_PAGEVIEWS = new LongMetric("ga:uniquePageviews");

    /**
     * Total revenue from purchased product items on your site. See the tracking API reference for
     * <a
     * href="http://code.google.com/apis/analytics/docs/gaJS/gaJSApiEcommerce.html"><code>_addItem()</code></a>
     * for additional information.
     */
    public static final CurrencyMetric ITEM_REVENUE = new CurrencyMetric("ga:itemRevenue");

    /**
     * The total number of items purchased. For example, if users purchase 2 frisbees and 5 tennis
     * balls, 7 items have been purchased.
     */
    public static final LongMetric ITEM_QUANTITY = new LongMetric("ga:itemQuantity");

    /**
     * The total sale revenue, including shipping and tax, if provided in the transation. See the
     * documentation for <a
     * href="http://code.google.com/apis/analytics/docs/gaJS/gaJSApiEcommerce.html#_gat.GA_Tracker_._addTrans"><code>_addTrans()</code></a>
     * in the tracking API reference for additional information.
     */
    public static final CurrencyMetric TRANSACTION_REVENUE = new CurrencyMetric("ga:transactionRevenue");

    /**
     * The total number of transactions.
     */
    public static final LongMetric TRANSACTIONS = new LongMetric("ga:transactions");

    /**
     * The total cost of shipping.
     */
    public static final CurrencyMetric TRANSACTION_SHIPPING = new CurrencyMetric("ga:transactionShipping");

    /**
     * The total amount of tax.
     */
    public static final CurrencyMetric TRANSACTION_TAX = new CurrencyMetric("ga:transactionTax");

    /**
     * The number of product sets purchased. For example, if users purchase 2 frisbees and 5 tennis
     * balls from your site, 2 product sets have been purchased.
     */
    public static final LongMetric UNIQUE_PURCHASES = new LongMetric("ga:uniquePurchases");

    /**
     * The average number of subsequent page views made on your site after a use of your internal
     * search feature.
     */
    public static final LongMetric SEARCH_DEPTH = new LongMetric("ga:searchDepth");

    /**
     * The visit duration to your site where a use of your internal search feature occurred.
     */
    public static final SecondsMetric SEARCH_DURATION = new SecondsMetric("ga:searchDuration");

    /**
     * The number of exits on your site that occurred following a search result from your internal
     * search feature.
     */
    public static final LongMetric SEARCH_EXITS = new LongMetric("ga:searchExits");

    /**
     * The number of refinements made on an internal search.
     */
    public static final LongMetric SEARCH_REFINEMENTS = new LongMetric("ga:searchRefinements");

    /**
     * The number of unique visitors to your site who used your internal search feature.
     */
    public static final LongMetric SEARCH_UNIQUES = new LongMetric("ga:searchUniques");

    /**
     * The total number of visits to your site where a use of your internal search feature occurred.
     */
    public static final LongMetric SEARCH_VISITS = new LongMetric("ga:searchVisits");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final LongMetric GOAL1_COMPLETIONS = new LongMetric("ga:goal1Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final LongMetric GOAL2_COMPLETIONS = new LongMetric("ga:goal2Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final LongMetric GOAL3_COMPLETIONS = new LongMetric("ga:goal3Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final LongMetric GOAL4_COMPLETIONS = new LongMetric("ga:goal4Completions");

    /**
     * The total number of completions for all goals defined for your profile.
     */
    public static final LongMetric GOAL_COMPLETIONS_ALL = new LongMetric("ga:goalCompletionsAll");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final LongMetric GOAL1_STARTS = new LongMetric("ga:goal1Starts");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final LongMetric GOAL2_STARTS = new LongMetric("ga:goal2Starts");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final LongMetric GOAL3_STARTS = new LongMetric("ga:goal3Starts");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final LongMetric GOAL4_STARTS = new LongMetric("ga:goal4Starts");

    /**
     * The total number of starts for all goals defined for your profile.
     */
    public static final LongMetric GOAL_STARTS_ALL = new LongMetric("ga:goalStartsAll");

    /**
     * The total numeric value for the requested goal.
     */
    public static final CurrencyMetric GOAL1_VALUE = new CurrencyMetric("ga:goal1Value");

    /**
     * The total numeric value for the requested goal.
     */
    public static final CurrencyMetric GOAL2_VALUE = new CurrencyMetric("ga:goal2Value");

    /**
     * The total numeric value for the requested goal.
     */
    public static final CurrencyMetric GOAL3_VALUE = new CurrencyMetric("ga:goal3Value");

    /**
     * The total numeric value for the requested goal.
     */
    public static final CurrencyMetric GOAL4_VALUE = new CurrencyMetric("ga:goal4Value");

    /**
     * The total value for all goals defined for your profile.
     */
    public static final CurrencyMetric GOAL_VALUE_ALL = new CurrencyMetric("ga:goalValueAll");

    /**
     * The total number of events recorded for your profile.
     */
    public static final LongMetric TOTAL_EVENTS = new LongMetric("ga:totalEvents");

    /**
     * The total number of unique events recorded for your profile.
     */
    public static final LongMetric UNIQUE_EVENTS = new LongMetric("ga:uniqueEvents");

    /**
     * The total value of events recorded for your profile.
     */
    public static final LongMetric EVENT_VALUE = new LongMetric("ga:eventValue");
}
