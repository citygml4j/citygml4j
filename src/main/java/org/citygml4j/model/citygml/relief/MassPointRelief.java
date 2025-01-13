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
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class MassPointRelief extends AbstractReliefComponent {
    private MultiPointProperty reliefPoints;
    private List<ADEComponent> ade;

    public MassPointRelief() {

    }

    public MassPointRelief(Module module) {
        super(module);
    }

    public void addGenericApplicationPropertyOfMassPointRelief(ADEComponent ade) {
        getGenericApplicationPropertyOfMassPointRelief().add(ade);
    }

    public List<ADEComponent> getGenericApplicationPropertyOfMassPointRelief() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public MultiPointProperty getReliefPoints() {
        return reliefPoints;
    }

    public boolean isSetGenericApplicationPropertyOfMassPointRelief() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetReliefPoints() {
        return reliefPoints != null;
    }

    public void setGenericApplicationPropertyOfMassPointRelief(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setReliefPoints(MultiPointProperty reliefPoints) {
        this.reliefPoints = ModelObjects.setParent(reliefPoints, this);
    }

    public void unsetGenericApplicationPropertyOfMassPointRelief() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfMassPointRelief(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfMassPointRelief() && this.ade.remove(ade);
    }

    public void unsetReliefPoints() {
        reliefPoints = ModelObjects.setNull(reliefPoints);
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.MASSPOINT_RELIEF;
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        if (isSetReliefPoints()) {
            if (reliefPoints.isSetMultiPoint()) {
                boundedBy.updateEnvelope(reliefPoints.getMultiPoint().calcBoundingBox());
            } else {
                // xlink
            }
        }

        if (isSetGenericApplicationPropertyOfMassPointRelief()) {
            for (ADEComponent ade : getGenericApplicationPropertyOfMassPointRelief()) {
                if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
                    boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject) ade, options).getEnvelope());
            }
        }

        if (options.isAssignResultToFeatures())
            setBoundedBy(boundedBy);

        return boundedBy;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new MassPointRelief(), copyBuilder);
    }

    @Override
    public LodRepresentation getLodRepresentation() {
        LodRepresentation lodRepresentation = new LodRepresentation();
        lodRepresentation.addRepresentation(getLod(), reliefPoints);

        return lodRepresentation;
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        MassPointRelief copy = (target == null) ? new MassPointRelief() : (MassPointRelief) target;
        super.copyTo(copy, copyBuilder);

        if (isSetReliefPoints()) {
            copy.setReliefPoints((MultiPointProperty) copyBuilder.copy(reliefPoints));
            if (copy.getReliefPoints() == reliefPoints)
                reliefPoints.setParent(this);
        }

        if (isSetGenericApplicationPropertyOfMassPointRelief()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfMassPointRelief(copyPart);

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
