package org.citygml4j.impl.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.AbstractFeatureImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.module.citygml.AppearanceModule;

public abstract class AbstractSurfaceDataImpl extends AbstractFeatureImpl implements AbstractSurfaceData {
	private Boolean isFront;
	private List<ADEComponent> ade;
	private AppearanceModule module;

	public AbstractSurfaceDataImpl() {
		
	}
	
	public AbstractSurfaceDataImpl(AppearanceModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfSurfaceData(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSurfaceData() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public Boolean getIsFront() {
		if (!isSetIsFront())
			return true;
		else
			return isFront;
	}

	public boolean isSetGenericApplicationPropertyOfSurfaceData() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetIsFront() {
		return isFront != null;
	}

	public void setGenericApplicationPropertyOfSurfaceData(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setIsFront(Boolean isFront) {
		this.isFront = isFront;
	}

	public void unsetGenericApplicationPropertyOfSurfaceData() {
		if (isSetGenericApplicationPropertyOfSurfaceData())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfSurfaceData(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfSurfaceData() ? this.ade.remove(ade) : false;
	}

	public void unsetIsFront() {
		isFront = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACTSURFACEDATA;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractSurfaceData copy = (AbstractSurfaceData)target;		
		super.copyTo(copy, copyBuilder);

		if (isSetIsFront())
			copy.setIsFront(copyBuilder.copy(isFront));

		if (isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfSurfaceData(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

}
