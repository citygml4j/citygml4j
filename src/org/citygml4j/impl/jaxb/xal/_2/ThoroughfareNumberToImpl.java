package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.ThoroughfareElement;
import org.citygml4j.jaxb.xal.ThoroughfareNumberElement;
import org.citygml4j.jaxb.xal.ThoroughfareNumberPrefixElement;
import org.citygml4j.jaxb.xal.ThoroughfareNumberSuffixElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.ThoroughfareNumberTo;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberToImpl extends XALBaseImpl implements ThoroughfareNumberTo {
	private ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo thoroughfareNumberTo;

	public ThoroughfareNumberToImpl() {
		thoroughfareNumberTo = new ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo();
	}

	public ThoroughfareNumberToImpl(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo thoroughfareNumberTo) {
		this.thoroughfareNumberTo = thoroughfareNumberTo;
	}

	@Override
	public ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo getJAXBObject() {
		return thoroughfareNumberTo;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARENUMBERTO;
	}

	public void addAddressLine(AddressLine addressLine) {
		thoroughfareNumberTo.getContent().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		thoroughfareNumberTo.getContent().add(((ThoroughfareNumberImpl)thoroughfareNumber).getJAXBObject());
	}


	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		thoroughfareNumberTo.getContent().add(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
	}

	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		thoroughfareNumberTo.getContent().add(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (Object object : thoroughfareNumberTo.getContent())
			if (object instanceof AddressLineElement)
				addressLineList.add(new AddressLineImpl((AddressLineElement)object));

		return addressLineList;
	}

	public String getContent() {
		if (thoroughfareNumberTo.isSetContent()) {
			StringBuffer content = new StringBuffer();
			List<Object> objectList = thoroughfareNumberTo.getContent();

			for (Object object : objectList)
				if (object instanceof String)
					content.append(object.toString());

			return content.toString();
		}

		return null;
	}

	public List<ThoroughfareNumber> getThoroughfareNumber() {
		List<ThoroughfareNumber> thoroughfareNumberList = new ArrayList<ThoroughfareNumber>();

		for (Object object : thoroughfareNumberTo.getContent())
			if (object instanceof ThoroughfareNumberElement)
				thoroughfareNumberList.add(new ThoroughfareNumberImpl((ThoroughfareNumberElement)object));

		return thoroughfareNumberList;
	}

	public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
		List<ThoroughfareNumberPrefix> thoroughfareNumberPrefixList = new ArrayList<ThoroughfareNumberPrefix>();

		for (Object object : thoroughfareNumberTo.getContent())
			if (object instanceof ThoroughfareNumberPrefixElement)
				thoroughfareNumberPrefixList.add(new ThoroughfareNumberPrefixImpl((ThoroughfareNumberPrefixElement)object));

		return thoroughfareNumberPrefixList;
	}

	public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
		List<ThoroughfareNumberSuffix> thoroughfareNumberSuffixList = new ArrayList<ThoroughfareNumberSuffix>();

		for (Object object : thoroughfareNumberTo.getContent())
			if (object instanceof ThoroughfareNumberSuffixElement)
				thoroughfareNumberSuffixList.add(new ThoroughfareNumberSuffixImpl((ThoroughfareNumberSuffixElement)object));

		return thoroughfareNumberSuffixList;
	}

	public void unsetContent() {
		thoroughfareNumberTo.unsetContent();
	}

	public void addContent(String content) {
		thoroughfareNumberTo.getContent().add(content);		
	}

	public String getCode() {
		return thoroughfareNumberTo.getCode();
	}

	public void setCode(String code) {
		thoroughfareNumberTo.setCode(code);
	}

	public boolean isSetAddressLine() {
		if (thoroughfareNumberTo.isSetContent()) {
			List<Object> objectList = thoroughfareNumberTo.getContent();

			for (Object object : objectList)
				if (object instanceof AddressLineElement)
					return true;
		}

		return false;
	}

	public boolean isSetContent() {
		return thoroughfareNumberTo.isSetContent();
	}

	public boolean isSetThoroughfareNumber() {
		if (thoroughfareNumberTo.isSetContent()) {
			List<Object> objectList = thoroughfareNumberTo.getContent();

			for (Object object : objectList)
				if (object instanceof ThoroughfareNumberElement)
					return true;
		}

		return false;
	}

	public boolean isSetThoroughfareNumberPrefix() {
		if (thoroughfareNumberTo.isSetContent()) {
			List<Object> objectList = thoroughfareNumberTo.getContent();

			for (Object object : objectList)
				if (object instanceof ThoroughfareNumberPrefixElement)
					return true;
		}

		return false;
	}

	public boolean isSetThoroughfareNumberSuffix() {
		if (thoroughfareNumberTo.isSetContent()) {
			List<Object> objectList = thoroughfareNumberTo.getContent();

			for (Object object : objectList)
				if (object instanceof ThoroughfareNumberSuffixElement)
					return true;
		}

		return false;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		unsetAddressLine();

		List<Object> elemList = new ArrayList<Object>();
		for (AddressLine object : addressLine)
			elemList.add(((AddressLineImpl)object).getJAXBObject());

		thoroughfareNumberTo.getContent().addAll(elemList);
	}

	public void setThoroughfareNumber(List<ThoroughfareNumber> thoroughfareNumber) {
		unsetThoroughfareNumber();

		List<Object> elemList = new ArrayList<Object>();
		for (ThoroughfareNumber object : thoroughfareNumber)
			elemList.add(((ThoroughfareNumberImpl)object).getJAXBObject());

		thoroughfareNumberTo.getContent().addAll(elemList);
	}

	public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix) {
		unsetThoroughfareNumberPrefix();

		List<Object> elemList = new ArrayList<Object>();
		for (ThoroughfareNumberPrefix object : thoroughfareNumberPrefix)
			elemList.add(((ThoroughfareNumberPrefixImpl)object).getJAXBObject());

		thoroughfareNumberTo.getContent().addAll(elemList);
	}

	public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix) {
		unsetThoroughfareNumberSuffix();

		List<Object> elemList = new ArrayList<Object>();
		for (ThoroughfareNumberSuffix object : thoroughfareNumberSuffix)
			elemList.add(((ThoroughfareNumberSuffixImpl)object).getJAXBObject());

		thoroughfareNumberTo.getContent().addAll(elemList);
	}

	public void unsetAddressLine() {
		if (thoroughfareNumberTo.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberTo.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof AddressLineElement)
					iter.remove();
			}			
		}
	}

	public void unsetThoroughfareNumber() {
		if (thoroughfareNumberTo.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberTo.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof ThoroughfareNumberElement)
					iter.remove();
			}			
		}
	}

	public void unsetThoroughfareNumberPrefix() {
		if (thoroughfareNumberTo.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberTo.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof ThoroughfareNumberPrefixElement)
					iter.remove();
			}			
		}
	}

	public void unsetThoroughfareNumberSuffix() {
		if (thoroughfareNumberTo.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberTo.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof ThoroughfareNumberSuffixElement)
					iter.remove();
			}			
		}
	}

	public boolean isSetCode() {
		return thoroughfareNumberTo.isSetCode();
	}

	public void unsetCode() {
		thoroughfareNumberTo.setCode(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (thoroughfareNumberTo.isSetContent())
			return thoroughfareNumberTo.getContent().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		if (thoroughfareNumberTo.isSetContent())
			return thoroughfareNumberTo.getContent().remove(((ThoroughfareNumberImpl)thoroughfareNumber).getJAXBObject());
		
		return false;
	}

	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (thoroughfareNumberTo.isSetContent())
			return thoroughfareNumberTo.getContent().remove(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
		
		return false;
	}

	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (thoroughfareNumberTo.isSetContent())
			return thoroughfareNumberTo.getContent().remove(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
		
		return false;
	}

}
