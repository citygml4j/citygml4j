/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.versioning;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.base.AssociationAttributes;

public class VersionReference extends AbstractReference<Version> implements CityGMLObject {

    public VersionReference() {
    }

    public VersionReference(String href) {
        super(href);
    }

    public VersionReference(Version object) {
        super(object);
    }

    public VersionReference(AssociationAttributes reference) {
        super(reference);
    }

    @Override
    public Class<Version> getTargetType() {
        return Version.class;
    }
}
