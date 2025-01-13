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
package org.citygml4j.builder.cityjson.extension;

import org.citygml4j.model.module.ModuleVersion;

public class ExtensionModuleVersion implements ModuleVersion {
    private final int major;
    private final int minor;
    private final int patch;
    private final String additionalLabel;

    public ExtensionModuleVersion(int major, int minor, int patch, String additionalLabel) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.additionalLabel = additionalLabel;
    }

    public ExtensionModuleVersion(int major, int minor, int patch) {
        this(major, minor, patch, null);
    }

    public ExtensionModuleVersion(int major, int minor) {
        this(major, minor, 0, null);
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

    public String getAdditionalLabel() {
        return additionalLabel;
    }

    @Override
    public String getVersionString() {
        StringBuilder version = new StringBuilder(major).append(".").append(minor).append(patch);
        if (additionalLabel != null)
            version.append(additionalLabel);

        return version.toString();
    }

    @Override
    public String toString() {
        return getVersionString();
    }

}