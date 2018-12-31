/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.binding.cityjson.metadata.feature;

import com.google.gson.annotations.SerializedName;
import org.citygml4j.binding.cityjson.metadata.ThematicModelType;

public class TunnelDataType extends AbstractFeatureDataType {
    @SerializedName("TunnelParts")
    private Integer tunnelParts;
    @SerializedName("TunnelInstallations")
    private Integer tunnelInstallations;

    public boolean isSetTunnelParts() {
        return tunnelParts != null;
    }

    public Integer getTunnelParts() {
        return tunnelParts;
    }

    public void setTunnelParts(Integer tunnelParts) {
        this.tunnelParts = tunnelParts;
    }

    public void unsetTunnelParts() {
        tunnelParts = null;
    }

    public boolean isSetTunnelInstallations() {
        return tunnelInstallations != null;
    }

    public Integer getTunnelInstallations() {
        return tunnelInstallations;
    }

    public void setTunnelInstallations(Integer tunnelInstallations) {
        this.tunnelInstallations = tunnelInstallations;
    }

    public void unsetTunnelInstallations() {
        tunnelInstallations = null;
    }

    @Override
    public ThematicModelType getType() {
        return ThematicModelType.TUNNEL;
    }
}
