/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.ade;

public class ADEException extends Exception {
    private static final long serialVersionUID = -2359107805047203847L;

    public ADEException() {
        super();
    }

    public ADEException(String message) {
        super(message);
    }

    public ADEException(Throwable cause) {
        super(cause);
    }

    public ADEException(String message, Throwable cause) {
        super(message, cause);
    }
}
