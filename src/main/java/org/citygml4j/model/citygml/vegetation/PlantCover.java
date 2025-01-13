/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.vegetation;

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
import org.citygml4j.model.gml.geometry.aggregates.MultiSolidProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class PlantCover extends AbstractVegetationObject implements StandardObjectClassifier {
    private Code clazz;
    private List<Code> function;
    private List<Code> usage;
    private Length averageHeight;
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiSurfaceProperty lod2MultiSurface;
    private MultiSurfaceProperty lod3MultiSurface;
    private MultiSurfaceProperty lod4MultiSurface;
    private MultiSolidProperty lod1MultiSolid;
    private MultiSolidProperty lod2MultiSolid;
    private MultiSolidProperty lod3MultiSolid;
    private MultiSolidProperty lod4MultiSolid;
    private List<ADEComponent> ade;

    public PlantCover() {

    }

    public PlantCover(Module module) {
        super(module);
    }

    public void addFunction(Code function) {
        getFunction().add(function);
    }

    public void addUsage(Code usage) {
        getUsage().add(usage);
    }

    public void addGenericApplicationPropertyOfPlantCover(ADEComponent ade) {
        getGenericApplicationPropertyOfPlantCover().add(ade);
    }

    public Length getAverageHeight() {
        return averageHeight;
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

    public List<ADEComponent> getGenericApplicationPropertyOfPlantCover() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public MultiSolidProperty getLod1MultiSolid() {
        return lod1MultiSolid;
    }

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public MultiSolidProperty getLod2MultiSolid() {
        return lod2MultiSolid;
    }

    public MultiSurfaceProperty getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    public MultiSolidProperty getLod3MultiSolid() {
        return lod3MultiSolid;
    }

    public MultiSurfaceProperty getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public MultiSolidProperty getLod4MultiSolid() {
        return lod4MultiSolid;
    }

    public boolean isSetAverageHeight() {
        return averageHeight != null;
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

    public boolean isSetGenericApplicationPropertyOfPlantCover() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetLod1MultiSolid() {
        return lod1MultiSolid != null;
    }

    public boolean isSetLod1MultiSurface() {
        return lod1MultiSurface != null;
    }

    public boolean isSetLod2MultiSolid() {
        return lod2MultiSolid != null;
    }

    public boolean isSetLod2MultiSurface() {
        return lod2MultiSurface != null;
    }

    public boolean isSetLod3MultiSolid() {
        return lod3MultiSolid != null;
    }

    public boolean isSetLod3MultiSurface() {
        return lod3MultiSurface != null;
    }

    public boolean isSetLod4MultiSurface() {
        return lod4MultiSurface != null;
    }

    public boolean isSetLod4MultiSolid() {
        return lod4MultiSolid != null;
    }

    public void setAverageHeight(Length averageHeight) {
        this.averageHeight = ModelObjects.setParent(averageHeight, this);
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

    public void setGenericApplicationPropertyOfPlantCover(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid) {
        this.lod1MultiSolid = ModelObjects.setParent(lod1MultiSolid, this);
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = ModelObjects.setParent(lod1MultiSurface, this);
    }

    public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid) {
        this.lod2MultiSolid = ModelObjects.setParent(lod2MultiSolid, this);
    }

    public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
        this.lod2MultiSurface = ModelObjects.setParent(lod2MultiSurface, this);
    }

    public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid) {
        this.lod3MultiSolid = ModelObjects.setParent(lod3MultiSolid, this);
    }

    public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
        this.lod3MultiSurface = ModelObjects.setParent(lod3MultiSurface, this);
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = ModelObjects.setParent(lod4MultiSurface, this);
    }

    public void setLod4MultiSolid(MultiSolidProperty lod4MultiSolid) {
        this.lod3MultiSolid = ModelObjects.setParent(lod4MultiSolid, this);
    }

    public void unsetAverageHeight() {
        averageHeight = ModelObjects.setNull(averageHeight);
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

    public void unsetGenericApplicationPropertyOfPlantCover() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfPlantCover(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfPlantCover() && this.ade.remove(ade);
    }

    public void unsetLod1MultiSolid() {
        lod1MultiSolid = ModelObjects.setNull(lod1MultiSolid);
    }

    public void unsetLod1MultiSurface() {
        lod1MultiSurface = ModelObjects.setNull(lod1MultiSurface);
    }

    public void unsetLod2MultiSolid() {
        lod2MultiSolid = ModelObjects.setNull(lod2MultiSolid);
    }

    public void unsetLod2MultiSurface() {
        lod2MultiSurface = ModelObjects.setNull(lod2MultiSurface);
    }

    public void unsetLod3MultiSolid() {
        lod3MultiSolid = ModelObjects.setNull(lod3MultiSolid);
    }

    public void unsetLod3MultiSurface() {
        lod3MultiSurface = ModelObjects.setNull(lod3MultiSurface);
    }

    public void unsetLod4MultiSurface() {
        lod4MultiSurface = ModelObjects.setNull(lod4MultiSurface);
    }

    public void unsetLod4MultiSolid() {
        lod4MultiSolid = ModelObjects.setNull(lod4MultiSolid);
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        MultiSolidProperty multiSolidProperty = null;
        for (int lod = 1; lod < 5; lod++) {
            switch (lod) {
                case 1:
                    multiSolidProperty = lod1MultiSolid;
                    break;
                case 2:
                    multiSolidProperty = lod2MultiSolid;
                    break;
                case 3:
                    multiSolidProperty = lod3MultiSolid;
                    break;
                case 4:
                    multiSolidProperty = lod4MultiSolid;
                    break;
            }

            if (multiSolidProperty != null) {
                if (multiSolidProperty.isSetMultiSolid()) {
                    boundedBy.updateEnvelope(multiSolidProperty.getMultiSolid().calcBoundingBox());
                } else {
                    // xlink
                }
            }
        }

        MultiSurfaceProperty multiSurfaceProperty = null;
        for (int lod = 1; lod < 5; lod++) {
            switch (lod) {
                case 1:
                    multiSurfaceProperty = lod1MultiSurface;
                    break;
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

        if (isSetGenericApplicationPropertyOfPlantCover()) {
            for (ADEComponent ade : getGenericApplicationPropertyOfPlantCover()) {
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

        lodRepresentation.addRepresentation(1, lod1MultiSolid);
        lodRepresentation.addRepresentation(2, lod2MultiSolid);
        lodRepresentation.addRepresentation(3, lod3MultiSolid);
        lodRepresentation.addRepresentation(4, lod4MultiSolid);

        lodRepresentation.addRepresentation(1, lod1MultiSurface);
        lodRepresentation.addRepresentation(2, lod2MultiSurface);
        lodRepresentation.addRepresentation(3, lod3MultiSurface);
        lodRepresentation.addRepresentation(4, lod4MultiSurface);

        return lodRepresentation;
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.PLANT_COVER;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new PlantCover(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        PlantCover copy = (target == null) ? new PlantCover() : (PlantCover) target;
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

        if (isSetAverageHeight()) {
            copy.setAverageHeight((Length) copyBuilder.copy(averageHeight));
            if (copy.getAverageHeight() == averageHeight)
                averageHeight.setParent(this);
        }

        if (isSetLod1MultiSurface()) {
            copy.setLod1MultiSurface((MultiSurfaceProperty) copyBuilder.copy(lod1MultiSurface));
            if (copy.getLod1MultiSurface() == lod1MultiSurface)
                lod1MultiSurface.setParent(this);
        }

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

        if (isSetLod1MultiSolid()) {
            copy.setLod1MultiSolid((MultiSolidProperty) copyBuilder.copy(lod1MultiSolid));
            if (copy.getLod1MultiSolid() == lod1MultiSolid)
                lod1MultiSolid.setParent(this);
        }

        if (isSetLod2MultiSolid()) {
            copy.setLod2MultiSolid((MultiSolidProperty) copyBuilder.copy(lod2MultiSolid));
            if (copy.getLod2MultiSolid() == lod2MultiSolid)
                lod2MultiSolid.setParent(this);
        }

        if (isSetLod3MultiSolid()) {
            copy.setLod3MultiSolid((MultiSolidProperty) copyBuilder.copy(lod3MultiSolid));
            if (copy.getLod3MultiSolid() == lod3MultiSolid)
                lod3MultiSolid.setParent(this);
        }

        if (isSetLod4MultiSolid()) {
            copy.setLod4MultiSolid((MultiSolidProperty) copyBuilder.copy(lod4MultiSolid));
            if (copy.getLod4MultiSolid() == lod4MultiSolid)
                lod4MultiSolid.setParent(this);
        }

        if (isSetGenericApplicationPropertyOfPlantCover()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfPlantCover(copyPart);

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
