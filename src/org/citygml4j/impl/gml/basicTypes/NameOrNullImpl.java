package org.citygml4j.impl.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.NameOrNull;
import org.citygml4j.model.gml.basicTypes.Null;

public class NameOrNullImpl implements NameOrNull {
	private String name;
	private Null _null;
	private ModelObject parent;

	public NameOrNullImpl() {

	}

	public NameOrNullImpl(String name) {
		setName(name);
	}

	public NameOrNullImpl(Null _null) {
		setNull(_null);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.NAME_OR_NULL;
	}

	public String getName() {
		return name;
	}

	public Null getNull() {
		return _null;
	}

	public boolean isSetName() {
		return name != null;
	}

	public boolean isSetNull() {
		return _null != null;
	}

	public void setName(String name) {
		if (name != null && name.length() > 0) {			
			String[] split = name.trim().split("\\s");
			if (split.length > 0) {
				this.name = split[0];
				unsetNull();
			}
		}
	}

	public void setNull(Null _null) {
		if (_null != null)
			_null.setParent(this);

		this._null = _null;
		unsetName();
	}

	public void unsetName() {
		name = null;
	}

	public void unsetNull() {
		if (isSetNull())
			_null.unsetParent();

		_null = null;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new NameOrNullImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		NameOrNull copy = (target == null) ? new NameOrNullImpl() : (NameOrNull)target;

		if (isSetName())
			copy.setName(copyBuilder.copy(name));

		if (isSetNull()) {
			copy.setNull((Null)copyBuilder.copy(_null));
			if (copy.getNull() == _null)
				_null.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

}
