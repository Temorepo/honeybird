import sys, textwrap

from sources import sources
from metric_types import types as metric_types
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

custom_sources = {"ga:visitorType": "VisitorTypeDimension"}
def generate_metrics(out):
    out.write(header % {"class": "Metrics"})
    wrapper = textwrap.TextWrapper(width=100, initial_indent='     * ', subsequent_indent='     * ',
            break_long_words=False)
    for metric, descr in sources["Metric"]:
        descr = wrapper.fill(descr)
        constant = asConstant(metric)
        if metric in custom_sources:
            javatype = custom_sources[metric]
            args = ""
        else:
            if metric_types[metric] == "l":
                javatype = "LongMetric"
            else:
                javatype = "DoubleMetric"
            args = '"%s"' % metric
        out.write('''    /**
%(descr)s
     */
    public static final %(javatype)s %(constant)s = new %(javatype)s(%(args)s);

''' % locals())
    out.write("}\n")

def generate_dimensions(out):
    out.write(header % {"class": "Dimensions"})
    wrapper = textwrap.TextWrapper(width=100, initial_indent='     * ', subsequent_indent='     * ',
            break_long_words=False)
    for source, descr in sources["Dimension"]:
        descr = wrapper.fill(descr)
        constant = asConstant(source)
        if source in custom_sources:
            javatype = custom_sources[source]
            args = ""
        else:
            javatype = "Dimension"
            args = '"%s"' % source
        out.write('''    /**
    %(descr)s
     */
    public static final %(javatype)s %(constant)s = new %(javatype)s(%(args)s);

    ''' % locals())
    out.write("}\n")

generate_metrics(open("../src/java/com/threerings/honeybird/Metrics.java", 'w'))
generate_dimensions(open("../src/java/com/threerings/honeybird/Dimensions.java", 'w'))
