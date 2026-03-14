/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.AbstractFeatureWithLifespanReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractReferenceAdapter;

import javax.xml.namespace.QName;

public class AbstractFeatureWithLifespanReferenceAdapter extends AbstractReferenceAdapter<AbstractFeatureWithLifespanReference> {

    @Override
    public AbstractFeatureWithLifespanReference createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractFeatureWithLifespanReference();
    }
}
