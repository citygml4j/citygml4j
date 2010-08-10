package org.citygml4j.impl.citygml.core;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractSite;

public abstract class AbstractSiteImpl extends AbstractCityObjectImpl implements AbstractSite {
	private List<ADEComponent> ade;
	
	public void addGenericApplicationPropertyOfSite(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSite() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfSite() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfSite(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfSite() {
		if (isSetGenericApplicationPropertyOfSite())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfSite(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfSite() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACT_SITE;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractSite copy = (AbstractSite)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfSite(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}


}
