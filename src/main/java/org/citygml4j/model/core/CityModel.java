/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.core;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CityModel extends AbstractFeatureWithLifespan {
    private EngineeringCRSProperty engineeringCRS;
    private List<AbstractCityObjectProperty> cityObjectMembers;
    private List<AbstractAppearanceProperty> appearanceMembers;
    private List<AbstractVersionProperty> versionMembers;
    private List<AbstractVersionTransitionProperty> versionTransitionMembers;
    private List<AbstractFeatureProperty> featureMembers;

    public EngineeringCRSProperty getEngineeringCRS() {
        return engineeringCRS;
    }

    public void setEngineeringCRS(EngineeringCRSProperty engineeringCRS) {
        this.engineeringCRS = asChild(engineeringCRS);
    }

    public List<AbstractCityObjectProperty> getCityObjectMembers() {
        if (cityObjectMembers == null)
            cityObjectMembers = new ChildList<>(this);

        return cityObjectMembers;
    }

    public void setCityObjectMembers(List<AbstractCityObjectProperty> cityObjectMembers) {
        this.cityObjectMembers = asChild(cityObjectMembers);
    }

    public List<AbstractAppearanceProperty> getAppearanceMembers() {
        if (appearanceMembers == null)
            appearanceMembers = new ChildList<>(this);

        return appearanceMembers;
    }

    public void setAppearanceMembers(List<AbstractAppearanceProperty> appearanceMembers) {
        this.appearanceMembers = asChild(appearanceMembers);
    }

    public List<AbstractVersionProperty> getVersionMembers() {
        if (versionMembers == null)
            versionMembers = new ChildList<>(this);

        return versionMembers;
    }

    public void setVersionMembers(List<AbstractVersionProperty> versionMembers) {
        this.versionMembers = asChild(versionMembers);
    }

    public List<AbstractVersionTransitionProperty> getVersionTransitionMembers() {
        if (versionTransitionMembers == null)
            versionTransitionMembers = new ChildList<>(this);

        return versionTransitionMembers;
    }

    public void setVersionTransitionMembers(List<AbstractVersionTransitionProperty> versionTransitionMembers) {
        this.versionTransitionMembers = asChild(versionTransitionMembers);
    }

    public List<AbstractFeatureProperty> getFeatureMembers() {
        if (featureMembers == null)
            featureMembers = new ChildList<>(this);

        return featureMembers;
    }

    public void setFeatureMembers(List<AbstractFeatureProperty> featureMembers) {
        this.featureMembers = asChild(featureMembers);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (cityObjectMembers != null) {
            for (AbstractCityObjectProperty property : cityObjectMembers) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (featureMembers != null) {
            for (AbstractFeatureProperty property : featureMembers) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
