package org.citygml4j.builder.json.marshal.citygml.tunnel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.json.feature.AbstractCityObjectType;
import org.citygml4j.binding.json.feature.AbstractTunnelType;
import org.citygml4j.binding.json.feature.Attributes;
import org.citygml4j.binding.json.feature.TunnelAttributes;
import org.citygml4j.binding.json.feature.TunnelInstallationType;
import org.citygml4j.binding.json.feature.TunnelPartType;
import org.citygml4j.binding.json.feature.TunnelType;
import org.citygml4j.binding.json.geometry.AbstractGeometryType;
import org.citygml4j.binding.json.geometry.GeometryTypeName;
import org.citygml4j.binding.json.geometry.SemanticsType;
import org.citygml4j.binding.json.geometry.SemanticsTypeName;
import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.json.marshal.util.SurfaceCollector;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface;
import org.citygml4j.model.citygml.tunnel.AbstractOpening;
import org.citygml4j.model.citygml.tunnel.AbstractTunnel;
import org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.tunnel.ClosureSurface;
import org.citygml4j.model.citygml.tunnel.Door;
import org.citygml4j.model.citygml.tunnel.GroundSurface;
import org.citygml4j.model.citygml.tunnel.OpeningProperty;
import org.citygml4j.model.citygml.tunnel.OuterCeilingSurface;
import org.citygml4j.model.citygml.tunnel.OuterFloorSurface;
import org.citygml4j.model.citygml.tunnel.RoofSurface;
import org.citygml4j.model.citygml.tunnel.Tunnel;
import org.citygml4j.model.citygml.tunnel.TunnelInstallation;
import org.citygml4j.model.citygml.tunnel.TunnelInstallationProperty;
import org.citygml4j.model.citygml.tunnel.TunnelPart;
import org.citygml4j.model.citygml.tunnel.TunnelPartProperty;
import org.citygml4j.model.citygml.tunnel.WallSurface;
import org.citygml4j.model.citygml.tunnel.Window;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.mapper.TypeMapper;

public class TunnelMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final TypeMapper<List<AbstractCityObjectType>> typeMapper;

	public TunnelMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();

		typeMapper = TypeMapper.<List<AbstractCityObjectType>>create()
				.with(Tunnel.class, this::marshalTunnel)
				.with(TunnelPart.class, this::marshalTunnelPart)
				.with(TunnelInstallation.class, this::marshalTunnelInstallation);
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

	public List<AbstractCityObjectType> marshalAbstractTunnel(AbstractTunnel src, AbstractTunnelType dest) {
		TunnelAttributes attributes = new TunnelAttributes();
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

		if (src.isSetOuterTunnelInstallation()) {
			for (TunnelInstallationProperty property : src.getOuterTunnelInstallation()) {
				if (property.isSetTunnelInstallation()) {
					for (AbstractCityObjectType type : marshalTunnelInstallation(property.getTunnelInstallation())) {
						dest.addInstallation(type.getGmlId());
						cityObjects.add(type);
					}
				}
			}
		}

		if (dest instanceof TunnelType && src.isSetConsistsOfTunnelPart()) {
			for (TunnelPartProperty property : src.getConsistsOfTunnelPart()) {
				if (property.isSetTunnelPart()) {
					for (AbstractCityObjectType cityObject : marshalTunnelPart(property.getTunnelPart())) {
						if (cityObject instanceof TunnelPartType)
							((TunnelType)dest).addPart(cityObject.getGmlId());

						cityObjects.add(cityObject);
					}
				}
			}
		}
		
		return cityObjects;
	}

	public List<AbstractCityObjectType> marshalTunnel(Tunnel src) {
		TunnelType dest = new TunnelType(src.getId());
		List<AbstractCityObjectType> cityObjects = marshalAbstractTunnel(src, dest);
		cityObjects.add(dest);

		return cityObjects;
	}

	public List<AbstractCityObjectType> marshalTunnelPart(TunnelPart src) {
		TunnelPartType dest = new TunnelPartType(src.getId());
		List<AbstractCityObjectType> cityObjects = marshalAbstractTunnel(src, dest);
		cityObjects.add(dest);

		return cityObjects;
	}

	public void marshalTunnelInstallation(TunnelInstallation src, TunnelInstallationType dest) {
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

	public List<AbstractCityObjectType> marshalTunnelInstallation(TunnelInstallation src) {
		TunnelInstallationType dest = new TunnelInstallationType(src.getId());
		marshalTunnelInstallation(src, dest);

		return Collections.singletonList(dest);
	}

	private void preprocessGeometry(AbstractTunnel tunnel) {
		SurfaceCollector collector = collectBoundarySurfaces(tunnel.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (tunnel.isSetLod2MultiSurface() && tunnel.getLod2MultiSurface().isSetMultiSurface())
							multiSurface = tunnel.getLod2MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							tunnel.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (tunnel.isSetLod3MultiSurface() && tunnel.getLod3MultiSurface().isSetMultiSurface())
							multiSurface = tunnel.getLod3MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							tunnel.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
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

	private void preprocessGeometry(TunnelInstallation installation) {
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
