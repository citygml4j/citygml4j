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
package org.citygml4j.model.citygml.transportation;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.TransportationModule;

public class TrafficAreaProperty extends FeatureProperty<TrafficArea> implements TransportationModuleComponent {
	private TransportationModule module;
	
	public TrafficAreaProperty() {

	}
	
	public TrafficAreaProperty(TrafficArea trafficArea) {
		super(trafficArea);
	}
	
	public TrafficAreaProperty(String href) {
		super(href);
	}

	public TrafficAreaProperty(TransportationModule module) {
		this.module = module;
	}
	
	public TrafficArea getTrafficArea() {
		return super.getObject();
	}

	public boolean isSetTrafficArea() {
		return super.isSetObject();
	}

	public void setTrafficArea(TrafficArea trafficArea) {
		super.setObject(trafficArea);
	}

	public void unsetTrafficArea() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRAFFIC_AREA_PROPERTY;
	}

	public final TransportationModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<TrafficArea> getAssociableClass() {
		return TrafficArea.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrafficAreaProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrafficAreaProperty copy = (target == null) ? new TrafficAreaProperty() : (TrafficAreaProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
