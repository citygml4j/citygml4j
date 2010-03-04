package org.citygml4j.impl.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AssociationImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.gml.TriangulatedSurface;
import org.citygml4j.model.module.citygml.ReliefModule;

public class TinPropertyImpl extends AssociationImpl<TriangulatedSurface> implements TinProperty {
	private ReliefModule module;
	
	public TinPropertyImpl() {
		
	}
	
	public TinPropertyImpl(ReliefModule module) {
		this.module = module;
	}
	
	public TriangulatedSurface getTriangulatedSurface() {
		return super.getObject();
	}

	public boolean isSetTriangulatedSurface() {
		return super.isSetObject();
	}

	public void setTriangulatedSurface(TriangulatedSurface triangulatedSurface) {
		super.setObject(triangulatedSurface);
	}

	public void unsetTriangulatedSurface() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TINPROPERTY;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TinPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TinProperty copy = (target == null) ? new TinPropertyImpl() : (TinProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
