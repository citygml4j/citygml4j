<?xml version="1.0" encoding="UTF-8"?>
<!-- CityGML Version No. 1.0.0, April 29th, 2008-->
<!-- CityGML - GML3 application schema for the 3D city model of the Special Interest Group 3D (SIG 3D) of GDI NRW-->
<!-- Editors: PD Dr. Gerhard Groeger, Institute for Geodesy and Geoinformation, University of Bonn & -->
<!-- Prof. Dr. Thomas H. Kolbe, Institute for Geodesy and Geoinformation Science, Technical University of Berlin -->
<!-- For further information see: www.citygml.org -->
<!-- For the history of changes and additions to this CityGML schema see file history.txt -->
<schema xmlns="http://www.ascc.net/xml/schematron">
    <title>Schematron validation rules checking referential integrity of CityGML association types</title>
    <ns prefix="gml" uri="http://www.opengis.net/gml"/>
    <ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
    <ns prefix="core" uri="http://www.opengis.net/citygml/1.0"/>
    <ns prefix="app" uri="http://www.opengis.net/citygml/appearance/1.0"/>
    <ns prefix="bldg" uri="http://www.opengis.net/citygml/building/1.0"/>
    <ns prefix="frn" uri="http://www.opengis.net/citygml/cityfurniture/1.0"/>
    <ns prefix="grp" uri="http://www.opengis.net/citygml/cityobjectgroup/1.0"/>
    <ns prefix="gen" uri="http://www.opengis.net/citygml/generics/1.0"/>
    <ns prefix="luse" uri="http://www.opengis.net/citygml/landuse/1.0"/>
    <ns prefix="dem" uri="http://www.opengis.net/citygml/relief/1.0"/>
    <ns prefix="tex" uri="http://www.opengis.net/citygml/texturedsurface/1.0"/>
    <ns prefix="tran" uri="http://www.opengis.net/citygml/transportation/1.0"/>
    <ns prefix="veg" uri="http://www.opengis.net/citygml/vegetation/1.0"/>
    <ns prefix="wtr" uri="http://www.opengis.net/citygml/waterbody/1.0"/>
    <!-- pattern "hrefOrContent" is taken from GML 3.1.1 -->
    <pattern name="Check either href or content not both">
        <rule abstract="true" id="hrefOrContent">
            <report test="@xlink:href and (*|text())">Property element may not carry both a reference to an object and contain an
                object.</report>
            <assert test="@xlink:href | (*|text())">Property element must either carry a reference to an object or contain an
                object.</assert>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML Core module==================== -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on core:cityObjectMember">
        <rule context="core:cityObjectMember">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on core:generalizesTo">
        <rule context="core:generalizesTo">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML Appearance module=============== -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on app:appearanceMember">
        <rule context="app:appearanceMember">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on app:appearance">
        <rule context="app:appearance">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on app:surfaceDataMember">
        <rule context="app:surfaceDataMember">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on app:target">
        <rule context="app:ParameterizedTexture/app:target">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML Building module================== -->
    <!-- ========================================================================================= -->
    <!-- covers boundedBy property of _Building and Room -->
    <pattern name="hrefOrContent check on bldg:boundedBy">
        <rule context="bldg:boundedBy">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on bldg:outerBuildingInstallation">
        <rule context="bldg:outerBuildingInstallation">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on bldg:interiorBuildingInstallation">
        <rule context="bldg:interiorBuildingInstallation">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on bldg:interiorRoom">
        <rule context="bldg:interiorRoom">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on bldg:consistsOfBuildingPart">
        <rule context="bldg:consistsOfBuildingPart">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- covers address property of _Building and Room -->
    <pattern name="hrefOrContent check on bldg:address">
        <rule context="bldg:address">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on bldg:opening">
        <rule context="bldg:opening">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on bldg:interiorFurniture">
        <rule context="bldg:interiorFurniture">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on bldg:roomInstallation">
        <rule context="bldg:roomInstallation">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML CityFurniture module============== -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on frn:lod[1..4]ImplicitRepresentation">
        <rule
            context="frn:lod1ImplicitRepresentation | frn:lod2ImplicitRepresentation | frn:lod3ImplicitRepresentation | frn:lod4ImplicitRepresentation">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML CityObjectGroup module=========== -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on grp:groupMember">
        <rule context="grp:groupMember">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on grp:parent">
        <rule context="grp:parent">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML Generics module================= -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on gen:lod[0..4]ImplicitRepresentation">
        <rule
            context="gen:lod0ImplicitRepresentation | gen:lod1ImplicitRepresentation | gen:lod2ImplicitRepresentation |
            gen:lod3ImplicitRepresentation | gen:lod4ImplicitRepresentation">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML Relief module==================== -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on dem:reliefComponent">
        <rule context="dem:reliefComponent">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on dem:tin">
        <rule context="dem:tin">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on dem:grid">
        <rule context="dem:grid">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- ======referential integrity checks on associations of the CityGML TexturedSurface (deprecated) module======== -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on tex:appearance">
        <rule context="tex:appearance">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML Transportation module============= -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on tran:trafficArea">
        <rule context="tran:trafficArea">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <pattern name="hrefOrContent check on tran:auxiliaryTrafficArea">
        <rule context="tran:auxiliaryTrafficArea">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML Vegetation module================ -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on veg:SolitaryVegetationObject/veg:lod[1..4]ImplicitRepresentation">
        <rule
            context="veg:SolitaryVegetationObject/veg:lod1ImplicitRepresentation | 
            veg:SolitaryVegetationObject/veg:lod2ImplicitRepresentation | 
            veg:SolitaryVegetationObject/veg:lod3ImplicitRepresentation | 
            veg:SolitaryVegetationObject/veg:lod4ImplicitRepresentation">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
    <!-- ========================================================================================= -->
    <!-- =============referential integrity checks on associations of the CityGML WaterBody module================ -->
    <!-- ========================================================================================= -->
    <pattern name="hrefOrContent check on wtr:boundedBy">
        <rule context="wtr:boundedBy">
            <extends rule="hrefOrContent"/>
        </rule>
    </pattern>
</schema>
