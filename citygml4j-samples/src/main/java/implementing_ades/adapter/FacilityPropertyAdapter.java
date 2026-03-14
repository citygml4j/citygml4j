/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.FacilityProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class FacilityPropertyAdapter extends AbstractPropertyAdapter<FacilityProperty> {

    @Override
    public FacilityProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new FacilityProperty();
    }
}
