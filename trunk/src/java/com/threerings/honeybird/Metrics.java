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

/**
* Aggregated statistics for user activity.<p>
*
* Generated from
* http://code.google.com/apis/analytics/docs/gdata/gdataReferenceDimensionsMetrics.html
*/
public interface Metrics
{
    /** The total number of single-page visits to your site. */
    public static final Metric BOUNCES = new Metric("ga:bounces");

    /**
     * The number of entrances to your site. The value will always be equal to the number of
     * visits when aggregated over your entire website. Thus, this metric is most useful when
     * combined with dimensions such as ga:landingPagePath, at which point entrances as a metric
     * indicates the number of times a particular page served as an entrance to your site.
     */
    public static final Metric ENTRANCES = new Metric("ga:entrances");

    /**
     * The number of exits from your site. As with entrances, it will always be equal to the
     * number of visits when aggregated over your entire website. Use this metric in combination
     * with content dimensions such as ga:exitPagePath in order to determine the number of times a
     * particular page was the last one viewed by visitors.
     */
    public static final Metric EXITS = new Metric("ga:exits");

    /** The number of visitors whose visit to your site was marked as a first-time visit. */
    public static final Metric NEW_VISITS = new Metric("ga:newVisits");

    /**
     * The total number of pageviews for your site when aggregated over the selected dimension.
     * For example, if you select this metric together with ga:pagePath, it will return the number
     * of page views for each URI.
     */
    public static final Metric PAGEVIEWS = new Metric("ga:pageviews");

    /**
     * How long a visitor spent on a particular page or set of pages. Calculated by subtracting
     * the initial view time for a particular page from the initial view time for a subsequent
     * page. Thus, this metric does not apply to exit pages for your site.
     */
    public static final Metric TIME_ON_PAGE = new Metric("ga:timeOnPage");

    /**
     * The total duration of visitor sessions over the selected dimension. For example, suppose
     * you combine this field with a particular ad campaign. In this case, the metric will display
     * the total duration of all visitor sessions for those visitors who came to your site via a
     * particular ad campaign. You could then compare this metric to the duration of all visitors
     * who came to your site through means other than the particular ad campaign. This would then
     * give you a side-by-side comparison and a means to calculate the boost in visit duration
     * provided by a particular campaign.
     */
    public static final Metric TIME_ON_SITE = new Metric("ga:timeOnSite");

    /**
     * Total number of visitors to your site for the requested time period. When requesting this
     * metric, you can only combine it with time dimensions such as ga:hour or ga:year.
     */
    public static final Metric VISITORS = new Metric("ga:visitors");

    /**
     * The total number of visits over the selected dimension. A visit consists of a single-user
     * session, which times out automatically after 30 minutes unless the visitor continues
     * activity on your site, or unless you have adjusted the user session in the ga.js tracking
     * for your site. See Adjusting the User Session for more information.
     */
    public static final Metric VISITS = new Metric("ga:visits");

    /** The total number of times users have clicked on an ad to reach your site. */
    public static final Metric AD_CLICKS = new Metric("ga:adClicks");

    /**
     * Derived cost for the advertising campaign. The currency for this value is based on the
     * currency that you set in your AdWords account.
     */
    public static final Metric AD_COST = new Metric("ga:adCost");

    /** Cost to advertiser per click. */
    public static final Metric CPC = new Metric("ga:CPC");

    /** Cost per thousand impressions. */
    public static final Metric CPM = new Metric("ga:CPM");

    /**
     * Click-through-rate for your ad. This is equal to the number of clicks divided by the number
     * of impressions for your ad (e.g. how many times users clicked on one of your ads where that
     * ad appeared).
     */
    public static final Metric CTR = new Metric("ga:CTR");

    /** Total number of campaign impressions. */
    public static final Metric IMPRESSIONS = new Metric("ga:impressions");

    /** The number of different (unique) pages within a visit, summed up across all visits */
    public static final Metric UNIQUE_PAGEVIEWS = new Metric("ga:uniquePageviews");

    /**
     * Total revenue from purchased product items on your site. See the tracking API reference for
     * _addItem() for additional information.
     */
    public static final Metric ITEM_REVENUE = new Metric("ga:itemRevenue");

    /**
     * The total number of items purchased. For example, if users purchase 2 frisbees and 5 tennis
     * balls, 7 items have been purchased.
     */
    public static final Metric ITEM_QUANTITY = new Metric("ga:itemQuantity");

    /**
     * The total sale revenue, including shipping and tax, if provided in the transation. See the
     * documentation for _addTrans() in the tracking API reference for additional information.
     */
    public static final Metric TRANSACTION_REVENUE = new Metric("ga:transactionRevenue");

    /** The total number of transactions. */
    public static final Metric TRANSACTIONS = new Metric("ga:transactions");

    /** The total cost of shipping. */
    public static final Metric TRANSACTION_SHIPPING = new Metric("ga:transactionShipping");

    /** The total amount of tax. */
    public static final Metric TRANSACTION_TAX = new Metric("ga:transactionTax");

    /**
     * The number of product sets purchased. For example, if users purchase 2 frisbees and 5
     * tennis balls from your site, 2 product sets have been purchased.
     */
    public static final Metric UNIQUE_PURCHASES = new Metric("ga:uniquePurchases");

    /**
     * The average number of subsequent page views made on your site after a use of your internal
     * search feature.
     */
    public static final Metric SEARCH_DEPTH = new Metric("ga:searchDepth");

    /** The visit duration to your site where a use of your internal search feature occurred. */
    public static final Metric SEARCH_DURATION = new Metric("ga:searchDuration");

    /**
     * The number of exits on your site that occurred following a search result from your internal
     * search feature.
     */
    public static final Metric SEARCH_EXITS = new Metric("ga:searchExits");

    /** The number of refinements made on an internal search. */
    public static final Metric SEARCH_REFINEMENTS = new Metric("ga:searchRefinements");

    /** The number of unique visitors to your site who used your internal search feature. */
    public static final Metric SEARCH_UNIQUES = new Metric("ga:searchUniques");

    /**
     * The total number of visits to your site where a use of your internal search feature
     * occurred.
     */
    public static final Metric SEARCH_VISITS = new Metric("ga:searchVisits");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. ga:goal1Completions).
     */
    public static final Metric GOAL1_COMPLETIONS = new Metric("ga:goal1Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. ga:goal1Completions).
     */
    public static final Metric GOAL2_COMPLETIONS = new Metric("ga:goal2Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. ga:goal1Completions).
     */
    public static final Metric GOAL3_COMPLETIONS = new Metric("ga:goal3Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. ga:goal1Completions).
     */
    public static final Metric GOAL4_COMPLETIONS = new Metric("ga:goal4Completions");

    /** The total number of completions for all goals defined for your profile. */
    public static final Metric GOAL_COMPLETIONS_ALL = new Metric("ga:goalCompletionsAll");

    /** The total number of starts for the requested goal number. */
    public static final Metric GOAL1_STARTS = new Metric("ga:goal1Starts");

    /** The total number of starts for the requested goal number. */
    public static final Metric GOAL2_STARTS = new Metric("ga:goal2Starts");

    /** The total number of starts for the requested goal number. */
    public static final Metric GOAL3_STARTS = new Metric("ga:goal3Starts");

    /** The total number of starts for the requested goal number. */
    public static final Metric GOAL4_STARTS = new Metric("ga:goal4Starts");

    /** The total number of starts for all goals defined for your profile. */
    public static final Metric GOAL_STARTS_ALL = new Metric("ga:goalStartsAll");

    /** The total numeric value for the requested goal. */
    public static final Metric GOAL1_VALUE = new Metric("ga:goal1Value");

    /** The total numeric value for the requested goal. */
    public static final Metric GOAL2_VALUE = new Metric("ga:goal2Value");

    /** The total numeric value for the requested goal. */
    public static final Metric GOAL3_VALUE = new Metric("ga:goal3Value");

    /** The total numeric value for the requested goal. */
    public static final Metric GOAL4_VALUE = new Metric("ga:goal4Value");

    /** The total value for all goals defined for your profile. */
    public static final Metric GOAL_VALUE_ALL = new Metric("ga:goalValueAll");

}
