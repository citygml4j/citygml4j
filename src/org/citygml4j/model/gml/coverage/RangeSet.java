package org.citygml4j.model.gml.coverage;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.valueObjects.ScalarValueList;
import org.citygml4j.model.gml.valueObjects.ValueArray;


public interface RangeSet extends GML, Child, Copyable {
	public List<ValueArray> getValueArray();
	public List<ScalarValueList> getScalarValueList();
	public DataBlock getDataBlock();
	public File getFile();
	public boolean isSetValueArray();
	public boolean isSetScalarValueList();
	public boolean isSetDataBlock();
	public boolean isSetFile();
	
	public void addValueArray(ValueArray valueArray);
	public void setValueArray(List<ValueArray> valueArray);
	public void addScalarValueList(ScalarValueList scalarValueList);
	public void setScalarValueList(List<ScalarValueList> scalarValueList);
	public void setDataBlock(DataBlock dataBlock);
	public void setFile(File file);
	public boolean unsetValueArray(ValueArray valueArray);
	public void unsetValueArray();
	public boolean unsetScalarValueList(ScalarValueList scalarValueList);
	public void unsetScalarValueList();
	public void unsetDataBlock();
	public void unsetFile();
}
