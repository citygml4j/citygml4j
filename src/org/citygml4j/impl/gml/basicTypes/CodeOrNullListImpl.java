package org.citygml4j.impl.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.NameOrNull;

public class CodeOrNullListImpl implements CodeOrNullList {
	private List<NameOrNull> nameOrNull;
	private String codeSpace;
	private Object parent;

	public GMLClass getGMLClass() {
		return GMLClass.CODE_OR_NULL_LIST;
	}

	public List<NameOrNull> getNameOrNull() {
		if (nameOrNull == null)
			nameOrNull = new ChildList<NameOrNull>(this);

		return nameOrNull;
	}

	public String getCodeSpace() {
		return codeSpace;
	}

	public boolean isSetNameOrNull() {
		return nameOrNull != null && !nameOrNull.isEmpty();
	}

	public boolean isSetCodeSpace() {
		return codeSpace != null;
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void setNameOrNull(List<NameOrNull> nameOrNull) {
		this.nameOrNull = new ChildList<NameOrNull>(this, nameOrNull);
	}

	public void addNameOrNull(NameOrNull nameOrNull) {
		if (this.nameOrNull == null)
			this.nameOrNull = new ChildList<NameOrNull>(this);

		this.nameOrNull.add(nameOrNull);
	}

	public void unsetNameOrNull() {
		if (isSetNameOrNull())
			nameOrNull.clear();

		nameOrNull = null;
	}

	public boolean unsetNameOrNull(NameOrNull nameOrNull) {
		return isSetNameOrNull() ? this.nameOrNull.remove(nameOrNull) : false;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
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

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CodeOrNullList copy = (target == null) ? new CodeOrNullListImpl() : (CodeOrNullList)target;

		if (isSetNameOrNull()) {
			for (NameOrNull part : nameOrNull) {
				NameOrNull copyPart = (NameOrNull)copyBuilder.copy(part);
				copy.addNameOrNull(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));

		copy.unsetParent();

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CodeOrNullListImpl(), copyBuilder);
	}

}
