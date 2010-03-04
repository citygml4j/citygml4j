package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.gml.PointProperty;

public interface GeoreferencedTexture extends AbstractTexture {
	public Boolean getPreferWorldFile();
	public PointProperty getReferencePoint();
	public TransformationMatrix2x2 getOrientation();
	public List<String> getTarget();
	public List<ADEComponent> getGenericApplicationPropertyOfGeoreferencedTexture();
	public boolean isSetPreferWorldFile();
	public boolean isSetReferencePoint();
	public boolean isSetOrientation();
	public boolean isSetTarget();
	public boolean isSetGenericApplicationPropertyOfGeoreferencedTexture();
	
	public void setPreferWorldFile(Boolean preferWorldFile);
	public void setReferencePoint(PointProperty referencePoint);
	public void setOrientation(TransformationMatrix2x2 orientation);
	public void setTarget(List<String> target);
	public void addTarget(String target);	
	public void addGenericApplicationPropertyOfGeoreferencedTexture(ADEComponent ade);
	public void setGenericApplicationPropertyOfGeoreferencedTexture(List<ADEComponent> ade);
	public void unsetPreferWorldFile();
	public void unsetReferencePoint();
	public void unsetOrientation();
	public void unsetTarget();
	public boolean unsetTarget(String target);
	public void unsetGenericApplicationPropertyOfGeoreferencedTexture();
	public boolean unsetGenericApplicationPropertyOfGeoreferencedTexture(ADEComponent ade);
}
