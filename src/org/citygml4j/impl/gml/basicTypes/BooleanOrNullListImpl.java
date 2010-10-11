package org.citygml4j.impl.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.BooleanOrNull;
import org.citygml4j.model.gml.basicTypes.BooleanOrNullList;

public class BooleanOrNullListImpl implements BooleanOrNullList {
	private List<BooleanOrNull> booleanOrNull;
	private ModelObject parent;

	public void addBooleanOrNull(BooleanOrNull booleanOrNull) {
		if (this.booleanOrNull == null)
			this.booleanOrNull = new ChildList<BooleanOrNull>(this);
		
		this.booleanOrNull.add(booleanOrNull);
	}

	public List<BooleanOrNull> getBooleanOrNull() {
		if (booleanOrNull == null)
			booleanOrNull = new ChildList<BooleanOrNull>(this);
		
		return booleanOrNull;
	}

	public boolean isSetBooleanOrNull() {
		return booleanOrNull != null && !booleanOrNull.isEmpty();
	}

	public void setBooleanOrNull(List<BooleanOrNull> booleanOrNull) {
		this.booleanOrNull = new ChildList<BooleanOrNull>(this, booleanOrNull);
	}

	public void unsetBooleanOrNull() {
		if (isSetBooleanOrNull())
			booleanOrNull.clear();
		
		booleanOrNull = null;
	}

	public boolean unsetBooleanOrNull(BooleanOrNull booleanOrNull) {
		return isSetBooleanOrNull() ? this.booleanOrNull.remove(booleanOrNull) : false;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.BOOLEAN_OR_NULL_LIST;
	}

	public ModelObject getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BooleanOrNullListImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BooleanOrNullList copy = (target == null) ? new BooleanOrNullListImpl() : (BooleanOrNullList)target;
		
		if (isSetBooleanOrNull()) {
			for (BooleanOrNull part : booleanOrNull) {
				BooleanOrNull copyPart = (BooleanOrNull)copyBuilder.copy(part);
				copy.addBooleanOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
