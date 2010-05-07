package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGMLType;
import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MetaDataProperty;
import org.citygml4j.model.gml.StringOrRef;

public abstract class AbstractGMLImpl extends GMLBaseImpl implements AbstractGML {
	private AbstractGMLType abstractGMLType;

	public AbstractGMLImpl(AbstractGMLType abstractGMLType) {
		this.abstractGMLType = abstractGMLType;
	}

	@Override
	public AbstractGMLType getJAXBObject() {
		return abstractGMLType;
	}

	public StringOrRef getDescription() {
		if (abstractGMLType.isSetDescription())
			return new StringOrRefImpl(abstractGMLType.getDescription());

		return null;
	}

	public String getId() {
		return abstractGMLType.getId();
	}

	public List<Code> getName() {
		List<Code> codeList = new ArrayList<Code>();

		for (JAXBElement<CodeType> codeType : abstractGMLType.getName()) {
			if (codeType.getValue() != null)
				codeList.add(new CodeImpl(codeType.getValue()));
		}

		return codeList;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTGML;
	}

	public MetaDataProperty getMetaDataProperty() {
		// TODO: To be implemented...
		return null;
	}

	public void setId(String id) {
		abstractGMLType.setId(id);
	}

	public void addName(Code name) {
		JAXBElement<CodeType> codeType = ObjectFactory.GML.createName(((CodeImpl)name).getJAXBObject());
		abstractGMLType.getName().add(codeType);
	}

	public void setName(List<Code> names) {
		List<JAXBElement<CodeType>> codeTypeList = new ArrayList<JAXBElement<CodeType>>();
		for (Code name : names)
			codeTypeList.add(ObjectFactory.GML.createName(((CodeImpl)name).getJAXBObject()));

		abstractGMLType.unsetName();
		abstractGMLType.getName().addAll(codeTypeList);
	}

	public void setDescription(StringOrRef description) {
		abstractGMLType.setDescription(((StringOrRefImpl)description).getJAXBObject());
	}

	public boolean isSetId() {
		return abstractGMLType.isSetId();
	}

	public void unsetId() {
		abstractGMLType.setId(null);
	}

	public boolean isSetDescription() {
		return abstractGMLType.isSetDescription();
	}

	public boolean isSetMetaDataProperty() {
		return abstractGMLType.isSetMetaDataProperty();
	}

	public boolean isSetName() {
		return abstractGMLType.isSetName();
	}

	public void unsetDescription() {
		abstractGMLType.setDescription(null);
	}

	public void unsetMetaDataProperty() {
		abstractGMLType.unsetMetaDataProperty();
	}

	public void unsetName() {
		abstractGMLType.unsetName();
	}

	public boolean unsetName(Code name) {
		if (abstractGMLType.isSetName())
			return abstractGMLType.getName().remove(((CodeImpl)name).getJAXBObject());
		
		return false;
	}

}
