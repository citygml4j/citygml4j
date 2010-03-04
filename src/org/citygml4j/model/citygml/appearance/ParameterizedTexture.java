package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface ParameterizedTexture extends AbstractTexture {
    public List<TextureAssociation> getTarget();
	public List<ADEComponent> getGenericApplicationPropertyOfParameterizedTexture();
	public boolean isSetTarget();
	public boolean isSetGenericApplicationPropertyOfParameterizedTexture();
	
    public void setTarget(List<TextureAssociation> target);
    public void addTarget(TextureAssociation target);	
	public void addGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade);
	public void setGenericApplicationPropertyOfParameterizedTexture(List<ADEComponent> ade);
	public void unsetTarget();
	public boolean unsetTarget(TextureAssociation target);
	public void unsetGenericApplicationPropertyOfParameterizedTexture();
	public boolean unsetGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade);
}
