package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class BreaklineReliefImpl extends AbstractReliefComponentImpl implements BreaklineRelief {
	private MultiCurveProperty ridgeOrValleyLines;
	private MultiCurveProperty breaklines;
	private List<ADEComponent> ade;

	public BreaklineReliefImpl() {

	}

	public BreaklineReliefImpl(ReliefModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfBreaklineRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public MultiCurveProperty getBreaklines() {
		return breaklines;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBreaklineRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiCurveProperty getRidgeOrValleyLines() {
		return ridgeOrValleyLines;
	}

	public boolean isSetBreaklines() {
		return breaklines != null;
	}

	public boolean isSetGenericApplicationPropertyOfBreaklineRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetRidgeOrValleyLines() {
		return ridgeOrValleyLines != null;
	}

	public void setBreaklines(MultiCurveProperty breaklines) {
		if (breaklines != null)
			breaklines.setParent(this);

		this.breaklines = breaklines;
	}

	public void setGenericApplicationPropertyOfBreaklineRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setRidgeOrValleyLines(MultiCurveProperty ridgeOrValleyLines) {
		if (ridgeOrValleyLines != null)
			ridgeOrValleyLines.setParent(this);

		this.ridgeOrValleyLines = ridgeOrValleyLines;
	}

	public void unsetBreaklines() {
		if (isSetBreaklines())
			breaklines.unsetParent();

		breaklines = null;
	}

	public void unsetGenericApplicationPropertyOfBreaklineRelief() {
		if (isSetGenericApplicationPropertyOfBreaklineRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfBreaklineRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBreaklineRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetRidgeOrValleyLines() {
		if (isSetRidgeOrValleyLines())
			ridgeOrValleyLines.unsetParent();

		ridgeOrValleyLines = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BREAKLINE_RELIEF;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = super.calcBoundedBy(false);
		if (boundedBy == null)
			boundedBy = new BoundingShapeImpl();

		if (isSetBreaklines()) {
			if (breaklines.isSetMultiCurve()) {
				calcBoundedBy(boundedBy, breaklines.getMultiCurve());
			} else {
				// xlink
			}
		}

		if (isSetRidgeOrValleyLines()) {
			if (ridgeOrValleyLines.isSetMultiCurve()) {
				calcBoundedBy(boundedBy, ridgeOrValleyLines.getMultiCurve());
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

		List<GeometryProperty<? extends AbstractGeometry>> propertyList = lodRepresentation.getLodGeometry(getLod());
		if (propertyList != null) {
			if (isSetRidgeOrValleyLines())
				propertyList.add(ridgeOrValleyLines);

			if (isSetBreaklines())
				propertyList.add(breaklines);
		}

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BreaklineReliefImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BreaklineRelief copy = (target == null) ? new BreaklineReliefImpl() : (BreaklineRelief)target;
		super.copyTo(copy, copyBuilder);

		if (isSetBreaklines()) {
			copy.setBreaklines((MultiCurveProperty)copyBuilder.copy(breaklines));
			if (copy.getBreaklines() == breaklines)
				breaklines.setParent(this);
		}

		if (isSetRidgeOrValleyLines()) {
			copy.setRidgeOrValleyLines((MultiCurveProperty)copyBuilder.copy(ridgeOrValleyLines));
			if (copy.getRidgeOrValleyLines() == ridgeOrValleyLines)
				ridgeOrValleyLines.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfBreaklineRelief(copyPart);

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
