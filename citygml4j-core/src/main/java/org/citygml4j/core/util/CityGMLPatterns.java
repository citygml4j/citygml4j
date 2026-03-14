/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.util;

import java.util.regex.Pattern;

public class CityGMLPatterns {
    public static final Pattern LOD_FROM_PROPERTY_NAME = Pattern.compile("^lod(-?\\d+).*", Pattern.CASE_INSENSITIVE);
}
