/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
