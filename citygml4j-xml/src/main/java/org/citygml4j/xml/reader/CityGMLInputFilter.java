/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.reader;

import javax.xml.namespace.QName;

@FunctionalInterface
public interface CityGMLInputFilter {
    boolean accept(QName name);
}
