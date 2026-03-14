/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class TextureAssociationProperty extends AbstractInlineProperty<TextureAssociation> implements CityGMLObject {

    public TextureAssociationProperty() {
    }

    public TextureAssociationProperty(TextureAssociation object) {
        super(object);
    }

    @Override
    public Class<TextureAssociation> getTargetType() {
        return TextureAssociation.class;
    }
}
