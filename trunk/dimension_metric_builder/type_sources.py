import pprint, sys
from sources import sources
try:
    from source_types import types
except:
    types = {}
def write_types():
    outtypes = open('source_types.py', 'w')
    outtypes.write("types = ")
    pprint.pprint(types, outtypes)
    outtypes.close()
for group, sources in sources.items():
    if not group in types:
        types[group] = {}
    for name, descr in sources:
        if name in types[group]:
            continue
        print name, descr
        try:
            type = raw_input("type(i, s or custom): ")
        except EOFError:
            write_types()
            sys.exit(0)
        types[group][name] = type
write_types()
