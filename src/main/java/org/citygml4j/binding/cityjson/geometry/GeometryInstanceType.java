package org.citygml4j.binding.cityjson.geometry;

import org.citygml4j.geometry.Matrix;

import java.util.Collections;
import java.util.List;

public class GeometryInstanceType extends AbstractGeometryType {
    private final GeometryTypeName type = GeometryTypeName.GEOMETRY_INSTANCE;
    private int template;
    private List<Integer> boundaries = Collections.singletonList(0);
    private List<Double> transformationMatrix = Matrix.identity(4, 4).toRowPackedList();

    @Override
    public GeometryTypeName getType() {
        return type;
    }

    public int getTemplate() {
        return template;
    }

    public void setTemplate(int template) {
        this.template = template;
    }

    public int getReferencePoint() {
        return boundaries.get(0);
    }

    public void setReferencePoint(int point) {
        boundaries = Collections.singletonList(point);
    }

    public List<Double> getTransformationMatrix() {
        return transformationMatrix;
    }

    public void setTransformationMatrix(List<Double> transformationMatrix) {
        if (transformationMatrix != null && transformationMatrix.size() >= 16)
            this.transformationMatrix = transformationMatrix.subList(0, 16);
    }

}
