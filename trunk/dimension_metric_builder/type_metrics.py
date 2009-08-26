import pprint, sys
from sources import sources
try:
    from metric_types import types
except:
    types = {}
def write_types():
    outtypes = open('metric_types.py', 'w')
    outtypes.write("types = ")
    pprint.pprint(types, outtypes)
    outtypes.close()

for name, descr in sources["Metric"]:
    if name in types:
        continue
    print name, descr
    try:
        type = raw_input("type(l or d): ")
    except EOFError:
        write_types()
        sys.exit(0)
    types[name] = type
write_types()
