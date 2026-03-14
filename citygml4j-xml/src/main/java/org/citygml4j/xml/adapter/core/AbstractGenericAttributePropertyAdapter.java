/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.AbstractGenericAttributeProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractGenericAttributePropertyAdapter extends AbstractInlinePropertyAdapter<AbstractGenericAttributeProperty> {

    @Override
    public AbstractGenericAttributeProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractGenericAttributeProperty();
    }
}
