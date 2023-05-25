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

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.core.AbstractOccupiedSpace;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractConstructiveElement extends AbstractOccupiedSpace {
    private Boolean isStructuralElement;
    private List<AbstractFillingElementProperty> fillings;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return AbstractConstructionSurface.class.isAssignableFrom(type)
                || ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
    }

    public Boolean getIsStructuralElement() {
        return isStructuralElement;
    }

    public boolean isSetIsStructuralElement() {
        return isStructuralElement != null;
    }

    public void setIsStructuralElement(Boolean isStructuralElement) {
        this.isStructuralElement = isStructuralElement;
    }

    public List<AbstractFillingElementProperty> getFillings() {
        if (fillings == null)
            fillings = new ChildList<>(this);

        return fillings;
    }

    public boolean isSetFillings() {
        return fillings != null && !fillings.isEmpty();
    }

    public void setFillings(List<AbstractFillingElementProperty> fillings) {
        this.fillings = asChild(fillings);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (fillings != null) {
            for (AbstractFillingElementProperty property : fillings) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }
    }
}
