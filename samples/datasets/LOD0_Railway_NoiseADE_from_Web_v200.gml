<?xml version="1.0" encoding="ISO-8859-15"?>
<CityModel xmlns="http://www.opengis.net/citygml/2.0" xmlns:gml="http://www.opengis.net/gml"
    xmlns:tran="http://www.opengis.net/citygml/transportation/2.0" xmlns:xlink="http://www.w3.org/1999/xlink"
    xmlns:xAL="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0" xmlns:noise="http://www.citygml.org/ade/noise_de/2.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.citygml.org/ade/noise_de/2.0 http://schemas.opengis.net/citygml/examples/2.0/ade/noise-ade/CityGML-NoiseADE.xsd">
    <gml:name>Eisenbahnmodell</gml:name>
    <gml:boundedBy>
        <gml:Envelope srsName="EPSG:31466">
            <gml:pos srsDimension="3">2523800.0 5705800.0 140.4</gml:pos>
            <gml:pos srsDimension="3">2526200.0 5708200.0 252.6</gml:pos>
        </gml:Envelope>
    </gml:boundedBy>
    <cityObjectMember>
        <tran:Railway gml:id="CRW_0815">
            <gml:name>ABC-098-7654</gml:name>
            <gml:boundedBy>
                <gml:Envelope srsName="EPSG:31466">
                    <gml:pos srsDimension="3">2523800.0 5705800.0 140.4</gml:pos>
                    <gml:pos srsDimension="3">2526200.0 5708200.0 252.6</gml:pos>
                </gml:Envelope>
            </gml:boundedBy>
            <creationDate>1967-08-13</creationDate>
            <terminationDate>1967-08-13</terminationDate>
            <tran:function>1234</tran:function>
            <tran:lod0Network>
                <gml:CompositeCurve srsName="EPSG:31466">
                    <gml:curveMember>
                        <gml:LineString>
                            <gml:coordinates decimal="." cs="," ts=" ">2524175,5707335,188 2524181,5707338,188 2524185,5707330,188
                                2524179,5707327,188</gml:coordinates>
                        </gml:LineString>
                    </gml:curveMember>
                    <gml:curveMember>
                        <gml:LineString>
                            <gml:coordinates decimal="." cs="," ts=" ">2524175,5707335,188 2524181,5707338,188 2524185,5707330,188
                                2524179,5707327,188</gml:coordinates>
                        </gml:LineString>
                    </gml:curveMember>
                </gml:CompositeCurve>
            </tran:lod0Network>
            <noise:noiseRailwaySegmentProperty>
                <noise:NoiseRailwaySegment gml:id="CNRS_0815">
                    <gml:boundedBy>
                        <gml:Envelope srsName="EPSG:31466">
                            <gml:pos srsDimension="3">2523800.0 5705800.0 140.4</gml:pos>
                            <gml:pos srsDimension="3">2526200.0 5708200.0 252.6</gml:pos>
                        </gml:Envelope>
                    </gml:boundedBy>
                    <creationDate>1967-08-13</creationDate>
                    <terminationDate>1967-08-13</terminationDate>
                    <externalReference>
                        <informationSystem>file:///L:/FB43_GeoDatZ/2006172_Laermkartierung
                            MUNLV/Katasterbehoerde/SO/05974000.zip</informationSystem>
                        <externalObject>
                            <name>Eisenbahn</name>
                        </externalObject>
                    </externalReference>
                    <noise:railwaySurfaceMaterial>Schotterbett-Holzschwelle</noise:railwaySurfaceMaterial>
                    <noise:railwaySurfaceCorrection uom="dB">3.123</noise:railwaySurfaceCorrection>
                    <noise:bridge>1</noise:bridge>
                    <noise:crossing>0</noise:crossing>
                    <noise:curveRadius uom="m">234.56</noise:curveRadius>
                    <noise:additionalCorrectionSegment uom="dB">-3.123</noise:additionalCorrectionSegment>
                    <noise:lod0BaseLine>
                        <gml:LineString srsName="EPSG:31466" srsDimension="3">
                            <gml:coordinates decimal="." cs="," ts=" ">2524175,5707335,188 2524181,5707338,188 2524185,5707330,188
                                2524179,5707327,188</gml:coordinates>
                        </gml:LineString>
                    </noise:lod0BaseLine>
                    <noise:usedBy>
                        <noise:Train gml:id="CTR_0815">
                            <gml:description>Musterzug von A nach B, verkehrt täglich uswusw.</gml:description>
                            <gml:name>Musterzug1</gml:name>
                            <noise:trainType>Fahrzeuge mit Radscheibenbremsen</noise:trainType>
                            <noise:trainTypeCorrection uom="dB">-2.123</noise:trainTypeCorrection>
                            <noise:brakePortionDay uom="percent">12.123</noise:brakePortionDay>
                            <noise:brakePortionEvening uom="percent">23.123</noise:brakePortionEvening>
                            <noise:brakePortionNight uom="percent">34.123</noise:brakePortionNight>
                            <noise:lengthDay uom="m">98.123</noise:lengthDay>
                            <noise:lengthEvening uom="m">87.123</noise:lengthEvening>
                            <noise:lengthNight uom="m">76.123</noise:lengthNight>
                            <noise:speedDay uom="kmph">100.123</noise:speedDay>
                            <noise:speedEvening uom="kmph">80.123</noise:speedEvening>
                            <noise:speedNight uom="kmph">50.123</noise:speedNight>
                            <noise:additionalCorrectionTrain uom="dB">-3.123</noise:additionalCorrectionTrain>
                        </noise:Train>
                    </noise:usedBy>
                </noise:NoiseRailwaySegment>
            </noise:noiseRailwaySegmentProperty>
        </tran:Railway>
    </cityObjectMember>
</CityModel>
