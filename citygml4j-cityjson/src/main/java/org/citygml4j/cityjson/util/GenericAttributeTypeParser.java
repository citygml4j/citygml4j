/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
