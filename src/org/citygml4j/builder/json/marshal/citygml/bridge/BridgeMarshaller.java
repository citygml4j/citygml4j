package org.citygml4j.builder.json.marshal.citygml.bridge;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.json.feature.AbstractBridgeType;
import org.citygml4j.binding.json.feature.AbstractCityObjectType;
import org.citygml4j.binding.json.feature.Attributes;
import org.citygml4j.binding.json.feature.BridgeAttributes;
import org.citygml4j.binding.json.feature.BridgeConstructionElementType;
import org.citygml4j.binding.json.feature.BridgeInstallationType;
import org.citygml4j.binding.json.feature.BridgePartType;
import org.citygml4j.binding.json.feature.BridgeType;
import org.citygml4j.binding.json.geometry.AbstractGeometryType;
import org.citygml4j.binding.json.geometry.GeometryTypeName;
import org.citygml4j.binding.json.geometry.SemanticsType;
import org.citygml4j.binding.json.geometry.SemanticsTypeName;
import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.json.marshal.util.SurfaceCollector;
import org.citygml4j.model.citygml.bridge.AbstractBoundarySurface;
import org.citygml4j.model.citygml.bridge.AbstractBridge;
import org.citygml4j.model.citygml.bridge.AbstractOpening;
import org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.bridge.Bridge;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElement;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElementProperty;
import org.citygml4j.model.citygml.bridge.BridgeInstallation;
import org.citygml4j.model.citygml.bridge.BridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.BridgePart;
import org.citygml4j.model.citygml.bridge.BridgePartProperty;
import org.citygml4j.model.citygml.bridge.ClosureSurface;
import org.citygml4j.model.citygml.bridge.Door;
import org.citygml4j.model.citygml.bridge.GroundSurface;
import org.citygml4j.model.citygml.bridge.OpeningProperty;
import org.citygml4j.model.citygml.bridge.OuterCeilingSurface;
import org.citygml4j.model.citygml.bridge.OuterFloorSurface;
import org.citygml4j.model.citygml.bridge.RoofSurface;
import org.citygml4j.model.citygml.bridge.WallSurface;
import org.citygml4j.model.citygml.bridge.Window;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.mapper.TypeMapper;

public class BridgeMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final TypeMapper<List<AbstractCityObjectType>> typeMapper;

	public BridgeMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();

		typeMapper = TypeMapper.<List<AbstractCityObjectType>>create()
				.with(Bridge.class, this::marshalBridge)
				.with(BridgePart.class, this::marshalBridgePart)
				.with(BridgeConstructionElement.class, this::marshalBridgeConstructionElement)
				.with(BridgeInstallation.class, this::marshalBridgeInstallation);
	}

	public List<AbstractCityObjectType> marshal(ModelObject src) {
		return typeMapper.apply(src);
	}

	public SemanticsType marshalSemantics(AbstractCityObject cityObject) {
		SemanticsType semantics = null;

		if (cityObject instanceof RoofSurface)
			semantics = new SemanticsType(SemanticsTypeName.ROOF_SURFACE);
		else if (cityObject instanceof GroundSurface)
			semantics = new SemanticsType(SemanticsTypeName.GROUND_SURFACE);
		else if (cityObject instanceof WallSurface)
			semantics = new SemanticsType(SemanticsTypeName.WALL_SURFACE);
		else if (cityObject instanceof ClosureSurface)
			semantics = new SemanticsType(SemanticsTypeName.CLOSURE_SURFACE);
		else if (cityObject instanceof OuterCeilingSurface)
			semantics = new SemanticsType(SemanticsTypeName.OUTER_CEILING_SURFACE);
		else if (cityObject instanceof OuterFloorSurface)
			semantics = new SemanticsType(SemanticsTypeName.OUTER_FLOOR_SURFACE);
		else if (cityObject instanceof Window)
			semantics = new SemanticsType(SemanticsTypeName.WINDOW);
		else if (cityObject instanceof Door)
			semantics = new SemanticsType(SemanticsTypeName.DOOR);

		if (semantics != null && cityObject.isSetGenericAttribute())
			citygml.getGenericsMarshaller().marshalSemanticsAttributes(cityObject.getGenericAttribute(), semantics);

		return semantics;
	}

	public List<AbstractCityObjectType> marshalAbstractBridge(AbstractBridge src, AbstractBridgeType dest) {
		BridgeAttributes attributes = new BridgeAttributes();
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

		if (src.isSetYearOfConstruction()) 
			attributes.setYearOfConstruction(src.getYearOfConstruction().get(Calendar.YEAR));

		if (src.isSetYearOfDemolition())
			attributes.setYearOfDemolition(src.getYearOfDemolition().get(Calendar.YEAR));
		
		if (src.isSetIsMovable())
			attributes.setIsMovable(src.getIsMovable());

		if (attributes.hasAttributes())
			dest.setAttributes(attributes);

		if (src.isSetBoundedBySurface())
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

		List<AbstractCityObjectType> cityObjects = new ArrayList<>();

		if (src.isSetOuterBridgeConstructionElement()) {
			for (BridgeConstructionElementProperty property : src.getOuterBridgeConstructionElement()) {
				if (property.isSetBridgeConstructionElement()) {
					for (AbstractCityObjectType type : marshalBridgeConstructionElement(property.getBridgeConstructionElement())) {
						dest.addConstructionElement(type.getGmlId());
						cityObjects.add(type);
					}
				}
			}
		}
		
		if (src.isSetOuterBridgeInstallation()) {
			for (BridgeInstallationProperty property : src.getOuterBridgeInstallation()) {
				if (property.isSetBridgeInstallation()) {
					for (AbstractCityObjectType type : marshalBridgeInstallation(property.getBridgeInstallation())) {
						dest.addInstallation(type.getGmlId());
						cityObjects.add(type);
					}
				}
			}
		}

		if (dest instanceof BridgeType && src.isSetConsistsOfBridgePart()) {
			for (BridgePartProperty property : src.getConsistsOfBridgePart()) {
				if (property.isSetBridgePart()) {
					for (AbstractCityObjectType cityObject : marshalBridgePart(property.getBridgePart())) {
						if (cityObject instanceof BridgePartType)
							((BridgeType)dest).addPart(cityObject.getGmlId());

						cityObjects.add(cityObject);
					}
				}
			}
		}
		
		if (src.isSetAddress()) {
			for (AddressProperty property : src.getAddress()) {
				if (property.isSetAddress()) {
					dest.setAddress(citygml.getCoreMarshaller().marshalAddress(property.getAddress()));
					break;
				}
			}
		}

		return cityObjects;
	}

	public List<AbstractCityObjectType> marshalBridge(Bridge src) {
		BridgeType dest = new BridgeType(src.getId());
		List<AbstractCityObjectType> cityObjects = marshalAbstractBridge(src, dest);
		cityObjects.add(dest);

		return cityObjects;
	}

	public List<AbstractCityObjectType> marshalBridgePart(BridgePart src) {
		BridgePartType dest = new BridgePartType(src.getId());
		List<AbstractCityObjectType> cityObjects = marshalAbstractBridge(src, dest);
		cityObjects.add(dest);

		return cityObjects;
	}
	
	public void marshalBridgeConstructionElement(BridgeConstructionElement src, BridgeConstructionElementType dest) {
		Attributes attributes = new Attributes();
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

		if (src.isSetBoundedBySurface())
			preprocessGeometry(src);

		Map<Integer, GeometryTypeName> geometryTypes = new HashMap<>();
		if (src.isSetLod2Geometry()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
				geometryTypes.put(2, geometry.getType());
			}
		}

		if (src.isSetLod3Geometry()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
				geometryTypes.put(3, geometry.getType());
			}
		}
		
		if (src.isSetLod2ImplicitRepresentation()) {
			AbstractGeometryType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(2) != geometry.getType()) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod3ImplicitRepresentation()) {
			AbstractGeometryType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(3) != geometry.getType()) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
	}

	public List<AbstractCityObjectType> marshalBridgeConstructionElement(BridgeConstructionElement src) {
		BridgeConstructionElementType dest = new BridgeConstructionElementType(src.getId());
		marshalBridgeConstructionElement(src, dest);

		return Collections.singletonList(dest);
	}

	public void marshalBridgeInstallation(BridgeInstallation src, BridgeInstallationType dest) {
		Attributes attributes = new Attributes();
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

		if (src.isSetBoundedBySurface())
			preprocessGeometry(src);

		Map<Integer, GeometryTypeName> geometryTypes = new HashMap<>();
		if (src.isSetLod2Geometry()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
				geometryTypes.put(2, geometry.getType());
			}
		}

		if (src.isSetLod3Geometry()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
				geometryTypes.put(3, geometry.getType());
			}
		}
		
		if (src.isSetLod2ImplicitRepresentation()) {
			AbstractGeometryType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(2) != geometry.getType()) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod3ImplicitRepresentation()) {
			AbstractGeometryType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(3) != geometry.getType()) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
	}

	public List<AbstractCityObjectType> marshalBridgeInstallation(BridgeInstallation src) {
		BridgeInstallationType dest = new BridgeInstallationType(src.getId());
		marshalBridgeInstallation(src, dest);

		return Collections.singletonList(dest);
	}

	private void preprocessGeometry(AbstractBridge bridge) {
		SurfaceCollector collector = collectBoundarySurfaces(bridge.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (bridge.isSetLod2MultiSurface() && bridge.getLod2MultiSurface().isSetMultiSurface())
							multiSurface = bridge.getLod2MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							bridge.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (bridge.isSetLod3MultiSurface() && bridge.getLod3MultiSurface().isSetMultiSurface())
							multiSurface = bridge.getLod3MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							bridge.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
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

	private void preprocessGeometry(BridgeInstallation installation) {
		SurfaceCollector collector = collectBoundarySurfaces(installation.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (installation.isSetLod2Geometry() && installation.getLod2Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)installation.getLod2Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							installation.setLod2Geometry(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (installation.isSetLod3Geometry() && installation.getLod3Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)installation.getLod3Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							installation.setLod3Geometry(new MultiSurfaceProperty(multiSurface));
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
	
	private void preprocessGeometry(BridgeConstructionElement element) {
		SurfaceCollector collector = collectBoundarySurfaces(element.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (element.isSetLod2Geometry() && element.getLod2Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)element.getLod2Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							element.setLod2Geometry(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (element.isSetLod3Geometry() && element.getLod3Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)element.getLod3Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							element.setLod3Geometry(new MultiSurfaceProperty(multiSurface));
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

	private SurfaceCollector collectBoundarySurfaces(List<BoundarySurfaceProperty> boundaryProperties) {
		SurfaceCollector collector = new SurfaceCollector();

		for (BoundarySurfaceProperty boundaryProperty : boundaryProperties) {
			if (boundaryProperty.isSetBoundarySurface()) {
				AbstractBoundarySurface boundarySurface = boundaryProperty.getBoundarySurface();
				LodRepresentation lodRepresentation = boundarySurface.getLodRepresentation();
				for (int lod = 2; lod < 4; lod++) {
					if (lodRepresentation.isSetGeometry(lod)) {
						collector.setLod(lod);
						for (GeometryProperty<?> geometryProperty : lodRepresentation.getGeometry(lod))
							collector.visit(geometryProperty);
					}
				}

				if (boundarySurface.isSetOpening()) {
					for (OpeningProperty openingProperty : boundarySurface.getOpening()) {
						if (openingProperty.isSetOpening()) {
							AbstractOpening opening = openingProperty.getOpening();
							lodRepresentation = opening.getLodRepresentation();
							for (int lod = 2; lod < 4; lod++) {
								if (lodRepresentation.isSetGeometry(lod)) {
									collector.setLod(lod);
									for (GeometryProperty<?> geometryProperty : lodRepresentation.getGeometry(lod))
										collector.visit(geometryProperty);
								}
							}
						}
					}
				}
			}
		}

		return collector;
	}
}
