/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml;

public class CityGMLContextException extends Exception {
    private static final long serialVersionUID = 5055757255726446192L;

    public CityGMLContextException() {
        super();
    }

    public CityGMLContextException(String message) {
        super(message);
    }

    public CityGMLContextException(Throwable cause) {
        super(cause);
    }

    public CityGMLContextException(String message, Throwable cause) {
        super(message, cause);
    }
}
