/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.ImplicitGeometryProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class ImplicitGeometryPropertyAdapter extends AbstractPropertyAdapter<ImplicitGeometryProperty> {

    @Override
    public ImplicitGeometryProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new ImplicitGeometryProperty();
    }
}
