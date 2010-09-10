package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class TINReliefImpl extends AbstractReliefComponentImpl implements TINRelief {
	private TinProperty tin;
	private List<ADEComponent> ade;

	public TINReliefImpl() {

	}

	public TINReliefImpl(ReliefModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfTinRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTinRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public TinProperty getTin() {
		return tin;
	}

	public boolean isSetGenericApplicationPropertyOfTinRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetTin() {
		return tin != null;
	}

	public void setGenericApplicationPropertyOfTinRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setTin(TinProperty tin) {
		if (tin != null)
			tin.setParent(this);

		this.tin = tin;
	}

	public void unsetGenericApplicationPropertyOfTinRelief() {
		if (isSetGenericApplicationPropertyOfTinRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTinRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTinRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetTin() {
		if (isSetTin())
			tin.unsetParent();

		tin = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TIN_RELIEF;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = super.calcBoundedBy(false);
		if (boundedBy == null)
			boundedBy = new BoundingShapeImpl();

		if (isSetTin()) {
			if (tin.isSetObject()) {
				calcBoundedBy(boundedBy, tin.getObject());
			} else {
				// xlink
			}
		}

		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();

		if (isSetTin()) {
			List<GeometryProperty<? extends AbstractGeometry>> propertyList = lodRepresentation.getLodRepresentation(getLod());
			if (propertyList != null)
				propertyList.add(tin);
		}

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TINReliefImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TINRelief copy = (target == null) ? new TINReliefImpl() : (TINRelief)target;
		super.copyTo(copy, copyBuilder);

		if (isSetTin()) {
			copy.setTin((TinProperty)copyBuilder.copy(tin));
			if (copy.getTin() == tin)
				tin.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTinRelief(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}

	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
