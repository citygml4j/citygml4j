<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<CityModel gml:id="UUID_ab2f5e3d-1c2d-4f4a-a744-a1c3a6d81c80" xmlns:con="http://www.opengis.net/citygml/construction/3.0" xmlns:tran="http://www.opengis.net/citygml/transportation/3.0" xmlns:wtr="http://www.opengis.net/citygml/waterbody/3.0" xmlns:veg="http://www.opengis.net/citygml/vegetation/3.0" xmlns="http://www.opengis.net/citygml/3.0" xmlns:dem="http://www.opengis.net/citygml/relief/3.0" xmlns:gml="http://www.opengis.net/gml/3.2" xmlns:bldg="http://www.opengis.net/citygml/building/3.0" xmlns:ct="urn:oasis:names:tc:ciq:ct:3" xmlns:grp="http://www.opengis.net/citygml/cityobjectgroup/3.0" xmlns:dyn="http://www.opengis.net/citygml/dynamizer/3.0" xmlns:pnt="http://www.opengis.net/citygml/pointcloud/3.0" xmlns:tun="http://www.opengis.net/citygml/tunnel/3.0" xmlns:frn="http://www.opengis.net/citygml/cityfurniture/3.0" xmlns:gen="http://www.opengis.net/citygml/generics/3.0" xmlns:xAL="urn:oasis:names:tc:ciq:xal:3" xmlns:app="http://www.opengis.net/citygml/appearance/3.0" xmlns:luse="http://www.opengis.net/citygml/landuse/3.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:brid="http://www.opengis.net/citygml/bridge/3.0" xmlns:ver="http://www.opengis.net/citygml/versioning/3.0" xmlns:xlink="http://www.w3.org/1999/xlink" xsi:schemaLocation="http://www.opengis.net/citygml/construction/3.0 http://schemas.opengis.net/citygml/construction/3.0/construction.xsd http://www.opengis.net/citygml/transportation/3.0 http://schemas.opengis.net/citygml/transportation/3.0/transportation.xsd http://www.opengis.net/citygml/waterbody/3.0 http://schemas.opengis.net/citygml/waterbody/3.0/waterBody.xsd http://www.opengis.net/citygml/vegetation/3.0 http://schemas.opengis.net/citygml/vegetation/3.0/vegetation.xsd http://www.opengis.net/citygml/relief/3.0 http://schemas.opengis.net/citygml/relief/3.0/relief.xsd http://www.opengis.net/citygml/building/3.0 http://schemas.opengis.net/citygml/building/3.0/building.xsd http://www.opengis.net/citygml/cityobjectgroup/3.0 http://schemas.opengis.net/citygml/cityobjectgroup/3.0/cityObjectGroup.xsd http://www.opengis.net/citygml/dynamizer/3.0 http://schemas.opengis.net/citygml/dynamizer/3.0/dynamizer.xsd http://www.opengis.net/citygml/pointcloud/3.0 http://schemas.opengis.net/citygml/pointcloud/3.0/pointCloud.xsd http://www.opengis.net/citygml/tunnel/3.0 http://schemas.opengis.net/citygml/tunnel/3.0/tunnel.xsd http://www.opengis.net/citygml/cityfurniture/3.0 http://schemas.opengis.net/citygml/cityfurniture/3.0/cityFurniture.xsd http://www.opengis.net/citygml/generics/3.0 http://schemas.opengis.net/citygml/generics/3.0/generics.xsd http://www.opengis.net/citygml/appearance/3.0 http://schemas.opengis.net/citygml/appearance/3.0/appearance.xsd http://www.opengis.net/citygml/landuse/3.0 http://schemas.opengis.net/citygml/landuse/3.0/landUse.xsd http://www.opengis.net/citygml/bridge/3.0 http://schemas.opengis.net/citygml/bridge/3.0/bridge.xsd http://www.opengis.net/citygml/versioning/3.0 http://schemas.opengis.net/citygml/versioning/3.0/versioning.xsd">
  <gml:name>Simple CityGML test case</gml:name>
  <gml:boundedBy>
    <gml:Envelope srsName="urn:ogc:def:crs,crs:EPSG:6.12:3068,crs:EPSG:6.12:5783" srsDimension="3">
      <gml:lowerCorner srsDimension="3">0.0 0.0 0.0</gml:lowerCorner>
      <gml:upperCorner srsDimension="3">100.0 100.0 10.0</gml:upperCorner>
    </gml:Envelope>
  </gml:boundedBy>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_1F3E679D-E226-4535-926C-7390977FB25A">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_7076142D-B7D1-48B6-901B-20CDB5968DF5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4ab1a80d-0c68-47af-9c03-8ad1e98ea10e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 0.0 0.0 0.0 0.0 0.0 0.0 8.0 0.0 6.0 8.0 0.0 6.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_227D72FE-7D2C-4336-8D6C-24AFABF8A4DB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8d096cc5-3093-4f60-8430-fd1b6e838d81">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 0.0 0.0 6.0 0.0 0.0 6.0 0.0 5.0 3.0 0.0 11.0 0.0 0.0 5.0 0.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C8C2E28B-8FAC-4E56-AFA6-C403F47F4DA3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8f934f24-0a64-4546-95f0-f5296c2ba2a0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 8.0 0.0 0.0 8.0 0.0 0.0 8.0 5.0 3.0 8.0 11.0 6.0 8.0 5.0 6.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8CC57495-6C1A-4F6F-9589-06CAAFC8EAF6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3987ffdc-78df-427c-baa1-9e326a2f23af">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 0.0 0.0 0.0 0.0 5.0 0.0 8.0 5.0 0.0 8.0 0.0 0.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9959A80E-FAC6-4F18-AA8C-27B4C853164C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9afe46ef-dedf-4923-9805-de4ab4e4f297">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 8.0 0.0 6.0 8.0 5.0 6.0 0.0 5.0 6.0 0.0 0.0 6.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_8225CA5F-2613-40E5-BA61-117AFA2628B9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_954aee8a-2af0-497e-9494-66f45400aa5c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 0.0 5.0 3.0 0.0 11.0 3.0 8.0 11.0 0.0 8.0 5.0 0.0 0.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9D7AB241-5B65-47B2-A4E3-802A63213A1F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b878434d-5133-4e1a-b3c4-e83ecb7e58e9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 8.0 5.0 3.0 8.0 11.0 3.0 0.0 11.0 6.0 0.0 5.0 6.0 8.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_4ab1a80d-0c68-47af-9c03-8ad1e98ea10e"/>
              <gml:surfaceMember xlink:href="#UUID_8d096cc5-3093-4f60-8430-fd1b6e838d81"/>
              <gml:surfaceMember xlink:href="#UUID_8f934f24-0a64-4546-95f0-f5296c2ba2a0"/>
              <gml:surfaceMember xlink:href="#UUID_3987ffdc-78df-427c-baa1-9e326a2f23af"/>
              <gml:surfaceMember xlink:href="#UUID_9afe46ef-dedf-4923-9805-de4ab4e4f297"/>
              <gml:surfaceMember xlink:href="#UUID_954aee8a-2af0-497e-9494-66f45400aa5c"/>
              <gml:surfaceMember xlink:href="#UUID_b878434d-5133-4e1a-b3c4-e83ecb7e58e9"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1929-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2044-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_7C605DB2-2E94-4C2D-82CC-8B9065F7CCCA">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_D1127B2A-B7E7-482A-9AB1-6117DDE9FFE2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_830344c8-b837-40c9-9c12-95533436c756">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 0.0 0.0 10.0 0.0 0.0 10.0 8.0 0.0 16.0 8.0 0.0 16.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_85A6DD95-2BB6-4B7F-B11E-29AE6DAE4014">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_94d64c22-040f-47ea-a866-b15b71bebc2b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 0.0 0.0 16.0 0.0 0.0 16.0 0.0 7.0 13.0 0.0 11.0 10.0 0.0 7.0 10.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A018227E-273E-4078-BE3B-5E6E95605CF8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fedcbd5c-9781-4316-bcee-3d6955c1c9dc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 8.0 0.0 10.0 8.0 0.0 10.0 8.0 7.0 13.0 8.0 11.0 16.0 8.0 7.0 16.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FA67FF27-18CB-4609-8B42-8C78A496416B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_35f6098f-7781-4f7a-abcb-2618a13bbbbb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 0.0 0.0 10.0 0.0 7.0 10.0 8.0 7.0 10.0 8.0 0.0 10.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AC4B6BC3-F693-406F-8463-1A05C96EBF52">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0373cf24-4342-404a-910e-7e5055c069bd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 8.0 0.0 16.0 8.0 7.0 16.0 0.0 7.0 16.0 0.0 0.0 16.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C9FA006B-AE85-4A00-B73A-260DA4812839">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fdc67fc1-7068-4970-bc06-f0cce34ee366">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 0.0 7.0 13.0 0.0 11.0 13.0 8.0 11.0 10.0 8.0 7.0 10.0 0.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_637B2F68-6B84-480B-9CB1-50F75A496FB2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6eb14f41-51e1-4d66-9ce7-8d1607f8552b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 8.0 7.0 13.0 8.0 11.0 13.0 0.0 11.0 16.0 0.0 7.0 16.0 8.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_830344c8-b837-40c9-9c12-95533436c756"/>
              <gml:surfaceMember xlink:href="#UUID_94d64c22-040f-47ea-a866-b15b71bebc2b"/>
              <gml:surfaceMember xlink:href="#UUID_fedcbd5c-9781-4316-bcee-3d6955c1c9dc"/>
              <gml:surfaceMember xlink:href="#UUID_35f6098f-7781-4f7a-abcb-2618a13bbbbb"/>
              <gml:surfaceMember xlink:href="#UUID_0373cf24-4342-404a-910e-7e5055c069bd"/>
              <gml:surfaceMember xlink:href="#UUID_fdc67fc1-7068-4970-bc06-f0cce34ee366"/>
              <gml:surfaceMember xlink:href="#UUID_6eb14f41-51e1-4d66-9ce7-8d1607f8552b"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1905-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2053-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1130</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_56B0191A-411F-4367-A743-059FAC0BB8E1">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_F7D82F0D-13E8-4DCE-9BA8-B481068B0749">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dc7a23f1-8ce2-4b72-b4d1-ddc79381d15c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 0.0 0.0 20.0 0.0 0.0 20.0 8.0 0.0 26.0 8.0 0.0 26.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AFC19DDA-B6E8-4FCC-94D8-528D1AA13D8C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a08108e0-97ed-4938-9323-8627955c55d7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 0.0 0.0 26.0 0.0 0.0 26.0 0.0 7.0 23.0 0.0 9.0 20.0 0.0 7.0 20.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5B73EEEF-AFB6-4975-B84B-B93483EDC1AF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ca6e1458-1a68-415a-a143-2917572dd2e2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 8.0 0.0 20.0 8.0 0.0 20.0 8.0 7.0 23.0 8.0 9.0 26.0 8.0 7.0 26.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_69326D59-9D4D-46AA-ADB0-1E56ECCECC73">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1856ebfa-2831-4f99-a926-80291bb6a0ea">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 0.0 0.0 20.0 0.0 7.0 20.0 8.0 7.0 20.0 8.0 0.0 20.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EC386BBB-62CC-4BC0-9E56-3467BCC9FB86">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_93eb6bf7-be90-4f20-acdc-93f762d7998f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 8.0 0.0 26.0 8.0 7.0 26.0 0.0 7.0 26.0 0.0 0.0 26.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_4D834F22-4E18-43DB-8076-279498006986">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_74faf592-5a72-4955-8d51-6481bf0eb3bb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 0.0 7.0 23.0 0.0 9.0 23.0 8.0 9.0 20.0 8.0 7.0 20.0 0.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_6ECFE9E9-AAAA-4BF9-9AB4-02F913EEDD5A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_49c460a8-0220-4a3f-9092-4ff6a74d0f7e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 8.0 7.0 23.0 8.0 9.0 23.0 0.0 9.0 26.0 0.0 7.0 26.0 8.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_dc7a23f1-8ce2-4b72-b4d1-ddc79381d15c"/>
              <gml:surfaceMember xlink:href="#UUID_a08108e0-97ed-4938-9323-8627955c55d7"/>
              <gml:surfaceMember xlink:href="#UUID_ca6e1458-1a68-415a-a143-2917572dd2e2"/>
              <gml:surfaceMember xlink:href="#UUID_1856ebfa-2831-4f99-a926-80291bb6a0ea"/>
              <gml:surfaceMember xlink:href="#UUID_93eb6bf7-be90-4f20-acdc-93f762d7998f"/>
              <gml:surfaceMember xlink:href="#UUID_74faf592-5a72-4955-8d51-6481bf0eb3bb"/>
              <gml:surfaceMember xlink:href="#UUID_49c460a8-0220-4a3f-9092-4ff6a74d0f7e"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1906-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2096-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1160</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_1E831EA2-F336-4D27-92E0-593D0D9D71D8">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_63A69E16-B1E4-4732-89C3-B17E2987A631">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e9fee2f9-3e21-4063-a10b-b9466badb17e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 0.0 0.0 30.0 0.0 0.0 30.0 8.0 0.0 36.0 8.0 0.0 36.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A1583CB2-03B2-4B88-BF54-957494EDF9F3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_00dec390-f3fd-4776-910b-9805c1f0581a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 0.0 0.0 36.0 0.0 0.0 36.0 0.0 3.0 33.0 0.0 11.0 30.0 0.0 3.0 30.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_300A6EF8-156E-4538-9A89-E7BE5C3170EA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_266982d7-7ae7-4f83-8427-7894280de0be">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 8.0 0.0 30.0 8.0 0.0 30.0 8.0 3.0 33.0 8.0 11.0 36.0 8.0 3.0 36.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6FA600BD-3DEE-4A04-B28A-C51528EE63AE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6af95c15-7705-4fdd-8b3d-1efba373111e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 0.0 0.0 30.0 0.0 3.0 30.0 8.0 3.0 30.0 8.0 0.0 30.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CE1F4E44-D5A9-4325-87FB-B2B381A81822">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9d94ec39-c8c4-4e46-b19d-6db52ee77ab2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 8.0 0.0 36.0 8.0 3.0 36.0 0.0 3.0 36.0 0.0 0.0 36.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_0A9AC6C7-496A-4B07-9D43-9DEB27655A5A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_43d6a7a8-5a9f-4393-b4c5-c89d421a6135">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 0.0 3.0 33.0 0.0 11.0 33.0 8.0 11.0 30.0 8.0 3.0 30.0 0.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_FB3F2FBE-468B-4D63-991A-0FCB8A7FF9DE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_204b1304-b858-45a1-a787-cd3df6c78192">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 8.0 3.0 33.0 8.0 11.0 33.0 0.0 11.0 36.0 0.0 3.0 36.0 8.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_e9fee2f9-3e21-4063-a10b-b9466badb17e"/>
              <gml:surfaceMember xlink:href="#UUID_00dec390-f3fd-4776-910b-9805c1f0581a"/>
              <gml:surfaceMember xlink:href="#UUID_266982d7-7ae7-4f83-8427-7894280de0be"/>
              <gml:surfaceMember xlink:href="#UUID_6af95c15-7705-4fdd-8b3d-1efba373111e"/>
              <gml:surfaceMember xlink:href="#UUID_9d94ec39-c8c4-4e46-b19d-6db52ee77ab2"/>
              <gml:surfaceMember xlink:href="#UUID_43d6a7a8-5a9f-4393-b4c5-c89d421a6135"/>
              <gml:surfaceMember xlink:href="#UUID_204b1304-b858-45a1-a787-cd3df6c78192"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1947-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2044-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1110</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_059E77E8-A50B-45DF-A5D5-7F09D32C09E1">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1E6BFAB6-0292-4013-BE90-A5FC4D35F062">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6d243179-7e62-49a0-9b4a-20c73a5ab439">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 0.0 0.0 40.0 0.0 0.0 40.0 8.0 0.0 46.0 8.0 0.0 46.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A8A052B1-551D-4785-B417-37645B509C0F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cacde0eb-9d61-463a-9a09-8a05738bd4a5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 0.0 0.0 46.0 0.0 0.0 46.0 0.0 4.0 43.0 0.0 9.0 40.0 0.0 4.0 40.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2E6F861D-7E00-44D5-944F-719421E68046">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cf2aacc4-5f58-4832-bdbf-df7e04339ff3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 8.0 0.0 40.0 8.0 0.0 40.0 8.0 4.0 43.0 8.0 9.0 46.0 8.0 4.0 46.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_199E49A8-0958-4FD8-913F-C63C343B01D1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3743f150-058a-4e9e-bf1b-1497a8615c79">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 0.0 0.0 40.0 0.0 4.0 40.0 8.0 4.0 40.0 8.0 0.0 40.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_459DE3E8-D100-4F2F-8441-A894A98E6370">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2231e4f9-907f-4782-baae-0863808248ea">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 8.0 0.0 46.0 8.0 4.0 46.0 0.0 4.0 46.0 0.0 0.0 46.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B1D569F7-1B6F-444B-AA9B-ACCB82B9106E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1fb31593-ccda-4fc2-a366-542dac96d7e6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 0.0 4.0 43.0 0.0 9.0 43.0 8.0 9.0 40.0 8.0 4.0 40.0 0.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_7E1FE9D0-2B81-4E04-90D6-F3D8FAA7DE14">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_19f6432f-2962-4c15-8ac6-fab2784df16b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 8.0 4.0 43.0 8.0 9.0 43.0 0.0 9.0 46.0 0.0 4.0 46.0 8.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_6d243179-7e62-49a0-9b4a-20c73a5ab439"/>
              <gml:surfaceMember xlink:href="#UUID_cacde0eb-9d61-463a-9a09-8a05738bd4a5"/>
              <gml:surfaceMember xlink:href="#UUID_cf2aacc4-5f58-4832-bdbf-df7e04339ff3"/>
              <gml:surfaceMember xlink:href="#UUID_3743f150-058a-4e9e-bf1b-1497a8615c79"/>
              <gml:surfaceMember xlink:href="#UUID_2231e4f9-907f-4782-baae-0863808248ea"/>
              <gml:surfaceMember xlink:href="#UUID_1fb31593-ccda-4fc2-a366-542dac96d7e6"/>
              <gml:surfaceMember xlink:href="#UUID_19f6432f-2962-4c15-8ac6-fab2784df16b"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1982-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2067-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1150</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_42F189C9-6272-4E93-9A82-89C22A354602">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_8990E696-DFA7-4A26-ADE8-BD9CD8CAC957">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9bdb7205-8eb9-42ad-8778-83fed00d9bb2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 0.0 0.0 50.0 0.0 0.0 50.0 8.0 0.0 56.0 8.0 0.0 56.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7725EAEB-6482-430F-B137-8435FAC5D60D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_97e45453-df6d-407a-bf16-497b8042e4e3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 0.0 0.0 56.0 0.0 0.0 56.0 0.0 6.0 53.0 0.0 9.0 50.0 0.0 6.0 50.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AD3F73E3-558C-4A89-88C5-9CE57D8B8F11">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_193a81fb-7dc7-4e33-8406-bc220b478d10">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 8.0 0.0 50.0 8.0 0.0 50.0 8.0 6.0 53.0 8.0 9.0 56.0 8.0 6.0 56.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2C8A2909-A238-47B9-AB48-7B2EF6BF2B90">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1ae58e2b-3529-4325-8b9c-a51258bbdcd5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 0.0 0.0 50.0 0.0 6.0 50.0 8.0 6.0 50.0 8.0 0.0 50.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FE3DC57C-1960-48FF-933C-A48E1E9A5AE6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1058a6fb-cbf9-4220-93ad-b23dd87d80ef">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 8.0 0.0 56.0 8.0 6.0 56.0 0.0 6.0 56.0 0.0 0.0 56.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_62CE9E76-371B-4007-B40C-2DE45D106789">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f34781f0-2712-4b1f-9973-4a7a8ea69f33">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 0.0 6.0 53.0 0.0 9.0 53.0 8.0 9.0 50.0 8.0 6.0 50.0 0.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F540317B-12BA-4E06-9470-663375F83E8E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fcf350b2-16c5-4b30-8342-7e718b88b448">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 8.0 6.0 53.0 8.0 9.0 53.0 0.0 9.0 56.0 0.0 6.0 56.0 8.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_9bdb7205-8eb9-42ad-8778-83fed00d9bb2"/>
              <gml:surfaceMember xlink:href="#UUID_97e45453-df6d-407a-bf16-497b8042e4e3"/>
              <gml:surfaceMember xlink:href="#UUID_193a81fb-7dc7-4e33-8406-bc220b478d10"/>
              <gml:surfaceMember xlink:href="#UUID_1ae58e2b-3529-4325-8b9c-a51258bbdcd5"/>
              <gml:surfaceMember xlink:href="#UUID_1058a6fb-cbf9-4220-93ad-b23dd87d80ef"/>
              <gml:surfaceMember xlink:href="#UUID_f34781f0-2712-4b1f-9973-4a7a8ea69f33"/>
              <gml:surfaceMember xlink:href="#UUID_fcf350b2-16c5-4b30-8342-7e718b88b448"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1924-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2063-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1180</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_1F989DA8-A234-4D78-B403-3D82AE473984">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_3E2D2A4E-EA28-4740-A379-CF2FC515B7EB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f05a7b68-23fd-4f73-9796-bb6141be4b55">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 0.0 0.0 60.0 0.0 0.0 60.0 8.0 0.0 66.0 8.0 0.0 66.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_20527D1D-3746-49C8-88D2-926A6974EEE7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_af370b9f-84d0-4c49-8728-839945e92350">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 0.0 0.0 66.0 0.0 0.0 66.0 0.0 3.0 63.0 0.0 11.0 60.0 0.0 3.0 60.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_33C7E789-9DCE-4D91-8597-A79D9A1F69E1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8eeca8a0-87b5-4ae6-b1a7-0752fa56f61f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 8.0 0.0 60.0 8.0 0.0 60.0 8.0 3.0 63.0 8.0 11.0 66.0 8.0 3.0 66.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_47581DA5-6142-485C-88DA-821C069DA7F2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2e873fc6-35e8-4cdb-82cf-db9419a2eee1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 0.0 0.0 60.0 0.0 3.0 60.0 8.0 3.0 60.0 8.0 0.0 60.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FE0E34E7-8C27-4224-8695-51BE014C7C48">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5d5d7eac-889e-4824-8773-d95ec37c1217">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 8.0 0.0 66.0 8.0 3.0 66.0 0.0 3.0 66.0 0.0 0.0 66.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5CE42DCB-A49D-4887-968B-D5B23CB5B60C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f59588a0-a866-408e-b4f1-4876f021b658">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 0.0 3.0 63.0 0.0 11.0 63.0 8.0 11.0 60.0 8.0 3.0 60.0 0.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_7AB65419-BB87-442B-8BE3-7F911807B410">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e6954398-f729-4b56-bb97-39df95224fcd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 8.0 3.0 63.0 8.0 11.0 63.0 0.0 11.0 66.0 0.0 3.0 66.0 8.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_f05a7b68-23fd-4f73-9796-bb6141be4b55"/>
              <gml:surfaceMember xlink:href="#UUID_af370b9f-84d0-4c49-8728-839945e92350"/>
              <gml:surfaceMember xlink:href="#UUID_8eeca8a0-87b5-4ae6-b1a7-0752fa56f61f"/>
              <gml:surfaceMember xlink:href="#UUID_2e873fc6-35e8-4cdb-82cf-db9419a2eee1"/>
              <gml:surfaceMember xlink:href="#UUID_5d5d7eac-889e-4824-8773-d95ec37c1217"/>
              <gml:surfaceMember xlink:href="#UUID_f59588a0-a866-408e-b4f1-4876f021b658"/>
              <gml:surfaceMember xlink:href="#UUID_e6954398-f729-4b56-bb97-39df95224fcd"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1910-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2028-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_D1598D54-4C5E-44BD-9D64-5F80CFF78666">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1B51CFEE-CF24-45B8-BB3F-8A9EECEBA016">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e4c86f73-99cd-4bc0-beea-8d76575fdf6f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 0.0 0.0 70.0 0.0 0.0 70.0 8.0 0.0 76.0 8.0 0.0 76.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0FD127DA-F062-42D8-9905-B5BF7FADA617">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b8b0137b-e532-4363-98b8-a8be4f1b5474">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 0.0 0.0 76.0 0.0 0.0 76.0 0.0 4.0 73.0 0.0 8.0 70.0 0.0 4.0 70.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_226FD408-7262-415F-BA21-725843150951">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b58e79b4-3b35-48c5-91d4-51fa732ad6e4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 8.0 0.0 70.0 8.0 0.0 70.0 8.0 4.0 73.0 8.0 8.0 76.0 8.0 4.0 76.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_27D1995D-1BFB-4502-8BB3-EDC689FC225B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8a3d98c4-879b-429f-9bd0-61ff5281a740">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 0.0 0.0 70.0 0.0 4.0 70.0 8.0 4.0 70.0 8.0 0.0 70.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_67170B23-4BC4-4750-8828-395E17AE64F9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_692a2c0b-f221-46c9-9ebd-d22487bbf281">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 8.0 0.0 76.0 8.0 4.0 76.0 0.0 4.0 76.0 0.0 0.0 76.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A17A5577-6AD2-47E5-8C49-B8F6AB98FA48">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e3ebfc08-d3b4-4580-8e96-a8dc3d3b4dbd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 0.0 4.0 73.0 0.0 8.0 73.0 8.0 8.0 70.0 8.0 4.0 70.0 0.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C3A1F70E-60E9-4D4F-BA4B-4A9C378D3E5B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a6932e07-32da-47d1-9f38-f131a8f52c47">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 8.0 4.0 73.0 8.0 8.0 73.0 0.0 8.0 76.0 0.0 4.0 76.0 8.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_e4c86f73-99cd-4bc0-beea-8d76575fdf6f"/>
              <gml:surfaceMember xlink:href="#UUID_b8b0137b-e532-4363-98b8-a8be4f1b5474"/>
              <gml:surfaceMember xlink:href="#UUID_b58e79b4-3b35-48c5-91d4-51fa732ad6e4"/>
              <gml:surfaceMember xlink:href="#UUID_8a3d98c4-879b-429f-9bd0-61ff5281a740"/>
              <gml:surfaceMember xlink:href="#UUID_692a2c0b-f221-46c9-9ebd-d22487bbf281"/>
              <gml:surfaceMember xlink:href="#UUID_e3ebfc08-d3b4-4580-8e96-a8dc3d3b4dbd"/>
              <gml:surfaceMember xlink:href="#UUID_a6932e07-32da-47d1-9f38-f131a8f52c47"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1930-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2096-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_E5657F8A-6B1E-4A35-9656-E844234B4F82">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_7328D60F-7D1F-40C9-9277-50534C6CFFB4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_96672b4e-fb78-45ad-8777-7510e2c326a6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 0.0 0.0 80.0 0.0 0.0 80.0 8.0 0.0 86.0 8.0 0.0 86.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0CD657E5-9C00-49D1-8CB4-5CDAAA137036">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a523a09d-edd9-4503-9e1c-8dad8d2a7d87">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 0.0 0.0 86.0 0.0 0.0 86.0 0.0 3.0 83.0 0.0 9.0 80.0 0.0 3.0 80.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AAC4B6F9-244D-4479-A00C-715D1AED75B9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c53e5240-41dd-488d-83a2-77c4747dde37">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 8.0 0.0 80.0 8.0 0.0 80.0 8.0 3.0 83.0 8.0 9.0 86.0 8.0 3.0 86.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E783D3B7-A324-47CF-AB8C-687EA0F67A80">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_31f1a0bb-ffe3-419e-889b-9c96b06a2eb1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 0.0 0.0 80.0 0.0 3.0 80.0 8.0 3.0 80.0 8.0 0.0 80.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4A859117-1349-41A9-A561-8A156A9591B8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6c0c566a-aa78-441c-83a1-b9d91f24a598">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 8.0 0.0 86.0 8.0 3.0 86.0 0.0 3.0 86.0 0.0 0.0 86.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9673ADA8-4BF1-460E-9D8B-3F4881D0E388">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_19c3504e-c00c-4217-933f-92bbd61c118d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 0.0 3.0 83.0 0.0 9.0 83.0 8.0 9.0 80.0 8.0 3.0 80.0 0.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_BFA323C2-B8C2-4D85-802B-53DCCF50A331">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4b4f808c-e440-4dff-a3a9-827fc9204075">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 8.0 3.0 83.0 8.0 9.0 83.0 0.0 9.0 86.0 0.0 3.0 86.0 8.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_96672b4e-fb78-45ad-8777-7510e2c326a6"/>
              <gml:surfaceMember xlink:href="#UUID_a523a09d-edd9-4503-9e1c-8dad8d2a7d87"/>
              <gml:surfaceMember xlink:href="#UUID_c53e5240-41dd-488d-83a2-77c4747dde37"/>
              <gml:surfaceMember xlink:href="#UUID_31f1a0bb-ffe3-419e-889b-9c96b06a2eb1"/>
              <gml:surfaceMember xlink:href="#UUID_6c0c566a-aa78-441c-83a1-b9d91f24a598"/>
              <gml:surfaceMember xlink:href="#UUID_19c3504e-c00c-4217-933f-92bbd61c118d"/>
              <gml:surfaceMember xlink:href="#UUID_4b4f808c-e440-4dff-a3a9-827fc9204075"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1965-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2053-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1030</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_ECB905FD-3514-4CEE-AFF2-A22E5A4AB3EF">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-0-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_D4C89A5A-9A5A-4462-BDE7-B3B576804255">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e686e61f-a8da-4564-b38f-1e641e8aee7e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 0.0 0.0 90.0 0.0 0.0 90.0 8.0 0.0 96.0 8.0 0.0 96.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_964EDD1F-D70B-47E8-8E37-D1F51F72DD15">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f9511779-662b-4be7-8a76-d0232c097d6b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 0.0 0.0 96.0 0.0 0.0 96.0 0.0 6.0 93.0 0.0 9.0 90.0 0.0 6.0 90.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DF49F54D-292E-491E-83DF-B272BDB8BB48">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_116d890d-fe60-42c6-859e-ea6c029bcbdf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 8.0 0.0 90.0 8.0 0.0 90.0 8.0 6.0 93.0 8.0 9.0 96.0 8.0 6.0 96.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_749A9CFF-0582-434C-A739-9AAD417CC434">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2d37e339-47e2-4806-bdab-07d606c35e33">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 0.0 0.0 90.0 0.0 6.0 90.0 8.0 6.0 90.0 8.0 0.0 90.0 0.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D33796EF-F6B6-456D-A79D-897A72C20577">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0442ba87-c114-4531-8638-ca1e5c2ad859">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 8.0 0.0 96.0 8.0 6.0 96.0 0.0 6.0 96.0 0.0 0.0 96.0 8.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C3C02E91-66DC-4D44-975F-C15F2F7C2413">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fa6ba92d-0b05-4447-a94b-6b1c9b0d2c40">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 0.0 6.0 93.0 0.0 9.0 93.0 8.0 9.0 90.0 8.0 6.0 90.0 0.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_81823C4E-BE33-47B5-98F9-5913C8E432C7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b80ec656-1d0e-4d54-b83b-43e1601ff5f9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 8.0 6.0 93.0 8.0 9.0 93.0 0.0 9.0 96.0 0.0 6.0 96.0 8.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_e686e61f-a8da-4564-b38f-1e641e8aee7e"/>
              <gml:surfaceMember xlink:href="#UUID_f9511779-662b-4be7-8a76-d0232c097d6b"/>
              <gml:surfaceMember xlink:href="#UUID_116d890d-fe60-42c6-859e-ea6c029bcbdf"/>
              <gml:surfaceMember xlink:href="#UUID_2d37e339-47e2-4806-bdab-07d606c35e33"/>
              <gml:surfaceMember xlink:href="#UUID_0442ba87-c114-4531-8638-ca1e5c2ad859"/>
              <gml:surfaceMember xlink:href="#UUID_fa6ba92d-0b05-4447-a94b-6b1c9b0d2c40"/>
              <gml:surfaceMember xlink:href="#UUID_b80ec656-1d0e-4d54-b83b-43e1601ff5f9"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1919-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2067-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1040</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_8BB5D194-E2A1-400E-AB3D-DF399F33CDB0">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_2F0F980A-7BCA-4CF6-A3D4-846A6B0156FE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_716ff98a-342c-4e92-af48-ab3a599aff8a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 10.0 0.0 0.0 10.0 0.0 0.0 18.0 0.0 6.0 18.0 0.0 6.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0B518765-9D87-443B-9983-ACBAF359F73B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3325d56d-9d2e-4775-8bc4-b2d0df28f64c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 10.0 0.0 6.0 10.0 0.0 6.0 10.0 4.0 3.0 10.0 12.0 0.0 10.0 4.0 0.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_034E8DA9-729F-47FF-BBDA-7ECDC067EA0F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e6cc62c5-bf82-49c5-9db5-c938e1dff132">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 18.0 0.0 0.0 18.0 0.0 0.0 18.0 4.0 3.0 18.0 12.0 6.0 18.0 4.0 6.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B8E7BBDF-C6BE-4CE3-A39E-5A4395CC3FED">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fd811525-19ef-45e9-b6a4-bffddb9267fe">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 10.0 0.0 0.0 10.0 4.0 0.0 18.0 4.0 0.0 18.0 0.0 0.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5EA7C09B-0AFE-4356-9962-2DB2375F86BD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fb92a28f-0210-47aa-9749-bf4777c4ee51">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 18.0 0.0 6.0 18.0 4.0 6.0 10.0 4.0 6.0 10.0 0.0 6.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_7903B709-85FA-4A9F-ABED-D765C4E51E2E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_512214fb-6542-4f10-a6ca-6289ce5c8e2e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 10.0 4.0 3.0 10.0 12.0 3.0 18.0 12.0 0.0 18.0 4.0 0.0 10.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_FC35F323-2C95-43C4-B968-E695A79F128D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ee3967f6-9e14-4da3-9a2f-77f21ee66df1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 18.0 4.0 3.0 18.0 12.0 3.0 10.0 12.0 6.0 10.0 4.0 6.0 18.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_716ff98a-342c-4e92-af48-ab3a599aff8a"/>
              <gml:surfaceMember xlink:href="#UUID_3325d56d-9d2e-4775-8bc4-b2d0df28f64c"/>
              <gml:surfaceMember xlink:href="#UUID_e6cc62c5-bf82-49c5-9db5-c938e1dff132"/>
              <gml:surfaceMember xlink:href="#UUID_fd811525-19ef-45e9-b6a4-bffddb9267fe"/>
              <gml:surfaceMember xlink:href="#UUID_fb92a28f-0210-47aa-9749-bf4777c4ee51"/>
              <gml:surfaceMember xlink:href="#UUID_512214fb-6542-4f10-a6ca-6289ce5c8e2e"/>
              <gml:surfaceMember xlink:href="#UUID_ee3967f6-9e14-4da3-9a2f-77f21ee66df1"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1938-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2043-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1140</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_37086C85-FD8A-40AE-9E00-F6BD3E5FDC0F">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_851A904F-A5DF-4E55-803A-060259CF0251">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6d1db811-1688-4471-8af6-fef84748cf78">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 10.0 0.0 10.0 10.0 0.0 10.0 18.0 0.0 16.0 18.0 0.0 16.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_1E1DB274-5CAE-46E4-82A8-575EF383254F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ecedb25c-68c9-492e-84f5-05380c6b3daf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 10.0 0.0 16.0 10.0 0.0 16.0 10.0 5.0 13.0 10.0 11.0 10.0 10.0 5.0 10.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CAF90491-2035-418A-AEAC-F8633224EDD5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3e16fbbe-1a65-421e-869c-95b555558247">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 18.0 0.0 10.0 18.0 0.0 10.0 18.0 5.0 13.0 18.0 11.0 16.0 18.0 5.0 16.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DF104ABF-C5FA-4B80-A431-175E0D1CCF07">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9fa7b9f8-aac9-4d2b-a24b-fd3d36bdb9da">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 10.0 0.0 10.0 10.0 5.0 10.0 18.0 5.0 10.0 18.0 0.0 10.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6C36AB13-7886-47E1-BE7D-B881496F016C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cc9595b3-0785-4ce0-b549-a261414bda76">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 18.0 0.0 16.0 18.0 5.0 16.0 10.0 5.0 16.0 10.0 0.0 16.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_91BBCD23-BDBD-4C20-801B-62D91B48693F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_68b8192f-e9ec-4f2c-b241-e8e541972c44">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 10.0 5.0 13.0 10.0 11.0 13.0 18.0 11.0 10.0 18.0 5.0 10.0 10.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_D818B04E-F45B-4EEA-ACCA-D0D3495A89DC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_53e832d0-177a-4093-9cad-9d0725fb9ec2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 18.0 5.0 13.0 18.0 11.0 13.0 10.0 11.0 16.0 10.0 5.0 16.0 18.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_6d1db811-1688-4471-8af6-fef84748cf78"/>
              <gml:surfaceMember xlink:href="#UUID_ecedb25c-68c9-492e-84f5-05380c6b3daf"/>
              <gml:surfaceMember xlink:href="#UUID_3e16fbbe-1a65-421e-869c-95b555558247"/>
              <gml:surfaceMember xlink:href="#UUID_9fa7b9f8-aac9-4d2b-a24b-fd3d36bdb9da"/>
              <gml:surfaceMember xlink:href="#UUID_cc9595b3-0785-4ce0-b549-a261414bda76"/>
              <gml:surfaceMember xlink:href="#UUID_68b8192f-e9ec-4f2c-b241-e8e541972c44"/>
              <gml:surfaceMember xlink:href="#UUID_53e832d0-177a-4093-9cad-9d0725fb9ec2"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1956-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2076-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1020</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_E2811057-3FC4-4B28-B530-B0A5C1CB5C67">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_F5532C9C-D354-4CEA-A82F-34BA2DB94B6C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3b28e360-7761-42dd-9ee1-aa61b7eff194">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 10.0 0.0 20.0 10.0 0.0 20.0 18.0 0.0 26.0 18.0 0.0 26.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_784F5AE2-9F3C-45DD-8A6C-04C81F8DE59A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1b58c112-25fe-4c1a-881e-fc9e789716ae">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 10.0 0.0 26.0 10.0 0.0 26.0 10.0 5.0 23.0 10.0 8.0 20.0 10.0 5.0 20.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9848BC77-2A1D-4759-B8C3-0E17C62B0951">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2b9c5e52-00ab-4aff-bbb7-e6743aaa4ef6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 18.0 0.0 20.0 18.0 0.0 20.0 18.0 5.0 23.0 18.0 8.0 26.0 18.0 5.0 26.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2E0E49AB-3A87-4544-B48A-A2CC4DD92B53">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3e5988e4-3fb2-40d2-a81a-d69e50cbdec0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 10.0 0.0 20.0 10.0 5.0 20.0 18.0 5.0 20.0 18.0 0.0 20.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A38B194D-5699-4A09-8104-7D5CC7D5D3BC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_24693b71-2556-4684-9fb2-7c72df953353">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 18.0 0.0 26.0 18.0 5.0 26.0 10.0 5.0 26.0 10.0 0.0 26.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2B341558-5E51-4FBE-8D18-B7F8CECB5476">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7edd97c5-29dd-403b-bd9b-f8e07fc40417">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 10.0 5.0 23.0 10.0 8.0 23.0 18.0 8.0 20.0 18.0 5.0 20.0 10.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_E8ECDCB1-31E6-44F0-B105-700822FA16B2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9512d73c-aebc-4aa0-8863-885ab2eb58f2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 18.0 5.0 23.0 18.0 8.0 23.0 10.0 8.0 26.0 10.0 5.0 26.0 18.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_3b28e360-7761-42dd-9ee1-aa61b7eff194"/>
              <gml:surfaceMember xlink:href="#UUID_1b58c112-25fe-4c1a-881e-fc9e789716ae"/>
              <gml:surfaceMember xlink:href="#UUID_2b9c5e52-00ab-4aff-bbb7-e6743aaa4ef6"/>
              <gml:surfaceMember xlink:href="#UUID_3e5988e4-3fb2-40d2-a81a-d69e50cbdec0"/>
              <gml:surfaceMember xlink:href="#UUID_24693b71-2556-4684-9fb2-7c72df953353"/>
              <gml:surfaceMember xlink:href="#UUID_7edd97c5-29dd-403b-bd9b-f8e07fc40417"/>
              <gml:surfaceMember xlink:href="#UUID_9512d73c-aebc-4aa0-8863-885ab2eb58f2"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1943-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2074-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1160</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_5C104766-179B-4013-9C16-2602CBE74499">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_03766F29-9D57-4AEA-9C29-5C1CFBC5397F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c89e61e4-899f-442b-b977-d128fb25168f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 10.0 0.0 30.0 10.0 0.0 30.0 18.0 0.0 36.0 18.0 0.0 36.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A96D5516-0638-4663-8610-E4B850610C6A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_aa51977d-855c-46a5-8f0d-a1ca6cff1a74">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 10.0 0.0 36.0 10.0 0.0 36.0 10.0 4.0 33.0 10.0 10.0 30.0 10.0 4.0 30.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A3F9E608-9A71-42AD-B1BF-628DCCA5D393">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_983780fc-30cf-4798-a8b0-dd15ee36db0d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 18.0 0.0 30.0 18.0 0.0 30.0 18.0 4.0 33.0 18.0 10.0 36.0 18.0 4.0 36.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_08C241AE-2029-4451-85DF-AE026DB2F40C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cad24e75-233c-4278-ac2f-81f298bdfee8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 10.0 0.0 30.0 10.0 4.0 30.0 18.0 4.0 30.0 18.0 0.0 30.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6478F422-D0BA-484F-A929-32E9986DCA03">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f3416bad-7604-47f0-a7af-eed96b9f67fe">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 18.0 0.0 36.0 18.0 4.0 36.0 10.0 4.0 36.0 10.0 0.0 36.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5F5BBA45-7A18-46EC-A8A2-02DF0079D0B9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_42f2bbff-98b0-4e9d-b155-b087f75dbf72">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 10.0 4.0 33.0 10.0 10.0 33.0 18.0 10.0 30.0 18.0 4.0 30.0 10.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_94591BC1-A865-477B-83C4-CCE6B2373FE0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_92171085-7c93-4ab2-bb2c-74278da657b9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 18.0 4.0 33.0 18.0 10.0 33.0 10.0 10.0 36.0 10.0 4.0 36.0 18.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_c89e61e4-899f-442b-b977-d128fb25168f"/>
              <gml:surfaceMember xlink:href="#UUID_aa51977d-855c-46a5-8f0d-a1ca6cff1a74"/>
              <gml:surfaceMember xlink:href="#UUID_983780fc-30cf-4798-a8b0-dd15ee36db0d"/>
              <gml:surfaceMember xlink:href="#UUID_cad24e75-233c-4278-ac2f-81f298bdfee8"/>
              <gml:surfaceMember xlink:href="#UUID_f3416bad-7604-47f0-a7af-eed96b9f67fe"/>
              <gml:surfaceMember xlink:href="#UUID_42f2bbff-98b0-4e9d-b155-b087f75dbf72"/>
              <gml:surfaceMember xlink:href="#UUID_92171085-7c93-4ab2-bb2c-74278da657b9"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1927-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2024-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_FCFA7DFE-5BA5-4734-85FB-E5C707166B9E">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_6377DE32-4D5D-4EDE-94BD-B89F93558B80">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ccbf1187-3b32-4e0d-bc1a-a1c91ae1ded9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 10.0 0.0 40.0 10.0 0.0 40.0 18.0 0.0 46.0 18.0 0.0 46.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_27B08315-6BC1-42C8-9A6E-C9C87BFBD125">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_72d70b22-3e33-4b97-a647-91876dad65d4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 10.0 0.0 46.0 10.0 0.0 46.0 10.0 4.0 43.0 10.0 8.0 40.0 10.0 4.0 40.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0F95709E-1731-47B3-B07E-36B82848217E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_27eb1c6f-c318-4cf0-9a39-8a896a9072e2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 18.0 0.0 40.0 18.0 0.0 40.0 18.0 4.0 43.0 18.0 8.0 46.0 18.0 4.0 46.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_42B0A3A2-A6F9-498A-9635-03B2A154A70E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d4b52b7a-b2e7-4d85-a24a-9dbcfccf1e0d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 10.0 0.0 40.0 10.0 4.0 40.0 18.0 4.0 40.0 18.0 0.0 40.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B19F5B54-9C39-4FB4-86B8-71848686DC03">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f5a63368-f028-4b5c-ba3a-f17b0c5a9e4b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 18.0 0.0 46.0 18.0 4.0 46.0 10.0 4.0 46.0 10.0 0.0 46.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B2FDC90F-D5AA-4F09-A1C2-BC6FD110C6DA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8d67e71d-b615-445b-aa53-f3b4a77a88bd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 10.0 4.0 43.0 10.0 8.0 43.0 18.0 8.0 40.0 18.0 4.0 40.0 10.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_7E13764D-76AA-419F-96A8-A09871FF7EDE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_55053189-bc84-4083-af76-f571fbebefda">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 18.0 4.0 43.0 18.0 8.0 43.0 10.0 8.0 46.0 10.0 4.0 46.0 18.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_ccbf1187-3b32-4e0d-bc1a-a1c91ae1ded9"/>
              <gml:surfaceMember xlink:href="#UUID_72d70b22-3e33-4b97-a647-91876dad65d4"/>
              <gml:surfaceMember xlink:href="#UUID_27eb1c6f-c318-4cf0-9a39-8a896a9072e2"/>
              <gml:surfaceMember xlink:href="#UUID_d4b52b7a-b2e7-4d85-a24a-9dbcfccf1e0d"/>
              <gml:surfaceMember xlink:href="#UUID_f5a63368-f028-4b5c-ba3a-f17b0c5a9e4b"/>
              <gml:surfaceMember xlink:href="#UUID_8d67e71d-b615-445b-aa53-f3b4a77a88bd"/>
              <gml:surfaceMember xlink:href="#UUID_55053189-bc84-4083-af76-f571fbebefda"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1949-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2032-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_71B0628B-5747-4BD8-AB39-49BFA7D440D3">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_C7A1C440-C391-48AB-A75E-028F5B378B0C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e0703bca-2693-468b-b3f9-40c4728679d2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 10.0 0.0 50.0 10.0 0.0 50.0 18.0 0.0 56.0 18.0 0.0 56.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DA470E68-DBD6-42B6-ABBD-FEC6BBA6F525">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fb009d9e-3561-4007-a563-bb3b5cf7c7c8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 10.0 0.0 56.0 10.0 0.0 56.0 10.0 5.0 53.0 10.0 11.0 50.0 10.0 5.0 50.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0205548E-12E9-4254-98E6-09B54DA24AE4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6d1584e3-e0d3-4069-801c-66f982992d24">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 18.0 0.0 50.0 18.0 0.0 50.0 18.0 5.0 53.0 18.0 11.0 56.0 18.0 5.0 56.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_975D7EDE-FC75-43D0-B079-592BD11DF6F3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_45ecf300-87b0-440f-b6f7-ea1b5092ea54">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 10.0 0.0 50.0 10.0 5.0 50.0 18.0 5.0 50.0 18.0 0.0 50.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FB1E2560-209D-4FD8-9892-6ACA32595F74">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_12d7c711-91fe-4cc5-813c-3c60756898ce">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 18.0 0.0 56.0 18.0 5.0 56.0 10.0 5.0 56.0 10.0 0.0 56.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_18756511-1014-40FA-9D86-4C19AE47F9C9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e406c4f9-ff37-4256-9f9e-c7d0c6e6dcea">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 10.0 5.0 53.0 10.0 11.0 53.0 18.0 11.0 50.0 18.0 5.0 50.0 10.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_821AFBFB-4DFA-45EC-9903-D7E3506FA5A3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_19dd4601-1a13-46bb-a7a8-df4641234c63">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 18.0 5.0 53.0 18.0 11.0 53.0 10.0 11.0 56.0 10.0 5.0 56.0 18.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_e0703bca-2693-468b-b3f9-40c4728679d2"/>
              <gml:surfaceMember xlink:href="#UUID_fb009d9e-3561-4007-a563-bb3b5cf7c7c8"/>
              <gml:surfaceMember xlink:href="#UUID_6d1584e3-e0d3-4069-801c-66f982992d24"/>
              <gml:surfaceMember xlink:href="#UUID_45ecf300-87b0-440f-b6f7-ea1b5092ea54"/>
              <gml:surfaceMember xlink:href="#UUID_12d7c711-91fe-4cc5-813c-3c60756898ce"/>
              <gml:surfaceMember xlink:href="#UUID_e406c4f9-ff37-4256-9f9e-c7d0c6e6dcea"/>
              <gml:surfaceMember xlink:href="#UUID_19dd4601-1a13-46bb-a7a8-df4641234c63"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1994-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2072-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1030</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_CE3138F1-845A-4DF4-BB91-7E2914867674">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_66C79534-C5C6-41DD-B1F6-34287506728E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_96befc08-6599-4d0f-8b5d-d0fde0a5d0af">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 10.0 0.0 60.0 10.0 0.0 60.0 18.0 0.0 66.0 18.0 0.0 66.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_440EEF09-4198-4375-9F0E-3F8FA85A10BA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_292f40c0-2e6a-4188-ba87-be5404e009db">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 10.0 0.0 66.0 10.0 0.0 66.0 10.0 6.0 63.0 10.0 8.0 60.0 10.0 6.0 60.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_85EA4112-9019-4FAC-AD32-134A814F014C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6684186c-cf55-4d66-9133-7981f999572a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 18.0 0.0 60.0 18.0 0.0 60.0 18.0 6.0 63.0 18.0 8.0 66.0 18.0 6.0 66.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C044BAC0-CE8B-4520-ABEC-86917D817D05">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_865a3ebe-51f8-42dc-b81b-eebb3049931c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 10.0 0.0 60.0 10.0 6.0 60.0 18.0 6.0 60.0 18.0 0.0 60.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8456665A-7F3C-4D6E-A949-C37693ABB2BD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_25098f9d-3a0b-4217-85b2-2a4f1efa18c4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 18.0 0.0 66.0 18.0 6.0 66.0 10.0 6.0 66.0 10.0 0.0 66.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_97A0C35B-7EA7-4E30-B97C-2328890C583B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_63892ef6-92cd-4642-a5fb-fa3c9de51d0e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 10.0 6.0 63.0 10.0 8.0 63.0 18.0 8.0 60.0 18.0 6.0 60.0 10.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_333E1799-C4A0-4994-8FBD-7EC9A7B1B087">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4d32c8b3-a41c-4b46-a762-06037f664dbc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 18.0 6.0 63.0 18.0 8.0 63.0 10.0 8.0 66.0 10.0 6.0 66.0 18.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_96befc08-6599-4d0f-8b5d-d0fde0a5d0af"/>
              <gml:surfaceMember xlink:href="#UUID_292f40c0-2e6a-4188-ba87-be5404e009db"/>
              <gml:surfaceMember xlink:href="#UUID_6684186c-cf55-4d66-9133-7981f999572a"/>
              <gml:surfaceMember xlink:href="#UUID_865a3ebe-51f8-42dc-b81b-eebb3049931c"/>
              <gml:surfaceMember xlink:href="#UUID_25098f9d-3a0b-4217-85b2-2a4f1efa18c4"/>
              <gml:surfaceMember xlink:href="#UUID_63892ef6-92cd-4642-a5fb-fa3c9de51d0e"/>
              <gml:surfaceMember xlink:href="#UUID_4d32c8b3-a41c-4b46-a762-06037f664dbc"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1975-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2068-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1080</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_F8185B2E-DC12-4E24-ABA3-380DD2C23E63">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_379D70D8-46EF-4D35-A515-E56E0FAF8344">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b7e5bfe5-823a-41a2-ab38-a8c496892b15">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 10.0 0.0 70.0 10.0 0.0 70.0 18.0 0.0 76.0 18.0 0.0 76.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_52A83304-E692-4278-8082-38C15A94FBDB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_04a1a7ef-4ca9-4557-be22-479e1db67046">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 10.0 0.0 76.0 10.0 0.0 76.0 10.0 3.0 73.0 10.0 9.0 70.0 10.0 3.0 70.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EAE6DE96-B8A5-40B3-98C1-744468D4BD81">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fdf946ef-9349-4cc8-a862-7ab6361cd5e1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 18.0 0.0 70.0 18.0 0.0 70.0 18.0 3.0 73.0 18.0 9.0 76.0 18.0 3.0 76.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C0FFDE29-BFBC-4E21-831D-991B1F3A85A3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_79375326-a29d-4912-89b2-88d18cb3819b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 10.0 0.0 70.0 10.0 3.0 70.0 18.0 3.0 70.0 18.0 0.0 70.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C6F80D06-4044-43CD-B9A2-69CB2DD96FA4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_14651ad2-a1f0-4222-ac02-74a43909ec36">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 18.0 0.0 76.0 18.0 3.0 76.0 10.0 3.0 76.0 10.0 0.0 76.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A1FD8A49-E8DA-4ABD-ABD2-8B88BD22B794">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1726fdf1-02c7-4334-9058-643411fd8b1d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 10.0 3.0 73.0 10.0 9.0 73.0 18.0 9.0 70.0 18.0 3.0 70.0 10.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3ADAC9F2-0C4E-4CE8-9949-DCDF2CFE21A7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_94726697-01c7-40cb-8128-bbe515150bd1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 18.0 3.0 73.0 18.0 9.0 73.0 10.0 9.0 76.0 10.0 3.0 76.0 18.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_b7e5bfe5-823a-41a2-ab38-a8c496892b15"/>
              <gml:surfaceMember xlink:href="#UUID_04a1a7ef-4ca9-4557-be22-479e1db67046"/>
              <gml:surfaceMember xlink:href="#UUID_fdf946ef-9349-4cc8-a862-7ab6361cd5e1"/>
              <gml:surfaceMember xlink:href="#UUID_79375326-a29d-4912-89b2-88d18cb3819b"/>
              <gml:surfaceMember xlink:href="#UUID_14651ad2-a1f0-4222-ac02-74a43909ec36"/>
              <gml:surfaceMember xlink:href="#UUID_1726fdf1-02c7-4334-9058-643411fd8b1d"/>
              <gml:surfaceMember xlink:href="#UUID_94726697-01c7-40cb-8128-bbe515150bd1"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1933-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2030-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1020</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_223389A7-2B18-4366-B0C1-7CBC934C055D">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_68F1351F-D64D-4F6D-9975-6EB52C639620">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_484970bf-355f-410d-b632-a9fc3e946631">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 10.0 0.0 80.0 10.0 0.0 80.0 18.0 0.0 86.0 18.0 0.0 86.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_447CCE92-1097-4726-8729-F508B6832255">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_20c4577b-7002-4a13-9df1-8f2e6525fae9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 10.0 0.0 86.0 10.0 0.0 86.0 10.0 5.0 83.0 10.0 11.0 80.0 10.0 5.0 80.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DB909861-D865-4AC6-8E2B-6F68A67D741D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3c88acbc-e1fd-4d46-b060-0988ae221451">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 18.0 0.0 80.0 18.0 0.0 80.0 18.0 5.0 83.0 18.0 11.0 86.0 18.0 5.0 86.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8EA7CAB0-BF23-47C7-A5E1-E3C06CED99F5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dc1d96d0-097a-4f0b-b7b6-725068e4f633">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 10.0 0.0 80.0 10.0 5.0 80.0 18.0 5.0 80.0 18.0 0.0 80.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BCEEA780-BB32-4FFD-9522-59AE594F1D10">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6e30b502-54a8-4e67-911c-27520e21e887">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 18.0 0.0 86.0 18.0 5.0 86.0 10.0 5.0 86.0 10.0 0.0 86.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_7F58BEF1-C6E5-4ACF-8B90-EAB8B2CFC7A4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_390e9e48-d4eb-4de1-850c-df7d2a097ad1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 10.0 5.0 83.0 10.0 11.0 83.0 18.0 11.0 80.0 18.0 5.0 80.0 10.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_640D4551-00EB-4EED-A71E-77ED61D2BCCC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1c0adcb5-d79c-427d-bfab-ad3b22ba0b29">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 18.0 5.0 83.0 18.0 11.0 83.0 10.0 11.0 86.0 10.0 5.0 86.0 18.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_484970bf-355f-410d-b632-a9fc3e946631"/>
              <gml:surfaceMember xlink:href="#UUID_20c4577b-7002-4a13-9df1-8f2e6525fae9"/>
              <gml:surfaceMember xlink:href="#UUID_3c88acbc-e1fd-4d46-b060-0988ae221451"/>
              <gml:surfaceMember xlink:href="#UUID_dc1d96d0-097a-4f0b-b7b6-725068e4f633"/>
              <gml:surfaceMember xlink:href="#UUID_6e30b502-54a8-4e67-911c-27520e21e887"/>
              <gml:surfaceMember xlink:href="#UUID_390e9e48-d4eb-4de1-850c-df7d2a097ad1"/>
              <gml:surfaceMember xlink:href="#UUID_1c0adcb5-d79c-427d-bfab-ad3b22ba0b29"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1908-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2035-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1150</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_DB8D4531-65CC-4161-8FF2-D62ED7570B82">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-1-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_16C5C469-EBA3-46D7-B3E8-06A7CCEEB4DD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_18effa0f-417f-4699-99a4-fb3ed95cfd92">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 10.0 0.0 90.0 10.0 0.0 90.0 18.0 0.0 96.0 18.0 0.0 96.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8DFD5F94-1883-426C-ABE2-DEC7854A742F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_987a74ee-70a6-4562-a2bc-133177e2cf53">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 10.0 0.0 96.0 10.0 0.0 96.0 10.0 3.0 93.0 10.0 9.0 90.0 10.0 3.0 90.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C1C8A844-A155-4A44-AD27-1FEC17401DC3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cd54945c-d752-4cd3-a3c3-d05b28c75c69">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 18.0 0.0 90.0 18.0 0.0 90.0 18.0 3.0 93.0 18.0 9.0 96.0 18.0 3.0 96.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2103F33C-D556-4C2F-B8F4-38E8A7B5E80F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f2217611-a808-4b59-b262-7e243d109c66">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 10.0 0.0 90.0 10.0 3.0 90.0 18.0 3.0 90.0 18.0 0.0 90.0 10.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C54B5292-8950-41E9-BFC2-38310779BF9D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9c88a82a-df3f-4d93-a592-0d46ba83b4f7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 18.0 0.0 96.0 18.0 3.0 96.0 10.0 3.0 96.0 10.0 0.0 96.0 18.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_96A59514-09B3-4C85-BE58-86B2D0644E09">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_36b65717-d664-484c-8794-fb475cc3e91d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 10.0 3.0 93.0 10.0 9.0 93.0 18.0 9.0 90.0 18.0 3.0 90.0 10.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_97052FE4-4061-45E3-9A46-553C67172210">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_35180ce2-31d7-4a06-a7b0-7afef673c906">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 18.0 3.0 93.0 18.0 9.0 93.0 10.0 9.0 96.0 10.0 3.0 96.0 18.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_18effa0f-417f-4699-99a4-fb3ed95cfd92"/>
              <gml:surfaceMember xlink:href="#UUID_987a74ee-70a6-4562-a2bc-133177e2cf53"/>
              <gml:surfaceMember xlink:href="#UUID_cd54945c-d752-4cd3-a3c3-d05b28c75c69"/>
              <gml:surfaceMember xlink:href="#UUID_f2217611-a808-4b59-b262-7e243d109c66"/>
              <gml:surfaceMember xlink:href="#UUID_9c88a82a-df3f-4d93-a592-0d46ba83b4f7"/>
              <gml:surfaceMember xlink:href="#UUID_36b65717-d664-484c-8794-fb475cc3e91d"/>
              <gml:surfaceMember xlink:href="#UUID_35180ce2-31d7-4a06-a7b0-7afef673c906"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1993-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2062-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1130</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_3B63EB40-4945-46D4-A906-254B49923371">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_AF30F689-25C4-474E-BD01-F63396EC3359">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_53e1ae30-a01c-41d5-b801-d055871b94dc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 20.0 0.0 0.0 20.0 0.0 0.0 28.0 0.0 6.0 28.0 0.0 6.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D7C36BC4-FA45-482D-A227-76468755CFB0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d1a008a8-9923-44b2-a281-3083361edab2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 20.0 0.0 6.0 20.0 0.0 6.0 20.0 5.0 3.0 20.0 10.0 0.0 20.0 5.0 0.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CB3FCBAE-4C6A-460B-9609-0D91FCD03050">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_60af01e3-5073-437b-9d40-8762765793c1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 28.0 0.0 0.0 28.0 0.0 0.0 28.0 5.0 3.0 28.0 10.0 6.0 28.0 5.0 6.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_83ED16CA-01A0-4AE5-84E7-313A3568FED7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cc14c4b6-7bca-48b1-8128-552bdd93bdee">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 20.0 0.0 0.0 20.0 5.0 0.0 28.0 5.0 0.0 28.0 0.0 0.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_13ED0380-AA55-4D90-8B93-3C216BC31F53">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3de87412-d49c-48f4-b93c-2433e78787eb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 28.0 0.0 6.0 28.0 5.0 6.0 20.0 5.0 6.0 20.0 0.0 6.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_D7C61EB7-1CD5-4C00-8595-76C8391D6E6F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_92c5a601-5d49-4e85-ac0e-ff1f7b820be4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 20.0 5.0 3.0 20.0 10.0 3.0 28.0 10.0 0.0 28.0 5.0 0.0 20.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5CED32EC-88B6-4655-8A47-169F84DC1592">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_050d87d8-4e56-4cf2-854b-c1bc731553da">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 28.0 5.0 3.0 28.0 10.0 3.0 20.0 10.0 6.0 20.0 5.0 6.0 28.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_53e1ae30-a01c-41d5-b801-d055871b94dc"/>
              <gml:surfaceMember xlink:href="#UUID_d1a008a8-9923-44b2-a281-3083361edab2"/>
              <gml:surfaceMember xlink:href="#UUID_60af01e3-5073-437b-9d40-8762765793c1"/>
              <gml:surfaceMember xlink:href="#UUID_cc14c4b6-7bca-48b1-8128-552bdd93bdee"/>
              <gml:surfaceMember xlink:href="#UUID_3de87412-d49c-48f4-b93c-2433e78787eb"/>
              <gml:surfaceMember xlink:href="#UUID_92c5a601-5d49-4e85-ac0e-ff1f7b820be4"/>
              <gml:surfaceMember xlink:href="#UUID_050d87d8-4e56-4cf2-854b-c1bc731553da"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1921-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2046-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_4CF2B853-5FD6-45A1-981C-ED765177495B">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_93A0D835-897B-436A-BF94-0D665F61BCA2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1e569ec5-6f14-4db0-88b6-dce02976f8cb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 20.0 0.0 10.0 20.0 0.0 10.0 28.0 0.0 16.0 28.0 0.0 16.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A4AF1B48-EFAA-415B-BDB7-384B22194CEB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5f415a00-39bd-48d3-b456-b25bc3c18fb5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 20.0 0.0 16.0 20.0 0.0 16.0 20.0 7.0 13.0 20.0 8.0 10.0 20.0 7.0 10.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EE25B188-FB9A-4350-9BCA-EC4717F1CAB9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f79497b1-b331-420a-970c-b23d5f6ed936">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 28.0 0.0 10.0 28.0 0.0 10.0 28.0 7.0 13.0 28.0 8.0 16.0 28.0 7.0 16.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_ECAFAEBB-7A63-4DD1-9BDC-CBBB11B94937">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4b482763-586c-4ee1-a6ba-9f04b73fd65e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 20.0 0.0 10.0 20.0 7.0 10.0 28.0 7.0 10.0 28.0 0.0 10.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_15A46E30-AC8B-4C6B-984F-A8C341FCEBD4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_19c9e8ea-8632-4dc9-bc59-77a6cb367277">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 28.0 0.0 16.0 28.0 7.0 16.0 20.0 7.0 16.0 20.0 0.0 16.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_6A14A4BD-9EDF-470B-84FA-CBF2FC88F542">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b4e7097d-9df7-4715-a887-23865bd3757c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 20.0 7.0 13.0 20.0 8.0 13.0 28.0 8.0 10.0 28.0 7.0 10.0 20.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_963B8586-7B70-464E-96B8-744AB7F4DDE5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e71adf38-504f-44c1-8ca3-6a8f38d9ec15">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 28.0 7.0 13.0 28.0 8.0 13.0 20.0 8.0 16.0 20.0 7.0 16.0 28.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_1e569ec5-6f14-4db0-88b6-dce02976f8cb"/>
              <gml:surfaceMember xlink:href="#UUID_5f415a00-39bd-48d3-b456-b25bc3c18fb5"/>
              <gml:surfaceMember xlink:href="#UUID_f79497b1-b331-420a-970c-b23d5f6ed936"/>
              <gml:surfaceMember xlink:href="#UUID_4b482763-586c-4ee1-a6ba-9f04b73fd65e"/>
              <gml:surfaceMember xlink:href="#UUID_19c9e8ea-8632-4dc9-bc59-77a6cb367277"/>
              <gml:surfaceMember xlink:href="#UUID_b4e7097d-9df7-4715-a887-23865bd3757c"/>
              <gml:surfaceMember xlink:href="#UUID_e71adf38-504f-44c1-8ca3-6a8f38d9ec15"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1944-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2042-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1020</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_6A040078-81B8-4AF7-80BE-3F0BBADF7ED3">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_62F7D2D9-C8A9-48E7-8D95-AF4203BDDA8B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c6977751-6029-408f-b0cc-8a335c25c615">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 20.0 0.0 20.0 20.0 0.0 20.0 28.0 0.0 26.0 28.0 0.0 26.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_F0F2EB25-434F-428C-AF84-778193CD0444">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_927791c1-a80e-4a62-921e-e6aede89dadf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 20.0 0.0 26.0 20.0 0.0 26.0 20.0 6.0 23.0 20.0 9.0 20.0 20.0 6.0 20.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2242374D-493F-4AC8-843B-93B3F21B38CE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_15568337-c4a1-4480-9ae0-02621b97dfae">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 28.0 0.0 20.0 28.0 0.0 20.0 28.0 6.0 23.0 28.0 9.0 26.0 28.0 6.0 26.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4A29D754-E59E-4DF6-A133-8853BA7345C9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0199e039-4c67-47e9-81b3-d7fc08f9d414">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 20.0 0.0 20.0 20.0 6.0 20.0 28.0 6.0 20.0 28.0 0.0 20.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B347EE23-F24A-4383-BFE9-A112916A417F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5f94673b-ba25-4111-be1c-521c01ce64e7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 28.0 0.0 26.0 28.0 6.0 26.0 20.0 6.0 26.0 20.0 0.0 26.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F9589724-818D-4808-B03C-5609F960CDB3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_60469ffd-00eb-4a1a-aadd-9f5841383b6b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 20.0 6.0 23.0 20.0 9.0 23.0 28.0 9.0 20.0 28.0 6.0 20.0 20.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_1C8A5813-3B45-457E-8F0C-4994068B8807">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c547911e-c91c-42fe-a030-470eeb6dfa89">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 28.0 6.0 23.0 28.0 9.0 23.0 20.0 9.0 26.0 20.0 6.0 26.0 28.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_c6977751-6029-408f-b0cc-8a335c25c615"/>
              <gml:surfaceMember xlink:href="#UUID_927791c1-a80e-4a62-921e-e6aede89dadf"/>
              <gml:surfaceMember xlink:href="#UUID_15568337-c4a1-4480-9ae0-02621b97dfae"/>
              <gml:surfaceMember xlink:href="#UUID_0199e039-4c67-47e9-81b3-d7fc08f9d414"/>
              <gml:surfaceMember xlink:href="#UUID_5f94673b-ba25-4111-be1c-521c01ce64e7"/>
              <gml:surfaceMember xlink:href="#UUID_60469ffd-00eb-4a1a-aadd-9f5841383b6b"/>
              <gml:surfaceMember xlink:href="#UUID_c547911e-c91c-42fe-a030-470eeb6dfa89"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1909-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2022-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1050</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_2B1A2099-17F7-451F-B727-4F14D2276166">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_8F377A23-8F65-4523-AB9F-69266E8A1A6F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bf1caf96-ba32-461d-b555-f3f67b8aadc8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 20.0 0.0 30.0 20.0 0.0 30.0 28.0 0.0 36.0 28.0 0.0 36.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7ACFDF14-E5EF-4046-B0BE-F0944FCA25F0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e1d3823c-1eca-4e1f-bf90-e24fb38b8e43">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 20.0 0.0 36.0 20.0 0.0 36.0 20.0 4.0 33.0 20.0 9.0 30.0 20.0 4.0 30.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CE8B44CF-BCBA-4883-95CC-BCC105D037A7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_da8d6ed7-dc29-4ea9-b541-1ef5e851ed15">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 28.0 0.0 30.0 28.0 0.0 30.0 28.0 4.0 33.0 28.0 9.0 36.0 28.0 4.0 36.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E548012F-E7F0-4623-997E-174A19160B68">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a716086c-974b-46e0-bd83-d8ca58e3c32c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 20.0 0.0 30.0 20.0 4.0 30.0 28.0 4.0 30.0 28.0 0.0 30.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6443BE23-50E3-498D-867C-2167ED19E7F3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1bab0e9e-54af-4407-a043-dc6eee50ed30">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 28.0 0.0 36.0 28.0 4.0 36.0 20.0 4.0 36.0 20.0 0.0 36.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_963517BE-11AD-41AE-B812-7FA5BA264796">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1ca6bc1e-7174-419f-b431-90391cfbdaf3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 20.0 4.0 33.0 20.0 9.0 33.0 28.0 9.0 30.0 28.0 4.0 30.0 20.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_DFF2BA00-2B97-4485-97D7-2355A57870C7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_60ff5759-d646-4e29-988b-3019f88a415e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 28.0 4.0 33.0 28.0 9.0 33.0 20.0 9.0 36.0 20.0 4.0 36.0 28.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_bf1caf96-ba32-461d-b555-f3f67b8aadc8"/>
              <gml:surfaceMember xlink:href="#UUID_e1d3823c-1eca-4e1f-bf90-e24fb38b8e43"/>
              <gml:surfaceMember xlink:href="#UUID_da8d6ed7-dc29-4ea9-b541-1ef5e851ed15"/>
              <gml:surfaceMember xlink:href="#UUID_a716086c-974b-46e0-bd83-d8ca58e3c32c"/>
              <gml:surfaceMember xlink:href="#UUID_1bab0e9e-54af-4407-a043-dc6eee50ed30"/>
              <gml:surfaceMember xlink:href="#UUID_1ca6bc1e-7174-419f-b431-90391cfbdaf3"/>
              <gml:surfaceMember xlink:href="#UUID_60ff5759-d646-4e29-988b-3019f88a415e"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1925-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2047-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_74C5D239-8F61-4F1D-AFCA-A835672931DA">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1CAB3CE8-8ED8-43F3-B9ED-8703A246DBD9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_43e069d6-b623-42c7-8efe-d2d9e59a67e1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 20.0 0.0 40.0 20.0 0.0 40.0 28.0 0.0 46.0 28.0 0.0 46.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_56340854-5D14-4A33-9E5A-F2FE80EC3255">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_766b739c-f4da-435a-9de3-204e83bc937a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 20.0 0.0 46.0 20.0 0.0 46.0 20.0 7.0 43.0 20.0 9.0 40.0 20.0 7.0 40.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0484F9BF-50F5-4CD7-A16F-63C86BE40550">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_29082b82-2aae-4832-99c4-da42b784abbd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 28.0 0.0 40.0 28.0 0.0 40.0 28.0 7.0 43.0 28.0 9.0 46.0 28.0 7.0 46.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_00457D68-1E1D-4D83-86E4-E654B46D20C7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ec4a89c5-7f0b-4710-81ea-c0de3f609bdb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 20.0 0.0 40.0 20.0 7.0 40.0 28.0 7.0 40.0 28.0 0.0 40.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E5F9E9DF-B295-4D1D-B2E6-AA388BE8A1DA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bebe6a58-abfb-4238-8fec-c320fff29f7a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 28.0 0.0 46.0 28.0 7.0 46.0 20.0 7.0 46.0 20.0 0.0 46.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B65C9237-9C12-4093-AEEA-27D252CD52DB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b9d7594e-5d6d-4c80-8894-8fb6bd3d850a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 20.0 7.0 43.0 20.0 9.0 43.0 28.0 9.0 40.0 28.0 7.0 40.0 20.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_CC732360-DFC9-4E1E-A529-C8DE906F9EA5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_121c9ae6-63a2-4643-93e4-cc60b23c8b65">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 28.0 7.0 43.0 28.0 9.0 43.0 20.0 9.0 46.0 20.0 7.0 46.0 28.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_43e069d6-b623-42c7-8efe-d2d9e59a67e1"/>
              <gml:surfaceMember xlink:href="#UUID_766b739c-f4da-435a-9de3-204e83bc937a"/>
              <gml:surfaceMember xlink:href="#UUID_29082b82-2aae-4832-99c4-da42b784abbd"/>
              <gml:surfaceMember xlink:href="#UUID_ec4a89c5-7f0b-4710-81ea-c0de3f609bdb"/>
              <gml:surfaceMember xlink:href="#UUID_bebe6a58-abfb-4238-8fec-c320fff29f7a"/>
              <gml:surfaceMember xlink:href="#UUID_b9d7594e-5d6d-4c80-8894-8fb6bd3d850a"/>
              <gml:surfaceMember xlink:href="#UUID_121c9ae6-63a2-4643-93e4-cc60b23c8b65"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1975-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2094-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1110</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_A9ED2889-FCB3-42DA-B5DD-0B45F2B4ED6A">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_91257C4F-F3BD-4841-81A7-3B48192E1BC9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cc4bc8f6-652b-4886-a58c-84c2ae4d8ce4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 20.0 0.0 50.0 20.0 0.0 50.0 28.0 0.0 56.0 28.0 0.0 56.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B4A0640A-8029-4903-9377-C941FCDFC7BE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_442d3c60-0b02-4767-b9b2-988f212d6be6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 20.0 0.0 56.0 20.0 0.0 56.0 20.0 6.0 53.0 20.0 8.0 50.0 20.0 6.0 50.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9D0EF038-F0EF-4AFA-B1DA-CCF4B9C63C52">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6c6fb3a3-0829-4b98-8012-7870c24630fb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 28.0 0.0 50.0 28.0 0.0 50.0 28.0 6.0 53.0 28.0 8.0 56.0 28.0 6.0 56.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C2395E18-A402-4B85-9AFA-C2E781C69636">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_64db83b8-5b3f-42dd-9b01-210af677ad58">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 20.0 0.0 50.0 20.0 6.0 50.0 28.0 6.0 50.0 28.0 0.0 50.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_F0CC271C-6261-47DB-AF20-9614F6A67946">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_17420a19-a44e-46ee-808e-92c74143ccdc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 28.0 0.0 56.0 28.0 6.0 56.0 20.0 6.0 56.0 20.0 0.0 56.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_392A02D5-CD8D-4D45-85C7-4ECC4BC70E45">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_26630498-15fc-458a-994b-ad6ceeb7f17a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 20.0 6.0 53.0 20.0 8.0 53.0 28.0 8.0 50.0 28.0 6.0 50.0 20.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_35987E36-5633-41E3-8F3A-1B357379C0C7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7f07269d-5795-479d-b90e-89cc30a19f77">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 28.0 6.0 53.0 28.0 8.0 53.0 20.0 8.0 56.0 20.0 6.0 56.0 28.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_cc4bc8f6-652b-4886-a58c-84c2ae4d8ce4"/>
              <gml:surfaceMember xlink:href="#UUID_442d3c60-0b02-4767-b9b2-988f212d6be6"/>
              <gml:surfaceMember xlink:href="#UUID_6c6fb3a3-0829-4b98-8012-7870c24630fb"/>
              <gml:surfaceMember xlink:href="#UUID_64db83b8-5b3f-42dd-9b01-210af677ad58"/>
              <gml:surfaceMember xlink:href="#UUID_17420a19-a44e-46ee-808e-92c74143ccdc"/>
              <gml:surfaceMember xlink:href="#UUID_26630498-15fc-458a-994b-ad6ceeb7f17a"/>
              <gml:surfaceMember xlink:href="#UUID_7f07269d-5795-479d-b90e-89cc30a19f77"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1996-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2029-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_1069C311-B523-48DC-AC41-5F98364DEE81">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_D453F869-81F3-4CAF-9E45-A6E7E91E3737">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2d4ab06b-c5d1-43a2-a1cb-b7f8da105823">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 20.0 0.0 60.0 20.0 0.0 60.0 28.0 0.0 66.0 28.0 0.0 66.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_043769F8-811C-4398-B7C2-63074DDD3B9A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2ca7e0b0-c285-46fa-b9ea-64e3b7fe279f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 20.0 0.0 66.0 20.0 0.0 66.0 20.0 3.0 63.0 20.0 9.0 60.0 20.0 3.0 60.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AA863DDE-53EF-4BBB-8310-CD239FB928E6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_29ddb9eb-8f45-4ad2-926f-06d06a859ccd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 28.0 0.0 60.0 28.0 0.0 60.0 28.0 3.0 63.0 28.0 9.0 66.0 28.0 3.0 66.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7B42C6F7-B4B4-4D78-8D43-7B31470BF5DE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_23b3882b-0b9f-4316-8638-dcd8dc35d003">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 20.0 0.0 60.0 20.0 3.0 60.0 28.0 3.0 60.0 28.0 0.0 60.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_93C8BEE8-4567-47D4-ADF1-F2719D832870">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_472c302a-0c6a-4825-a837-e343352d1aa7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 28.0 0.0 66.0 28.0 3.0 66.0 20.0 3.0 66.0 20.0 0.0 66.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B46C4C39-D89E-483B-B3D2-F56EDA36A987">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_09047149-5ef7-4561-a561-938a7538dbf0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 20.0 3.0 63.0 20.0 9.0 63.0 28.0 9.0 60.0 28.0 3.0 60.0 20.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_CB7DA0F7-D7F7-4164-B898-522A2A93024A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_69265bf4-c09a-4a12-8a82-4bb81902e3a6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 28.0 3.0 63.0 28.0 9.0 63.0 20.0 9.0 66.0 20.0 3.0 66.0 28.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_2d4ab06b-c5d1-43a2-a1cb-b7f8da105823"/>
              <gml:surfaceMember xlink:href="#UUID_2ca7e0b0-c285-46fa-b9ea-64e3b7fe279f"/>
              <gml:surfaceMember xlink:href="#UUID_29ddb9eb-8f45-4ad2-926f-06d06a859ccd"/>
              <gml:surfaceMember xlink:href="#UUID_23b3882b-0b9f-4316-8638-dcd8dc35d003"/>
              <gml:surfaceMember xlink:href="#UUID_472c302a-0c6a-4825-a837-e343352d1aa7"/>
              <gml:surfaceMember xlink:href="#UUID_09047149-5ef7-4561-a561-938a7538dbf0"/>
              <gml:surfaceMember xlink:href="#UUID_69265bf4-c09a-4a12-8a82-4bb81902e3a6"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1922-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2099-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_08144080-363F-4EBF-8D45-91EDC7F26D46">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_5AFFB10F-990B-40A3-BE76-60EF01B38302">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_49b4cb39-69a8-413f-b4d0-f4b4159bff7d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 20.0 0.0 70.0 20.0 0.0 70.0 28.0 0.0 76.0 28.0 0.0 76.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3B1AFAD0-BB81-469A-81D1-BADDA27BFE74">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_91e45c82-8396-4f74-bbcf-1ff410121f5d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 20.0 0.0 76.0 20.0 0.0 76.0 20.0 5.0 73.0 20.0 9.0 70.0 20.0 5.0 70.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3CFEFFC7-2565-4FD8-8F0F-37B09F9B0ECF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_21dc9d63-521b-4e13-86bc-906bf0aa54c1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 28.0 0.0 70.0 28.0 0.0 70.0 28.0 5.0 73.0 28.0 9.0 76.0 28.0 5.0 76.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D0D57E1C-EADB-4480-846A-BEFE6B2A6100">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b5d6276a-619c-4d87-8dbc-0aae9e95dade">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 20.0 0.0 70.0 20.0 5.0 70.0 28.0 5.0 70.0 28.0 0.0 70.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2E4B21C6-4D79-49DE-92EC-98A1B4DB8EAB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0be56450-8b2e-4964-8ded-4fa6fbfcdd78">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 28.0 0.0 76.0 28.0 5.0 76.0 20.0 5.0 76.0 20.0 0.0 76.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_0D646FB1-6B46-41CD-8A2A-A1FCF56FD2FB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_63ad7672-4e4b-4691-a59e-43ed9c33dd83">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 20.0 5.0 73.0 20.0 9.0 73.0 28.0 9.0 70.0 28.0 5.0 70.0 20.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_43033734-D387-4CED-96B7-EC758B9C0B45">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e93f50eb-7b1b-4559-a1c1-e92b979fdab9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 28.0 5.0 73.0 28.0 9.0 73.0 20.0 9.0 76.0 20.0 5.0 76.0 28.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_49b4cb39-69a8-413f-b4d0-f4b4159bff7d"/>
              <gml:surfaceMember xlink:href="#UUID_91e45c82-8396-4f74-bbcf-1ff410121f5d"/>
              <gml:surfaceMember xlink:href="#UUID_21dc9d63-521b-4e13-86bc-906bf0aa54c1"/>
              <gml:surfaceMember xlink:href="#UUID_b5d6276a-619c-4d87-8dbc-0aae9e95dade"/>
              <gml:surfaceMember xlink:href="#UUID_0be56450-8b2e-4964-8ded-4fa6fbfcdd78"/>
              <gml:surfaceMember xlink:href="#UUID_63ad7672-4e4b-4691-a59e-43ed9c33dd83"/>
              <gml:surfaceMember xlink:href="#UUID_e93f50eb-7b1b-4559-a1c1-e92b979fdab9"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1954-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2053-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1170</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_EB8761DE-DA99-4A0C-8B65-A1BD9927F3E3">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_41465B66-0DD8-45B5-A363-229FDC85C852">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0ab80c58-67f3-446e-b019-106440ccbf1d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 20.0 0.0 80.0 20.0 0.0 80.0 28.0 0.0 86.0 28.0 0.0 86.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D30B99C5-B8D7-44A5-9D77-757E7EEDDD7C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_220b2624-0277-4220-bb17-0b3428911951">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 20.0 0.0 86.0 20.0 0.0 86.0 20.0 6.0 83.0 20.0 11.0 80.0 20.0 6.0 80.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CD6DC0E2-CBD9-47DC-9F7F-19962FE584F9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f60136a5-14b3-42e8-b983-13d4fb2231be">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 28.0 0.0 80.0 28.0 0.0 80.0 28.0 6.0 83.0 28.0 11.0 86.0 28.0 6.0 86.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3A288C91-2C62-43FD-9E86-76A1A9A2D796">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4d3e79b0-f6c7-491f-ba4b-8e76f22fde91">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 20.0 0.0 80.0 20.0 6.0 80.0 28.0 6.0 80.0 28.0 0.0 80.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3820FE88-1A32-4816-8102-C0DEE00F3968">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_acca4e24-6acd-46de-ab2e-ad69ce39b6cf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 28.0 0.0 86.0 28.0 6.0 86.0 20.0 6.0 86.0 20.0 0.0 86.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5B90D0B2-173D-49F6-8120-5D647D5F8402">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_842fb7e8-fe6a-4d65-805e-a5467bc3e3d9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 20.0 6.0 83.0 20.0 11.0 83.0 28.0 11.0 80.0 28.0 6.0 80.0 20.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C3EF90A6-A5C0-4B07-AB3F-5990124B9DF3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_123fe7a2-b253-4d86-bbfa-91307f3e2e51">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 28.0 6.0 83.0 28.0 11.0 83.0 20.0 11.0 86.0 20.0 6.0 86.0 28.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_0ab80c58-67f3-446e-b019-106440ccbf1d"/>
              <gml:surfaceMember xlink:href="#UUID_220b2624-0277-4220-bb17-0b3428911951"/>
              <gml:surfaceMember xlink:href="#UUID_f60136a5-14b3-42e8-b983-13d4fb2231be"/>
              <gml:surfaceMember xlink:href="#UUID_4d3e79b0-f6c7-491f-ba4b-8e76f22fde91"/>
              <gml:surfaceMember xlink:href="#UUID_acca4e24-6acd-46de-ab2e-ad69ce39b6cf"/>
              <gml:surfaceMember xlink:href="#UUID_842fb7e8-fe6a-4d65-805e-a5467bc3e3d9"/>
              <gml:surfaceMember xlink:href="#UUID_123fe7a2-b253-4d86-bbfa-91307f3e2e51"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1934-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2060-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1180</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_CFB4E4AD-AC69-4930-8344-CA1F7BA00442">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-2-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_32E389CB-0E88-48CD-8D87-FED1CEC5933A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_33eb5862-b000-4234-8b40-175f545f1f87">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 20.0 0.0 90.0 20.0 0.0 90.0 28.0 0.0 96.0 28.0 0.0 96.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7677AEBB-F2A4-4BF8-A9DD-CFE71175C657">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_58d36049-b0f0-4fe3-a8a6-796d73a7caf1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 20.0 0.0 96.0 20.0 0.0 96.0 20.0 5.0 93.0 20.0 8.0 90.0 20.0 5.0 90.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2D6C4978-98E6-4313-BDF2-3EB1052BEAFC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d3bfb910-01ab-4111-a047-4a8dd1a9eb4b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 28.0 0.0 90.0 28.0 0.0 90.0 28.0 5.0 93.0 28.0 8.0 96.0 28.0 5.0 96.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CA2BFDDC-771D-4E9F-A33D-1FADD2451791">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0352ae48-91e8-4c76-8e06-11d045453dd3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 20.0 0.0 90.0 20.0 5.0 90.0 28.0 5.0 90.0 28.0 0.0 90.0 20.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EAA6E160-785E-45EA-B401-587F48A8F1AA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0537db38-ca9a-49d6-9bbc-e09edf4bc997">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 28.0 0.0 96.0 28.0 5.0 96.0 20.0 5.0 96.0 20.0 0.0 96.0 28.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_FF42294E-06A1-49E1-AF13-209CB2D68568">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f176c906-d6aa-4648-b4c9-9e65ada2d1a0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 20.0 5.0 93.0 20.0 8.0 93.0 28.0 8.0 90.0 28.0 5.0 90.0 20.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B8D5564D-E39A-40AD-98D9-1197480DA189">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_46219632-6798-4260-9a18-1e51ed01a0a1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 28.0 5.0 93.0 28.0 8.0 93.0 20.0 8.0 96.0 20.0 5.0 96.0 28.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_33eb5862-b000-4234-8b40-175f545f1f87"/>
              <gml:surfaceMember xlink:href="#UUID_58d36049-b0f0-4fe3-a8a6-796d73a7caf1"/>
              <gml:surfaceMember xlink:href="#UUID_d3bfb910-01ab-4111-a047-4a8dd1a9eb4b"/>
              <gml:surfaceMember xlink:href="#UUID_0352ae48-91e8-4c76-8e06-11d045453dd3"/>
              <gml:surfaceMember xlink:href="#UUID_0537db38-ca9a-49d6-9bbc-e09edf4bc997"/>
              <gml:surfaceMember xlink:href="#UUID_f176c906-d6aa-4648-b4c9-9e65ada2d1a0"/>
              <gml:surfaceMember xlink:href="#UUID_46219632-6798-4260-9a18-1e51ed01a0a1"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1981-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2063-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_B95C6AFD-524C-4A1C-9D7D-DAA4A2BD5473">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_E5F7493F-9F72-4C7C-B43A-D4DD96571672">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_37510375-0470-4bb9-9234-30b7d91591a8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 30.0 0.0 0.0 30.0 0.0 0.0 38.0 0.0 6.0 38.0 0.0 6.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_1DB95511-FE0A-4180-A531-F02C56F3EBDD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_48763f66-850c-4915-a510-b46291d35632">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 30.0 0.0 6.0 30.0 0.0 6.0 30.0 6.0 3.0 30.0 9.0 0.0 30.0 6.0 0.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3C36A4F1-7B56-48D6-B0FE-7937A5F73FA0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_80b1bdb5-0a83-4050-8927-b7093d1f4f39">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 38.0 0.0 0.0 38.0 0.0 0.0 38.0 6.0 3.0 38.0 9.0 6.0 38.0 6.0 6.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_209043F7-EBDD-41BF-815A-DA818A35C7BD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_043e8d76-7ec9-4e12-be2b-a998efa38d45">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 30.0 0.0 0.0 30.0 6.0 0.0 38.0 6.0 0.0 38.0 0.0 0.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C17970BF-E460-413D-B28D-119C34F1C31C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_58664fc8-bb30-4df7-9ef2-c6ce813ca332">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 38.0 0.0 6.0 38.0 6.0 6.0 30.0 6.0 6.0 30.0 0.0 6.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9565E655-D8CE-4F83-8D4E-2B2D755F6402">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_218b9f32-ecde-4898-840f-74b48732e0dd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 30.0 6.0 3.0 30.0 9.0 3.0 38.0 9.0 0.0 38.0 6.0 0.0 30.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_4175C957-6C36-43CF-9D49-34085D2B649D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bc187827-e057-4fab-b65a-cdae676696f1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 38.0 6.0 3.0 38.0 9.0 3.0 30.0 9.0 6.0 30.0 6.0 6.0 38.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_37510375-0470-4bb9-9234-30b7d91591a8"/>
              <gml:surfaceMember xlink:href="#UUID_48763f66-850c-4915-a510-b46291d35632"/>
              <gml:surfaceMember xlink:href="#UUID_80b1bdb5-0a83-4050-8927-b7093d1f4f39"/>
              <gml:surfaceMember xlink:href="#UUID_043e8d76-7ec9-4e12-be2b-a998efa38d45"/>
              <gml:surfaceMember xlink:href="#UUID_58664fc8-bb30-4df7-9ef2-c6ce813ca332"/>
              <gml:surfaceMember xlink:href="#UUID_218b9f32-ecde-4898-840f-74b48732e0dd"/>
              <gml:surfaceMember xlink:href="#UUID_bc187827-e057-4fab-b65a-cdae676696f1"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1968-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2091-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_EF615D5A-C2EF-4AFE-9BB7-46DA310BB4C5">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_457A0E7C-462A-439B-9FD3-5498CF19A1ED">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_39a92122-11fc-4374-a1ec-6e1040bcddec">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 30.0 0.0 10.0 30.0 0.0 10.0 38.0 0.0 16.0 38.0 0.0 16.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AC5F29C0-607E-4F48-A410-3F0329542D55">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2960d1af-d5d8-480c-8aab-d6d68390c6f4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 30.0 0.0 16.0 30.0 0.0 16.0 30.0 3.0 13.0 30.0 9.0 10.0 30.0 3.0 10.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B74263DF-F386-4E33-A1D2-E5AD1A5D886D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c1a25b37-a3e6-4679-94bc-51fc34311333">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 38.0 0.0 10.0 38.0 0.0 10.0 38.0 3.0 13.0 38.0 9.0 16.0 38.0 3.0 16.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5954C52C-9B1E-49F7-8502-7C1E4303C979">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9f7aee08-fc34-4080-9c14-a6e413ce4994">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 30.0 0.0 10.0 30.0 3.0 10.0 38.0 3.0 10.0 38.0 0.0 10.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_79059957-1B1E-4E7A-9CA9-9CD56810E995">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dedd92fd-c268-41c3-867f-93b71ba2cd6b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 38.0 0.0 16.0 38.0 3.0 16.0 30.0 3.0 16.0 30.0 0.0 16.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_CB40326D-3E11-4AF6-A800-79FE85098873">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_05721fb2-c8ef-49a8-afb0-4b002139a43c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 30.0 3.0 13.0 30.0 9.0 13.0 38.0 9.0 10.0 38.0 3.0 10.0 30.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2D632DB4-5C8E-47C2-8DD2-3443C71A5C30">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0ef8944b-a9e9-4d25-83c7-fc74b66f77ce">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 38.0 3.0 13.0 38.0 9.0 13.0 30.0 9.0 16.0 30.0 3.0 16.0 38.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_39a92122-11fc-4374-a1ec-6e1040bcddec"/>
              <gml:surfaceMember xlink:href="#UUID_2960d1af-d5d8-480c-8aab-d6d68390c6f4"/>
              <gml:surfaceMember xlink:href="#UUID_c1a25b37-a3e6-4679-94bc-51fc34311333"/>
              <gml:surfaceMember xlink:href="#UUID_9f7aee08-fc34-4080-9c14-a6e413ce4994"/>
              <gml:surfaceMember xlink:href="#UUID_dedd92fd-c268-41c3-867f-93b71ba2cd6b"/>
              <gml:surfaceMember xlink:href="#UUID_05721fb2-c8ef-49a8-afb0-4b002139a43c"/>
              <gml:surfaceMember xlink:href="#UUID_0ef8944b-a9e9-4d25-83c7-fc74b66f77ce"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1922-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2067-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_1E77A4C2-1BDD-4A10-9A01-AE0CD13142FC">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_30871297-97C1-4AED-A7EE-F45840BB442A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_20c06736-8edc-417b-8c53-63714873fa17">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 30.0 0.0 20.0 30.0 0.0 20.0 38.0 0.0 26.0 38.0 0.0 26.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_00615594-3427-4617-8927-0A1692941BD9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fa0ef279-b0c1-4dc5-aa42-edbe789b554b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 30.0 0.0 26.0 30.0 0.0 26.0 30.0 3.0 23.0 30.0 10.0 20.0 30.0 3.0 20.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_65F1DD3B-CE21-4789-9876-09D7284E469A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2ae3e0da-980b-407a-9938-a6ae5a6a7a47">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 38.0 0.0 20.0 38.0 0.0 20.0 38.0 3.0 23.0 38.0 10.0 26.0 38.0 3.0 26.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4AE24B41-50D6-4022-B280-0F650CC75DFD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e0bcf4af-45d3-429b-9a11-23082cf490a0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 30.0 0.0 20.0 30.0 3.0 20.0 38.0 3.0 20.0 38.0 0.0 20.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4A4199C0-DE54-4FD6-932F-6A3A686DBB12">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_de86c282-898d-4120-85a3-f352a287e859">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 38.0 0.0 26.0 38.0 3.0 26.0 30.0 3.0 26.0 30.0 0.0 26.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B303476F-BC4E-4130-B826-B88B82BD8E02">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_196b1c8f-a980-4740-a4dc-f6320a9054a1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 30.0 3.0 23.0 30.0 10.0 23.0 38.0 10.0 20.0 38.0 3.0 20.0 30.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3CFC8572-CB73-4A9A-B510-8A2D1EB41AA7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_12e2756d-5167-46f1-bf91-ef17a3780fc5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 38.0 3.0 23.0 38.0 10.0 23.0 30.0 10.0 26.0 30.0 3.0 26.0 38.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_20c06736-8edc-417b-8c53-63714873fa17"/>
              <gml:surfaceMember xlink:href="#UUID_fa0ef279-b0c1-4dc5-aa42-edbe789b554b"/>
              <gml:surfaceMember xlink:href="#UUID_2ae3e0da-980b-407a-9938-a6ae5a6a7a47"/>
              <gml:surfaceMember xlink:href="#UUID_e0bcf4af-45d3-429b-9a11-23082cf490a0"/>
              <gml:surfaceMember xlink:href="#UUID_de86c282-898d-4120-85a3-f352a287e859"/>
              <gml:surfaceMember xlink:href="#UUID_196b1c8f-a980-4740-a4dc-f6320a9054a1"/>
              <gml:surfaceMember xlink:href="#UUID_12e2756d-5167-46f1-bf91-ef17a3780fc5"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1975-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2069-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1120</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_EFF909F6-1180-44F1-A298-38C97D4ACE95">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_76A3BF25-BDD4-427F-8E9F-D2EC8B58AEAB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0c5b7867-6d2c-4839-93c2-3e5cb3075502">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 30.0 0.0 30.0 30.0 0.0 30.0 38.0 0.0 36.0 38.0 0.0 36.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_12B7ED22-114D-4727-B24B-3A7D07FFF57F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c88409d1-a5b2-403e-aa11-3983a5656150">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 30.0 0.0 36.0 30.0 0.0 36.0 30.0 4.0 33.0 30.0 12.0 30.0 30.0 4.0 30.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BA7E58C0-DDF3-4C0E-8DE2-615A99DBABF8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_078db51f-cd25-4ef5-9132-238c131ba3c3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 38.0 0.0 30.0 38.0 0.0 30.0 38.0 4.0 33.0 38.0 12.0 36.0 38.0 4.0 36.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D99252B8-E4B1-47C4-8E23-D59753F9C523">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_84acc292-8b68-4a64-87f0-3dc59bf80f03">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 30.0 0.0 30.0 30.0 4.0 30.0 38.0 4.0 30.0 38.0 0.0 30.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_15E7DF92-F3E4-4AB4-9197-13D25E8CCC67">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b7d2c01f-2762-4f2e-8705-76800105b424">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 38.0 0.0 36.0 38.0 4.0 36.0 30.0 4.0 36.0 30.0 0.0 36.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_18FC09F7-5D80-4EF3-99AF-098DC2CFF4EB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cb52d42d-a3f6-415f-9482-798cde02bda0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 30.0 4.0 33.0 30.0 12.0 33.0 38.0 12.0 30.0 38.0 4.0 30.0 30.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_DFBA50C2-F04C-4B5C-B874-621DD064823F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c215958e-3bef-4c51-b83a-0ec22759ea56">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 38.0 4.0 33.0 38.0 12.0 33.0 30.0 12.0 36.0 30.0 4.0 36.0 38.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_0c5b7867-6d2c-4839-93c2-3e5cb3075502"/>
              <gml:surfaceMember xlink:href="#UUID_c88409d1-a5b2-403e-aa11-3983a5656150"/>
              <gml:surfaceMember xlink:href="#UUID_078db51f-cd25-4ef5-9132-238c131ba3c3"/>
              <gml:surfaceMember xlink:href="#UUID_84acc292-8b68-4a64-87f0-3dc59bf80f03"/>
              <gml:surfaceMember xlink:href="#UUID_b7d2c01f-2762-4f2e-8705-76800105b424"/>
              <gml:surfaceMember xlink:href="#UUID_cb52d42d-a3f6-415f-9482-798cde02bda0"/>
              <gml:surfaceMember xlink:href="#UUID_c215958e-3bef-4c51-b83a-0ec22759ea56"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1907-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2025-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1170</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_6E87EF8E-6BBC-462C-B207-3052B99476FD">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_10CA627E-1BE4-4100-BEBF-C626D66B34DD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0a9efdfa-d195-41ee-8132-ecd2383048ce">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 30.0 0.0 40.0 30.0 0.0 40.0 38.0 0.0 46.0 38.0 0.0 46.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_39AFBE8D-721E-4B0D-9435-E236395D0254">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5650d042-1ee2-4973-8c18-29dc728000bb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 30.0 0.0 46.0 30.0 0.0 46.0 30.0 3.0 43.0 30.0 10.0 40.0 30.0 3.0 40.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_25EBB269-922F-40EA-8748-83506D6B55AC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1c42a1d8-6a0d-4d5c-b1d2-a831b9caba76">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 38.0 0.0 40.0 38.0 0.0 40.0 38.0 3.0 43.0 38.0 10.0 46.0 38.0 3.0 46.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_11BF215F-2D8D-4335-9ACF-C32E44FE9373">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0751e1c9-7887-4d80-aca5-305224b54b7c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 30.0 0.0 40.0 30.0 3.0 40.0 38.0 3.0 40.0 38.0 0.0 40.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D19270A5-EAEE-4C2E-A2C6-8BFD68A642C4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7f0f5cb5-6c3a-4811-9bd2-cf589fadf507">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 38.0 0.0 46.0 38.0 3.0 46.0 30.0 3.0 46.0 30.0 0.0 46.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_DAA15800-E7DF-4AD0-B02B-C604AF7CE730">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_04d14c1d-9607-4125-bd59-d2c52eb28778">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 30.0 3.0 43.0 30.0 10.0 43.0 38.0 10.0 40.0 38.0 3.0 40.0 30.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3F2E0851-3841-4616-AEE2-0D63DDE1876C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a605d056-24e7-4b66-b151-2c1bdf7b81c3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 38.0 3.0 43.0 38.0 10.0 43.0 30.0 10.0 46.0 30.0 3.0 46.0 38.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_0a9efdfa-d195-41ee-8132-ecd2383048ce"/>
              <gml:surfaceMember xlink:href="#UUID_5650d042-1ee2-4973-8c18-29dc728000bb"/>
              <gml:surfaceMember xlink:href="#UUID_1c42a1d8-6a0d-4d5c-b1d2-a831b9caba76"/>
              <gml:surfaceMember xlink:href="#UUID_0751e1c9-7887-4d80-aca5-305224b54b7c"/>
              <gml:surfaceMember xlink:href="#UUID_7f0f5cb5-6c3a-4811-9bd2-cf589fadf507"/>
              <gml:surfaceMember xlink:href="#UUID_04d14c1d-9607-4125-bd59-d2c52eb28778"/>
              <gml:surfaceMember xlink:href="#UUID_a605d056-24e7-4b66-b151-2c1bdf7b81c3"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1917-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2024-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1020</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_6C434530-AB07-4370-9531-D0E2DB662CF3">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_7D2876A1-313B-4D0E-BD1E-BD406874A189">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b6d12e83-8bc0-4811-8693-5a6c0d83fd41">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 30.0 0.0 50.0 30.0 0.0 50.0 38.0 0.0 56.0 38.0 0.0 56.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_032C6481-ECE9-4314-85EA-0267774C3384">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f81fa78a-1406-4285-853b-b9f6e29f5a59">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 30.0 0.0 56.0 30.0 0.0 56.0 30.0 4.0 53.0 30.0 10.0 50.0 30.0 4.0 50.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_24526132-4DF8-416B-BDEF-434EFBB269DA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7ac15c72-8cd6-4adc-b2e4-313df5172ede">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 38.0 0.0 50.0 38.0 0.0 50.0 38.0 4.0 53.0 38.0 10.0 56.0 38.0 4.0 56.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0C48C2D6-8D04-47B1-AFE9-707909313FBF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_628da195-0271-411e-ac90-826a1c79b13b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 30.0 0.0 50.0 30.0 4.0 50.0 38.0 4.0 50.0 38.0 0.0 50.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_52EA5965-543C-4E16-B17D-0AEA327B5C10">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_801701b5-4cd0-4d38-9e9d-360e35599d95">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 38.0 0.0 56.0 38.0 4.0 56.0 30.0 4.0 56.0 30.0 0.0 56.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3EE89BC2-F045-48B9-8F13-F80D39DE770F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7f9589de-4612-4a5e-9dab-27b683155e23">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 30.0 4.0 53.0 30.0 10.0 53.0 38.0 10.0 50.0 38.0 4.0 50.0 30.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_78D5F054-672E-4022-8435-E422F85E11D9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d0438151-4367-46a2-84ac-5f9ad1f3d60d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 38.0 4.0 53.0 38.0 10.0 53.0 30.0 10.0 56.0 30.0 4.0 56.0 38.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_b6d12e83-8bc0-4811-8693-5a6c0d83fd41"/>
              <gml:surfaceMember xlink:href="#UUID_f81fa78a-1406-4285-853b-b9f6e29f5a59"/>
              <gml:surfaceMember xlink:href="#UUID_7ac15c72-8cd6-4adc-b2e4-313df5172ede"/>
              <gml:surfaceMember xlink:href="#UUID_628da195-0271-411e-ac90-826a1c79b13b"/>
              <gml:surfaceMember xlink:href="#UUID_801701b5-4cd0-4d38-9e9d-360e35599d95"/>
              <gml:surfaceMember xlink:href="#UUID_7f9589de-4612-4a5e-9dab-27b683155e23"/>
              <gml:surfaceMember xlink:href="#UUID_d0438151-4367-46a2-84ac-5f9ad1f3d60d"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1975-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2080-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1080</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_5C3871D9-A6B1-43E3-990C-9BD68B32A927">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1E328D89-4773-4D4D-94C0-5AF736B6DCCC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d4bc9f73-76d6-48f0-aa0a-ed15e8db42ef">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 30.0 0.0 60.0 30.0 0.0 60.0 38.0 0.0 66.0 38.0 0.0 66.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B8E37720-BD03-47C8-909B-C37FA2347761">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_123966a4-5aa6-412e-9024-917d4478e75c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 30.0 0.0 66.0 30.0 0.0 66.0 30.0 3.0 63.0 30.0 11.0 60.0 30.0 3.0 60.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_19888B38-EE9F-4CA5-922C-5075707A38AE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c37a1a03-4984-409a-b574-04cee5231c52">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 38.0 0.0 60.0 38.0 0.0 60.0 38.0 3.0 63.0 38.0 11.0 66.0 38.0 3.0 66.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AC11DD54-9DC4-43FC-ACBB-B3A67D736550">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b17e8cb3-3b1a-45dc-97c7-c7b30d9840d3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 30.0 0.0 60.0 30.0 3.0 60.0 38.0 3.0 60.0 38.0 0.0 60.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_01C93476-FE4E-429E-BC17-DA56231EE091">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f5a5011f-a3a0-4ea7-b55d-31e5f3690708">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 38.0 0.0 66.0 38.0 3.0 66.0 30.0 3.0 66.0 30.0 0.0 66.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_8066D0A9-E086-4B3A-907C-91739BEE0A0B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3fd29ff9-d4c6-44e6-a383-f29e690b91ce">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 30.0 3.0 63.0 30.0 11.0 63.0 38.0 11.0 60.0 38.0 3.0 60.0 30.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9EAA6067-FFE5-40E8-AFB2-E7D8BDF34787">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ad42a1d1-d24a-41a0-b005-e4e822b6684a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 38.0 3.0 63.0 38.0 11.0 63.0 30.0 11.0 66.0 30.0 3.0 66.0 38.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_d4bc9f73-76d6-48f0-aa0a-ed15e8db42ef"/>
              <gml:surfaceMember xlink:href="#UUID_123966a4-5aa6-412e-9024-917d4478e75c"/>
              <gml:surfaceMember xlink:href="#UUID_c37a1a03-4984-409a-b574-04cee5231c52"/>
              <gml:surfaceMember xlink:href="#UUID_b17e8cb3-3b1a-45dc-97c7-c7b30d9840d3"/>
              <gml:surfaceMember xlink:href="#UUID_f5a5011f-a3a0-4ea7-b55d-31e5f3690708"/>
              <gml:surfaceMember xlink:href="#UUID_3fd29ff9-d4c6-44e6-a383-f29e690b91ce"/>
              <gml:surfaceMember xlink:href="#UUID_ad42a1d1-d24a-41a0-b005-e4e822b6684a"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1971-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2021-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1110</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_6494D1A5-C2E1-4B77-8500-2822D9C9BA42">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_2518B86F-45BA-4FF5-9722-F592863AF86B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d0f32aec-2031-41bd-a0eb-c872f1613ee6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 30.0 0.0 70.0 30.0 0.0 70.0 38.0 0.0 76.0 38.0 0.0 76.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B73BBE75-7600-4372-AA09-6EEEF1368A6C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_24ee57fb-7fab-44b4-8bb2-cb823e383912">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 30.0 0.0 76.0 30.0 0.0 76.0 30.0 7.0 73.0 30.0 9.0 70.0 30.0 7.0 70.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_02434154-63A1-48CE-A759-3A40B2A1731D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_396c8c28-cf22-4b29-a8b1-71dcd8647ee4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 38.0 0.0 70.0 38.0 0.0 70.0 38.0 7.0 73.0 38.0 9.0 76.0 38.0 7.0 76.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CEBF28A0-8FA8-49CF-AFE4-8F1E80F6A45E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a189af95-ca43-432b-85ac-7fe7f2d8c44f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 30.0 0.0 70.0 30.0 7.0 70.0 38.0 7.0 70.0 38.0 0.0 70.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CCBB41CA-FC2A-454E-A8BB-53A2A4E89840">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cf7a1928-71fc-4c53-acbf-7ede3015cf44">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 38.0 0.0 76.0 38.0 7.0 76.0 30.0 7.0 76.0 30.0 0.0 76.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A5E120E3-1E0D-46F0-86E5-3A7617628863">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b93070a4-3ce8-4a73-a6ef-12a2ab0d7fda">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 30.0 7.0 73.0 30.0 9.0 73.0 38.0 9.0 70.0 38.0 7.0 70.0 30.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2A786AB2-D789-4529-8656-F3B029DDDDB5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0da34363-c719-49db-bcb7-c39cbaa6da67">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 38.0 7.0 73.0 38.0 9.0 73.0 30.0 9.0 76.0 30.0 7.0 76.0 38.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_d0f32aec-2031-41bd-a0eb-c872f1613ee6"/>
              <gml:surfaceMember xlink:href="#UUID_24ee57fb-7fab-44b4-8bb2-cb823e383912"/>
              <gml:surfaceMember xlink:href="#UUID_396c8c28-cf22-4b29-a8b1-71dcd8647ee4"/>
              <gml:surfaceMember xlink:href="#UUID_a189af95-ca43-432b-85ac-7fe7f2d8c44f"/>
              <gml:surfaceMember xlink:href="#UUID_cf7a1928-71fc-4c53-acbf-7ede3015cf44"/>
              <gml:surfaceMember xlink:href="#UUID_b93070a4-3ce8-4a73-a6ef-12a2ab0d7fda"/>
              <gml:surfaceMember xlink:href="#UUID_0da34363-c719-49db-bcb7-c39cbaa6da67"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1970-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2053-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1140</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_C2225566-C8DF-4C5C-93E2-886157B29C11">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_BA1C5FD2-D55D-4DF7-99F6-C7F0248B6035">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5b202a6d-c9bd-45a4-a67a-b4905ef68de8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 30.0 0.0 80.0 30.0 0.0 80.0 38.0 0.0 86.0 38.0 0.0 86.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EBFCC524-AB4D-458B-9BF3-6B84C35A99DB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ae49a415-3380-4e4f-a7f5-fcd91faa9e9c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 30.0 0.0 86.0 30.0 0.0 86.0 30.0 5.0 83.0 30.0 9.0 80.0 30.0 5.0 80.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5DD13253-368B-4BFD-B5CF-A1A0A337A612">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_51eb028e-2bf7-4034-bcb9-4edf3534347b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 38.0 0.0 80.0 38.0 0.0 80.0 38.0 5.0 83.0 38.0 9.0 86.0 38.0 5.0 86.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_ACF16FE0-4E21-4275-8BD3-822DF0AE38F8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c5cf23ff-339a-4dd2-b1b2-d09b163060e2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 30.0 0.0 80.0 30.0 5.0 80.0 38.0 5.0 80.0 38.0 0.0 80.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_93C089FF-99E1-4D5A-B721-7D457F2897BD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_59d68086-adca-43c6-bf3f-7aa4be752795">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 38.0 0.0 86.0 38.0 5.0 86.0 30.0 5.0 86.0 30.0 0.0 86.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9DF0FABB-46E9-4962-BF23-406636DB2C9D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9171ff1d-a0b7-4a0e-bdb5-f2f56c95f776">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 30.0 5.0 83.0 30.0 9.0 83.0 38.0 9.0 80.0 38.0 5.0 80.0 30.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_21D547E5-E003-4EC2-94AD-0966D2086B3E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_02f8d83f-0acb-4401-aefe-f64586444436">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 38.0 5.0 83.0 38.0 9.0 83.0 30.0 9.0 86.0 30.0 5.0 86.0 38.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_5b202a6d-c9bd-45a4-a67a-b4905ef68de8"/>
              <gml:surfaceMember xlink:href="#UUID_ae49a415-3380-4e4f-a7f5-fcd91faa9e9c"/>
              <gml:surfaceMember xlink:href="#UUID_51eb028e-2bf7-4034-bcb9-4edf3534347b"/>
              <gml:surfaceMember xlink:href="#UUID_c5cf23ff-339a-4dd2-b1b2-d09b163060e2"/>
              <gml:surfaceMember xlink:href="#UUID_59d68086-adca-43c6-bf3f-7aa4be752795"/>
              <gml:surfaceMember xlink:href="#UUID_9171ff1d-a0b7-4a0e-bdb5-f2f56c95f776"/>
              <gml:surfaceMember xlink:href="#UUID_02f8d83f-0acb-4401-aefe-f64586444436"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1912-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2072-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1170</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_04942F0F-2C8C-49ED-B111-4C9994196C91">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-3-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_50F6A987-6783-473D-AEA0-56F77923A294">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a9d1b86a-7414-4129-b2c9-32b0d7068c3a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 30.0 0.0 90.0 30.0 0.0 90.0 38.0 0.0 96.0 38.0 0.0 96.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_90123641-ECC2-475C-AEC6-AC1CF91CAE54">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_da527cb2-c325-4f48-b755-b3aee3abe008">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 30.0 0.0 96.0 30.0 0.0 96.0 30.0 3.0 93.0 30.0 8.0 90.0 30.0 3.0 90.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BB43FC30-4341-47A7-920B-FCDD2DCB4FC3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a59b7aa6-8d3d-4ae0-8e53-dfcb835fc5c5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 38.0 0.0 90.0 38.0 0.0 90.0 38.0 3.0 93.0 38.0 8.0 96.0 38.0 3.0 96.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_F993C620-FBEB-413F-B581-BDA1EFD33940">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3e43f18b-c7af-4c2b-a555-14ac64ee6444">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 30.0 0.0 90.0 30.0 3.0 90.0 38.0 3.0 90.0 38.0 0.0 90.0 30.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4235B2D4-0AD6-4289-8F0C-20C5D70611C6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_33ff0a56-2904-44f5-9107-7e4eac6d1258">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 38.0 0.0 96.0 38.0 3.0 96.0 30.0 3.0 96.0 30.0 0.0 96.0 38.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B445D519-C6DF-4769-9DC5-626DEEDC18FB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_60a26b7c-3237-4ab2-9d46-ca4859cdaeb9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 30.0 3.0 93.0 30.0 8.0 93.0 38.0 8.0 90.0 38.0 3.0 90.0 30.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5EBEB0CC-294D-40B3-9AEB-64980870CC01">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0dc5f002-549d-43b1-8781-07e9d412cb68">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 38.0 3.0 93.0 38.0 8.0 93.0 30.0 8.0 96.0 30.0 3.0 96.0 38.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_a9d1b86a-7414-4129-b2c9-32b0d7068c3a"/>
              <gml:surfaceMember xlink:href="#UUID_da527cb2-c325-4f48-b755-b3aee3abe008"/>
              <gml:surfaceMember xlink:href="#UUID_a59b7aa6-8d3d-4ae0-8e53-dfcb835fc5c5"/>
              <gml:surfaceMember xlink:href="#UUID_3e43f18b-c7af-4c2b-a555-14ac64ee6444"/>
              <gml:surfaceMember xlink:href="#UUID_33ff0a56-2904-44f5-9107-7e4eac6d1258"/>
              <gml:surfaceMember xlink:href="#UUID_60a26b7c-3237-4ab2-9d46-ca4859cdaeb9"/>
              <gml:surfaceMember xlink:href="#UUID_0dc5f002-549d-43b1-8781-07e9d412cb68"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1996-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2063-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1080</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_CF1B287C-6875-44CD-B115-B8972C1B64B7">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_EA394E7D-152E-49CB-91BA-0173CE8B796F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d7506487-f703-4d7c-9b9d-c9f3e9664490">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 40.0 0.0 0.0 40.0 0.0 0.0 48.0 0.0 6.0 48.0 0.0 6.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B5594D9E-4AD6-4FAD-BEA8-422A4F011E54">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7e3685d9-26ee-4d2c-91bd-29a350ddc899">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 40.0 0.0 6.0 40.0 0.0 6.0 40.0 4.0 3.0 40.0 9.0 0.0 40.0 4.0 0.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6F1B3A71-02C6-4E05-BBF4-97EC9FE42792">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8d6880ff-98ad-4f33-963c-8431ab092195">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 48.0 0.0 0.0 48.0 0.0 0.0 48.0 4.0 3.0 48.0 9.0 6.0 48.0 4.0 6.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_74C7BBDD-E906-46F9-9B94-FD28DE4C0204">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_245298b5-4d7b-4b8f-a361-316bd76927c7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 40.0 0.0 0.0 40.0 4.0 0.0 48.0 4.0 0.0 48.0 0.0 0.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C6C7570E-E49F-45ED-A2CE-20325FF1DCD0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b6e0becf-6fe2-4800-aae0-2c9900836d79">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 48.0 0.0 6.0 48.0 4.0 6.0 40.0 4.0 6.0 40.0 0.0 6.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5E75FD85-21C1-40FC-A56D-F271927C9564">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_743334ae-7f83-41fd-9784-bb6414d26667">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 40.0 4.0 3.0 40.0 9.0 3.0 48.0 9.0 0.0 48.0 4.0 0.0 40.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F4975F2A-8D31-429E-B023-D074D8DD637B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_52847b3c-f681-47b9-9d45-0861785150c2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 48.0 4.0 3.0 48.0 9.0 3.0 40.0 9.0 6.0 40.0 4.0 6.0 48.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_d7506487-f703-4d7c-9b9d-c9f3e9664490"/>
              <gml:surfaceMember xlink:href="#UUID_7e3685d9-26ee-4d2c-91bd-29a350ddc899"/>
              <gml:surfaceMember xlink:href="#UUID_8d6880ff-98ad-4f33-963c-8431ab092195"/>
              <gml:surfaceMember xlink:href="#UUID_245298b5-4d7b-4b8f-a361-316bd76927c7"/>
              <gml:surfaceMember xlink:href="#UUID_b6e0becf-6fe2-4800-aae0-2c9900836d79"/>
              <gml:surfaceMember xlink:href="#UUID_743334ae-7f83-41fd-9784-bb6414d26667"/>
              <gml:surfaceMember xlink:href="#UUID_52847b3c-f681-47b9-9d45-0861785150c2"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1928-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2060-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_AB6C3C5B-940D-4F2E-B096-208E7AC1C891">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_E40A678D-53AF-4D57-B4A9-8630E4D0837A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_aee3b74c-fa63-4efd-a274-091bd7379513">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 40.0 0.0 10.0 40.0 0.0 10.0 48.0 0.0 16.0 48.0 0.0 16.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_20DD6F08-030E-4A5D-AFC3-9D174BBA5D7C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d3ddd038-8b95-4a5b-ba18-00283144b1ef">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 40.0 0.0 16.0 40.0 0.0 16.0 40.0 5.0 13.0 40.0 12.0 10.0 40.0 5.0 10.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C0C6D0DD-BB88-4A54-B636-92C4027F6D6D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6f4e8386-6f4a-4a96-9a94-0ef9a768d2b2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 48.0 0.0 10.0 48.0 0.0 10.0 48.0 5.0 13.0 48.0 12.0 16.0 48.0 5.0 16.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_08432EC6-68AB-4045-924B-7B8F17D809A7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_eaf94d8f-80e9-4d64-9a2b-25ccb6b831c3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 40.0 0.0 10.0 40.0 5.0 10.0 48.0 5.0 10.0 48.0 0.0 10.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_386AE890-DF74-49FC-8796-B0675B08B4FC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e0a1441d-9ac7-4187-80f4-126c55e46043">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 48.0 0.0 16.0 48.0 5.0 16.0 40.0 5.0 16.0 40.0 0.0 16.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_11344BC6-D9CE-46B1-A0F5-9D061FE8C95E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bd27f68e-f41d-4b0e-9416-1d43ee415114">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 40.0 5.0 13.0 40.0 12.0 13.0 48.0 12.0 10.0 48.0 5.0 10.0 40.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2E841137-E654-4510-B88A-5F4704BCC798">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fca97340-70b7-46da-8f39-3f5a6b75934c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 48.0 5.0 13.0 48.0 12.0 13.0 40.0 12.0 16.0 40.0 5.0 16.0 48.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_aee3b74c-fa63-4efd-a274-091bd7379513"/>
              <gml:surfaceMember xlink:href="#UUID_d3ddd038-8b95-4a5b-ba18-00283144b1ef"/>
              <gml:surfaceMember xlink:href="#UUID_6f4e8386-6f4a-4a96-9a94-0ef9a768d2b2"/>
              <gml:surfaceMember xlink:href="#UUID_eaf94d8f-80e9-4d64-9a2b-25ccb6b831c3"/>
              <gml:surfaceMember xlink:href="#UUID_e0a1441d-9ac7-4187-80f4-126c55e46043"/>
              <gml:surfaceMember xlink:href="#UUID_bd27f68e-f41d-4b0e-9416-1d43ee415114"/>
              <gml:surfaceMember xlink:href="#UUID_fca97340-70b7-46da-8f39-3f5a6b75934c"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1966-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2055-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1160</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_EC3964ED-8BF8-463D-BB7F-1B4B524BEF59">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_B38270CB-8398-4B6E-8D06-8F9B613AA66D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_db889059-b804-4d0d-834e-7cca797a54b4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 40.0 0.0 20.0 40.0 0.0 20.0 48.0 0.0 26.0 48.0 0.0 26.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_65F69799-2843-4E1C-9EDA-8B847F8F89FA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_474c7eb8-e354-47c4-b41f-26709147d943">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 40.0 0.0 26.0 40.0 0.0 26.0 40.0 6.0 23.0 40.0 11.0 20.0 40.0 6.0 20.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4EB8BBDF-1318-4722-98EE-5D28F346166B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_55bd300b-f0a0-4f9e-b839-ae143a6a3416">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 48.0 0.0 20.0 48.0 0.0 20.0 48.0 6.0 23.0 48.0 11.0 26.0 48.0 6.0 26.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7837D1CF-AB4B-405F-831A-9180DEE4F3D8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a192f9a1-11f8-4aa9-a6a4-520c1f1d0bfe">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 40.0 0.0 20.0 40.0 6.0 20.0 48.0 6.0 20.0 48.0 0.0 20.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FFF8CBFB-DD71-4131-AA08-FA5BD7707A2F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0d5bf99b-fe66-4bd9-9123-619bd697e073">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 48.0 0.0 26.0 48.0 6.0 26.0 40.0 6.0 26.0 40.0 0.0 26.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5AF8014B-F7B0-4951-833C-EFDB44C93B2D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_54c6435d-effd-4e3b-aba2-a0851da39623">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 40.0 6.0 23.0 40.0 11.0 23.0 48.0 11.0 20.0 48.0 6.0 20.0 40.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9E8D7CD2-B985-4C6A-9CAE-ED8AD0BFF57D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6355243f-e7a2-456c-ac27-2f7b64996848">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 48.0 6.0 23.0 48.0 11.0 23.0 40.0 11.0 26.0 40.0 6.0 26.0 48.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_db889059-b804-4d0d-834e-7cca797a54b4"/>
              <gml:surfaceMember xlink:href="#UUID_474c7eb8-e354-47c4-b41f-26709147d943"/>
              <gml:surfaceMember xlink:href="#UUID_55bd300b-f0a0-4f9e-b839-ae143a6a3416"/>
              <gml:surfaceMember xlink:href="#UUID_a192f9a1-11f8-4aa9-a6a4-520c1f1d0bfe"/>
              <gml:surfaceMember xlink:href="#UUID_0d5bf99b-fe66-4bd9-9123-619bd697e073"/>
              <gml:surfaceMember xlink:href="#UUID_54c6435d-effd-4e3b-aba2-a0851da39623"/>
              <gml:surfaceMember xlink:href="#UUID_6355243f-e7a2-456c-ac27-2f7b64996848"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1916-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2038-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_AB56DFA1-66E6-46A3-A5E2-2AA6830AAE11">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_28AA5E54-3E01-4DEA-833C-B001C62B3204">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9e45aec2-33a2-4619-a86d-daa748e11679">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 40.0 0.0 30.0 40.0 0.0 30.0 48.0 0.0 36.0 48.0 0.0 36.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4045DC32-5971-40B7-8ED5-D0F664A5CC99">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c7ac4af1-3ad7-441e-a882-fceb743cf180">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 40.0 0.0 36.0 40.0 0.0 36.0 40.0 5.0 33.0 40.0 8.0 30.0 40.0 5.0 30.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_20C2F61E-C2F6-4FA0-8914-D99E04DA60DF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_22377978-352d-41f6-80a0-36893e739a7e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 48.0 0.0 30.0 48.0 0.0 30.0 48.0 5.0 33.0 48.0 8.0 36.0 48.0 5.0 36.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7769CE83-5F23-4F6E-8767-9495245AA4F8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b7334e61-ebab-4ba5-abd2-e3d9c8892214">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 40.0 0.0 30.0 40.0 5.0 30.0 48.0 5.0 30.0 48.0 0.0 30.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5A54AC4E-563A-46C1-AC08-E1074731CC17">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c8498b86-97c4-45a4-9777-0bc091548448">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 48.0 0.0 36.0 48.0 5.0 36.0 40.0 5.0 36.0 40.0 0.0 36.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_4E75A8D7-C9B1-4279-A186-3A43E36462CE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_80fc0d6b-02e4-42f2-a126-a061d32afc71">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 40.0 5.0 33.0 40.0 8.0 33.0 48.0 8.0 30.0 48.0 5.0 30.0 40.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C9C2932C-D519-4D03-9680-43951BA9C69C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6e7fb11e-4ca2-4b35-821b-827065c54ea0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 48.0 5.0 33.0 48.0 8.0 33.0 40.0 8.0 36.0 40.0 5.0 36.0 48.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_9e45aec2-33a2-4619-a86d-daa748e11679"/>
              <gml:surfaceMember xlink:href="#UUID_c7ac4af1-3ad7-441e-a882-fceb743cf180"/>
              <gml:surfaceMember xlink:href="#UUID_22377978-352d-41f6-80a0-36893e739a7e"/>
              <gml:surfaceMember xlink:href="#UUID_b7334e61-ebab-4ba5-abd2-e3d9c8892214"/>
              <gml:surfaceMember xlink:href="#UUID_c8498b86-97c4-45a4-9777-0bc091548448"/>
              <gml:surfaceMember xlink:href="#UUID_80fc0d6b-02e4-42f2-a126-a061d32afc71"/>
              <gml:surfaceMember xlink:href="#UUID_6e7fb11e-4ca2-4b35-821b-827065c54ea0"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1980-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2046-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1140</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_681BF087-1B5F-4DDD-902B-6599177F70D1">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_277960E7-51BA-4016-A5A3-D21990CE938E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_262da6e8-23ad-43b4-85a3-389e3dd5850c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 40.0 0.0 40.0 40.0 0.0 40.0 48.0 0.0 46.0 48.0 0.0 46.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_157C19D1-D069-4253-9C21-6BBEF47E564C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4aa7bc95-a5a8-4c8b-af75-7d83b8b6c214">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 40.0 0.0 46.0 40.0 0.0 46.0 40.0 7.0 43.0 40.0 11.0 40.0 40.0 7.0 40.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_242D5A2D-6FA3-4C2D-9455-C7CFB4332190">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d60e9bd8-ceef-4a8d-a284-8e8eaa703d6c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 48.0 0.0 40.0 48.0 0.0 40.0 48.0 7.0 43.0 48.0 11.0 46.0 48.0 7.0 46.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EE84CA84-E1FE-44D9-BE6E-CB40B68E65D3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b44f1bc0-6cbd-4728-97d7-a25a07aeae4d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 40.0 0.0 40.0 40.0 7.0 40.0 48.0 7.0 40.0 48.0 0.0 40.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_05209C30-EC00-4A5F-92B7-D7BC67D7E177">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_36652b74-96d2-435d-8aac-158dcd4ed22f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 48.0 0.0 46.0 48.0 7.0 46.0 40.0 7.0 46.0 40.0 0.0 46.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_699043C6-1F38-4413-A1AF-F858BDEBDDBC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_56acd292-abd6-40a2-a9a0-958669b86e27">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 40.0 7.0 43.0 40.0 11.0 43.0 48.0 11.0 40.0 48.0 7.0 40.0 40.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_71205937-32EA-447E-8526-31CBC9744723">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d7d75282-1e6a-4ca0-84e1-19da81885d9e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 48.0 7.0 43.0 48.0 11.0 43.0 40.0 11.0 46.0 40.0 7.0 46.0 48.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_262da6e8-23ad-43b4-85a3-389e3dd5850c"/>
              <gml:surfaceMember xlink:href="#UUID_4aa7bc95-a5a8-4c8b-af75-7d83b8b6c214"/>
              <gml:surfaceMember xlink:href="#UUID_d60e9bd8-ceef-4a8d-a284-8e8eaa703d6c"/>
              <gml:surfaceMember xlink:href="#UUID_b44f1bc0-6cbd-4728-97d7-a25a07aeae4d"/>
              <gml:surfaceMember xlink:href="#UUID_36652b74-96d2-435d-8aac-158dcd4ed22f"/>
              <gml:surfaceMember xlink:href="#UUID_56acd292-abd6-40a2-a9a0-958669b86e27"/>
              <gml:surfaceMember xlink:href="#UUID_d7d75282-1e6a-4ca0-84e1-19da81885d9e"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1942-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2030-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1160</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_8DDCB7B1-7FB3-4A71-A38F-5BBE145C5A82">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_CC1514F4-87AC-4375-B82A-76953C57DCB8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_04964b72-1a77-4ca6-9585-8b997ca5ee8b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 40.0 0.0 50.0 40.0 0.0 50.0 48.0 0.0 56.0 48.0 0.0 56.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C9B7241D-28C2-408E-AEBB-523E2F861292">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f35f046c-25c6-413a-9c35-847935f55eeb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 40.0 0.0 56.0 40.0 0.0 56.0 40.0 5.0 53.0 40.0 11.0 50.0 40.0 5.0 50.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_ED12528D-3A1D-412C-9A6D-7C2691ABF395">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_909b8284-96aa-4a29-b150-78429268c753">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 48.0 0.0 50.0 48.0 0.0 50.0 48.0 5.0 53.0 48.0 11.0 56.0 48.0 5.0 56.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_76C8A221-72C4-44BD-927A-EB5C2CF4C471">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b42ea6cb-2f97-4c06-88d0-b755ec690d5a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 40.0 0.0 50.0 40.0 5.0 50.0 48.0 5.0 50.0 48.0 0.0 50.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_017C9CC3-299E-4636-A5FF-813313917B1B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ef18049d-d151-4131-8273-39a29ba8c00d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 48.0 0.0 56.0 48.0 5.0 56.0 40.0 5.0 56.0 40.0 0.0 56.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A47F59BC-9CA6-428F-844C-FC8DD372D082">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fbb8d947-f79c-4762-8c11-aa511294a554">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 40.0 5.0 53.0 40.0 11.0 53.0 48.0 11.0 50.0 48.0 5.0 50.0 40.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_CBEC3E06-0803-46C1-8316-C613631D2F0A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_03cdbe5e-31ec-4c5d-aa47-a71d6d3a7f26">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 48.0 5.0 53.0 48.0 11.0 53.0 40.0 11.0 56.0 40.0 5.0 56.0 48.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_04964b72-1a77-4ca6-9585-8b997ca5ee8b"/>
              <gml:surfaceMember xlink:href="#UUID_f35f046c-25c6-413a-9c35-847935f55eeb"/>
              <gml:surfaceMember xlink:href="#UUID_909b8284-96aa-4a29-b150-78429268c753"/>
              <gml:surfaceMember xlink:href="#UUID_b42ea6cb-2f97-4c06-88d0-b755ec690d5a"/>
              <gml:surfaceMember xlink:href="#UUID_ef18049d-d151-4131-8273-39a29ba8c00d"/>
              <gml:surfaceMember xlink:href="#UUID_fbb8d947-f79c-4762-8c11-aa511294a554"/>
              <gml:surfaceMember xlink:href="#UUID_03cdbe5e-31ec-4c5d-aa47-a71d6d3a7f26"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1917-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2033-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1000</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_34396898-6918-4925-84C4-0712F7BF31E6">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_930A2465-2C00-4617-A200-CECEE154BAC5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a31de2e0-ce11-4d88-8b3e-ff0606857ac1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 40.0 0.0 60.0 40.0 0.0 60.0 48.0 0.0 66.0 48.0 0.0 66.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BFEB2A8E-54C8-4062-A867-B6338216F6D4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d39fdb04-187c-4c69-bdcd-afaaaa71e299">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 40.0 0.0 66.0 40.0 0.0 66.0 40.0 4.0 63.0 40.0 8.0 60.0 40.0 4.0 60.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9D1C6A87-0C51-4910-827A-6A3E2B748BD0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b714f5ee-331b-4ac8-88a6-574e870c7fde">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 48.0 0.0 60.0 48.0 0.0 60.0 48.0 4.0 63.0 48.0 8.0 66.0 48.0 4.0 66.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C6E38BAF-2EEF-450C-B9AB-1910010FDE23">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3131aeff-d7cc-47bb-b9f6-c5b7e754b607">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 40.0 0.0 60.0 40.0 4.0 60.0 48.0 4.0 60.0 48.0 0.0 60.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B17DAD0F-1F4C-4D95-A776-DFB5C0A99AB2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b55f39c3-184a-4dcb-875d-eb89f14e2d81">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 48.0 0.0 66.0 48.0 4.0 66.0 40.0 4.0 66.0 40.0 0.0 66.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C2969C82-8F84-4573-9606-13BE7D974AEC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3402edca-89fd-45a7-b85f-1cd1b75f0f2b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 40.0 4.0 63.0 40.0 8.0 63.0 48.0 8.0 60.0 48.0 4.0 60.0 40.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_EC7C69FD-DC4C-478F-851E-BA2D292B7194">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7684a66a-6007-4a84-898a-0a9202a24a26">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 48.0 4.0 63.0 48.0 8.0 63.0 40.0 8.0 66.0 40.0 4.0 66.0 48.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_a31de2e0-ce11-4d88-8b3e-ff0606857ac1"/>
              <gml:surfaceMember xlink:href="#UUID_d39fdb04-187c-4c69-bdcd-afaaaa71e299"/>
              <gml:surfaceMember xlink:href="#UUID_b714f5ee-331b-4ac8-88a6-574e870c7fde"/>
              <gml:surfaceMember xlink:href="#UUID_3131aeff-d7cc-47bb-b9f6-c5b7e754b607"/>
              <gml:surfaceMember xlink:href="#UUID_b55f39c3-184a-4dcb-875d-eb89f14e2d81"/>
              <gml:surfaceMember xlink:href="#UUID_3402edca-89fd-45a7-b85f-1cd1b75f0f2b"/>
              <gml:surfaceMember xlink:href="#UUID_7684a66a-6007-4a84-898a-0a9202a24a26"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1985-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2060-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1120</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_A813923B-DD8F-4936-A79C-A4FDE3C80951">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_A6F126F2-1E14-447E-AC10-352BC20CC7A6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_581fddfe-181f-4610-93e7-6b5605ff30fd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 40.0 0.0 70.0 40.0 0.0 70.0 48.0 0.0 76.0 48.0 0.0 76.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8FDB9F04-7A0B-44CE-AD19-2FC93FC2EA2B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_08209b57-aae2-4986-a288-862f01af36f8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 40.0 0.0 76.0 40.0 0.0 76.0 40.0 4.0 73.0 40.0 9.0 70.0 40.0 4.0 70.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D821665C-DF7C-4316-BA91-6999B50F5090">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2d3c1643-489c-4a87-a113-6017656cca07">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 48.0 0.0 70.0 48.0 0.0 70.0 48.0 4.0 73.0 48.0 9.0 76.0 48.0 4.0 76.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AAF5831A-7F11-4C74-8CAF-599F366B4A60">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0625f35d-9136-4a4e-8099-7cc7cca0f39e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 40.0 0.0 70.0 40.0 4.0 70.0 48.0 4.0 70.0 48.0 0.0 70.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0858BB1E-E2F0-4AF7-B170-CADE80DBF9D9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c107c050-080d-404f-9c70-ebf4c60d0957">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 48.0 0.0 76.0 48.0 4.0 76.0 40.0 4.0 76.0 40.0 0.0 76.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_316CF3CE-3108-46E6-8003-FFC6AF4C7BEA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b60411bb-0287-4c0e-9fe4-74157f3bbe93">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 40.0 4.0 73.0 40.0 9.0 73.0 48.0 9.0 70.0 48.0 4.0 70.0 40.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_37F5D2BF-E6C4-45AB-923F-518557FDD20B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8f96350a-de9d-45a5-af02-cfc5c2bbe4e9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 48.0 4.0 73.0 48.0 9.0 73.0 40.0 9.0 76.0 40.0 4.0 76.0 48.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_581fddfe-181f-4610-93e7-6b5605ff30fd"/>
              <gml:surfaceMember xlink:href="#UUID_08209b57-aae2-4986-a288-862f01af36f8"/>
              <gml:surfaceMember xlink:href="#UUID_2d3c1643-489c-4a87-a113-6017656cca07"/>
              <gml:surfaceMember xlink:href="#UUID_0625f35d-9136-4a4e-8099-7cc7cca0f39e"/>
              <gml:surfaceMember xlink:href="#UUID_c107c050-080d-404f-9c70-ebf4c60d0957"/>
              <gml:surfaceMember xlink:href="#UUID_b60411bb-0287-4c0e-9fe4-74157f3bbe93"/>
              <gml:surfaceMember xlink:href="#UUID_8f96350a-de9d-45a5-af02-cfc5c2bbe4e9"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1922-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2056-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1140</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_E75AD2FB-D172-410E-B730-1A10AB542AD5">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_2E6420E9-9C22-493E-AF1E-83EBB9C437C5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a33db56b-232b-4217-afe4-e98910fa5817">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 40.0 0.0 80.0 40.0 0.0 80.0 48.0 0.0 86.0 48.0 0.0 86.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5C70ED01-FCE3-4F2F-B1B1-ABB685D2D4F6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_db6fa55e-c859-4aa8-ba67-9aa44a3a0470">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 40.0 0.0 86.0 40.0 0.0 86.0 40.0 4.0 83.0 40.0 11.0 80.0 40.0 4.0 80.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6329AE69-DF5E-47B6-B7CC-76DD21FC5191">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5bcfccc9-ab2f-4207-b98d-aea519debefc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 48.0 0.0 80.0 48.0 0.0 80.0 48.0 4.0 83.0 48.0 11.0 86.0 48.0 4.0 86.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2801278A-2D53-4AEA-AA76-7C0D7BDD2C93">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1bc12656-213c-4e05-b298-ee2d1942a2ae">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 40.0 0.0 80.0 40.0 4.0 80.0 48.0 4.0 80.0 48.0 0.0 80.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B6C6CF49-1BE4-4029-AF96-5003C2BFB705">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_938322c2-d4bf-4ccf-9cb6-d2b7a9c24520">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 48.0 0.0 86.0 48.0 4.0 86.0 40.0 4.0 86.0 40.0 0.0 86.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_63E7560D-96BA-46AA-BA0D-217C2C223BE3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_95d21db6-19cc-45db-9041-9b9aec40315a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 40.0 4.0 83.0 40.0 11.0 83.0 48.0 11.0 80.0 48.0 4.0 80.0 40.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_E8B7011B-9310-4A93-BC2F-6388EF825E96">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8df46579-0149-46c4-bb45-70fb2923e11c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 48.0 4.0 83.0 48.0 11.0 83.0 40.0 11.0 86.0 40.0 4.0 86.0 48.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_a33db56b-232b-4217-afe4-e98910fa5817"/>
              <gml:surfaceMember xlink:href="#UUID_db6fa55e-c859-4aa8-ba67-9aa44a3a0470"/>
              <gml:surfaceMember xlink:href="#UUID_5bcfccc9-ab2f-4207-b98d-aea519debefc"/>
              <gml:surfaceMember xlink:href="#UUID_1bc12656-213c-4e05-b298-ee2d1942a2ae"/>
              <gml:surfaceMember xlink:href="#UUID_938322c2-d4bf-4ccf-9cb6-d2b7a9c24520"/>
              <gml:surfaceMember xlink:href="#UUID_95d21db6-19cc-45db-9041-9b9aec40315a"/>
              <gml:surfaceMember xlink:href="#UUID_8df46579-0149-46c4-bb45-70fb2923e11c"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1986-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2067-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_BC2F603C-2ECD-47AE-88DD-C4C0DD3DF450">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-4-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_7BC4A1A1-992F-4CBF-A5F6-9006B91DBDA2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_80b3ca94-c2ff-4498-ba31-e0295eb56de3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 40.0 0.0 90.0 40.0 0.0 90.0 48.0 0.0 96.0 48.0 0.0 96.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_ADDC2436-C9B9-49CF-A97D-0D49B74E4BD0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5cb97d07-583e-4604-98d7-5e90de5c5355">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 40.0 0.0 96.0 40.0 0.0 96.0 40.0 7.0 93.0 40.0 9.0 90.0 40.0 7.0 90.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FE82BB3B-E8F3-4031-9D1C-6C24FA0B22A2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5aece901-0d36-4c29-95c7-647df25a7a73">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 48.0 0.0 90.0 48.0 0.0 90.0 48.0 7.0 93.0 48.0 9.0 96.0 48.0 7.0 96.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C7530B62-BE3C-46A7-A2A1-3DD030BDDEF9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4a1dca78-f9d2-4c60-bf85-8d7bccd419b8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 40.0 0.0 90.0 40.0 7.0 90.0 48.0 7.0 90.0 48.0 0.0 90.0 40.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4C7A9F62-D654-4742-9FBF-BD4DDCFC4E8A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_edf5f559-935e-4233-bfbf-8b7927484363">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 48.0 0.0 96.0 48.0 7.0 96.0 40.0 7.0 96.0 40.0 0.0 96.0 48.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B19F8234-5E5A-4588-95EE-63414F910A01">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b23824d5-fed4-4d2a-b8ce-72a2fa5f4d04">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 40.0 7.0 93.0 40.0 9.0 93.0 48.0 9.0 90.0 48.0 7.0 90.0 40.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C58D8E34-7812-4F61-9B81-60130CFB8946">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7acc319e-e5bc-4278-9b3a-531c5c097778">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 48.0 7.0 93.0 48.0 9.0 93.0 40.0 9.0 96.0 40.0 7.0 96.0 48.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_80b3ca94-c2ff-4498-ba31-e0295eb56de3"/>
              <gml:surfaceMember xlink:href="#UUID_5cb97d07-583e-4604-98d7-5e90de5c5355"/>
              <gml:surfaceMember xlink:href="#UUID_5aece901-0d36-4c29-95c7-647df25a7a73"/>
              <gml:surfaceMember xlink:href="#UUID_4a1dca78-f9d2-4c60-bf85-8d7bccd419b8"/>
              <gml:surfaceMember xlink:href="#UUID_edf5f559-935e-4233-bfbf-8b7927484363"/>
              <gml:surfaceMember xlink:href="#UUID_b23824d5-fed4-4d2a-b8ce-72a2fa5f4d04"/>
              <gml:surfaceMember xlink:href="#UUID_7acc319e-e5bc-4278-9b3a-531c5c097778"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1926-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2034-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1050</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_D0F7FFBE-8014-4A94-913B-AF09C361932E">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_2FCA54E1-3D4E-4960-85D5-D7716EC18CF5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0d050b49-de86-4303-ac6e-1b13dd23819c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 50.0 0.0 0.0 50.0 0.0 0.0 58.0 0.0 6.0 58.0 0.0 6.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_F724F93E-3C11-41DB-B56C-DA18F47652F1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_273b9155-da68-4384-b5e9-2a30980b5296">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 50.0 0.0 6.0 50.0 0.0 6.0 50.0 7.0 3.0 50.0 11.0 0.0 50.0 7.0 0.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E930F876-55EE-4E35-A366-7C4D3A3EF7F3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9a04d299-65c3-4ce2-a213-96570b6082ad">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 58.0 0.0 0.0 58.0 0.0 0.0 58.0 7.0 3.0 58.0 11.0 6.0 58.0 7.0 6.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_49758847-4681-4054-84BB-82EB59A39872">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f2701e13-0ff3-411f-b51f-cdf2f7b6807e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 50.0 0.0 0.0 50.0 7.0 0.0 58.0 7.0 0.0 58.0 0.0 0.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FD3D9AEE-C2BC-4809-A58D-6649599A5E90">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3fb1abda-c5bb-4433-a9d8-85156da8b19a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 58.0 0.0 6.0 58.0 7.0 6.0 50.0 7.0 6.0 50.0 0.0 6.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A0F18ECC-5B75-45AE-AE15-F88233ADAB7D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a9cbf336-e1d9-4c12-88a9-60b7885694a6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 50.0 7.0 3.0 50.0 11.0 3.0 58.0 11.0 0.0 58.0 7.0 0.0 50.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9D4CEA9E-DA18-456D-94E8-909855538831">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9cd83e2c-b137-4359-b285-f6c77e3d25a5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 58.0 7.0 3.0 58.0 11.0 3.0 50.0 11.0 6.0 50.0 7.0 6.0 58.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_0d050b49-de86-4303-ac6e-1b13dd23819c"/>
              <gml:surfaceMember xlink:href="#UUID_273b9155-da68-4384-b5e9-2a30980b5296"/>
              <gml:surfaceMember xlink:href="#UUID_9a04d299-65c3-4ce2-a213-96570b6082ad"/>
              <gml:surfaceMember xlink:href="#UUID_f2701e13-0ff3-411f-b51f-cdf2f7b6807e"/>
              <gml:surfaceMember xlink:href="#UUID_3fb1abda-c5bb-4433-a9d8-85156da8b19a"/>
              <gml:surfaceMember xlink:href="#UUID_a9cbf336-e1d9-4c12-88a9-60b7885694a6"/>
              <gml:surfaceMember xlink:href="#UUID_9cd83e2c-b137-4359-b285-f6c77e3d25a5"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1970-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2052-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1050</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_4A82AB6B-4A16-447B-B7CA-D319D4BF2113">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_780380E6-F4AE-44CB-B07B-7F1BE4AF02F9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0207384d-7a0b-4a32-a132-8ce1c8ab4854">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 50.0 0.0 10.0 50.0 0.0 10.0 58.0 0.0 16.0 58.0 0.0 16.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FB6675E8-0BEE-4AF4-BB5C-EEAAEB8450F1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5800ec0b-9a00-4004-9ddb-bca2dcc0f768">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 50.0 0.0 16.0 50.0 0.0 16.0 50.0 3.0 13.0 50.0 10.0 10.0 50.0 3.0 10.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D7CC37BB-C087-4A03-B60D-9770F5CD4B48">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f28074f5-a270-48fa-8676-298f7a4f8099">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 58.0 0.0 10.0 58.0 0.0 10.0 58.0 3.0 13.0 58.0 10.0 16.0 58.0 3.0 16.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EE38B10E-C38F-4CFC-B79B-387F0E534896">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_83d0ca96-b50c-4f6a-8685-ee1f9b6a68e2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 50.0 0.0 10.0 50.0 3.0 10.0 58.0 3.0 10.0 58.0 0.0 10.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_43E64D3A-A8E9-46E1-8BBB-33E9F323C48D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_efc64a78-45af-4f64-b2de-22d31281a7f3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 58.0 0.0 16.0 58.0 3.0 16.0 50.0 3.0 16.0 50.0 0.0 16.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_7412CA32-9604-418F-A8AF-983BB3CDBA0E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_11d1e7ef-ff2c-45bb-8c5c-9044f28a1a8a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 50.0 3.0 13.0 50.0 10.0 13.0 58.0 10.0 10.0 58.0 3.0 10.0 50.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5E8A4EBD-1F85-4EAF-95C6-6B028802E9A2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e0a48d27-c8fe-42b8-a02e-2de1f847f8bd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 58.0 3.0 13.0 58.0 10.0 13.0 50.0 10.0 16.0 50.0 3.0 16.0 58.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_0207384d-7a0b-4a32-a132-8ce1c8ab4854"/>
              <gml:surfaceMember xlink:href="#UUID_5800ec0b-9a00-4004-9ddb-bca2dcc0f768"/>
              <gml:surfaceMember xlink:href="#UUID_f28074f5-a270-48fa-8676-298f7a4f8099"/>
              <gml:surfaceMember xlink:href="#UUID_83d0ca96-b50c-4f6a-8685-ee1f9b6a68e2"/>
              <gml:surfaceMember xlink:href="#UUID_efc64a78-45af-4f64-b2de-22d31281a7f3"/>
              <gml:surfaceMember xlink:href="#UUID_11d1e7ef-ff2c-45bb-8c5c-9044f28a1a8a"/>
              <gml:surfaceMember xlink:href="#UUID_e0a48d27-c8fe-42b8-a02e-2de1f847f8bd"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1934-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2077-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_6E17750D-C29D-4637-B873-D90E04B226AA">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_0DB22C62-37ED-4AC3-AFA4-590532347D6F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c59d806b-adb7-4507-8a0e-7e42b36a481e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 50.0 0.0 20.0 50.0 0.0 20.0 58.0 0.0 26.0 58.0 0.0 26.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7CB61194-B517-487E-9B57-45CF42B64B05">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cd48d0cf-0560-4cf0-8fae-4df9cff0e9b5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 50.0 0.0 26.0 50.0 0.0 26.0 50.0 5.0 23.0 50.0 8.0 20.0 50.0 5.0 20.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4E5F9989-4D3A-4117-B6CC-70E5659AB1A2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_87af5d5f-f413-477b-8f2d-d0a863a7117f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 58.0 0.0 20.0 58.0 0.0 20.0 58.0 5.0 23.0 58.0 8.0 26.0 58.0 5.0 26.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E2E9A0BC-F8B3-4A97-8D77-D317E1E7F9DE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f38f53ac-5591-4a81-90fb-c2ecd1329c00">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 50.0 0.0 20.0 50.0 5.0 20.0 58.0 5.0 20.0 58.0 0.0 20.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A63F7847-D3D8-469C-BD34-0C0A4BCA677E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2aa93db8-c589-466d-8052-1d2d37eeac04">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 58.0 0.0 26.0 58.0 5.0 26.0 50.0 5.0 26.0 50.0 0.0 26.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_12E0B992-5E0B-4308-9C3B-BF75200BC4C2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5fbbd9ef-c7eb-445f-94d9-6bdcdf4f96c1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 50.0 5.0 23.0 50.0 8.0 23.0 58.0 8.0 20.0 58.0 5.0 20.0 50.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_14BF4072-7492-4249-A12F-DAA8FDC6AC56">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ec1315e0-8d5b-4dbf-b6ed-ee6ecbf7b640">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 58.0 5.0 23.0 58.0 8.0 23.0 50.0 8.0 26.0 50.0 5.0 26.0 58.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_c59d806b-adb7-4507-8a0e-7e42b36a481e"/>
              <gml:surfaceMember xlink:href="#UUID_cd48d0cf-0560-4cf0-8fae-4df9cff0e9b5"/>
              <gml:surfaceMember xlink:href="#UUID_87af5d5f-f413-477b-8f2d-d0a863a7117f"/>
              <gml:surfaceMember xlink:href="#UUID_f38f53ac-5591-4a81-90fb-c2ecd1329c00"/>
              <gml:surfaceMember xlink:href="#UUID_2aa93db8-c589-466d-8052-1d2d37eeac04"/>
              <gml:surfaceMember xlink:href="#UUID_5fbbd9ef-c7eb-445f-94d9-6bdcdf4f96c1"/>
              <gml:surfaceMember xlink:href="#UUID_ec1315e0-8d5b-4dbf-b6ed-ee6ecbf7b640"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1924-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2095-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1170</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_E9A42D65-8323-41E0-BC42-942222ACF15E">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_EBCB58B1-55EF-401E-A0DA-A55A5198233B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bd731434-2c04-4c48-8ff9-d326f08f0495">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 50.0 0.0 30.0 50.0 0.0 30.0 58.0 0.0 36.0 58.0 0.0 36.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BD48CC6F-024E-4B64-AD82-2A3C62B35D4D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f26a0d75-0c64-4b60-a1af-e8340ff64234">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 50.0 0.0 36.0 50.0 0.0 36.0 50.0 5.0 33.0 50.0 11.0 30.0 50.0 5.0 30.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_59320027-0E8E-4D2D-9575-524FE869D0DC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_93f28479-aa8d-41bb-a8ad-94627f9d48cd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 58.0 0.0 30.0 58.0 0.0 30.0 58.0 5.0 33.0 58.0 11.0 36.0 58.0 5.0 36.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FAC91392-4FDB-4FEF-8A7B-C14D0B5CCBD0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_17fd0837-c1e1-4d63-bdaa-3068bc835069">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 50.0 0.0 30.0 50.0 5.0 30.0 58.0 5.0 30.0 58.0 0.0 30.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_58896A53-2830-4114-A41B-D46A483EFDD9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b8e2a812-bf87-46e9-8f81-0d6d224631f6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 58.0 0.0 36.0 58.0 5.0 36.0 50.0 5.0 36.0 50.0 0.0 36.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3270B887-63C0-4235-BAF2-61FDF93409E2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_836142e7-b5e1-4ed8-8675-cb61a3f10998">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 50.0 5.0 33.0 50.0 11.0 33.0 58.0 11.0 30.0 58.0 5.0 30.0 50.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_FC089A21-97E3-4511-81D9-E92BA67B7E40">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5bb8c17a-abc0-469a-9e07-a1f76d45fe58">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 58.0 5.0 33.0 58.0 11.0 33.0 50.0 11.0 36.0 50.0 5.0 36.0 58.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_bd731434-2c04-4c48-8ff9-d326f08f0495"/>
              <gml:surfaceMember xlink:href="#UUID_f26a0d75-0c64-4b60-a1af-e8340ff64234"/>
              <gml:surfaceMember xlink:href="#UUID_93f28479-aa8d-41bb-a8ad-94627f9d48cd"/>
              <gml:surfaceMember xlink:href="#UUID_17fd0837-c1e1-4d63-bdaa-3068bc835069"/>
              <gml:surfaceMember xlink:href="#UUID_b8e2a812-bf87-46e9-8f81-0d6d224631f6"/>
              <gml:surfaceMember xlink:href="#UUID_836142e7-b5e1-4ed8-8675-cb61a3f10998"/>
              <gml:surfaceMember xlink:href="#UUID_5bb8c17a-abc0-469a-9e07-a1f76d45fe58"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1957-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2040-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1160</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_529EF6AC-EF74-44D9-8D84-1BB0B4AFF01A">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_41DCAD28-11F2-4995-82A5-75156144F0E9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_63450757-98c2-42c2-86cd-77eb1855f2e8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 50.0 0.0 40.0 50.0 0.0 40.0 58.0 0.0 46.0 58.0 0.0 46.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E0DA8C0F-0E73-464A-A26F-88F0E42B801B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d3faaaf5-0c8b-4eb5-b19e-99857cc68641">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 50.0 0.0 46.0 50.0 0.0 46.0 50.0 6.0 43.0 50.0 10.0 40.0 50.0 6.0 40.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_985525FE-8E4D-4226-B7E1-EF8DF4D5BB64">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_369a9301-f9ed-4a22-86b4-7d346ab26705">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 58.0 0.0 40.0 58.0 0.0 40.0 58.0 6.0 43.0 58.0 10.0 46.0 58.0 6.0 46.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_33CA3DE9-D779-4DF4-9CE4-1AE81936C3AC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_352698ec-7a42-4717-9ae0-542aac4d4fe3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 50.0 0.0 40.0 50.0 6.0 40.0 58.0 6.0 40.0 58.0 0.0 40.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9D823BA0-1E5D-48BB-81AA-F57B628F8032">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9ee5906d-7a12-4006-b23c-58e02914c18f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 58.0 0.0 46.0 58.0 6.0 46.0 50.0 6.0 46.0 50.0 0.0 46.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_92114B9F-F3A3-4E6B-99F0-9AB46FBB1EAE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8a767253-3521-4c73-890e-d0da966fc3eb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 50.0 6.0 43.0 50.0 10.0 43.0 58.0 10.0 40.0 58.0 6.0 40.0 50.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_AEE32673-9533-4462-9F09-8D8BD2ABF83A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1fa89123-47dc-4e0a-ae5f-2a6a4ed1bb66">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 58.0 6.0 43.0 58.0 10.0 43.0 50.0 10.0 46.0 50.0 6.0 46.0 58.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_63450757-98c2-42c2-86cd-77eb1855f2e8"/>
              <gml:surfaceMember xlink:href="#UUID_d3faaaf5-0c8b-4eb5-b19e-99857cc68641"/>
              <gml:surfaceMember xlink:href="#UUID_369a9301-f9ed-4a22-86b4-7d346ab26705"/>
              <gml:surfaceMember xlink:href="#UUID_352698ec-7a42-4717-9ae0-542aac4d4fe3"/>
              <gml:surfaceMember xlink:href="#UUID_9ee5906d-7a12-4006-b23c-58e02914c18f"/>
              <gml:surfaceMember xlink:href="#UUID_8a767253-3521-4c73-890e-d0da966fc3eb"/>
              <gml:surfaceMember xlink:href="#UUID_1fa89123-47dc-4e0a-ae5f-2a6a4ed1bb66"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1938-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2052-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1040</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_808C2A46-8C44-44CD-B14C-5D8D97F2BF12">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_56D51D5C-7AA0-4EB1-AF00-4C7B06008A38">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fd098d3a-07f8-4376-a3cc-9b08251265ea">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 50.0 0.0 50.0 50.0 0.0 50.0 58.0 0.0 56.0 58.0 0.0 56.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_68036DE7-602C-4405-A1A5-188391DC7A83">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_244c5aae-a52e-4bb8-b246-849f5e4939f7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 50.0 0.0 56.0 50.0 0.0 56.0 50.0 4.0 53.0 50.0 10.0 50.0 50.0 4.0 50.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_78E12214-DC5C-4EC6-B5AD-C1049A186AE6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2389f1f1-1afd-4456-8a62-cc71c29f5b8d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 58.0 0.0 50.0 58.0 0.0 50.0 58.0 4.0 53.0 58.0 10.0 56.0 58.0 4.0 56.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8E1BB768-B220-4770-978B-4AF503736976">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5dc6e1dd-7473-4dff-9cf8-3546a23cdcce">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 50.0 0.0 50.0 50.0 4.0 50.0 58.0 4.0 50.0 58.0 0.0 50.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C6408C24-16A5-435C-A3F4-3C0A78ED5A06">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0caec07d-ff0e-41e2-8c54-ebbf4b4d7103">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 58.0 0.0 56.0 58.0 4.0 56.0 50.0 4.0 56.0 50.0 0.0 56.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_66E94056-C353-409E-B4E3-6602B2AB7F72">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_61a64f06-73af-4671-a166-6cf238c93289">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 50.0 4.0 53.0 50.0 10.0 53.0 58.0 10.0 50.0 58.0 4.0 50.0 50.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_E4CC7310-F050-4FA3-A0CD-FD68B665AED3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_477461c2-4922-45e7-9c22-d3b7e1fe8669">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 58.0 4.0 53.0 58.0 10.0 53.0 50.0 10.0 56.0 50.0 4.0 56.0 58.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_fd098d3a-07f8-4376-a3cc-9b08251265ea"/>
              <gml:surfaceMember xlink:href="#UUID_244c5aae-a52e-4bb8-b246-849f5e4939f7"/>
              <gml:surfaceMember xlink:href="#UUID_2389f1f1-1afd-4456-8a62-cc71c29f5b8d"/>
              <gml:surfaceMember xlink:href="#UUID_5dc6e1dd-7473-4dff-9cf8-3546a23cdcce"/>
              <gml:surfaceMember xlink:href="#UUID_0caec07d-ff0e-41e2-8c54-ebbf4b4d7103"/>
              <gml:surfaceMember xlink:href="#UUID_61a64f06-73af-4671-a166-6cf238c93289"/>
              <gml:surfaceMember xlink:href="#UUID_477461c2-4922-45e7-9c22-d3b7e1fe8669"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1990-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2029-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1010</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_42260BC5-DA45-4DEB-86B7-35EE6C811506">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_28E44C5B-7DBD-49A6-8D2C-A5F350A83359">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_29f9e203-faec-441c-8900-6f7c41a789fa">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 50.0 0.0 60.0 50.0 0.0 60.0 58.0 0.0 66.0 58.0 0.0 66.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_372B55B1-D31F-4187-BA32-4AA9D804F226">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a6422009-0181-412a-a05d-8f7504a0a263">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 50.0 0.0 66.0 50.0 0.0 66.0 50.0 7.0 63.0 50.0 9.0 60.0 50.0 7.0 60.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9004F025-0F5C-4DE3-AA78-420BC70D1305">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_14035b96-76c0-468e-8640-e9cf5db442bb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 58.0 0.0 60.0 58.0 0.0 60.0 58.0 7.0 63.0 58.0 9.0 66.0 58.0 7.0 66.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_533D85F4-E7A8-467A-AE9C-ED3089ECB4BC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d82e08fb-41c4-47e4-89c3-3f3c9c6713f6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 50.0 0.0 60.0 50.0 7.0 60.0 58.0 7.0 60.0 58.0 0.0 60.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_1A2A1F55-D2BE-4DCF-BEC7-EDBC00429A8C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c80cebed-2c00-431d-881c-7b8095d70a01">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 58.0 0.0 66.0 58.0 7.0 66.0 50.0 7.0 66.0 50.0 0.0 66.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_BE587585-7003-4208-957B-BB4E829A5CA3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9cea1fcd-2e84-45ba-ae8d-7e12cd7fe0b1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 50.0 7.0 63.0 50.0 9.0 63.0 58.0 9.0 60.0 58.0 7.0 60.0 50.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F0F42BB4-FCE6-4644-A7A0-EA5EF0849C54">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0af7a355-9fcb-4444-9459-f14809a16091">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 58.0 7.0 63.0 58.0 9.0 63.0 50.0 9.0 66.0 50.0 7.0 66.0 58.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_29f9e203-faec-441c-8900-6f7c41a789fa"/>
              <gml:surfaceMember xlink:href="#UUID_a6422009-0181-412a-a05d-8f7504a0a263"/>
              <gml:surfaceMember xlink:href="#UUID_14035b96-76c0-468e-8640-e9cf5db442bb"/>
              <gml:surfaceMember xlink:href="#UUID_d82e08fb-41c4-47e4-89c3-3f3c9c6713f6"/>
              <gml:surfaceMember xlink:href="#UUID_c80cebed-2c00-431d-881c-7b8095d70a01"/>
              <gml:surfaceMember xlink:href="#UUID_9cea1fcd-2e84-45ba-ae8d-7e12cd7fe0b1"/>
              <gml:surfaceMember xlink:href="#UUID_0af7a355-9fcb-4444-9459-f14809a16091"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1944-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2059-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1150</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_7254CC17-AC13-4AB9-84F2-E86E85B985A1">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_D5803933-9ED2-4263-98A4-BC7BC762B163">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f549dc2b-067e-403a-87a9-260fe53be451">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 50.0 0.0 70.0 50.0 0.0 70.0 58.0 0.0 76.0 58.0 0.0 76.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5AEB0C77-7F34-4CD8-B2D8-E8AF9973DAFC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_aac108e8-2188-485a-b4b5-cd17af7d8bd3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 50.0 0.0 76.0 50.0 0.0 76.0 50.0 3.0 73.0 50.0 9.0 70.0 50.0 3.0 70.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5435C028-97DE-4634-B424-0D55DD4B71AE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_09aaa48d-c486-4652-930f-3278ba2d4833">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 58.0 0.0 70.0 58.0 0.0 70.0 58.0 3.0 73.0 58.0 9.0 76.0 58.0 3.0 76.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_12135EE1-501A-4BBF-8EA6-D1C3D79AA032">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_39484dad-972c-4d59-9d93-c9a820f00d80">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 50.0 0.0 70.0 50.0 3.0 70.0 58.0 3.0 70.0 58.0 0.0 70.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C8C6DB20-D679-4A2F-847A-7F923E559B98">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a925a4c5-55d1-4da9-8dc5-065de2984e99">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 58.0 0.0 76.0 58.0 3.0 76.0 50.0 3.0 76.0 50.0 0.0 76.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5DC82099-D033-479C-ABBF-ABBA4BE57A87">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b1ee04be-c2a4-45cc-975f-ffec859f6f73">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 50.0 3.0 73.0 50.0 9.0 73.0 58.0 9.0 70.0 58.0 3.0 70.0 50.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_78425B96-79DE-47BE-8806-9962C4249690">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8d52a3bd-5495-4fe5-a209-518139864a40">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 58.0 3.0 73.0 58.0 9.0 73.0 50.0 9.0 76.0 50.0 3.0 76.0 58.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_f549dc2b-067e-403a-87a9-260fe53be451"/>
              <gml:surfaceMember xlink:href="#UUID_aac108e8-2188-485a-b4b5-cd17af7d8bd3"/>
              <gml:surfaceMember xlink:href="#UUID_09aaa48d-c486-4652-930f-3278ba2d4833"/>
              <gml:surfaceMember xlink:href="#UUID_39484dad-972c-4d59-9d93-c9a820f00d80"/>
              <gml:surfaceMember xlink:href="#UUID_a925a4c5-55d1-4da9-8dc5-065de2984e99"/>
              <gml:surfaceMember xlink:href="#UUID_b1ee04be-c2a4-45cc-975f-ffec859f6f73"/>
              <gml:surfaceMember xlink:href="#UUID_8d52a3bd-5495-4fe5-a209-518139864a40"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1941-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2032-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1060</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_14D1B3FA-B82D-4DC2-9E31-054D0D2B2D35">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_7E8EB040-4F47-44F3-8A36-CFFA51F4C03F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a326a351-fec7-409a-b0e3-e1a981abf038">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 50.0 0.0 80.0 50.0 0.0 80.0 58.0 0.0 86.0 58.0 0.0 86.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_79BA9360-D6F6-4510-B2D2-2CD5CB25BBEE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a48ef01b-1b6f-4065-9752-7ffbd5d50ffd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 50.0 0.0 86.0 50.0 0.0 86.0 50.0 6.0 83.0 50.0 9.0 80.0 50.0 6.0 80.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_81392252-1E09-4CAB-A7E1-90F6B03B8976">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_97fe44da-610a-400e-b941-de068e477c29">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 58.0 0.0 80.0 58.0 0.0 80.0 58.0 6.0 83.0 58.0 9.0 86.0 58.0 6.0 86.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EC9CBE5E-DAC6-426F-908F-E0DC00B0E77D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_84960914-6f83-467e-a3d2-49a8d68224cd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 50.0 0.0 80.0 50.0 6.0 80.0 58.0 6.0 80.0 58.0 0.0 80.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_ACBCC26F-EB6B-4271-86DC-4268D4EB2605">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f5c4fc88-9171-479b-9d0d-4da1dd534d83">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 58.0 0.0 86.0 58.0 6.0 86.0 50.0 6.0 86.0 50.0 0.0 86.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_243685DE-473D-4EF0-91AF-59535A5B3C92">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bab43d0c-d7e4-47c2-84b0-ae362efb1a8d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 50.0 6.0 83.0 50.0 9.0 83.0 58.0 9.0 80.0 58.0 6.0 80.0 50.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9461F5AE-F013-44B9-B1C8-EFDBC2718DBC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6d8d540d-2c6e-44aa-99a5-6dedcd9df943">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 58.0 6.0 83.0 58.0 9.0 83.0 50.0 9.0 86.0 50.0 6.0 86.0 58.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_a326a351-fec7-409a-b0e3-e1a981abf038"/>
              <gml:surfaceMember xlink:href="#UUID_a48ef01b-1b6f-4065-9752-7ffbd5d50ffd"/>
              <gml:surfaceMember xlink:href="#UUID_97fe44da-610a-400e-b941-de068e477c29"/>
              <gml:surfaceMember xlink:href="#UUID_84960914-6f83-467e-a3d2-49a8d68224cd"/>
              <gml:surfaceMember xlink:href="#UUID_f5c4fc88-9171-479b-9d0d-4da1dd534d83"/>
              <gml:surfaceMember xlink:href="#UUID_bab43d0c-d7e4-47c2-84b0-ae362efb1a8d"/>
              <gml:surfaceMember xlink:href="#UUID_6d8d540d-2c6e-44aa-99a5-6dedcd9df943"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1918-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2099-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_8B00ECB9-A099-4BE2-A728-CC370C123FA6">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-5-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_464227C3-0AB8-4498-A72E-AC5F6D15808A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2888f56f-6d10-428e-bbf3-a999e09a8a4b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 50.0 0.0 90.0 50.0 0.0 90.0 58.0 0.0 96.0 58.0 0.0 96.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_31F44024-A45C-448C-A3BD-D072B9DA79BA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6929dfe7-4687-4de7-b68b-8dfd9cb33972">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 50.0 0.0 96.0 50.0 0.0 96.0 50.0 4.0 93.0 50.0 10.0 90.0 50.0 4.0 90.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7E801208-ADC6-4220-999C-9296740B9A60">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0fda5d89-33ef-4cf9-838c-a95727ea10d9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 58.0 0.0 90.0 58.0 0.0 90.0 58.0 4.0 93.0 58.0 10.0 96.0 58.0 4.0 96.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_863AB107-5D7B-4614-863C-31E8E78CCB9D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0f4764e2-d530-481e-9518-8379eab34de8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 50.0 0.0 90.0 50.0 4.0 90.0 58.0 4.0 90.0 58.0 0.0 90.0 50.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5CED78CC-4072-4DF6-85DD-80C41B81B544">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_eaf1834a-d1e4-4746-b291-8f42010dbc3b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 58.0 0.0 96.0 58.0 4.0 96.0 50.0 4.0 96.0 50.0 0.0 96.0 58.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_E978B48B-791D-4B58-8901-63B8229F2604">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2e8cf502-cca9-463e-9b18-335062af23ee">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 50.0 4.0 93.0 50.0 10.0 93.0 58.0 10.0 90.0 58.0 4.0 90.0 50.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_FC77E2F3-D9BD-4718-B4E7-22CA04CD1E72">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_06a871a2-1a4e-4d1b-ad55-08f6dbc92b86">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 58.0 4.0 93.0 58.0 10.0 93.0 50.0 10.0 96.0 50.0 4.0 96.0 58.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_2888f56f-6d10-428e-bbf3-a999e09a8a4b"/>
              <gml:surfaceMember xlink:href="#UUID_6929dfe7-4687-4de7-b68b-8dfd9cb33972"/>
              <gml:surfaceMember xlink:href="#UUID_0fda5d89-33ef-4cf9-838c-a95727ea10d9"/>
              <gml:surfaceMember xlink:href="#UUID_0f4764e2-d530-481e-9518-8379eab34de8"/>
              <gml:surfaceMember xlink:href="#UUID_eaf1834a-d1e4-4746-b291-8f42010dbc3b"/>
              <gml:surfaceMember xlink:href="#UUID_2e8cf502-cca9-463e-9b18-335062af23ee"/>
              <gml:surfaceMember xlink:href="#UUID_06a871a2-1a4e-4d1b-ad55-08f6dbc92b86"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1989-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2086-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1140</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_1E662029-01AB-4579-B54E-547593CD3173">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_766110DB-7C95-4F17-A212-554D203D8037">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5af89679-5b67-4546-8f60-1b6312b1977a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 60.0 0.0 0.0 60.0 0.0 0.0 68.0 0.0 6.0 68.0 0.0 6.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_F78EAEDD-F3CA-46F4-9DB6-5FC4F1F40477">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_242e689a-7d9f-47e0-b0a4-191620adb676">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 60.0 0.0 6.0 60.0 0.0 6.0 60.0 3.0 3.0 60.0 8.0 0.0 60.0 3.0 0.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C7272415-1BF6-48B0-94DC-DEC7D7E70FEB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_afb57635-7a50-43da-875b-8ad0570bf2a7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 68.0 0.0 0.0 68.0 0.0 0.0 68.0 3.0 3.0 68.0 8.0 6.0 68.0 3.0 6.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9AA7E101-DA92-4990-83B6-190AE90AEBB7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_73f83236-0e83-4f33-a965-d506c39ff788">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 60.0 0.0 0.0 60.0 3.0 0.0 68.0 3.0 0.0 68.0 0.0 0.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DC42294D-18B8-4CB1-8B70-EDEBC6E306DA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_328adef5-76b9-4b93-b4cd-8777b4969a15">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 68.0 0.0 6.0 68.0 3.0 6.0 60.0 3.0 6.0 60.0 0.0 6.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_FFC097AB-208C-4F69-BA81-04D17F0E45A3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9e7b8410-4bf3-478e-a86a-f36bedf5b255">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 60.0 3.0 3.0 60.0 8.0 3.0 68.0 8.0 0.0 68.0 3.0 0.0 60.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_322A1674-880E-4EA8-91E1-4C820275C829">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_89345229-c98f-44b1-9b36-891e515b51ec">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 68.0 3.0 3.0 68.0 8.0 3.0 60.0 8.0 6.0 60.0 3.0 6.0 68.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_5af89679-5b67-4546-8f60-1b6312b1977a"/>
              <gml:surfaceMember xlink:href="#UUID_242e689a-7d9f-47e0-b0a4-191620adb676"/>
              <gml:surfaceMember xlink:href="#UUID_afb57635-7a50-43da-875b-8ad0570bf2a7"/>
              <gml:surfaceMember xlink:href="#UUID_73f83236-0e83-4f33-a965-d506c39ff788"/>
              <gml:surfaceMember xlink:href="#UUID_328adef5-76b9-4b93-b4cd-8777b4969a15"/>
              <gml:surfaceMember xlink:href="#UUID_9e7b8410-4bf3-478e-a86a-f36bedf5b255"/>
              <gml:surfaceMember xlink:href="#UUID_89345229-c98f-44b1-9b36-891e515b51ec"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1919-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2098-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_4B5F2BDF-4574-48DD-AABB-8AE4B4AC4F45">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_10C8FEDA-4A24-4ADB-B138-3E06406E4C13">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_19833f22-6b9c-4bc1-ac15-4703e9d30494">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 60.0 0.0 10.0 60.0 0.0 10.0 68.0 0.0 16.0 68.0 0.0 16.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_741A40E3-0D7C-4D3D-8555-B808131C413F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0ed9c616-a4bf-401b-9cbb-6b00a145f39f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 60.0 0.0 16.0 60.0 0.0 16.0 60.0 3.0 13.0 60.0 11.0 10.0 60.0 3.0 10.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D6A210A5-1D8E-46D9-A0EC-324F636C42CC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_37cc76e2-f1ff-427c-bad0-52e97817af50">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 68.0 0.0 10.0 68.0 0.0 10.0 68.0 3.0 13.0 68.0 11.0 16.0 68.0 3.0 16.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FEF4A3F9-1E90-4A77-8620-A11639E47A59">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8a98da05-2689-4db0-910e-6fff4b130086">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 60.0 0.0 10.0 60.0 3.0 10.0 68.0 3.0 10.0 68.0 0.0 10.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_362D3F17-A668-4484-AC14-45CBD474B881">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5374f8b6-888d-499d-9824-d101938d807d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 68.0 0.0 16.0 68.0 3.0 16.0 60.0 3.0 16.0 60.0 0.0 16.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C2B0F3F6-2E28-493B-8E87-C61EA3A1150B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_32419538-edf4-45f4-a562-4c4b1a28c31b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 60.0 3.0 13.0 60.0 11.0 13.0 68.0 11.0 10.0 68.0 3.0 10.0 60.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_25F16188-E303-4486-B113-493FEE40C3C2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_297c6fdf-ae5a-4577-8adf-e45b2bb56529">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 68.0 3.0 13.0 68.0 11.0 13.0 60.0 11.0 16.0 60.0 3.0 16.0 68.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_19833f22-6b9c-4bc1-ac15-4703e9d30494"/>
              <gml:surfaceMember xlink:href="#UUID_0ed9c616-a4bf-401b-9cbb-6b00a145f39f"/>
              <gml:surfaceMember xlink:href="#UUID_37cc76e2-f1ff-427c-bad0-52e97817af50"/>
              <gml:surfaceMember xlink:href="#UUID_8a98da05-2689-4db0-910e-6fff4b130086"/>
              <gml:surfaceMember xlink:href="#UUID_5374f8b6-888d-499d-9824-d101938d807d"/>
              <gml:surfaceMember xlink:href="#UUID_32419538-edf4-45f4-a562-4c4b1a28c31b"/>
              <gml:surfaceMember xlink:href="#UUID_297c6fdf-ae5a-4577-8adf-e45b2bb56529"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1903-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2086-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1050</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_F8BA47AE-2098-4464-B02C-4EADE6658900">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_724BB101-A3E6-4981-8918-2C5E4BCCF22A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_93ad9af7-e5bf-41a5-9e31-1f219e99ab66">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 60.0 0.0 20.0 60.0 0.0 20.0 68.0 0.0 26.0 68.0 0.0 26.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AFF26D84-CFBA-4786-B96C-409B931EF60E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9d4584a9-3055-4217-8ccd-45aae23706ae">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 60.0 0.0 26.0 60.0 0.0 26.0 60.0 5.0 23.0 60.0 9.0 20.0 60.0 5.0 20.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_87F38723-B0C5-44A1-9B2E-F20B79FBC9A1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c057a8ee-94a4-4efa-a933-f970e01b6ebd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 68.0 0.0 20.0 68.0 0.0 20.0 68.0 5.0 23.0 68.0 9.0 26.0 68.0 5.0 26.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_825DD83C-740B-4EE8-900F-E0F42D40D6B5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9a2776fc-ef28-494a-a89f-41ebf49d78e8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 60.0 0.0 20.0 60.0 5.0 20.0 68.0 5.0 20.0 68.0 0.0 20.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_74006144-6A05-42CB-9E6E-4EE00BECAEA1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5334669b-5bbe-42c7-9a1e-379198ba2d27">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 68.0 0.0 26.0 68.0 5.0 26.0 60.0 5.0 26.0 60.0 0.0 26.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_1F0F059F-2784-4C11-8A51-DA310D98493C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0e281df2-45c4-4989-b25e-f6e1ae39487e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 60.0 5.0 23.0 60.0 9.0 23.0 68.0 9.0 20.0 68.0 5.0 20.0 60.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_68A7240B-8A3A-4A79-A730-5CD94B1577B2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c05d6a4b-e723-43c9-bcbc-05e6ab160d91">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 68.0 5.0 23.0 68.0 9.0 23.0 60.0 9.0 26.0 60.0 5.0 26.0 68.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_93ad9af7-e5bf-41a5-9e31-1f219e99ab66"/>
              <gml:surfaceMember xlink:href="#UUID_9d4584a9-3055-4217-8ccd-45aae23706ae"/>
              <gml:surfaceMember xlink:href="#UUID_c057a8ee-94a4-4efa-a933-f970e01b6ebd"/>
              <gml:surfaceMember xlink:href="#UUID_9a2776fc-ef28-494a-a89f-41ebf49d78e8"/>
              <gml:surfaceMember xlink:href="#UUID_5334669b-5bbe-42c7-9a1e-379198ba2d27"/>
              <gml:surfaceMember xlink:href="#UUID_0e281df2-45c4-4989-b25e-f6e1ae39487e"/>
              <gml:surfaceMember xlink:href="#UUID_c05d6a4b-e723-43c9-bcbc-05e6ab160d91"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1980-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2065-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_28949BBC-766D-4657-9352-A08AD1F026C8">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1CD37F80-D3F5-47CA-80EE-628A87CB2C34">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8b451755-a968-4eb6-8032-d3f1f70648a5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 60.0 0.0 30.0 60.0 0.0 30.0 68.0 0.0 36.0 68.0 0.0 36.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A761D83C-441F-4971-9AB3-EE71468A23B7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6441dc84-8799-4357-b911-e716347e8654">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 60.0 0.0 36.0 60.0 0.0 36.0 60.0 5.0 33.0 60.0 9.0 30.0 60.0 5.0 30.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4B44EF8C-B641-4BF6-8251-1C9ACA95D731">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1511a83a-c589-4574-97a2-bcdc130ba06d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 68.0 0.0 30.0 68.0 0.0 30.0 68.0 5.0 33.0 68.0 9.0 36.0 68.0 5.0 36.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E1009130-DC79-4DBE-B24E-D172B04BF262">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8a296899-03ea-4a04-9fbb-18ccf92d2831">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 60.0 0.0 30.0 60.0 5.0 30.0 68.0 5.0 30.0 68.0 0.0 30.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9DE64251-78C0-4B3E-B0EA-6E903F52CA23">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5e803eb7-4710-4669-86a7-1fd05965e450">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 68.0 0.0 36.0 68.0 5.0 36.0 60.0 5.0 36.0 60.0 0.0 36.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_58C837CA-90F8-4B04-BD94-1E5FA48231C3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fe3bbece-63b4-4d7f-b171-03334ca14c00">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 60.0 5.0 33.0 60.0 9.0 33.0 68.0 9.0 30.0 68.0 5.0 30.0 60.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F2152393-C271-4364-9FAD-5A00B702D177">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f49bc9b2-fadb-4c1a-9293-8b723444b11a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 68.0 5.0 33.0 68.0 9.0 33.0 60.0 9.0 36.0 60.0 5.0 36.0 68.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_8b451755-a968-4eb6-8032-d3f1f70648a5"/>
              <gml:surfaceMember xlink:href="#UUID_6441dc84-8799-4357-b911-e716347e8654"/>
              <gml:surfaceMember xlink:href="#UUID_1511a83a-c589-4574-97a2-bcdc130ba06d"/>
              <gml:surfaceMember xlink:href="#UUID_8a296899-03ea-4a04-9fbb-18ccf92d2831"/>
              <gml:surfaceMember xlink:href="#UUID_5e803eb7-4710-4669-86a7-1fd05965e450"/>
              <gml:surfaceMember xlink:href="#UUID_fe3bbece-63b4-4d7f-b171-03334ca14c00"/>
              <gml:surfaceMember xlink:href="#UUID_f49bc9b2-fadb-4c1a-9293-8b723444b11a"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1953-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2054-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1060</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_5BF85CE1-C418-4430-B102-3D1BB500D9DD">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_48E1AFC7-516D-4402-81D0-82AB81BE235C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0585c8f9-6add-464b-9a99-a7e40947fc03">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 60.0 0.0 40.0 60.0 0.0 40.0 68.0 0.0 46.0 68.0 0.0 46.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B577C68F-E975-40A6-874A-481D4B9EDA61">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_06f2f58e-8122-4eb9-8a10-ff8810489d50">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 60.0 0.0 46.0 60.0 0.0 46.0 60.0 4.0 43.0 60.0 10.0 40.0 60.0 4.0 40.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9B522C84-FE92-4DD0-B968-B0048A8A1A23">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ce72e40c-ce6c-4fd6-94b9-aca809aa0dc2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 68.0 0.0 40.0 68.0 0.0 40.0 68.0 4.0 43.0 68.0 10.0 46.0 68.0 4.0 46.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9F1BBD6E-9AB1-45AE-B407-D4AD54F67289">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a21a4ea7-4dbe-4896-97d9-8fb1a9739484">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 60.0 0.0 40.0 60.0 4.0 40.0 68.0 4.0 40.0 68.0 0.0 40.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5173B31A-E86A-4231-A6BC-7585CF8FD012">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f361e002-5271-4a5b-a17c-0558e7e28219">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 68.0 0.0 46.0 68.0 4.0 46.0 60.0 4.0 46.0 60.0 0.0 46.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_373ADCF5-A112-4895-AC20-C31B37AC7B69">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_04311e1d-794d-49d6-92f2-6223c9920309">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 60.0 4.0 43.0 60.0 10.0 43.0 68.0 10.0 40.0 68.0 4.0 40.0 60.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_982A09B9-3ABB-4D2C-8161-5813919E916B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_60ebb57b-6981-4524-8993-960949b707ea">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 68.0 4.0 43.0 68.0 10.0 43.0 60.0 10.0 46.0 60.0 4.0 46.0 68.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_0585c8f9-6add-464b-9a99-a7e40947fc03"/>
              <gml:surfaceMember xlink:href="#UUID_06f2f58e-8122-4eb9-8a10-ff8810489d50"/>
              <gml:surfaceMember xlink:href="#UUID_ce72e40c-ce6c-4fd6-94b9-aca809aa0dc2"/>
              <gml:surfaceMember xlink:href="#UUID_a21a4ea7-4dbe-4896-97d9-8fb1a9739484"/>
              <gml:surfaceMember xlink:href="#UUID_f361e002-5271-4a5b-a17c-0558e7e28219"/>
              <gml:surfaceMember xlink:href="#UUID_04311e1d-794d-49d6-92f2-6223c9920309"/>
              <gml:surfaceMember xlink:href="#UUID_60ebb57b-6981-4524-8993-960949b707ea"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1993-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2099-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1170</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_297748FB-6712-4C9E-97A4-231C6F45EF8F">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_6D40E28C-4D67-438A-AF26-5B8FDB61A8CF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d6f01e99-b180-45f5-b222-fedd0ffb374b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 60.0 0.0 50.0 60.0 0.0 50.0 68.0 0.0 56.0 68.0 0.0 56.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_169666E3-6F65-421A-9CE6-880313AC8134">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dabad0ad-e874-4dbc-8ea9-b60c4c83be4d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 60.0 0.0 56.0 60.0 0.0 56.0 60.0 7.0 53.0 60.0 12.0 50.0 60.0 7.0 50.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B04597DB-A6A4-466D-91E6-BE2F201D3821">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_deee2e28-2a52-44ba-a0df-da4cad273bd4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 68.0 0.0 50.0 68.0 0.0 50.0 68.0 7.0 53.0 68.0 12.0 56.0 68.0 7.0 56.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8DAE50A4-B528-448D-B70A-6ABE4D8E316C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2ea7b25f-8c1d-4026-8165-f4b0f0677bed">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 60.0 0.0 50.0 60.0 7.0 50.0 68.0 7.0 50.0 68.0 0.0 50.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_1112B7E4-B7E2-4826-98C8-03EB05B264F1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a902b4dd-0890-4d5a-99b6-b5b0d654e67c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 68.0 0.0 56.0 68.0 7.0 56.0 60.0 7.0 56.0 60.0 0.0 56.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_DAA39D1D-6A06-43FA-9FD6-E22B51D6F436">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5ccf6f0f-b530-4a8a-bc82-e65f4822e5f3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 60.0 7.0 53.0 60.0 12.0 53.0 68.0 12.0 50.0 68.0 7.0 50.0 60.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F6D997F1-E918-4314-B7B6-2E5AB2C66D3A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fca78cc6-21a7-4e40-a771-e01a24d03a83">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 68.0 7.0 53.0 68.0 12.0 53.0 60.0 12.0 56.0 60.0 7.0 56.0 68.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_d6f01e99-b180-45f5-b222-fedd0ffb374b"/>
              <gml:surfaceMember xlink:href="#UUID_dabad0ad-e874-4dbc-8ea9-b60c4c83be4d"/>
              <gml:surfaceMember xlink:href="#UUID_deee2e28-2a52-44ba-a0df-da4cad273bd4"/>
              <gml:surfaceMember xlink:href="#UUID_2ea7b25f-8c1d-4026-8165-f4b0f0677bed"/>
              <gml:surfaceMember xlink:href="#UUID_a902b4dd-0890-4d5a-99b6-b5b0d654e67c"/>
              <gml:surfaceMember xlink:href="#UUID_5ccf6f0f-b530-4a8a-bc82-e65f4822e5f3"/>
              <gml:surfaceMember xlink:href="#UUID_fca78cc6-21a7-4e40-a771-e01a24d03a83"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1917-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2076-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1050</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_DAD7577B-D32C-4F0A-9710-754A83312014">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_7D5E67FF-F4F3-4697-8747-7E4FFCA9C04A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dfcf0901-bcc7-4d1b-addc-a14c86ccce73">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 60.0 0.0 60.0 60.0 0.0 60.0 68.0 0.0 66.0 68.0 0.0 66.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DB7B92E1-F6B4-4FED-BD17-9183F241D190">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c53dbe62-da34-48a0-b53f-0d350bb4acbb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 60.0 0.0 66.0 60.0 0.0 66.0 60.0 3.0 63.0 60.0 11.0 60.0 60.0 3.0 60.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_1B3B2E81-337E-405A-97B4-514F1B0F01CF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_816c20a5-c6b5-4606-aad7-6575c9f91692">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 68.0 0.0 60.0 68.0 0.0 60.0 68.0 3.0 63.0 68.0 11.0 66.0 68.0 3.0 66.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_05B68177-4C64-494F-B52A-FA1E9F81B91A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dda5acf4-8c47-424b-9be5-07d858538db1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 60.0 0.0 60.0 60.0 3.0 60.0 68.0 3.0 60.0 68.0 0.0 60.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C86F05E1-414F-426F-8CB2-49D426A6BE4D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_33f094ac-55dd-4322-bb2e-416adae1e341">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 68.0 0.0 66.0 68.0 3.0 66.0 60.0 3.0 66.0 60.0 0.0 66.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2460E5B3-DB58-4657-8DA3-7AC2E91540E0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4fe359b0-3942-4747-95ac-98e21a86c20b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 60.0 3.0 63.0 60.0 11.0 63.0 68.0 11.0 60.0 68.0 3.0 60.0 60.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A60E32F2-CAC9-4CC8-B115-0C4D0A96F06B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6b5109bb-8e60-4177-869f-5439186fe91c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 68.0 3.0 63.0 68.0 11.0 63.0 60.0 11.0 66.0 60.0 3.0 66.0 68.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_dfcf0901-bcc7-4d1b-addc-a14c86ccce73"/>
              <gml:surfaceMember xlink:href="#UUID_c53dbe62-da34-48a0-b53f-0d350bb4acbb"/>
              <gml:surfaceMember xlink:href="#UUID_816c20a5-c6b5-4606-aad7-6575c9f91692"/>
              <gml:surfaceMember xlink:href="#UUID_dda5acf4-8c47-424b-9be5-07d858538db1"/>
              <gml:surfaceMember xlink:href="#UUID_33f094ac-55dd-4322-bb2e-416adae1e341"/>
              <gml:surfaceMember xlink:href="#UUID_4fe359b0-3942-4747-95ac-98e21a86c20b"/>
              <gml:surfaceMember xlink:href="#UUID_6b5109bb-8e60-4177-869f-5439186fe91c"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1929-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2052-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1020</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_8B40CF5B-6FB5-4C1C-8B42-2912452BB815">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_3CC79164-B008-4D77-9D31-9CC42FAF3E3E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_518e4e9e-8a60-473a-9765-1830013b94ec">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 60.0 0.0 70.0 60.0 0.0 70.0 68.0 0.0 76.0 68.0 0.0 76.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DFD81253-B006-4A22-AEE0-DBEB0C2ADBD7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f005ddd4-d289-4d23-b9be-2afd7e81b65a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 60.0 0.0 76.0 60.0 0.0 76.0 60.0 7.0 73.0 60.0 9.0 70.0 60.0 7.0 70.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C49191D2-7537-4626-B296-7E98D9920A8F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d354f7bb-5edd-40f0-9030-c1e92d466e22">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 68.0 0.0 70.0 68.0 0.0 70.0 68.0 7.0 73.0 68.0 9.0 76.0 68.0 7.0 76.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6B961B86-CFD6-43A7-8640-7B2AB8B12DAE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0cff7306-2ef5-429e-a992-70ed0bff7ac6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 60.0 0.0 70.0 60.0 7.0 70.0 68.0 7.0 70.0 68.0 0.0 70.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6977DAFF-83B5-4538-8AC3-5DC3FC6BE148">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1d5a2b01-1568-470b-8ad6-02440be149f6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 68.0 0.0 76.0 68.0 7.0 76.0 60.0 7.0 76.0 60.0 0.0 76.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_17BE7455-AE14-46ED-B3B4-77532372753E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2d9b589d-a66a-4cc7-8839-cc36def1c2ab">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 60.0 7.0 73.0 60.0 9.0 73.0 68.0 9.0 70.0 68.0 7.0 70.0 60.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_DA58A2E3-A86F-4B62-859A-076DD952506E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d0f8a6f7-5a76-4591-87db-cd4d6cc9a45f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 68.0 7.0 73.0 68.0 9.0 73.0 60.0 9.0 76.0 60.0 7.0 76.0 68.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_518e4e9e-8a60-473a-9765-1830013b94ec"/>
              <gml:surfaceMember xlink:href="#UUID_f005ddd4-d289-4d23-b9be-2afd7e81b65a"/>
              <gml:surfaceMember xlink:href="#UUID_d354f7bb-5edd-40f0-9030-c1e92d466e22"/>
              <gml:surfaceMember xlink:href="#UUID_0cff7306-2ef5-429e-a992-70ed0bff7ac6"/>
              <gml:surfaceMember xlink:href="#UUID_1d5a2b01-1568-470b-8ad6-02440be149f6"/>
              <gml:surfaceMember xlink:href="#UUID_2d9b589d-a66a-4cc7-8839-cc36def1c2ab"/>
              <gml:surfaceMember xlink:href="#UUID_d0f8a6f7-5a76-4591-87db-cd4d6cc9a45f"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1938-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2052-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1060</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_B9A61B30-1EC3-491A-B6C1-3D9FC7421B00">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_69D870E1-0E3B-447D-B399-CED4BD749092">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_29247512-81d2-411b-b46b-f4c13c488003">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 60.0 0.0 80.0 60.0 0.0 80.0 68.0 0.0 86.0 68.0 0.0 86.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C0ADE8CE-CCFB-463A-AEAD-485790C68B6E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0d6ea922-126a-4b28-a404-73d615646630">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 60.0 0.0 86.0 60.0 0.0 86.0 60.0 6.0 83.0 60.0 11.0 80.0 60.0 6.0 80.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_31F7C944-D7E9-4FE8-858B-92A0F373DE9D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ca420a82-f0d3-4f71-a5a8-9e7b3aeb5997">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 68.0 0.0 80.0 68.0 0.0 80.0 68.0 6.0 83.0 68.0 11.0 86.0 68.0 6.0 86.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_80BFE7D0-EA73-49C9-A34A-E349A88F2957">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4f8f28a5-51f7-49b6-a5aa-304f54f084d3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 60.0 0.0 80.0 60.0 6.0 80.0 68.0 6.0 80.0 68.0 0.0 80.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B6BCCD01-C2CE-48FE-AC53-77585F171C2D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2fa793e0-251f-48d6-89e3-9ec493417562">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 68.0 0.0 86.0 68.0 6.0 86.0 60.0 6.0 86.0 60.0 0.0 86.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F22A8207-C15D-4656-9C13-FB94D33B28CE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_68dab02d-2c76-4dc6-a5b5-32d5e193929b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 60.0 6.0 83.0 60.0 11.0 83.0 68.0 11.0 80.0 68.0 6.0 80.0 60.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_40B06B9E-B247-48EF-BCCC-C15D1B578DE2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_093f14b8-9f26-4145-939d-22901d73870e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 68.0 6.0 83.0 68.0 11.0 83.0 60.0 11.0 86.0 60.0 6.0 86.0 68.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_29247512-81d2-411b-b46b-f4c13c488003"/>
              <gml:surfaceMember xlink:href="#UUID_0d6ea922-126a-4b28-a404-73d615646630"/>
              <gml:surfaceMember xlink:href="#UUID_ca420a82-f0d3-4f71-a5a8-9e7b3aeb5997"/>
              <gml:surfaceMember xlink:href="#UUID_4f8f28a5-51f7-49b6-a5aa-304f54f084d3"/>
              <gml:surfaceMember xlink:href="#UUID_2fa793e0-251f-48d6-89e3-9ec493417562"/>
              <gml:surfaceMember xlink:href="#UUID_68dab02d-2c76-4dc6-a5b5-32d5e193929b"/>
              <gml:surfaceMember xlink:href="#UUID_093f14b8-9f26-4145-939d-22901d73870e"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1995-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2072-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_B4EACFB6-C29F-4FFF-A25A-2474E659F970">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-6-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1934142B-DD56-4CC0-B902-D364D41DC23E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e4091f7b-c2fc-4cde-a5ad-465648db61db">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 60.0 0.0 90.0 60.0 0.0 90.0 68.0 0.0 96.0 68.0 0.0 96.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C6A8C94A-28BF-460C-A464-C34B68C5AD85">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fc4cc83d-8db0-4781-b469-7b57f7075f34">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 60.0 0.0 96.0 60.0 0.0 96.0 60.0 6.0 93.0 60.0 10.0 90.0 60.0 6.0 90.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A013317C-A647-4AB9-A254-02BCCA42300E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_81022a8f-d7a3-4ce2-b28a-130aa1e27579">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 68.0 0.0 90.0 68.0 0.0 90.0 68.0 6.0 93.0 68.0 10.0 96.0 68.0 6.0 96.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BDF53854-07E6-4212-B805-0BFB6FE9FA48">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3df7f697-93cd-48e3-859b-bbfa7b8079ad">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 60.0 0.0 90.0 60.0 6.0 90.0 68.0 6.0 90.0 68.0 0.0 90.0 60.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_370EBB06-0390-47EB-9530-4F979CA6C88D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d602036b-abf8-4fe4-9f14-5a05f9de46f1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 68.0 0.0 96.0 68.0 6.0 96.0 60.0 6.0 96.0 60.0 0.0 96.0 68.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_66092751-B292-4DD0-98E9-5C95302D3438">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_972b887c-2464-430d-b2d8-33841ed1f4d4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 60.0 6.0 93.0 60.0 10.0 93.0 68.0 10.0 90.0 68.0 6.0 90.0 60.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_26C78A54-B4B8-4E89-A4C3-089536A19135">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_81cf3994-d926-44fc-b7c8-57bba535a63e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 68.0 6.0 93.0 68.0 10.0 93.0 60.0 10.0 96.0 60.0 6.0 96.0 68.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_e4091f7b-c2fc-4cde-a5ad-465648db61db"/>
              <gml:surfaceMember xlink:href="#UUID_fc4cc83d-8db0-4781-b469-7b57f7075f34"/>
              <gml:surfaceMember xlink:href="#UUID_81022a8f-d7a3-4ce2-b28a-130aa1e27579"/>
              <gml:surfaceMember xlink:href="#UUID_3df7f697-93cd-48e3-859b-bbfa7b8079ad"/>
              <gml:surfaceMember xlink:href="#UUID_d602036b-abf8-4fe4-9f14-5a05f9de46f1"/>
              <gml:surfaceMember xlink:href="#UUID_972b887c-2464-430d-b2d8-33841ed1f4d4"/>
              <gml:surfaceMember xlink:href="#UUID_81cf3994-d926-44fc-b7c8-57bba535a63e"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1990-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2043-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1080</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_67C4E76D-3261-4C9D-A31A-20441E59FED3">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_5BD5B73E-6FDA-47FF-9F17-09FC97BB0B04">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8077317e-38b2-4284-b457-6445cb19549a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 70.0 0.0 0.0 70.0 0.0 0.0 78.0 0.0 6.0 78.0 0.0 6.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AD232282-2AEC-46C5-939F-4C9D78D3090A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_764f312e-7022-4fcb-bb25-d3009c2afe06">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 70.0 0.0 6.0 70.0 0.0 6.0 70.0 4.0 3.0 70.0 9.0 0.0 70.0 4.0 0.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EF5AACEA-34CB-44AD-892B-1C50146A0AE1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dc619bcd-8d7e-4520-9bd9-22bb6b5a21cb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 78.0 0.0 0.0 78.0 0.0 0.0 78.0 4.0 3.0 78.0 9.0 6.0 78.0 4.0 6.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C44F725F-D83A-4359-9E0D-18CB3FFC9694">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bff3ab07-f022-45c1-9132-0a9c268a6963">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 70.0 0.0 0.0 70.0 4.0 0.0 78.0 4.0 0.0 78.0 0.0 0.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_DD21CF92-14D9-481D-9D8C-91A4EDC143BD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_731ec8ac-2507-419d-8a39-b725c9e4b1eb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 78.0 0.0 6.0 78.0 4.0 6.0 70.0 4.0 6.0 70.0 0.0 6.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_BAE5B49B-C9BF-4E04-8358-BCCB7C24D112">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cfedd45c-f943-4ebc-be60-c774e2d66f5d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 70.0 4.0 3.0 70.0 9.0 3.0 78.0 9.0 0.0 78.0 4.0 0.0 70.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_14A0BB9D-0104-4EA0-81CB-31843CB24BB8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_14788e8c-7efc-4e24-964e-af1eba08b700">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 78.0 4.0 3.0 78.0 9.0 3.0 70.0 9.0 6.0 70.0 4.0 6.0 78.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_8077317e-38b2-4284-b457-6445cb19549a"/>
              <gml:surfaceMember xlink:href="#UUID_764f312e-7022-4fcb-bb25-d3009c2afe06"/>
              <gml:surfaceMember xlink:href="#UUID_dc619bcd-8d7e-4520-9bd9-22bb6b5a21cb"/>
              <gml:surfaceMember xlink:href="#UUID_bff3ab07-f022-45c1-9132-0a9c268a6963"/>
              <gml:surfaceMember xlink:href="#UUID_731ec8ac-2507-419d-8a39-b725c9e4b1eb"/>
              <gml:surfaceMember xlink:href="#UUID_cfedd45c-f943-4ebc-be60-c774e2d66f5d"/>
              <gml:surfaceMember xlink:href="#UUID_14788e8c-7efc-4e24-964e-af1eba08b700"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1929-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2099-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1000</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_6311DACE-221A-4EF6-840D-14BB1ADF71D6">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_04EA17D2-264D-4A02-96AD-6B5C1A3C5BD3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1ca047bb-90fa-491c-a51e-680f90bf1cd2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 70.0 0.0 10.0 70.0 0.0 10.0 78.0 0.0 16.0 78.0 0.0 16.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C0452331-FFA7-4273-ADF9-8A177A5D91C2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4c06bff4-9441-4981-b7c0-ad3b9596c68c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 70.0 0.0 16.0 70.0 0.0 16.0 70.0 4.0 13.0 70.0 11.0 10.0 70.0 4.0 10.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CA17A229-C71E-4EDE-9027-66BF59BD5898">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f2fd41d9-452a-4f05-953d-c1f6ac495b9e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 78.0 0.0 10.0 78.0 0.0 10.0 78.0 4.0 13.0 78.0 11.0 16.0 78.0 4.0 16.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5E84AFAF-B83A-4CBB-A2C9-3754E08E91AC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_775d29c6-bba1-42c2-88f5-4f9e5505f261">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 70.0 0.0 10.0 70.0 4.0 10.0 78.0 4.0 10.0 78.0 0.0 10.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E166E1BA-EC81-41E5-A900-8CBCD043C117">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_145ac129-3a46-4be9-b46b-75f9c1366d9e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 78.0 0.0 16.0 78.0 4.0 16.0 70.0 4.0 16.0 70.0 0.0 16.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A73C53F3-7E28-4DA5-A7DD-F46896E4B04E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_53962b9f-514d-4493-bfb4-8fd2fbbcc738">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 70.0 4.0 13.0 70.0 11.0 13.0 78.0 11.0 10.0 78.0 4.0 10.0 70.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_795BC398-30AF-4333-A3E9-81F5D110A603">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_58281063-9fd9-4b1a-9834-d9a8d36c5bee">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 78.0 4.0 13.0 78.0 11.0 13.0 70.0 11.0 16.0 70.0 4.0 16.0 78.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_1ca047bb-90fa-491c-a51e-680f90bf1cd2"/>
              <gml:surfaceMember xlink:href="#UUID_4c06bff4-9441-4981-b7c0-ad3b9596c68c"/>
              <gml:surfaceMember xlink:href="#UUID_f2fd41d9-452a-4f05-953d-c1f6ac495b9e"/>
              <gml:surfaceMember xlink:href="#UUID_775d29c6-bba1-42c2-88f5-4f9e5505f261"/>
              <gml:surfaceMember xlink:href="#UUID_145ac129-3a46-4be9-b46b-75f9c1366d9e"/>
              <gml:surfaceMember xlink:href="#UUID_53962b9f-514d-4493-bfb4-8fd2fbbcc738"/>
              <gml:surfaceMember xlink:href="#UUID_58281063-9fd9-4b1a-9834-d9a8d36c5bee"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1979-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2089-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_14B97F70-0AF9-4052-B683-4750946E460E">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_D6D53A63-27DC-44BA-906A-EE1DD6F61BFC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b755acee-4c03-467d-998f-66f9e3037bcd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 70.0 0.0 20.0 70.0 0.0 20.0 78.0 0.0 26.0 78.0 0.0 26.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_ECB90362-A95E-4F0E-8560-8150875E0F87">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a527bba7-bed3-4394-944a-5f73d92100b1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 70.0 0.0 26.0 70.0 0.0 26.0 70.0 3.0 23.0 70.0 10.0 20.0 70.0 3.0 20.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_82DA2C54-57C2-444A-8F1B-B431B6205C65">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_153a6c9c-db7a-449b-ab60-9d2168a32f6e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 78.0 0.0 20.0 78.0 0.0 20.0 78.0 3.0 23.0 78.0 10.0 26.0 78.0 3.0 26.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2029799D-3B88-41E3-9EEC-C280325F99DB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_60337158-f4bb-45fe-9cd6-aca04ec4a15d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 70.0 0.0 20.0 70.0 3.0 20.0 78.0 3.0 20.0 78.0 0.0 20.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AD18B112-5822-4A23-86B1-22A7161F37A7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6c41ef1d-14f8-45af-a4b4-54682cc99a1b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 78.0 0.0 26.0 78.0 3.0 26.0 70.0 3.0 26.0 70.0 0.0 26.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A4D56E25-54E2-4AD3-A376-2B5F1EEE3525">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_df0b1cc1-2148-4a1f-986a-8e7c0827c0cf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 70.0 3.0 23.0 70.0 10.0 23.0 78.0 10.0 20.0 78.0 3.0 20.0 70.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_AB8CA36D-1AA8-4790-9648-C11710FEF63A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6740a760-6144-4b95-881d-9379bc64875c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 78.0 3.0 23.0 78.0 10.0 23.0 70.0 10.0 26.0 70.0 3.0 26.0 78.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_b755acee-4c03-467d-998f-66f9e3037bcd"/>
              <gml:surfaceMember xlink:href="#UUID_a527bba7-bed3-4394-944a-5f73d92100b1"/>
              <gml:surfaceMember xlink:href="#UUID_153a6c9c-db7a-449b-ab60-9d2168a32f6e"/>
              <gml:surfaceMember xlink:href="#UUID_60337158-f4bb-45fe-9cd6-aca04ec4a15d"/>
              <gml:surfaceMember xlink:href="#UUID_6c41ef1d-14f8-45af-a4b4-54682cc99a1b"/>
              <gml:surfaceMember xlink:href="#UUID_df0b1cc1-2148-4a1f-986a-8e7c0827c0cf"/>
              <gml:surfaceMember xlink:href="#UUID_6740a760-6144-4b95-881d-9379bc64875c"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1970-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2060-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1080</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_C848D7E3-63AC-42C8-A9C3-F32608AB5C3F">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_3C7A2AE1-5F5B-4CF6-B3AF-DFD991E9E950">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d392b92d-0533-4b38-a8e3-4453410e472a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 70.0 0.0 30.0 70.0 0.0 30.0 78.0 0.0 36.0 78.0 0.0 36.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_886B3BD2-52F4-47BE-8D5A-8ED8DF9434A3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a139874c-0b3f-47ca-8e4d-9efd69bf7798">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 70.0 0.0 36.0 70.0 0.0 36.0 70.0 5.0 33.0 70.0 12.0 30.0 70.0 5.0 30.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0BE5B6B6-6BA9-443A-9B7E-02B38324F380">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f79dd2da-cacc-4ad1-b686-a4c09f1146b9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 78.0 0.0 30.0 78.0 0.0 30.0 78.0 5.0 33.0 78.0 12.0 36.0 78.0 5.0 36.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D9354F52-3C0C-458F-86A0-093E5D8A1983">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fda73c1f-1802-4bc5-a0d2-e7b73436a564">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 70.0 0.0 30.0 70.0 5.0 30.0 78.0 5.0 30.0 78.0 0.0 30.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A632EB39-AA4F-4CBE-9925-F52C0B6067FD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dc59b453-ec0d-4077-bf27-05368d9ad0ea">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 78.0 0.0 36.0 78.0 5.0 36.0 70.0 5.0 36.0 70.0 0.0 36.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_DB3C8042-E209-435E-A2D4-C9E5431006B2">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a3ef8959-93b7-4c1f-a835-073f7deb2e16">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 70.0 5.0 33.0 70.0 12.0 33.0 78.0 12.0 30.0 78.0 5.0 30.0 70.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_57B99FAB-CF12-486F-97E6-8C0F4F09EB84">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_19871e49-c9dd-4dac-9406-530e9b191011">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 78.0 5.0 33.0 78.0 12.0 33.0 70.0 12.0 36.0 70.0 5.0 36.0 78.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_d392b92d-0533-4b38-a8e3-4453410e472a"/>
              <gml:surfaceMember xlink:href="#UUID_a139874c-0b3f-47ca-8e4d-9efd69bf7798"/>
              <gml:surfaceMember xlink:href="#UUID_f79dd2da-cacc-4ad1-b686-a4c09f1146b9"/>
              <gml:surfaceMember xlink:href="#UUID_fda73c1f-1802-4bc5-a0d2-e7b73436a564"/>
              <gml:surfaceMember xlink:href="#UUID_dc59b453-ec0d-4077-bf27-05368d9ad0ea"/>
              <gml:surfaceMember xlink:href="#UUID_a3ef8959-93b7-4c1f-a835-073f7deb2e16"/>
              <gml:surfaceMember xlink:href="#UUID_19871e49-c9dd-4dac-9406-530e9b191011"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1962-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2027-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_A2323294-4352-4123-AA3E-A42F880A6185">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_3C8FAA3E-7F92-41B8-854B-8156C4E73708">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8154feed-80e0-43ce-ae1d-e5ca3e8ae6b6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 70.0 0.0 40.0 70.0 0.0 40.0 78.0 0.0 46.0 78.0 0.0 46.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D45B5F71-672D-4448-814E-10042C6A137A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4ceec857-b0b8-410a-b350-176e5bc8bad5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 70.0 0.0 46.0 70.0 0.0 46.0 70.0 3.0 43.0 70.0 8.0 40.0 70.0 3.0 40.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2277D79D-E1B9-44EB-8331-96728DBA24D1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_54fab966-5b81-43a1-8249-69d2b8073d09">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 78.0 0.0 40.0 78.0 0.0 40.0 78.0 3.0 43.0 78.0 8.0 46.0 78.0 3.0 46.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_59BF3ABA-2417-41A8-827B-F18B29BA53DB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_92a0a639-93a1-47be-9b2a-8e8001dbecdf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 70.0 0.0 40.0 70.0 3.0 40.0 78.0 3.0 40.0 78.0 0.0 40.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5FF05580-FCB1-4B23-ACE3-5E0591C74B56">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0676d8b6-8344-42e3-9969-c5e84ad2730e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 78.0 0.0 46.0 78.0 3.0 46.0 70.0 3.0 46.0 70.0 0.0 46.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C831EE7E-324B-4A8B-9534-DD28F0EACCB6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1a524747-c56b-4f16-be6b-b7ad0e4bfb00">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 70.0 3.0 43.0 70.0 8.0 43.0 78.0 8.0 40.0 78.0 3.0 40.0 70.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5ED050D1-5DEE-46D1-BBFB-DAF032FF87B6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3fbfafcf-d0d7-4ba9-8d6d-b288ed016270">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 78.0 3.0 43.0 78.0 8.0 43.0 70.0 8.0 46.0 70.0 3.0 46.0 78.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_8154feed-80e0-43ce-ae1d-e5ca3e8ae6b6"/>
              <gml:surfaceMember xlink:href="#UUID_4ceec857-b0b8-410a-b350-176e5bc8bad5"/>
              <gml:surfaceMember xlink:href="#UUID_54fab966-5b81-43a1-8249-69d2b8073d09"/>
              <gml:surfaceMember xlink:href="#UUID_92a0a639-93a1-47be-9b2a-8e8001dbecdf"/>
              <gml:surfaceMember xlink:href="#UUID_0676d8b6-8344-42e3-9969-c5e84ad2730e"/>
              <gml:surfaceMember xlink:href="#UUID_1a524747-c56b-4f16-be6b-b7ad0e4bfb00"/>
              <gml:surfaceMember xlink:href="#UUID_3fbfafcf-d0d7-4ba9-8d6d-b288ed016270"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1955-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2065-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1080</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_A3C090D4-84AD-4319-98D4-886F2D6BDABC">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_8D812647-F170-4225-B002-FFFA1196FB98">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2e96e5b5-5692-4824-924d-da6049b50904">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 70.0 0.0 50.0 70.0 0.0 50.0 78.0 0.0 56.0 78.0 0.0 56.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E999973C-F9CF-48CB-A2F7-461323929052">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c8826ebd-11c1-48b1-8a55-63bb2fff06a4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 70.0 0.0 56.0 70.0 0.0 56.0 70.0 3.0 53.0 70.0 10.0 50.0 70.0 3.0 50.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5B4F927A-9090-42BD-81BF-A04EF3762BCB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bd43fd95-8c4c-4f35-90fc-5f3376e20a9a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 78.0 0.0 50.0 78.0 0.0 50.0 78.0 3.0 53.0 78.0 10.0 56.0 78.0 3.0 56.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_6203557D-B1F1-4AE6-B96E-B792149AC7B3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_325effcb-0923-4496-959a-0f833ee65468">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 70.0 0.0 50.0 70.0 3.0 50.0 78.0 3.0 50.0 78.0 0.0 50.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_49B323C7-135B-4709-AC77-2661C3A851AF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_012d69bf-0d46-4a29-a955-bbe92d5b19c6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 78.0 0.0 56.0 78.0 3.0 56.0 70.0 3.0 56.0 70.0 0.0 56.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F4781367-89E2-4CB5-A211-1DA52116245E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a1c5061f-270c-4721-b573-6a4ac1fa60a0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 70.0 3.0 53.0 70.0 10.0 53.0 78.0 10.0 50.0 78.0 3.0 50.0 70.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A6854FA7-90C3-4E21-98BC-BBD10AA83074">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5ccdccf8-d03d-476f-bd1d-6bf780d611bc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 78.0 3.0 53.0 78.0 10.0 53.0 70.0 10.0 56.0 70.0 3.0 56.0 78.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_2e96e5b5-5692-4824-924d-da6049b50904"/>
              <gml:surfaceMember xlink:href="#UUID_c8826ebd-11c1-48b1-8a55-63bb2fff06a4"/>
              <gml:surfaceMember xlink:href="#UUID_bd43fd95-8c4c-4f35-90fc-5f3376e20a9a"/>
              <gml:surfaceMember xlink:href="#UUID_325effcb-0923-4496-959a-0f833ee65468"/>
              <gml:surfaceMember xlink:href="#UUID_012d69bf-0d46-4a29-a955-bbe92d5b19c6"/>
              <gml:surfaceMember xlink:href="#UUID_a1c5061f-270c-4721-b573-6a4ac1fa60a0"/>
              <gml:surfaceMember xlink:href="#UUID_5ccdccf8-d03d-476f-bd1d-6bf780d611bc"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1960-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2061-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1060</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_8E55CFA5-EB58-4196-A9BA-9BD77D4006F4">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_74C6CB1A-4588-4C25-AC1B-B94F1324FBDE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ea461e32-0512-4eef-8bf0-b213d1b2833b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 70.0 0.0 60.0 70.0 0.0 60.0 78.0 0.0 66.0 78.0 0.0 66.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FF82E8DF-2C9B-4CBF-A636-6CAB342A0B60">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_202d47bc-5c59-49e6-9cf2-5fec7fd23c7e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 70.0 0.0 66.0 70.0 0.0 66.0 70.0 6.0 63.0 70.0 12.0 60.0 70.0 6.0 60.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_26C550D3-A6CD-4851-80E2-5FBAA32471CC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d36ca582-56fc-41fc-9c5a-8136cd38f0bf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 78.0 0.0 60.0 78.0 0.0 60.0 78.0 6.0 63.0 78.0 12.0 66.0 78.0 6.0 66.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_52E5FB0B-3BD9-4673-B81A-FF3E5FA977B1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ffff5dc0-7fc1-41da-b0f1-edfc9587f35b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 70.0 0.0 60.0 70.0 6.0 60.0 78.0 6.0 60.0 78.0 0.0 60.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9EBFD715-68C4-445D-9164-4BB04B54F193">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f81ac31c-e5c2-468a-8292-3dd1b54ce755">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 78.0 0.0 66.0 78.0 6.0 66.0 70.0 6.0 66.0 70.0 0.0 66.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_29AD86B7-B727-4B38-A85A-8771C60FA6B9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c75088d8-3a03-436f-a8d4-450a5e4e45f5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 70.0 6.0 63.0 70.0 12.0 63.0 78.0 12.0 60.0 78.0 6.0 60.0 70.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2E99F23E-2651-4DEA-AB82-4D21A0F4A269">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b1633f1c-1a8f-458e-a832-a1fc9d054f64">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 78.0 6.0 63.0 78.0 12.0 63.0 70.0 12.0 66.0 70.0 6.0 66.0 78.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_ea461e32-0512-4eef-8bf0-b213d1b2833b"/>
              <gml:surfaceMember xlink:href="#UUID_202d47bc-5c59-49e6-9cf2-5fec7fd23c7e"/>
              <gml:surfaceMember xlink:href="#UUID_d36ca582-56fc-41fc-9c5a-8136cd38f0bf"/>
              <gml:surfaceMember xlink:href="#UUID_ffff5dc0-7fc1-41da-b0f1-edfc9587f35b"/>
              <gml:surfaceMember xlink:href="#UUID_f81ac31c-e5c2-468a-8292-3dd1b54ce755"/>
              <gml:surfaceMember xlink:href="#UUID_c75088d8-3a03-436f-a8d4-450a5e4e45f5"/>
              <gml:surfaceMember xlink:href="#UUID_b1633f1c-1a8f-458e-a832-a1fc9d054f64"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1943-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2079-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_31D2D0E9-37BF-4712-918E-E87A7276DDCA">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_5CB72437-37B1-4789-99C9-41E250C60DE6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b7e326de-9c63-491a-9116-1f017cdb106a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 70.0 0.0 70.0 70.0 0.0 70.0 78.0 0.0 76.0 78.0 0.0 76.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_CFA4A9A7-0274-40DB-AED2-32664C8841C9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c73e16c0-b37d-4bd4-9031-1387e17718e9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 70.0 0.0 76.0 70.0 0.0 76.0 70.0 6.0 73.0 70.0 9.0 70.0 70.0 6.0 70.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_F3B41BC7-BC8E-4348-B72B-23C9F1D34F21">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_25720cb4-81bb-44c4-a170-1dc3d7d5999c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 78.0 0.0 70.0 78.0 0.0 70.0 78.0 6.0 73.0 78.0 9.0 76.0 78.0 6.0 76.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A4588B31-DEDE-401F-8A28-52378349DEFA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c7cb1168-9813-4994-adde-602b4d360ce1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 70.0 0.0 70.0 70.0 6.0 70.0 78.0 6.0 70.0 78.0 0.0 70.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7EAB395E-6606-4D66-92E5-82F481F2C39D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4ec44b5c-3e5b-4596-bbe4-b003170e1f50">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 78.0 0.0 76.0 78.0 6.0 76.0 70.0 6.0 76.0 70.0 0.0 76.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_74BD15EC-D5F9-45AC-AE9A-C1000A0FCEC5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_28ef71ce-607f-46e1-9b2b-098221277185">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 70.0 6.0 73.0 70.0 9.0 73.0 78.0 9.0 70.0 78.0 6.0 70.0 70.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_13FBF161-A2BA-461E-A5D4-3448BE1D53CF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6468b415-791e-48dd-ad09-6a4c8f7559f3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 78.0 6.0 73.0 78.0 9.0 73.0 70.0 9.0 76.0 70.0 6.0 76.0 78.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_b7e326de-9c63-491a-9116-1f017cdb106a"/>
              <gml:surfaceMember xlink:href="#UUID_c73e16c0-b37d-4bd4-9031-1387e17718e9"/>
              <gml:surfaceMember xlink:href="#UUID_25720cb4-81bb-44c4-a170-1dc3d7d5999c"/>
              <gml:surfaceMember xlink:href="#UUID_c7cb1168-9813-4994-adde-602b4d360ce1"/>
              <gml:surfaceMember xlink:href="#UUID_4ec44b5c-3e5b-4596-bbe4-b003170e1f50"/>
              <gml:surfaceMember xlink:href="#UUID_28ef71ce-607f-46e1-9b2b-098221277185"/>
              <gml:surfaceMember xlink:href="#UUID_6468b415-791e-48dd-ad09-6a4c8f7559f3"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1935-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2075-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1170</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_5DB757D9-1228-491C-9C36-14A425EAC032">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_EE11E101-6A1C-45C3-B942-46B98C0F0A6F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_08cc5d9c-9442-44b4-863f-c02397b2d31f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 70.0 0.0 80.0 70.0 0.0 80.0 78.0 0.0 86.0 78.0 0.0 86.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3A0A233B-F09C-4F36-BC58-57AEE384AF2D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_920acd48-11ce-4e4b-925d-d7a51deec10d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 70.0 0.0 86.0 70.0 0.0 86.0 70.0 5.0 83.0 70.0 11.0 80.0 70.0 5.0 80.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EDE0C7FF-71A4-4F61-849E-5B288DC21E2A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6b64c8cd-4574-4857-990b-df02da8db227">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 78.0 0.0 80.0 78.0 0.0 80.0 78.0 5.0 83.0 78.0 11.0 86.0 78.0 5.0 86.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_27E1EF38-D97C-432C-8665-12BCD2B7E778">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f6e26f4c-e009-4701-bac6-a94358bc7f3a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 70.0 0.0 80.0 70.0 5.0 80.0 78.0 5.0 80.0 78.0 0.0 80.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_90376006-72A6-4615-9A51-005D3FE56881">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f5fc7b79-f37f-4dba-8d54-7cc34d7ae1e4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 78.0 0.0 86.0 78.0 5.0 86.0 70.0 5.0 86.0 70.0 0.0 86.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_4B90A94C-A6C7-462B-B9F9-B4235D980799">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_81559c4e-39c5-4c58-9ffb-a02594773f56">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 70.0 5.0 83.0 70.0 11.0 83.0 78.0 11.0 80.0 78.0 5.0 80.0 70.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_EA3A91A3-8880-4EFD-8844-80960325516A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_190852ab-7d91-441e-8b99-6b88d99acfaf">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 78.0 5.0 83.0 78.0 11.0 83.0 70.0 11.0 86.0 70.0 5.0 86.0 78.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_08cc5d9c-9442-44b4-863f-c02397b2d31f"/>
              <gml:surfaceMember xlink:href="#UUID_920acd48-11ce-4e4b-925d-d7a51deec10d"/>
              <gml:surfaceMember xlink:href="#UUID_6b64c8cd-4574-4857-990b-df02da8db227"/>
              <gml:surfaceMember xlink:href="#UUID_f6e26f4c-e009-4701-bac6-a94358bc7f3a"/>
              <gml:surfaceMember xlink:href="#UUID_f5fc7b79-f37f-4dba-8d54-7cc34d7ae1e4"/>
              <gml:surfaceMember xlink:href="#UUID_81559c4e-39c5-4c58-9ffb-a02594773f56"/>
              <gml:surfaceMember xlink:href="#UUID_190852ab-7d91-441e-8b99-6b88d99acfaf"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1960-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2093-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1040</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_238D28C9-68FF-47F0-939D-BA8A99E1DA75">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-7-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_5FEB1ABF-9C48-41B5-B5F6-DA283085A00E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fb5f0d8f-1829-42fe-ab9e-30746b590a1f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 70.0 0.0 90.0 70.0 0.0 90.0 78.0 0.0 96.0 78.0 0.0 96.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_510C37CC-E1D4-42EA-83D0-56EA6879A9DB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3bbd5e34-9d0b-4dbd-b302-7e57190fa072">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 70.0 0.0 96.0 70.0 0.0 96.0 70.0 6.0 93.0 70.0 8.0 90.0 70.0 6.0 90.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_84811F58-FA0A-4F8D-BDBE-83050B193856">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d10d3e37-20f2-4ef3-8ee1-b3aed8855720">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 78.0 0.0 90.0 78.0 0.0 90.0 78.0 6.0 93.0 78.0 8.0 96.0 78.0 6.0 96.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_80A9DEF0-6A03-4FDF-9B80-59F32E91C2E4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cadc252f-bded-44be-9e3d-0e4609cc8887">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 70.0 0.0 90.0 70.0 6.0 90.0 78.0 6.0 90.0 78.0 0.0 90.0 70.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_555D3748-F9F9-452A-A6FC-6FFC48EECD00">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_abe55db2-5200-4120-83ca-0ef25dd55afe">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 78.0 0.0 96.0 78.0 6.0 96.0 70.0 6.0 96.0 70.0 0.0 96.0 78.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_32C8D9E3-E689-4FDC-9352-EC8EF6B7BC97">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b0e39fee-4cc3-4732-881e-fcb8d221e6f6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 70.0 6.0 93.0 70.0 8.0 93.0 78.0 8.0 90.0 78.0 6.0 90.0 70.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_345C4D95-69FC-439A-9DED-F341371E8A83">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6fada051-27bb-4e76-83c2-87607c4d1bcc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 78.0 6.0 93.0 78.0 8.0 93.0 70.0 8.0 96.0 70.0 6.0 96.0 78.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_fb5f0d8f-1829-42fe-ab9e-30746b590a1f"/>
              <gml:surfaceMember xlink:href="#UUID_3bbd5e34-9d0b-4dbd-b302-7e57190fa072"/>
              <gml:surfaceMember xlink:href="#UUID_d10d3e37-20f2-4ef3-8ee1-b3aed8855720"/>
              <gml:surfaceMember xlink:href="#UUID_cadc252f-bded-44be-9e3d-0e4609cc8887"/>
              <gml:surfaceMember xlink:href="#UUID_abe55db2-5200-4120-83ca-0ef25dd55afe"/>
              <gml:surfaceMember xlink:href="#UUID_b0e39fee-4cc3-4732-881e-fcb8d221e6f6"/>
              <gml:surfaceMember xlink:href="#UUID_6fada051-27bb-4e76-83c2-87607c4d1bcc"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1901-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2096-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1170</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_B3BA0D65-A9A1-458A-9944-CE51B14BBA8B">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_3143AFF3-41A9-4D87-B4E0-88CAA042F2A6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a164dfb5-ca3f-4d6e-9cc3-3adfb505e3ec">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 80.0 0.0 0.0 80.0 0.0 0.0 88.0 0.0 6.0 88.0 0.0 6.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_90FE7E32-7FF4-4A36-BB26-D0B4072CB629">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a264c9a5-2a1b-40b5-bfe8-6abf0596a7c7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 80.0 0.0 6.0 80.0 0.0 6.0 80.0 7.0 3.0 80.0 10.0 0.0 80.0 7.0 0.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_8491F2A1-56B1-4F3E-9221-BED33EC5C0C3">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_793ba775-cd72-4e56-8746-5633777b9a99">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 88.0 0.0 0.0 88.0 0.0 0.0 88.0 7.0 3.0 88.0 10.0 6.0 88.0 7.0 6.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_051201FF-FA24-4FC4-8E98-22CAFDA7DEDF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5fc0a45b-32ca-4c1c-97cb-45abc770d6a4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 80.0 0.0 0.0 80.0 7.0 0.0 88.0 7.0 0.0 88.0 0.0 0.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D22A067D-95CF-43DE-BF95-9515250A9FEA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_322e2161-904a-4804-86f2-7814daffdd82">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 88.0 0.0 6.0 88.0 7.0 6.0 80.0 7.0 6.0 80.0 0.0 6.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F4B9F321-5B62-48C7-9E59-3F02379FA8B7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d6ee661f-af22-4c39-8e32-71689ea915bb">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 80.0 7.0 3.0 80.0 10.0 3.0 88.0 10.0 0.0 88.0 7.0 0.0 80.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_CC4D346B-211E-4B9F-BC3F-6DAA3821737E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_24cfc098-dc43-4b56-b1b4-fb31e7734833">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 88.0 7.0 3.0 88.0 10.0 3.0 80.0 10.0 6.0 80.0 7.0 6.0 88.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_a164dfb5-ca3f-4d6e-9cc3-3adfb505e3ec"/>
              <gml:surfaceMember xlink:href="#UUID_a264c9a5-2a1b-40b5-bfe8-6abf0596a7c7"/>
              <gml:surfaceMember xlink:href="#UUID_793ba775-cd72-4e56-8746-5633777b9a99"/>
              <gml:surfaceMember xlink:href="#UUID_5fc0a45b-32ca-4c1c-97cb-45abc770d6a4"/>
              <gml:surfaceMember xlink:href="#UUID_322e2161-904a-4804-86f2-7814daffdd82"/>
              <gml:surfaceMember xlink:href="#UUID_d6ee661f-af22-4c39-8e32-71689ea915bb"/>
              <gml:surfaceMember xlink:href="#UUID_24cfc098-dc43-4b56-b1b4-fb31e7734833"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1905-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2065-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1010</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_2128226D-4A64-4C9B-96F3-A711CEB247CE">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_A331CDEE-E74B-4BDA-A7A4-68BED1730254">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_64e21289-cc14-4ef4-9769-24714afddd0d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 80.0 0.0 10.0 80.0 0.0 10.0 88.0 0.0 16.0 88.0 0.0 16.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_35872545-E7E1-4E75-B98A-78DE3E5C3811">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fa74dc1b-9c68-4210-ac4c-38b30c5c2dc5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 80.0 0.0 16.0 80.0 0.0 16.0 80.0 6.0 13.0 80.0 10.0 10.0 80.0 6.0 10.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A7506A24-6707-41A5-A121-64DAB3993580">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_37ee587a-6930-4edb-9606-f62ad5da1693">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 88.0 0.0 10.0 88.0 0.0 10.0 88.0 6.0 13.0 88.0 10.0 16.0 88.0 6.0 16.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0B42C259-25D1-4BBF-8F67-CC899A9B0DCF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_36aeae18-d98d-435c-8f1b-ffe69993057e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 80.0 0.0 10.0 80.0 6.0 10.0 88.0 6.0 10.0 88.0 0.0 10.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B5EB5057-F487-4036-AFF5-3C0F25F87415">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9429e036-681b-4e9c-986c-680e4acc2194">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 88.0 0.0 16.0 88.0 6.0 16.0 80.0 6.0 16.0 80.0 0.0 16.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F8CB9C91-CCC1-47BF-991B-661203F3AE0D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_32f0c85a-b679-4e6c-9e0a-5d96de2f5a8d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 80.0 6.0 13.0 80.0 10.0 13.0 88.0 10.0 10.0 88.0 6.0 10.0 80.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_AF8C90D4-32FA-4370-9CDC-F2A18E6FFDDD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_35b4f7bf-0b60-408d-b4ba-3fdf3658f402">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 88.0 6.0 13.0 88.0 10.0 13.0 80.0 10.0 16.0 80.0 6.0 16.0 88.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_64e21289-cc14-4ef4-9769-24714afddd0d"/>
              <gml:surfaceMember xlink:href="#UUID_fa74dc1b-9c68-4210-ac4c-38b30c5c2dc5"/>
              <gml:surfaceMember xlink:href="#UUID_37ee587a-6930-4edb-9606-f62ad5da1693"/>
              <gml:surfaceMember xlink:href="#UUID_36aeae18-d98d-435c-8f1b-ffe69993057e"/>
              <gml:surfaceMember xlink:href="#UUID_9429e036-681b-4e9c-986c-680e4acc2194"/>
              <gml:surfaceMember xlink:href="#UUID_32f0c85a-b679-4e6c-9e0a-5d96de2f5a8d"/>
              <gml:surfaceMember xlink:href="#UUID_35b4f7bf-0b60-408d-b4ba-3fdf3658f402"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1932-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2026-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1080</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_A71043B3-2F75-4823-8DA8-191FCE24F34D">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_74FBE825-FBCF-4821-A641-9A573C671485">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8371dd4e-26ce-429b-aa39-e03dad790437">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 80.0 0.0 20.0 80.0 0.0 20.0 88.0 0.0 26.0 88.0 0.0 26.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B69FF60C-0787-4AA8-9154-234395758F99">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_cb40e0fa-422d-4e10-bdd9-fbfa1b3143e0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 80.0 0.0 26.0 80.0 0.0 26.0 80.0 5.0 23.0 80.0 11.0 20.0 80.0 5.0 20.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5B5ABBC6-3E7D-43EF-B515-38D4927C4824">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6b8c1129-df07-4467-b556-538da9992515">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 88.0 0.0 20.0 88.0 0.0 20.0 88.0 5.0 23.0 88.0 11.0 26.0 88.0 5.0 26.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9D002FC5-3FFD-45BF-9500-F291859307B4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e9b3acef-1456-4afe-ae5e-511be38761f8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 80.0 0.0 20.0 80.0 5.0 20.0 88.0 5.0 20.0 88.0 0.0 20.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4A05ACD3-1055-4E9B-9B41-66B12C38EEF7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f66563ba-bdfa-495f-9db4-0e23759c277e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 88.0 0.0 26.0 88.0 5.0 26.0 80.0 5.0 26.0 80.0 0.0 26.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_81E44586-4DC3-46CB-8648-B49189ED15C8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_84bf7ae4-2c2e-40c0-a15e-4d4278d717d7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 80.0 5.0 23.0 80.0 11.0 23.0 88.0 11.0 20.0 88.0 5.0 20.0 80.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3843E971-3214-4DD9-8B4A-BC31DF10DED0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b59c330f-8ba8-4d92-bca8-6c28fece171f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 88.0 5.0 23.0 88.0 11.0 23.0 80.0 11.0 26.0 80.0 5.0 26.0 88.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_8371dd4e-26ce-429b-aa39-e03dad790437"/>
              <gml:surfaceMember xlink:href="#UUID_cb40e0fa-422d-4e10-bdd9-fbfa1b3143e0"/>
              <gml:surfaceMember xlink:href="#UUID_6b8c1129-df07-4467-b556-538da9992515"/>
              <gml:surfaceMember xlink:href="#UUID_e9b3acef-1456-4afe-ae5e-511be38761f8"/>
              <gml:surfaceMember xlink:href="#UUID_f66563ba-bdfa-495f-9db4-0e23759c277e"/>
              <gml:surfaceMember xlink:href="#UUID_84bf7ae4-2c2e-40c0-a15e-4d4278d717d7"/>
              <gml:surfaceMember xlink:href="#UUID_b59c330f-8ba8-4d92-bca8-6c28fece171f"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1981-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2053-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1120</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_84313F90-632D-4B5D-A969-1AB20172682A">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1DB5A648-D519-4A89-A128-9DE42600EDAE">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_943cf491-8bc6-49b2-8ebe-26fe262c497e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 80.0 0.0 30.0 80.0 0.0 30.0 88.0 0.0 36.0 88.0 0.0 36.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_31AC5A04-F01D-42A6-B43A-0A931E1E2F80">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_42dee1ab-a3a9-4f4b-a792-47e925474f5d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 80.0 0.0 36.0 80.0 0.0 36.0 80.0 6.0 33.0 80.0 11.0 30.0 80.0 6.0 30.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2E934702-0750-4D4D-B59F-229D0D7E8272">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a83c99dc-bf0c-4e41-bb79-d3c11d2b9587">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 88.0 0.0 30.0 88.0 0.0 30.0 88.0 6.0 33.0 88.0 11.0 36.0 88.0 6.0 36.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3FF968BE-DC76-4689-B11D-C613357D69C4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ebbd677f-3051-4d84-bbc0-f2d013977311">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 80.0 0.0 30.0 80.0 6.0 30.0 88.0 6.0 30.0 88.0 0.0 30.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_ABC73845-3BA8-4194-91D0-D1432AEFE63A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_af3e3e5f-2617-4c5a-9977-f79c249bc146">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 88.0 0.0 36.0 88.0 6.0 36.0 80.0 6.0 36.0 80.0 0.0 36.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3B781C9C-A510-45E2-ACB9-439F2F8DCFFF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ffee7899-119e-455f-8afa-ca9f7f28cbb3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 80.0 6.0 33.0 80.0 11.0 33.0 88.0 11.0 30.0 88.0 6.0 30.0 80.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_8EF6303A-731D-44D4-9795-52B568C290AD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1c76ae9a-a609-4fa3-8d23-0807ffd93e15">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 88.0 6.0 33.0 88.0 11.0 33.0 80.0 11.0 36.0 80.0 6.0 36.0 88.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_943cf491-8bc6-49b2-8ebe-26fe262c497e"/>
              <gml:surfaceMember xlink:href="#UUID_42dee1ab-a3a9-4f4b-a792-47e925474f5d"/>
              <gml:surfaceMember xlink:href="#UUID_a83c99dc-bf0c-4e41-bb79-d3c11d2b9587"/>
              <gml:surfaceMember xlink:href="#UUID_ebbd677f-3051-4d84-bbc0-f2d013977311"/>
              <gml:surfaceMember xlink:href="#UUID_af3e3e5f-2617-4c5a-9977-f79c249bc146"/>
              <gml:surfaceMember xlink:href="#UUID_ffee7899-119e-455f-8afa-ca9f7f28cbb3"/>
              <gml:surfaceMember xlink:href="#UUID_1c76ae9a-a609-4fa3-8d23-0807ffd93e15"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1977-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2026-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1030</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_6DA30A06-6165-405F-B2BD-D2524CA03F16">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_A32C0F66-511B-4E30-B4A5-C6867A8E9C9F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6d37ad04-9603-45c1-b011-b6ce1d095e65">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 80.0 0.0 40.0 80.0 0.0 40.0 88.0 0.0 46.0 88.0 0.0 46.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_072348F5-8FCE-4F8B-84F7-3A6BA3DEA3E6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6901d945-c9dd-490e-a4b6-180bb08669be">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 80.0 0.0 46.0 80.0 0.0 46.0 80.0 4.0 43.0 80.0 12.0 40.0 80.0 4.0 40.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4D788E80-2201-44C2-A1B6-539A561C6E08">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8b655a54-7d46-4309-a66e-e93e9952d55a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 88.0 0.0 40.0 88.0 0.0 40.0 88.0 4.0 43.0 88.0 12.0 46.0 88.0 4.0 46.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5ACE3EF3-5013-4118-9FFA-D8FC914A3688">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a1e621f8-d09c-487e-8344-edc52e07eadd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 80.0 0.0 40.0 80.0 4.0 40.0 88.0 4.0 40.0 88.0 0.0 40.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_02120F78-AC5D-423B-94AE-697940733BAB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6f592440-1ed0-4169-ad6a-03264f5ec7d8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 88.0 0.0 46.0 88.0 4.0 46.0 80.0 4.0 46.0 80.0 0.0 46.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F4006A3B-7019-449A-B413-D13D741074E5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fc5fb02c-10c3-41f6-bc9b-7d157e0467a7">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 80.0 4.0 43.0 80.0 12.0 43.0 88.0 12.0 40.0 88.0 4.0 40.0 80.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_920B6964-7952-4FFF-927F-30F4E3125174">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_40e1e5f0-2551-40e9-972d-4973dfa6331b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 88.0 4.0 43.0 88.0 12.0 43.0 80.0 12.0 46.0 80.0 4.0 46.0 88.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_6d37ad04-9603-45c1-b011-b6ce1d095e65"/>
              <gml:surfaceMember xlink:href="#UUID_6901d945-c9dd-490e-a4b6-180bb08669be"/>
              <gml:surfaceMember xlink:href="#UUID_8b655a54-7d46-4309-a66e-e93e9952d55a"/>
              <gml:surfaceMember xlink:href="#UUID_a1e621f8-d09c-487e-8344-edc52e07eadd"/>
              <gml:surfaceMember xlink:href="#UUID_6f592440-1ed0-4169-ad6a-03264f5ec7d8"/>
              <gml:surfaceMember xlink:href="#UUID_fc5fb02c-10c3-41f6-bc9b-7d157e0467a7"/>
              <gml:surfaceMember xlink:href="#UUID_40e1e5f0-2551-40e9-972d-4973dfa6331b"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1924-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2094-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1030</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_8B590983-7D9E-4DA3-BF38-2592FF977578">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_B956083E-A908-4EFF-9086-87D9188309F7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_26a7e3ce-235d-4803-8e24-178931419426">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 80.0 0.0 50.0 80.0 0.0 50.0 88.0 0.0 56.0 88.0 0.0 56.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AAB746DA-BA26-4155-8F7F-FAA06BD05498">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1fa5108f-3d45-4073-a306-bf1092fb4b6b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 80.0 0.0 56.0 80.0 0.0 56.0 80.0 6.0 53.0 80.0 11.0 50.0 80.0 6.0 50.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_53A5734E-C42D-4915-9D8B-50499C442CB7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_52766d49-6302-4c06-aced-246ae259a677">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 88.0 0.0 50.0 88.0 0.0 50.0 88.0 6.0 53.0 88.0 11.0 56.0 88.0 6.0 56.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_1AF4F67E-6C8F-4DDE-B20B-3F98337D571F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fec83414-8093-4d13-9d96-935761247d6c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 80.0 0.0 50.0 80.0 6.0 50.0 88.0 6.0 50.0 88.0 0.0 50.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_06937C5A-62A2-4489-8193-B77C64C00E52">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e55ef946-cc64-442f-bc55-5257bde272cc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 88.0 0.0 56.0 88.0 6.0 56.0 80.0 6.0 56.0 80.0 0.0 56.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_4B4007D0-3586-4B04-9FB5-FE1898989B44">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3f3fcf19-7a0d-45c3-89d0-52bcfb2f4af1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 80.0 6.0 53.0 80.0 11.0 53.0 88.0 11.0 50.0 88.0 6.0 50.0 80.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_E24113AC-16A4-4EF6-B6CC-D1E591E8A6C8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_536586d0-46bb-4045-8373-107f96a04bdc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 88.0 6.0 53.0 88.0 11.0 53.0 80.0 11.0 56.0 80.0 6.0 56.0 88.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_26a7e3ce-235d-4803-8e24-178931419426"/>
              <gml:surfaceMember xlink:href="#UUID_1fa5108f-3d45-4073-a306-bf1092fb4b6b"/>
              <gml:surfaceMember xlink:href="#UUID_52766d49-6302-4c06-aced-246ae259a677"/>
              <gml:surfaceMember xlink:href="#UUID_fec83414-8093-4d13-9d96-935761247d6c"/>
              <gml:surfaceMember xlink:href="#UUID_e55ef946-cc64-442f-bc55-5257bde272cc"/>
              <gml:surfaceMember xlink:href="#UUID_3f3fcf19-7a0d-45c3-89d0-52bcfb2f4af1"/>
              <gml:surfaceMember xlink:href="#UUID_536586d0-46bb-4045-8373-107f96a04bdc"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1976-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2045-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1140</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_3EAE0942-D98B-44CE-B410-88315C598D84">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1CE61E2D-C224-43F2-820C-1323D45CA136">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d5b2c6a9-a326-4970-b3df-433cd45d466d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 80.0 0.0 60.0 80.0 0.0 60.0 88.0 0.0 66.0 88.0 0.0 66.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3198FBD9-F452-40E7-99E8-D01D5D313143">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0a87d30e-2314-4d82-9974-0fde5cfb3622">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 80.0 0.0 66.0 80.0 0.0 66.0 80.0 4.0 63.0 80.0 12.0 60.0 80.0 4.0 60.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_15957036-86CD-4A61-81E0-0FC627044C66">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_25ba8dfe-4681-42ac-85f8-01202b3db00f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 88.0 0.0 60.0 88.0 0.0 60.0 88.0 4.0 63.0 88.0 12.0 66.0 88.0 4.0 66.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EAC7D9FB-5531-4552-AEF0-D92BC64FEB3B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ea219748-a780-4ce9-a7d2-87ae6ebe38cd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 80.0 0.0 60.0 80.0 4.0 60.0 88.0 4.0 60.0 88.0 0.0 60.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_644638BF-999B-4E52-928C-B15698B364F7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_617e2ca1-f6a8-464f-b8d5-f2073df1dd08">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 88.0 0.0 66.0 88.0 4.0 66.0 80.0 4.0 66.0 80.0 0.0 66.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_50CFD0E5-1592-4225-A4F4-442A07430BD0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f1eed7ce-593c-481f-b92d-683c9fae5f90">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 80.0 4.0 63.0 80.0 12.0 63.0 88.0 12.0 60.0 88.0 4.0 60.0 80.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_00082F2B-9468-4784-A13A-3FBA7462EAE7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f9be1bfe-82a4-48c0-a484-949a2d9dd4b1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 88.0 4.0 63.0 88.0 12.0 63.0 80.0 12.0 66.0 80.0 4.0 66.0 88.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_d5b2c6a9-a326-4970-b3df-433cd45d466d"/>
              <gml:surfaceMember xlink:href="#UUID_0a87d30e-2314-4d82-9974-0fde5cfb3622"/>
              <gml:surfaceMember xlink:href="#UUID_25ba8dfe-4681-42ac-85f8-01202b3db00f"/>
              <gml:surfaceMember xlink:href="#UUID_ea219748-a780-4ce9-a7d2-87ae6ebe38cd"/>
              <gml:surfaceMember xlink:href="#UUID_617e2ca1-f6a8-464f-b8d5-f2073df1dd08"/>
              <gml:surfaceMember xlink:href="#UUID_f1eed7ce-593c-481f-b92d-683c9fae5f90"/>
              <gml:surfaceMember xlink:href="#UUID_f9be1bfe-82a4-48c0-a484-949a2d9dd4b1"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1955-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2048-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1060</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_8DAA8E79-029F-410A-B7DC-EF580E49ED4B">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_32A566DF-C1BA-4F80-9898-752C659B1E10">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c43f50b7-e33e-4f96-9f32-90da4eedf351">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 80.0 0.0 70.0 80.0 0.0 70.0 88.0 0.0 76.0 88.0 0.0 76.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FF9AC0F3-2B0E-469F-BA28-54ED4B4B06AA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d38bebaf-7035-4570-8b77-c79689d39894">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 80.0 0.0 76.0 80.0 0.0 76.0 80.0 3.0 73.0 80.0 11.0 70.0 80.0 3.0 70.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C0A37C16-A72E-46AE-88AA-205AA7BB541A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_95ef0dc2-506a-4dff-9543-9b62a44687a4">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 88.0 0.0 70.0 88.0 0.0 70.0 88.0 3.0 73.0 88.0 11.0 76.0 88.0 3.0 76.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_51B884F3-9D74-425B-8104-D7C86D6943F0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2fa75ac3-127c-40d5-9aa2-2e1f5447eb39">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 80.0 0.0 70.0 80.0 3.0 70.0 88.0 3.0 70.0 88.0 0.0 70.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_91988DF5-1E82-4F68-B054-1FF00648A708">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_36cfe1f7-6694-413d-8156-60159d065e1c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 88.0 0.0 76.0 88.0 3.0 76.0 80.0 3.0 76.0 80.0 0.0 76.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_8C79B35B-A938-45C5-A2DC-A4F44322D368">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2a42df34-2401-4f32-a8bb-711d50b04a35">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 80.0 3.0 73.0 80.0 11.0 73.0 88.0 11.0 70.0 88.0 3.0 70.0 80.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_637172BA-185D-4F70-BC73-9AFA90118DB9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b710bf95-4200-4202-ab96-dacfa20c6bc1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 88.0 3.0 73.0 88.0 11.0 73.0 80.0 11.0 76.0 80.0 3.0 76.0 88.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_c43f50b7-e33e-4f96-9f32-90da4eedf351"/>
              <gml:surfaceMember xlink:href="#UUID_d38bebaf-7035-4570-8b77-c79689d39894"/>
              <gml:surfaceMember xlink:href="#UUID_95ef0dc2-506a-4dff-9543-9b62a44687a4"/>
              <gml:surfaceMember xlink:href="#UUID_2fa75ac3-127c-40d5-9aa2-2e1f5447eb39"/>
              <gml:surfaceMember xlink:href="#UUID_36cfe1f7-6694-413d-8156-60159d065e1c"/>
              <gml:surfaceMember xlink:href="#UUID_2a42df34-2401-4f32-a8bb-711d50b04a35"/>
              <gml:surfaceMember xlink:href="#UUID_b710bf95-4200-4202-ab96-dacfa20c6bc1"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1963-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2087-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1010</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_A6183331-69EE-44AC-B55F-4AB795B95545">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_175F4C46-E61F-485E-AA3E-7249229FF06D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2987aa33-d435-4855-9e55-40bd73650b60">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 80.0 0.0 80.0 80.0 0.0 80.0 88.0 0.0 86.0 88.0 0.0 86.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_C5B62E5D-E088-4938-88AD-715A82F2F6E8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3531a29a-ff4d-460b-a1fb-2788464943bd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 80.0 0.0 86.0 80.0 0.0 86.0 80.0 5.0 83.0 80.0 8.0 80.0 80.0 5.0 80.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_853908F2-4CDC-4EB1-8813-9EA6B557A174">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_276a7082-c845-48cf-a8da-a36fa712d367">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 88.0 0.0 80.0 88.0 0.0 80.0 88.0 5.0 83.0 88.0 8.0 86.0 88.0 5.0 86.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_99BEEE90-ED3E-4930-BF49-D3FD18F7DA94">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1b01e701-110f-4ade-831e-27f590923593">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 80.0 0.0 80.0 80.0 5.0 80.0 88.0 5.0 80.0 88.0 0.0 80.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7DA3E4E9-A1AB-4D79-A199-9DD9458FBAF7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d35e0c7b-29e0-4e97-b5dd-e60a6621b9df">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 88.0 0.0 86.0 88.0 5.0 86.0 80.0 5.0 86.0 80.0 0.0 86.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5BD9B739-24CF-4167-B9AD-377AD7162D63">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ee7d3f43-8a21-4f33-beb1-73e81ccfdb4a">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 80.0 5.0 83.0 80.0 8.0 83.0 88.0 8.0 80.0 88.0 5.0 80.0 80.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_5B85B4F4-A6C7-40CE-B002-1F6B3C55CAAF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_e06db938-ba15-4c28-b94d-bdbd2c1746dc">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 88.0 5.0 83.0 88.0 8.0 83.0 80.0 8.0 86.0 80.0 5.0 86.0 88.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_2987aa33-d435-4855-9e55-40bd73650b60"/>
              <gml:surfaceMember xlink:href="#UUID_3531a29a-ff4d-460b-a1fb-2788464943bd"/>
              <gml:surfaceMember xlink:href="#UUID_276a7082-c845-48cf-a8da-a36fa712d367"/>
              <gml:surfaceMember xlink:href="#UUID_1b01e701-110f-4ade-831e-27f590923593"/>
              <gml:surfaceMember xlink:href="#UUID_d35e0c7b-29e0-4e97-b5dd-e60a6621b9df"/>
              <gml:surfaceMember xlink:href="#UUID_ee7d3f43-8a21-4f33-beb1-73e81ccfdb4a"/>
              <gml:surfaceMember xlink:href="#UUID_e06db938-ba15-4c28-b94d-bdbd2c1746dc"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1977-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2050-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1180</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_095C8695-5509-4767-8E3F-33290157D891">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-8-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_2B69AD92-8947-46F5-B3FD-E2FAF9D91F0F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_473797ed-ceee-4ab6-99fd-b10f6d83dbe2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 80.0 0.0 90.0 80.0 0.0 90.0 88.0 0.0 96.0 88.0 0.0 96.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E2D3AEC7-4CF0-49D1-9F26-707629958C48">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_16c63356-ab9b-49af-ae07-693c3f4a13f1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 80.0 0.0 96.0 80.0 0.0 96.0 80.0 3.0 93.0 80.0 11.0 90.0 80.0 3.0 90.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9E18C500-04FA-45ED-9360-BEF22E5AA3C8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2e5543d9-b8c3-41e7-bdfe-027f4f7b6d5d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 88.0 0.0 90.0 88.0 0.0 90.0 88.0 3.0 93.0 88.0 11.0 96.0 88.0 3.0 96.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_703BC2F0-C772-4968-87F7-640AFD02AB34">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5aa06da1-430f-483d-8162-c4a55008f4ce">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 80.0 0.0 90.0 80.0 3.0 90.0 88.0 3.0 90.0 88.0 0.0 90.0 80.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_E8EE51BF-26A8-4B9F-A75C-B1B0385B87A5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1da74cf0-80a1-4943-84ac-5300485dbae2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 88.0 0.0 96.0 88.0 3.0 96.0 80.0 3.0 96.0 80.0 0.0 96.0 88.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_989CB641-A75D-43CA-A5BC-519DA3B56A99">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_bab42a85-591b-4202-b997-b75d9fc05300">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 80.0 3.0 93.0 80.0 11.0 93.0 88.0 11.0 90.0 88.0 3.0 90.0 80.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_C028AE9A-2005-4098-B6A7-8C71FA1181E1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_901da733-1fc5-496d-9ca0-418a266e20d1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 88.0 3.0 93.0 88.0 11.0 93.0 80.0 11.0 96.0 80.0 3.0 96.0 88.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_473797ed-ceee-4ab6-99fd-b10f6d83dbe2"/>
              <gml:surfaceMember xlink:href="#UUID_16c63356-ab9b-49af-ae07-693c3f4a13f1"/>
              <gml:surfaceMember xlink:href="#UUID_2e5543d9-b8c3-41e7-bdfe-027f4f7b6d5d"/>
              <gml:surfaceMember xlink:href="#UUID_5aa06da1-430f-483d-8162-c4a55008f4ce"/>
              <gml:surfaceMember xlink:href="#UUID_1da74cf0-80a1-4943-84ac-5300485dbae2"/>
              <gml:surfaceMember xlink:href="#UUID_bab42a85-591b-4202-b997-b75d9fc05300"/>
              <gml:surfaceMember xlink:href="#UUID_901da733-1fc5-496d-9ca0-418a266e20d1"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1990-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2047-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1120</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>5</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_2B10D21D-573A-4BF2-B364-201201E891B5">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-0_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_6F95F209-5A63-477F-9A96-24864DF2C702">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_74893a97-e384-40ae-85b8-9e02193e50cd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 90.0 0.0 0.0 90.0 0.0 0.0 98.0 0.0 6.0 98.0 0.0 6.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BFBDD01F-EC9C-4BE9-966F-6BF9318BCB36">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_969ffbd4-f289-4de4-b0fd-7147b394b104">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 90.0 0.0 6.0 90.0 0.0 6.0 90.0 4.0 3.0 90.0 11.0 0.0 90.0 4.0 0.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EC788598-EC6E-4379-9C62-480547DDDE82">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8698a07f-a663-4d75-85ee-c6ccbd359c0e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 98.0 0.0 0.0 98.0 0.0 0.0 98.0 4.0 3.0 98.0 11.0 6.0 98.0 4.0 6.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_56B08095-BB30-4BDE-9EA4-7403815D29DA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_4749b8e4-74ca-4d4a-b306-d67c44b80e09">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 90.0 0.0 0.0 90.0 4.0 0.0 98.0 4.0 0.0 98.0 0.0 0.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7847CDC7-9519-4108-9E78-895F2D00D069">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_48b3ba6a-ba43-4f92-9669-7932871b4fc2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 98.0 0.0 6.0 98.0 4.0 6.0 90.0 4.0 6.0 90.0 0.0 6.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_E5F5A2CA-77F8-4129-8C00-C235EF2753EC">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ddde22e9-0b62-4568-9cae-7f3a5e08731b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">0.0 90.0 4.0 3.0 90.0 11.0 3.0 98.0 11.0 0.0 98.0 4.0 0.0 90.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_25503830-9974-418C-8B55-4383482F3323">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_811a04f4-b7f0-4782-8328-e7607f3e5816">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">6.0 98.0 4.0 3.0 98.0 11.0 3.0 90.0 11.0 6.0 90.0 4.0 6.0 98.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_74893a97-e384-40ae-85b8-9e02193e50cd"/>
              <gml:surfaceMember xlink:href="#UUID_969ffbd4-f289-4de4-b0fd-7147b394b104"/>
              <gml:surfaceMember xlink:href="#UUID_8698a07f-a663-4d75-85ee-c6ccbd359c0e"/>
              <gml:surfaceMember xlink:href="#UUID_4749b8e4-74ca-4d4a-b306-d67c44b80e09"/>
              <gml:surfaceMember xlink:href="#UUID_48b3ba6a-ba43-4f92-9669-7932871b4fc2"/>
              <gml:surfaceMember xlink:href="#UUID_ddde22e9-0b62-4568-9cae-7f3a5e08731b"/>
              <gml:surfaceMember xlink:href="#UUID_811a04f4-b7f0-4782-8328-e7607f3e5816"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1975-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2055-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1070</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_0B982C92-BFF6-4EEE-8C5F-78BB2DDCCC40">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-1_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_6FF8F227-18FB-4286-AEE1-6258B5E8251F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fd2de933-3259-451e-9eb6-3807b03264e2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 90.0 0.0 10.0 90.0 0.0 10.0 98.0 0.0 16.0 98.0 0.0 16.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A1986CE4-F0CE-425B-9CFB-B89DC5A01EBA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ebf8acdf-ca86-4463-9e16-e2dad84e4463">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 90.0 0.0 16.0 90.0 0.0 16.0 90.0 4.0 13.0 90.0 8.0 10.0 90.0 4.0 10.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_549748E2-8CD9-4EF4-8659-9E5E55498E8C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d670b23c-25e5-47c0-96eb-bc481e515c08">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 98.0 0.0 10.0 98.0 0.0 10.0 98.0 4.0 13.0 98.0 8.0 16.0 98.0 4.0 16.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FAF7AF06-56AC-4227-AA2B-D634FE2C5E9A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_70955020-c6d5-462f-9514-1f57a10a0af5">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 90.0 0.0 10.0 90.0 4.0 10.0 98.0 4.0 10.0 98.0 0.0 10.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_578A7485-1214-45CB-9B3E-B18A208C7D8D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_250dbe75-5211-4019-a5ad-5f9b954d708f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 98.0 0.0 16.0 98.0 4.0 16.0 90.0 4.0 16.0 90.0 0.0 16.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_A605ADC0-7296-4F30-92E6-F5108457B1AF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c4a979ba-0f86-45d9-b0e3-144a63484518">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">10.0 90.0 4.0 13.0 90.0 8.0 13.0 98.0 8.0 10.0 98.0 4.0 10.0 90.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F8D98B36-6E5A-46F2-B9D4-5F172C4B946B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c865c3c8-1cf0-4da4-82f0-ba44b09e3ca3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">16.0 98.0 4.0 13.0 98.0 8.0 13.0 90.0 8.0 16.0 90.0 4.0 16.0 98.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_fd2de933-3259-451e-9eb6-3807b03264e2"/>
              <gml:surfaceMember xlink:href="#UUID_ebf8acdf-ca86-4463-9e16-e2dad84e4463"/>
              <gml:surfaceMember xlink:href="#UUID_d670b23c-25e5-47c0-96eb-bc481e515c08"/>
              <gml:surfaceMember xlink:href="#UUID_70955020-c6d5-462f-9514-1f57a10a0af5"/>
              <gml:surfaceMember xlink:href="#UUID_250dbe75-5211-4019-a5ad-5f9b954d708f"/>
              <gml:surfaceMember xlink:href="#UUID_c4a979ba-0f86-45d9-b0e3-144a63484518"/>
              <gml:surfaceMember xlink:href="#UUID_c865c3c8-1cf0-4da4-82f0-ba44b09e3ca3"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1998-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2043-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">8.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1020</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_B22F37F1-4DC7-4FFB-AC04-451753A8D504">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-2_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_1F740F5B-A99C-4667-9219-21D30474D9E5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1659d3f6-53c0-49cf-b431-b40f2357eb82">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 90.0 0.0 20.0 90.0 0.0 20.0 98.0 0.0 26.0 98.0 0.0 26.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_FC7EE6B3-1DD0-4AF2-93F2-DF5AC1CE0A0A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0458707c-3c9e-4ae1-98d3-ce3eaee799e3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 90.0 0.0 26.0 90.0 0.0 26.0 90.0 4.0 23.0 90.0 12.0 20.0 90.0 4.0 20.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_31007552-EA27-445C-8FED-925F2F6693C9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7b509f1b-eeb4-4a28-94a6-fa1b71559eb9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 98.0 0.0 20.0 98.0 0.0 20.0 98.0 4.0 23.0 98.0 12.0 26.0 98.0 4.0 26.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_84D0F291-048D-423F-8E35-57ACFCC7E7FD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9829abcf-9ac8-45cf-bec9-31c6665f70a6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 90.0 0.0 20.0 90.0 4.0 20.0 98.0 4.0 20.0 98.0 0.0 20.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0718ABFC-7DB0-4383-9892-2B97126FA9ED">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_fea0e4e8-4e60-4db6-9f9f-b17e63d34639">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 98.0 0.0 26.0 98.0 4.0 26.0 90.0 4.0 26.0 90.0 0.0 26.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_6B739474-AA6E-43A8-9EAF-C7C979034DE7">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_1e217282-004f-44d8-9a27-955f690438d0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">20.0 90.0 4.0 23.0 90.0 12.0 23.0 98.0 12.0 20.0 98.0 4.0 20.0 90.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2621ACBA-C65E-4A88-8804-AC331C785698">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_44302626-f2dd-4ddf-afaa-53298f51c238">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">26.0 98.0 4.0 23.0 98.0 12.0 23.0 90.0 12.0 26.0 90.0 4.0 26.0 98.0 4.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_1659d3f6-53c0-49cf-b431-b40f2357eb82"/>
              <gml:surfaceMember xlink:href="#UUID_0458707c-3c9e-4ae1-98d3-ce3eaee799e3"/>
              <gml:surfaceMember xlink:href="#UUID_7b509f1b-eeb4-4a28-94a6-fa1b71559eb9"/>
              <gml:surfaceMember xlink:href="#UUID_9829abcf-9ac8-45cf-bec9-31c6665f70a6"/>
              <gml:surfaceMember xlink:href="#UUID_fea0e4e8-4e60-4db6-9f9f-b17e63d34639"/>
              <gml:surfaceMember xlink:href="#UUID_1e217282-004f-44d8-9a27-955f690438d0"/>
              <gml:surfaceMember xlink:href="#UUID_44302626-f2dd-4ddf-afaa-53298f51c238"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1917-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2044-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1140</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_27BA9457-2728-4BE4-9B91-FDD9E3794C99">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-3_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_2B26ED50-7509-4C56-9B4E-7AE4D52F2A96">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9066e40c-cacd-4523-a316-96791b05a0af">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 90.0 0.0 30.0 90.0 0.0 30.0 98.0 0.0 36.0 98.0 0.0 36.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2A5AB239-9403-4A37-A282-43A34670CB2C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6e27d316-f472-4df6-8723-4df16cd187a1">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 90.0 0.0 36.0 90.0 0.0 36.0 90.0 5.0 33.0 90.0 10.0 30.0 90.0 5.0 30.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_5B583317-EA08-471A-8256-0DF123A44D03">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c87f9680-2f71-49ac-a693-53fd3d2727d9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 98.0 0.0 30.0 98.0 0.0 30.0 98.0 5.0 33.0 98.0 10.0 36.0 98.0 5.0 36.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BBFC712C-BE26-4CF5-8889-65DB80CB29F0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_03b5cb69-65d2-49cd-a0ce-4a1beed1ab01">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 90.0 0.0 30.0 90.0 5.0 30.0 98.0 5.0 30.0 98.0 0.0 30.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_262E90C5-3405-4756-86C0-94708B6B728E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b059312c-4ca6-44b7-94f6-7c3f2c03f587">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 98.0 0.0 36.0 98.0 5.0 36.0 90.0 5.0 36.0 90.0 0.0 36.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_2603F5CB-F766-4276-9153-A7577A58E8C9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a1e61414-b823-4564-a6f1-31f4f1f374de">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">30.0 90.0 5.0 33.0 90.0 10.0 33.0 98.0 10.0 30.0 98.0 5.0 30.0 90.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B43CA5F4-09D1-4EE5-8F2A-C997DEAB87A9">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8cc610f2-3896-4756-b39f-62ef7eb5934c">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">36.0 98.0 5.0 33.0 98.0 10.0 33.0 90.0 10.0 36.0 90.0 5.0 36.0 98.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_9066e40c-cacd-4523-a316-96791b05a0af"/>
              <gml:surfaceMember xlink:href="#UUID_6e27d316-f472-4df6-8723-4df16cd187a1"/>
              <gml:surfaceMember xlink:href="#UUID_c87f9680-2f71-49ac-a693-53fd3d2727d9"/>
              <gml:surfaceMember xlink:href="#UUID_03b5cb69-65d2-49cd-a0ce-4a1beed1ab01"/>
              <gml:surfaceMember xlink:href="#UUID_b059312c-4ca6-44b7-94f6-7c3f2c03f587"/>
              <gml:surfaceMember xlink:href="#UUID_a1e61414-b823-4564-a6f1-31f4f1f374de"/>
              <gml:surfaceMember xlink:href="#UUID_8cc610f2-3896-4756-b39f-62ef7eb5934c"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1932-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2031-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1010</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_451B81BF-75D5-468A-8B6B-E5B52E2BDE00">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-4_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_5610DE1D-956C-4D70-B6A6-9D2F5B40CA61">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_b198f6e9-c2ee-4c63-86ce-55b23983f3e6">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 90.0 0.0 40.0 90.0 0.0 40.0 98.0 0.0 46.0 98.0 0.0 46.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B4A78BFE-E30D-43CE-84B5-B0A30AC20BF5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d1348844-a83e-4294-8a83-2284f3ac17f8">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 90.0 0.0 46.0 90.0 0.0 46.0 90.0 7.0 43.0 90.0 11.0 40.0 90.0 7.0 40.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_AC740544-1966-468F-83B8-17D0E963E08F">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8bdb4b80-7bac-4c43-ae35-029a1a441047">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 98.0 0.0 40.0 98.0 0.0 40.0 98.0 7.0 43.0 98.0 11.0 46.0 98.0 7.0 46.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_B5335879-C8C0-46BF-88C0-7C9362CA9001">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ebf7522d-8c60-4833-9661-b6eab1226745">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 90.0 0.0 40.0 90.0 7.0 40.0 98.0 7.0 40.0 98.0 0.0 40.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0FBA7138-F316-4070-AF96-4D091A080C69">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_616d0bc5-e6ad-4c1c-964c-2b0215b4558d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 98.0 0.0 46.0 98.0 7.0 46.0 90.0 7.0 46.0 90.0 0.0 46.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_11A7E927-E0CB-4226-ADA3-6FE5B803649B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7cfe37a0-e808-4792-84ff-28be22b782ae">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">40.0 90.0 7.0 43.0 90.0 11.0 43.0 98.0 11.0 40.0 98.0 7.0 40.0 90.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_BA05ED8D-E431-4E00-9588-B84B473F9DE8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_79bec494-ec9c-4e79-b998-c512ab319e28">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">46.0 98.0 7.0 43.0 98.0 11.0 43.0 90.0 11.0 46.0 90.0 7.0 46.0 98.0 7.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_b198f6e9-c2ee-4c63-86ce-55b23983f3e6"/>
              <gml:surfaceMember xlink:href="#UUID_d1348844-a83e-4294-8a83-2284f3ac17f8"/>
              <gml:surfaceMember xlink:href="#UUID_8bdb4b80-7bac-4c43-ae35-029a1a441047"/>
              <gml:surfaceMember xlink:href="#UUID_ebf7522d-8c60-4833-9661-b6eab1226745"/>
              <gml:surfaceMember xlink:href="#UUID_616d0bc5-e6ad-4c1c-964c-2b0215b4558d"/>
              <gml:surfaceMember xlink:href="#UUID_7cfe37a0-e808-4792-84ff-28be22b782ae"/>
              <gml:surfaceMember xlink:href="#UUID_79bec494-ec9c-4e79-b998-c512ab319e28"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1955-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2069-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1150</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_3177EC0F-35DA-44B5-BF8D-A1E71D73963B">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-5_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_15864EC1-2EC2-40B9-93F0-2FA34205C108">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ee851158-aa4a-4850-9a6c-47840c0cfac9">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 90.0 0.0 50.0 90.0 0.0 50.0 98.0 0.0 56.0 98.0 0.0 56.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_A2DE3736-5F76-40F7-93CE-EC49DCB50899">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0be5c880-247f-40c7-8f32-a0b954b0150f">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 90.0 0.0 56.0 90.0 0.0 56.0 90.0 6.0 53.0 90.0 9.0 50.0 90.0 6.0 50.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_2A33D97D-A9E9-491F-A8B8-D1B04AE5CD52">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a6662847-0578-4220-b0e9-21a4d2bd389e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 98.0 0.0 50.0 98.0 0.0 50.0 98.0 6.0 53.0 98.0 9.0 56.0 98.0 6.0 56.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_4A9D290C-0E3E-497C-B3B6-1C90D35EBB80">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_290e34e5-132a-4efa-a944-45fab2987490">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 90.0 0.0 50.0 90.0 6.0 50.0 98.0 6.0 50.0 98.0 0.0 50.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_F10F2634-723E-4B75-95FF-211669E97E3A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_8eb1cb01-5251-49e8-a84c-afca3892bf56">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 98.0 0.0 56.0 98.0 6.0 56.0 90.0 6.0 56.0 90.0 0.0 56.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_E2C5D1E7-17F6-4279-A739-312551BBEE2B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_2ce92f9f-e759-4f12-ac7e-f0b5dfb08025">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">50.0 90.0 6.0 53.0 90.0 9.0 53.0 98.0 9.0 50.0 98.0 6.0 50.0 90.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_461B04FD-CE65-4516-AB47-B2826777B34C">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_58a3dc8a-be36-4f97-beaf-fd4169e2a6de">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">56.0 98.0 6.0 53.0 98.0 9.0 53.0 90.0 9.0 56.0 90.0 6.0 56.0 98.0 6.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_ee851158-aa4a-4850-9a6c-47840c0cfac9"/>
              <gml:surfaceMember xlink:href="#UUID_0be5c880-247f-40c7-8f32-a0b954b0150f"/>
              <gml:surfaceMember xlink:href="#UUID_a6662847-0578-4220-b0e9-21a4d2bd389e"/>
              <gml:surfaceMember xlink:href="#UUID_290e34e5-132a-4efa-a944-45fab2987490"/>
              <gml:surfaceMember xlink:href="#UUID_8eb1cb01-5251-49e8-a84c-afca3892bf56"/>
              <gml:surfaceMember xlink:href="#UUID_2ce92f9f-e759-4f12-ac7e-f0b5dfb08025"/>
              <gml:surfaceMember xlink:href="#UUID_58a3dc8a-be36-4f97-beaf-fd4169e2a6de"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1977-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2077-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1110</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>2</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_B95E22E7-65B0-4D8D-963D-20AC76763C55">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-6_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_5E5266E7-1A0F-4136-8D5D-5B95DBAA7DBF">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a5072084-1b78-4427-959f-4b8d3aede67b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 90.0 0.0 60.0 90.0 0.0 60.0 98.0 0.0 66.0 98.0 0.0 66.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_526BAC39-390B-4214-B75F-527884D6661B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_6d572d9a-3ee5-4eeb-a3be-f5aa5d34ee73">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 90.0 0.0 66.0 90.0 0.0 66.0 90.0 5.0 63.0 90.0 9.0 60.0 90.0 5.0 60.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9F1AAA3F-32F2-4526-B2D0-CAA4B2770826">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7a5ceb5e-9d76-42bd-b80a-1ac993bc0710">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 98.0 0.0 60.0 98.0 0.0 60.0 98.0 5.0 63.0 98.0 9.0 66.0 98.0 5.0 66.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7CB2AF91-B743-416E-A655-54B2816A0C93">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9a68b48c-cf61-4534-8b94-6dcce93cec97">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 90.0 0.0 60.0 90.0 5.0 60.0 98.0 5.0 60.0 98.0 0.0 60.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3BCCF9ED-EF6C-490F-810F-919353DED2CD">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_85b82887-a3cc-4c8f-9082-9a4202cd0e9e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 98.0 0.0 66.0 98.0 5.0 66.0 90.0 5.0 66.0 90.0 0.0 66.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_AD6AB7EF-14FE-4973-BF52-6275B72E98DB">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3eeb11f2-d840-4bb2-b488-a1eecf98842d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">60.0 90.0 5.0 63.0 90.0 9.0 63.0 98.0 9.0 60.0 98.0 5.0 60.0 90.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_02B42149-1C81-4AF3-979A-C85FC1A0E57D">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d6451fa7-2577-4870-bd9c-6bf2f4757ddd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">66.0 98.0 5.0 63.0 98.0 9.0 63.0 90.0 9.0 66.0 90.0 5.0 66.0 98.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_a5072084-1b78-4427-959f-4b8d3aede67b"/>
              <gml:surfaceMember xlink:href="#UUID_6d572d9a-3ee5-4eeb-a3be-f5aa5d34ee73"/>
              <gml:surfaceMember xlink:href="#UUID_7a5ceb5e-9d76-42bd-b80a-1ac993bc0710"/>
              <gml:surfaceMember xlink:href="#UUID_9a68b48c-cf61-4534-8b94-6dcce93cec97"/>
              <gml:surfaceMember xlink:href="#UUID_85b82887-a3cc-4c8f-9082-9a4202cd0e9e"/>
              <gml:surfaceMember xlink:href="#UUID_3eeb11f2-d840-4bb2-b488-a1eecf98842d"/>
              <gml:surfaceMember xlink:href="#UUID_d6451fa7-2577-4870-bd9c-6bf2f4757ddd"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1957-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2043-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">9.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1090</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>4</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_F3A9502A-8B1C-44BF-BC66-2043264B366B">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-7_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_DD9A7F5A-3F27-4FA7-AE80-EE0418DD9661">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f00b2165-6eb6-4a2a-b736-8add0c01d0fd">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 90.0 0.0 70.0 90.0 0.0 70.0 98.0 0.0 76.0 98.0 0.0 76.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_989A9B88-DC7B-42C5-BE0B-1731A0C52636">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_64d4b2bc-68c2-4771-93d0-2dbc384c1319">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 90.0 0.0 76.0 90.0 0.0 76.0 90.0 5.0 73.0 90.0 12.0 70.0 90.0 5.0 70.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_7CF94BF4-A9EE-45C1-A678-8A82A5E62A08">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3a7f19fd-fdda-4234-8daa-28c4976d8a25">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 98.0 0.0 70.0 98.0 0.0 70.0 98.0 5.0 73.0 98.0 12.0 76.0 98.0 5.0 76.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_BCE44094-C4EC-45D8-9E58-C5DFB4C4BE8A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5c467927-4635-48cb-a9b9-666da5269cd0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 90.0 0.0 70.0 90.0 5.0 70.0 98.0 5.0 70.0 98.0 0.0 70.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_EF586CD6-EC0F-4F33-9723-9E75FF01DAE6">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_c050adc7-d3e1-461d-8b5c-1d6f507134ad">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 98.0 0.0 76.0 98.0 5.0 76.0 90.0 5.0 76.0 90.0 0.0 76.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_BCC8A5F9-95EE-4F90-B34B-822C8C12E8D1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_5ace4820-6339-494b-8d91-184346d8d1b3">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">70.0 90.0 5.0 73.0 90.0 12.0 73.0 98.0 12.0 70.0 98.0 5.0 70.0 90.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_F54E287F-3999-469D-B10C-884AB9F3DECA">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7b5fe1f4-c6ba-4602-ae0a-5f34f6c5102d">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">76.0 98.0 5.0 73.0 98.0 12.0 73.0 90.0 12.0 76.0 90.0 5.0 76.0 98.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_f00b2165-6eb6-4a2a-b736-8add0c01d0fd"/>
              <gml:surfaceMember xlink:href="#UUID_64d4b2bc-68c2-4771-93d0-2dbc384c1319"/>
              <gml:surfaceMember xlink:href="#UUID_3a7f19fd-fdda-4234-8daa-28c4976d8a25"/>
              <gml:surfaceMember xlink:href="#UUID_5c467927-4635-48cb-a9b9-666da5269cd0"/>
              <gml:surfaceMember xlink:href="#UUID_c050adc7-d3e1-461d-8b5c-1d6f507134ad"/>
              <gml:surfaceMember xlink:href="#UUID_5ace4820-6339-494b-8d91-184346d8d1b3"/>
              <gml:surfaceMember xlink:href="#UUID_7b5fe1f4-c6ba-4602-ae0a-5f34f6c5102d"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1947-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2023-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">12.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1100</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>6</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">2.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_3854E349-060D-4B68-A508-43C4B50C8D63">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-8_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_408D627C-60FC-42B0-BEA8-93447C1835D5">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_0ceaf44a-823c-4287-9604-b7e22920c55e">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 90.0 0.0 80.0 90.0 0.0 80.0 98.0 0.0 86.0 98.0 0.0 86.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_22334A68-0381-4E03-A817-CA474FEED404">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_00c15de0-7a27-449c-80ab-5bdb8078e9b2">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 90.0 0.0 86.0 90.0 0.0 86.0 90.0 3.0 83.0 90.0 11.0 80.0 90.0 3.0 80.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0ADF8BD3-E855-404E-8817-EECFF3CA9886">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_9d0fa45c-60c2-489b-97ea-9e5df55abf92">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 98.0 0.0 80.0 98.0 0.0 80.0 98.0 3.0 83.0 98.0 11.0 86.0 98.0 3.0 86.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_9FB606F3-54AA-4BD7-8B3A-195484396133">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_ee69d561-b51d-48a8-991c-de025215d0e0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 90.0 0.0 80.0 90.0 3.0 80.0 98.0 3.0 80.0 98.0 0.0 80.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_05BFC484-2786-461F-AA4A-733CF966C7E1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_7e6bf0a7-9531-4337-99c4-03da8295bb48">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 98.0 0.0 86.0 98.0 3.0 86.0 90.0 3.0 86.0 90.0 0.0 86.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_9E7EB602-1777-40A4-97EE-4ABD33B0839A">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_963162f8-55c2-401e-97b5-b7cc2156d629">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">80.0 90.0 3.0 83.0 90.0 11.0 83.0 98.0 11.0 80.0 98.0 3.0 80.0 90.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_3FA0AD56-4694-4B89-B376-52C4B165C113">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_d67a6150-518b-4484-85c1-685875bf70e0">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">86.0 98.0 3.0 83.0 98.0 11.0 83.0 90.0 11.0 86.0 90.0 3.0 86.0 98.0 3.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_0ceaf44a-823c-4287-9604-b7e22920c55e"/>
              <gml:surfaceMember xlink:href="#UUID_00c15de0-7a27-449c-80ab-5bdb8078e9b2"/>
              <gml:surfaceMember xlink:href="#UUID_9d0fa45c-60c2-489b-97ea-9e5df55abf92"/>
              <gml:surfaceMember xlink:href="#UUID_ee69d561-b51d-48a8-991c-de025215d0e0"/>
              <gml:surfaceMember xlink:href="#UUID_7e6bf0a7-9531-4337-99c4-03da8295bb48"/>
              <gml:surfaceMember xlink:href="#UUID_963162f8-55c2-401e-97b5-b7cc2156d629"/>
              <gml:surfaceMember xlink:href="#UUID_d67a6150-518b-4484-85c1-685875bf70e0"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1938-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2028-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">11.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1040</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
  <cityObjectMember>
    <bldg:Building gml:id="FZK_GUID_57571072-D5A5-4104-BECE-155049240A3B">
      <gml:description>FZK/IAI test cases only</gml:description>
      <gml:name>Testcase-9-9_LoD2</gml:name>
      <boundary>
        <con:GroundSurface gml:id="FZK_GUID_5CE1EE97-E74C-46FB-B6C1-D8A5CA2A88B4">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dd43e4e0-5870-4d6e-8c51-54b4d6995d6b">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 90.0 0.0 90.0 90.0 0.0 90.0 98.0 0.0 96.0 98.0 0.0 96.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:GroundSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_D37C8B64-8822-481E-93CE-ACEEB5C00B7E">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_a3529c33-916d-44d9-a6e6-44c96add5c56">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 90.0 0.0 96.0 90.0 0.0 96.0 90.0 5.0 93.0 90.0 10.0 90.0 90.0 5.0 90.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_288374D4-5598-44F1-8C25-5F360FBA4286">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_667cd809-ae26-4153-a3a5-42a3c54e8986">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 98.0 0.0 90.0 98.0 0.0 90.0 98.0 5.0 93.0 98.0 10.0 96.0 98.0 5.0 96.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_0F70B9FD-42C2-4633-8CDC-F8692DB6B4E0">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_dac0390f-7fa6-46d0-bae0-5c6e7bebb3ec">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 90.0 0.0 90.0 90.0 5.0 90.0 98.0 5.0 90.0 98.0 0.0 90.0 90.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:WallSurface gml:id="FZK_GUID_3D00AA05-87EF-4187-9C91-60738B82833B">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_3ed0ea58-a66a-4df4-8ec0-eec6d1c6ee74">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 98.0 0.0 96.0 98.0 5.0 96.0 90.0 5.0 96.0 90.0 0.0 96.0 98.0 0.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:WallSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_B4AEF68E-1D1E-4CD3-84EA-0C7AE1FE49E1">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_f27e472d-838d-40b3-b870-942738333868">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">90.0 90.0 5.0 93.0 90.0 10.0 93.0 98.0 10.0 90.0 98.0 5.0 90.0 90.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <boundary>
        <con:RoofSurface gml:id="FZK_GUID_131C191E-42DE-4B72-AD64-B2EF564679C8">
          <lod2MultiSurface>
            <gml:MultiSurface>
              <gml:surfaceMember>
                <gml:Polygon gml:id="UUID_660fae02-23d0-421a-9981-15c39f89d095">
                  <gml:exterior>
                    <gml:LinearRing>
                      <gml:posList srsDimension="3">96.0 98.0 5.0 93.0 98.0 10.0 93.0 90.0 10.0 96.0 90.0 5.0 96.0 98.0 5.0</gml:posList>
                    </gml:LinearRing>
                  </gml:exterior>
                </gml:Polygon>
              </gml:surfaceMember>
            </gml:MultiSurface>
          </lod2MultiSurface>
        </con:RoofSurface>
      </boundary>
      <lod2Solid>
        <gml:Solid>
          <gml:exterior>
            <gml:Shell>
              <gml:surfaceMember xlink:href="#UUID_dd43e4e0-5870-4d6e-8c51-54b4d6995d6b"/>
              <gml:surfaceMember xlink:href="#UUID_a3529c33-916d-44d9-a6e6-44c96add5c56"/>
              <gml:surfaceMember xlink:href="#UUID_667cd809-ae26-4153-a3a5-42a3c54e8986"/>
              <gml:surfaceMember xlink:href="#UUID_dac0390f-7fa6-46d0-bae0-5c6e7bebb3ec"/>
              <gml:surfaceMember xlink:href="#UUID_3ed0ea58-a66a-4df4-8ec0-eec6d1c6ee74"/>
              <gml:surfaceMember xlink:href="#UUID_f27e472d-838d-40b3-b870-942738333868"/>
              <gml:surfaceMember xlink:href="#UUID_660fae02-23d0-421a-9981-15c39f89d095"/>
            </gml:Shell>
          </gml:exterior>
        </gml:Solid>
      </lod2Solid>
      <con:dateOfConstruction>1970-01-01</con:dateOfConstruction>
      <con:dateOfDemolition>2037-01-01</con:dateOfDemolition>
      <con:height>
        <con:Height>
          <con:highReference>highestRoofEdge</con:highReference>
          <con:lowReference>lowestGroundPoint</con:lowReference>
          <con:status>measured</con:status>
          <con:value uom="#m">10.0</con:value>
        </con:Height>
      </con:height>
      <bldg:class>1060</bldg:class>
      <bldg:roofType>1030</bldg:roofType>
      <bldg:storeysAboveGround>3</bldg:storeysAboveGround>
      <bldg:storeysBelowGround>0</bldg:storeysBelowGround>
      <bldg:storeyHeightsAboveGround uom="#m">3.0</bldg:storeyHeightsAboveGround>
      <bldg:storeyHeightsBelowGround uom="#m">0.0</bldg:storeyHeightsBelowGround>
    </bldg:Building>
  </cityObjectMember>
</CityModel>