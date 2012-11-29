/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: StandardObjectClassifier.java 542 2012-11-29 20:56:44Z nagel $
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
