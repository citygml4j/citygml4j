package org.citygml4j.impl.xal;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.ThoroughfareNumberFrom;
import org.citygml4j.model.xal.ThoroughfareNumberRange;
import org.citygml4j.model.xal.ThoroughfareNumberTo;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class ThoroughfareNumberRangeImpl implements ThoroughfareNumberRange {
	private List<AddressLine> addressLine;
	private ThoroughfareNumberFrom thoroughfareNumberFrom;
	private ThoroughfareNumberTo thoroughfareNumberTo;
	private String rangeType;
	private String indicator;
	private String separator;
	private String indicatorOccurrence;
	private String numberRangeOccurrence;
	private String type;
	private String code;
	private Object parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public String getIndicator() {
		return indicator;
	}

	public String getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	public String getNumberRangeOccurrence() {
		return numberRangeOccurrence;
	}

	public String getRangeType() {
		return rangeType;
	}

	public String getSeparator() {
		return separator;
	}

	public ThoroughfareNumberFrom getThoroughfareNumberFrom() {
		return thoroughfareNumberFrom;
	}

	public ThoroughfareNumberTo getThoroughfareNumberTo() {
		return thoroughfareNumberTo;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetIndicatorOccurrence() {
		return indicatorOccurrence != null;
	}

	public boolean isSetNumberRangeOccurrence() {
		return numberRangeOccurrence != null;
	}

	public boolean isSetRangeType() {
		return rangeType != null;
	}

	public boolean isSetSeparator() {
		return separator != null;
	}

	public boolean isSetThoroughfareNumberFrom() {
		return thoroughfareNumberFrom != null;
	}

	public boolean isSetThoroughfareNumberTo() {
		return thoroughfareNumberTo != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			this.indicatorOccurrence = indicatorOccurrence;
	}

	public void setNumberRangeOccurrence(String numberRangeOccurrence) {
		if (numberRangeOccurrence.equals("BeforeName") || numberRangeOccurrence.equals("AfterName") ||
				numberRangeOccurrence.equals("BeforeType") || numberRangeOccurrence.equals("AfterType"))
			this.numberRangeOccurrence = numberRangeOccurrence;
	}

	public void setRangeType(String rangeType) {
		if (rangeType.equals("Odd") || rangeType.equals("Even"))
			this.rangeType = rangeType;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public void setThoroughfareNumberFrom(ThoroughfareNumberFrom thoroughfareNumberFrom) {
		if (thoroughfareNumberFrom != null)
			thoroughfareNumberFrom.setParent(this);
		
		this.thoroughfareNumberFrom = thoroughfareNumberFrom;
	}

	public void setThoroughfareNumberTo(ThoroughfareNumberTo thoroughfareNumberTo) {
		if (thoroughfareNumberTo != null)
			thoroughfareNumberTo.setParent(this);
		
		this.thoroughfareNumberTo = thoroughfareNumberTo;
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

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetIndicatorOccurrence() {
		indicatorOccurrence = null;
	}

	public void unsetNumberRangeOccurrence() {
		numberRangeOccurrence = null;
	}

	public void unsetRangeType() {
		rangeType = null;
	}

	public void unsetSeparator() {
		separator = null;
	}

	public void unsetThoroughfareNumberFrom() {
		if (isSetThoroughfareNumberFrom())
			thoroughfareNumberFrom.unsetParent();
		
		thoroughfareNumberFrom = null;
	}

	public void unsetThoroughfareNumberTo() {
		if (isSetThoroughfareNumberTo())
			thoroughfareNumberTo.unsetParent();
		
		thoroughfareNumberTo = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_RANGE;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ThoroughfareNumberRangeImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberRange copy = (target == null) ? new ThoroughfareNumberRangeImpl() : (ThoroughfareNumberRange)target;
		
		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetThoroughfareNumberFrom()) {
			copy.setThoroughfareNumberFrom((ThoroughfareNumberFrom)copyBuilder.copy(thoroughfareNumberFrom));
			if (copy.getThoroughfareNumberFrom() == thoroughfareNumberFrom)
				thoroughfareNumberFrom.setParent(this);
		}
		
		if (isSetThoroughfareNumberTo()) {
			copy.setThoroughfareNumberTo((ThoroughfareNumberTo)copyBuilder.copy(thoroughfareNumberTo));
			if (copy.getThoroughfareNumberTo() == thoroughfareNumberTo)
				thoroughfareNumberTo.setParent(this);
		}
		
		if (isSetRangeType())
			copy.setRangeType(copyBuilder.copy(rangeType));
		
		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));
		
		if (isSetSeparator())
			copy.setSeparator(copyBuilder.copy(separator));
		
		if (isSetIndicatorOccurrence())
			copy.setIndicatorOccurrence(copyBuilder.copy(indicatorOccurrence));
		
		if (isSetNumberRangeOccurrence())
			copy.setNumberRangeOccurrence(copyBuilder.copy(numberRangeOccurrence));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));		
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T visit(XALFunction<T> visitor) {
		return visitor.accept(this);
	}

}
