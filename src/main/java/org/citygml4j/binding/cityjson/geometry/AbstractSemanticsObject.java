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
package org.citygml4j.binding.cityjson.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSemanticsObject {
	private List<SemanticsType> surfaces;

	public abstract void addNullValue();
	public abstract int getNumValues();
	public abstract List<Integer> flatValues();
	public abstract void unsetValues();

	public boolean isSetSurfaces() {
		return surfaces != null;
	}

	public void addSurface(SemanticsType surface) {
		if (surfaces == null)
			surfaces = new ArrayList<>();

		surfaces.add(surface);
	}

	public List<SemanticsType> getSurfaces() {
		return surfaces;
	}

	public void setSurfaces(List<SemanticsType> surfaces) {
		this.surfaces = surfaces;
	}
	
	public void removeSurface(SemanticsType surface) {
		if (surfaces != null)
			surfaces.remove(surface);
	}

	public void unsetSurfaces() {
		surfaces = null;
	}
	
	public int getNumSurfaces() {
		return surfaces != null ? surfaces.size() : 0;
	}

}
