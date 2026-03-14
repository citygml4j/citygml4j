/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.extension;

import org.citygml4j.cityjson.extension.Extension;

public class ExtensionInfo {
    private String name;
    private String schemaLocation;
    private String version;

    public ExtensionInfo() {
    }

    public ExtensionInfo(String name, String schemaLocation, String version) {
        setName(name);
        setSchemaLocation(schemaLocation);
        setVersion(version);
    }

    public static ExtensionInfo of(Extension extension) {
        return new ExtensionInfo(extension.getName(), extension.getSchemaLocation(), extension.getVersion());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = Extension.isValidVersion(version) ? version : null;
    }
}
