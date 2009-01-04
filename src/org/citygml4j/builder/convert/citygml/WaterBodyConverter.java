package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterObject;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class WaterBodyConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected WaterBodyConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected BoundedByWaterSurfaceProperty convertBoundedByWaterSurfaceProperty(BoundedByWaterSurfaceProperty src) {
		BoundedByWaterSurfaceProperty dest = citygml.createBoundedByWaterSurfaceProperty(builder.convertContext.wtrModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				CityObject tmp = builder.core.convertCityObject(src.getObject());
				if (tmp != null && tmp instanceof WaterBoundarySurface)
					dest.setObject((WaterBoundarySurface)tmp);
			}
		}

		return dest;
	}

	protected WaterBody convertWaterBody(WaterBody src) {
		WaterBody dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof WaterBody)
				dest = (WaterBody)tmp;
		} else {
			dest = citygml.createWaterBody(builder.convertContext.wtrModule);
			if (dest != null)
				convertWaterBody(src, dest);
		}

		return dest;
	}

	protected WaterClosureSurface convertWaterClosureSurface(WaterClosureSurface src) {
		WaterClosureSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof WaterClosureSurface)
				dest = (WaterClosureSurface)tmp;
		} else {
			dest = citygml.createWaterClosureSurface(builder.convertContext.wtrModule);
			if (dest != null)
				convertWaterClosureSurface(src, dest);
		}

		return dest;
	}

	protected WaterGroundSurface convertWaterGroundSurface(WaterGroundSurface src) {
		WaterGroundSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof WaterGroundSurface)
				dest = (WaterGroundSurface)tmp;
		} else {
			dest = citygml.createWaterGroundSurface(builder.convertContext.wtrModule);
			if (dest != null)
				convertWaterGroundSurface(src, dest);
		}

		return dest;
	}

	protected WaterSurface convertWaterSurface(WaterSurface src) {
		WaterSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof WaterSurface)
				dest = (WaterSurface)tmp;
		} else {
			dest = citygml.createWaterSurface(builder.convertContext.wtrModule);
			if (dest != null)
				convertWaterSurface(src, dest);
		}

		return dest;
	}

	protected void convertWaterBody(WaterBody src, WaterBody dest) {
		convertWaterObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod0MultiCurve())
			dest.setLod0MultiCurve(src.getLod0MultiCurve());

		if (src.isSetLod1MultiCurve())
			dest.setLod1MultiCurve(src.getLod1MultiCurve());

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

		if (src.isSetLod1Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod1Solid());
			if (tmp != null)
				dest.setLod1Solid(tmp);
		}

		if (src.isSetLod2Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod2Solid());
			if (tmp != null)
				dest.setLod2Solid(tmp);
		}

		if (src.isSetLod3Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod3Solid());
			if (tmp != null)
				dest.setLod3Solid(tmp);
		}

		if (src.isSetLod4Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod4Solid());
			if (tmp != null)
				dest.setLod4Solid(tmp);
		}

		if (src.isSetBoundedBySurfaces()) {
			for (BoundedByWaterSurfaceProperty boundary : src.getBoundedBySurfaces()) {
				BoundedByWaterSurfaceProperty tmp = convertBoundedByWaterSurfaceProperty(boundary);
				if (tmp != null)
					dest.addBoundedBySurface(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWaterBody()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWaterBody(tmp);
			}
		}
	}

	protected void convertWaterBoundarySurface(WaterBoundarySurface src, WaterBoundarySurface dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetLod2Surface()) {
			SurfaceProperty tmp = builder.gml.convertSurfaceProperty(src.getLod2Surface());
			if (tmp != null)
				dest.setLod2Surface(tmp);
		}

		if (src.isSetLod3Surface()) {
			SurfaceProperty tmp = builder.gml.convertSurfaceProperty(src.getLod3Surface());
			if (tmp != null)
				dest.setLod3Surface(tmp);
		}

		if (src.isSetLod4Surface()) {
			SurfaceProperty tmp = builder.gml.convertSurfaceProperty(src.getLod4Surface());
			if (tmp != null)
				dest.setLod4Surface(tmp);
		}
		
		if (src.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWaterBoundarySurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWaterBoundarySurface(tmp);
			}
		}
	}

	protected void convertWaterClosureSurface(WaterClosureSurface src, WaterClosureSurface dest) {
		convertWaterBoundarySurface(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfWaterClosureSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWaterClosureSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWaterClosureSurface(tmp);
			}
		}
	}

	protected void convertWaterGroundSurface(WaterGroundSurface src, WaterGroundSurface dest) {
		convertWaterBoundarySurface(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWaterGroundSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWaterGroundSurface(tmp);
			}
		}
	}

	protected void convertWaterSurface(WaterSurface src, WaterSurface dest) {
		convertWaterBoundarySurface(src, dest);

		if (src.isSetWaterLevel())
			dest.setWaterLevel(src.getWaterLevel());
		
		if (src.isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWaterSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWaterSurface(tmp);
			}
		}
	}

	protected void convertWaterObject(WaterObject src, WaterObject dest) {
		builder.core.convertCityObject(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWaterObject()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWaterObject(tmp);
			}
		}
	}
}
