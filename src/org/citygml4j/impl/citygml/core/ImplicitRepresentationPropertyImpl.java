package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AssociationImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.module.citygml.CoreModule;

public class ImplicitRepresentationPropertyImpl extends AssociationImpl<ImplicitGeometry> implements ImplicitRepresentationProperty {
	private CoreModule module;
	
	public ImplicitRepresentationPropertyImpl() {
		
	}
	
	public ImplicitRepresentationPropertyImpl(CoreModule module) {
		this.module = module;
	}
	
	public ImplicitGeometry getImplicitGeometry() {
		return super.getObject();
	}

	public boolean isSetImplicitGeometry() {
		return super.isSetObject();
	}

	public void setImplicitGeometry(ImplicitGeometry implicitGeometry) {
		super.setObject(implicitGeometry);
	}

	public void unsetImplicitGeometry() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.IMPLICITREPRESENTATIONPROPERTY;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ImplicitRepresentationPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ImplicitRepresentationProperty copy = (target == null) ? new ImplicitRepresentationPropertyImpl() : (ImplicitRepresentationProperty)target;
		return super.copyTo(copy, copyBuilder);		
	}

}
