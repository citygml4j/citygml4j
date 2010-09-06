package org.citygml4j.impl.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class TexCoordListImpl extends AbstractTextureParameterizationImpl implements TexCoordList {
	private List<TextureCoordinates> textureCoordinates;
	private List<ADEComponent> ade;
	
	public TexCoordListImpl() {
		
	}
	
	public TexCoordListImpl(AppearanceModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfTexCoordList(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addTextureCoordinates(TextureCoordinates textureCoordinates) {
		if (this.textureCoordinates == null)
			this.textureCoordinates = new ChildList<TextureCoordinates>(this);

		this.textureCoordinates.add(textureCoordinates);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTexCoordList() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<TextureCoordinates> getTextureCoordinates() {
		if (textureCoordinates == null)
			textureCoordinates = new ChildList<TextureCoordinates>(this);

		return textureCoordinates;
	}

	public boolean isSetGenericApplicationPropertyOfTexCoordList() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetTextureCoordinates() {
		return textureCoordinates != null && !textureCoordinates.isEmpty();
	}

	public void setGenericApplicationPropertyOfTexCoordList(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setTextureCoordinates(List<TextureCoordinates> textureCoordinates) {
		this.textureCoordinates = new ChildList<TextureCoordinates>(this, textureCoordinates);
	}

	public void unsetGenericApplicationPropertyOfTexCoordList() {
		if (isSetGenericApplicationPropertyOfTexCoordList())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTexCoordList(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTexCoordList() ? this.ade.remove(ade) : false;
	}

	public void unsetTextureCoordinates() {
		if (isSetTextureCoordinates())
			textureCoordinates.clear();

		textureCoordinates = null;
	}

	public boolean unsetTextureCoordinates(TextureCoordinates textureCoordinates) {
		return isSetTextureCoordinates() ? this.textureCoordinates.remove(textureCoordinates) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEX_COORD_LIST;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TexCoordListImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TexCoordList copy = (target == null) ? new TexCoordListImpl() : (TexCoordList)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetTextureCoordinates()) {
			for (TextureCoordinates part : textureCoordinates) {
				TextureCoordinates copyPart = (TextureCoordinates)copyBuilder.copy(part);
				copy.addTextureCoordinates(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfTexCoordList()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTexCoordList(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
