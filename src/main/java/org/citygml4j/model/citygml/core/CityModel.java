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
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class CityModel extends AbstractFeatureCollection implements CoreModuleComponent {
    private List<CityObjectMember> cityObjectMember;
    private List<AppearanceMember> appearanceMember;
    private List<ADEComponent> ade;

    public CityModel() {

    }

    public CityModel(Module module) {
        super(module);
    }

    public void addAppearanceMember(AppearanceMember appearanceMember) {
        getAppearanceMember().add(appearanceMember);
    }

    public void addCityObjectMember(CityObjectMember cityObjectMember) {
        getCityObjectMember().add(cityObjectMember);
    }

    public void addGenericApplicationPropertyOfCityModel(ADEComponent ade) {
        getGenericApplicationPropertyOfCityModel().add(ade);
    }

    public List<AppearanceMember> getAppearanceMember() {
        if (appearanceMember == null)
            appearanceMember = new ChildList<>(this);

        return appearanceMember;
    }

    public List<CityObjectMember> getCityObjectMember() {
        if (cityObjectMember == null)
            cityObjectMember = new ChildList<>(this);

        return cityObjectMember;
    }

    public List<ADEComponent> getGenericApplicationPropertyOfCityModel() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public boolean isSetAppearanceMember() {
        return appearanceMember != null && !appearanceMember.isEmpty();
    }

    public boolean isSetCityObjectMember() {
        return cityObjectMember != null && !cityObjectMember.isEmpty();
    }

    public boolean isSetGenericApplicationPropertyOfCityModel() {
        return ade != null && !ade.isEmpty();
    }

    public void setAppearanceMember(List<AppearanceMember> appearanceMember) {
        this.appearanceMember = new ChildList<>(this, appearanceMember);
    }

    public void setCityObjectMember(List<CityObjectMember> cityObjectMember) {
        this.cityObjectMember = new ChildList<>(this, cityObjectMember);
    }

    public void setGenericApplicationPropertyOfCityModel(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void unsetAppearanceMember() {
        appearanceMember = ModelObjects.setNull(appearanceMember);
    }

    public boolean unsetAppearanceMember(AppearanceMember appearanceMember) {
        return isSetAppearanceMember() && this.appearanceMember.remove(appearanceMember);
    }

    public void unsetCityObjectMember() {
        cityObjectMember = ModelObjects.setNull(cityObjectMember);
    }

    public boolean unsetCityObjectMember(CityObjectMember cityObjectMember) {
        return isSetCityObjectMember() && this.cityObjectMember.remove(cityObjectMember);
    }

    public void unsetGenericApplicationPropertyOfCityModel() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfCityModel(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfCityModel() && this.ade.remove(ade);
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.CITY_MODEL;
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        if (isSetCityObjectMember()) {
            for (CityObjectMember member : cityObjectMember) {
                if (member.isSetFeature()) {
                    boundedBy.updateEnvelope(member.getFeature().calcBoundedBy(options).getEnvelope());
                } else {
                    // xlink
                }
            }
        }

        if (isSetFeatureMember()) {
            for (FeatureMember featureMember : getFeatureMember()) {
                if (featureMember.isSetFeature()) {
                    boundedBy.updateEnvelope(featureMember.getFeature().calcBoundedBy(options).getEnvelope());
                } else {
                    // xlink
                }
            }
        }

        if (isSetFeatureMembers()) {
            for (AbstractFeature abstractFeature : getFeatureMembers().getFeature()) {
                if (abstractFeature != null)
                    boundedBy.updateEnvelope(abstractFeature.calcBoundedBy(options).getEnvelope());
            }
        }

        if (isSetGenericApplicationPropertyOfCityModel()) {
            for (ADEComponent ade : getGenericApplicationPropertyOfCityModel()) {
                if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
                    boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject) ade, options).getEnvelope());
            }
        }

        if (options.isAssignResultToFeatures())
            setBoundedBy(boundedBy);

        return boundedBy;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new CityModel(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        CityModel copy = (target == null) ? new CityModel() : (CityModel) target;
        super.copyTo(copy, copyBuilder);

        if (isSetCityObjectMember()) {
            for (CityObjectMember part : cityObjectMember) {
                CityObjectMember copyPart = (CityObjectMember) copyBuilder.copy(part);
                copy.addCityObjectMember(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetAppearanceMember()) {
            for (AppearanceMember part : appearanceMember) {
                AppearanceMember copyPart = (AppearanceMember) copyBuilder.copy(part);
                copy.addAppearanceMember(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetGenericApplicationPropertyOfCityModel()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfCityModel(copyPart);

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
