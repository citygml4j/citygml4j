<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<CityModel gml:id="UUID_e71fcf70-6f2d-404c-ab5c-301415150062" xmlns:app="http://www.opengis.net/citygml/appearance/2.0" xmlns:xAL="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0" xmlns:bldg="http://www.opengis.net/citygml/building/2.0"
  xmlns:gml="http://www.opengis.net/gml" xmlns:test="http://www.citygml.org/ade/TestADE/1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.opengis.net/citygml/2.0" xmlns:xlink="http://www.w3.org/1999/xlink"
  xsi:schemaLocation="http://www.citygml.org/ade/TestADE/1.0 ../schemas/test-ade.xsd">
  <gml:name>TestADE sample dataset</gml:name>
  <gml:boundedBy>
    <gml:Envelope srsName="urn:ogc:def:crs,crs:EPSG::25832,crs:EPSG::5783" srsDimension="3">
      <gml:lowerCorner>458875.0 5438350.0 112.0</gml:lowerCorner>
      <gml:upperCorner>458887.5 5438355.0 117.0</gml:upperCorner>
    </gml:Envelope>
  </gml:boundedBy>
  <cityObjectMember>
    <bldg:Building gml:id="GML_7b1a5a6f-ddad-4c3d-a507-3eb9ee0a8e68">
      <bldg:function codeSpace="http://www.sig3d.org/codelists/standard/building/2.0/_AbstractBuilding_function.xml">1000</bldg:function>
      <bldg:yearOfConstruction>1985</bldg:yearOfConstruction>
      <bldg:roofType codeSpace="http://www.sig3d.org/codelists/standard/building/2.0/_AbstractBuilding_roofType.xml">1030</bldg:roofType>
      <bldg:measuredHeight uom="#m">5.0</bldg:measuredHeight>
      <bldg:storeysAboveGround>1</bldg:storeysAboveGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:CompositeSurface>
              <gml:surfaceMember xlink:href="#GML_d3981803-d4b0-4b5b-969c-53f657594757"/>
              <gml:surfaceMember xlink:href="#GML_1d350a50-6acc-4d3c-8c28-326ca4305fd1"/>
              <gml:surfaceMember xlink:href="#GML_d3909000-2f18-4472-8886-1c127ea67df1"/>
              <gml:surfaceMember xlink:href="#GML_6286ffa9-3811-4796-a92f-3fd037c8e668"/>
              <gml:surfaceMember xlink:href="#GML_5cc4fd92-d5de-4dd8-971e-892c91da2d9f"/>
              <gml:surfaceMember xlink:href="#GML_ec6a8966-58d9-4894-8edd-9aceb91b923f"/>
              <gml:surfaceMember xlink:href="#GML_b41dc792-5da6-4cd9-8f85-247583f305e3"/>
            </gml:CompositeSurface>
          </gml:exterior>
        </gml:Solid>
      </bldg:lod2Solid>
      <bldg:boundedBy>
        <bldg:GroundSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_d3981803-d4b0-4b5b-969c-53f657594757">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458875.0 5438350.0 112.0 458875.0 5438355.0 112.0 458885.0 5438355.0 112.0 458885.0 5438350.0 112.0 458875.0 5438350.0 112.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:GroundSurface>
      </bldg:boundedBy>
      <bldg:boundedBy>
        <bldg:WallSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_1d350a50-6acc-4d3c-8c28-326ca4305fd1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458875.0 5438350.0 112.0 458885.0 5438350.0 112.0 458885.0 5438350.0 115.0 458875.0 5438350.0 115.0 458875.0 5438350.0 112.0</gml:posList>
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
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_d3909000-2f18-4472-8886-1c127ea67df1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458885.0 5438355.0 112.0 458875.0 5438355.0 112.0 458875.0 5438355.0 115.0 458885.0 5438355.0 115.0 458885.0 5438355.0 112.0</gml:posList>
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
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_6286ffa9-3811-4796-a92f-3fd037c8e668">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458885.0 5438350.0 112.0 458885.0 5438355.0 112.0 458885.0 5438355.0 115.0 458885.0 5438352.5 117.0 458885.0 5438350.0 115.0 458885.0 5438350.0 112.0</gml:posList>
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
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_5cc4fd92-d5de-4dd8-971e-892c91da2d9f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458875.0 5438355.0 112.0 458875.0 5438350.0 112.0 458875.0 5438350.0 115.0 458875.0 5438352.5 117.0 458875.0 5438355.0 115.0 458875.0 5438355.0 112.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:WallSurface>
      </bldg:boundedBy>
      <bldg:boundedBy>
        <test:IndustrialBuildingRoofSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_ec6a8966-58d9-4894-8edd-9aceb91b923f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458885.0 5438355.0 115.0 458875.0 5438355.0 115.0 458875.0 5438352.5 117.0 458885.0 5438352.5 117.0 458885.0 5438355.0 115.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </test:IndustrialBuildingRoofSurface>
      </bldg:boundedBy>
      <bldg:boundedBy>
        <test:IndustrialBuildingRoofSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_b41dc792-5da6-4cd9-8f85-247583f305e3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458875.0 5438350.0 115.0 458885.0 5438350.0 115.0 458885.0 5438352.5 117.0 458875.0 5438352.5 117.0 458875.0 5438350.0 115.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </test:IndustrialBuildingRoofSurface>
      </bldg:boundedBy>
      <bldg:address>
        <Address>
          <xalAddress>
            <xAL:AddressDetails>
              <xAL:Country>
                <xAL:CountryName>TestCountry</xAL:CountryName>
                <xAL:Locality Type="Town">
                  <xAL:LocalityName>TestCity</xAL:LocalityName>
                  <xAL:Thoroughfare Type="Street">
                    <xAL:ThoroughfareNumber>1</xAL:ThoroughfareNumber>
                    <xAL:ThoroughfareName>TestStreet</xAL:ThoroughfareName>
                  </xAL:Thoroughfare>
                  <xAL:PostalCode>
                    <xAL:PostalCodeNumber>01234</xAL:PostalCodeNumber>
                  </xAL:PostalCode>
                </xAL:Locality>
              </xAL:Country>
            </xAL:AddressDetails>
          </xalAddress>
          <multiPoint>
            <gml:MultiPoint>
              <gml:pointMember>
                <gml:Point>
                  <gml:pos srsDimension="3">458880.0 5438352.6 112.0</gml:pos>
                </gml:Point>
              </gml:pointMember>
            </gml:MultiPoint>
          </multiPoint>
        </Address>
      </bldg:address>
      <test:energyPerformanceCertification>
        <test:EnergyPerformanceCertification>
          <test:certificationName>Test Certificate</test:certificationName>
          <test:certificationid>ID_0815</test:certificationid>
        </test:EnergyPerformanceCertification>
      </test:energyPerformanceCertification>
      <test:buildingUnit>
        <test:BuildingUnit>
          <test:lod2Solid>
            <gml:Solid>
              <gml:exterior>
                <gml:CompositeSurface>
                  <gml:surfaceMember>
                    <gml:Polygon gml:id="GML_fa89e511-39b2-46de-9a13-9f4621576a46">
                      <gml:exterior>
                        <gml:LinearRing>
                          <gml:posList>458884.8 5438354.8 112.2 458884.8 5438350.2 112.2 458875.2 5438350.2 112.2 458875.2 5438354.8 112.2 458884.8 5438354.8 112.2</gml:posList>
                        </gml:LinearRing>
                      </gml:exterior>
                    </gml:Polygon>
                  </gml:surfaceMember>
                  <gml:surfaceMember>
                    <gml:Polygon gml:id="GML_592ce9fa-0b98-4225-8d22-20eff4f86fc5">
                      <gml:exterior>
                        <gml:LinearRing>
                          <gml:posList>458875.2 5438354.8 112.2 458875.2 5438354.8 114.90387503050269 458884.8 5438354.8 114.90387503050269 458884.8 5438354.8 112.2 458875.2 5438354.8 112.2</gml:posList>
                        </gml:LinearRing>
                      </gml:exterior>
                    </gml:Polygon>
                  </gml:surfaceMember>
                  <gml:surfaceMember>
                    <gml:Polygon gml:id="GML_a9fe597d-c338-43ad-a633-2a0beb273fac">
                      <gml:exterior>
                        <gml:LinearRing>
                          <gml:posList>458875.2 5438350.2 112.2 458875.2 5438350.2 114.90387503050269 458875.2 5438352.5 116.74387503050269 458875.2 5438354.8 114.90387503050269 458875.2 5438354.8 112.2 458875.2 5438350.2 112.2</gml:posList>
                        </gml:LinearRing>
                      </gml:exterior>
                    </gml:Polygon>
                  </gml:surfaceMember>
                  <gml:surfaceMember>
                    <gml:Polygon gml:id="GML_d86e14ef-90d0-4331-b9ba-42fc869639c2">
                      <gml:exterior>
                        <gml:LinearRing>
                          <gml:posList>458884.8 5438354.8 112.2 458884.8 5438354.8 114.90387503050269 458884.8 5438352.5 116.74387503050269 458884.8 5438350.2 114.90387503050269 458884.8 5438350.2 112.2 458884.8 5438354.8 112.2</gml:posList>
                        </gml:LinearRing>
                      </gml:exterior>
                    </gml:Polygon>
                  </gml:surfaceMember>
                  <gml:surfaceMember>
                    <gml:Polygon gml:id="GML_cf0b79ba-f31f-4bae-a10f-5bcc85ce2cf6">
                      <gml:exterior>
                        <gml:LinearRing>
                          <gml:posList>458884.8 5438350.2 112.2 458884.8 5438350.2 114.90387503050269 458875.2 5438350.2 114.90387503050269 458875.2 5438350.2 112.2 458884.8 5438350.2 112.2</gml:posList>
                        </gml:LinearRing>
                      </gml:exterior>
                    </gml:Polygon>
                  </gml:surfaceMember>
                  <gml:surfaceMember>
                    <gml:Polygon gml:id="GML_989aa5cf-ee07-4fd8-89b6-500a9d5ba8041">
                      <gml:exterior>
                        <gml:LinearRing>
                          <gml:posList>458884.8 5438352.5 116.74387503050269 458875.2 5438352.5 116.74387503050269 458875.2 5438350.2 114.90387503050269 458884.8 5438350.2 114.90387503050269 458884.8 5438352.5 116.74387503050269</gml:posList>
                        </gml:LinearRing>
                      </gml:exterior>
                    </gml:Polygon>
                  </gml:surfaceMember>
                  <gml:surfaceMember>
                    <gml:Polygon gml:id="GML_98841838-ee0b-402f-ba28-64ed61cb10f8">
                      <gml:exterior>
                        <gml:LinearRing>
                          <gml:posList>458875.2 5438352.5 116.74387503050269 458884.8 5438352.5 116.74387503050269 458884.8 5438354.8 114.90387503050269 458875.2 5438354.8 114.90387503050269 458875.2 5438352.5 116.74387503050269</gml:posList>
                        </gml:LinearRing>
                      </gml:exterior>
                    </gml:Polygon>
                  </gml:surfaceMember>
                </gml:CompositeSurface>
              </gml:exterior>
            </gml:Solid>
          </test:lod2Solid>
          <test:equippedWith>
            <test:DHWFacilities>
              <test:totalValue uom="m3">24</test:totalValue>
            </test:DHWFacilities>
          </test:equippedWith>
          <test:equippedWith>
            <test:LightingFacilities>
              <test:totalValue uom="W">4000</test:totalValue>
            </test:LightingFacilities>
          </test:equippedWith>
        </test:BuildingUnit>
      </test:buildingUnit>
      <test:floorArea uom="m2">50</test:floorArea>
      <test:ownerName>Smith</test:ownerName>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <test:OtherConstruction>
      <gml:name>Shed modelled as other construction</gml:name>
      <test:boundedBy>
        <bldg:WallSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_dab75f49-f6f8-4490-b86b-450b613e1fc2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458887.5 5438355.0 114.3 458887.5 5438351.0 114.5 458887.5 5438351.0 112.0 458887.5 5438355.0 112.0 458887.5 5438355.0 114.3</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:WallSurface>
      </test:boundedBy>
      <test:boundedBy>
        <bldg:WallSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_f3f56c7b-7e59-47bc-ba03-d841032f1a37">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458885.0 5438351.0 114.5 458885.0 5438351.0 112.0 458887.5 5438351.0 112.0 458887.5 5438351.0 114.5 458885.0 5438351.0 114.5</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:WallSurface>
      </test:boundedBy>
      <test:boundedBy>
        <bldg:WallSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_9f0465e6-f316-4f89-a9bd-eb21934ffe84">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458885.0 5438355.0 112.0 458885.0 5438351.0 112.0 458885.0 5438351.0 114.5 458885.0 5438355.0 114.3 458885.0 5438355.0 112.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:WallSurface>
      </test:boundedBy>
      <test:boundedBy>
        <bldg:WallSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_5339468c-b2cb-4a99-9eb5-8b0660fb26d3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458887.5 5438355.0 112.0 458885.0 5438355.0 112.0 458885.0 5438355.0 114.3 458887.5 5438355.0 114.3 458887.5 5438355.0 112.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:WallSurface>
      </test:boundedBy>
      <test:boundedBy>
        <bldg:GroundSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_2e1ff653-b62b-41ee-9f99-d6852ae7d567">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458887.5 5438351.0 112.0 458885.0 5438351.0 112.0 458885.0 5438355.0 112.0 458887.5 5438355.0 112.0 458887.5 5438351.0 112.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:GroundSurface>
      </test:boundedBy>
      <test:boundedBy>
        <bldg:RoofSurface>
          <bldg:lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="GML_7996bef1-f045-4704-be27-db27430d4f70">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList>458885.0 5438355.0 114.3 458885.0 5438351.0 114.5 458887.5 5438351.0 114.5 458887.5 5438355.0 114.3 458885.0 5438355.0 114.3</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </bldg:lod2MultiSurface>
        </bldg:RoofSurface>
      </test:boundedBy>
    </test:OtherConstruction>
  </cityObjectMember>
</CityModel>
