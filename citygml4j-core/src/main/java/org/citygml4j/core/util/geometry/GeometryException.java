/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.util.geometry;

public class GeometryException extends RuntimeException {

    public GeometryException() {
        super();
    }

    public GeometryException(String message) {
        super(message);
    }

    public GeometryException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeometryException(Throwable cause) {
        super(cause);
    }
}
