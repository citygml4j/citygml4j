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
 * $Id$
 */
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.TunnelModule;

public class OpeningProperty extends FeatureProperty<AbstractOpening> implements TunnelModuleComponent {
	private TunnelModule module;
	
	public OpeningProperty() {
		
	}
	
	public OpeningProperty(AbstractOpening abstractOpening) {
		super(abstractOpening);
	}
	
	public OpeningProperty(String href) {
		super(href);
	}
	
	public OpeningProperty(TunnelModule module) {
		this.module = module;
	}
	
	public AbstractOpening getOpening() {
		return (AbstractOpening)super.getObject();
	}

	public boolean isSetOpening() {
		return super.isSetObject();
	}

	public void setOpening(AbstractOpening opening) {
		super.setObject(opening);
	}

	public void unsetOpening() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TUNNEL_OPENING_PROPERTY;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractOpening> getAssociableClass() {
		return AbstractOpening.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OpeningProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OpeningProperty copy = (target == null) ? new OpeningProperty() : (OpeningProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
