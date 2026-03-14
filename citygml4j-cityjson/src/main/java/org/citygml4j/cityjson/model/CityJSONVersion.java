/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model;

public enum CityJSONVersion {
    v2_0(2, 0),
    v1_1(1, 1),
    v1_0(1, 0);

    private final int major;
    private final int minor;

    CityJSONVersion(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public boolean isLessThanOrEqual(CityJSONVersion version) {
        return compare(this, version) <= 0;
    }

    public boolean isGreaterThanOrEqual(CityJSONVersion version) {
        return compare(this, version) >= 0;
    }

    public String toValue() {
        return major + "." + minor;
    }

    public static CityJSONVersion min(CityJSONVersion a, CityJSONVersion b) {
        return compare(a, b) < 0 ? a : b;
    }

    public static CityJSONVersion max(CityJSONVersion a, CityJSONVersion b) {
        return compare(a, b) > 0 ? a : b;
    }

    public static int compare(CityJSONVersion a, CityJSONVersion b) {
        return a.major != b.major ?
                Integer.compare(a.major, b.major) :
                Integer.compare(a.minor, b.minor);
    }

    public static CityJSONVersion fromValue(String value) {
        for (CityJSONVersion v : CityJSONVersion.values()) {
            if (v.toValue().equals(value))
                return v;
        }

        return null;
    }

    @Override
    public String toString() {
        return toValue();
    }
}
