import collections, pprint, re, urllib
from BeautifulSoup import BeautifulSoup

refpage = "http://code.google.com/apis/analytics/docs/gdata/gdataReferenceDimensionsMetrics.html"
ref = urllib.urlopen(refpage).read().decode("UTF-8")
soup = BeautifulSoup(ref)
sources = {}
badcols = []

# Absolutize any links to /
abslink = re.compile('^/')
for link in soup("a", href=abslink):
    link["href"] =  "http://code.google.com%s" % link["href"]

anchor = re.compile('<a.*href="#.*">([\w:]+)</a>')
multispace = re.compile('\s+')
javadoc_links = {"ga:hour": "{@link #HOUR}", "ga:adContent": "{@link #AD_CONTENT}"}
for table in soup('table', border="0", cellpadding="5"):
    type = table.tr.th.next
    sources[type] = []
    for row in table('tr')[1:]:
        cols = row('td')
        for code in cols[1]('code'):
            descr = ''.join([str(content) for content in cols[2].contents]).strip()

            # Compress big hunks of whitespace
            descr = multispace.sub(' ', descr)

            # Look for any page relative anchors, and replace them with an item from javadoc_links
            # if it exists.  If it doesn't, a KeyError will be thrown, which means a new anchor has
            # been added.  A new entry should be added to javadoc_links to handle it.
            descr = anchor.sub(lambda m: javadoc_links[m.group(1)], descr)
            sources[type].append((code.string, descr))
print 'sources = ',
pprint.pprint(sources)

