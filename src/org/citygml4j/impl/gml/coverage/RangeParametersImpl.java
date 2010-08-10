package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.RangeParameters;
import org.citygml4j.model.gml.valueObjects.ValueObject;

public class RangeParametersImpl extends AssociationByRepOrRefImpl<ValueObject> implements RangeParameters {
	
	public ValueObject getValueObject() {
		return super.getObject();
	}

	public boolean isSetValueObject() {
		return super.isSetObject();
	}

	public void setValueObject(ValueObject valueObject) {
		super.setObject(valueObject);
	}

	public void unsetValueObject() {
		super.unsetObject();
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.RANGE_PARAMETERS;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RangeParameters copy = (target == null) ? new RangeParametersImpl() : (RangeParameters)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RangeParametersImpl(), copyBuilder);
	}

}
