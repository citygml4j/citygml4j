/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.reader;

import javax.xml.namespace.QName;

/**
 * Decides which features a reader returns, based on the qualified name of the feature element.
 * <p>
 * A chunking reader applies the filter to every chunked feature. A non-chunking reader returns every
 * feature the filter accepts, searching inside rejected elements: a filter accepting only buildings
 * returns the buildings of a city model one by one, while a filter accepting the city model returns
 * the entire city model including all its members.
 */
@FunctionalInterface
public interface CityGMLInputFilter {
    boolean accept(QName name);
}
