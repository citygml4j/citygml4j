package org.citygml4j.model.gml;

public interface BoundingShape extends GMLBase {
	public Envelope getEnvelope();
	public String getNull();
	public boolean isSetEnvelope();
	public boolean isSetNull();

	public void setEnvelope(Envelope envelope);
	public void setNull(String _null);
	public boolean convertEnvelope();
	public void unsetEnvelope();
	public void unsetNull();
}
