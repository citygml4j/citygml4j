/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.relief;

import org.citygml4j.core.model.relief.TinProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;

import javax.xml.namespace.QName;

public class TinPropertyAdapter extends AbstractGeometryPropertyAdapter<TinProperty> {

    @Override
    public TinProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new TinProperty();
    }
}
