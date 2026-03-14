/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

public class CityJSONWriteException extends Exception {
    private static final long serialVersionUID = -5084586100447250323L;

    public CityJSONWriteException() {
        super();
    }

    public CityJSONWriteException(String message) {
        super(message);
    }

    public CityJSONWriteException(Throwable cause) {
        super(cause);
    }

    public CityJSONWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
