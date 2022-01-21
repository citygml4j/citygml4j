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
import org.citygml4j.model.construction.AbstractFurniture;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfTunnelFurniture;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TunnelFurniture extends AbstractFurniture implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;

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

    @Override
    public DeprecatedPropertiesOfTunnelFurniture getDeprecatedProperties() {
        return (DeprecatedPropertiesOfTunnelFurniture) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfTunnelFurniture createDeprecatedProperties() {
        return new DeprecatedPropertiesOfTunnelFurniture();
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelFurniture properties = getDeprecatedProperties();

            if (properties.getLod4Geometry() != null && properties.getLod4Geometry().getObject() != null)
                envelope.include(properties.getLod4Geometry().getObject().computeEnvelope());

            if (properties.getLod4ImplicitRepresentation() != null && properties.getLod4ImplicitRepresentation().getObject() != null)
                envelope.include(properties.getLod4ImplicitRepresentation().getObject().computeEnvelope());
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelFurniture properties = getDeprecatedProperties();

            geometryInfo.addGeometry(4, properties.getLod4Geometry());
            geometryInfo.addImplicitGeometry(4, properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
