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

package org.citygml4j.cityjson.util;

import java.net.URI;

public class GenericAttributeTypeParser {

    public static boolean isUri(String text) {
        try {
            URI uri = new URI(text);
            return uri.getScheme() != null && uri.getPath() != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLocalDate(String text) {
        if (text.length() == 10) {
            String[] items = text.split("-");
            if (items.length == 3 && items[0].length() == 4 && items[1].length() == 2 && items[2].length() == 2) {
                for (String item : items) {
                    if (!isOnlyDigits(item)) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

    private static boolean isOnlyDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
