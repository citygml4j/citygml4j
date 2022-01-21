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

package org.citygml4j.model.tunnel;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.construction.RelationToConstruction;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfAbstractTunnel;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractTunnel extends AbstractConstruction implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<TunnelConstructiveElementProperty> tunnelConstructiveElements;
    private List<TunnelInstallationProperty> tunnelInstallations;
    private List<HollowSpaceProperty> hollowSpaces;
    private List<TunnelFurnitureProperty> tunnelFurniture;

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

    public List<TunnelConstructiveElementProperty> getTunnelConstructiveElements() {
        if (tunnelConstructiveElements == null)
            tunnelConstructiveElements = new ChildList<>(this);

        return tunnelConstructiveElements;
    }

    public void setTunnelConstructiveElements(List<TunnelConstructiveElementProperty> tunnelConstructiveElements) {
        this.tunnelConstructiveElements = asChild(tunnelConstructiveElements);
    }

    public List<TunnelInstallationProperty> getTunnelInstallations() {
        if (tunnelInstallations == null)
            tunnelInstallations = new ChildList<>(this);

        return tunnelInstallations;
    }

    public void setTunnelInstallations(List<TunnelInstallationProperty> tunnelInstallations) {
        this.tunnelInstallations = asChild(tunnelInstallations);
    }

    public List<HollowSpaceProperty> getHollowSpaces() {
        if (hollowSpaces == null)
            hollowSpaces = new ChildList<>(this);

        return hollowSpaces;
    }

    public void setHollowSpaces(List<HollowSpaceProperty> hollowSpaces) {
        this.hollowSpaces = asChild(hollowSpaces);
    }

    public List<TunnelFurnitureProperty> getTunnelFurniture() {
        if (tunnelFurniture == null)
            tunnelFurniture = new ChildList<>(this);

        return tunnelFurniture;
    }

    public void setTunnelFurniture(List<TunnelFurnitureProperty> tunnelFurniture) {
        this.tunnelFurniture = asChild(tunnelFurniture);
    }

    @Override
    public DeprecatedPropertiesOfAbstractTunnel getDeprecatedProperties() {
        return (DeprecatedPropertiesOfAbstractTunnel) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfAbstractTunnel createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractTunnel();
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (tunnelConstructiveElements != null) {
            for (TunnelConstructiveElementProperty member : tunnelConstructiveElements) {
                if (member.getObject() != null)
                    envelope.include(member.getObject().computeEnvelope(options));
            }
        }

        if (tunnelInstallations != null) {
            for (TunnelInstallationProperty member : tunnelInstallations) {
                if (member.getObject() != null && member.getObject().getRelationToConstruction() != RelationToConstruction.INSIDE)
                    envelope.include(member.getObject().computeEnvelope(options));
            }
        }

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTunnel properties = getDeprecatedProperties();

            for (TunnelPartProperty property : properties.getConsistsOfTunnelParts()) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }

            if (properties.getLod1MultiSurface() != null && properties.getLod1MultiSurface().getObject() != null)
                envelope.include(properties.getLod1MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4MultiCurve() != null && properties.getLod4MultiCurve().getObject() != null)
                envelope.include(properties.getLod4MultiCurve().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4Solid() != null && properties.getLod4Solid().getObject() != null)
                envelope.include(properties.getLod4Solid().getObject().computeEnvelope());
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTunnel properties = getDeprecatedProperties();

            geometryInfo.addGeometry(1, properties.getLod1MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4MultiCurve());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4Solid());
        }
    }
}
