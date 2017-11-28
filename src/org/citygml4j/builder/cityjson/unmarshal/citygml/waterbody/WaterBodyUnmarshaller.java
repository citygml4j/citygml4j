package org.citygml4j.builder.cityjson.unmarshal.citygml.waterbody;

import java.util.List;
import java.util.Map;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.WaterBodyType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.AbstractSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;

public class WaterBodyUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;

	public WaterBodyUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}
	
	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		if (src instanceof WaterBodyType)
			return unmarshalWaterBody((WaterBodyType)src);

		return null;
	}
	
	public void unmarshalSemantics(AbstractSemanticsObject src, Map<Integer, List<AbstractSurface>> surfaces, Number lod, AbstractCityObject parent) {
		if (!(parent instanceof WaterBody))
			return;
		
		for (int i = 0; i < src.getNumSurfaces(); i++) {
			SemanticsType semanticsType = src.getSurfaces().get(i);
			if (semanticsType == null)
				continue;

			List<AbstractSurface> tmp = surfaces.get(i);
			if (tmp == null || tmp.isEmpty())
				continue;

			AbstractWaterBoundarySurface boundarySurface = null;
			switch (semanticsType.getType()) {
			case WATER_SURFACE:
				boundarySurface = unmarshalWaterSurface(semanticsType, tmp, lod);
				break;
			case WATER_GROUND_SURFACE:
				boundarySurface = unmarshalWaterGroundSurface(semanticsType, tmp, lod);
				break;
			case WATER_CLOSURE_SURFACE:
				boundarySurface = unmarshalWaterClosureSurface(semanticsType, tmp, lod);
				break;
			default:
				continue;
			}
			
			if (boundarySurface != null)
				((WaterBody)parent).addBoundedBySurface(new BoundedByWaterSurfaceProperty(boundarySurface));
		}
	}
	
	public void unmarshalWaterBody(WaterBodyType src, WaterBody dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
		}
		
		for (AbstractGeometryType geometryType : src.getGeometry()) {
			AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryType, dest);

			if (geometry != null) {
				int lod = geometryType.getLod().intValue();

				if (geometry instanceof MultiCurve) {
					MultiCurve multiCurve = (MultiCurve)geometry;
					switch (lod) {
					case 0:
						dest.setLod0MultiCurve(new MultiCurveProperty(multiCurve));
						break;
					case 1:
						dest.setLod0MultiCurve(new MultiCurveProperty(multiCurve));
						break;
					}
				}
				
				else if (geometry instanceof MultiSurface || geometry instanceof CompositeSurface) {
					MultiSurface multiSurface = null;
					
					if (geometry instanceof MultiSurface) 
						multiSurface = (MultiSurface)geometry;
					else {
						multiSurface = new MultiSurface();
						multiSurface.setSurfaceMember(((CompositeSurface)geometry).getSurfaceMember());
					}
					
					switch (lod) {
					case 0:
						dest.setLod0MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					case 1:
						dest.setLod1MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					}
				}

				else if (geometry instanceof AbstractSolid) {
					AbstractSolid solid = (AbstractSolid)geometry;
					switch (lod) {
					case 1:
						dest.setLod1Solid(new SolidProperty(solid));
						break;
					case 2:
						dest.setLod2Solid(new SolidProperty(solid));
						break;
					case 3:
						dest.setLod3Solid(new SolidProperty(solid));
						break;
					}
				}
			}	
		}
	}
	
	public WaterBody unmarshalWaterBody(WaterBodyType src) {
		WaterBody dest = new WaterBody();
		unmarshalWaterBody(src, dest);
		
		return dest;
	}
	
	public void unmarshalAbstractWaterBoundarySurface(SemanticsType src, AbstractWaterBoundarySurface dest, List<AbstractSurface> surfaces, Number lod) {
		dest.setId(DefaultGMLIdManager.getInstance().generateUUID());
		
		if (src.isSetProperties())
			citygml.getGenericsUnmarshaller().unmarshalSemanticsAttributes(src.getProperties(), dest);
		
		CompositeSurface compositeSurface = new CompositeSurface();
		for (AbstractSurface surface : surfaces)
			compositeSurface.addSurfaceMember(new SurfaceProperty(surface));

		switch (lod.intValue()) {
		case 2:
			dest.setLod2Surface(new SurfaceProperty(compositeSurface));
			break;
		case 3:
			dest.setLod3Surface(new SurfaceProperty(compositeSurface));
			break;
		}
	}
	
	public WaterSurface unmarshalWaterSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WaterSurface dest = new WaterSurface();
		
		if (src.isSetProperties()) {
			Object attribute = src.getProperties().get("waterLevel");
			if (attribute instanceof String) {
				dest.setWaterLevel(new Code((String)attribute));
				src.getProperties().remove("waterLevel");
			}
		}
		
		unmarshalAbstractWaterBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}
	
	public WaterGroundSurface unmarshalWaterGroundSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WaterGroundSurface dest = new WaterGroundSurface();
		unmarshalAbstractWaterBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}
	
	public WaterClosureSurface unmarshalWaterClosureSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WaterClosureSurface dest = new WaterClosureSurface();
		unmarshalAbstractWaterBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}
	
}
