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

package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractInstallation extends AbstractOccupiedSpace {
    private RelationToConstruction relationToConstruction;
    private List<ADEOfAbstractInstallation> adeOfAbstractInstallation;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public RelationToConstruction getRelationToConstruction() {
        return relationToConstruction;
    }

    public void setRelationToConstruction(RelationToConstruction relationToConstruction) {
        this.relationToConstruction = relationToConstruction;
    }

    public List<ADEOfAbstractInstallation> getADEOfAbstractInstallation() {
        if (adeOfAbstractInstallation == null)
            adeOfAbstractInstallation = new ChildList<>(this);

        return adeOfAbstractInstallation;
    }

    public void setADEOfAbstractInstallation(List<ADEOfAbstractInstallation> adeOfAbstractInstallation) {
        this.adeOfAbstractInstallation = asChild(adeOfAbstractInstallation);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractInstallation != null) {
            for (ADEOfAbstractInstallation container : adeOfAbstractInstallation)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractInstallation != null) {
            for (ADEOfAbstractInstallation container : adeOfAbstractInstallation)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
