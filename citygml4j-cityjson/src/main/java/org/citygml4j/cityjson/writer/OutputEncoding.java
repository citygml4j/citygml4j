/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import com.fasterxml.jackson.core.JsonEncoding;

public enum OutputEncoding {
    UTF8(JsonEncoding.UTF8),
    UTF16_BE(JsonEncoding.UTF16_BE),
    UTF16_LE(JsonEncoding.UTF16_LE),
    UTF32_BE(JsonEncoding.UTF32_BE),
    UTF32_LE(JsonEncoding.UTF32_LE);

    private final JsonEncoding jsonEncoding;

    OutputEncoding(JsonEncoding jsonEncoding) {
        this.jsonEncoding = jsonEncoding;
    }

    JsonEncoding toJsonEncoding() {
        return jsonEncoding;
    }
}
