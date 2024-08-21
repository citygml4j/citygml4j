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
package org.citygml4j.model.citygml.transportation;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
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
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class TrafficArea extends AbstractTransportationObject implements StandardObjectClassifier {
    private Code clazz;
    private List<Code> function;
    private List<Code> usage;
    private Code surfaceMaterial;
    private MultiSurfaceProperty lod2MultiSurface;
    private MultiSurfaceProperty lod3MultiSurface;
    private MultiSurfaceProperty lod4MultiSurface;
    private List<ADEComponent> ade;

    public TrafficArea() {

    }

    public TrafficArea(Module module) {
        super(module);
    }

    public void addFunction(Code function) {
        getFunction().add(function);
    }

    public void addUsage(Code usage) {
        getUsage().add(usage);
    }

    public void addGenericApplicationPropertyOfTrafficArea(ADEComponent ade) {
        getGenericApplicationPropertyOfTrafficArea().add(ade);
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

    public List<ADEComponent> getGenericApplicationPropertyOfTrafficArea() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public MultiSurfaceProperty getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    public MultiSurfaceProperty getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public Code getSurfaceMaterial() {
        return surfaceMaterial;
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

    public boolean isSetGenericApplicationPropertyOfTrafficArea() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetLod2MultiSurface() {
        return lod2MultiSurface != null;
    }

    public boolean isSetLod3MultiSurface() {
        return lod3MultiSurface != null;
    }

    public boolean isSetLod4MultiSurface() {
        return lod4MultiSurface != null;
    }

    public boolean isSetSurfaceMaterial() {
        return surfaceMaterial != null;
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

    public void setGenericApplicationPropertyOfTrafficArea(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
        this.lod2MultiSurface = ModelObjects.setParent(lod2MultiSurface, this);
    }

    public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
        this.lod3MultiSurface = ModelObjects.setParent(lod3MultiSurface, this);
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = ModelObjects.setParent(lod4MultiSurface, this);
    }

    public void setSurfaceMaterial(Code surfaceMaterial) {
        this.surfaceMaterial = ModelObjects.setParent(surfaceMaterial, this);
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

    public void unsetGenericApplicationPropertyOfTrafficArea() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfTrafficArea(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfTrafficArea() && this.ade.remove(ade);
    }

    public void unsetLod2MultiSurface() {
        lod2MultiSurface = ModelObjects.setNull(lod2MultiSurface);
    }

    public void unsetLod3MultiSurface() {
        lod3MultiSurface = ModelObjects.setNull(lod3MultiSurface);
    }

    public void unsetLod4MultiSurface() {
        lod4MultiSurface = ModelObjects.setNull(lod4MultiSurface);
    }

    public void unsetSurfaceMaterial() {
        surfaceMaterial = ModelObjects.setNull(surfaceMaterial);
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.TRAFFIC_AREA;
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        MultiSurfaceProperty multiSurfaceProperty = null;
        for (int lod = 2; lod < 5; lod++) {
            switch (lod) {
                case 2:
                    multiSurfaceProperty = lod2MultiSurface;
                    break;
                case 3:
                    multiSurfaceProperty = lod3MultiSurface;
                    break;
                case 4:
                    multiSurfaceProperty = lod4MultiSurface;
                    break;
            }

            if (multiSurfaceProperty != null) {
                if (multiSurfaceProperty.isSetMultiSurface()) {
                    boundedBy.updateEnvelope(multiSurfaceProperty.getMultiSurface().calcBoundingBox());
                } else {
                    // xlink
                }
            }
        }

        if (isSetGenericApplicationPropertyOfTrafficArea()) {
            for (ADEComponent ade : getGenericApplicationPropertyOfTrafficArea()) {
                if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
                    boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject) ade, options).getEnvelope());
            }
        }

        if (options.isAssignResultToFeatures())
            setBoundedBy(boundedBy);

        return boundedBy;
    }

    @Override
    public LodRepresentation getLodRepresentation() {
        LodRepresentation lodRepresentation = new LodRepresentation();

        lodRepresentation.addRepresentation(2, lod2MultiSurface);
        lodRepresentation.addRepresentation(3, lod3MultiSurface);
        lodRepresentation.addRepresentation(4, lod4MultiSurface);

        return lodRepresentation;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new TrafficArea(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        TrafficArea copy = (target == null) ? new TrafficArea() : (TrafficArea) target;
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

        if (isSetSurfaceMaterial())
            copy.setSurfaceMaterial((Code) copyBuilder.copy(surfaceMaterial));

        if (isSetLod2MultiSurface()) {
            copy.setLod2MultiSurface((MultiSurfaceProperty) copyBuilder.copy(lod2MultiSurface));
            if (copy.getLod2MultiSurface() == lod2MultiSurface)
                lod2MultiSurface.setParent(this);
        }

        if (isSetLod3MultiSurface()) {
            copy.setLod3MultiSurface((MultiSurfaceProperty) copyBuilder.copy(lod3MultiSurface));
            if (copy.getLod3MultiSurface() == lod3MultiSurface)
                lod3MultiSurface.setParent(this);
        }

        if (isSetLod4MultiSurface()) {
            copy.setLod4MultiSurface((MultiSurfaceProperty) copyBuilder.copy(lod4MultiSurface));
            if (copy.getLod4MultiSurface() == lod4MultiSurface)
                lod4MultiSurface.setParent(this);
        }

        if (isSetGenericApplicationPropertyOfTrafficArea()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfTrafficArea(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
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
