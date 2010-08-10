package org.citygml4j.impl.gml.grids;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.impl.gml.geometry.AbstractGeometryImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.grids.Grid;
import org.citygml4j.model.gml.grids.GridEnvelope;
import org.citygml4j.model.gml.grids.GridLimits;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class GridImpl extends AbstractGeometryImpl implements Grid {
	private GridLimits limits;
	private List<String> axisName;
	private int dimension;

	public GridLimits getLimits() {
		return limits;
	}

	public List<String> getAxisName() {
		if (axisName == null)
			axisName = new ArrayList<String>();

		return axisName;
	}

	public Integer getDimension() {
		return dimension;
	}

	public boolean isSetLimits() {
		return limits != null;
	}

	public boolean isSetAxisName() {
		return axisName != null && !axisName.isEmpty();
	}

	public boolean isSetDimension() {
		return true;
	}

	public void setLimits(GridLimits limits) {
		if (limits != null)
			limits.setParent(this);

		this.limits = limits;
	}

	public void addAxisName(String axisName) {
		if (this.axisName == null)
			this.axisName = new ArrayList<String>();

		this.axisName.add(axisName);
	}

	public void setAxisName(List<String> axisName) {
		this.axisName = axisName;
	}

	public void setDimension(Integer dimension) {
		if (dimension > 0)
			this.dimension = dimension;
	}

	public void unsetLimits() {
		if (isSetLimits())
			limits.unsetParent();

		limits = null;
	}

	public void unsetAxisName() {
		axisName = null;
	}

	public BoundingBox calcBoundingBox() {
		if (!isSetLimits())
			return null;

		GridEnvelope gridEnvelope = limits.getGridEnvelope();
		if (!(gridEnvelope.isSetHigh() && gridEnvelope.isSetLow() &&
				gridEnvelope.getHigh().size() >= dimension &&
				gridEnvelope.getLow().size() >= dimension))
			return null;

		BoundingBox bbox = new BoundingBox();

		Point low = new Point();
		low.setX(dimension >= 1 ? gridEnvelope.getLow().get(0) : 0.0);
		low.setY(dimension >= 2 ? gridEnvelope.getLow().get(1) : 0.0);
		low.setZ(dimension >= 3 ? gridEnvelope.getLow().get(2) : 0.0);
		bbox.update(low);
		
		Point high = new Point();
		high.setX(dimension >= 1 ? gridEnvelope.getHigh().get(0) : 0.0);
		high.setY(dimension >= 2 ? gridEnvelope.getHigh().get(1) : 0.0);
		high.setZ(dimension >= 3 ? gridEnvelope.getHigh().get(2) : 0.0);
		bbox.update(high);
		
		return bbox;	
	}	

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.GRID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Grid copy = (target == null) ? new GridImpl() : (Grid)target;
		super.copyTo(copy, copyBuilder);

		if (isSetLimits()) {
			copy.setLimits((GridLimits)copyBuilder.copy(limits));
			if (copy.getLimits() == limits)
				limits.setParent(this);
		}

		if (isSetAxisName())
			copy.setAxisName((List<String>)copyBuilder.copy(axisName));

		copy.setDimension(dimension);

		copy.unsetParent();

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridImpl(), copyBuilder);
	}

	public void visit(GeometryVisitor visitor) {
		visitor.accept(this);
	}

	public <T> T apply(GeometryFunction<T> visitor) {
		return visitor.accept(this);
	}

	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}

	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
