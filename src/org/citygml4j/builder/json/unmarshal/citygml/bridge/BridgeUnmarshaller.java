package org.citygml4j.builder.json.unmarshal.citygml.bridge;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.json.CityJSON;
import org.citygml4j.binding.json.feature.AbstractBridgeType;
import org.citygml4j.binding.json.feature.AbstractCityObjectType;
import org.citygml4j.binding.json.feature.Attributes;
import org.citygml4j.binding.json.feature.BridgeAttributes;
import org.citygml4j.binding.json.feature.BridgeConstructionElementType;
import org.citygml4j.binding.json.feature.BridgeInstallationType;
import org.citygml4j.binding.json.feature.BridgePartType;
import org.citygml4j.binding.json.feature.BridgeType;
import org.citygml4j.binding.json.geometry.AbstractGeometryType;
import org.citygml4j.binding.json.geometry.AbstractSemanticsObject;
import org.citygml4j.binding.json.geometry.SemanticsType;
import org.citygml4j.builder.json.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.CityGMLUnmarshaller;
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

public class BridgeUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private final BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public BridgeUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();

		typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
				.with(BridgeType.class, this::unmarshalBridge)
				.with(BridgePartType.class, this::unmarshalBridgePart)
				.with(BridgeInstallationType.class, this::unmarshalBridgeInstallation);
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

				if (parent instanceof AbstractBridge)
					((AbstractBridge)parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
				else if (parent instanceof BridgeInstallation)
					((BridgeInstallation)parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
			}

			else if (cityObject instanceof AbstractOpening && boundarySurface != null) {
				// we need a boundary surface to assign the opening to
				boundarySurface.addOpening(new OpeningProperty((AbstractOpening)cityObject));
			}
		}
	}

	public void unmarshalAbstractBridge(AbstractBridgeType src, AbstractBridge dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetAttributes()) {
			BridgeAttributes attributes = src.getAttributes();

			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));

			if (attributes.isSetYearOfConstruction()) {
				GregorianCalendar yearOfConstruction = new GregorianCalendar();
				yearOfConstruction.set(Calendar.YEAR, attributes.getYearOfConstruction());
				dest.setYearOfConstruction(yearOfConstruction);
			}

			if (attributes.isSetYearOfDemolition()) {
				GregorianCalendar yearOfDemolition = new GregorianCalendar();
				yearOfDemolition.set(Calendar.YEAR, attributes.getYearOfDemolition());
				dest.setYearOfDemolition(yearOfDemolition);
			}
			
			if (attributes.isSetIsMovable())
				dest.setIsMovable(attributes.getIsMovable());
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryType, dest);

			if (geometry != null) {
				int lod = geometryType.getLod().intValue();

				if (geometry instanceof MultiSurface) {
					MultiSurface multiSurface = (MultiSurface)geometry;
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

		if (src.isSetInstallations()) {
			for (String gmlId : src.getInstallations()) {
				BridgeInstallationType installation = cityJSON.getCityObject(gmlId, BridgeInstallationType.class);
				if (installation != null)
					dest.addOuterBridgeInstallation(new BridgeInstallationProperty(unmarshalBridgeInstallation(installation, cityJSON)));
			}
		}
		
		if (src.isSetConstructionElements()) {
			for (String gmlId : src.getConstructionElements()) {
				BridgeConstructionElementType element = cityJSON.getCityObject(gmlId, BridgeConstructionElementType.class);
				if (element != null)
					dest.addOuterBridgeConstructionElement(new BridgeConstructionElementProperty(unmarshalBridgeConstructionElement(element, cityJSON)));
			}
		}

		if (src instanceof BridgeType) {
			BridgeType bridge = (BridgeType)src;
			if (bridge.isSetParts()) {
				for (String gmlId : bridge.getParts()) {
					BridgePartType bridgePart = cityJSON.getCityObject(gmlId, BridgePartType.class);
					if (bridgePart != null)
						dest.addConsistsOfBridgePart(new BridgePartProperty(unmarshalBridgePart(bridgePart, cityJSON)));
				}
			}
		}

		if (src.isSetAddress())
			dest.addAddress(new AddressProperty(citygml.getCoreUnmarshaller().unmarshalAddress(src.getAddress())));
	}

	public Bridge unmarshalBridge(BridgeType src, CityJSON cityJSON) {
		Bridge dest = new Bridge();
		unmarshalAbstractBridge(src, dest, cityJSON);

		return dest;
	}
	
	public BridgePart unmarshalBridgePart(BridgePartType src, CityJSON cityJSON) {
		BridgePart dest = new BridgePart();
		unmarshalAbstractBridge(src, dest, cityJSON);

		return dest;
	}
	
	public void unmarshalBridgeConstructionElement(BridgeConstructionElementType src, BridgeConstructionElement dest) {
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
				switch (lod) {
				case 2:
					dest.setLod2Geometry(new GeometryProperty<>(geometry));
					break;
				case 3:
					dest.setLod3Geometry(new GeometryProperty<>(geometry));
					break;
				}
			}	
		}
	}

	public BridgeConstructionElement unmarshalBridgeConstructionElement(BridgeConstructionElementType src, CityJSON cityJSON) {
		BridgeConstructionElement dest = new BridgeConstructionElement();
		unmarshalBridgeConstructionElement(src, dest);

		return dest;
	}

	public void unmarshalBridgeInstallation(BridgeInstallationType src, BridgeInstallation dest) {
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
				switch (lod) {
				case 2:
					dest.setLod2Geometry(new GeometryProperty<>(geometry));
					break;
				case 3:
					dest.setLod3Geometry(new GeometryProperty<>(geometry));
					break;
				}
			}	
		}
	}

	public BridgeInstallation unmarshalBridgeInstallation(BridgeInstallationType src, CityJSON cityJSON) {
		BridgeInstallation dest = new BridgeInstallation();
		unmarshalBridgeInstallation(src, dest);

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
