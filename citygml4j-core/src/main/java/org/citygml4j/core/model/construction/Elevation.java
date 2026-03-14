/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.DirectPosition;

public class Elevation extends GMLObject implements CityGMLObject {
    private Code elevationReference;
    private DirectPosition elevationValue;

    public Elevation() {
    }

    public Elevation(Code elevationReference, DirectPosition elevationValue) {
        setElevationReference(elevationReference);
        setElevationValue(elevationValue);
    }

    public Code getElevationReference() {
        return elevationReference;
    }

    public void setElevationReference(Code elevationReference) {
        this.elevationReference = asChild(elevationReference);
    }

    public DirectPosition getElevationValue() {
        return elevationValue;
    }

    public void setElevationValue(DirectPosition elevationValue) {
        this.elevationValue = asChild(elevationValue);
    }
}
