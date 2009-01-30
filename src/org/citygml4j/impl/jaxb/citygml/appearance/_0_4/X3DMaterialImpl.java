package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.X3DMaterialType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.X3DMaterial;

public class X3DMaterialImpl extends AbstractSurfaceDataImpl implements X3DMaterial {
	private X3DMaterialType x3DMaterialType;

	public X3DMaterialImpl() {
		this(new X3DMaterialType());
	}

	public X3DMaterialImpl(X3DMaterialType x3DMaterialType) {
		super(x3DMaterialType);
		this.x3DMaterialType = x3DMaterialType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.X3DMATERIAL;
	}

	@Override
	public X3DMaterialType getJAXBObject() {
		return x3DMaterialType;
	}

	@Override
	public void addTarget(String target) {
		x3DMaterialType.getTarget().add(target);
	}

	@Override
	public Double getAmbientIntensity() {
		return x3DMaterialType.getAmbientIntensity();
	}

	@Override
	public Color getDiffuseColor() {
		if (x3DMaterialType.isSetDiffuseColor()) {
			Color diffuseColor = new ColorImpl(0.8);
			List<Double> diffuseColorList = x3DMaterialType.getDiffuseColor();

			if (diffuseColorList.size() >= 3) {
				diffuseColor.setRed(diffuseColorList.get(0));
				diffuseColor.setGreen(diffuseColorList.get(1));
				diffuseColor.setBlue(diffuseColorList.get(2));
			}

			return diffuseColor;
		}

		return null;
	}

	@Override
	public Color getEmissiveColor() {
		if (x3DMaterialType.isSetEmissiveColor()) {
			Color emissiveColor = new ColorImpl(0.0);
			List<Double> emissiveColorList = x3DMaterialType.getEmissiveColor();

			if (emissiveColorList.size() >= 3) {
				emissiveColor.setRed(emissiveColorList.get(0));
				emissiveColor.setGreen(emissiveColorList.get(1));
				emissiveColor.setBlue(emissiveColorList.get(2));
			}

			return emissiveColor;
		}

		return null;
	}

	@Override
	public Boolean getIsSmooth() {
		return x3DMaterialType.isIsSmooth();
	}

	@Override
	public Double getShininess() {
		return x3DMaterialType.getShininess();
	}

	@Override
	public Color getSpecularColor() {
		if (x3DMaterialType.isSetSpecularColor()) {
			Color specularColor = new ColorImpl(1.0);
			List<Double> specularColorList = x3DMaterialType.getSpecularColor();

			if (specularColorList.size() >= 3) {
				specularColor.setRed(specularColorList.get(0));
				specularColor.setGreen(specularColorList.get(1));
				specularColor.setBlue(specularColorList.get(2));
			}

			return specularColor;
		}

		return null;
	}

	@Override
	public List<String> getTarget() {
		return x3DMaterialType.getTarget();
	}

	@Override
	public Double getTransparency() {
		return x3DMaterialType.getTransparency();
	}

	@Override
	public void setAmbientIntensity(Double ambientIntensity) {
		if (ambientIntensity >= 0.0 && ambientIntensity <= 1.0)
			x3DMaterialType.setAmbientIntensity(ambientIntensity);
		else
			x3DMaterialType.setAmbientIntensity(0.2);
	}

	@Override
	public void setDiffuseColor(Color diffuseColor) {
		x3DMaterialType.unsetDiffuseColor();
		x3DMaterialType.getDiffuseColor().addAll(diffuseColor.toList());
	}

	@Override
	public void setEmissiveColor(Color emissiveColor) {
		x3DMaterialType.unsetEmissiveColor();
		x3DMaterialType.getEmissiveColor().addAll(emissiveColor.toList());
	}

	@Override
	public void setIsSmooth(Boolean isSmooth) {
		x3DMaterialType.setIsSmooth(isSmooth);
	}

	@Override
	public void setShininess(Double shininess) {
		if (shininess >= 0.0 && shininess <= 1.0)
			x3DMaterialType.setShininess(shininess);
		else
			x3DMaterialType.setShininess(0.2);
	}

	@Override
	public void setSpecularColor(Color specularColor) {
		x3DMaterialType.unsetSpecularColor();
		x3DMaterialType.getSpecularColor().addAll(specularColor.toList());
	}

	@Override
	public void setTarget(List<String> target) {
		x3DMaterialType.unsetTarget();
		x3DMaterialType.getTarget().addAll(target);
	}

	@Override
	public void setTransparency(Double transparency) {
		if (transparency >= 0.0 && transparency <= 1.0)
			x3DMaterialType.setTransparency(transparency);
		else
			x3DMaterialType.setTransparency(0.0);
	}

	@Override
	public void addGenericApplicationPropertyOfX3DMaterial(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			x3DMaterialType.get_GenericApplicationPropertyOfX3DMaterial().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfX3DMaterial() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : x3DMaterialType.get_GenericApplicationPropertyOfX3DMaterial()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfX3DMaterial(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			x3DMaterialType.unset_GenericApplicationPropertyOfX3DMaterial();
			x3DMaterialType.get_GenericApplicationPropertyOfX3DMaterial().addAll(elemList);
		}
	}

	@Override
	public boolean isSetAmbientIntensity() {
		return x3DMaterialType.isSetAmbientIntensity();
	}

	@Override
	public boolean isSetDiffuseColor() {
		return x3DMaterialType.isSetDiffuseColor();
	}

	@Override
	public boolean isSetEmissiveColor() {
		return x3DMaterialType.isSetEmissiveColor();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfX3DMaterial() {
		return x3DMaterialType.isSet_GenericApplicationPropertyOfX3DMaterial();
	}

	@Override
	public boolean isSetIsSmooth() {
		return x3DMaterialType.isSetIsSmooth();
	}

	@Override
	public boolean isSetShininess() {
		return x3DMaterialType.isSetShininess();
	}

	@Override
	public boolean isSetSpecularColor() {
		return x3DMaterialType.isSetSpecularColor();
	}

	@Override
	public boolean isSetTarget() {
		return x3DMaterialType.isSetTarget();
	}

	@Override
	public boolean isSetTransparency() {
		return x3DMaterialType.isSetTransparency();
	}

	@Override
	public void unsetAmbientIntensity() {
		x3DMaterialType.setAmbientIntensity(null);
	}

	@Override
	public void unsetDiffuseColor() {
		x3DMaterialType.unsetDiffuseColor();
	}

	@Override
	public void unsetEmissiveColor() {
		x3DMaterialType.unsetEmissiveColor();
	}

	@Override
	public void unsetGenericApplicationPropertyOfX3DMaterial() {
		x3DMaterialType.unset_GenericApplicationPropertyOfX3DMaterial();
	}

	@Override
	public void unsetIsSmooth() {
		x3DMaterialType.setIsSmooth(null);
	}

	@Override
	public void unsetShininess() {
		x3DMaterialType.setShininess(null);
	}

	@Override
	public void unsetSpecularColor() {
		x3DMaterialType.unsetSpecularColor();
	}

	@Override
	public void unsetTarget() {
		x3DMaterialType.unsetTarget();
	}

	@Override
	public void unsetTransparency() {
		x3DMaterialType.setTransparency(null);
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfX3DMaterial(ADEComponent adeObject) {
		if (x3DMaterialType.isSet_GenericApplicationPropertyOfX3DMaterial()) {
			Iterator<JAXBElement<?>> iter = x3DMaterialType.get_GenericApplicationPropertyOfX3DMaterial().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}
		
		return false;
	}

	@Override
	public boolean unsetTarget(String target) {
		if (x3DMaterialType.isSetTarget())
			return x3DMaterialType.getTarget().remove(target);
		
		return false;
	}

}
