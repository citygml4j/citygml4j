/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.builder;

public class CityJSONBuildException extends Exception {
    private static final long serialVersionUID = 5593833226861198811L;

    public CityJSONBuildException() {
        super();
    }

    public CityJSONBuildException(String message) {
        super(message);
    }

    public CityJSONBuildException(Throwable cause) {
        super(cause);
    }

    public CityJSONBuildException(String message, Throwable cause) {
        super(message, cause);
    }
}
