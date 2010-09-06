package org.citygml4j.impl.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class TexCoordGenImpl extends AbstractTextureParameterizationImpl implements TexCoordGen {
	private WorldToTexture worldToTexture;
	private List<ADEComponent> ade;
	
	public TexCoordGenImpl() {
		
	}
	
	public TexCoordGenImpl(AppearanceModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfTexCoordGen(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTexCoordGen() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public WorldToTexture getWorldToTexture() {
		return worldToTexture;
	}

	public boolean isSetGenericApplicationPropertyOfTexCoordGen() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetWorldToTexture() {
		return worldToTexture != null;
	}

	public void setGenericApplicationPropertyOfTexCoordGen(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setWorldToTexture(WorldToTexture worldToTexture) {
		if (worldToTexture != null)
			worldToTexture.setParent(this);
		
		this.worldToTexture = worldToTexture;
	}

	public void unsetGenericApplicationPropertyOfTexCoordGen() {
		if (isSetGenericApplicationPropertyOfTexCoordGen())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTexCoordGen(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTexCoordGen() ? this.ade.remove(ade) : false;
	}

	public void unsetWorldToTexture() {
		if (isSetWorldToTexture())
			worldToTexture.unsetParent();
		
		worldToTexture = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEX_COORD_GEN;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TexCoordGenImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TexCoordGen copy = (target == null) ? new TexCoordGenImpl() : (TexCoordGen)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetWorldToTexture()) {
			copy.setWorldToTexture((WorldToTexture)copyBuilder.copy(worldToTexture));
			if (copy.getWorldToTexture() == worldToTexture)
				worldToTexture.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfTexCoordGen()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTexCoordGen(copyPart);

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
