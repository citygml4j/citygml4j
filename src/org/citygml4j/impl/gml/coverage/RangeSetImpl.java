/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.impl.gml.coverage;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.DataBlock;
import org.citygml4j.model.gml.coverage.File;
import org.citygml4j.model.gml.coverage.RangeSet;
import org.citygml4j.model.gml.valueObjects.ScalarValueList;
import org.citygml4j.model.gml.valueObjects.ValueArray;

public class RangeSetImpl implements RangeSet {
	private List<ValueArray> valueArray;
	private List<ScalarValueList> scalarValueList;
	private DataBlock dataBlock;
	private File file;
	private ModelObject parent;
	
	public RangeSetImpl() {
		
	}
	
	public RangeSetImpl(ValueArray valueArray) {
		addValueArray(valueArray);
	}
	
	public RangeSetImpl(ScalarValueList scalarValueList) {
		addScalarValueList(scalarValueList);
	}
	
	public RangeSetImpl(DataBlock dataBlock) {
		setDataBlock(dataBlock);
	}
	
	public RangeSetImpl(File file) {
		setFile(file);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.RANGE_SET;
	}

	public void addValueArray(ValueArray valueArray) {
		if (this.valueArray == null)
			this.valueArray = new ChildList<ValueArray>(this);
		
		this.valueArray.add(valueArray);
		
		unsetDataBlock();
		unsetFile();
		unsetScalarValueList();
	}

	public List<ValueArray> getValueArray() {
		if (valueArray == null)
			valueArray = new ChildList<ValueArray>(this);
		
		return valueArray;
	}

	public void addScalarValueList(ScalarValueList scalarValueList) {
		if (this.scalarValueList == null)
			this.scalarValueList = new ChildList<ScalarValueList>(this);
		
		this.scalarValueList.add(scalarValueList);
		
		unsetDataBlock();
		unsetFile();
		unsetValueArray();
	}

	public List<ScalarValueList> getScalarValueList() {
		if (scalarValueList == null)
			scalarValueList = new ChildList<ScalarValueList>(this);
		
		return scalarValueList;
	}

	public DataBlock getDataBlock() {
		return dataBlock;
	}

	public File getFile() {
		return file;
	}

	public boolean isSetValueArray() {
		return valueArray != null && !valueArray.isEmpty();
	}

	public boolean isSetScalarValueList() {
		return scalarValueList != null && !scalarValueList.isEmpty();
	}

	public boolean isSetDataBlock() {
		return dataBlock != null;
	}

	public boolean isSetFile() {
		return file != null;
	}

	public void setValueArray(List<ValueArray> valueArray) {
		this.valueArray = new ChildList<ValueArray>(this, valueArray);
		
		unsetDataBlock();
		unsetFile();
		unsetScalarValueList();
	}

	public void setScalarValueList(List<ScalarValueList> scalarValueList) {
		this.scalarValueList = new ChildList<ScalarValueList>(this, scalarValueList);
		
		unsetDataBlock();
		unsetFile();
		unsetValueArray();
	}

	public void setDataBlock(DataBlock dataBlock) {
		if (dataBlock != null)
			dataBlock.setParent(this);
		
		this.dataBlock = dataBlock;
		
		unsetFile();
		unsetScalarValueList();
		unsetValueArray();
	}

	public void setFile(File file) {
		if (file != null)
			file.setParent(this);
		
		this.file = file;
		
		unsetDataBlock();
		unsetScalarValueList();
		unsetValueArray();
	}

	public boolean unsetValueArray(ValueArray valueArray) {
		return isSetValueArray() ? this.valueArray.remove(valueArray) : false;
	}

	public void unsetValueArray() {
		if (isSetValueArray())
			valueArray.clear();
		
		valueArray = null;
	}

	public boolean unsetScalarValueList(ScalarValueList scalarValueList) {
		return isSetScalarValueList() ? this.scalarValueList.remove(scalarValueList) : false;
	}

	public void unsetScalarValueList() {
		if (isSetScalarValueList())
			scalarValueList.clear();
		
		scalarValueList = null;
	}

	public void unsetDataBlock() {
		if (isSetDataBlock())
			dataBlock.unsetParent();
		
		dataBlock = null;
	}

	public void unsetFile() {
		if (isSetFile())
			file.unsetParent();
		
		file = null;
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
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RangeSet copy = (target == null) ? new RangeSetImpl() : (RangeSet)target;
		
		if (isSetDataBlock()) {
			copy.setDataBlock((DataBlock)copyBuilder.copy(dataBlock));
			if (copy.getDataBlock() == dataBlock)
				dataBlock.setParent(this);
		}
		
		if (isSetScalarValueList()) {
			for (ScalarValueList part : scalarValueList) {
				ScalarValueList copyPart = (ScalarValueList)copyBuilder.copy(part);
				copy.addScalarValueList(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetFile()) {
			copy.setFile((File)copyBuilder.copy(file));
			if (copy.getFile() == file)
				file.setParent(this);
		}
		
		if (isSetValueArray()) {
			for (ValueArray part : valueArray) {
				ValueArray copyPart = (ValueArray)copyBuilder.copy(part);
				copy.addValueArray(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RangeSetImpl(), copyBuilder);
	}

}
