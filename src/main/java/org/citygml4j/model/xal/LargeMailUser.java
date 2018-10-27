/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

public class LargeMailUser implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<LargeMailUserName> largeMailUserName;
	private List<BuildingName> buildingName;
	private LargeMailUserIdentifier largeMailUserIdentifier;
	private Department department;
	private PostBox postBox;
	private Thoroughfare thoroughfare;
	private PostalCode postalCode;
	private String type;
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

	public void addLargeMailUserName(LargeMailUserName largeMailUserName) {
		if (this.largeMailUserName == null)
			this.largeMailUserName = new ChildList<LargeMailUserName>(this);

		this.largeMailUserName.add(largeMailUserName);
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

	public Department getDepartment() {
		return department;
	}

	public LargeMailUserIdentifier getLargeMailUserIdentifier() {
		return largeMailUserIdentifier;
	}

	public List<LargeMailUserName> getLargeMailUserName() {
		if (largeMailUserName == null)
			largeMailUserName = new ChildList<LargeMailUserName>(this);

		return largeMailUserName;
	}

	public PostBox getPostBox() {
		return postBox;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public Thoroughfare getThoroughfare() {
		return thoroughfare;
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

	public boolean isSetDepartment() {
		return department != null;
	}

	public boolean isSetLargeMailUserIdentifier() {
		return largeMailUserIdentifier != null;
	}

	public boolean isSetLargeMailUserName() {
		return largeMailUserName != null && !largeMailUserName.isEmpty();
	}

	public boolean isSetPostBox() {
		return postBox != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetThoroughfare() {
		return thoroughfare != null;
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

	public void setDepartment(Department department) {
		if (department != null)
			department.setParent(this);

		this.department = department;
	}

	public void setLargeMailUserIdentifier(LargeMailUserIdentifier largeMailUserIdentifier) {
		if (largeMailUserIdentifier != null)
			largeMailUserIdentifier.setParent(this);

		this.largeMailUserIdentifier = largeMailUserIdentifier;
	}

	public void setLargeMailUserName(List<LargeMailUserName> largeMailUserName) {
		this.largeMailUserName = new ChildList<LargeMailUserName>(this, largeMailUserName);
	}

	public void setPostBox(PostBox postBox) {
		if (postBox != null)
			postBox.setParent(this);

		this.postBox = postBox;
	}

	public void setPostalCode(PostalCode postalCode) {
		if (postalCode != null)
			postalCode.setParent(this);

		this.postalCode = postalCode;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		if (thoroughfare != null)
			thoroughfare.setParent(this);

		this.thoroughfare = thoroughfare;
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

	public void unsetDepartment() {
		if (isSetDepartment())
			department.unsetParent();

		department = null;
	}

	public void unsetLargeMailUserIdentifier() {
		if (isSetLargeMailUserIdentifier())
			largeMailUserIdentifier.unsetParent();

		largeMailUserIdentifier = null;
	}

	public void unsetLargeMailUserName() {
		if (isSetLargeMailUserName())
			largeMailUserName.clear();

		largeMailUserName = null;
	}

	public boolean unsetLargeMailUserName(LargeMailUserName largeMailUserName) {
		return isSetLargeMailUserName() ? this.largeMailUserName.remove(largeMailUserName) : false;
	}

	public void unsetPostBox() {
		if (isSetPostBox())
			postBox.unsetParent();

		postBox = null;
	}

	public void unsetPostalCode() {
		if (isSetPostalCode())
			postalCode.unsetParent();

		postalCode = null;
	}

	public void unsetThoroughfare() {
		if (isSetThoroughfare())
			thoroughfare.unsetParent();

		thoroughfare = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.LARGE_MAIL_USER;
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
		return copyTo(new LargeMailUser(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LargeMailUser copy = (target == null) ? new LargeMailUser() : (LargeMailUser)target;
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));

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
		
		if (isSetLargeMailUserName()) {
			for (LargeMailUserName part : largeMailUserName) {
				LargeMailUserName copyPart = (LargeMailUserName)copyBuilder.copy(part);
				copy.addLargeMailUserName(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetLargeMailUserIdentifier()) {
			copy.setLargeMailUserIdentifier((LargeMailUserIdentifier)copyBuilder.copy(largeMailUserIdentifier));
			if (copy.getLargeMailUserIdentifier() == largeMailUserIdentifier)
				largeMailUserIdentifier.setParent(this);
		}
		
		if (isSetDepartment()) {
			copy.setDepartment((Department)copyBuilder.copy(department));
			if (copy.getDepartment() == department)
				department.setParent(this);
		}
		
		if (isSetPostBox()) {
			copy.setPostBox((PostBox)copyBuilder.copy(postBox));
			if (copy.getPostBox() == postBox)
				postBox.setParent(this);
		}

		if (isSetThoroughfare()) {
			copy.setThoroughfare((Thoroughfare)copyBuilder.copy(thoroughfare));
			if (copy.getThoroughfare() == thoroughfare)
				thoroughfare.setParent(this);
		}

		if (isSetPostalCode()) {
			copy.setPostalCode((PostalCode)copyBuilder.copy(postalCode));
			if (copy.getPostalCode() == postalCode)
				postalCode.setParent(this);
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
