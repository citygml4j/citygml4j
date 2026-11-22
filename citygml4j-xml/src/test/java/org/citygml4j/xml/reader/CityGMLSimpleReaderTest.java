/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.reader;

import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.citygml4j.xml.CityGMLContext;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CityGMLSimpleReaderTest {
    private static final String NAMESPACES = """
            xmlns:core="http://www.opengis.net/citygml/3.0"
            xmlns:bldg="http://www.opengis.net/citygml/building/3.0"
            xmlns:tran="http://www.opengis.net/citygml/transportation/3.0"
            xmlns:gml="http://www.opengis.net/gml/3.2"
            xmlns:wfs="http://www.opengis.net/wfs/2.0"
            """;

    private static final String CITY_MODEL = "<core:CityModel " + NAMESPACES + """
            >
              <core:cityObjectMember>
                <bldg:Building gml:id="b1">
                  <bldg:buildingPart><bldg:BuildingPart gml:id="p1"/></bldg:buildingPart>
                </bldg:Building>
              </core:cityObjectMember>
              <core:cityObjectMember><tran:Road gml:id="r1"/></core:cityObjectMember>
              <core:cityObjectMember><bldg:Building gml:id="b2"/></core:cityObjectMember>
            </core:CityModel>
            """;

    private static final String FEATURE_COLLECTION = "<wfs:FeatureCollection " + NAMESPACES + """
            >
              <wfs:member><bldg:Building gml:id="b1"/></wfs:member>
              <wfs:member><tran:Road gml:id="r1"/></wfs:member>
              <wfs:member><bldg:Building gml:id="b2"/></wfs:member>
            </wfs:FeatureCollection>
            """;

    private List<AbstractFeature> read(String xml, Set<String> accepted) throws Exception {
        CityGMLInputFactory in = CityGMLContext.newInstance().createCityGMLInputFactory();
        CityGMLReader created = in.createCityGMLReader(new StringReader(xml));

        List<AbstractFeature> features = new ArrayList<>();
        try (CityGMLReader reader = accepted == null ? created :
                in.createFilteredCityGMLReader(created, name -> accepted.contains(name.getLocalPart()))) {
            while (reader.hasNext()) {
                features.add(reader.next());
            }
        }

        return features;
    }

    private List<String> ids(List<AbstractFeature> features) {
        return features.stream().map(AbstractFeature::getId).toList();
    }

    private void assertEntireCityModel(List<AbstractFeature> features) {
        assertEquals(1, features.size());
        CityModel cityModel = assertInstanceOf(CityModel.class, features.get(0));
        assertEquals(3, cityModel.getCityObjectMembers().size());
    }

    @Test
    void noFilterReturnsEntireCityModel() throws Exception {
        assertEntireCityModel(read(CITY_MODEL, null));
    }

    @Test
    void acceptedCityModelIsReturnedWithAllMembers() throws Exception {
        assertEntireCityModel(read(CITY_MODEL, Set.of("CityModel")));
        assertEntireCityModel(read(CITY_MODEL, Set.of("CityModel", "Building")));
    }

    @Test
    void featuresInsideRejectedCityModelAreReturned() throws Exception {
        assertEquals(List.of("b1", "b2"), ids(read(CITY_MODEL, Set.of("Building"))));
    }

    @Test
    void nestedFeaturesInsideRejectedFeatureAreReturned() throws Exception {
        assertEquals(List.of("p1"), ids(read(CITY_MODEL, Set.of("BuildingPart"))));
    }

    @Test
    void featuresInsideRejectedWrapperAreReturned() throws Exception {
        assertEquals(List.of("b1", "b2"), ids(read(FEATURE_COLLECTION, Set.of("Building"))));
        assertEquals(List.of("b1", "b2"), ids(read(FEATURE_COLLECTION, Set.of("FeatureCollection", "member", "Building"))));
    }
}
