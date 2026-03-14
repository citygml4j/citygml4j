/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.core.model.transportation.AuxiliaryTrafficSpaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AuxiliaryTrafficSpacePropertyAdapter extends AbstractFeaturePropertyAdapter<AuxiliaryTrafficSpaceProperty> {

    @Override
    public AuxiliaryTrafficSpaceProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new AuxiliaryTrafficSpaceProperty();
    }
}
