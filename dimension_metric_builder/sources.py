sources = {u'Dimension': [(u'ga:browser',
                 'The names of browsers used by visitors to your website.  For example,  &quot;Internet Explorer&quot; or &quot;Firefox.&quot;  The version of the browser is not returned in this field. '),
                (u'ga:browserVersion',
                 'The browser versions used by visitors to your site.  For example, 2.0.0.14 '),
                (u'ga:city',
                 'The cities of site visitors, derived from IP addresses.  The <code>city</code> field falls in a hierarchy of geographical groupings used in Analytics, which proceeds in the following order: continent, sub-continent, country, region, sub-region, and city. '),
                (u'ga:connectionSpeed',
                 'The qualitative network connection speeds of   site visitors.  For example, T1, DSL, Cable, Dialup. '),
                (u'ga:continent',
                 'The continents of site visitors, derived from  IP addresses. '),
                (u'ga:countOfVisits',
                 'Number of visits to your site. This  is calculated by determining the number of visitor sessions. For example, if a visitor comes to your site, exits their browser, and 5 minutes later visits your site again via the same browser, that is calculated as 2 visits.'),
                (u'ga:country',
                 'The countries of site visitors, derived from  IP addresses. '),
                (u'ga:date',
                 'The date of the visit. An integer in the form YYYYMMDD. '),
                (u'ga:day', 'The day of the month from 01 to 31.'),
                (u'ga:daysSinceLastVisit',
                 ' The number of days elapsed since visitors last visited the site.  Used to calculate visitor loyalty. For example, if you view this field in a report on 5/20, and some visitors last visited your site on 5/15, the value for this would be 5, reported as &quot;5 days ago.&quot;'),
                (u'ga:flashVersion',
                 "The versions of Flash supported by visitors' browsers, including minor versions. "),
                (u'ga:hostname',
                 'The hostnames visitors used to reach your site.  In other words, if some visitors use <em>www.googlestore.com</em> to reach your site,  this string appears as one of the hostnames used to reach your site. However, if other visitors also come to your site via <em>googlestore.com</em> or via an IP redirect from a search engine result (<code>66.102.9.104</code>), those values will also be present in this field. '),
                (u'ga:hour',
                 'A two digit hour of the day ranging from 00-23. (Google Analytics does not track visitor time more precisely than hours.) <strong>Note</strong>: Combining this dimension with <a href="#adContent">ga:adContent</a> is not currently supported.'),
                (u'ga:javaEnabled',
                 'Whether the visitor has Java support enabled on their browser. The possible values are <code>Yes</code> or <code>No</code>.'),
                (u'ga:language',
                 'This field uses the language as provided by the HTTP Request for the browser to determine the primary languages used by  visitors.  Values are given as an ISO-639 code (e.g.  en-gb for British English). '),
                (u'ga:latitude',
                 "The approximate latitude of the visitor's city. Locations north of the equator are represented by positive values and locations south of the equator by negative values."),
                (u'ga:longitude',
                 "The approximate longitude of the visitor's city.   Locations east of the meridian are represented by positive values and locations west of the meridian by negative values."),
                (u'ga:month',
                 'The month of the visit. A two digit integer from 01 to 12. '),
                (u'ga:networkDomain',
                 'The domain name of the ISPs used by visitors to your website. '),
                (u'ga:networkLocation',
                 'The name of service providers used to reach your site.  For example, if most visitors to your site come via the major service providers for cable internet, you will see the names of those cable service providers in this element. '),
                (u'ga:pageDepth',
                 'The number of pages visited by visitors during a session (visit). The value is a histogram that counts  pageviews across a range of possible values. In this calculation, all visits will have at least one pageview, and some percentage of visits will have more. '),
                (u'ga:operatingSystem',
                 'The operating system used by your visitors. For example, <em>Windows</em>, <em>Linux</em>, <em>Macintosh</em>, <em>iPhone</em>, <em>iPod</em>. '),
                (u'ga:operatingSystemVersion',
                 'The version of the operating system used by your visitors, such as <em>XP</em> for Windows or <em>PPC</em> for Macintosh. '),
                (u'ga:region',
                 'The region of site visitors, derived from  IP addresses. In the U.S., a region is a state, such as <em>New York</em>.'),
                (u'ga:screenColors',
                 "The color depth of visitors' monitors, as retrieved from the DOM of the visitor's browser. Values include <em>4-bit</em>, <em>8-bit</em>, <em>24-bit</em>, or <em>undefined-bit</em>."),
                (u'ga:screenResolution',
                 "The screen resolution of visitors' monitors, as retrieved from the DOM of the visitor's browser. For example: <em>1024x738</em>."),
                (u'ga:subContinent',
                 'The sub-continent of site visitors, derived from  IP addresses. For example, <em>Polynesia</em> or <em>Northern Europe</em>.'),
                (u'ga:userDefinedValue',
                 'The value provided when you define custom visitor segments for your site. For more information, see <a href="/apis/analytics/docs/tracking/gaTrackingVisitors.html#customVisitors">Creating Custom Visitor Segments</a>.'),
                (u'ga:visitorType',
                 'A boolean indicating if visitors are new or returning. Possible values: <code>New Visitor</code>, <code>Returning Visitor</code>.'),
                (u'ga:week',
                 'The week of the visit. A two-digit number from 01 to 52. '),
                (u'ga:year',
                 'The year of the visit. A four-digit year from 2005 to the current year. '),
                (u'ga:adContent',
                 'The first line of the text for your online Ad campaign.  If you are using mad libs for your AdWords content, this field displays the keywords you provided for the mad libs keyword match. <strong>Note</strong>: Combining this dimension with <a href="#hour">ga:hour</a> is not currently supported.'),
                (u'ga:adGroup',
                 'The ad groups that you have identified for your campaign keywords.  For example, you might have an ad group <em>toys</em> which you associate with the keywords <em>fuzzy bear</em>. '),
                (u'ga:adSlot',
                 'The position of the advertisement as it appears on the host page. For example, the online advertising position might be <em>side</em> or <em>top</em>.'),
                (u'ga:adSlotPosition',
                 'The  order of the online advertisement as it appears along with other ads in the position on the page.  For example, the ad might appear on the right side of the page and be the 3rd ad from the top.'),
                (u'ga:campaign',
                 'The name(s) of the online ad campaign that you use for your website.'),
                (u'ga:keyword',
                 'The keywords used by visitors to reach your site, via both paid ads and through search engine results.'),
                (u'ga:medium',
                 'The type of referral to your website. For example,  when referring sources  to your website are search engines, there are a number of possible mediums that can be used from a search engine referral: from a search result (organic) and  from an online ad on the search results page (CPC, ppc, cpa, CPM, cpv, cpp). '),
                (u'ga:referralPath',
                 'The path of the referring URL. If someone places a link to your site on their website, this element contains the path of the page that contains the referring link. '),
                (u'ga:source',
                 'The domain (e.g. <code>google.com</code>) of the source referring the visitor to your website. The value for this dimension sometimes contains a port address as well.'),
                (u'ga:exitPagePath',
                 'The last page of the session (or &quot;exit&quot; page) for your visitors. '),
                (u'ga:landingPagePath',
                 'The path component of the URL of the entrance or &quot;landing&quot; page for your visitors. '),
                (u'ga:pagePath',
                 'The page on your website by path and/or query parameters.  '),
                (u'ga:pageTitle',
                 'The title for the page, as specified in the <code>&lt;title&gt;&lt;/title&gt;</code> element of the HTML document. '),
                (u'ga:affiliation',
                 'Typically used to designate  a supplying company or brick and mortar location; product affiliation.'),
                (u'ga:daysToTransaction',
                 "The number of days between users' purchases and the related campaigns that lead to the purchases."),
                (u'ga:productCategory',
                 'Any product variations (size, color) for purchased items as supplied by your ecommerce application.  '),
                (u'ga:productName',
                 'The product name for purchased items as supplied by your ecommerce tracking method.'),
                (u'ga:productSku',
                 'The product codes for purchased items as you have defined them in your ecommerce tracking application.'),
                (u'ga:transactionId',
                 ' The transaction ID for the shopping cart purchase as supplied by your ecommerce tracking method.'),
                (u'ga:searchCategory',
                 'If you have categories enabled for internal site search, this field identifies the categories used for the internal search.  For example, you might have product categories for internal search, such as <em>electronics</em>, <em>furniture</em>, or <em>clothing</em>.'),
                (u'ga:searchDestinationPage',
                 'The page that the user visited after performing an internal site search. '),
                (u'ga:searchKeyword',
                 'Search terms used by site visitors on your internal site search.'),
                (u'ga:searchKeywordRefinement',
                 'Subsequent keyword search terms or strings entered by users after a given initial string search. '),
                (u'ga:searchStartPage',
                 'The page where the user initiated an internal site search. '),
                (u'ga:searchUsed',
                 'A boolean which separates visitor activity depending upon whether internal search activity occured or did not occur.\n      Values are <code>Visits With Site Search</code> and <code>Visits Without Site Search</code>.')],
 u'Metric': [(u'ga:bounces',
              'The total number of single-page visits to your site.'),
             (u'ga:entrances',
              'The number of entrances to your site.  The value will always be equal to the number of visits when aggregated over your entire website.  Thus, this metric is most useful when combined with dimensions such as <code>ga:landingPagePath</code>, at which point entrances as a metric indicates the number of times a particular page served as an entrance to your site. '),
             (u'ga:exits',
              'The number of exits from your site. As with entrances, it will always be equal to the number of visits when aggregated over your entire website.  Use this metric in combination with content dimensions such as <code>ga:exitPagePath</code> in order to determine the number of times  a particular page was the last one viewed by visitors. '),
             (u'ga:newVisits',
              'The number of visitors whose visit to your site was marked as a first-time visit. '),
             (u'ga:pageviews',
              'The total  number of pageviews for your site when aggregated over the selected dimension.  For example, if you select this metric together with <code>ga:pagePath</code>, it will return the number of page views for each  URI. '),
             (u'ga:timeOnPage',
              'How long a visitor spent on a particular page or set of pages.  Calculated by subtracting the initial view time for a particular page from the initial view time for a subsequent page.  Thus, this metric does not apply to exit pages for your site. '),
             (u'ga:timeOnSite',
              'The total duration of visitor sessions over the selected dimension.  For example, suppose you combine this field with a particular ad campaign.  In this case, the metric will display the total duration of all visitor sessions for those visitors who came to your site via a particular ad campaign.  You could then compare this metric to the duration of all visitors who came to your site through means other than the particular ad campaign.  This would then give you a side-by-side comparison and a means to calculate the boost in visit duration provided by a particular campaign. '),
             (u'ga:visitors',
              'Total number of visitors to your site for the requested time period. When requesting this metric, you can only combine it with time dimensions such as <code>ga:hour</code> or <code>ga:year</code>.'),
             (u'ga:visits',
              'The total number of visits over the selected dimension. A visit consists of a single-user session, which times out automatically after 30 minutes unless the visitor continues activity on your site, or unless you have adjusted the user session in the <code>ga.js</code> tracking for your site. See <a href="/apis/analytics/docs/tracking/gaTrackingVisitors.html#userSession">Adjusting the User Session</a> for more information.'),
             (u'ga:adClicks',
              'The total number of times users have clicked on an ad to reach your site.'),
             (u'ga:adCost',
              'Derived cost for the advertising campaign. The currency for this value is based on the currency that you set in your AdWords account.'),
             (u'ga:CPC', 'Cost to advertiser per click.'),
             (u'ga:CPM', 'Cost per thousand impressions.'),
             (u'ga:CTR',
              'Click-through-rate for your ad. This is equal to the number of clicks divided by the number of impressions for your ad (e.g. how many times users clicked on one of your ads where that ad appeared).'),
             (u'ga:impressions', 'Total number of campaign impressions.'),
             (u'ga:uniquePageviews',
              'The number of different (unique) pages within a visit,  summed up across all visits'),
             (u'ga:itemRevenue',
              'Total revenue from purchased product items on your site. See the tracking API reference for <a href="/apis/analytics/docs/gaJS/gaJSApiEcommerce.html"><code>_addItem()</code></a> for additional information.'),
             (u'ga:itemQuantity',
              'The total number of items purchased.  For example, if  users purchase 2 frisbees and 5 tennis balls, 7 items have been purchased. '),
             (u'ga:transactionRevenue',
              'The total sale revenue, including shipping and tax, if provided in the transation. See the documentation for <a href="/apis/analytics/docs/gaJS/gaJSApiEcommerce.html#_gat.GA_Tracker_._addTrans"><code>_addTrans()</code></a> in the tracking API reference for additional information.'),
             (u'ga:transactions', 'The total number of transactions.'),
             (u'ga:transactionShipping', 'The total cost of shipping. '),
             (u'ga:transactionTax', 'The total amount of tax. '),
             (u'ga:uniquePurchases',
              'The number of product sets purchased.  For example, if  users purchase 2 frisbees and 5 tennis balls from your site,  2 product sets have been purchased. '),
             (u'ga:searchDepth',
              'The average number of subsequent page views made on your site after a use of your internal search feature.'),
             (u'ga:searchDuration',
              'The visit duration to your site where a use of your internal search feature occurred.'),
             (u'ga:searchExits',
              'The number of exits on your site that occurred following a search result from your internal search feature.'),
             (u'ga:searchRefinements',
              'The number of refinements made on an internal search.'),
             (u'ga:searchUniques',
              'The number of unique visitors to your site who used your internal search feature.'),
             (u'ga:searchVisits',
              'The total number of visits to your site where a use of your internal search feature occurred.'),
             (u'ga:goal1Completions',
              'The total number of completions for the specific goal. You can request completions for individual goals by number (e.g. <code>ga:goal1Completions</code>).'),
             (u'ga:goal2Completions',
              'The total number of completions for the specific goal. You can request completions for individual goals by number (e.g. <code>ga:goal1Completions</code>).'),
             (u'ga:goal3Completions',
              'The total number of completions for the specific goal. You can request completions for individual goals by number (e.g. <code>ga:goal1Completions</code>).'),
             (u'ga:goal4Completions',
              'The total number of completions for the specific goal. You can request completions for individual goals by number (e.g. <code>ga:goal1Completions</code>).'),
             (u'ga:goalCompletionsAll',
              'The total number of completions for all goals defined for your profile.'),
             (u'ga:goal1Starts',
              'The total number of starts for the requested goal number. '),
             (u'ga:goal2Starts',
              'The total number of starts for the requested goal number. '),
             (u'ga:goal3Starts',
              'The total number of starts for the requested goal number. '),
             (u'ga:goal4Starts',
              'The total number of starts for the requested goal number. '),
             (u'ga:goalStartsAll',
              'The total number of starts for all goals defined for your profile.'),
             (u'ga:goal1Value',
              'The total numeric value for the requested goal. '),
             (u'ga:goal2Value',
              'The total numeric value for the requested goal. '),
             (u'ga:goal3Value',
              'The total numeric value for the requested goal. '),
             (u'ga:goal4Value',
              'The total numeric value for the requested goal. '),
             (u'ga:goalValueAll',
              'The total value for all goals defined for your profile.')]}
