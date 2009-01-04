package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationObject;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.MultiSolidProperty;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class VegetationConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected VegetationConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected PlantCover convertPlantCover(PlantCover src) {
		PlantCover dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof PlantCover)
				dest = (PlantCover)tmp;
		} else {
			dest = citygml.createPlantCover(builder.convertContext.vegModule);
			if (dest != null)
				convertPlantCover(src, dest);
		}

		return dest;
	}

	protected SolitaryVegetationObject convertSolitaryVegetationObject(SolitaryVegetationObject src) {
		SolitaryVegetationObject dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof SolitaryVegetationObject)
				dest = (SolitaryVegetationObject)tmp;
		} else {
			dest = citygml.createSolitaryVegetationObject(builder.convertContext.vegModule);
			if (dest != null)
				convertSolitaryVegetationObject(src, dest);
		}

		return dest;
	}

	protected void convertPlantCover(PlantCover src, PlantCover dest) {
		convertVegetationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetAverageHeight())
			dest.setAverageHeight(src.getAverageHeight());

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

		if (src.isSetLod1MultiSolid()) {
			MultiSolidProperty tmp = builder.gml.convertMultiSolidProperty(src.getLod1MultiSolid());
			if (tmp != null)
				dest.setLod1MultiSolid(tmp);
		}

		if (src.isSetLod2MultiSolid()) {
			MultiSolidProperty tmp = builder.gml.convertMultiSolidProperty(src.getLod2MultiSolid());
			if (tmp != null)
				dest.setLod2MultiSolid(tmp);
		}

		if (src.isSetLod3MultiSolid()) {
			MultiSolidProperty tmp = builder.gml.convertMultiSolidProperty(src.getLod3MultiSolid());
			if (tmp != null)
				dest.setLod3MultiSolid(tmp);
		}
		
		if (src.isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfPlantCover()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfPlantCover(tmp);
			}
		}
	}

	protected void convertSolitaryVegetationObject(SolitaryVegetationObject src, SolitaryVegetationObject dest) {
		convertVegetationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetSpecies())
			dest.setSpecies(src.getSpecies());

		if (src.isSetHeight())
			dest.setHeight(src.getHeight());

		if (src.isSetTrunkDiameter())
			dest.setTrunkDiameter(src.getTrunkDiameter());

		if (src.isSetCrownDiameter())
			dest.setCrownDiameter(src.getCrownDiameter());

		if (src.isSetLod1Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod1Geometry());
			if (tmp != null)
				dest.setLod1Geometry(tmp);
		}

		if (src.isSetLod2Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod2Geometry());
			if (tmp != null)
				dest.setLod2Geometry(tmp);
		}

		if (src.isSetLod3Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod3Geometry());
			if (tmp != null)
				dest.setLod3Geometry(tmp);
		}

		if (src.isSetLod4Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod4Geometry());
			if (tmp != null)
				dest.setLod4Geometry(tmp);
		}

		if (src.isSetLod1ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod1ImplicitRepresentation());
			if (tmp != null)
				dest.setLod1ImplicitRepresentation(tmp);
		}

		if (src.isSetLod2ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod2ImplicitRepresentation());
			if (tmp != null)
				dest.setLod2ImplicitRepresentation(tmp);
		}

		if (src.isSetLod3ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod3ImplicitRepresentation());
			if (tmp != null)
				dest.setLod3ImplicitRepresentation(tmp);
		}

		if (src.isSetLod4ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLod4ImplicitRepresentation());
			if (tmp != null)
				dest.setLod4ImplicitRepresentation(tmp);
		}
		
		if (src.isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfSolitaryVegetationObject()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfSolitaryVegetationObject(tmp);
			}
		}
	}

	protected void convertVegetationObject(VegetationObject src, VegetationObject dest) {
		builder.core.convertCityObject(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfVegetationObject()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfVegetationObject(tmp);
			}
		}
	}
}
