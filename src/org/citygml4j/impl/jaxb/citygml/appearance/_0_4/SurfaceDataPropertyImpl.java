package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml._0_4.AbstractSurfaceDataType;
import org.citygml4j.jaxb.citygml._0_4.AbstractTextureType;
import org.citygml4j.jaxb.citygml._0_4.GeoreferencedTextureType;
import org.citygml4j.jaxb.citygml._0_4.ParameterizedTextureType;
import org.citygml4j.jaxb.citygml._0_4.SurfaceDataPropertyType;
import org.citygml4j.jaxb.citygml._0_4.X3DMaterialType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.X3DMaterial;

public class SurfaceDataPropertyImpl extends CityGMLBaseImpl implements SurfaceDataProperty {
	private SurfaceDataPropertyType surfaceDataPropertyType;

	public SurfaceDataPropertyImpl() {
		surfaceDataPropertyType = new SurfaceDataPropertyType();
	}

	public SurfaceDataPropertyImpl(SurfaceDataPropertyType surfaceDataPropertyType) {
		this.surfaceDataPropertyType = surfaceDataPropertyType;
	}

	@Override
	public SurfaceDataPropertyType getJAXBObject() {
		return surfaceDataPropertyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SURFACEDATAPROPERTY;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	@Override
	public AbstractSurfaceData getSurfaceData() {
		if (surfaceDataPropertyType.isSet_SurfaceData()) {
			JAXBElement<? extends AbstractSurfaceDataType> abstractSurfaceData = surfaceDataPropertyType.get_SurfaceData();

			if (abstractSurfaceData.getValue() != null) {
				AbstractSurfaceDataType elem = abstractSurfaceData.getValue();
				QName name = abstractSurfaceData.getName();

				if (elem instanceof X3DMaterialType)
					return ModelMapper.APP_0_4.toCityGML((X3DMaterialType)elem, name);
				else if (elem instanceof GeoreferencedTextureType)
					return ModelMapper.APP_0_4.toCityGML((GeoreferencedTextureType)elem, name);
				else if (elem instanceof ParameterizedTextureType)
					return ModelMapper.APP_0_4.toCityGML((ParameterizedTextureType)elem, name);
				else if (elem instanceof AbstractTextureType)
					return ModelMapper.APP_0_4.toCityGML((AbstractTextureType)elem, name);
				else if (elem instanceof AbstractSurfaceDataType)
					return ModelMapper.APP_0_4.toCityGML((AbstractSurfaceDataType)elem, name);
			}
		}

		return null;
	}

	@Override
	public void setSurfaceData(AbstractSurfaceData surfaceData) {
		JAXBElement<? extends AbstractSurfaceDataType> jaxbElem = null;

		if (surfaceData instanceof X3DMaterial)
			jaxbElem = ModelMapper.APP_0_4.toJAXB((X3DMaterial)surfaceData);
		else if (surfaceData instanceof GeoreferencedTexture)
			jaxbElem = ModelMapper.APP_0_4.toJAXB((GeoreferencedTexture)surfaceData);
		else if (surfaceData instanceof ParameterizedTexture)
			jaxbElem = ModelMapper.APP_0_4.toJAXB((ParameterizedTexture)surfaceData);
		else if (surfaceData instanceof AbstractTexture)
			jaxbElem = ModelMapper.APP_0_4.toJAXB((AbstractTexture)surfaceData);
		else if (surfaceData instanceof AbstractSurfaceData)
			jaxbElem = ModelMapper.APP_0_4.toJAXB((AbstractSurfaceData)surfaceData);

		if (jaxbElem != null)
			surfaceDataPropertyType.set_SurfaceData(jaxbElem);
	}

	@Override
	public String getActuate() {
		return surfaceDataPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return surfaceDataPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return surfaceDataPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return surfaceDataPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return surfaceDataPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return surfaceDataPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return surfaceDataPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return surfaceDataPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		surfaceDataPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		surfaceDataPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		surfaceDataPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		surfaceDataPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		surfaceDataPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		surfaceDataPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		surfaceDataPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		surfaceDataPropertyType.setType(type);
	}

	@Override
	public boolean isSetSurfaceData() {
		return surfaceDataPropertyType.isSet_SurfaceData();
	}

	@Override
	public void unsetSurfaceData() {
		surfaceDataPropertyType.set_SurfaceData(null);
	}

	@Override
	public boolean isSetActuate() {
		return surfaceDataPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return surfaceDataPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return surfaceDataPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return surfaceDataPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return surfaceDataPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return surfaceDataPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return surfaceDataPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return surfaceDataPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		surfaceDataPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		surfaceDataPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		surfaceDataPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		surfaceDataPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		surfaceDataPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		surfaceDataPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		surfaceDataPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		surfaceDataPropertyType.setType(null);
	}

}
