/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/Dimensions.java

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

public interface Dimensions
{
    /**
     * The names of browsers used by visitors to your website.  For example,  &quot;Internet
     * Explorer&quot; or &quot;Firefox.&quot;  The version of the browser is not returned in this
     * field.
     */
    public static final Dimension BROWSER = new Dimension("ga:browser");

    /**
     * The browser versions used by visitors to your site.  For example, 2.0.0.14
     */
    public static final Dimension BROWSER_VERSION = new Dimension("ga:browserVersion");

    /**
     * The cities of site visitors, derived from IP addresses.  The <code>city</code> field falls in
     * a hierarchy of geographical groupings used in Analytics, which proceeds in the following
     * order: continent, sub-continent, country, region, sub-region, and city.
     */
    public static final Dimension CITY = new Dimension("ga:city");

    /**
     * The qualitative network connection speeds of   site visitors.  For example, T1, DSL, Cable,
     * Dialup.
     */
    public static final Dimension CONNECTION_SPEED = new Dimension("ga:connectionSpeed");

    /**
     * The continents of site visitors, derived from  IP addresses.
     */
    public static final Dimension CONTINENT = new Dimension("ga:continent");

    /**
     * Number of visits to your site. This  is calculated by determining the number of visitor
     * sessions. For example, if a visitor comes to your site, exits their browser, and 5 minutes
     * later visits your site again via the same browser, that is calculated as 2 visits.
     */
    public static final Dimension COUNT_OF_VISITS = new Dimension("ga:countOfVisits");

    /**
     * The countries of site visitors, derived from  IP addresses.
     */
    public static final Dimension COUNTRY = new Dimension("ga:country");

    /**
     * The date of the visit. An integer in the form YYYYMMDD.
     */
    public static final Dimension DATE = new Dimension("ga:date");

    /**
     * The day of the month from 01 to 31.
     */
    public static final Dimension DAY = new Dimension("ga:day");

    /**
     *  The number of days elapsed since visitors last visited the site.  Used to calculate visitor
     * loyalty. For example, if you view this field in a report on 5/20, and some visitors last
     * visited your site on 5/15, the value for this would be 5, reported as &quot;5 days ago.&quot;
     */
    public static final Dimension DAYS_SINCE_LAST_VISIT = new Dimension("ga:daysSinceLastVisit");

    /**
     * The versions of Flash supported by visitors' browsers, including minor versions.
     */
    public static final Dimension FLASH_VERSION = new Dimension("ga:flashVersion");

    /**
     * The hostnames visitors used to reach your site.  In other words, if some visitors use
     * <em>www.googlestore.com</em> to reach your site,  this string appears as one of the hostnames
     * used to reach your site. However, if other visitors also come to your site via
     * <em>googlestore.com</em> or via an IP redirect from a search engine result
     * (<code>66.102.9.104</code>), those values will also be present in this field.
     */
    public static final Dimension HOSTNAME = new Dimension("ga:hostname");

    /**
     * A two digit hour of the day ranging from 00-23. (Google Analytics does not track visitor time
     * more precisely than hours.) <strong>Note</strong>: Combining this dimension with <a
     * href="#adContent">ga:adContent</a> is not currently supported.
     */
    public static final Dimension HOUR = new Dimension("ga:hour");

    /**
     * Whether the visitor has Java support enabled on their browser. The possible values are
     * <code>Yes</code> or <code>No</code>.
     */
    public static final Dimension JAVA_ENABLED = new Dimension("ga:javaEnabled");

    /**
     * This field uses the language as provided by the HTTP Request for the browser to determine the
     * primary languages used by  visitors.  Values are given as an ISO-639 code (e.g.  en-gb for
     * British English).
     */
    public static final Dimension LANGUAGE = new Dimension("ga:language");

    /**
     * The approximate latitude of the visitor's city. Locations north of the equator are
     * represented by positive values and locations south of the equator by negative values.
     */
    public static final Dimension LATITUDE = new Dimension("ga:latitude");

    /**
     * The approximate longitude of the visitor's city.   Locations east of the meridian are
     * represented by positive values and locations west of the meridian by negative values.
     */
    public static final Dimension LONGITUDE = new Dimension("ga:longitude");

    /**
     * The month of the visit. A two digit integer from 01 to 12.
     */
    public static final Dimension MONTH = new Dimension("ga:month");

    /**
     * The domain name of the ISPs used by visitors to your website.
     */
    public static final Dimension NETWORK_DOMAIN = new Dimension("ga:networkDomain");

    /**
     * The name of service providers used to reach your site.  For example, if most visitors to your
     * site come via the major service providers for cable internet, you will see the names of those
     * cable service providers in this element.
     */
    public static final Dimension NETWORK_LOCATION = new Dimension("ga:networkLocation");

    /**
     * The number of pages visited by visitors during a session (visit). The value is a histogram
     * that counts  pageviews across a range of possible values. In this calculation, all visits
     * will have at least one pageview, and some percentage of visits will have more.
     */
    public static final Dimension PAGE_DEPTH = new Dimension("ga:pageDepth");

    /**
     * The operating system used by your visitors. For example, <em>Windows</em>, <em>Linux</em>,
     * <em>Macintosh</em>, <em>iPhone</em>, <em>iPod</em>.
     */
    public static final Dimension OPERATING_SYSTEM = new Dimension("ga:operatingSystem");

    /**
     * The version of the operating system used by your visitors, such as <em>XP</em> for Windows or
     * <em>PPC</em> for Macintosh.
     */
    public static final Dimension OPERATING_SYSTEM_VERSION = new Dimension("ga:operatingSystemVersion");

    /**
     * The region of site visitors, derived from  IP addresses. In the U.S., a region is a state,
     * such as <em>New York</em>.
     */
    public static final Dimension REGION = new Dimension("ga:region");

    /**
     * The color depth of visitors' monitors, as retrieved from the DOM of the visitor's browser.
     * Values include <em>4-bit</em>, <em>8-bit</em>, <em>24-bit</em>, or <em>undefined-bit</em>.
     */
    public static final Dimension SCREEN_COLORS = new Dimension("ga:screenColors");

    /**
     * The screen resolution of visitors' monitors, as retrieved from the DOM of the visitor's
     * browser. For example: <em>1024x738</em>.
     */
    public static final Dimension SCREEN_RESOLUTION = new Dimension("ga:screenResolution");

    /**
     * The sub-continent of site visitors, derived from  IP addresses. For example,
     * <em>Polynesia</em> or <em>Northern Europe</em>.
     */
    public static final Dimension SUB_CONTINENT = new Dimension("ga:subContinent");

    /**
     * The value provided when you define custom visitor segments for your site. For more
     * information, see <a
     * href="/apis/analytics/docs/tracking/gaTrackingVisitors.html#customVisitors">Creating Custom
     * Visitor Segments</a>.
     */
    public static final Dimension USER_DEFINED_VALUE = new Dimension("ga:userDefinedValue");

    /**
     * A boolean indicating if visitors are new or returning. Possible values: <code>New
     * Visitor</code>, <code>Returning Visitor</code>.
     */
    public static final VisitorTypeDimension VISITOR_TYPE = new VisitorTypeDimension();

    /**
     * The week of the visit. A two-digit number from 01 to 52.
     */
    public static final Dimension WEEK = new Dimension("ga:week");

    /**
     * The year of the visit. A four-digit year from 2005 to the current year.
     */
    public static final Dimension YEAR = new Dimension("ga:year");

    /**
     * The first line of the text for your online Ad campaign.  If you are using mad libs for your
     * AdWords content, this field displays the keywords you provided for the mad libs keyword
     * match. <strong>Note</strong>: Combining this dimension with <a href="#hour">ga:hour</a> is
     * not currently supported.
     */
    public static final Dimension AD_CONTENT = new Dimension("ga:adContent");

    /**
     * The ad groups that you have identified for your campaign keywords.  For example, you might
     * have an ad group <em>toys</em> which you associate with the keywords <em>fuzzy bear</em>.
     */
    public static final Dimension AD_GROUP = new Dimension("ga:adGroup");

    /**
     * The position of the advertisement as it appears on the host page. For example, the online
     * advertising position might be <em>side</em> or <em>top</em>.
     */
    public static final Dimension AD_SLOT = new Dimension("ga:adSlot");

    /**
     * The  order of the online advertisement as it appears along with other ads in the position on
     * the page.  For example, the ad might appear on the right side of the page and be the 3rd ad
     * from the top.
     */
    public static final Dimension AD_SLOT_POSITION = new Dimension("ga:adSlotPosition");

    /**
     * The name(s) of the online ad campaign that you use for your website.
     */
    public static final Dimension CAMPAIGN = new Dimension("ga:campaign");

    /**
     * The keywords used by visitors to reach your site, via both paid ads and through search engine
     * results.
     */
    public static final Dimension KEYWORD = new Dimension("ga:keyword");

    /**
     * The type of referral to your website. For example,  when referring sources  to your website
     * are search engines, there are a number of possible mediums that can be used from a search
     * engine referral: from a search result (organic) and  from an online ad on the search results
     * page (CPC, ppc, cpa, CPM, cpv, cpp).
     */
    public static final Dimension MEDIUM = new Dimension("ga:medium");

    /**
     * The path of the referring URL. If someone places a link to your site on their website, this
     * element contains the path of the page that contains the referring link.
     */
    public static final Dimension REFERRAL_PATH = new Dimension("ga:referralPath");

    /**
     * The domain (e.g. <code>google.com</code>) of the source referring the visitor to your
     * website. The value for this dimension sometimes contains a port address as well.
     */
    public static final Dimension SOURCE = new Dimension("ga:source");

    /**
     * The last page of the session (or &quot;exit&quot; page) for your visitors.
     */
    public static final Dimension EXIT_PAGE_PATH = new Dimension("ga:exitPagePath");

    /**
     * The path component of the URL of the entrance or &quot;landing&quot; page for your visitors.
     */
    public static final Dimension LANDING_PAGE_PATH = new Dimension("ga:landingPagePath");

    /**
     * The page on your website by path and/or query parameters.
     */
    public static final Dimension PAGE_PATH = new Dimension("ga:pagePath");

    /**
     * The title for the page, as specified in the <code>&lt;title&gt;&lt;/title&gt;</code> element
     * of the HTML document.
     */
    public static final Dimension PAGE_TITLE = new Dimension("ga:pageTitle");

    /**
     * Typically used to designate  a supplying company or brick and mortar location; product
     * affiliation.
     */
    public static final Dimension AFFILIATION = new Dimension("ga:affiliation");

    /**
     * The number of days between users' purchases and the related campaigns that lead to the
     * purchases.
     */
    public static final Dimension DAYS_TO_TRANSACTION = new Dimension("ga:daysToTransaction");

    /**
     * Any product variations (size, color) for purchased items as supplied by your ecommerce
     * application.
     */
    public static final Dimension PRODUCT_CATEGORY = new Dimension("ga:productCategory");

    /**
     * The product name for purchased items as supplied by your ecommerce tracking method.
     */
    public static final Dimension PRODUCT_NAME = new Dimension("ga:productName");

    /**
     * The product codes for purchased items as you have defined them in your ecommerce tracking
     * application.
     */
    public static final Dimension PRODUCT_SKU = new Dimension("ga:productSku");

    /**
     *  The transaction ID for the shopping cart purchase as supplied by your ecommerce tracking
     * method.
     */
    public static final Dimension TRANSACTION_ID = new Dimension("ga:transactionId");

    /**
     * If you have categories enabled for internal site search, this field identifies the categories
     * used for the internal search.  For example, you might have product categories for internal
     * search, such as <em>electronics</em>, <em>furniture</em>, or <em>clothing</em>.
     */
    public static final Dimension SEARCH_CATEGORY = new Dimension("ga:searchCategory");

    /**
     * The page that the user visited after performing an internal site search.
     */
    public static final Dimension SEARCH_DESTINATION_PAGE = new Dimension("ga:searchDestinationPage");

    /**
     * Search terms used by site visitors on your internal site search.
     */
    public static final Dimension SEARCH_KEYWORD = new Dimension("ga:searchKeyword");

    /**
     * Subsequent keyword search terms or strings entered by users after a given initial string
     * search.
     */
    public static final Dimension SEARCH_KEYWORD_REFINEMENT = new Dimension("ga:searchKeywordRefinement");

    /**
     * The page where the user initiated an internal site search.
     */
    public static final Dimension SEARCH_START_PAGE = new Dimension("ga:searchStartPage");

    /**
     * A boolean which separates visitor activity depending upon whether internal search activity
     * occured or did not occur.       Values are <code>Visits With Site Search</code> and
     * <code>Visits Without Site Search</code>.
     */
    public static final Dimension SEARCH_USED = new Dimension("ga:searchUsed");

}
