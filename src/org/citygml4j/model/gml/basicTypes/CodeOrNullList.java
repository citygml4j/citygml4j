/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.NameOrNull;

public class CodeOrNullList implements GML, Child, Copyable {
	private List<NameOrNull> nameOrNull;
	private String codeSpace;
	private ModelObject parent;

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
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

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CodeOrNullList copy = (target == null) ? new CodeOrNullList() : (CodeOrNullList)target;

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
		return copyTo(new CodeOrNullList(), copyBuilder);
	}

}
