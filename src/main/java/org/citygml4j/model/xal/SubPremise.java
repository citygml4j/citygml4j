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

public class SubPremise implements XAL, Child, Copyable {
    private List<AddressLine> addressLine;
    private List<SubPremiseName> subPremiseName;
    private List<SubPremiseNumber> subPremiseNumber;
    private List<SubPremiseNumberPrefix> subPremiseNumberPrefix;
    private List<SubPremiseNumberSuffix> subPremiseNumberSuffix;
    private List<BuildingName> buildingName;
    private SubPremiseLocation subPremiseLocation;
    private Firm firm;
    private MailStop mailStop;
    private PostalCode postalCode;
    private SubPremise subPremise;
    private String type;
    private ModelObject parent;

    public void addAddressLine(AddressLine addressLine) {
        getAddressLine().add(addressLine);
    }

    public void addBuildingName(BuildingName buildingName) {
        getBuildingName().add(buildingName);
    }

    public void addSubPremiseName(SubPremiseName subPremiseName) {
        getSubPremiseName().add(subPremiseName);
    }

    public void addSubPremiseNumber(SubPremiseNumber subPremiseNumber) {
        getSubPremiseNumber().add(subPremiseNumber);
    }

    public void addSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix) {
        getSubPremiseNumberPrefix().add(subPremiseNumberPrefix);
    }

    public void addSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix) {
        getSubPremiseNumberSuffix().add(subPremiseNumberSuffix);
    }

    public List<AddressLine> getAddressLine() {
        if (addressLine == null)
            addressLine = new ChildList<>(this);

        return addressLine;
    }

    public List<BuildingName> getBuildingName() {
        if (buildingName == null)
            buildingName = new ChildList<>(this);

        return buildingName;
    }

    public Firm getFirm() {
        return firm;
    }

    public MailStop getMailStop() {
        return mailStop;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public SubPremise getSubPremise() {
        return subPremise;
    }

    public SubPremiseLocation getSubPremiseLocation() {
        return subPremiseLocation;
    }

    public List<SubPremiseName> getSubPremiseName() {
        if (subPremiseName == null)
            subPremiseName = new ChildList<>(this);

        return subPremiseName;
    }

    public List<SubPremiseNumber> getSubPremiseNumber() {
        if (subPremiseNumber == null)
            subPremiseNumber = new ChildList<>(this);

        return subPremiseNumber;
    }

    public List<SubPremiseNumberPrefix> getSubPremiseNumberPrefix() {
        if (subPremiseNumberPrefix == null)
            subPremiseNumberPrefix = new ChildList<>(this);

        return subPremiseNumberPrefix;
    }

    public List<SubPremiseNumberSuffix> getSubPremiseNumberSuffix() {
        if (subPremiseNumberSuffix == null)
            subPremiseNumberSuffix = new ChildList<>(this);

        return subPremiseNumberSuffix;
    }

    public String getType() {
        return type;
    }

    public boolean isSetAddressLine() {
        return addressLine != null && !addressLine.isEmpty();
    }

    public boolean isSetBuildingName() {
        return buildingName != null && !buildingName.isEmpty();
    }

    public boolean isSetFirm() {
        return firm != null;
    }

    public boolean isSetMailStop() {
        return mailStop != null;
    }

    public boolean isSetPostalCode() {
        return postalCode != null;
    }

    public boolean isSetSubPremise() {
        return subPremise != null;
    }

    public boolean isSetSubPremiseLocation() {
        return subPremiseLocation != null;
    }

    public boolean isSetSubPremiseName() {
        return subPremiseName != null && !subPremiseName.isEmpty();
    }

    public boolean isSetSubPremiseNumber() {
        return subPremiseNumber != null && !subPremiseNumber.isEmpty();
    }

    public boolean isSetSubPremiseNumberPrefix() {
        return subPremiseNumberPrefix != null && !subPremiseNumberPrefix.isEmpty();
    }

    public boolean isSetSubPremiseNumberSuffix() {
        return subPremiseNumberSuffix != null && !subPremiseNumberSuffix.isEmpty();
    }

    public boolean isSetType() {
        return type != null;
    }

    public void setAddressLine(List<AddressLine> addressLine) {
        this.addressLine = new ChildList<>(this, addressLine);
    }

    public void setBuildingName(List<BuildingName> buildingName) {
        this.buildingName = new ChildList<>(this, buildingName);
    }

    public void setFirm(Firm firm) {
        this.firm = ModelObjects.setParent(firm, this);
    }

    public void setMailStop(MailStop mailStop) {
        this.mailStop = ModelObjects.setParent(mailStop, this);
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = ModelObjects.setParent(postalCode, this);
    }

    public void setSubPremise(SubPremise subPremise) {
        this.subPremise = ModelObjects.setParent(subPremise, this);
    }

    public void setSubPremiseLocation(SubPremiseLocation subPremiseLocation) {
        this.subPremiseLocation = ModelObjects.setParent(subPremiseLocation, this);
    }

    public void setSubPremiseName(List<SubPremiseName> subPremiseName) {
        this.subPremiseName = new ChildList<>(this, subPremiseName);
    }

    public void setSubPremiseNumber(List<SubPremiseNumber> subPremiseNumber) {
        this.subPremiseNumber = new ChildList<>(this, subPremiseNumber);
    }

    public void setSubPremiseNumberPrefix(List<SubPremiseNumberPrefix> subPremiseNumberPrefix) {
        this.subPremiseNumberPrefix = new ChildList<>(this, subPremiseNumberPrefix);
    }

    public void setSubPremiseNumberSuffix(List<SubPremiseNumberSuffix> subPremiseNumberSuffix) {
        this.subPremiseNumberSuffix = new ChildList<>(this, subPremiseNumberSuffix);
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

    public void unsetBuildingName() {
        buildingName = ModelObjects.setNull(buildingName);
    }

    public boolean unsetBuildingName(BuildingName buildingName) {
        return isSetBuildingName() && this.buildingName.remove(buildingName);
    }

    public void unsetFirm() {
        firm = ModelObjects.setNull(firm);
    }

    public void unsetMailStop() {
        mailStop = ModelObjects.setNull(mailStop);
    }

    public void unsetPostalCode() {
        postalCode = ModelObjects.setNull(postalCode);
    }

    public void unsetSubPremise() {
        subPremise = ModelObjects.setNull(subPremise);
    }

    public void unsetSubPremiseLocation() {
        subPremiseLocation = ModelObjects.setNull(subPremiseLocation);
    }

    public void unsetSubPremiseName() {
        subPremiseName = ModelObjects.setNull(subPremiseName);
    }

    public boolean unsetSubPremiseName(SubPremiseName subPremiseName) {
        return isSetSubPremiseName() && this.subPremiseName.remove(subPremiseName);
    }

    public void unsetSubPremiseNumber() {
        subPremiseNumber = ModelObjects.setNull(subPremiseNumber);
    }

    public boolean unsetSubPremiseNumber(SubPremiseNumber subPremiseNumber) {
        return isSetSubPremiseNumber() && this.subPremiseNumber.remove(subPremiseNumber);
    }

    public void unsetSubPremiseNumberPrefix() {
        subPremiseNumberPrefix = ModelObjects.setNull(subPremiseNumberPrefix);
    }

    public boolean unsetSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix) {
        return isSetSubPremiseNumberPrefix() && this.subPremiseNumberPrefix.remove(subPremiseNumberPrefix);
    }

    public void unsetSubPremiseNumberSuffix() {
        subPremiseNumberSuffix = ModelObjects.setNull(subPremiseNumberSuffix);
    }

    public boolean unsetSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix) {
        return isSetSubPremiseNumberSuffix() && this.subPremiseNumberSuffix.remove(subPremiseNumberSuffix);
    }

    public void unsetType() {
        type = null;
    }

    public XALClass getXALClass() {
        return XALClass.SUB_PREMISE;
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
        return copyTo(new SubPremise(), copyBuilder);
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        SubPremise copy = (target == null) ? new SubPremise() : (SubPremise) target;

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

        if (isSetBuildingName()) {
            for (BuildingName part : buildingName) {
                BuildingName copyPart = (BuildingName) copyBuilder.copy(part);
                copy.addBuildingName(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetSubPremiseName()) {
            for (SubPremiseName part : subPremiseName) {
                SubPremiseName copyPart = (SubPremiseName) copyBuilder.copy(part);
                copy.addSubPremiseName(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetSubPremiseNumber()) {
            for (SubPremiseNumber part : subPremiseNumber) {
                SubPremiseNumber copyPart = (SubPremiseNumber) copyBuilder.copy(part);
                copy.addSubPremiseNumber(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetSubPremiseNumberPrefix()) {
            for (SubPremiseNumberPrefix part : subPremiseNumberPrefix) {
                SubPremiseNumberPrefix copyPart = (SubPremiseNumberPrefix) copyBuilder.copy(part);
                copy.addSubPremiseNumberPrefix(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetSubPremiseNumberSuffix()) {
            for (SubPremiseNumberSuffix part : subPremiseNumberSuffix) {
                SubPremiseNumberSuffix copyPart = (SubPremiseNumberSuffix) copyBuilder.copy(part);
                copy.addSubPremiseNumberSuffix(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetMailStop()) {
            copy.setMailStop((MailStop) copyBuilder.copy(mailStop));
            if (copy.getMailStop() == mailStop)
                mailStop.setParent(this);
        }

        if (isSetPostalCode()) {
            copy.setPostalCode((PostalCode) copyBuilder.copy(postalCode));
            if (copy.getPostalCode() == postalCode)
                postalCode.setParent(this);
        }

        if (isSetFirm()) {
            copy.setFirm((Firm) copyBuilder.copy(firm));
            if (copy.getFirm() == firm)
                firm.setParent(this);
        }

        if (isSetSubPremise()) {
            copy.setSubPremise((SubPremise) copyBuilder.copy(subPremise));
            if (copy.getSubPremise() == subPremise)
                subPremise.setParent(this);
        }

        if (isSetSubPremiseLocation()) {
            copy.setSubPremiseLocation((SubPremiseLocation) copyBuilder.copy(subPremiseLocation));
            if (copy.getSubPremiseLocation() == subPremiseLocation)
                subPremiseLocation.setParent(this);
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
