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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public abstract class AbstractOpening extends AbstractCityObject implements BridgeModuleComponent {
    private MultiSurfaceProperty lod3MultiSurface;
    private MultiSurfaceProperty lod4MultiSurface;
    private ImplicitRepresentationProperty lod3ImplicitRepresentation;
    private ImplicitRepresentationProperty lod4ImplicitRepresentation;
    private List<ADEComponent> ade;

    public AbstractOpening() {

    }

    public AbstractOpening(Module module) {
        super(module);
    }

    public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    public boolean isSetLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation != null;
    }

    public boolean isSetLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation != null;
    }

    public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
        this.lod3ImplicitRepresentation = ModelObjects.setParent(lod3ImplicitRepresentation, this);
    }

    public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
        this.lod4ImplicitRepresentation = ModelObjects.setParent(lod4ImplicitRepresentation, this);
    }

    public void unsetLod3ImplicitRepresentation() {
        lod3ImplicitRepresentation = ModelObjects.setNull(lod3ImplicitRepresentation);
    }

    public void unsetLod4ImplicitRepresentation() {
        lod4ImplicitRepresentation = ModelObjects.setNull(lod4ImplicitRepresentation);
    }

    public void addGenericApplicationPropertyOfOpening(ADEComponent ade) {
        getGenericApplicationPropertyOfOpening().add(ade);
    }

    public List<ADEComponent> getGenericApplicationPropertyOfOpening() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public MultiSurfaceProperty getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public boolean isSetGenericApplicationPropertyOfOpening() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetLod3MultiSurface() {
        return lod3MultiSurface != null;
    }

    public boolean isSetLod4MultiSurface() {
        return lod4MultiSurface != null;
    }

    public void setGenericApplicationPropertyOfOpening(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
        this.lod3MultiSurface = ModelObjects.setParent(lod3MultiSurface, this);
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = ModelObjects.setParent(lod4MultiSurface, this);
    }

    public void unsetGenericApplicationPropertyOfOpening() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfOpening(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfOpening() && this.ade.remove(ade);
    }

    public void unsetLod3MultiSurface() {
        lod3MultiSurface = ModelObjects.setNull(lod3MultiSurface);
    }

    public void unsetLod4MultiSurface() {
        lod4MultiSurface = ModelObjects.setNull(lod4MultiSurface);
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        GeometryProperty<? extends AbstractGeometry> geometryProperty = null;
        for (int lod = 3; lod < 5; lod++) {
            switch (lod) {
                case 3:
                    geometryProperty = lod3MultiSurface;
                    break;
                case 4:
                    geometryProperty = lod4MultiSurface;
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
        for (int lod = 3; lod < 5; lod++) {
            switch (lod) {
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

        if (isSetGenericApplicationPropertyOfOpening()) {
            for (ADEComponent ade : getGenericApplicationPropertyOfOpening()) {
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

        lodRepresentation.addRepresentation(3, lod3MultiSurface);
        lodRepresentation.addRepresentation(4, lod4MultiSurface);

        lodRepresentation.addRepresentation(3, lod3ImplicitRepresentation);
        lodRepresentation.addRepresentation(4, lod4ImplicitRepresentation);

        return lodRepresentation;
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        if (target == null)
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

        AbstractOpening copy = (AbstractOpening) target;
        super.copyTo(copy, copyBuilder);

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

        if (isSetGenericApplicationPropertyOfOpening()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfOpening(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        return copy;
    }

}
