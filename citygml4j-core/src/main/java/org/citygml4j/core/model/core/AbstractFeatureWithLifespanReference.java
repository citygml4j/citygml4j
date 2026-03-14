/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.base.AssociationAttributes;

public class AbstractFeatureWithLifespanReference extends AbstractReference<AbstractFeatureWithLifespan> implements CityGMLObject {

    public AbstractFeatureWithLifespanReference() {
    }

    public AbstractFeatureWithLifespanReference(String href) {
        super(href);
    }

    public AbstractFeatureWithLifespanReference(AbstractFeatureWithLifespan object) {
        super(object);
    }

    public AbstractFeatureWithLifespanReference(AssociationAttributes reference) {
        super(reference);
    }

    @Override
    public Class<AbstractFeatureWithLifespan> getTargetType() {
        return AbstractFeatureWithLifespan.class;
    }
}
