/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.construction;

import org.citygml4j.core.model.construction.HeightProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class HeightPropertyAdapter extends AbstractInlinePropertyAdapter<HeightProperty> {

    @Override
    public HeightProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new HeightProperty();
    }
}
