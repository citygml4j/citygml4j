package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.CategoryExtent;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.NameOrNull;

public class CategoryExtentImpl extends CodeOrNullListImpl implements CategoryExtent {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CATEGORYEXTENT;
	}

	@Override
	public void setNameOrNull(List<NameOrNull> nameOrNull) {
		if (nameOrNull != null && nameOrNull.size() >= 2)
			super.setNameOrNull(nameOrNull.subList(0, 2));
	}

	@Override
	public void addNameOrNull(NameOrNull nameOrNull) {
		if (getNameOrNull().size() < 2)
			super.addNameOrNull(nameOrNull);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CategoryExtent copy = (target == null) ? new CategoryExtentImpl() : (CategoryExtent)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CategoryExtentImpl(), copyBuilder);
	}

}
