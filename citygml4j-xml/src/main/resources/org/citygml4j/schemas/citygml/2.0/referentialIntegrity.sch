<?xml version="1.0" encoding="UTF-8"?>
<!-- CityGML Version No. 2.0.0, February 2012 -->
<!-- CityGML - GML 3.1.1 application schema for 3D city models -->
<!-- International encoding standard of the Open Geospatial Consortium, see http://www.opengeospatial.org/standards/citygml -->
<!-- Jointly developed by the Special Interest Group 3D (SIG 3D) of GDI-DE, see http://www.sig3d.org               -->
<!-- For further information see: http://www.citygml.org -->
<!-- CityGML is an OGC Standard. -->
<!-- Copyright (c) 2012 Open Geospatial Consortium. -->
<!-- To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ . -->
<sch:schema xmlns:sch="http://www.ascc.net/xml/schematron">
	<sch:title>Schematron constraints for CityGML 2.0</sch:title>
	<sch:ns prefix="gml" uri="http://www.opengis.net/gml"/>
	<sch:ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
	<sch:ns prefix="core" uri="http://www.opengis.net/citygml/2.0"/>
	<sch:ns prefix="app" uri="http://www.opengis.net/citygml/appearance/2.0"/>
	<sch:ns prefix="brid" uri="http://www.opengis.net/citygml/bridge/2.0"/>
	<sch:ns prefix="bldg" uri="http://www.opengis.net/citygml/building/2.0"/>
	<sch:ns prefix="frn" uri="http://www.opengis.net/citygml/cityfurniture/2.0"/>
	<sch:ns prefix="grp" uri="http://www.opengis.net/citygml/cityobjectgroup/2.0"/>
	<sch:ns prefix="gen" uri="http://www.opengis.net/citygml/generics/2.0"/>
	<sch:ns prefix="luse" uri="http://www.opengis.net/citygml/landuse/2.0"/>
	<sch:ns prefix="dem" uri="http://www.opengis.net/citygml/relief/2.0"/>
	<sch:ns prefix="tex" uri="http://www.opengis.net/citygml/texturedsurface/2.0"/>
	<sch:ns prefix="tran" uri="http://www.opengis.net/citygml/transportation/2.0"/>
	<sch:ns prefix="tun" uri="http://www.opengis.net/citygml/tunnel/2.0"/>
	<sch:ns prefix="veg" uri="http://www.opengis.net/citygml/vegetation/2.0"/>
	<sch:ns prefix="wtr" uri="http://www.opengis.net/citygml/waterbody/2.0"/>
	<!-- ========================================================================================= -->
	<!-- === base rule "hrefOrContent" for referential integrity checks (taken from GMl 3.1.1) === -->
	<!-- ========================================================================================= -->
	<sch:pattern name="Check either href or content not both">
		<sch:rule abstract="true" id="hrefOrContent">
			<sch:report test="@xlink:href and (*|text())">Property element may not carry both a reference to an object and contain an object.</sch:report>
			<sch:assert test="@xlink:href | (*|text())">Property element must either carry a reference to an object or contain an object.</sch:assert>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Core module ========= -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on core:cityObjectMember">
		<sch:rule context="core:cityObjectMember">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on core:generalizesTo">
		<sch:rule context="core:generalizesTo">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Appearance module === -->
	<!-- ========================================================================================= -->
	<sch:pattern name="Restrict children to app:Appearance elements">
		<sch:rule context="core:CityModel">
			<sch:assert test="count(app:appearanceMember/*)=count(app:appearanceMember/app:Appearance)">app:appearanceMember shall only contain app:Appearance elements.</sch:assert>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on app:appearanceMember">
		<sch:rule context="app:appearanceMember">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on app:appearance">
		<sch:rule context="app:appearance">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on app:surfaceDataMember">
		<sch:rule context="app:surfaceDataMember">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on app:target">
		<sch:rule context="app:ParameterizedTexture/app:target">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Bridge module ======= -->
	<!-- ========================================================================================= -->
	<!-- covers boundedBy property of _AbstractBridge, BridgeInstallation, IntBuildingInstallation,
	     BridgeConstructionElement, and BridgeRoom -->
	<sch:pattern name="hrefOrContent check on brid:boundedBy">
		<sch:rule context="brid:boundedBy">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:outerBridgeConstruction">
		<sch:rule context="brid:outerBridgeConstruction">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:outerBridgeInstallation">
		<sch:rule context="brid:outerBridgeInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:interiorBridgeInstallation">
		<sch:rule context="brid:interiorBridgeInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:interiorBridgeRoom">
		<sch:rule context="brid:interiorBridgeRoom">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:consistsOfBridgePart">
		<sch:rule context="brid:consistsOfBridgePart">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- covers address property of _Bridge and Door -->
	<sch:pattern name="hrefOrContent check on brid:address">
		<sch:rule context="brid:address">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:opening">
		<sch:rule context="brid:opening">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:interiorFurniture">
		<sch:rule context="brid:interiorFurniture">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:bridgeRoomInstallation">
		<sch:rule context="brid:bridgeRoomInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on brid:lod[1..4]ImplicitRepresentation">
		<sch:rule
			context="brid:lod1ImplicitRepresentation | brid:lod2ImplicitRepresentation | brid:lod3ImplicitRepresentation | brid:lod4ImplicitRepresentation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Building module ===== -->
	<!-- ========================================================================================= -->
	<!-- covers boundedBy property of _AbstractBuilding, Room, BuildingInstallation, and IntBuildingInstallation -->
	<sch:pattern name="hrefOrContent check on bldg:boundedBy">
		<sch:rule context="bldg:boundedBy">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:outerBuildingInstallation">
		<sch:rule context="bldg:outerBuildingInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:interiorBuildingInstallation">
		<sch:rule context="bldg:interiorBuildingInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:interiorRoom">
		<sch:rule context="bldg:interiorRoom">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:consistsOfBuildingPart">
		<sch:rule context="bldg:consistsOfBuildingPart">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- covers address property of _Building and Door -->
	<sch:pattern name="hrefOrContent check on bldg:address">
		<sch:rule context="bldg:address">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:opening">
		<sch:rule context="bldg:opening">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:interiorFurniture">
		<sch:rule context="bldg:interiorFurniture">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:roomInstallation">
		<sch:rule context="bldg:roomInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on bldg:lod[2..4]ImplicitRepresentation">
		<sch:rule context="bldg:lod2ImplicitRepresentation | bldg:lod3ImplicitRepresentation | bldg:lod4ImplicitRepresentation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ===== referential integrity checks on associations of the CityGML CityFurniture module == -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on frn:lod[1..4]ImplicitRepresentation">
		<sch:rule
			context="frn:lod1ImplicitRepresentation | frn:lod2ImplicitRepresentation | frn:lod3ImplicitRepresentation | frn:lod4ImplicitRepresentation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- === referential integrity checks on associations of the CityGML CityObjectGroup module == -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on grp:groupMember">
		<sch:rule context="grp:groupMember">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on grp:parent">
		<sch:rule context="grp:parent">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Generics module ===== -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on gen:lod[0..4]ImplicitRepresentation">
		<sch:rule
			context="gen:lod0ImplicitRepresentation | gen:lod1ImplicitRepresentation | gen:lod2ImplicitRepresentation |
            gen:lod3ImplicitRepresentation | gen:lod4ImplicitRepresentation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Relief module ======= -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on dem:reliefComponent">
		<sch:rule context="dem:reliefComponent">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on dem:tin">
		<sch:rule context="dem:tin">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on dem:grid">
		<sch:rule context="dem:grid">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- == referential integrity checks on associations of the CityGML TexturedSurface module === -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on tex:appearance">
		<sch:rule context="tex:appearance">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ==== referential integrity checks on associations of the CityGML Transportation module == -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on tran:trafficArea">
		<sch:rule context="tran:trafficArea">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tran:auxiliaryTrafficArea">
		<sch:rule context="tran:auxiliaryTrafficArea">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Tunnel module ======= -->
	<!-- ========================================================================================= -->
	<!-- covers boundedBy property of _AbstractTunnel, TunnelInstallation, IntTunnelInstallation, and HollowSpace -->
	<sch:pattern name="hrefOrContent check on tun:boundedBy">
		<sch:rule context="tun:boundedBy">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:outerTunnelInstallation">
		<sch:rule context="tun:outerTunnelInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:interiorTunnelInstallation">
		<sch:rule context="tun:interiorTunnelInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:interiorHollowSpace">
		<sch:rule context="tun:interiorHollowSpace">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:consistsOfTunnelPart">
		<sch:rule context="tun:consistsOfTunnelPart">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:opening">
		<sch:rule context="tun:opening">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:interiorFurniture">
		<sch:rule context="tun:interiorFurniture">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:hollowSpaceInstallation">
		<sch:rule context="tun:hollowSpaceInstallation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<sch:pattern name="hrefOrContent check on tun:lod[2..4]ImplicitRepresentation">
		<sch:rule context="tun:lod2ImplicitRepresentation | tun:lod3ImplicitRepresentation | tun:lod4ImplicitRepresentation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML Vegetation module === -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on veg:SolitaryVegetationObject/veg:lod[1..4]ImplicitRepresentation">
		<sch:rule
			context="veg:SolitaryVegetationObject/veg:lod1ImplicitRepresentation | 
            veg:SolitaryVegetationObject/veg:lod2ImplicitRepresentation | 
            veg:SolitaryVegetationObject/veg:lod3ImplicitRepresentation | 
            veg:SolitaryVegetationObject/veg:lod4ImplicitRepresentation">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
	<!-- ========================================================================================= -->
	<!-- ======= referential integrity checks on associations of the CityGML WaterBody module ==== -->
	<!-- ========================================================================================= -->
	<sch:pattern name="hrefOrContent check on wtr:boundedBy">
		<sch:rule context="wtr:boundedBy">
			<sch:extends rule="hrefOrContent"/>
		</sch:rule>
	</sch:pattern>
</sch:schema>
