/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.construction;

import org.citygml4j.core.model.construction.ElevationProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class ElevationPropertyAdapter extends AbstractInlinePropertyAdapter<ElevationProperty> {

    @Override
    public ElevationProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new ElevationProperty();
    }
}
