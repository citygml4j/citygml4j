/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.relief;

import org.citygml4j.core.model.relief.GridProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class GridPropertyAdapter extends AbstractFeaturePropertyAdapter<GridProperty> {

    @Override
    public GridProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new GridProperty();
    }
}
