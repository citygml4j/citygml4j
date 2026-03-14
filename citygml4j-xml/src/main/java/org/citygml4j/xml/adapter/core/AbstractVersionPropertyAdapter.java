/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.AbstractVersionProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractVersionPropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractVersionProperty> {

    @Override
    public AbstractVersionProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractVersionProperty();
    }
}
