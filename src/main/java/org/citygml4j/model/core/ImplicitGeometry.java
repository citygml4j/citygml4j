package org.citygml4j.model.core;

import Jama.Matrix;
import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.util.Matrices;
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

    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();

        if (relativeGMLGeometry != null
                && relativeGMLGeometry.getObject() != null
                && transformationMatrix != null
                && referencePoint != null
                && getReferencePoint().getObject() != null) {
            Envelope relative = relativeGMLGeometry.getObject().computeEnvelope();
            if (relative.isValid()) {
                Matrix matrix = transformationMatrix.getValue().copy();

                List<Double> point = referencePoint.getObject().toCoordinateList3D();
                if (!point.isEmpty()) {
                    matrix.set(0, 3, matrix.get(0, 3) + point.get(0));
                    matrix.set(1, 3, matrix.get(1, 3) + point.get(1));
                    matrix.set(2, 3, matrix.get(2, 3) + point.get(2));
                }

                envelope.include(Matrices.transform3D(relative.getLowerCorner(), matrix));
                envelope.include(Matrices.transform3D(relative.getUpperCorner(), matrix));
            }
        } else if (referencePoint != null
                && referencePoint.getObject() != null) {
            List<Double> point = referencePoint.getObject().toCoordinateList3D();
            if (!point.isEmpty()) {
                if (transformationMatrix != null) {
                    Matrix matrix = transformationMatrix.getValue();
                    point.set(0, point.get(0) + matrix.get(0, 3));
                    point.set(1, point.get(1) + matrix.get(1, 3));
                    point.set(2, point.get(2) + matrix.get(2, 3));
                }

                envelope.include(point);
            }
        }

        return envelope;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
