/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

import java.util.List;

public class DependentThoroughfare implements XAL, Child, Copyable {
    private List<AddressLine> addressLine;
    private List<ThoroughfareName> thoroughfareName;
    private ThoroughfarePreDirection thoroughfarePreDirection;
    private ThoroughfarePostDirection thoroughfarePostDirection;
    private ThoroughfareLeadingType thoroughfareLeadingType;
    private ThoroughfareTrailingType thoroughfareTrailingType;
    private String type;
    private ModelObject parent;

    public void addAddressLine(AddressLine addressLine) {
        getAddressLine().add(addressLine);
    }

    public void addThoroughfareName(ThoroughfareName thoroughfareName) {
        getThoroughfareName().add(thoroughfareName);
    }

    public List<AddressLine> getAddressLine() {
        if (addressLine == null)
            addressLine = new ChildList<>(this);

        return addressLine;
    }

    public ThoroughfareLeadingType getThoroughfareLeadingType() {
        return thoroughfareLeadingType;
    }

    public List<ThoroughfareName> getThoroughfareName() {
        if (thoroughfareName == null)
            thoroughfareName = new ChildList<>(this);

        return thoroughfareName;
    }

    public ThoroughfarePostDirection getThoroughfarePostDirection() {
        return thoroughfarePostDirection;
    }

    public ThoroughfarePreDirection getThoroughfarePreDirection() {
        return thoroughfarePreDirection;
    }

    public ThoroughfareTrailingType getThoroughfareTrailingType() {
        return thoroughfareTrailingType;
    }

    public String getType() {
        return type;
    }

    public boolean isSetAddressLine() {
        return addressLine != null && !addressLine.isEmpty();
    }

    public boolean isSetThoroughfareLeadingType() {
        return thoroughfareLeadingType != null;
    }

    public boolean isSetThoroughfareName() {
        return thoroughfareName != null && !thoroughfareName.isEmpty();
    }

    public boolean isSetThoroughfarePostDirection() {
        return thoroughfarePostDirection != null;
    }

    public boolean isSetThoroughfarePreDirection() {
        return thoroughfarePreDirection != null;
    }

    public boolean isSetThoroughfareTrailingType() {
        return thoroughfareTrailingType != null;
    }

    public boolean isSetType() {
        return type != null;
    }

    public void setAddressLine(List<AddressLine> addressLine) {
        this.addressLine = new ChildList<>(this, addressLine);
    }

    public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType) {
        this.thoroughfareLeadingType = ModelObjects.setParent(thoroughfareLeadingType, this);
    }

    public void setThoroughfareName(List<ThoroughfareName> thoroughfareName) {
        this.thoroughfareName = new ChildList<>(this, thoroughfareName);
    }

    public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection) {
        this.thoroughfarePostDirection = ModelObjects.setParent(thoroughfarePostDirection, this);
    }

    public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection) {
        this.thoroughfarePreDirection = ModelObjects.setParent(thoroughfarePreDirection, this);
    }

    public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType) {
        this.thoroughfareTrailingType = ModelObjects.setParent(thoroughfareTrailingType, this);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void unsetAddressLine() {
        addressLine = ModelObjects.setNull(addressLine);
    }

    public boolean unsetAddressLine(AddressLine addressLine) {
        return isSetAddressLine() && this.addressLine.remove(addressLine);
    }

    public void unsetThoroughfareLeadingType() {
        thoroughfareLeadingType = ModelObjects.setNull(thoroughfareLeadingType);
    }

    public void unsetThoroughfareName() {
        thoroughfareName = ModelObjects.setNull(thoroughfareName);
    }

    public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName) {
        return isSetThoroughfareName() && this.thoroughfareName.remove(thoroughfareName);
    }

    public void unsetThoroughfarePostDirection() {
        thoroughfarePostDirection = ModelObjects.setNull(thoroughfarePostDirection);
    }

    public void unsetThoroughfarePreDirection() {
        thoroughfarePreDirection = ModelObjects.setNull(thoroughfarePreDirection);
    }

    public void unsetThoroughfareTrailingType() {
        thoroughfareTrailingType = ModelObjects.setNull(thoroughfareTrailingType);
    }

    public void unsetType() {
        type = null;
    }

    public XALClass getXALClass() {
        return XALClass.DEPENDENT_THOROUGHFARE;
    }

    public ModelObject getParent() {
        return parent;
    }

    public void setParent(ModelObject parent) {
        this.parent = parent;
    }

    public boolean isSetParent() {
        return parent != null;
    }

    public void unsetParent() {
        parent = null;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new DependentThoroughfare(), copyBuilder);
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        DependentThoroughfare copy = (target == null) ? new DependentThoroughfare() : (DependentThoroughfare) target;

        if (isSetType())
            copy.setType(copyBuilder.copy(type));

        if (isSetAddressLine()) {
            for (AddressLine part : addressLine) {
                AddressLine copyPart = (AddressLine) copyBuilder.copy(part);
                copy.addAddressLine(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetThoroughfareName()) {
            for (ThoroughfareName part : thoroughfareName) {
                ThoroughfareName copyPart = (ThoroughfareName) copyBuilder.copy(part);
                copy.addThoroughfareName(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetThoroughfareLeadingType()) {
            copy.setThoroughfareLeadingType((ThoroughfareLeadingType) copyBuilder.copy(thoroughfareLeadingType));
            if (copy.getThoroughfareLeadingType() == thoroughfareLeadingType)
                thoroughfareLeadingType.setParent(this);
        }

        if (isSetThoroughfarePostDirection()) {
            copy.setThoroughfarePostDirection((ThoroughfarePostDirection) copyBuilder.copy(thoroughfarePostDirection));
            if (copy.getThoroughfarePostDirection() == thoroughfarePostDirection)
                thoroughfarePostDirection.setParent(this);
        }

        if (isSetThoroughfarePreDirection()) {
            copy.setThoroughfarePreDirection((ThoroughfarePreDirection) copyBuilder.copy(thoroughfarePreDirection));
            if (copy.getThoroughfarePreDirection() == thoroughfarePreDirection)
                thoroughfarePreDirection.setParent(this);
        }

        if (isSetThoroughfareTrailingType()) {
            copy.setThoroughfareTrailingType((ThoroughfareTrailingType) copyBuilder.copy(thoroughfareTrailingType));
            if (copy.getThoroughfareTrailingType() == thoroughfareTrailingType)
                thoroughfareTrailingType.setParent(this);
        }

        copy.unsetParent();

        return copy;
    }

    public void accept(XALVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(XALFunctor<T> visitor) {
        return visitor.apply(this);
    }

}
