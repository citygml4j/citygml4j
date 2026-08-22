/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.citygml4j.core.visitor.VisitableObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.util.Matrices;
import org.xmlobjects.gml.util.matrix.Matrix;
import org.xmlobjects.model.ChildList;

import java.util.Arrays;
import java.util.List;

public class ImplicitGeometry extends AbstractGML implements CityGMLObject, VisitableObject {
    private TransformationMatrix4x4 transformationMatrix;
    private Code mimeType;
    private String libraryObject;
    private PointProperty referencePoint;
    private GeometryProperty<?> relativeGeometry;
    private List<AbstractAppearanceProperty> appearances;

    public ImplicitGeometry() {
    }

    public ImplicitGeometry(GeometryProperty<?> relativeGeometry) {
        setRelativeGeometry(relativeGeometry);
    }

    public ImplicitGeometry(GeometryProperty<?> relativeGeometry, PointProperty referencePoint, TransformationMatrix4x4 transformationMatrix) {
        this(relativeGeometry);
        setReferencePoint(referencePoint);
        setTransformationMatrix(transformationMatrix);
    }

    public ImplicitGeometry(String libraryObject) {
        this.libraryObject = libraryObject;
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

    public GeometryProperty<?> getRelativeGeometry() {
        return relativeGeometry;
    }

    public void setRelativeGeometry(GeometryProperty<?> relativeGeometry) {
        this.relativeGeometry = asChild(relativeGeometry);
    }

    public List<AbstractAppearanceProperty> getAppearances() {
        if (appearances == null)
            appearances = new ChildList<>(this);

        return appearances;
    }

    public boolean isSetAppearances() {
        return appearances != null && !appearances.isEmpty();
    }

    public void setAppearances(List<AbstractAppearanceProperty> appearances) {
        this.appearances = asChild(appearances);
    }

    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();

        if (relativeGeometry != null
                && relativeGeometry.getObject() != null
                && transformationMatrix != null
                && referencePoint != null
                && getReferencePoint().getObject() != null) {
            Envelope relative = relativeGeometry.getObject().computeEnvelope();
            if (relative.isValid()) {
                Matrix matrix = transformationMatrix.getValue().copy();

                List<Double> point = referencePoint.getObject().toCoordinateList3D();
                if (!point.isEmpty()) {
                    matrix.set(0, 3, matrix.get(0, 3) + point.get(0));
                    matrix.set(1, 3, matrix.get(1, 3) + point.get(1));
                    matrix.set(2, 3, matrix.get(2, 3) + point.get(2));
                }

                List<Double> lowerCorner = relative.getLowerCorner().toCoordinateList3D();
                List<Double> upperCorner = relative.getUpperCorner().toCoordinateList3D();
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        for (int z = 0; z < 2; z++) {
                            List<Double> corner = Arrays.asList(
                                    x == 0 ? lowerCorner.get(0) : upperCorner.get(0),
                                    y == 0 ? lowerCorner.get(1) : upperCorner.get(1),
                                    z == 0 ? lowerCorner.get(2) : upperCorner.get(2));
                            envelope.include(Matrices.transform3D(corner, matrix));
                        }
                    }
                }
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
