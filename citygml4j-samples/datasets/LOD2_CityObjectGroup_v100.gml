<?xml version="1.0" encoding="UTF-8"?>
<CityModel xmlns="http://www.opengis.net/citygml/1.0" xmlns:grp="http://www.opengis.net/citygml/cityobjectgroup/1.0"
    xmlns:wtr="http://www.opengis.net/citygml/waterbody/1.0" xmlns:tran="http://www.opengis.net/citygml/transportation/1.0"
    xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.opengis.net/citygml/transportation/1.0
    http://schemas.opengis.net/citygml/transportation/1.0/transportation.xsd http://www.opengis.net/citygml/waterbody/1.0 http://schemas.opengis.net/citygml/waterbody/1.0/waterBody.xsd http://www.opengis.net/citygml/cityobjectgroup/1.0 http://schemas.opengis.net/citygml/cityobjectgroup/1.0/cityObjectGroup.xsd">
    <gml:description> This CityGML file contains examples for transportation objects, water bodies, and groups. However, the
        geometries do not make sense; they are only included to illustrate the document structuring. The elements of the object
        group are referenced by their ID. </gml:description>
    <gml:name>Roads and Areas of the 3D City Model of Bonn being of interest for tourists</gml:name>
    <gml:boundedBy>
        <gml:Envelope srsName="urn:ogc:def:crs,crs:EPSG:6.12:31466,crs:EPSG:6.12:5783">
            <gml:pos srsDimension="3">0.0 0.0 0.0 </gml:pos>
            <gml:pos srsDimension="3">33.0 34.0 2.5</gml:pos>
        </gml:Envelope>
    </gml:boundedBy>
    <cityObjectMember>
        <tran:Road gml:id="ID_76">
            <gml:name>Adenauerallee</gml:name>
            <gml:name>B 9</gml:name>
            <tran:function>113</tran:function>
            <tran:trafficArea>
                <tran:TrafficArea>
                    <tran:function>1</tran:function>
                    <tran:surfaceMaterial>1</tran:surfaceMaterial>
                    <tran:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">2.0 1.0 2.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </tran:lod2MultiSurface>
                </tran:TrafficArea>
            </tran:trafficArea>
            <tran:trafficArea>
                <tran:TrafficArea>
                    <tran:function>2</tran:function>
                    <tran:lod2MultiSurface>
                        <gml:MultiSurface gml:id="ID_83">
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">2.0 1.0 2.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </tran:lod2MultiSurface>
                </tran:TrafficArea>
            </tran:trafficArea>
            <tran:trafficArea>
                <tran:TrafficArea>
                    <tran:function>3</tran:function>
                    <tran:lod2MultiSurface xlink:href="#ID_83"/>
                </tran:TrafficArea>
            </tran:trafficArea>
            <tran:auxiliaryTrafficArea>
                <tran:AuxiliaryTrafficArea>
                    <tran:function>31</tran:function>
                    <tran:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">2.0 1.0 2.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </tran:lod2MultiSurface>
                </tran:AuxiliaryTrafficArea>
            </tran:auxiliaryTrafficArea>
        </tran:Road>
    </cityObjectMember>
    <cityObjectMember>
        <tran:Road gml:id="ID_78">
            <tran:trafficArea>
                <tran:TrafficArea>
                    <gml:name>Bonngasse</gml:name>
                    <tran:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">2.0 1.0 2.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </tran:lod2MultiSurface>
                </tran:TrafficArea>
            </tran:trafficArea>
        </tran:Road>
    </cityObjectMember>
    <cityObjectMember>
        <tran:Square gml:id="ID_79">
            <gml:name>Hofgarten</gml:name>
            <tran:trafficArea>
                <tran:TrafficArea>
                    <tran:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 0.0</gml:pos>
                                            <gml:pos srsDimension="3">3.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">2.0 1.0 2.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 1.5</gml:pos>
                                            <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </tran:lod2MultiSurface>
                </tran:TrafficArea>
            </tran:trafficArea>
        </tran:Square>
    </cityObjectMember>
    <cityObjectMember>
        <wtr:WaterBody gml:id="ID_81">
            <gml:name>Ruhr</gml:name>
            <wtr:class>20</wtr:class>
            <wtr:boundedBy>
                <wtr:WaterSurface>
                    <wtr:lod2Surface>
                        <gml:Polygon>
                            <gml:exterior>
                                <gml:LinearRing>
                                    <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                    <gml:pos srsDimension="3">3.0 1.0 0.0</gml:pos>
                                    <gml:pos srsDimension="3">3.0 1.0 1.5</gml:pos>
                                    <gml:pos srsDimension="3">2.0 1.0 2.5</gml:pos>
                                    <gml:pos srsDimension="3">1.0 1.0 1.5</gml:pos>
                                    <gml:pos srsDimension="3">1.0 1.0 0.0</gml:pos>
                                </gml:LinearRing>
                            </gml:exterior>
                        </gml:Polygon>
                    </wtr:lod2Surface>
                </wtr:WaterSurface>
            </wtr:boundedBy>
        </wtr:WaterBody>
    </cityObjectMember>
    <cityObjectMember>
        <grp:CityObjectGroup>
            <grp:class>Group of Roads and Water bodies</grp:class>
            <grp:function>Roads and Areas in Bonn being of interest for tourists</grp:function>
            <grp:groupMember role="Road along the building where Beethoven was born" xlink:href="#ID_78"/>
            <grp:groupMember role="Nice place to walk, near the university" xlink:href="#ID_79"/>
            <grp:groupMember role="Small river, suitable for rafting or rowing" xlink:href="#ID_81"/>
            <grp:groupMember role="Famous museums and exhibitions" xlink:href="#ID_76"/>
        </grp:CityObjectGroup>
    </cityObjectMember>
</CityModel>
