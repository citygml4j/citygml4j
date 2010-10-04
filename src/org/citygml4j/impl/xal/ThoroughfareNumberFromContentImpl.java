package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.ThoroughfareNumberFromContent;
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberFromContentImpl implements ThoroughfareNumberFromContent {
	private AddressLine addressLine;
	private ThoroughfareNumber thoroughfareNumber;
	private ThoroughfareNumberPrefix thoroughfareNumberPrefix;
	private ThoroughfareNumberSuffix thoroughfareNumberSuffix;
	private String string;	
	private ModelObject parent;
	
	public ThoroughfareNumberFromContentImpl() {
		
	}
	
	public ThoroughfareNumberFromContentImpl(AddressLine addressLine) {
		setAddressLine(addressLine);
	}
	
	public ThoroughfareNumberFromContentImpl(ThoroughfareNumber thoroughfareNumber) {
		setThoroughfareNumber(thoroughfareNumber);
	}
	
	public ThoroughfareNumberFromContentImpl(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		setThoroughfareNumberPrefix(thoroughfareNumberPrefix);
	}
	
	public ThoroughfareNumberFromContentImpl(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		setThoroughfareNumberSuffix(thoroughfareNumberSuffix);
	}
	
	public ThoroughfareNumberFromContentImpl(String string) {
		setString(string);
	}
	
	public ModelType getModelType() {
		return ModelType.XAL;
	}
	
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_FROM_CONTENT;
	}

	public AddressLine getAddressLine() {
		return addressLine;
	}

	public String getString() {
		return string;
	}

	public ThoroughfareNumber getThoroughfareNumber() {
		return thoroughfareNumber;
	}

	public ThoroughfareNumberPrefix getThoroughfareNumberPrefix() {
		return thoroughfareNumberPrefix;
	}

	public ThoroughfareNumberSuffix getThoroughfareNumberSuffix() {
		return thoroughfareNumberSuffix;
	}

	public boolean isSetAddressLine() {
		return addressLine != null;
	}

	public boolean isSetString() {
		return string != null;
	}

	public boolean isSetThoroughfareNumber() {
		return thoroughfareNumber != null;
	}

	public boolean isSetThoroughfareNumberPrefix() {
		return thoroughfareNumberPrefix != null;
	}

	public boolean isSetThoroughfareNumberSuffix() {
		return thoroughfareNumberSuffix != null;
	}

	public void setAddressLine(AddressLine addressLine) {
		if (addressLine != null)
			addressLine.setParent(this);
		
		this.addressLine = addressLine;
		unsetString();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberPrefix();
		unsetThoroughfareNumberSuffix();
	}

	public void setThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		if (thoroughfareNumber != null)
			thoroughfareNumber.setParent(this);
		
		this.thoroughfareNumber = thoroughfareNumber;
		unsetString();
		unsetAddressLine();
		unsetThoroughfareNumberPrefix();
		unsetThoroughfareNumberSuffix();
	}

	public void setThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (thoroughfareNumberPrefix != null)
			thoroughfareNumberPrefix.setParent(this);
		
		this.thoroughfareNumberPrefix = thoroughfareNumberPrefix;
		unsetString();
		unsetAddressLine();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberSuffix();
	}

	public void setThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (thoroughfareNumberSuffix != null)
			thoroughfareNumberSuffix.setParent(this);
		
		this.thoroughfareNumberSuffix = thoroughfareNumberSuffix;
		unsetString();
		unsetAddressLine();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberPrefix();
	}

	public void setString(String string) {
		this.string = string;
		unsetAddressLine();
		unsetThoroughfareNumber();
		unsetThoroughfareNumberPrefix();
		unsetThoroughfareNumberSuffix();
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.unsetParent();
		
		addressLine = null;
	}

	public void unsetString() {
		string = null;
	}

	public void unsetThoroughfareNumber() {
		if (isSetThoroughfareNumber())
			thoroughfareNumber.unsetParent();
		
		thoroughfareNumber = null;
	}

	public void unsetThoroughfareNumberPrefix() {
		if (isSetThoroughfareNumberPrefix())
			thoroughfareNumberPrefix.unsetParent();
		
		thoroughfareNumberPrefix = null;
	}

	public void unsetThoroughfareNumberSuffix() {
		if (isSetThoroughfareNumberSuffix())
			thoroughfareNumberSuffix.unsetParent();
		
		thoroughfareNumberSuffix = null;
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
		return copyTo(new ThoroughfareNumberFromContentImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberFromContent copy = (target == null) ? new ThoroughfareNumberFromContentImpl() : (ThoroughfareNumberFromContent)target;
		
		if (isSetAddressLine()) {
			copy.setAddressLine((AddressLine)copyBuilder.copy(addressLine));
			if (copy.getAddressLine() == addressLine)
				addressLine.setParent(this);
		}
		
		if (isSetThoroughfareNumber()) {
			copy.setThoroughfareNumber((ThoroughfareNumber)copyBuilder.copy(thoroughfareNumber));
			if (copy.getThoroughfareNumber() == thoroughfareNumber)
				thoroughfareNumber.setParent(this);
		}
		
		if (isSetThoroughfareNumberPrefix()) {
			copy.setThoroughfareNumberPrefix((ThoroughfareNumberPrefix)copyBuilder.copy(thoroughfareNumberPrefix));
			if (copy.getThoroughfareNumberPrefix() == thoroughfareNumberPrefix)
				thoroughfareNumberPrefix.setParent(this);
		}
		
		if (isSetThoroughfareNumberSuffix()) {
			copy.setThoroughfareNumberSuffix((ThoroughfareNumberSuffix)copyBuilder.copy(thoroughfareNumberSuffix));
			if (copy.getThoroughfareNumberSuffix() == thoroughfareNumberSuffix)
				thoroughfareNumberSuffix.setParent(this);
		}
		
		if (isSetString())
			copy.setString(copyBuilder.copy(string));
		
		copy.unsetParent();
		
		return copy;
	}

}
