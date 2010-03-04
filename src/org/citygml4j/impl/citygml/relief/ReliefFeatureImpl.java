package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.citygml.core.CityObjectImpl;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class ReliefFeatureImpl extends CityObjectImpl implements ReliefFeature {
	private int lod;
	private List<ReliefComponentProperty> reliefComponent;
	private List<ADEComponent> ade;
	private ReliefModule module;
	
	public ReliefFeatureImpl() {
		
	}
	
	public ReliefFeatureImpl(ReliefModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfReliefFeature(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addReliefComponent(ReliefComponentProperty reliefComponent) {
		if (this.reliefComponent == null)
			this.reliefComponent = new ChildList<ReliefComponentProperty>(this);

		this.reliefComponent.add(reliefComponent);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfReliefFeature() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public int getLod() {
		return lod;
	}

	public List<ReliefComponentProperty> getReliefComponent() {
		if (reliefComponent == null)
			reliefComponent = new ChildList<ReliefComponentProperty>(this);

		return reliefComponent;
	}

	public boolean isSetGenericApplicationPropertyOfReliefFeature() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod() {
		return true;
	}

	public boolean isSetReliefComponent() {
		return reliefComponent != null && !reliefComponent.isEmpty();
	}

	public void setGenericApplicationPropertyOfReliefFeature(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod(int lod) {
		if (lod >= 0 && lod <= 4)
			this.lod = lod;
	}

	public void setReliefComponent(List<ReliefComponentProperty> reliefComponent) {
		this.reliefComponent = new ChildList<ReliefComponentProperty>(this, reliefComponent);
	}

	public void unsetGenericApplicationPropertyOfReliefFeature() {
		if (isSetGenericApplicationPropertyOfReliefFeature())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfReliefFeature(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfReliefFeature() ? this.ade.remove(ade) : false;
	}

	public void unsetReliefComponent() {
		if (isSetReliefComponent())
			reliefComponent.clear();

		reliefComponent = null;
	}

	public boolean unsetReliefComponent(ReliefComponentProperty reliefComponent) {
		return isSetReliefComponent() ? this.reliefComponent.remove(reliefComponent) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEFFEATURE;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();

		if (isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : reliefComponent) {
				if (reliefComponentProperty.isSetObject()) {
					calcBoundedBy(boundedBy, reliefComponentProperty.getObject(), setBoundedBy);
				} else {
					// xlink
				}
			}
		}

		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ReliefFeatureImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ReliefFeature copy = (target == null) ? new ReliefFeatureImpl() : (ReliefFeature)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLod())
			copy.setLod(copyBuilder.copy(lod));

		if (isSetReliefComponent()) {
			for (ReliefComponentProperty part : reliefComponent) {
				ReliefComponentProperty copyPart = (ReliefComponentProperty)copyBuilder.copy(part);
				copy.addReliefComponent(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfReliefFeature(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void visit(FeatureVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(FeatureFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
