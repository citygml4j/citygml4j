package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

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

	@Override
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
