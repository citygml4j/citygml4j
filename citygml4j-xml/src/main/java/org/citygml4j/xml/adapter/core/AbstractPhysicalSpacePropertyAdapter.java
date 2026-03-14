/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.AbstractPhysicalSpaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractPhysicalSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractPhysicalSpaceProperty> {

    @Override
    public AbstractPhysicalSpaceProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractPhysicalSpaceProperty();
    }
}
