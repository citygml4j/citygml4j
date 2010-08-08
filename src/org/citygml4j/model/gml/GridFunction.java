package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface GridFunction extends GML, Child, Copyable {
	public SequenceRule getSequenceRule();
	public List<Integer> getStartPoint();
	public boolean isSetSequenceRule();
	public boolean isSetStartPoint();
	
	public void setSequenceRule(SequenceRule sequenceRule);
	public void addStartPoint(Integer startPoint);
	public void setStartPoint(List<Integer> startPoint);
	public void unsetSequenceRule();
	public void unsetStartPoint();
}
