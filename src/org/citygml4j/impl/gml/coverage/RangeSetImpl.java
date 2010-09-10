package org.citygml4j.impl.gml.coverage;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
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
	private Object parent;
	
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
	
	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
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
