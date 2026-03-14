/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.AbstractCityObjectReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractReferenceAdapter;

import javax.xml.namespace.QName;

public class AbstractCityObjectReferenceAdapter extends AbstractReferenceAdapter<AbstractCityObjectReference> {

    @Override
    public AbstractCityObjectReference createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractCityObjectReference();
    }
}
