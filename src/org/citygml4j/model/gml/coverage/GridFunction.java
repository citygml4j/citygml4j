package org.citygml4j.model.gml.coverage;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


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
