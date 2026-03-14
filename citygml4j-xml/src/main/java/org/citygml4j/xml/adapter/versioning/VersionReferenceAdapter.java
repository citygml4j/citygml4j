/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.versioning;

import org.citygml4j.core.model.versioning.VersionReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractReferenceAdapter;

import javax.xml.namespace.QName;

public class VersionReferenceAdapter extends AbstractReferenceAdapter<VersionReference> {

    @Override
    public VersionReference createObject(QName name, Object parent) throws ObjectBuildException {
        return new VersionReference();
    }
}
