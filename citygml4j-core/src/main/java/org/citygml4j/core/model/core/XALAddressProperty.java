/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.xal.model.Address;

public class XALAddressProperty extends AbstractInlineProperty<Address> implements CityGMLObject {

    public XALAddressProperty() {
    }

    public XALAddressProperty(Address object) {
        super(object);
    }

    @Override
    public Class<Address> getTargetType() {
        return Address.class;
    }
}
