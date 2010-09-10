package org.citygml4j.impl.gml.coverage;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.IndexMap;

public class IndexMapImpl extends GridFunctionImpl implements IndexMap {
	private List<Integer> lookUpTable;
	
	public List<Integer> getLookUpTable() {
		if (lookUpTable == null)
			lookUpTable = new ArrayList<Integer>();
		
		return lookUpTable;
	}

	public boolean isSetLookUpTable() {
		return lookUpTable != null && !lookUpTable.isEmpty();
	}

	public void addLookUpIndex(Integer lookUpIndex) {
		if (lookUpTable == null)
			lookUpTable = new ArrayList<Integer>();
		
		lookUpTable.add(lookUpIndex);
	}

	public void setLookUpTable(List<Integer> lookUpTable) {
		this.lookUpTable = lookUpTable;
	}

	public void unsetLookUpTable() {
		lookUpTable = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.INDEX_MAP;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IndexMap copy = (target == null) ? new IndexMapImpl() : (IndexMap)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLookUpTable())
			copy.setLookUpTable((List<Integer>)copyBuilder.copy(lookUpTable));
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IndexMapImpl(), copyBuilder);
	}

}
