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

    public void setTargetResource(String targetResource) {
        this.targetResource = targetResource;
        externalObjectName = null;
    }

    public String getExternalObjectName() {
        return externalObjectName;
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
