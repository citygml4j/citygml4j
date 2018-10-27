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
package org.citygml4j.binding.cityjson.feature;

public class SolitaryVegetationObjectAttributes extends Attributes {
	private String species;
	private Double trunkDiameter;
	private Double crownDiameter;
	
	public boolean isSetSpecies() {
		return species != null;
	}
	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void unsetSpecies() {
		species = null;
	}

	public boolean isSetTrunkDiameter() {
		return trunkDiameter != null;
	}
	
	public Double getTrunkDiameter() {
		return trunkDiameter;
	}

	public void setTrunkDiameter(Double trunkDiameter) {
		this.trunkDiameter = trunkDiameter;
	}
	
	public void unsetTrunkDiameter() {
		trunkDiameter = null;
	}

	public boolean isSetCrownDiameter() {
		return crownDiameter != null;
	}
	
	public Double getCrownDiameter() {
		return crownDiameter;
	}

	public void setCrownDiameter(Double crownDiameter) {
		this.crownDiameter = crownDiameter;
	}
	
	public void unsetCrownDiameter() {
		crownDiameter = null;
	}
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| species != null
				|| trunkDiameter != null
				|| crownDiameter != null;
	}
	
}
