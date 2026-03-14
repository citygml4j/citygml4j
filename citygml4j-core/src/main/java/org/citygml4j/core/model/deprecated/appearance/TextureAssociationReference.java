/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.appearance.TextureAssociation;
import org.xmlobjects.gml.model.base.AbstractReference;

public class TextureAssociationReference extends AbstractReference<TextureAssociation> implements CityGMLObject {
    private String uri;

    public TextureAssociationReference() {
    }

    public TextureAssociationReference(String href, String uri) {
        super(href);
        this.uri = uri;
    }

    public TextureAssociationReference(TextureAssociation object) {
        super(object);
        if (object.getTarget() != null) {
            uri = object.getTarget().getHref();
        }
    }

    @Override
    public Class<TextureAssociation> getTargetType() {
        return TextureAssociation.class;
    }

    public String getURI() {
        return uri;
    }

    public void setURI(String uri) {
        this.uri = uri;
    }
}
