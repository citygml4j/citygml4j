/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.core.model.tunnel.TunnelConstructiveElementProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class TunnelConstructiveElementPropertyAdapter extends AbstractFeaturePropertyAdapter<TunnelConstructiveElementProperty> {

    @Override
    public TunnelConstructiveElementProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new TunnelConstructiveElementProperty();
    }
}
