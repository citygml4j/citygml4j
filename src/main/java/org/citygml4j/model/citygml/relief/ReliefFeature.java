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
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class ReliefFeature extends AbstractCityObject implements ReliefModuleComponent {
    private int lod;
    private List<ReliefComponentProperty> reliefComponent;
    private List<ADEComponent> ade;

    public ReliefFeature() {

    }

    public ReliefFeature(Module module) {
        super(module);
    }

    public void addGenericApplicationPropertyOfReliefFeature(ADEComponent ade) {
        getGenericApplicationPropertyOfReliefFeature().add(ade);
    }

    public void addReliefComponent(ReliefComponentProperty reliefComponent) {
        getReliefComponent().add(reliefComponent);
    }

    public List<ADEComponent> getGenericApplicationPropertyOfReliefFeature() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public int getLod() {
        return lod;
    }

    public List<ReliefComponentProperty> getReliefComponent() {
        if (reliefComponent == null)
            reliefComponent = new ChildList<>(this);

        return reliefComponent;
    }

    public boolean isSetGenericApplicationPropertyOfReliefFeature() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetLod() {
        return true;
    }

    public boolean isSetReliefComponent() {
        return reliefComponent != null && !reliefComponent.isEmpty();
    }

    public void setGenericApplicationPropertyOfReliefFeature(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setLod(int lod) {
        if (lod >= 0 && lod <= 4)
            this.lod = lod;
    }

    public void setReliefComponent(List<ReliefComponentProperty> reliefComponent) {
        this.reliefComponent = new ChildList<>(this, reliefComponent);
    }

    public void unsetGenericApplicationPropertyOfReliefFeature() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfReliefFeature(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfReliefFeature() && this.ade.remove(ade);
    }

    public void unsetReliefComponent() {
        reliefComponent = ModelObjects.setNull(reliefComponent);
    }

    public boolean unsetReliefComponent(ReliefComponentProperty reliefComponent) {
        return isSetReliefComponent() && this.reliefComponent.remove(reliefComponent);
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.RELIEF_FEATURE;
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        if (isSetReliefComponent()) {
            for (ReliefComponentProperty reliefComponentProperty : reliefComponent) {
                if (reliefComponentProperty.isSetObject()) {
                    boundedBy.updateEnvelope(reliefComponentProperty.getObject().calcBoundedBy(options).getEnvelope());
                } else {
                    // xlink
                }
            }
        }

        if (isSetGenericApplicationPropertyOfReliefFeature()) {
            for (ADEComponent ade : getGenericApplicationPropertyOfReliefFeature()) {
                if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
                    boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject) ade, options).getEnvelope());
            }
        }

        if (options.isAssignResultToFeatures())
            setBoundedBy(boundedBy);

        return boundedBy;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new ReliefFeature(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        ReliefFeature copy = (target == null) ? new ReliefFeature() : (ReliefFeature) target;
        super.copyTo(copy, copyBuilder);

        if (isSetLod())
            copy.setLod(copyBuilder.copy(lod));

        if (isSetReliefComponent()) {
            for (ReliefComponentProperty part : reliefComponent) {
                ReliefComponentProperty copyPart = (ReliefComponentProperty) copyBuilder.copy(part);
                copy.addReliefComponent(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetGenericApplicationPropertyOfReliefFeature()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfReliefFeature(copyPart);

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
