/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TransportationComplexAttributes extends Attributes {
	@SerializedName("surfaceMaterial")
	private List<String> surfaceMaterials;
	
	public boolean isSetSurfaceMaterials() {
		return surfaceMaterials != null;
	}
	
	public void addSurfaceMaterial(String surfaceMaterial) {
		if (surfaceMaterials == null)
			surfaceMaterials = new ArrayList<>();
		
		surfaceMaterials.add(surfaceMaterial);
	}

	public List<String> getSurfaceMaterials() {
		return surfaceMaterials;
	}

	public void setSurfaceMaterials(List<String> surfaceMaterial) {
		this.surfaceMaterials = surfaceMaterial;
	}
	
	public void unsetSurfaceMaterials() {
		surfaceMaterials = null;
	}

	@Override
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| surfaceMaterials != null;
	}
	
}
