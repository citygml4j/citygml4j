/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
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
