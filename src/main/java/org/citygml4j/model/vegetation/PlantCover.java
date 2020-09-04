/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.vegetation;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.vegetation.DeprecatedPropertiesOfPlantCover;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class PlantCover extends AbstractVegetationObject implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private Length averageHeight;
    private Length minHeight;
    private Length maxHeight;
    private List<ADEOfPlantCover> adeOfPlantCover;

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

    public Length getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(Length averageHeight) {
        this.averageHeight = asChild(averageHeight);
    }

    public Length getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Length minHeight) {
        this.minHeight = asChild(minHeight);
    }

    public Length getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Length maxHeight) {
        this.maxHeight = asChild(maxHeight);
    }

    @Override
    public DeprecatedPropertiesOfPlantCover getDeprecatedProperties() {
        return (DeprecatedPropertiesOfPlantCover) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfPlantCover createDeprecatedProperties() {
        return new DeprecatedPropertiesOfPlantCover();
    }

    public List<ADEOfPlantCover> getADEOfPlantCover() {
        if (adeOfPlantCover == null)
            adeOfPlantCover = new ChildList<>(this);

        return adeOfPlantCover;
    }

    public void setADEOfPlantCover(List<ADEOfPlantCover> adeOfPlantCover) {
        this.adeOfPlantCover = asChild(adeOfPlantCover);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfPlantCover properties = getDeprecatedProperties();

            if (properties.getLod1MultiSurface() != null && properties.getLod1MultiSurface().getObject() != null)
                envelope.include(properties.getLod1MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());

            if (properties.getLod1MultiSolid() != null && properties.getLod1MultiSolid().getObject() != null)
                envelope.include(properties.getLod1MultiSolid().getObject().computeEnvelope());

            if (properties.getLod2MultiSolid() != null && properties.getLod2MultiSolid().getObject() != null)
                envelope.include(properties.getLod2MultiSolid().getObject().computeEnvelope());

            if (properties.getLod3MultiSolid() != null && properties.getLod3MultiSolid().getObject() != null)
                envelope.include(properties.getLod3MultiSolid().getObject().computeEnvelope());

            if (properties.getLod4MultiSolid() != null && properties.getLod4MultiSolid().getObject() != null)
                envelope.include(properties.getLod4MultiSolid().getObject().computeEnvelope());
        }

        if (adeOfPlantCover != null) {
            for (ADEOfPlantCover container : adeOfPlantCover)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfPlantCover properties = getDeprecatedProperties();

            geometryInfo.addGeometry(1, properties.getLod1MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
            geometryInfo.addGeometry(1, properties.getLod1MultiSolid());
            geometryInfo.addGeometry(2, properties.getLod2MultiSolid());
            geometryInfo.addGeometry(3, properties.getLod3MultiSolid());
            geometryInfo.addGeometry(4, properties.getLod4MultiSolid());
        }

        if (adeOfPlantCover != null) {
            for (ADEOfPlantCover container : adeOfPlantCover)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
