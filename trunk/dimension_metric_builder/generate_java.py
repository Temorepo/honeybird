import sys, textwrap

from sources import sources
from source_types import types 
from string import uppercase

def asConstant(sourceName):
    sourceName = sourceName[3:]
    return "".join(["_" + s if s in uppercase else s.upper() for s in sourceName])

header = '''/*
   honeybird - Fluent queries for Google Analytics
   src/java/com/threerings/honeybird/%(class)s.java

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

public interface %(class)s
{
'''

def generate_group(group, sources, out):
    out.write(header % {"class": group + "s"})
    grouptypes = types[group]
    wrapper = textwrap.TextWrapper(width=100, initial_indent='     * ', subsequent_indent='     * ',
            break_long_words=False)
    for source, descr in sources:
        descr = wrapper.fill(descr)
        type = grouptypes[source]
        if type == 's':
            generic = "String"
        elif type == 'i':
            generic = "Integer"
        else:
            generic = "Void"
        constant = asConstant(source)
        out.write('''    /**
%(descr)s
     */
    public static final %(group)s<%(generic)s> %(constant)s = new %(group)s<%(generic)s>("%(source)s");

''' % locals())
    out.write("}\n")

for group, sources in sources.items():
    generate_group(group, sources,
            open("../src/java/com/threerings/honeybird/%ss.java" % group, 'w'))
