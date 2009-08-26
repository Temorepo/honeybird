import collections, pprint, urllib
from BeautifulSoup import BeautifulSoup

refpage = "http://code.google.com/apis/analytics/docs/gdata/gdataReferenceDimensionsMetrics.html"
ref = urllib.urlopen(refpage).read().decode("UTF-8")
soup = BeautifulSoup(ref)
sources = {}
badcols = []
for table in soup('table', border="0", cellpadding="5"):
    type = table.tr.th.next
    sources[type] = []
    for row in table('tr')[1:]:
        cols = row('td')
        for code in cols[1]('code'):

            descr = ''.join([str(content) for content in cols[2].contents])
            sources[type].append((code.string, descr))
print 'sources = ',
pprint.pprint(sources)

