package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.CountExtent;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.IntegerOrNull;

public class CountExtentImpl extends IntegerOrNullListImpl implements CountExtent {

	@Override
	public void addIntegerOrNull(IntegerOrNull integerOrNull) {
		if (getIntegerOrNull().size() < 2)
			super.addIntegerOrNull(integerOrNull);
	}

	@Override
	public void setIntegerOrNull(List<IntegerOrNull> integerOrNull) {
		if (integerOrNull != null && integerOrNull.size() >= 2)
			super.setIntegerOrNull(integerOrNull.subList(0, 2));
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COUNTEXTENT;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CountExtentImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CountExtent copy = (target == null) ? new CountExtentImpl() : (CountExtent)target;
		return super.copyTo(copy, copyBuilder);
	}

}
