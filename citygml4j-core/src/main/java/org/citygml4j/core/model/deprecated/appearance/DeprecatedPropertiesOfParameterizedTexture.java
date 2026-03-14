/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.deprecated.appearance;

import org.citygml4j.core.model.deprecated.core.DeprecatedPropertiesOfAbstractFeature;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfParameterizedTexture extends DeprecatedPropertiesOfAbstractFeature {
    private List<TextureAssociationReference> targets;

    public List<TextureAssociationReference> getTargets() {
        if (targets == null) {
            targets = new ChildList<>(this);
        }

        return targets;
    }

    public boolean isSetTargets() {
        return targets != null && !targets.isEmpty();
    }

    public void setTargets(List<TextureAssociationReference> targets) {
        this.targets = asChild(targets);
    }
}
