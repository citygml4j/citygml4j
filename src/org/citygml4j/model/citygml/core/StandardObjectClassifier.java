package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.model.gml.basicTypes.Code;

public interface StandardObjectClassifier {
	public Code getClazz();
	public List<Code> getFunction();
	public List<Code> getUsage();	
	public boolean isSetClazz();
	public boolean isSetFunction();
	public boolean isSetUsage();
	
	public void setClazz(Code clazz);
	public void setFunction(List<Code> function);
	public void addFunction(Code function);
	public void setUsage(List<Code> usage);
	public void addUsage(Code usage);	
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(Code function);
	public void unsetUsage();
	public boolean unsetUsage(Code usage);
}
