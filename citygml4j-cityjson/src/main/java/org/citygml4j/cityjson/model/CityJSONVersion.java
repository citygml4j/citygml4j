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

package org.citygml4j.cityjson.model;

public enum CityJSONVersion {
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
