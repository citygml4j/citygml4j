/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.core.model.transportation.TrafficSpaceReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractReferenceAdapter;

import javax.xml.namespace.QName;

public class TrafficSpaceReferenceAdapter extends AbstractReferenceAdapter<TrafficSpaceReference> {

    @Override
    public TrafficSpaceReference createObject(QName name, Object parent) throws ObjectBuildException {
        return new TrafficSpaceReference();
    }
}
