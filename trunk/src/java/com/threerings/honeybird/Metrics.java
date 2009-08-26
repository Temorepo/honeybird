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
    public static final Metric<Integer> BOUNCES = new Metric<Integer>("ga:bounces");

    /**
     * The number of entrances to your site.  The value will always be equal to the number of visits
     * when aggregated over your entire website.  Thus, this metric is most useful when combined
     * with dimensions such as <code>ga:landingPagePath</code>, at which point entrances as a metric
     * indicates the number of times a particular page served as an entrance to your site.
     */
    public static final Metric<Integer> ENTRANCES = new Metric<Integer>("ga:entrances");

    /**
     * The number of exits from your site. As with entrances, it will always be equal to the number
     * of visits when aggregated over your entire website.  Use this metric in combination with
     * content dimensions such as <code>ga:exitPagePath</code> in order to determine the number of
     * times  a particular page was the last one viewed by visitors.
     */
    public static final Metric<Integer> EXITS = new Metric<Integer>("ga:exits");

    /**
     * The number of visitors whose visit to your site was marked as a first-time visit.
     */
    public static final Metric<Integer> NEW_VISITS = new Metric<Integer>("ga:newVisits");

    /**
     * The total  number of pageviews for your site when aggregated over the selected dimension.
     * For example, if you select this metric together with <code>ga:pagePath</code>, it will return
     * the number of page views for each  URI.
     */
    public static final Metric<Integer> PAGEVIEWS = new Metric<Integer>("ga:pageviews");

    /**
     * How long a visitor spent on a particular page or set of pages.  Calculated by subtracting the
     * initial view time for a particular page from the initial view time for a subsequent page.
     * Thus, this metric does not apply to exit pages for your site.
     */
    public static final Metric<Integer> TIME_ON_PAGE = new Metric<Integer>("ga:timeOnPage");

    /**
     * The total duration of visitor sessions over the selected dimension.  For example, suppose you
     * combine this field with a particular ad campaign.  In this case, the metric will display the
     * total duration of all visitor sessions for those visitors who came to your site via a
     * particular ad campaign.  You could then compare this metric to the duration of all visitors
     * who came to your site through means other than the particular ad campaign.  This would then
     * give you a side-by-side comparison and a means to calculate the boost in visit duration
     * provided by a particular campaign.
     */
    public static final Metric<Integer> TIME_ON_SITE = new Metric<Integer>("ga:timeOnSite");

    /**
     * Total number of visitors to your site for the requested time period. When requesting this
     * metric, you can only combine it with time dimensions such as <code>ga:hour</code> or
     * <code>ga:year</code>.
     */
    public static final Metric<Integer> VISITORS = new Metric<Integer>("ga:visitors");

    /**
     * The total number of visits over the selected dimension. A visit consists of a single-user
     * session, which times out automatically after 30 minutes unless the visitor continues activity
     * on your site, or unless you have adjusted the user session in the <code>ga.js</code> tracking
     * for your site. See <a
     * href="/apis/analytics/docs/tracking/gaTrackingVisitors.html#userSession">Adjusting the User
     * Session</a> for more information.
     */
    public static final Metric<Integer> VISITS = new Metric<Integer>("ga:visits");

    /**
     * The total number of times users have clicked on an ad to reach your site.
     */
    public static final Metric<Integer> AD_CLICKS = new Metric<Integer>("ga:adClicks");

    /**
     * Derived cost for the advertising campaign. The currency for this value is based on the
     * currency that you set in your AdWords account.
     */
    public static final Metric<Void> AD_COST = new Metric<Void>("ga:adCost");

    /**
     * Cost to advertiser per click.
     */
    public static final Metric<Void> _C_P_C = new Metric<Void>("ga:CPC");

    /**
     * Cost per thousand impressions.
     */
    public static final Metric<Void> _C_P_M = new Metric<Void>("ga:CPM");

    /**
     * Click-through-rate for your ad. This is equal to the number of clicks divided by the number
     * of impressions for your ad (e.g. how many times users clicked on one of your ads where that
     * ad appeared).
     */
    public static final Metric<Void> _C_T_R = new Metric<Void>("ga:CTR");

    /**
     * Total number of campaign impressions.
     */
    public static final Metric<Integer> IMPRESSIONS = new Metric<Integer>("ga:impressions");

    /**
     * The number of different (unique) pages within a visit,  summed up across all visits
     */
    public static final Metric<Integer> UNIQUE_PAGEVIEWS = new Metric<Integer>("ga:uniquePageviews");

    /**
     * Total revenue from purchased product items on your site. See the tracking API reference for
     * <a href="/apis/analytics/docs/gaJS/gaJSApiEcommerce.html"><code>_addItem()</code></a> for
     * additional information.
     */
    public static final Metric<Void> ITEM_REVENUE = new Metric<Void>("ga:itemRevenue");

    /**
     * The total number of items purchased.  For example, if  users purchase 2 frisbees and 5 tennis
     * balls, 7 items have been purchased.
     */
    public static final Metric<Integer> ITEM_QUANTITY = new Metric<Integer>("ga:itemQuantity");

    /**
     * The total sale revenue, including shipping and tax, if provided in the transation. See the
     * documentation for <a
     * href="/apis/analytics/docs/gaJS/gaJSApiEcommerce.html#_gat.GA_Tracker_._addTrans"><code>_addTrans()</code></a>
     * in the tracking API reference for additional information.
     */
    public static final Metric<Void> TRANSACTION_REVENUE = new Metric<Void>("ga:transactionRevenue");

    /**
     * The total number of transactions.
     */
    public static final Metric<Integer> TRANSACTIONS = new Metric<Integer>("ga:transactions");

    /**
     * The total cost of shipping.
     */
    public static final Metric<Void> TRANSACTION_SHIPPING = new Metric<Void>("ga:transactionShipping");

    /**
     * The total amount of tax.
     */
    public static final Metric<Void> TRANSACTION_TAX = new Metric<Void>("ga:transactionTax");

    /**
     * The number of product sets purchased.  For example, if  users purchase 2 frisbees and 5
     * tennis balls from your site,  2 product sets have been purchased.
     */
    public static final Metric<Integer> UNIQUE_PURCHASES = new Metric<Integer>("ga:uniquePurchases");

    /**
     * The average number of subsequent page views made on your site after a use of your internal
     * search feature.
     */
    public static final Metric<Integer> SEARCH_DEPTH = new Metric<Integer>("ga:searchDepth");

    /**
     * The visit duration to your site where a use of your internal search feature occurred.
     */
    public static final Metric<Integer> SEARCH_DURATION = new Metric<Integer>("ga:searchDuration");

    /**
     * The number of exits on your site that occurred following a search result from your internal
     * search feature.
     */
    public static final Metric<Integer> SEARCH_EXITS = new Metric<Integer>("ga:searchExits");

    /**
     * The number of refinements made on an internal search.
     */
    public static final Metric<Integer> SEARCH_REFINEMENTS = new Metric<Integer>("ga:searchRefinements");

    /**
     * The number of unique visitors to your site who used your internal search feature.
     */
    public static final Metric<Integer> SEARCH_UNIQUES = new Metric<Integer>("ga:searchUniques");

    /**
     * The total number of visits to your site where a use of your internal search feature occurred.
     */
    public static final Metric<Integer> SEARCH_VISITS = new Metric<Integer>("ga:searchVisits");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final Metric<Integer> GOAL1_COMPLETIONS = new Metric<Integer>("ga:goal1Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final Metric<Integer> GOAL2_COMPLETIONS = new Metric<Integer>("ga:goal2Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final Metric<Integer> GOAL3_COMPLETIONS = new Metric<Integer>("ga:goal3Completions");

    /**
     * The total number of completions for the specific goal. You can request completions for
     * individual goals by number (e.g. <code>ga:goal1Completions</code>).
     */
    public static final Metric<Integer> GOAL4_COMPLETIONS = new Metric<Integer>("ga:goal4Completions");

    /**
     * The total number of completions for all goals defined for your profile.
     */
    public static final Metric<Integer> GOAL_COMPLETIONS_ALL = new Metric<Integer>("ga:goalCompletionsAll");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final Metric<Integer> GOAL1_STARTS = new Metric<Integer>("ga:goal1Starts");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final Metric<Integer> GOAL2_STARTS = new Metric<Integer>("ga:goal2Starts");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final Metric<Integer> GOAL3_STARTS = new Metric<Integer>("ga:goal3Starts");

    /**
     * The total number of starts for the requested goal number.
     */
    public static final Metric<Integer> GOAL4_STARTS = new Metric<Integer>("ga:goal4Starts");

    /**
     * The total number of starts for all goals defined for your profile.
     */
    public static final Metric<Integer> GOAL_STARTS_ALL = new Metric<Integer>("ga:goalStartsAll");

    /**
     * The total numeric value for the requested goal.
     */
    public static final Metric<Integer> GOAL1_VALUE = new Metric<Integer>("ga:goal1Value");

    /**
     * The total numeric value for the requested goal.
     */
    public static final Metric<Integer> GOAL2_VALUE = new Metric<Integer>("ga:goal2Value");

    /**
     * The total numeric value for the requested goal.
     */
    public static final Metric<Integer> GOAL3_VALUE = new Metric<Integer>("ga:goal3Value");

    /**
     * The total numeric value for the requested goal.
     */
    public static final Metric<Integer> GOAL4_VALUE = new Metric<Integer>("ga:goal4Value");

    /**
     * The total value for all goals defined for your profile.
     */
    public static final Metric<Integer> GOAL_VALUE_ALL = new Metric<Integer>("ga:goalValueAll");

}
