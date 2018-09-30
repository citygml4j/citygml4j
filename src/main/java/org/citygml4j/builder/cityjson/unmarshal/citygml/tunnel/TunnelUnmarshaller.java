/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.cityjson.unmarshal.citygml.tunnel;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.AbstractTunnelType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.TunnelAttributes;
import org.citygml4j.binding.cityjson.feature.TunnelInstallationType;
import org.citygml4j.binding.cityjson.feature.TunnelPartType;
import org.citygml4j.binding.cityjson.feature.TunnelType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.AbstractSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
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
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TunnelUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private final BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public TunnelUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();

		typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
				.with(TunnelType.class, this::unmarshalTunnel)
				.with(TunnelPartType.class, this::unmarshalTunnelPart)
				.with(TunnelInstallationType.class, this::unmarshalTunnelInstallation);
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		return typeMapper.apply(src, cityJSON);
	}

	public void unmarshalSemantics(AbstractSemanticsObject src, Map<Integer, List<AbstractSurface>> surfaces, Number lod, AbstractCityObject parent) {
		AbstractBoundarySurface boundarySurface = null;

		for (int i = 0; i < src.getNumSurfaces(); i++) {
			SemanticsType semanticsType = src.getSurfaces().get(i);
			if (semanticsType == null)
				continue;

			List<AbstractSurface> tmp = surfaces.get(i);
			if (tmp == null || tmp.isEmpty())
				continue;

			AbstractCityObject cityObject = null;
			switch (semanticsType.getType()) {
			case ROOF_SURFACE:
				cityObject = unmarshalRoofSurface(semanticsType, tmp, lod);
				break;
			case GROUND_SURFACE:
				cityObject = unmarshalGroundSurface(semanticsType, tmp, lod);
				break;
			case WALL_SURFACE:
				cityObject = unmarshalWallSurface(semanticsType, tmp, lod);
				break;
			case CLOSURE_SURFACE:
				cityObject = unmarshalClosureSurface(semanticsType, tmp, lod);
				break;
			case OUTER_CEILING_SURFACE:
				cityObject = unmarshalOuterCeilingSurface(semanticsType, tmp, lod);
				break;
			case OUTER_FLOOR_SURFACE:
				cityObject = unmarshalOuterFloorSurface(semanticsType, tmp, lod);
				break;
			case WINDOW:
				cityObject = unmarshalWindow(semanticsType, tmp, lod);
				break;
			case DOOR:
				cityObject = unmarshalDoor(semanticsType, tmp, lod);
				break;
			default:
				continue;
			}

			if (cityObject instanceof AbstractBoundarySurface) {
				boundarySurface = (AbstractBoundarySurface)cityObject;

				if (parent instanceof AbstractTunnel)
					((AbstractTunnel)parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
				else if (parent instanceof TunnelInstallation)
					((TunnelInstallation)parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
			}

			else if (cityObject instanceof AbstractOpening && boundarySurface != null) {
				// we need a boundary surface to assign the opening to
				boundarySurface.addOpening(new OpeningProperty((AbstractOpening)cityObject));
			}
		}
	}

	public void unmarshalAbstractTunnel(AbstractTunnelType src, AbstractTunnel dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetAttributes()) {
			TunnelAttributes attributes = src.getAttributes();

			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));

			if (attributes.isSetYearOfConstruction())
				dest.setYearOfConstruction(LocalDate.of(attributes.getYearOfConstruction(), 1, 1));

			if (attributes.isSetYearOfDemolition())
				dest.setYearOfConstruction(LocalDate.of(attributes.getYearOfDemolition(), 1, 1));
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			AbstractGeometry geometry = null;
			int lod = 0;

			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest);
				lod = geometryObject.getLod().intValue();
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				geometry = citygml.getCoreUnmarshaller().unmarshalAndTransformGeometryInstance(geometryInstance, dest);
				lod = (int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD);
			}

			if (geometry != null) {
				if (geometry instanceof MultiSurface) {
					MultiSurface multiSurface = (MultiSurface) geometry;
					switch (lod) {
						case 1:
							dest.setLod1MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
						case 2:
							dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
						case 3:
							dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
					}
				} else if (geometry instanceof AbstractSolid) {
					AbstractSolid solid = (AbstractSolid) geometry;
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

		if (src.isSetChildren()) {
			for (String gmlId : src.getChildren()) {
				AbstractCityObjectType cityObject = cityJSON.getCityObject(gmlId);

				if (cityObject instanceof TunnelInstallationType) {
					TunnelInstallation installation = unmarshalTunnelInstallation((TunnelInstallationType) cityObject, cityJSON);
					dest.addOuterTunnelInstallation(new TunnelInstallationProperty(installation));
				} else if (cityObject instanceof TunnelPartType && src instanceof TunnelType) {
					TunnelPart part = unmarshalTunnelPart((TunnelPartType) cityObject, cityJSON);
					dest.addConsistsOfTunnelPart(new TunnelPartProperty(part));
				}
			}
		}
	}

	public Tunnel unmarshalTunnel(TunnelType src, CityJSON cityJSON) {
		Tunnel dest = new Tunnel();
		unmarshalAbstractTunnel(src, dest, cityJSON);

		return dest;
	}
	
	public TunnelPart unmarshalTunnelPart(TunnelPartType src, CityJSON cityJSON) {
		TunnelPart dest = new TunnelPart();
		unmarshalAbstractTunnel(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalTunnelInstallation(TunnelInstallationType src, TunnelInstallation dest) {
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
			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest);

				if (geometry != null) {
					int lod = geometryObject.getLod().intValue();
					switch (lod) {
						case 2:
							dest.setLod2Geometry(new GeometryProperty<>(geometry));
							break;
						case 3:
							dest.setLod3Geometry(new GeometryProperty<>(geometry));
							break;
					}
				}
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType)geometryType;
				ImplicitGeometry geometry = citygml.getCoreUnmarshaller().unmarshalGeometryInstance(geometryInstance);

				if (geometry != null) {
					switch ((int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD)) {
						case 2:
							dest.setLod2ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 3:
							dest.setLod3ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
					}
				}
			}
		}
	}

	public TunnelInstallation unmarshalTunnelInstallation(TunnelInstallationType src, CityJSON cityJSON) {
		TunnelInstallation dest = new TunnelInstallation();
		unmarshalTunnelInstallation(src, dest);

		return dest;
	}

	public void unmarshalAbstractBoundarySurface(SemanticsType src, AbstractBoundarySurface dest, List<AbstractSurface> surfaces, Number lod) {
		dest.setId(DefaultGMLIdManager.getInstance().generateUUID());
		
		if (src.isSetProperties())
			citygml.getGenericsUnmarshaller().unmarshalSemanticsAttributes(src.getProperties(), dest);

		MultiSurface multiSurface = new MultiSurface();
		for (AbstractSurface surface : surfaces)
			multiSurface.addSurfaceMember(new SurfaceProperty(surface));

		switch (lod.intValue()) {
		case 2:
			dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		case 3:
			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		}
	}

	public RoofSurface unmarshalRoofSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		RoofSurface dest = new RoofSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public GroundSurface unmarshalGroundSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		GroundSurface dest = new GroundSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public WallSurface unmarshalWallSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WallSurface dest = new WallSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public ClosureSurface unmarshalClosureSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		ClosureSurface dest = new ClosureSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public OuterCeilingSurface unmarshalOuterCeilingSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		OuterCeilingSurface dest = new OuterCeilingSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public OuterFloorSurface unmarshalOuterFloorSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		OuterFloorSurface dest = new OuterFloorSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public void unmarshalAbstractOpening(SemanticsType src, AbstractOpening dest, List<AbstractSurface> surfaces, Number lod) {
		if (src.isSetProperties())
			citygml.getGenericsUnmarshaller().unmarshalSemanticsAttributes(src.getProperties(), dest);

		if (lod.intValue() == 3) {
			MultiSurface multiSurface = new MultiSurface();
			for (AbstractSurface surface : surfaces)
				multiSurface.addSurfaceMember(new SurfaceProperty(surface));

			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
		}
	}

	public Door unmarshalDoor(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		Door dest = new Door();
		unmarshalAbstractOpening(src, dest, surfaces, lod);

		return dest;
	}

	public Window unmarshalWindow(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		Window dest = new Window();
		unmarshalAbstractOpening(src, dest, surfaces, lod);

		return dest;
	}

}
