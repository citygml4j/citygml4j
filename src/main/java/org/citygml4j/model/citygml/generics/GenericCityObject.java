/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class GenericCityObject extends AbstractCityObject implements GenericsModuleComponent, StandardObjectClassifier {
    private Code clazz;
    private List<Code> function;
    private List<Code> usage;
    private GeometryProperty<? extends AbstractGeometry> lod0Geometry;
    private GeometryProperty<? extends AbstractGeometry> lod1Geometry;
    private GeometryProperty<? extends AbstractGeometry> lod2Geometry;
    private GeometryProperty<? extends AbstractGeometry> lod3Geometry;
    private GeometryProperty<? extends AbstractGeometry> lod4Geometry;
    private MultiCurveProperty lod0TerrainIntersection;
    private MultiCurveProperty lod1TerrainIntersection;
    private MultiCurveProperty lod2TerrainIntersection;
    private MultiCurveProperty lod3TerrainIntersection;
    private MultiCurveProperty lod4TerrainIntersection;
    private ImplicitRepresentationProperty lod0ImplicitRepresentation;
    private ImplicitRepresentationProperty lod1ImplicitRepresentation;
    private ImplicitRepresentationProperty lod2ImplicitRepresentation;
    private ImplicitRepresentationProperty lod3ImplicitRepresentation;
    private ImplicitRepresentationProperty lod4ImplicitRepresentation;

    public GenericCityObject() {

    }

    public GenericCityObject(Module module) {
        super(module);
    }

    public void addFunction(Code function) {
        getFunction().add(function);
    }

    public void addUsage(Code usage) {
        getUsage().add(usage);
    }

    public Code getClazz() {
        return clazz;
    }

    public List<Code> getFunction() {
        if (function == null)
            function = new ChildList<>(this);

        return function;
    }

    public List<Code> getUsage() {
        if (usage == null)
            usage = new ChildList<>(this);

        return usage;
    }

    public GeometryProperty<? extends AbstractGeometry> getLod0Geometry() {
        return lod0Geometry;
    }

    public ImplicitRepresentationProperty getLod0ImplicitRepresentation() {
        return lod0ImplicitRepresentation;
    }

    public MultiCurveProperty getLod0TerrainIntersection() {
        return lod0TerrainIntersection;
    }

    public GeometryProperty<? extends AbstractGeometry> getLod1Geometry() {
        return lod1Geometry;
    }

    public ImplicitRepresentationProperty getLod1ImplicitRepresentation() {
        return lod1ImplicitRepresentation;
    }

    public MultiCurveProperty getLod1TerrainIntersection() {
        return lod1TerrainIntersection;
    }

    public GeometryProperty<? extends AbstractGeometry> getLod2Geometry() {
        return lod2Geometry;
    }

    public ImplicitRepresentationProperty getLod2ImplicitRepresentation() {
        return lod2ImplicitRepresentation;
    }

    public MultiCurveProperty getLod2TerrainIntersection() {
        return lod2TerrainIntersection;
    }

    public GeometryProperty<? extends AbstractGeometry> getLod3Geometry() {
        return lod3Geometry;
    }

    public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    public MultiCurveProperty getLod3TerrainIntersection() {
        return lod3TerrainIntersection;
    }

    public GeometryProperty<? extends AbstractGeometry> getLod4Geometry() {
        return lod4Geometry;
    }

    public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    public MultiCurveProperty getLod4TerrainIntersection() {
        return lod4TerrainIntersection;
    }

    public boolean isSetClazz() {
        return clazz != null;
    }

    public boolean isSetFunction() {
        return function != null && !function.isEmpty();
    }

    public boolean isSetUsage() {
        return usage != null && !usage.isEmpty();
    }

    public boolean isSetLod0Geometry() {
        return lod0Geometry != null;
    }

    public boolean isSetLod0ImplicitRepresentation() {
        return lod0ImplicitRepresentation != null;
    }

    public boolean isSetLod0TerrainIntersection() {
        return lod0TerrainIntersection != null;
    }

    public boolean isSetLod1Geometry() {
        return lod1Geometry != null;
    }

    public boolean isSetLod1ImplicitRepresentation() {
        return lod1ImplicitRepresentation != null;
    }

    public boolean isSetLod1TerrainIntersection() {
        return lod1TerrainIntersection != null;
    }

    public boolean isSetLod2Geometry() {
        return lod2Geometry != null;
    }

    public boolean isSetLod2ImplicitRepresentation() {
        return lod2ImplicitRepresentation != null;
    }

    public boolean isSetLod2TerrainIntersection() {
        return lod2TerrainIntersection != null;
    }

    public boolean isSetLod3Geometry() {
        return lod3Geometry != null;
    }

    public boolean isSetLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation != null;
    }

    public boolean isSetLod3TerrainIntersection() {
        return lod3TerrainIntersection != null;
    }

    public boolean isSetLod4Geometry() {
        return lod4Geometry != null;
    }

    public boolean isSetLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation != null;
    }

    public boolean isSetLod4TerrainIntersection() {
        return lod4TerrainIntersection != null;
    }

    public void setClazz(Code clazz) {
        this.clazz = ModelObjects.setParent(clazz, this);
    }

    public void setFunction(List<Code> function) {
        this.function = new ChildList<>(this, function);
    }

    public void setUsage(List<Code> usage) {
        this.usage = new ChildList<>(this, usage);
    }

    public void setLod0Geometry(GeometryProperty<? extends AbstractGeometry> lod0Geometry) {
        this.lod0Geometry = ModelObjects.setParent(lod0Geometry, this);
    }

    public void setLod0ImplicitRepresentation(ImplicitRepresentationProperty lod0ImplicitRepresentation) {
        this.lod0ImplicitRepresentation = ModelObjects.setParent(lod0ImplicitRepresentation, this);
    }

    public void setLod0TerrainIntersection(MultiCurveProperty lod0TerrainIntersection) {
        this.lod0TerrainIntersection = ModelObjects.setParent(lod0TerrainIntersection, this);
    }

    public void setLod1Geometry(GeometryProperty<? extends AbstractGeometry> lod1Geometry) {
        this.lod1Geometry = ModelObjects.setParent(lod1Geometry, this);
    }

    public void setLod1ImplicitRepresentation(ImplicitRepresentationProperty lod1ImplicitRepresentation) {
        this.lod1ImplicitRepresentation = ModelObjects.setParent(lod1ImplicitRepresentation, this);
    }

    public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
        this.lod1TerrainIntersection = ModelObjects.setParent(lod1TerrainIntersection, this);
    }

    public void setLod2Geometry(GeometryProperty<? extends AbstractGeometry> lod2Geometry) {
        this.lod2Geometry = ModelObjects.setParent(lod2Geometry, this);
    }

    public void setLod2ImplicitRepresentation(ImplicitRepresentationProperty lod2ImplicitRepresentation) {
        this.lod2ImplicitRepresentation = ModelObjects.setParent(lod2ImplicitRepresentation, this);
    }

    public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
        this.lod2TerrainIntersection = ModelObjects.setParent(lod2TerrainIntersection, this);
    }

    public void setLod3Geometry(GeometryProperty<? extends AbstractGeometry> lod3Geometry) {
        this.lod3Geometry = ModelObjects.setParent(lod3Geometry, this);
    }

    public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
        this.lod3ImplicitRepresentation = ModelObjects.setParent(lod3ImplicitRepresentation, this);
    }

    public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
        this.lod3TerrainIntersection = ModelObjects.setParent(lod3TerrainIntersection, this);
    }

    public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry) {
        this.lod4Geometry = ModelObjects.setParent(lod4Geometry, this);
    }

    public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
        this.lod4ImplicitRepresentation = ModelObjects.setParent(lod4ImplicitRepresentation, this);
    }

    public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
        this.lod4TerrainIntersection = ModelObjects.setParent(lod4TerrainIntersection, this);
    }

    public void unsetClazz() {
        clazz = ModelObjects.setNull(clazz);
    }

    public void unsetFunction() {
        function = ModelObjects.setNull(function);
    }

    public boolean unsetFunction(Code function) {
        return isSetFunction() && this.function.remove(function);
    }

    public void unsetUsage() {
        usage = ModelObjects.setNull(usage);
    }

    public boolean unsetUsage(Code usage) {
        return isSetUsage() && this.usage.remove(usage);
    }

    public void unsetLod0Geometry() {
        lod0Geometry = ModelObjects.setNull(lod0Geometry);
    }

    public void unsetLod0ImplicitRepresentation() {
        lod0ImplicitRepresentation = ModelObjects.setNull(lod0ImplicitRepresentation);
    }

    public void unsetLod0TerrainIntersection() {
        lod0TerrainIntersection = ModelObjects.setNull(lod0TerrainIntersection);
    }

    public void unsetLod1Geometry() {
        lod1Geometry = ModelObjects.setNull(lod1Geometry);
    }

    public void unsetLod1ImplicitRepresentation() {
        lod1ImplicitRepresentation = ModelObjects.setNull(lod1ImplicitRepresentation);
    }

    public void unsetLod1TerrainIntersection() {
        lod1TerrainIntersection = ModelObjects.setNull(lod1TerrainIntersection);
    }

    public void unsetLod2Geometry() {
        lod2Geometry = ModelObjects.setNull(lod2Geometry);
    }

    public void unsetLod2ImplicitRepresentation() {
        lod2ImplicitRepresentation = ModelObjects.setNull(lod2ImplicitRepresentation);
    }

    public void unsetLod2TerrainIntersection() {
        lod2TerrainIntersection = ModelObjects.setNull(lod2TerrainIntersection);
    }

    public void unsetLod3Geometry() {
        lod3Geometry = ModelObjects.setNull(lod3Geometry);
    }

    public void unsetLod3ImplicitRepresentation() {
        lod3ImplicitRepresentation = ModelObjects.setNull(lod3ImplicitRepresentation);
    }

    public void unsetLod3TerrainIntersection() {
        lod3TerrainIntersection = ModelObjects.setNull(lod3TerrainIntersection);
    }

    public void unsetLod4Geometry() {
        lod4Geometry = ModelObjects.setNull(lod4Geometry);
    }

    public void unsetLod4ImplicitRepresentation() {
        lod4ImplicitRepresentation = ModelObjects.setNull(lod4ImplicitRepresentation);
    }

    public void unsetLod4TerrainIntersection() {
        lod4TerrainIntersection = ModelObjects.setNull(lod4TerrainIntersection);
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.GENERIC_CITY_OBJECT;
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        GeometryProperty<? extends AbstractGeometry> geometryProperty = null;
        for (int lod = 0; lod < 5; lod++) {
            switch (lod) {
                case 0:
                    geometryProperty = lod0Geometry;
                    break;
                case 1:
                    geometryProperty = lod1Geometry;
                    break;
                case 2:
                    geometryProperty = lod2Geometry;
                    break;
                case 3:
                    geometryProperty = lod3Geometry;
                    break;
                case 4:
                    geometryProperty = lod4Geometry;
                    break;
            }

            if (geometryProperty != null) {
                if (geometryProperty.isSetGeometry()) {
                    boundedBy.updateEnvelope(geometryProperty.getGeometry().calcBoundingBox());
                } else {
                    // xlink
                }
            }
        }

        ImplicitRepresentationProperty implicitRepresentation = null;
        for (int lod = 0; lod < 5; lod++) {
            switch (lod) {
                case 0:
                    implicitRepresentation = lod0ImplicitRepresentation;
                    break;
                case 1:
                    implicitRepresentation = lod1ImplicitRepresentation;
                    break;
                case 2:
                    implicitRepresentation = lod2ImplicitRepresentation;
                    break;
                case 3:
                    implicitRepresentation = lod3ImplicitRepresentation;
                    break;
                case 4:
                    implicitRepresentation = lod4ImplicitRepresentation;
                    break;
            }

            if (implicitRepresentation != null && implicitRepresentation.isSetImplicitGeometry())
                boundedBy.updateEnvelope(implicitRepresentation.getImplicitGeometry().calcBoundingBox(options));
        }

        if (options.isAssignResultToFeatures())
            setBoundedBy(boundedBy);

        return boundedBy;
    }

    @Override
    public LodRepresentation getLodRepresentation() {
        LodRepresentation lodRepresentation = new LodRepresentation();

        lodRepresentation.addRepresentation(0, lod0Geometry);
        lodRepresentation.addRepresentation(1, lod1Geometry);
        lodRepresentation.addRepresentation(2, lod2Geometry);
        lodRepresentation.addRepresentation(3, lod3Geometry);
        lodRepresentation.addRepresentation(4, lod4Geometry);

        lodRepresentation.addRepresentation(0, lod0ImplicitRepresentation);
        lodRepresentation.addRepresentation(1, lod1ImplicitRepresentation);
        lodRepresentation.addRepresentation(2, lod2ImplicitRepresentation);
        lodRepresentation.addRepresentation(3, lod3ImplicitRepresentation);
        lodRepresentation.addRepresentation(4, lod4ImplicitRepresentation);

        return lodRepresentation;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new GenericCityObject(), copyBuilder);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        GenericCityObject copy = (target == null) ? new GenericCityObject() : (GenericCityObject) target;
        super.copyTo(copy, copyBuilder);

        if (isSetClazz())
            copy.setClazz((Code) copyBuilder.copy(clazz));

        if (isSetFunction()) {
            for (Code part : function) {
                Code copyPart = (Code) copyBuilder.copy(part);
                copy.addFunction(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetUsage()) {
            for (Code part : usage) {
                Code copyPart = (Code) copyBuilder.copy(part);
                copy.addUsage(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetLod0Geometry()) {
            copy.setLod0Geometry((GeometryProperty<? extends AbstractGeometry>) copyBuilder.copy(lod0Geometry));
            if (copy.getLod0Geometry() == lod0Geometry)
                lod0Geometry.setParent(this);
        }

        if (isSetLod1Geometry()) {
            copy.setLod1Geometry((GeometryProperty<? extends AbstractGeometry>) copyBuilder.copy(lod1Geometry));
            if (copy.getLod1Geometry() == lod1Geometry)
                lod1Geometry.setParent(this);
        }

        if (isSetLod2Geometry()) {
            copy.setLod2Geometry((GeometryProperty<? extends AbstractGeometry>) copyBuilder.copy(lod2Geometry));
            if (copy.getLod2Geometry() == lod2Geometry)
                lod2Geometry.setParent(this);
        }

        if (isSetLod3Geometry()) {
            copy.setLod3Geometry((GeometryProperty<? extends AbstractGeometry>) copyBuilder.copy(lod3Geometry));
            if (copy.getLod3Geometry() == lod3Geometry)
                lod3Geometry.setParent(this);
        }

        if (isSetLod4Geometry()) {
            copy.setLod4Geometry((GeometryProperty<? extends AbstractGeometry>) copyBuilder.copy(lod4Geometry));
            if (copy.getLod4Geometry() == lod4Geometry)
                lod4Geometry.setParent(this);
        }

        if (isSetLod0ImplicitRepresentation()) {
            copy.setLod0ImplicitRepresentation((ImplicitRepresentationProperty) copyBuilder.copy(lod0ImplicitRepresentation));
            if (copy.getLod0ImplicitRepresentation() == lod0ImplicitRepresentation)
                lod0ImplicitRepresentation.setParent(this);
        }

        if (isSetLod1ImplicitRepresentation()) {
            copy.setLod1ImplicitRepresentation((ImplicitRepresentationProperty) copyBuilder.copy(lod1ImplicitRepresentation));
            if (copy.getLod1ImplicitRepresentation() == lod1ImplicitRepresentation)
                lod1ImplicitRepresentation.setParent(this);
        }

        if (isSetLod2ImplicitRepresentation()) {
            copy.setLod2ImplicitRepresentation((ImplicitRepresentationProperty) copyBuilder.copy(lod2ImplicitRepresentation));
            if (copy.getLod2ImplicitRepresentation() == lod2ImplicitRepresentation)
                lod2ImplicitRepresentation.setParent(this);
        }

        if (isSetLod3ImplicitRepresentation()) {
            copy.setLod3ImplicitRepresentation((ImplicitRepresentationProperty) copyBuilder.copy(lod3ImplicitRepresentation));
            if (copy.getLod3ImplicitRepresentation() == lod3ImplicitRepresentation)
                lod3ImplicitRepresentation.setParent(this);
        }

        if (isSetLod4ImplicitRepresentation()) {
            copy.setLod4ImplicitRepresentation((ImplicitRepresentationProperty) copyBuilder.copy(lod4ImplicitRepresentation));
            if (copy.getLod4ImplicitRepresentation() == lod4ImplicitRepresentation)
                lod4ImplicitRepresentation.setParent(this);
        }

        if (isSetLod0TerrainIntersection()) {
            copy.setLod0TerrainIntersection((MultiCurveProperty) copyBuilder.copy(lod0TerrainIntersection));
            if (copy.getLod0TerrainIntersection() == lod0TerrainIntersection)
                lod0TerrainIntersection.setParent(this);
        }

        if (isSetLod1TerrainIntersection()) {
            copy.setLod1TerrainIntersection((MultiCurveProperty) copyBuilder.copy(lod1TerrainIntersection));
            if (copy.getLod1TerrainIntersection() == lod1TerrainIntersection)
                lod1TerrainIntersection.setParent(this);
        }

        if (isSetLod2TerrainIntersection()) {
            copy.setLod2TerrainIntersection((MultiCurveProperty) copyBuilder.copy(lod2TerrainIntersection));
            if (copy.getLod2TerrainIntersection() == lod2TerrainIntersection)
                lod2TerrainIntersection.setParent(this);
        }

        if (isSetLod3TerrainIntersection()) {
            copy.setLod3TerrainIntersection((MultiCurveProperty) copyBuilder.copy(lod3TerrainIntersection));
            if (copy.getLod3TerrainIntersection() == lod3TerrainIntersection)
                lod3TerrainIntersection.setParent(this);
        }

        if (isSetLod4TerrainIntersection()) {
            copy.setLod4TerrainIntersection((MultiCurveProperty) copyBuilder.copy(lod4TerrainIntersection));
            if (copy.getLod4TerrainIntersection() == lod4TerrainIntersection)
                lod4TerrainIntersection.setParent(this);
        }

        return copy;
    }

    public void accept(FeatureVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(FeatureFunctor<T> visitor) {
        return visitor.apply(this);
    }

    public void accept(GMLVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(GMLFunctor<T> visitor) {
        return visitor.apply(this);
    }

}
