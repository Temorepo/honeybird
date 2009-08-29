import sys, textwrap

from sources import sources
from metric_types import types as metric_types
from string import uppercase

def asConstant(sourceName):
    chars = []
    previousUpper = True
    for char in sourceName[3:]:
        if char in uppercase and not previousUpper:
            chars.append('_')
        previousUpper = char in uppercase
        chars.append(char.upper())
    return "".join(chars)

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

wrapper = textwrap.TextWrapper(width=100, initial_indent='     * ', subsequent_indent='     * ',
        break_long_words=False)
def generate_metrics(out):
    for source, descr in sources["Metric"]:
        if metric_types[source] == "l":
            javatype = "LongMetric"
        else:
            javatype = "DoubleMetric"
        write_constant(out, descr, javatype, source, '"%s"' % source)

custom_dimensions = {"ga:visitorType": "VisitorTypeDimension"}
def generate_dimensions(out):
    for source, descr in sources["Dimension"]:
        if source in custom_dimensions:
            javatype = custom_dimensions[source]
            args = ""
        else:
            javatype = "Dimension"
            args = '"%s"' % source
        write_constant(out, descr, javatype, source, args)
        

def write_constant(out, descr, javatype, source, args):
    descr = wrapper.fill(descr)
    constant = asConstant(source)
    out.write('''    /**
%(descr)s
     */
    public static final %(javatype)s %(constant)s = new %(javatype)s(%(args)s);

''' % locals())

def write_java(classname, bodywriter):
    out = open("../src/java/com/threerings/honeybird/%s.java" % classname, 'w')
    out.write(header % {"class": classname})
    bodywriter(out)
    out.write("}\n")

if __name__ == "__main__":
    write_java("Metrics", generate_metrics)
    write_java("Dimensions", generate_dimensions)
