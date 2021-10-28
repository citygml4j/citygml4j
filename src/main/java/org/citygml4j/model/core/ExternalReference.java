/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;

public class ExternalReference extends GMLObject implements CityGMLObject {
    private String targetResource;
    private String externalObjectName;
    private String informationSystem;
    private String relationType;

    public ExternalReference() {
    }

    public ExternalReference(String targetResource) {
        this.targetResource = targetResource;
    }

    public static ExternalReference ofExternalObjectName(String externalObjectName) {
        ExternalReference externalReference = new ExternalReference();
        externalReference.setExternalObjectName(externalObjectName);
        return externalReference;
    }

    public String getTargetResource() {
        return targetResource;
    }

    public boolean isSetTargetResource() {
        return targetResource != null;
    }

    public void setTargetResource(String targetResource) {
        this.targetResource = targetResource;
        externalObjectName = null;
    }

    public String getExternalObjectName() {
        return externalObjectName;
    }

    public boolean isSetExternalObjectName() {
        return externalObjectName != null;
    }

    public void setExternalObjectName(String externalObjectName) {
        this.externalObjectName = externalObjectName;
        targetResource = null;
    }

    public String getInformationSystem() {
        return informationSystem;
    }

    public void setInformationSystem(String informationSystem) {
        this.informationSystem = informationSystem;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }
}
