/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.metadata;

import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.util.CityJSONPatterns;

import java.util.regex.Matcher;

public class ReferenceSystem {
    private final String authority;
    private final String version;
    private final int code;

    public ReferenceSystem(String authority, String version, int code) {
        this.authority = authority != null && !authority.isEmpty() ? authority : "EPSG";
        this.version = version != null && !version.isEmpty() ? version : "0";
        this.code = code;
    }

    public ReferenceSystem(String authority, int code) {
        this(authority, null, code);
    }

    public ReferenceSystem(int code) {
        this(null, code);
    }

    public static ReferenceSystem parse(String referenceSystem) {
        if (referenceSystem != null) {
            Matcher matcher = CityJSONPatterns.CRS_URL.matcher(referenceSystem);
            if (matcher.matches()) {
                return new ReferenceSystem(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));
            } else if (matcher.usePattern(CityJSONPatterns.CRS_URN).matches()) {
                return new ReferenceSystem(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));
            } else if (matcher.usePattern(CityJSONPatterns.CRS_SHORT).matches()) {
                return new ReferenceSystem(matcher.group(1), Integer.parseInt(matcher.group(2)));
            }
        }

        return null;
    }

    public String getAuthority() {
        return authority;
    }

    public String getVersion() {
        return version;
    }

    public int getCode() {
        return code;
    }

    public String toURL() {
        return "http://www.opengis.net/def/crs/" + authority + "/" + version + "/" + code;
    }

    public String toURN() {
        return "urn:ogc:def:crs:" + authority + ":" + (!version.equals("0") ? version : "") + ":" + code;
    }

    public String toURI(CityJSONVersion version) {
        return version == CityJSONVersion.v1_0 ?
                "urn:ogc:def:crs:EPSG::" + code :
                toURL();
    }
}
