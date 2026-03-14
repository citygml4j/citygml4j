/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.building;

import org.citygml4j.core.model.building.AbstractBuildingSubdivisionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractBuildingSubdivisionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractBuildingSubdivisionProperty> {

    @Override
    public AbstractBuildingSubdivisionProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractBuildingSubdivisionProperty();
    }
}
