package org.citygml4j.model.citygml.generics;

import java.util.List;

public interface GenericAttributeSet extends AbstractGenericAttribute {
	public List<AbstractGenericAttribute> getGenericAttribute();
	public String getCodeSpace();
	
	public boolean isSetGenericAttribute();
	public boolean isSetCodeSpace();
	
	public void setGenericAttribute(List<AbstractGenericAttribute> genericAttribute);
	public void addGenericAttribute(AbstractGenericAttribute genericAttribute);
	public void setCodeSpace(String codeSpace);
	public void unsetGenericAttribute();
	public boolean unsetGenericAttribute(AbstractGenericAttribute genericAttribute);
	public void unsetCodeSpace();	
}
