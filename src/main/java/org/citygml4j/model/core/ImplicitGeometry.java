package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.Visitable;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class ImplicitGeometry extends AbstractGML implements CityGMLObject, Visitable {
    private TransformationMatrix4x4 transformationMatrix;
    private Code mimeType;
    private String libraryObject;
    private PointProperty referencePoint;
    private GeometryProperty<?> relativeGMLGeometry;
    private List<AbstractAppearanceProperty> appearances;

    public ImplicitGeometry() {
    }

    public ImplicitGeometry(TransformationMatrix4x4 transformationMatrix) {
        setTransformationMatrix(transformationMatrix);
    }

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

    public GeometryProperty<?> getRelativeGMLGeometry() {
        return relativeGMLGeometry;
    }

    public void setRelativeGMLGeometry(GeometryProperty<?> relativeGMLGeometry) {
        this.relativeGMLGeometry = asChild(relativeGMLGeometry);
    }

    public List<AbstractAppearanceProperty> getAppearances() {
        if (appearances == null)
            appearances = new ChildList<>(this);

        return appearances;
    }

    public void setAppearances(List<AbstractAppearanceProperty> appearances) {
        this.appearances = asChild(appearances);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
