/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.core.model.bridge.BridgePartProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BridgePartPropertyAdapter extends AbstractFeaturePropertyAdapter<BridgePartProperty> {

    @Override
    public BridgePartProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgePartProperty();
    }
}
