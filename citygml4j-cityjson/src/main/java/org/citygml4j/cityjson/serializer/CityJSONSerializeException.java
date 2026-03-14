/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.serializer;

public class CityJSONSerializeException extends Exception {
    private static final long serialVersionUID = -38653953458549226L;

    public CityJSONSerializeException() {
        super();
    }

    public CityJSONSerializeException(String message) {
        super(message);
    }

    public CityJSONSerializeException(Throwable cause) {
        super(cause);
    }

    public CityJSONSerializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
