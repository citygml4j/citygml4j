package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class PolygonImpl extends AbstractSurfaceImpl implements Polygon {
	private AbstractRingProperty exterior;
	private List<AbstractRingProperty> interior;

	public void addInterior(AbstractRingProperty abstractRingProperty) {
		if (interior == null)
			interior = new ChildList<AbstractRingProperty>(this);

		interior.add(abstractRingProperty);
	}

	public AbstractRingProperty getExterior() {
		return exterior;
	}

	public List<AbstractRingProperty> getInterior() {
		if (interior == null)
			interior = new ChildList<AbstractRingProperty>(this);

		return interior;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public boolean isSetInterior() {
		return interior != null && !interior.isEmpty();
	}

	public void setExterior(AbstractRingProperty abstractRingProperty) {
		if (abstractRingProperty != null)
			abstractRingProperty.setParent(this);

		exterior = abstractRingProperty;
	}

	public void setInterior(List<AbstractRingProperty> abstractRingProperty) {
		interior = new ChildList<AbstractRingProperty>(this, abstractRingProperty);
	}

	public void unsetExterior() {
		if (isSetExterior())
			exterior.unsetParent();

		exterior = null;
	}

	public void unsetInterior() {
		if (isSetInterior())
			interior.clear();

		interior = null;
	}

	public boolean unsetInterior(AbstractRingProperty abstractRingProperty) {
		return isSetInterior() ? interior.remove(abstractRingProperty) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior() && exterior.isSetRing())
			bbox.update(exterior.getRing().calcBoundingBox());
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.POLYGON;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PolygonImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Polygon copy = (target == null) ? new PolygonImpl() : (Polygon)target;
		super.copyTo(copy, copyBuilder);

		if (isSetExterior()) {
			copy.setExterior((AbstractRingProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}

		if (isSetInterior()) {
			for (AbstractRingProperty part : interior) {
				AbstractRingProperty copyPart = (AbstractRingProperty)copyBuilder.copy(part);
				copy.addInterior(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
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
