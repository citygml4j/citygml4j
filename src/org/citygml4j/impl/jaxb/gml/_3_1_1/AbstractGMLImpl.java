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

	@Override
	public StringOrRef getDescription() {
		if (abstractGMLType.isSetDescription())
			return new StringOrRefImpl(abstractGMLType.getDescription());

		return null;
	}

	@Override
	public String getId() {
		return abstractGMLType.getId();
	}

	@Override
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

	@Override
	public MetaDataProperty getMetaDataProperty() {
		// TODO: To be implemented...
		return null;
	}

	@Override
	public void setId(String id) {
		abstractGMLType.setId(id);
	}

	@Override
	public void addName(Code name) {
		JAXBElement<CodeType> codeType = ObjectFactory.GML.createName(((CodeImpl)name).getJAXBObject());
		abstractGMLType.getName().add(codeType);
	}

	@Override
	public void setName(List<Code> names) {
		List<JAXBElement<CodeType>> codeTypeList = new ArrayList<JAXBElement<CodeType>>();
		for (Code name : names)
			codeTypeList.add(ObjectFactory.GML.createName(((CodeImpl)name).getJAXBObject()));

		abstractGMLType.unsetName();
		abstractGMLType.getName().addAll(codeTypeList);
	}

	@Override
	public void setDescription(StringOrRef description) {
		abstractGMLType.setDescription(((StringOrRefImpl)description).getJAXBObject());
	}

	@Override
	public boolean isSetId() {
		return abstractGMLType.isSetId();
	}

	@Override
	public void unsetId() {
		abstractGMLType.setId(null);
	}

	@Override
	public boolean isSetDescription() {
		return abstractGMLType.isSetDescription();
	}

	@Override
	public boolean isSetMetaDataProperty() {
		return abstractGMLType.isSetMetaDataProperty();
	}

	@Override
	public boolean isSetName() {
		return abstractGMLType.isSetName();
	}

	@Override
	public void unsetDescription() {
		abstractGMLType.setDescription(null);
	}

	@Override
	public void unsetMetaDataProperty() {
		abstractGMLType.unsetMetaDataProperty();
	}

	@Override
	public void unsetName() {
		abstractGMLType.unsetName();
	}

	@Override
	public boolean unsetName(Code name) {
		if (abstractGMLType.isSetName())
			return abstractGMLType.getName().remove(((CodeImpl)name).getJAXBObject());
		
		return false;
	}

}
