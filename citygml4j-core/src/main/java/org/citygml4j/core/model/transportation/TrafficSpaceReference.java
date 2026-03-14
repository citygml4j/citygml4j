/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.base.AssociationAttributes;

public class TrafficSpaceReference extends AbstractReference<TrafficSpace> implements CityGMLObject {

    public TrafficSpaceReference() {
    }

    public TrafficSpaceReference(String href) {
        super(href);
    }

    public TrafficSpaceReference(TrafficSpace object) {
        super(object);
    }

    public TrafficSpaceReference(AssociationAttributes reference) {
        super(reference);
    }

    @Override
    public Class<TrafficSpace> getTargetType() {
        return TrafficSpace.class;
    }
}
