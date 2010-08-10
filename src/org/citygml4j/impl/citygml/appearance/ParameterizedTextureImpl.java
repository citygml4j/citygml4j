package org.citygml4j.impl.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class ParameterizedTextureImpl extends AbstractTextureImpl implements ParameterizedTexture {
	private List<TextureAssociation> target;
	private List<ADEComponent> ade;
	
	public ParameterizedTextureImpl() {
		
	}
	
	public ParameterizedTextureImpl(AppearanceModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addTarget(TextureAssociation target) {
		if (this.target == null)
			this.target = new ChildList<TextureAssociation>(this);

		this.target.add(target);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfParameterizedTexture() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<TextureAssociation> getTarget() {
		if (target == null)
			target = new ChildList<TextureAssociation>(this);

		return target;
	}

	public boolean isSetGenericApplicationPropertyOfParameterizedTexture() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetTarget() {
		return target != null && !target.isEmpty();
	}

	public void setGenericApplicationPropertyOfParameterizedTexture(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setTarget(List<TextureAssociation> target) {
		this.target = new ChildList<TextureAssociation>(this, target);
	}

	public void unsetGenericApplicationPropertyOfParameterizedTexture() {
		if (isSetGenericApplicationPropertyOfParameterizedTexture())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfParameterizedTexture() ? this.ade.remove(ade) : false;
	}

	public void unsetTarget() {
		if (isSetTarget())
			target.clear();

		target = null;
	}

	public boolean unsetTarget(TextureAssociation target) {
		return isSetTarget() ? this.target.remove(target) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.PARAMETERIZED_TEXTURE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ParameterizedTextureImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ParameterizedTexture copy = (target == null) ? new ParameterizedTextureImpl() : (ParameterizedTexture)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetTarget()) {
			for (TextureAssociation part : this.target) {
				TextureAssociation copyPart = (TextureAssociation)copyBuilder.copy(part);
				copy.addTarget(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfParameterizedTexture(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void visit(FeatureVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(FeatureFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
