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

public class PostalServiceElements implements XAL, Child, Copyable {
    private List<AddressIdentifier> addressIdentifier;
    private EndorsementLineCode endorsementLineCode;
    private KeyLineCode keyLineCode;
    private Barcode barcode;
    private SortingCode sortingCode;
    private AddressLatitude addressLatitude;
    private AddressLatitudeDirection addressLatitudeDirection;
    private AddressLongitude addressLongitude;
    private AddressLongitudeDirection addressLongitudeDirection;
    private List<SupplementaryPostalServiceData> supplementaryPostalServiceData;
    private String type;
    private ModelObject parent;

    public void addAddressIdentifier(AddressIdentifier addressIdentifier) {
        getAddressIdentifier().add(addressIdentifier);
    }

    public void addSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData) {
        getSupplementaryPostalServiceData().add(supplementaryPostalServiceData);
    }

    public List<AddressIdentifier> getAddressIdentifier() {
        if (addressIdentifier == null)
            addressIdentifier = new ChildList<>(this);

        return addressIdentifier;
    }

    public AddressLatitude getAddressLatitude() {
        return addressLatitude;
    }

    public AddressLatitudeDirection getAddressLatitudeDirection() {
        return addressLatitudeDirection;
    }

    public AddressLongitude getAddressLongitude() {
        return addressLongitude;
    }

    public AddressLongitudeDirection getAddressLongitudeDirection() {
        return addressLongitudeDirection;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public EndorsementLineCode getEndorsementLineCode() {
        return endorsementLineCode;
    }

    public KeyLineCode getKeyLineCode() {
        return keyLineCode;
    }

    public SortingCode getSortingCode() {
        return sortingCode;
    }

    public List<SupplementaryPostalServiceData> getSupplementaryPostalServiceData() {
        if (supplementaryPostalServiceData == null)
            supplementaryPostalServiceData = new ChildList<>(this);

        return supplementaryPostalServiceData;
    }

    public String getType() {
        return type;
    }

    public boolean isSetAddressIdentifier() {
        return addressIdentifier != null && !addressIdentifier.isEmpty();
    }

    public boolean isSetAddressLatitude() {
        return addressLatitude != null;
    }

    public boolean isSetAddressLatitudeDirection() {
        return addressLatitudeDirection != null;
    }

    public boolean isSetAddressLongitude() {
        return addressLongitude != null;
    }

    public boolean isSetAddressLongitudeDirection() {
        return addressLongitudeDirection != null;
    }

    public boolean isSetBarcode() {
        return barcode != null;
    }

    public boolean isSetEndorsementLineCode() {
        return endorsementLineCode != null;
    }

    public boolean isSetKeyLineCode() {
        return keyLineCode != null;
    }

    public boolean isSetSortingCode() {
        return sortingCode != null;
    }

    public boolean isSetSupplementaryPostalServiceData() {
        return supplementaryPostalServiceData != null && !supplementaryPostalServiceData.isEmpty();
    }

    public boolean isSetType() {
        return type != null;
    }

    public void setAddressIdentifier(List<AddressIdentifier> addressIdentifier) {
        this.addressIdentifier = new ChildList<>(this, addressIdentifier);
    }

    public void setAddressLatitude(AddressLatitude addressLatitude) {
        this.addressLatitude = ModelObjects.setParent(addressLatitude, this);
    }

    public void setAddressLatitudeDirection(AddressLatitudeDirection addressLatitudeDirection) {
        this.addressLatitudeDirection = ModelObjects.setParent(addressLatitudeDirection, this);
    }

    public void setAddressLongitude(AddressLongitude addressLongitude) {
        this.addressLongitude = ModelObjects.setParent(addressLongitude, this);
    }

    public void setAddressLongitudeDirection(AddressLongitudeDirection addressLongitudeDirection) {
        this.addressLongitudeDirection = ModelObjects.setParent(addressLongitudeDirection, this);
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = ModelObjects.setParent(barcode, this);
    }

    public void setEndorsementLineCode(EndorsementLineCode endorsementLineCode) {
        this.endorsementLineCode = ModelObjects.setParent(endorsementLineCode, this);
    }

    public void setKeyLineCode(KeyLineCode keyLineCode) {
        this.keyLineCode = ModelObjects.setParent(keyLineCode, this);
    }

    public void setSortingCode(SortingCode sortingCode) {
        this.sortingCode = ModelObjects.setParent(sortingCode, this);
    }

    public void setSupplementaryPostalServiceData(List<SupplementaryPostalServiceData> supplementaryPostalServiceData) {
        this.supplementaryPostalServiceData = new ChildList<>(this, supplementaryPostalServiceData);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void unsetAddressIdentifier() {
        addressIdentifier = ModelObjects.setNull(addressIdentifier);
    }

    public boolean unsetAddressIdentifier(AddressIdentifier addressIdentifier) {
        return isSetAddressIdentifier() && this.addressIdentifier.remove(addressIdentifier);
    }

    public void unsetAddressLatitude() {
        addressLatitude = ModelObjects.setNull(addressLatitude);
    }

    public void unsetAddressLatitudeDirection() {
        addressLatitudeDirection = ModelObjects.setNull(addressLatitudeDirection);
    }

    public void unsetAddressLongitude() {
        addressLongitude = ModelObjects.setNull(addressLongitude);
    }

    public void unsetAddressLongitudeDirection() {
        addressLongitudeDirection = ModelObjects.setNull(addressLongitudeDirection);
    }

    public void unsetBarcode() {
        barcode = ModelObjects.setNull(barcode);
    }

    public void unsetEndorsementLineCode() {
        endorsementLineCode = ModelObjects.setNull(endorsementLineCode);
    }

    public void unsetKeyLineCode() {
        keyLineCode = ModelObjects.setNull(keyLineCode);
    }

    public void unsetSortingCode() {
        sortingCode = ModelObjects.setNull(sortingCode);
    }

    public void unsetSupplementaryPostalServiceData() {
        supplementaryPostalServiceData = ModelObjects.setNull(supplementaryPostalServiceData);
    }

    public boolean unsetSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData) {
        return isSetSupplementaryPostalServiceData() && this.supplementaryPostalServiceData.remove(supplementaryPostalServiceData);
    }

    public void unsetType() {
        type = null;
    }

    public XALClass getXALClass() {
        return XALClass.POSTAL_SERVICE_ELEMENTS;
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
        return copyTo(new PostalServiceElements(), copyBuilder);
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        PostalServiceElements copy = (target == null) ? new PostalServiceElements() : (PostalServiceElements) target;

        if (isSetAddressIdentifier()) {
            for (AddressIdentifier part : addressIdentifier) {
                AddressIdentifier copyPart = (AddressIdentifier) copyBuilder.copy(part);
                copy.addAddressIdentifier(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetEndorsementLineCode()) {
            copy.setEndorsementLineCode((EndorsementLineCode) copyBuilder.copy(endorsementLineCode));
            if (copy.getEndorsementLineCode() == endorsementLineCode)
                endorsementLineCode.setParent(this);
        }

        if (isSetKeyLineCode()) {
            copy.setKeyLineCode((KeyLineCode) copyBuilder.copy(keyLineCode));
            if (copy.getKeyLineCode() == keyLineCode)
                keyLineCode.setParent(this);
        }

        if (isSetBarcode()) {
            copy.setBarcode((Barcode) copyBuilder.copy(barcode));
            if (copy.getBarcode() == barcode)
                barcode.setParent(this);
        }

        if (isSetSortingCode()) {
            copy.setSortingCode((SortingCode) copyBuilder.copy(sortingCode));
            if (copy.getSortingCode() == sortingCode)
                sortingCode.setParent(this);
        }

        if (isSetAddressLatitude()) {
            copy.setAddressLatitude((AddressLatitude) copyBuilder.copy(addressLatitude));
            if (copy.getAddressLatitude() == addressLatitude)
                addressLatitude.setParent(this);
        }

        if (isSetAddressLatitudeDirection()) {
            copy.setAddressLatitudeDirection((AddressLatitudeDirection) copyBuilder.copy(addressLatitudeDirection));
            if (copy.getAddressLatitudeDirection() == addressLatitudeDirection)
                addressLatitudeDirection.setParent(this);
        }

        if (isSetAddressLongitude()) {
            copy.setAddressLongitude((AddressLongitude) copyBuilder.copy(addressLongitude));
            if (copy.getAddressLongitude() == addressLongitude)
                addressLongitude.setParent(this);
        }

        if (isSetAddressLongitudeDirection()) {
            copy.setAddressLongitudeDirection((AddressLongitudeDirection) copyBuilder.copy(addressLongitudeDirection));
            if (copy.getAddressLongitudeDirection() == addressLongitudeDirection)
                addressLongitudeDirection.setParent(this);
        }

        if (isSetSupplementaryPostalServiceData()) {
            for (SupplementaryPostalServiceData part : supplementaryPostalServiceData) {
                SupplementaryPostalServiceData copyPart = (SupplementaryPostalServiceData) copyBuilder.copy(part);
                copy.addSupplementaryPostalServiceData(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetType())
            copy.setType(copyBuilder.copy(type));

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
