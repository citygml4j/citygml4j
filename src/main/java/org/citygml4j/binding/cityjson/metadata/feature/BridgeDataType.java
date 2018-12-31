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

public class BridgeDataType extends AbstractFeatureDataType {
    @SerializedName("BridgeParts")
    private Integer bridgeParts;
    @SerializedName("BridgeInstallations")
    private Integer bridgeInstallations;
    @SerializedName("BridgeConstructionElements")
    private Integer bridgeConstructionElements;

    public boolean isSetBridgeParts() {
        return bridgeParts != null;
    }

    public Integer getBridgeParts() {
        return bridgeParts;
    }

    public void setBridgeParts(Integer bridgeParts) {
        this.bridgeParts = bridgeParts;
    }

    public void unsetBridgeParts() {
        bridgeParts = null;
    }

    public boolean isSetBridgeInstallations() {
        return bridgeInstallations != null;
    }

    public Integer getBridgeInstallations() {
        return bridgeInstallations;
    }

    public void setBridgeInstallations(Integer bridgeInstallations) {
        this.bridgeInstallations = bridgeInstallations;
    }

    public void unsetBridgeInstallations() {
        bridgeInstallations = null;
    }

    public boolean isSetBridgeConstructionElements() {
        return bridgeConstructionElements != null;
    }

    public Integer getBridgeConstructionElements() {
        return bridgeConstructionElements;
    }

    public void setBridgeConstructionElements(Integer bridgeConstructionElements) {
        this.bridgeConstructionElements = bridgeConstructionElements;
    }

    public void unsetBridgeConstructionElements() {
        bridgeConstructionElements = null;
    }

    @Override
    public ThematicModelType getType() {
        return ThematicModelType.BRIDGE;
    }
}
