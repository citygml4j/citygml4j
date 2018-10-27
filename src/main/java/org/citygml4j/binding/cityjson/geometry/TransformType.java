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

import java.util.List;

public class TransformType {
	List<Double> scale;
	List<Double> translate;
	
	public boolean isSetScale() {
		return scale != null && scale.size() >= 3;
	}
	
	public List<Double> getScale() {
		return isSetScale() ? scale.subList(0, 3) : null;
	}

	public void setScale(List<Double> scale) {
		if (scale == null)
			this.scale = null;
		else if (scale != null && scale.size() >= 3)
			this.scale = scale.subList(0, 3);
	}
	
	public void unsetScale() {
		scale = null;
	}
	
	public boolean isSetTranslate() {
		return translate != null && translate.size() >= 3;
	}
	
	public List<Double> getTranslate() {
		return isSetTranslate() ? translate.subList(0, 3) : null;
	}

	public void setTranslate(List<Double> translate) {
		if (translate == null)
			this.translate = null;
		else if (translate != null && translate.size() >= 3)
			this.translate = translate.subList(0, 3);
	}
	
	public void unsetTranslate() {
		translate = null;
	}
	
}
