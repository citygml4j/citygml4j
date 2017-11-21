package org.citygml4j.builder.json.marshal.citygml.transportation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.json.marshal.util.SurfaceCollector;
import org.citygml4j.builder.json.objects.feature.AbstractCityObjectType;
import org.citygml4j.builder.json.objects.feature.AbstractTransportationComplexType;
import org.citygml4j.builder.json.objects.feature.RailwayType;
import org.citygml4j.builder.json.objects.feature.RoadType;
import org.citygml4j.builder.json.objects.feature.TransportSquareType;
import org.citygml4j.builder.json.objects.feature.TransportationComplexAttributes;
import org.citygml4j.builder.json.objects.geometry.AbstractGeometryType;
import org.citygml4j.builder.json.objects.geometry.SemanticsType;
import org.citygml4j.builder.json.objects.geometry.SemanticsTypeName;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.mapper.TypeMapper;

public class TransportationMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final TypeMapper<List<AbstractCityObjectType>> typeMapper;

	public TransportationMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();

		typeMapper = TypeMapper.<List<AbstractCityObjectType>>create()
				.with(Road.class, this::marshalRoad)
				.with(Railway.class, this::marshalRailway)
				.with(Square.class, this::marshalSquare);
	}

	public List<AbstractCityObjectType> marshal(ModelObject src) {
		return typeMapper.apply(src);
	}

	public SemanticsType marshalSemantics(AbstractCityObject cityObject) {
		SemanticsType semantics = null;

		if (cityObject instanceof TrafficArea) {
			semantics = new SemanticsType(SemanticsTypeName.TRAFFIC_AREA);
			marshalTrafficArea((TrafficArea)cityObject, semantics);
		} else if (cityObject instanceof AuxiliaryTrafficArea) {
			semantics = new SemanticsType(SemanticsTypeName.AUXILIARY_TRAFFIC_AREA);
			marshalAuxiliaryTrafficArea((AuxiliaryTrafficArea)cityObject, semantics);
		}

		if (semantics != null && cityObject.isSetGenericAttribute())
			citygml.getGenericsMarshaller().marshalSemanticsAttributes(cityObject.getGenericAttribute(), semantics);

		return semantics;
	}
	
	public void marshalTransportationComplex(TransportationComplex src, AbstractTransportationComplexType dest) {
		TransportationComplexAttributes attributes = new TransportationComplexAttributes();
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
		
		if (src.isSetTrafficArea()) {
			for (TrafficAreaProperty property : src.getTrafficArea()) {
				if (property.isSetTrafficArea() && property.getTrafficArea().isSetSurfaceMaterial()) {
					Code surfaceMaterial = property.getTrafficArea().getSurfaceMaterial();
					if (surfaceMaterial.isSetValue())
						attributes.addSurfaceMaterial(surfaceMaterial.getValue());
				}
			}
		}
		
		if (src.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty property : src.getAuxiliaryTrafficArea()) {
				if (property.isSetAuxiliaryTrafficArea() && property.getAuxiliaryTrafficArea().isSetSurfaceMaterial()) {
					Code surfaceMaterial = property.getAuxiliaryTrafficArea().getSurfaceMaterial();
					if (surfaceMaterial.isSetValue())
						attributes.addSurfaceMaterial(surfaceMaterial.getValue());
				}
			}
		}
		
		if (attributes.hasAttributes())
			dest.setAttributes(attributes);
		
		if (src.isSetTrafficArea() || src.isSetAuxiliaryTrafficArea())
			preprocessGeometry(src);
		
		if (src.isSetLod1MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSurface());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSurface());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
	}
	
	public List<AbstractCityObjectType> marshalRoad(Road src) {
		RoadType dest = new RoadType();
		marshalTransportationComplex(src, dest);
		
		return Collections.singletonList(dest);
	}
	
	public List<AbstractCityObjectType> marshalRailway(Railway src) {
		RailwayType dest = new RailwayType();
		marshalTransportationComplex(src, dest);
		
		return Collections.singletonList(dest);
	}
	
	public List<AbstractCityObjectType> marshalSquare(Square src) {
		TransportSquareType dest = new TransportSquareType();
		marshalTransportationComplex(src, dest);
		
		return Collections.singletonList(dest);
	}

	private void marshalTrafficArea(TrafficArea src, SemanticsType dest) {
		if (src.isSetClazz())
			dest.addProperty("class", src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					dest.addProperty("function", function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					dest.addProperty("usage", usage.getValue());
					break;
				}
			}
		}

		if (src.isSetSurfaceMaterial())
			dest.addProperty("surfaceMaterial", src.getSurfaceMaterial().getValue());
	}

	private void marshalAuxiliaryTrafficArea(AuxiliaryTrafficArea src, SemanticsType dest) {
		if (src.isSetClazz())
			dest.addProperty("class", src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					dest.addProperty("function", function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					dest.addProperty("usage", usage.getValue());
					break;
				}
			}
		}

		if (src.isSetSurfaceMaterial())
			dest.addProperty("surfaceMaterial", src.getSurfaceMaterial().getValue());
	}


	private void preprocessGeometry(TransportationComplex transportationComplex) {
		SurfaceCollector collector = new SurfaceCollector();
		
		List<FeatureProperty<?>> properties = new ArrayList<>(transportationComplex.getTrafficArea());
		properties.addAll(transportationComplex.getAuxiliaryTrafficArea());
		if (properties.isEmpty())
			return;
	 
		for (FeatureProperty<?> property : properties) {
			if (property.getFeature() instanceof AbstractCityObject) {
				LodRepresentation lodRepresentation = ((AbstractCityObject)property.getFeature()).getLodRepresentation();
				for (int lod = 2; lod < 4; lod++) {
					if (lodRepresentation.isSetGeometry(lod)) {
						collector.setLod(lod);
						for (GeometryProperty<?> geometryProperty : lodRepresentation.getGeometry(lod))
							collector.visit(geometryProperty);
					}
				}
			}
		}

		if (collector.hasSurfaces()) {			
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (transportationComplex.isSetLod2MultiSurface() && transportationComplex.getLod2MultiSurface().isSetMultiSurface())
							multiSurface = transportationComplex.getLod2MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							transportationComplex.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (transportationComplex.isSetLod3MultiSurface() && transportationComplex.getLod3MultiSurface().isSetMultiSurface())
							multiSurface = transportationComplex.getLod3MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							transportationComplex.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
						}
					}

					for (AbstractSurface surface : surfaces) {					
						SurfaceProperty dummy = new SurfaceProperty();
						dummy.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK, surface);
						surface.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET, true);
						multiSurface.addSurfaceMember(dummy);
					}
				}
			}
		}
	}

}
