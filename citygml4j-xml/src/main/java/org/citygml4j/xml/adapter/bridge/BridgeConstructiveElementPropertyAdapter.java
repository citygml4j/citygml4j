/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.core.model.bridge.BridgeConstructiveElementProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class BridgeConstructiveElementPropertyAdapter extends AbstractFeaturePropertyAdapter<BridgeConstructiveElementProperty> {

    @Override
    public BridgeConstructiveElementProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeConstructiveElementProperty();
    }
}
