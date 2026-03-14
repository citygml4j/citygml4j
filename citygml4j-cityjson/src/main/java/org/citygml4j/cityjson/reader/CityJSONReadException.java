/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.reader;

public class CityJSONReadException extends Exception {
    private static final long serialVersionUID = -2576696421938548363L;

    public CityJSONReadException() {
        super();
    }

    public CityJSONReadException(String message) {
        super(message);
    }

    public CityJSONReadException(Throwable cause) {
        super(cause);
    }

    public CityJSONReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
