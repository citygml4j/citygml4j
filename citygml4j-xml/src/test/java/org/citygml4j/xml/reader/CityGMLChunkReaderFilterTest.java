/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.reader;

import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.citygml4j.xml.CityGMLContext;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class CityGMLChunkReaderFilterTest {
    private static final String CITY_MODEL = """
            <core:CityModel xmlns:core="http://www.opengis.net/citygml/3.0"
                xmlns:bldg="http://www.opengis.net/citygml/building/3.0"
                xmlns:tran="http://www.opengis.net/citygml/transportation/3.0"
                xmlns:gml="http://www.opengis.net/gml/3.2">
              <core:cityObjectMember>
                <bldg:Building gml:id="b1">
                  <bldg:buildingPart><bldg:BuildingPart gml:id="p1"/></bldg:buildingPart>
                </bldg:Building>
              </core:cityObjectMember>
              <core:cityObjectMember><tran:Road gml:id="r1"/></core:cityObjectMember>
              <core:cityObjectMember><bldg:Building gml:id="b2"/></core:cityObjectMember>
            </core:CityModel>
            """;

    private List<AbstractFeature> read(ChunkOptions options, Predicate<String> accepted) throws Exception {
        CityGMLInputFactory in = CityGMLContext.newInstance().createCityGMLInputFactory().withChunking(options);
        CityGMLReader created = in.createCityGMLReader(new StringReader(CITY_MODEL));

        List<AbstractFeature> features = new ArrayList<>();
        try (CityGMLReader reader = accepted == null ? created :
                in.createFilteredCityGMLReader(created, name -> accepted.test(name.getLocalPart()))) {
            while (reader.hasNext()) {
                features.add(reader.next());
            }
        }

        return features;
    }

    private List<String> ids(List<AbstractFeature> features) {
        return features.stream().map(AbstractFeature::getId).toList();
    }

    @Test
    void featuresInsideRejectedRootCityModelAreReturned() throws Exception {
        assertEquals(List.of("b1", "b2"), ids(read(ChunkOptions.defaults(), "Building"::equals)));
    }

    @Test
    void filterAppliesToEachReturnedChunk() throws Exception {
        ChunkOptions options = ChunkOptions.chunkByFeatures();
        assertEquals(List.of("p1", "r1"), ids(read(options, name -> !name.equals("Building") && !name.equals("CityModel"))));
        assertEquals(List.of("p1", "r1"), ids(read(options, name -> name.equals("BuildingPart") || name.equals("Road"))));
    }

    @Test
    void rejectedChunkIsReferencedFromParent() throws Exception {
        ChunkOptions options = ChunkOptions.chunkByFeatures();
        List<AbstractFeature> features = read(options, name -> !name.equals("BuildingPart") && !name.equals("CityModel"));
        assertEquals(List.of("b1", "r1", "b2"), ids(features));
        Building b1 = assertInstanceOf(Building.class, features.get(0));
        assertEquals("#p1", b1.getBuildingParts().get(0).getHref());
    }

    @Test
    void nestedFeaturesOfAcceptedChunkAreKept() throws Exception {
        List<AbstractFeature> features = read(ChunkOptions.defaults(), "Building"::equals);
        Building b1 = assertInstanceOf(Building.class, features.get(0));
        assertEquals("p1", b1.getBuildingParts().get(0).getObject().getId());
    }

    @Test
    void acceptedRootCityModelIsReturned() throws Exception {
        List<AbstractFeature> features = read(ChunkOptions.defaults().skipCityModel(false), name -> true);
        assertInstanceOf(CityModel.class, features.get(features.size() - 1));
    }
}
