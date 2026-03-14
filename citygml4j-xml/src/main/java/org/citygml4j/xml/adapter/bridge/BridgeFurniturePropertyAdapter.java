/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.core.model.bridge.BridgeFurnitureProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BridgeFurniturePropertyAdapter extends AbstractFeaturePropertyAdapter<BridgeFurnitureProperty> {

    @Override
    public BridgeFurnitureProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeFurnitureProperty();
    }
}
