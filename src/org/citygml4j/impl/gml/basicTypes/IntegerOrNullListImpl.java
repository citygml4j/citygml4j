package org.citygml4j.impl.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.IntegerOrNull;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;

public class IntegerOrNullListImpl implements IntegerOrNullList {
	private List<IntegerOrNull> integerOrNull;
	private Object parent;

	public void addIntegerOrNull(IntegerOrNull integerOrNull) {
		if (this.integerOrNull == null)
			this.integerOrNull = new ChildList<IntegerOrNull>(this);
		
		this.integerOrNull.add(integerOrNull);
	}

	public List<IntegerOrNull> getIntegerOrNull() {
		if (integerOrNull == null)
			integerOrNull = new ChildList<IntegerOrNull>(this);
		
		return integerOrNull;
	}

	public boolean isSetIntegerOrNull() {
		return integerOrNull != null && !integerOrNull.isEmpty();
	}

	public void setIntegerOrNull(List<IntegerOrNull> integerOrNull) {
		this.integerOrNull = new ChildList<IntegerOrNull>(this, integerOrNull);
	}

	public void unsetIntegerOrNull() {
		if (isSetIntegerOrNull())
			integerOrNull.clear();
		
		integerOrNull = null;
	}

	public boolean unsetIntegerOrNull(IntegerOrNull integerOrNull) {
		return isSetIntegerOrNull() ? this.integerOrNull.remove(integerOrNull) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.INTEGER_OR_NULL_LIST;
	}

	public Object getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntegerOrNullListImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntegerOrNullList copy = (target == null) ? new IntegerOrNullListImpl() : (IntegerOrNullList)target;
		
		if (isSetIntegerOrNull()) {
			for (IntegerOrNull part : integerOrNull) {
				IntegerOrNull copyPart = (IntegerOrNull)copyBuilder.copy(part);
				copy.addIntegerOrNull(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
