/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.reader;

public class CityGMLReadException extends Exception {
    private static final long serialVersionUID = -2820518959032762590L;

    public CityGMLReadException() {
        super();
    }

    public CityGMLReadException(String message) {
        super(message);
    }

    public CityGMLReadException(Throwable cause) {
        super(cause);
    }

    public CityGMLReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
