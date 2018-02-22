<?xml version="1.0" encoding="UTF-8"?>
<core:CityModel xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.citygml.org/ade/sub/0.9.0 schemas/CityGML-SubsurfaceADE-0_9_0.xsd" xmlns="http://www.opengis.net/citygml/Profiles/base/1.0"
    xmlns:xAL="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0" xmlns:sub="http://www.citygml.org/ade/sub/0.9.0"
    xmlns:grp="http://www.opengis.net/citygml/cityobjectgroup/1.0" xmlns:luse="http://www.opengis.net/citygml/landuse/1.0"
    xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:tex="http://www.opengis.net/citygml/texturedsurface/1.0" xmlns:gml="http://www.opengis.net/gml"
    xmlns:core="http://www.opengis.net/citygml/1.0" xmlns:bldg="http://www.opengis.net/citygml/building/1.0">
    <gml:name>U-Bahn-Tunnel -LoD2-Project</gml:name>
    <gml:boundedBy>
        <gml:Envelope srsName="EPSG:31467">
            <gml:lowerCorner srsDimension="3">459000 5439693 -21 </gml:lowerCorner>
            <gml:upperCorner srsDimension="3">459120 5440353 4 </gml:upperCorner>
        </gml:Envelope>
    </gml:boundedBy>
    <core:cityObjectMember>
        <bldg:Building gml:id="1st-Building">
            <gml:name>U-Bahn-Tunnel -LoD2-Bahnhof-Nord</gml:name>
            <sub:relativeToTerrain>substantiallyBelowTerrain</sub:relativeToTerrain>
            <bldg:class>1170</bldg:class>
            <bldg:function>2500</bldg:function>
            <bldg:boundedBy>
                <bldg:RoofSurface>
                    <gml:name>Bahnhof-Nord-Dach</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440278 -1 459050 5440303 -1 459050 5440243 -1 459055 5440278 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440278 -1 459070 5440303 -1 459050 5440303 -1 459065 5440278 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440278 -1 459070 5440243 -1 459070 5440303 -1 459065 5440278 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440268 -1 459050 5440243 -1 459070 5440243 -1 459055 5440268 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459070 5440243 -1 459065 5440268 -1 459055 5440268 -1 459070 5440243 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459070 5440243 -1 459065 5440278 -1 459065 5440268 -1 459070 5440243 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459050 5440303 -1 459055 5440278 -1 459065 5440278 -1 459050 5440303 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459050 5440243 -1 459055 5440268 -1 459055 5440278 -1 459050 5440243 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:RoofSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:ClosureSurface>
                    <gml:name>Bahnhof-Nord-Durchfahrt</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:Polygon>
                                <gml:exterior>
                                    <gml:LinearRing>
                                        <gml:posList srsDimension="3">459055 5440243 -13 459065 5440243 -13 459060 5440243 -10.1690483093262 459055 5440243 -13
                                        </gml:posList>
                                    </gml:LinearRing>
                                </gml:exterior>
                            </gml:Polygon>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440243 -13 459065 5440243 -20 459065 5440243 -13 459055 5440243 -13
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440243 -20 459055 5440243 -13 459055 5440243 -20 459065 5440243 -20
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:ClosureSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Westseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459050 5440303 -1 459050 5440303 -21 459050 5440243 -21 459050 5440243 -1 459050
                                                5440303 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Nordseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459070 5440303 -1 459070 5440303 -21 459050 5440303 -21 459050 5440303 -1 459070
                                                5440303 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Ostseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459070 5440243 -1 459070 5440243 -21 459070 5440303 -21 459070 5440303 -1 459070
                                                5440243 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Suedseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440243 -20 459050 5440243 -21 459070 5440243 -21 459065 5440243 -20
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440243 -13 459050 5440243 -1 459050 5440243 -21 459055 5440243 -13
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459060 5440243 -10.1690483093262 459070 5440243 -1 459050 5440243 -1 459060 5440243
                                                -10.1690483093262 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440243 -13 459070 5440243 -21 459070 5440243 -1 459065 5440243 -13
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459050 5440243 -21 459055 5440243 -20 459055 5440243 -13 459050 5440243 -21
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459050 5440243 -21 459065 5440243 -20 459055 5440243 -20 459050 5440243 -21
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459070 5440243 -21 459065 5440243 -13 459065 5440243 -20 459070 5440243 -21
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459070 5440243 -1 459060 5440243 -10.1690483093262 459065 5440243 -13 459070 5440243
                                                -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459050 5440243 -1 459055 5440243 -13 459060 5440243 -10.1690483093262 459050 5440243
                                                -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:GroundSurface>
                    <gml:name>Bahnhof-Nord-Boden</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459070 5440303 -21 459070 5440243 -21 459050 5440243 -21 459050 5440303 -21 459070
                                                5440303 -21 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:GroundSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:RoofSurface>
                    <gml:name>Bahnhof-Nord-Eingang-Dach-West</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459060 5440268 4 459060 5440278 4 459055 5440278 3 459055 5440268 3 459060 5440268 4
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:RoofSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:RoofSurface>
                    <gml:name>Bahnhof-Nord-Eingang-Dach-Ost</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440268 3 459065 5440278 3 459060 5440278 4 459060 5440268 4 459065 5440268 3
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:RoofSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Eingang-Suedseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459060 5440268 4 459055 5440268 -1 459065 5440268 -1 459060 5440268 4 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440268 -1 459060 5440268 4 459055 5440268 3 459055 5440268 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440268 -1 459065 5440268 3 459060 5440268 4 459065 5440268 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Eingang-Ostseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440278 3 459065 5440268 -1 459065 5440278 -1 459065 5440278 3 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440268 -1 459065 5440278 3 459065 5440268 3 459065 5440268 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Eingang-Nordseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459060 5440278 4 459065 5440278 -1 459055 5440278 -1 459060 5440278 4 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440278 -1 459060 5440278 4 459065 5440278 3 459065 5440278 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440278 -1 459055 5440278 3 459060 5440278 4 459055 5440278 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:boundedBy>
                <bldg:WallSurface>
                    <gml:name>Bahnhof-Nord-Eingang-Westseite</gml:name>
                    <bldg:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440268 3 459055 5440278 -1 459055 5440268 -1 459055 5440268 3 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440278 -1 459055 5440268 3 459055 5440278 3 459055 5440278 -1 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </bldg:lod2MultiSurface>
                </bldg:WallSurface>
            </bldg:boundedBy>
            <bldg:address>
                <core:Address>
                    <core:xalAddress>
                        <xAL:AddressDetails>
                            <xAL:Country>
                                <xAL:CountryName>Germany</xAL:CountryName>
                                <xAL:Locality Type="City">
                                    <xAL:LocalityName>Berlin</xAL:LocalityName>
                                    <xAL:Thoroughfare Type="Street">
                                        <xAL:ThoroughfareName>Straße des 17. Juni</xAL:ThoroughfareName>
                                        <xAL:ThoroughfareNumber>135</xAL:ThoroughfareNumber>
                                    </xAL:Thoroughfare>
                                    <xAL:PostalCode>
                                        <xAL:PostalCodeNumber>10623</xAL:PostalCodeNumber>
                                    </xAL:PostalCode>
                                </xAL:Locality>
                            </xAL:Country>
                        </xAL:AddressDetails>
                    </core:xalAddress>
                </core:Address>
            </bldg:address>
        </bldg:Building>
    </core:cityObjectMember>
    <core:cityObjectMember>
        <sub:Tunnel gml:id="UUID_TUNNEL_0815">
            <gml:name>U-Bahn-Tunnel -LoD2-Tunnelroehre</gml:name>
            <core:creationDate>2010-02-09</core:creationDate>
            <sub:relativeToTerrain>invalid</sub:relativeToTerrain>
            <sub:boundedBy>
                <sub:RoofSurface>
                    <gml:name>Tunneldach</gml:name>
                    <sub:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440243 -13 459060 5440243 -10.1690483093262 459060 5439803 -10.1690483093262
                                                459065 5439803 -13 459065 5440243 -13 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459060 5440243 -10.1690483093262 459055 5440243 -13 459055 5439803 -13 459060 5439803
                                                -10.1690483093262 459060 5440243 -10.1690483093262 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </sub:lod2MultiSurface>
                </sub:RoofSurface>
            </sub:boundedBy>
            <sub:boundedBy>
                <sub:ClosureSurface>
                    <gml:name>Tunnel-Einfahrt-Nord</gml:name>
                    <sub:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440243 -13 459065 5440243 -20 459055 5440243 -13 459065 5440243 -13
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440243 -20 459055 5440243 -13 459065 5440243 -20 459055 5440243 -20
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459060 5440243 -10.1690483093262 459065 5440243 -13 459055 5440243 -13 459060 5440243
                                                -10.1690483093262 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </sub:lod2MultiSurface>
                </sub:ClosureSurface>
            </sub:boundedBy>
            <sub:boundedBy>
                <sub:WallSurface>
                    <gml:name>Tunnel-Wand-Ost</gml:name>
                    <sub:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5440243 -20 459065 5440243 -13 459065 5439803 -13 459065 5439803 -20 459065
                                                5440243 -20 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </sub:lod2MultiSurface>
                </sub:WallSurface>
            </sub:boundedBy>
            <sub:boundedBy>
                <sub:GroundSurface>
                    <gml:name>Tunnelboden</gml:name>
                    <sub:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440243 -20 459065 5440243 -20 459065 5439803 -20 459055 5439803 -20 459055
                                                5440243 -20 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </sub:lod2MultiSurface>
                </sub:GroundSurface>
            </sub:boundedBy>
            <sub:boundedBy>
                <sub:WallSurface>
                    <gml:name>Tunnel-Wand-West</gml:name>
                    <sub:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5440243 -13 459055 5440243 -20 459055 5439803 -20 459055 5439803 -13 459055
                                                5440243 -13 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </sub:lod2MultiSurface>
                </sub:WallSurface>
            </sub:boundedBy>
            <sub:boundedBy>
                <sub:ClosureSurface>
                    <gml:name>Tunnel-Einfahrt-Sued</gml:name>
                    <sub:lod2MultiSurface>
                        <gml:MultiSurface>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5439803 -13 459065 5439803 -20 459065 5439803 -13 459055 5439803 -13
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459065 5439803 -20 459055 5439803 -13 459055 5439803 -20 459065 5439803 -20
                                            </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                            <gml:surfaceMember>
                                <gml:Polygon>
                                    <gml:exterior>
                                        <gml:LinearRing>
                                            <gml:posList srsDimension="3">459055 5439803 -13 459065 5439803 -13 459060 5439803 -10.1690483093262 459055 5439803
                                                -13 </gml:posList>
                                        </gml:LinearRing>
                                    </gml:exterior>
                                </gml:Polygon>
                            </gml:surfaceMember>
                        </gml:MultiSurface>
                    </sub:lod2MultiSurface>
                </sub:ClosureSurface>
            </sub:boundedBy>
        </sub:Tunnel>
    </core:cityObjectMember>
</core:CityModel>
