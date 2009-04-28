package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.GMLClass;

public class CodeImpl extends GMLBaseImpl implements Code {
	private CodeType codeType;

	public CodeImpl() {
		codeType = new CodeType();
	}

	public CodeImpl(CodeType codeType) {
		this.codeType = codeType;
	}

	@Override
	public CodeType getJAXBObject() {
		return codeType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CODE;
	}

	@Override
	public String getCodeSpace() {
		return codeType.getCodeSpace();
	}

	@Override
	public String getValue() {
		return codeType.getValue();
	}

	@Override
	public void setCodeSpace(String codeSpace) {
		codeType.setCodeSpace(codeSpace);
	}

	@Override
	public void setValue(String value) {
		codeType.setValue(value);
	}

	@Override
	public boolean isSetCodeSpace() {
		return codeType.isSetCodeSpace();
	}

	@Override
	public boolean isSetValue() {
		return codeType.isSetValue();
	}

	@Override
	public void unsetCodeSpace() {
		codeType.setCodeSpace(null);
	}

	@Override
	public void unsetValue() {
		codeType.setValue(null);
	}

}
