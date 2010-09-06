package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class RasterReliefImpl extends AbstractReliefComponentImpl implements RasterRelief {
	private GridProperty grid;
	private List<ADEComponent> ade;

	public RasterReliefImpl() {

	}

	public RasterReliefImpl(ReliefModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfRasterRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfRasterRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public GridProperty getGrid() {
		return grid;
	}

	public boolean isSetGenericApplicationPropertyOfRasterRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetGrid() {
		return grid != null;
	}

	public void setGenericApplicationPropertyOfRasterRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setGrid(GridProperty grid) {
		if (grid != null)
			grid.setParent(this);

		this.grid = grid;
	}

	public void unsetGenericApplicationPropertyOfRasterRelief() {
		if (isSetGenericApplicationPropertyOfRasterRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfRasterRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfRasterRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetGrid() {
		if (isSetGrid())
			grid.unsetParent();

		grid = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RASTER_RELIEF;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = super.calcBoundedBy(false);
		if (boundedBy == null)
			boundedBy = new BoundingShapeImpl();

		if (isSetGrid()) {
			if (grid.isSetObject()) {
				calcBoundedBy(boundedBy, grid.getObject(), setBoundedBy);
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

		if (isSetGrid() && grid.isSetObject() && grid.getObject().isSetRectifiedGridDomain()) {
			List<GeometryProperty<? extends AbstractGeometry>> propertyList = lodRepresentation.getLodRepresentation(getLod());
			if (propertyList != null) 
				propertyList.add(grid.getObject().getRectifiedGridDomain());
		}

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RasterReliefImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RasterRelief copy = (target == null) ? new RasterReliefImpl() : (RasterReliefImpl)target;
		super.copyTo(copy, copyBuilder);

		if (isSetGrid()) {
			copy.setGrid((GridProperty)copyBuilder.copy(grid));
			if (copy.getGrid() == grid)
				grid.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfRasterRelief(copyPart);

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
