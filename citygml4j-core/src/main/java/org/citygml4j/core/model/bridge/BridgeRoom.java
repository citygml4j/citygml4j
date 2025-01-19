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

package org.citygml4j.core.model.bridge;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.construction.AbstractConstructionSurface;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.core.StandardObjectClassifier;
import org.citygml4j.core.model.deprecated.bridge.DeprecatedPropertiesOfBridgeRoom;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BridgeRoom extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<BridgeFurnitureProperty> bridgeFurniture;
    private List<BridgeInstallationProperty> bridgeInstallations;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return AbstractConstructionSurface.class.isAssignableFrom(type)
                || ClosureSurface.class.isAssignableFrom(type)
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

    public List<BridgeFurnitureProperty> getBridgeFurniture() {
        if (bridgeFurniture == null)
            bridgeFurniture = new ChildList<>(this);

        return bridgeFurniture;
    }

    public boolean isSetBridgeFurniture() {
        return bridgeFurniture != null && !bridgeFurniture.isEmpty();
    }

    public void setBridgeFurniture(List<BridgeFurnitureProperty> bridgeFurniture) {
        this.bridgeFurniture = asChild(bridgeFurniture);
    }

    public List<BridgeInstallationProperty> getBridgeInstallations() {
        if (bridgeInstallations == null)
            bridgeInstallations = new ChildList<>(this);

        return bridgeInstallations;
    }

    public boolean isSetBridgeInstallations() {
        return bridgeInstallations != null && !bridgeInstallations.isEmpty();
    }

    public void setBridgeInstallations(List<BridgeInstallationProperty> bridgeInstallations) {
        this.bridgeInstallations = asChild(bridgeInstallations);
    }

    @Override
    public DeprecatedPropertiesOfBridgeRoom getDeprecatedProperties() {
        return super.getDeprecatedProperties(DeprecatedPropertiesOfBridgeRoom.class);
    }

    @Override
    protected DeprecatedPropertiesOfBridgeRoom createDeprecatedProperties() {
        return new DeprecatedPropertiesOfBridgeRoom();
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (bridgeFurniture != null) {
            for (BridgeFurnitureProperty property : bridgeFurniture) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (bridgeInstallations != null) {
            for (BridgeInstallationProperty property : bridgeInstallations) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeRoom properties = getDeprecatedProperties();

            if (properties.getLod4Solid() != null && properties.getLod4Solid().getObject() != null)
                envelope.include(properties.getLod4Solid().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeRoom properties = getDeprecatedProperties();

            geometryInfo.addGeometry(4, properties.getLod4Solid());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
