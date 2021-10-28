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

package org.citygml4j.model.cityobjectgroup;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.common.TopLevelFeature;
import org.citygml4j.model.core.*;
import org.citygml4j.model.deprecated.cityobjectgroup.DeprecatedPropertiesOfCityObjectGroup;
import org.citygml4j.model.deprecated.cityobjectgroup.GroupMember;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CityObjectGroup extends AbstractLogicalSpace implements TopLevelFeature, StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<RoleProperty> groupMembers;
    private AbstractCityObjectReference groupParent;
    private List<ADEOfCityObjectGroup> adeOfCityObjectGroup;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    @Override
    public Code getClassifier() {
        return classifier;
    }

    @Override
    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public List<Code> getFunctions() {
        if (functions == null)
            functions = new ChildList<>(this);

        return functions;
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null)
            usages = new ChildList<>(this);

        return usages;
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public List<RoleProperty> getGroupMembers() {
        if (groupMembers == null)
            groupMembers = new ChildList<>(this);

        return groupMembers;
    }

    public void setGroupMembers(List<RoleProperty> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public AbstractCityObjectReference getGroupParent() {
        return groupParent;
    }

    public void setGroupParent(AbstractCityObjectReference groupParent) {
        this.groupParent = asChild(groupParent);
    }

    @Override
    public DeprecatedPropertiesOfCityObjectGroup getDeprecatedProperties() {
        return (DeprecatedPropertiesOfCityObjectGroup) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfCityObjectGroup createDeprecatedProperties() {
        return new DeprecatedPropertiesOfCityObjectGroup();
    }

    public List<ADEOfCityObjectGroup> getADEOfCityObjectGroup() {
        if (adeOfCityObjectGroup == null)
            adeOfCityObjectGroup = new ChildList<>(this);

        return adeOfCityObjectGroup;
    }

    public void setADEOfCityObjectGroup(List<ADEOfCityObjectGroup> adeOfCityObjectGroup) {
        this.adeOfCityObjectGroup = asChild(adeOfCityObjectGroup);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityObjectGroup properties = getDeprecatedProperties();

            for (GroupMember member : properties.getGroupMembers()) {
                if (member.getObject() != null)
                    envelope.include(member.getObject().computeEnvelope(options));
            }

            if (properties.getGeometry() != null && properties.getGeometry().getObject() != null)
                envelope.include(properties.getGeometry().getObject().computeEnvelope());
        }

        if (adeOfCityObjectGroup != null) {
            for (ADEOfCityObjectGroup container : adeOfCityObjectGroup)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityObjectGroup properties = getDeprecatedProperties();

            geometryInfo.addGeometry(properties.getGeometry());
        }

        if (adeOfCityObjectGroup != null) {
            for (ADEOfCityObjectGroup container : adeOfCityObjectGroup)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

}
