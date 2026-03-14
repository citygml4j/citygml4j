/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util;

import java.util.regex.Pattern;

public class CityJSONPatterns {
    public static final Pattern LOD = Pattern.compile("^(\\d\\.)?(\\d)$");
    public static final Pattern EXTENSION_VERSION = Pattern.compile("^(\\d+\\.)(\\d)+$");
    public static final Pattern CRS_URL = Pattern.compile("^https?://www.opengis.net/def/crs/(.+?)/(.*?)/(\\d+)$");
    public static final Pattern CRS_URN = Pattern.compile("^urn:ogc:def:crs(?:,crs)?:(.+?):(.*?):(\\d+).*");
    public static final Pattern CRS_SHORT = Pattern.compile("^([^:]+):(\\d+)$");
}
