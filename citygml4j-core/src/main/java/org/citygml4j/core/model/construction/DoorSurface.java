/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DoorSurface extends AbstractFillingSurface {
    private List<AddressProperty> addresses;

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public boolean isSetAddresses() {
        return addresses != null && !addresses.isEmpty();
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
