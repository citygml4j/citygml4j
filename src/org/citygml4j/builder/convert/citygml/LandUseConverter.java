package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class LandUseConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected LandUseConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected LandUse convertLandUse(LandUse src) {
		LandUse dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof LandUse)
				dest = (LandUse)tmp;
		} else {
			dest = citygml.createLandUse(builder.convertContext.luseModule);
			if (dest != null)
				convertLandUse(src, dest);
		}

		return dest;
	}

	protected void convertLandUse(LandUse src, LandUse dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod0MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod0MultiSurface());
			if (tmp != null)
				dest.setLod0MultiSurface(tmp);
		}

		if (src.isSetLod1MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod1MultiSurface());
			if (tmp != null)
				dest.setLod1MultiSurface(tmp);
		}

		if (src.isSetLod2MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod2MultiSurface());
			if (tmp != null)
				dest.setLod2MultiSurface(tmp);
		}

		if (src.isSetLod3MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod3MultiSurface());
			if (tmp != null)
				dest.setLod3MultiSurface(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}
		
		if (src.isSetGenericApplicationPropertyOfLandUse()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfLandUse()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfLandUse(tmp);
			}
		}
	}
}
