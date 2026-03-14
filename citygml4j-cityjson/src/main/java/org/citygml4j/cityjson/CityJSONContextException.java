/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson;

public class CityJSONContextException extends Exception {
    private static final long serialVersionUID = -6812784169431656655L;

    public CityJSONContextException() {
        super();
    }

    public CityJSONContextException(String message) {
        super(message);
    }

    public CityJSONContextException(Throwable cause) {
        super(cause);
    }

    public CityJSONContextException(String message, Throwable cause) {
        super(message, cause);
    }
}
