package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import java.util.List;

public class ImplicitGeometry extends AbstractFeature implements CityGMLObject {
    private TransformationMatrix4x4 transformationMatrix;
    private Code mimeType;
    private String libraryObject;
    private PointProperty referencePoint;
    private GeometryProperty relativeGMLGeometry;
    private List<ADEPropertyOfImplicitGeometry> adeProperties;

    public TransformationMatrix4x4 getTransformationMatrix() {
        return transformationMatrix;
    }

    public void setTransformationMatrix(TransformationMatrix4x4 transformationMatrix) {
        this.transformationMatrix = asChild(transformationMatrix);
    }

    public Code getMimeType() {
        return mimeType;
    }

    public void setMimeType(Code mimeType) {
        this.mimeType = asChild(mimeType);
    }

    public String getLibraryObject() {
        return libraryObject;
    }

    public void setLibraryObject(String libraryObject) {
        this.libraryObject = libraryObject;
    }

    public PointProperty getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(PointProperty referencePoint) {
        this.referencePoint = asChild(referencePoint);
    }

    public GeometryProperty getRelativeGMLGeometry() {
        return relativeGMLGeometry;
    }

    public void setRelativeGMLGeometry(GeometryProperty relativeGMLGeometry) {
        this.relativeGMLGeometry = asChild(relativeGMLGeometry);
    }

    public List<ADEPropertyOfImplicitGeometry> getADEPropertiesOfImplicitGeometry() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfImplicitGeometry(List<ADEPropertyOfImplicitGeometry> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
