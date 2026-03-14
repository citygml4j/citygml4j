/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.core.model.appearance.AbstractSurfaceDataProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractSurfaceDataPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractSurfaceDataProperty> {

    @Override
    public AbstractSurfaceDataProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractSurfaceDataProperty();
    }
}
