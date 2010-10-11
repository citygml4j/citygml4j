package org.citygml4j.impl.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.module.citygml.ReliefModule;

public class TinPropertyImpl extends GeometryPropertyImpl<TriangulatedSurface> implements TinProperty {
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

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TIN_PROPERTY;
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
