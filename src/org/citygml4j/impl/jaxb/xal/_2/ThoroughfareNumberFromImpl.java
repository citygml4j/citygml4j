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
import org.citygml4j.model.xal.ThoroughfareNumberFrom;
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberFromImpl extends XALBaseImpl implements ThoroughfareNumberFrom {
	private ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom thoroughfareNumberFrom;

	public ThoroughfareNumberFromImpl() {
		thoroughfareNumberFrom = new ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom();
	}

	public ThoroughfareNumberFromImpl(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom thoroughfareNumberFrom) {
		this.thoroughfareNumberFrom = thoroughfareNumberFrom;
	}

	@Override
	public ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom getJAXBObject() {
		return thoroughfareNumberFrom;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARENUMBERFROM;
	}

	@Override
	public void addAddressLine(AddressLine addressLine) {
		thoroughfareNumberFrom.getContent().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		thoroughfareNumberFrom.getContent().add(((ThoroughfareNumberImpl)thoroughfareNumber).getJAXBObject());
	}


	@Override
	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		thoroughfareNumberFrom.getContent().add(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
	}

	@Override
	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		thoroughfareNumberFrom.getContent().add(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<Object> objectList = thoroughfareNumberFrom.getContent();

		for (Object object : objectList)
			if (object instanceof AddressLineElement)
				addressLineList.add(new AddressLineImpl((AddressLineElement)object));

		return addressLineList;
	}

	@Override
	public String getContent() {
		if (thoroughfareNumberFrom.isSetContent()) {
			StringBuffer content = new StringBuffer();
			List<Object> objectList = thoroughfareNumberFrom.getContent();

			for (Object object : objectList)
				if (object instanceof String)
					content.append(object.toString());

			return content.toString();
		}

		return null;
	}

	@Override
	public List<ThoroughfareNumber> getThoroughfareNumber() {
		List<ThoroughfareNumber> thoroughfareNumberList = new ArrayList<ThoroughfareNumber>();
		List<Object> objectList = thoroughfareNumberFrom.getContent();

		for (Object object : objectList)
			if (object instanceof ThoroughfareNumberElement)
				thoroughfareNumberList.add(new ThoroughfareNumberImpl((ThoroughfareNumberElement)object));

		return thoroughfareNumberList;
	}

	@Override
	public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
		List<ThoroughfareNumberPrefix> thoroughfareNumberPrefixList = new ArrayList<ThoroughfareNumberPrefix>();
		List<Object> objectList = thoroughfareNumberFrom.getContent();

		for (Object object : objectList)
			if (object instanceof ThoroughfareNumberPrefixElement)
				thoroughfareNumberPrefixList.add(new ThoroughfareNumberPrefixImpl((ThoroughfareNumberPrefixElement)object));

		return thoroughfareNumberPrefixList;
	}

	@Override
	public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
		List<ThoroughfareNumberSuffix> thoroughfareNumberSuffixList = new ArrayList<ThoroughfareNumberSuffix>();
		List<Object> objectList = thoroughfareNumberFrom.getContent();

		for (Object object : objectList)
			if (object instanceof ThoroughfareNumberSuffixElement)
				thoroughfareNumberSuffixList.add(new ThoroughfareNumberSuffixImpl((ThoroughfareNumberSuffixElement)object));

		return thoroughfareNumberSuffixList;
	}

	@Override
	public void unsetContent() {
		thoroughfareNumberFrom.unsetContent();
	}

	@Override
	public void addContent(String content) {
		thoroughfareNumberFrom.getContent().add(content);		
	}

	@Override
	public String getCode() {
		return thoroughfareNumberFrom.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfareNumberFrom.setCode(code);
	}

	@Override
	public boolean isSetAddressLine() {
		if (thoroughfareNumberFrom.isSetContent()) {
			List<Object> objectList = thoroughfareNumberFrom.getContent();

			for (Object object : objectList)
				if (object instanceof AddressLineElement)
					return true;
		}

		return false;
	}

	@Override
	public boolean isSetContent() {
		return thoroughfareNumberFrom.isSetContent();
	}

	@Override
	public boolean isSetThoroughfareNumber() {
		if (thoroughfareNumberFrom.isSetContent()) {
			List<Object> objectList = thoroughfareNumberFrom.getContent();

			for (Object object : objectList)
				if (object instanceof ThoroughfareNumberElement)
					return true;
		}

		return false;
	}

	@Override
	public boolean isSetThoroughfareNumberPrefix() {
		if (thoroughfareNumberFrom.isSetContent()) {
			List<Object> objectList = thoroughfareNumberFrom.getContent();

			for (Object object : objectList)
				if (object instanceof ThoroughfareNumberPrefixElement)
					return true;
		}

		return false;
	}

	@Override
	public boolean isSetThoroughfareNumberSuffix() {
		if (thoroughfareNumberFrom.isSetContent()) {
			List<Object> objectList = thoroughfareNumberFrom.getContent();

			for (Object object : objectList)
				if (object instanceof ThoroughfareNumberSuffixElement)
					return true;
		}

		return false;
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		unsetAddressLine();

		List<Object> elemList = new ArrayList<Object>();
		for (AddressLine object : addressLine)
			elemList.add(((AddressLineImpl)object).getJAXBObject());

		thoroughfareNumberFrom.getContent().addAll(elemList);
	}

	@Override
	public void setThoroughfareNumber(List<ThoroughfareNumber> thoroughfareNumber) {
		unsetThoroughfareNumber();

		List<Object> elemList = new ArrayList<Object>();
		for (ThoroughfareNumber object : thoroughfareNumber)
			elemList.add(((ThoroughfareNumberImpl)object).getJAXBObject());

		thoroughfareNumberFrom.getContent().addAll(elemList);
	}

	@Override
	public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix) {
		unsetThoroughfareNumberPrefix();

		List<Object> elemList = new ArrayList<Object>();
		for (ThoroughfareNumberPrefix object : thoroughfareNumberPrefix)
			elemList.add(((ThoroughfareNumberPrefixImpl)object).getJAXBObject());

		thoroughfareNumberFrom.getContent().addAll(elemList);
	}

	@Override
	public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix) {
		unsetThoroughfareNumberSuffix();

		List<Object> elemList = new ArrayList<Object>();
		for (ThoroughfareNumberSuffix object : thoroughfareNumberSuffix)
			elemList.add(((ThoroughfareNumberSuffixImpl)object).getJAXBObject());

		thoroughfareNumberFrom.getContent().addAll(elemList);
	}

	@Override
	public void unsetAddressLine() {
		if (thoroughfareNumberFrom.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberFrom.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof AddressLineElement)
					iter.remove();
			}			
		}
	}

	@Override
	public void unsetThoroughfareNumber() {
		if (thoroughfareNumberFrom.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberFrom.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof ThoroughfareNumberElement)
					iter.remove();
			}			
		}
	}

	@Override
	public void unsetThoroughfareNumberPrefix() {
		if (thoroughfareNumberFrom.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberFrom.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof ThoroughfareNumberPrefixElement)
					iter.remove();
			}			
		}
	}

	@Override
	public void unsetThoroughfareNumberSuffix() {
		if (thoroughfareNumberFrom.isSetContent()) {
			Iterator<Object> iter = thoroughfareNumberFrom.getContent().iterator();

			while (iter.hasNext()) {
				Object object = iter.next();
				if (object instanceof ThoroughfareNumberSuffixElement)
					iter.remove();
			}			
		}
	}

	@Override
	public boolean isSetCode() {
		return thoroughfareNumberFrom.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfareNumberFrom.setCode(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (thoroughfareNumberFrom.isSetContent())
			return thoroughfareNumberFrom.getContent().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		if (thoroughfareNumberFrom.isSetContent())
			return thoroughfareNumberFrom.getContent().remove(((ThoroughfareNumberImpl)thoroughfareNumber).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (thoroughfareNumberFrom.isSetContent())
			return thoroughfareNumberFrom.getContent().remove(((ThoroughfareNumberPrefixImpl)thoroughfareNumberPrefix).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (thoroughfareNumberFrom.isSetContent())
			return thoroughfareNumberFrom.getContent().remove(((ThoroughfareNumberSuffixImpl)thoroughfareNumberSuffix).getJAXBObject());
		
		return false;
	}

}
