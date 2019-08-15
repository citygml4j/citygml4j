<?xml version="1.0" encoding="utf-8"?>
<!-- CityGML Version No. 2.0, February 2012 -->
<!-- CityGML - GML 3.1.1 application schema for 3D city models -->
<!-- International encoding standard of the Open Geospatial Consortium, see http://www.opengeospatial.org/standards/citygml -->
<!-- Jointly developed by the Special Interest Group 3D (SIG 3D) of GDI-DE, see http://www.sig3d.org               -->
<!-- For further information see: http://www.citygml.org -->
<bldg:Building xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.opengis.net/citygml/2.0"
  xmlns:xAL="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:gml="http://www.opengis.net/gml"
  xmlns:app="http://www.opengis.net/citygml/appearance/2.0"
  xmlns:dem="http://www.opengis.net/citygml/relief/2.0" xmlns:gen="http://www.opengis.net/citygml/generics/2.0"
  xmlns:bldg="http://www.opengis.net/citygml/building/2.0"
  xsi:schemaLocation="http://www.opengis.net/citygml/appearance/2.0 schemas/citygml/2.0/appearance.xsd http://www.opengis.net/citygml/generics/2.0 schemas/citygml/2.0/generics.xsd http://www.opengis.net/citygml/building/2.0 schemas/citygml/2.0/building.xsd http://www.opengis.net/citygml/relief/2.0 schemas/citygml/2.0//relief.xsd"
  gml:id="GML_7b1a5a6f-ddad-4c3d-a507-3eb9ee0a8e68">
  <gml:name>Example Building LOD2 </gml:name>
  <gml:boundedBy>
    <gml:Envelope srsDimension="3" srsName="urn:ogc:def:crs,crs:EPSG::25832,crs:EPSG::5783">
      <gml:lowerCorner>458868.0 5438343.0 112.0</gml:lowerCorner>
      <gml:upperCorner>458892.0 5438362.0 117.0</gml:upperCorner>
    </gml:Envelope>
  </gml:boundedBy>
  <creationDate>2011-11-01</creationDate>


  <externalReference>
    <informationSystem>infoSys</informationSystem>
    <externalObject>
      <name>name</name>
    </externalObject>
  </externalReference>
  <generalizesTo xlink:href="kdfhj">
    <bldg:Building gml:id="bla"> </bldg:Building>
  </generalizesTo>

<gen:genericAttributeSet name="sdf" codeSpace="asdasd">
  <gen:dateAttribute name="hallo">
    <gen:value>2019-11-11</gen:value>
  </gen:dateAttribute>
  <gen:measureAttribute name="asdf">
    <gen:value uom="sdf">12</gen:value>
  </gen:measureAttribute>
</gen:genericAttributeSet>

  <app:appearance>
    <app:Appearance></app:Appearance>
  </app:appearance>


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
          <!-- Ground Slab -->
          <gml:surfaceMember xlink:href="#GML_d3981803-d4b0-4b5b-969c-53f657594757"/>
          <!-- Wall South -->
          <gml:surfaceMember xlink:href="#GML_1d350a50-6acc-4d3c-8c28-326ca4305fd1"/>
          <!-- Wall North -->
          <gml:surfaceMember xlink:href="#GML_d3909000-2f18-4472-8886-1c127ea67df1"/>
          <!-- Wall East -->
          <gml:surfaceMember xlink:href="#GML_6286ffa9-3811-4796-a92f-3fd037c8e668"/>
          <!-- Wall West -->
          <gml:surfaceMember xlink:href="#GML_5cc4fd92-d5de-4dd8-971e-892c91da2d9f"/>
          <!-- Roof North -->
          <gml:surfaceMember xlink:href="#GML_ec6a8966-58d9-4894-8edd-9aceb91b923f"/>
          <!-- Roof South -->
          <gml:surfaceMember xlink:href="#GML_b41dc792-5da6-4cd9-8f85-247583f305e3"/>
        </gml:CompositeSurface>
      </gml:exterior>
    </gml:Solid>
  </bldg:lod2Solid>
  <bldg:boundedBy>
    <bldg:GroundSurface>
      <gml:name>Ground Slab</gml:name>
      <bldg:lod2MultiSurface>
        <gml:MultiSurface>
          <gml:surfaceMember>
            <gml:Polygon gml:id="GML_d3981803-d4b0-4b5b-969c-53f657594757">
              <gml:exterior>
                <gml:LinearRing>
                  <gml:posList>458875.0 5438350.0 112.0 458875.0 5438355.0 112.0 458885.0 5438355.0 112.0 458885.0 5438350.0 112.0 458875.0 5438350.0
                    112.0 </gml:posList>
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
      <gml:name>Wall South</gml:name>
      <bldg:lod2MultiSurface>
        <gml:MultiSurface>
          <gml:surfaceMember>
            <gml:Polygon gml:id="GML_1d350a50-6acc-4d3c-8c28-326ca4305fd1">
              <gml:exterior>
                <gml:LinearRing>
                  <gml:posList>458875.0 5438350.0 112.0 458885.0 5438350.0 112.0 458885.0 5438350.0 115.0 458875.0 5438350.0 115.0 458875.0 5438350.0
                    112.0 </gml:posList>
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
      <gml:name>Wall North</gml:name>
      <bldg:lod2MultiSurface>
        <gml:MultiSurface>
          <gml:surfaceMember>
            <gml:Polygon gml:id="GML_d3909000-2f18-4472-8886-1c127ea67df1">
              <gml:exterior>
                <gml:LinearRing>
                  <gml:posList>458885.0 5438355.0 112.0 458875.0 5438355.0 112.0 458875.0 5438355.0 115.0 458885.0 5438355.0 115.0 458885.0 5438355.0
                    112.0 </gml:posList>
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
      <gml:name>Wall East</gml:name>
      <bldg:lod2MultiSurface>
        <gml:MultiSurface>
          <gml:surfaceMember>
            <gml:Polygon gml:id="GML_6286ffa9-3811-4796-a92f-3fd037c8e668">
              <gml:exterior>
                <gml:LinearRing>
                  <gml:posList>458885.0 5438350.0 112.0 458885.0 5438355.0 112.0 458885.0 5438355.0 115.0 458885.0 5438352.5 117.0 458885.0 5438350.0
                    115.0 458885.0 5438350.0 112.0 </gml:posList>
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
      <gml:name>Wall West</gml:name>
      <bldg:lod2MultiSurface>
        <gml:MultiSurface>
          <gml:surfaceMember>
            <gml:Polygon gml:id="GML_5cc4fd92-d5de-4dd8-971e-892c91da2d9f">
              <gml:exterior>
                <gml:LinearRing>
                  <gml:posList>458875.0 5438355.0 112.0 458875.0 5438350.0 112.0 458875.0 5438350.0 115.0 458875.0 5438352.5 117.0 458875.0 5438355.0
                    115.0 458875.0 5438355.0 112.0 </gml:posList>
                </gml:LinearRing>
              </gml:exterior>
            </gml:Polygon>
          </gml:surfaceMember>
        </gml:MultiSurface>
      </bldg:lod2MultiSurface>
    </bldg:WallSurface>
  </bldg:boundedBy>
  <bldg:boundedBy>
    <bldg:RoofSurface>
      <gml:name>Roof North</gml:name>
      <bldg:lod2MultiSurface>
        <gml:MultiSurface>
          <gml:surfaceMember>
            <gml:Polygon gml:id="GML_ec6a8966-58d9-4894-8edd-9aceb91b923f">
              <gml:exterior>
                <gml:LinearRing>
                  <gml:posList>458885.0 5438355.0 115.0 458875.0 5438355.0 115.0 458875.0 5438352.5 117.0 458885.0 5438352.5 117.0 458885.0 5438355.0
                    115.0 </gml:posList>
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
      <gml:name>Roof South</gml:name>
      <bldg:lod2MultiSurface>
        <gml:MultiSurface>
          <gml:surfaceMember>
            <gml:Polygon gml:id="GML_b41dc792-5da6-4cd9-8f85-247583f305e3">
              <gml:exterior>
                <gml:LinearRing>
                  <gml:posList>458875.0 5438350.0 115.0 458885.0 5438350.0 115.0 458885.0 5438352.5 117.0 458875.0 5438352.5 117.0 458875.0 5438350.0
                    115.0 </gml:posList>
                </gml:LinearRing>
              </gml:exterior>
            </gml:Polygon>
          </gml:surfaceMember>
        </gml:MultiSurface>
      </bldg:lod2MultiSurface>
    </bldg:RoofSurface>
  </bldg:boundedBy>
  <bldg:address>
    <Address>
      <xalAddress>
        <xAL:AddressDetails>
          <xAL:Country>
            <xAL:CountryName>Germany</xAL:CountryName>
            <xAL:Locality Type="Town">
              <xAL:LocalityName>Eggenstein-Leopoldshafen</xAL:LocalityName>
              <xAL:Thoroughfare Type="Street">
                <xAL:ThoroughfareNumber>1</xAL:ThoroughfareNumber>
                <xAL:ThoroughfareName>Hermann-von-Helmholtz-Platz</xAL:ThoroughfareName>
              </xAL:Thoroughfare>
              <xAL:PostalCode>
                <xAL:PostalCodeNumber>76344</xAL:PostalCodeNumber>
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
</bldg:Building>
