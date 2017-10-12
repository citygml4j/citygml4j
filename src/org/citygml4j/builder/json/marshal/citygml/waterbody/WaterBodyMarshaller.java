package org.citygml4j.builder.json.marshal.citygml.waterbody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.json.objects.feature.AbstractCityObjectType;
import org.citygml4j.builder.json.objects.feature.DefaultAttributes;
import org.citygml4j.builder.json.objects.feature.WaterBodyType;
import org.citygml4j.builder.json.objects.geometry.AbstractGeometryType;
import org.citygml4j.builder.json.objects.geometry.SemanticsType;
import org.citygml4j.builder.json.objects.geometry.SemanticsTypeName;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.walker.GeometryWalker;

public class WaterBodyMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	
	public WaterBodyMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
	}
	
	public List<AbstractCityObjectType> marshal(ModelObject src) {
		if (src instanceof WaterBody)
			return Collections.singletonList(marshalWaterBody((WaterBody)src));
		
		return Collections.emptyList();			
	}

	public SemanticsType marshalSemantics(AbstractCityObject cityObject) {
		SemanticsType semantics = null;

		if (cityObject instanceof WaterSurface)
			semantics = new SemanticsType(SemanticsTypeName.WATER_SURFACE);
		else if (cityObject instanceof WaterGroundSurface)
			semantics = new SemanticsType(SemanticsTypeName.WATER_GROUND_SURFACE);
		else if (cityObject instanceof WaterClosureSurface)
			semantics = new SemanticsType(SemanticsTypeName.WATER_CLOSURE_SURFACE);

		if (semantics != null && cityObject.isSetGenericAttribute())
			citygml.getGenericsMarshaller().marshalSemanticsAttributes(cityObject.getGenericAttribute(), semantics);

		return semantics;
	}
	
	public void marshalWaterBody(WaterBody src, WaterBodyType dest) {
		DefaultAttributes attributes = new DefaultAttributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);
		
		if (src.isSetClazz())
			attributes.setClazz(src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					attributes.setFunction(function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					attributes.setUsage(usage.getValue());
					break;
				}
			}
		}
		
		if (attributes.hasAttributes())
			dest.setAttributes(attributes);
		
		Map<Integer, MultiSurface> multiSurfaces = null;
		if (src.isSetBoundedBySurface())
			multiSurfaces = preprocessGeometry(src);
		
		if (multiSurfaces != null) {
			for (Entry<Integer, MultiSurface> entry : multiSurfaces.entrySet()) {
				AbstractGeometryType geometry = json.getGMLMarshaller().marshal(entry.getValue());
				if (geometry != null) {
					geometry.setLod(entry.getKey());
					dest.addGeometry(geometry);
				}
			}
		}
		
		if (src.isSetLod0MultiCurve()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod0MultiCurve());
			if (geometry != null) {
				geometry.setLod(0);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1MultiCurve()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiCurve());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod0MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod0MultiSurface());
			if (geometry != null) {
				geometry.setLod(0);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1Solid()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Solid());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod2Solid()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Solid());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod3Solid()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Solid());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
	}
	
	public WaterBodyType marshalWaterBody(WaterBody src) {
		WaterBodyType dest = new WaterBodyType();
		marshalWaterBody(src, dest);
		
		return dest;
	}

	private Map<Integer, MultiSurface> preprocessGeometry(WaterBody waterBody) {
		Map<Integer, MultiSurface> multiSurfaces = null;
		BoundarySurfaceCollector collector = collectBoundarySurfaces(waterBody.getBoundedBySurface());		
		if (!collector.surfaces.isEmpty()) {
			multiSurfaces = new HashMap<>();
			
			for (int lod = 2; lod < 4; lod++) {
				List<AbstractSurface> surfaces = collector.surfaces.get(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = new MultiSurface();

					for (AbstractSurface surface : surfaces) {					
						SurfaceProperty dummy = new SurfaceProperty();
						dummy.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK, surface);
						surface.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET, true);
						multiSurface.addSurfaceMember(dummy);
					}
					
					multiSurfaces.put(lod, multiSurface);
				}
			}
		}
		
		return multiSurfaces;
	}
	
	private BoundarySurfaceCollector collectBoundarySurfaces(List<BoundedByWaterSurfaceProperty> boundaryProperties) {
		BoundarySurfaceCollector collector = new BoundarySurfaceCollector();

		for (BoundedByWaterSurfaceProperty property : boundaryProperties) {
			if (property.isSetWaterBoundarySurface()) {
				AbstractWaterBoundarySurface boundarySurface = property.getWaterBoundarySurface();				
				LodRepresentation lodRepresentation = boundarySurface.getLodRepresentation();
				for (int lod = 2; lod < 4; lod++) {
					if (lodRepresentation.isSetLodGeometry(lod)) {
						collector.lod = lod;
						for (GeometryProperty<?> geometryProperty : lodRepresentation.getLodGeometry(lod))
							collector.visit(geometryProperty);
					}
				}
			}
		}

		return collector;
	}

	private final class BoundarySurfaceCollector extends GeometryWalker {
		private int lod;
		private Map<Integer, List<AbstractSurface>> surfaces = new HashMap<>();

		@Override
		public void visit(CompositeSurface surface) {
			collect(surface);
		}

		@Override
		public void visit(OrientableSurface surface) {
			collect(surface);
		}

		@Override
		public void visit(Surface surface) {
			collect(surface);
		}

		@Override
		public void visit(Polygon surface) {
			collect(surface);
		}

		private void collect(AbstractSurface surface) {
			if (!surface.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET)) {
				List<AbstractSurface> tmp = surfaces.get(lod);
				if (tmp == null) {
					tmp = new ArrayList<>();
					surfaces.put(lod, tmp);
				}

				tmp.add(surface);
			}
		}
	}
	
}
