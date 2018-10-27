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
package org.citygml4j.model.gml.geometry;

import org.citygml4j.model.gml.GML;

import java.util.List;

public interface SRSInformationGroup extends GML {
	public List<String> getAxisLabels();
	public List<String> getUomLabels();
	public boolean isSetAxisLabels();
	public boolean isSetUomLabels();

	public void setAxisLabels(List<String> axisLabels);
	public void addAxisLabel(String axisLabel);
	public void setUomLabels(List<String> uomLabels);
	public void addUomLabel(String uomLabel);
	public void unsetAxisLabels();
	public boolean unsetAxisLabels(String axisLabel);
	public void unsetUomLabels();
	public boolean unsetUomLabels(String uomLabel);
}
