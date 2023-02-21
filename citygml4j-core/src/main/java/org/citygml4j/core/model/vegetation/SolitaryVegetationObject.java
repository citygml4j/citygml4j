/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.vegetation;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.model.core.StandardObjectClassifier;
import org.citygml4j.core.model.deprecated.vegetation.DeprecatedPropertiesOfSolitaryVegetationObject;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class SolitaryVegetationObject extends AbstractVegetationObject implements TopLevelFeature, StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private Code species;
    private Length height;
    private Length trunkDiameter;
    private Length crownDiameter;
    private Length rootBallDiameter;
    private Length maxRootBallDepth;

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

    public Code getSpecies() {
        return species;
    }

    public void setSpecies(Code species) {
        this.species = asChild(species);
    }

    public Length getHeight() {
        return height;
    }

    public void setHeight(Length height) {
        this.height = asChild(height);
    }

    public Length getTrunkDiameter() {
        return trunkDiameter;
    }

    public void setTrunkDiameter(Length trunkDiameter) {
        this.trunkDiameter = asChild(trunkDiameter);
    }

    public Length getCrownDiameter() {
        return crownDiameter;
    }

    public void setCrownDiameter(Length crownDiameter) {
        this.crownDiameter = asChild(crownDiameter);
    }

    public Length getRootBallDiameter() {
        return rootBallDiameter;
    }

    public void setRootBallDiameter(Length rootBallDiameter) {
        this.rootBallDiameter = asChild(rootBallDiameter);
    }

    public Length getMaxRootBallDepth() {
        return maxRootBallDepth;
    }

    public void setMaxRootBallDepth(Length maxRootBallDepth) {
        this.maxRootBallDepth = asChild(maxRootBallDepth);
    }

    @Override
    public DeprecatedPropertiesOfSolitaryVegetationObject getDeprecatedProperties() {
        return super.getDeprecatedProperties(DeprecatedPropertiesOfSolitaryVegetationObject.class);
    }

    @Override
    protected DeprecatedPropertiesOfSolitaryVegetationObject createDeprecatedProperties() {
        return new DeprecatedPropertiesOfSolitaryVegetationObject();
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfSolitaryVegetationObject properties = getDeprecatedProperties();

            if (properties.getLod1Geometry() != null && properties.getLod1Geometry().getObject() != null)
                envelope.include(properties.getLod1Geometry().getObject().computeEnvelope());

            if (properties.getLod2Geometry() != null && properties.getLod2Geometry().getObject() != null)
                envelope.include(properties.getLod2Geometry().getObject().computeEnvelope());

            if (properties.getLod3Geometry() != null && properties.getLod3Geometry().getObject() != null)
                envelope.include(properties.getLod3Geometry().getObject().computeEnvelope());

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
            DeprecatedPropertiesOfSolitaryVegetationObject properties = getDeprecatedProperties();

            geometryInfo.addGeometry(1, properties.getLod1Geometry());
            geometryInfo.addGeometry(2, properties.getLod2Geometry());
            geometryInfo.addGeometry(3, properties.getLod3Geometry());
            geometryInfo.addGeometry(4, properties.getLod4Geometry());
            geometryInfo.addImplicitGeometry(4, properties.getLod4ImplicitRepresentation());
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
