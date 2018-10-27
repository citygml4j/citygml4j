/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.basicTypes.Code;

import java.util.List;

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
