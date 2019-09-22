package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.LocalProperties;

public abstract class AbstractTextureParameterization extends GMLObject implements CityGMLObject {
    private LocalProperties localProperties;

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }
}
