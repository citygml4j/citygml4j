package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.primitives.Envelope;

public interface BoundingShape extends GML, Child, Copyable {
	public Envelope getEnvelope();
	public Null getNull();
	public boolean isSetEnvelope();
	public boolean isSetNull();

	public void setEnvelope(BoundingBox boundingBox);	
	public void setEnvelope(Envelope envelope);
	public void updateEnvelope(BoundingBox boundingBox);
	public void setNull(Null _null);
	public void unsetEnvelope();
	public void unsetNull();
}
