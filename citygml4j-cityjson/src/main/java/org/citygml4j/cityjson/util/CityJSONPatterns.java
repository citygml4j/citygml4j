/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

import java.util.regex.Pattern;

public class CityJSONPatterns {
    public static final Pattern LOD = Pattern.compile("^(\\d\\.)?(\\d)$");
    public static final Pattern EXTENSION_VERSION = Pattern.compile("^(\\d+\\.)(\\d)+$");
    public static final Pattern CRS_URL = Pattern.compile("^https?://www.opengis.net/def/crs/(.+?)/(.*?)/(\\d+)$");
    public static final Pattern CRS_URN = Pattern.compile("^urn:ogc:def:crs(?:,crs)?:(.+?):(.*?):(\\d+).*");
    public static final Pattern CRS_SHORT = Pattern.compile("^([^:]+):(\\d+)$");
}
