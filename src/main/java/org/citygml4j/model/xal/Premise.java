/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

import java.util.List;

public class Premise implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PremiseName> premiseName;
	private List<PremiseNumber> premiseNumber;
	private List<PremiseNumberPrefix> premiseNumberPrefix;
	private List<PremiseNumberSuffix> premiseNumberSuffix;
	private List<BuildingName> buildingName;
	private List<SubPremise> subPremise;
	private PremiseLocation premiseLocation;
	private PremiseNumberRange premiseNumberRange;
	private Firm firm;
	private MailStop mailStop;
	private PostalCode postalCode;
	private Premise premise;
	private String type;
	private String premiseDependency;
	private String premiseDependencyType;
	private String premiseThoroughfareConnector;
	private ModelObject parent;	
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addBuildingName(BuildingName buildingName) {
		if (this.buildingName == null)
			this.buildingName = new ChildList<BuildingName>(this);

		this.buildingName.add(buildingName);
	}

	public void addPremiseName(PremiseName premiseName) {
		if (this.premiseName == null)
			this.premiseName = new ChildList<PremiseName>(this);

		this.premiseName.add(premiseName);
	}

	public void addPremiseNumber(PremiseNumber premiseNumber) {
		if (this.premiseNumber == null)
			this.premiseNumber = new ChildList<PremiseNumber>(this);

		this.premiseNumber.add(premiseNumber);
	}

	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		if (this.premiseNumberPrefix == null)
			this.premiseNumberPrefix = new ChildList<PremiseNumberPrefix>(this);

		this.premiseNumberPrefix.add(premiseNumberPrefix);
	}

	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		if (this.premiseNumberSuffix == null)
			this.premiseNumberSuffix = new ChildList<PremiseNumberSuffix>(this);

		this.premiseNumberSuffix.add(premiseNumberSuffix);
	}

	public void addSubPremise(SubPremise subPremise) {
		if (this.subPremise == null)
			this.subPremise = new ChildList<SubPremise>(this);

		this.subPremise.add(subPremise);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public List<BuildingName> getBuildingName() {
		if (buildingName == null)
			buildingName = new ChildList<BuildingName>(this);

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

	public Premise getPremise() {
		return premise;
	}

	public String getPremiseDependency() {
		return premiseDependency;
	}

	public String getPremiseDependencyType() {
		return premiseDependencyType;
	}

	public PremiseLocation getPremiseLocation() {
		return premiseLocation;
	}

	public List<PremiseName> getPremiseName() {
		if (premiseName == null)
			premiseName = new ChildList<PremiseName>(this);

		return premiseName;
	}

	public List<PremiseNumber> getPremiseNumber() {
		if (premiseNumber == null)
			premiseNumber = new ChildList<PremiseNumber>(this);

		return premiseNumber;
	}

	public List<PremiseNumberPrefix> getPremiseNumberPrefix() {
		if (premiseNumberPrefix == null)
			premiseNumberPrefix = new ChildList<PremiseNumberPrefix>(this);

		return premiseNumberPrefix;
	}

	public PremiseNumberRange getPremiseNumberRange() {
		return premiseNumberRange;
	}

	public List<PremiseNumberSuffix> getPremiseNumberSuffix() {
		if (premiseNumberSuffix == null)
			premiseNumberSuffix = new ChildList<PremiseNumberSuffix>(this);

		return premiseNumberSuffix;
	}

	public String getPremiseThoroughfareConnector() {
		return premiseThoroughfareConnector;
	}

	public List<SubPremise> getSubPremise() {
		if (subPremise == null)
			subPremise = new ChildList<SubPremise>(this);

		return subPremise;
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

	public boolean isSetPremise() {
		return premise != null;
	}

	public boolean isSetPremiseDependency() {
		return premiseDependency != null;
	}

	public boolean isSetPremiseDependencyType() {
		return premiseDependencyType != null;
	}

	public boolean isSetPremiseLocation() {
		return premiseLocation != null;
	}

	public boolean isSetPremiseName() {
		return premiseName != null && !premiseName.isEmpty();
	}

	public boolean isSetPremiseNumber() {
		return premiseNumber != null && !premiseNumber.isEmpty();
	}

	public boolean isSetPremiseNumberPrefix() {
		return premiseNumberPrefix != null && !premiseNumberPrefix.isEmpty();
	}

	public boolean isSetPremiseNumberRange() {
		return premiseNumberRange != null;
	}

	public boolean isSetPremiseNumberSuffix() {
		return premiseNumberSuffix != null && !premiseNumberSuffix.isEmpty();
	}

	public boolean isSetPremiseThoroughfareConnector() {
		return premiseThoroughfareConnector != null;
	}

	public boolean isSetSubPremise() {
		return subPremise != null && !subPremise.isEmpty();
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setBuildingName(List<BuildingName> buildingName) {
		this.buildingName = new ChildList<BuildingName>(this, buildingName);
	}

	public void setFirm(Firm firm) {
		if (firm != null)
			firm.setParent(this);
		
		this.firm = firm;
	}

	public void setMailStop(MailStop mailStop) {
		if (mailStop != null)
			mailStop.setParent(this);
		
		this.mailStop = mailStop;
	}

	public void setPostalCode(PostalCode postalCode) {
		if (postalCode != null)
			postalCode.setParent(this);
		
		this.postalCode = postalCode;
	}

	public void setPremise(Premise premise) {
		if (premise != null)
			premise.setParent(this);
		
		this.premise = premise;
	}

	public void setPremiseDependency(String premiseDependency) {
		this.premiseDependency = premiseDependency;
	}

	public void setPremiseDependencyType(String premiseDependencyType) {
		this.premiseDependencyType = premiseDependencyType;
	}

	public void setPremiseLocation(PremiseLocation premiseLocation) {
		if (premiseLocation != null)
			premiseLocation.setParent(this);
		
		this.premiseLocation = premiseLocation;
	}

	public void setPremiseName(List<PremiseName> premiseName) {
		this.premiseName = new ChildList<PremiseName>(this, premiseName);
	}

	public void setPremiseNumber(List<PremiseNumber> premiseNumber) {
		this.premiseNumber = new ChildList<PremiseNumber>(this, premiseNumber);
	}

	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix) {
		this.premiseNumberPrefix = new ChildList<PremiseNumberPrefix>(this, premiseNumberPrefix);
	}

	public void setPremiseNumberRange(PremiseNumberRange premiseNumberRange) {
		if (premiseNumberRange != null)
			premiseNumberRange.setParent(this);
		
		this.premiseNumberRange = premiseNumberRange;
	}

	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix) {
		this.premiseNumberSuffix = new ChildList<PremiseNumberSuffix>(this, premiseNumberSuffix);
	}

	public void setPremiseThoroughfareConnector(String premiseThoroughfareConnector) {
		this.premiseThoroughfareConnector = premiseThoroughfareConnector;
	}

	public void setSubPremise(List<SubPremise> subPremise) {
		this.subPremise = new ChildList<SubPremise>(this, subPremise);
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();

		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetBuildingName() {
		if (isSetBuildingName())
			buildingName.clear();

		buildingName = null;
	}

	public boolean unsetBuildingName(BuildingName buildingName) {
		return isSetBuildingName() ? this.buildingName.remove(buildingName) : false;
	}

	public void unsetFirm() {
		if (isSetFirm())
			firm.unsetParent();
		
		firm = null;
	}

	public void unsetMailStop() {
		if (isSetMailStop())
			mailStop.unsetParent();

		mailStop = null;
	}

	public void unsetPostalCode() {
		if (isSetPostalCode())
			postalCode.unsetParent();

		postalCode = null;
	}

	public void unsetPremise() {
		if (isSetPremise())
			premise.unsetParent();

		premise = null;
	}

	public void unsetPremiseDependency() {
		premiseDependency = null;
	}

	public void unsetPremiseDependencyType() {
		premiseDependencyType = null;
	}

	public void unsetPremiseLocation() {
		if (isSetPremiseLocation())
			premiseLocation.unsetParent();

		premiseLocation = null;
	}

	public void unsetPremiseName() {
		if (isSetPremiseName())
			premiseName.clear();

		premiseName = null;
	}

	public boolean unsetPremiseName(PremiseName premiseName) {
		return isSetPremiseName() ? this.premiseName.remove(premiseName) : false;
	}

	public void unsetPremiseNumber() {
		if (isSetPremiseNumber())
			premiseNumber.clear();

		premiseNumber = null;
	}

	public boolean unsetPremiseNumber(PremiseNumber premiseNumber) {
		return isSetPremiseNumber() ? this.premiseNumber.remove(premiseNumber) : false;
	}

	public void unsetPremiseNumberPrefix() {
		if (isSetPremiseNumberPrefix())
			premiseNumberPrefix.clear();

		premiseNumberPrefix = null;
	}

	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		return isSetPremiseNumberPrefix() ? this.premiseNumberPrefix.remove(premiseNumberPrefix) : false;
	}

	public void unsetPremiseNumberRange() {
		if (isSetPremiseNumberRange())
			premiseNumberRange.unsetParent();

		premiseNumberRange = null;
	}

	public void unsetPremiseNumberSuffix() {
		if (isSetPremiseNumberSuffix())
			premiseNumberSuffix.clear();

		premiseNumberSuffix = null;
	}

	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		return isSetPremiseNumberSuffix() ? this.premiseNumberSuffix.remove(premiseNumberSuffix) : false;
	}

	public void unsetPremiseThoroughfareConnector() {
		premiseThoroughfareConnector = null;
	}

	public void unsetSubPremise() {
		if (isSetSubPremise())
			subPremise.clear();

		subPremise = null;
	}

	public boolean unsetSubPremise(SubPremise subPremise) {
		return isSetSubPremise() ? this.subPremise.remove(subPremise) : false;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.PREMISE;
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
		return copyTo(new Premise(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Premise copy = (target == null) ? new Premise() : (Premise)target;
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));

		if (isSetPremiseDependency())
			copy.setPremiseDependency(copyBuilder.copy(premiseDependency));
		
		if (isSetPremiseDependencyType())
			copy.setPremiseDependencyType(copyBuilder.copy(premiseDependencyType));
		
		if (isSetPremiseThoroughfareConnector())
			copy.setPremiseThoroughfareConnector(copyBuilder.copy(premiseThoroughfareConnector));
		
		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetBuildingName()) {
			for (BuildingName part : buildingName) {
				BuildingName copyPart = (BuildingName)copyBuilder.copy(part);
				copy.addBuildingName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPremiseName()) {
			for (PremiseName part : premiseName) {
				PremiseName copyPart = (PremiseName)copyBuilder.copy(part);
				copy.addPremiseName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPremiseNumber()) {
			for (PremiseNumber part : premiseNumber) {
				PremiseNumber copyPart = (PremiseNumber)copyBuilder.copy(part);
				copy.addPremiseNumber(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix part : premiseNumberPrefix) {
				PremiseNumberPrefix copyPart = (PremiseNumberPrefix)copyBuilder.copy(part);
				copy.addPremiseNumberPrefix(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix part : premiseNumberSuffix) {
				PremiseNumberSuffix copyPart = (PremiseNumberSuffix)copyBuilder.copy(part);
				copy.addPremiseNumberSuffix(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetSubPremise()) {
			for (SubPremise part : subPremise) {
				SubPremise copyPart = (SubPremise)copyBuilder.copy(part);
				copy.addSubPremise(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetMailStop()) {
			copy.setMailStop((MailStop)copyBuilder.copy(mailStop));
			if (copy.getMailStop() == mailStop)
				mailStop.setParent(this);
		}

		if (isSetPostalCode()) {
			copy.setPostalCode((PostalCode)copyBuilder.copy(postalCode));
			if (copy.getPostalCode() == postalCode)
				postalCode.setParent(this);
		}
		
		if (isSetFirm()) {
			copy.setFirm((Firm)copyBuilder.copy(firm));
			if (copy.getFirm() == firm)
				firm.setParent(this);
		}
		
		if (isSetPremise()) {
			copy.setPremise((Premise)copyBuilder.copy(premise));
			if (copy.getPremise() == premise)
				premise.setParent(this);
		}
		
		if (isSetPremiseLocation()) {
			copy.setPremiseLocation((PremiseLocation)copyBuilder.copy(premiseLocation));
			if (copy.getPremiseLocation() == premiseLocation)
				premiseLocation.setParent(this);
		}
		
		if (isSetPremiseNumberRange()) {
			copy.setPremiseNumberRange((PremiseNumberRange)copyBuilder.copy(premiseNumberRange));
			if (copy.getPremiseNumberRange() == premiseNumberRange)
				premiseNumberRange.setParent(this);
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
