package org.citygml4j.xml.reader;

import javax.xml.namespace.QName;

@FunctionalInterface
public interface CityGMLInputFilter {
    boolean accept(QName name);
}
