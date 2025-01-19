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

package org.citygml4j.core.model.cityobjectgroup;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.model.core.*;
import org.citygml4j.core.model.deprecated.cityobjectgroup.DeprecatedPropertiesOfCityObjectGroup;
import org.citygml4j.core.model.deprecated.cityobjectgroup.GroupMember;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
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

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
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
    public boolean isSetFunctions() {
        return functions != null && !functions.isEmpty();
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
    public boolean isSetUsages() {
        return usages != null && !usages.isEmpty();
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

    public boolean isSetGroupMembers() {
        return groupMembers != null && !groupMembers.isEmpty();
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
        return super.getDeprecatedProperties(DeprecatedPropertiesOfCityObjectGroup.class);
    }

    @Override
    protected DeprecatedPropertiesOfCityObjectGroup createDeprecatedProperties() {
        return new DeprecatedPropertiesOfCityObjectGroup();
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityObjectGroup properties = getDeprecatedProperties();

            if (properties.isSetGroupMembers()) {
                for (GroupMember member : properties.getGroupMembers()) {
                    if (member.getObject() != null)
                        envelope.include(member.getObject().computeEnvelope(options));
                }
            }

            if (properties.getGeometry() != null && properties.getGeometry().getObject() != null)
                envelope.include(properties.getGeometry().getObject().computeEnvelope());
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityObjectGroup properties = getDeprecatedProperties();

            geometryInfo.addGeometry(properties.getGeometry());
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

}
