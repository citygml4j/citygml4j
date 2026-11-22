/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.reader;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityJSONChunkReaderTest {

    @Test
    void emptyInputHasNoFeatures() throws Exception {
        CityJSONInputFactory in = CityJSONContext.newInstance().createCityJSONInputFactory()
                .chunkByTopLevelCityObjects(true);

        try (CityJSONReader reader = in.createCityJSONReader(new StringReader(""))) {
            assertFalse(reader.hasNext());
        }

        try (CityJSONReader reader = in.createCityJSONReader(new StringReader("[]"))) {
            assertFalse(reader.hasNext());
        }
    }

    @Test
    void readsChildrenListedBeforeParents() {
        assertEquals(5, assertTimeoutPreemptively(Duration.ofSeconds(10),
                () -> countFeatures(parentsAndChildren(5, 4, true))));
    }

    @Test
    void readsChildrenListedAfterParents() {
        assertEquals(5, assertTimeoutPreemptively(Duration.ofSeconds(10),
                () -> countFeatures(parentsAndChildren(5, 4, false))));
    }

    @Test
    void readsManyChildrenInLinearTime() {
        // consumed children used to stay in the CityObjects map and were rescanned for every top-level object
        String json = parentsAndChildren(10000, 4, false);
        assertEquals(10000, assertTimeoutPreemptively(Duration.ofSeconds(10), () -> countFeatures(json)));
    }

    @Test
    void readsManyChildrenListedFirstInLinearTime() {
        // the top-level iterator used to rescan all leading children on every call
        String json = parentsAndChildren(10000, 4, true);
        assertEquals(10000, assertTimeoutPreemptively(Duration.ofSeconds(10), () -> countFeatures(json)));
    }

    @Test
    void buildsAllChildren() throws Exception {
        CityJSONInputFactory in = CityJSONContext.newInstance().createCityJSONInputFactory()
                .chunkByTopLevelCityObjects(true);

        try (CityJSONReader reader = in.createCityJSONReader(new StringReader(parentsAndChildren(3, 4, true)))) {
            int count = 0;
            while (reader.hasNext()) {
                Building building = assertInstanceOf(Building.class, reader.next());
                assertEquals(2, building.getBuildingParts().size());
                assertEquals(2, building.getBuildingInstallations().size());
                count++;
            }

            assertEquals(3, count);
        }
    }

    @Test
    void buildsChildSharedByTwoParents() throws Exception {
        String json = "{\"type\":\"CityJSON\",\"version\":\"2.0\",\"transform\":{\"scale\":[1,1,1],\"translate\":[0,0,0]},"
                + "\"CityObjects\":{"
                + "\"a\":{\"type\":\"Building\",\"children\":[\"c\"]},"
                + "\"c\":{\"type\":\"BuildingPart\",\"parents\":[\"a\",\"b\"]},"
                + "\"b\":{\"type\":\"Building\",\"children\":[\"c\"]}"
                + "},\"vertices\":[]}";

        for (boolean chunk : new boolean[]{true, false}) {
            CityJSONInputFactory in = CityJSONContext.newInstance().createCityJSONInputFactory()
                    .chunkByTopLevelCityObjects(chunk);

            List<AbstractFeature> features = new ArrayList<>();
            try (CityJSONReader reader = in.createCityJSONReader(new StringReader(json))) {
                while (reader.hasNext()) {
                    AbstractFeature feature = reader.next();
                    if (feature instanceof CityModel cityModel) {
                        cityModel.getCityObjectMembers().forEach(member -> features.add(member.getObject()));
                    } else {
                        features.add(feature);
                    }
                }
            }

            assertEquals(2, features.size(), "chunk=" + chunk);
            for (AbstractFeature feature : features) {
                Building building = assertInstanceOf(Building.class, feature, "chunk=" + chunk);
                assertEquals(1, building.getBuildingParts().size(), "chunk=" + chunk);
                assertEquals("c", building.getBuildingParts().get(0).getObject().getId(), "chunk=" + chunk);
            }
        }
    }

    private int countFeatures(String json) throws Exception {
        CityJSONInputFactory in = CityJSONContext.newInstance().createCityJSONInputFactory()
                .chunkByTopLevelCityObjects(true);

        int count = 0;
        try (CityJSONReader reader = in.createCityJSONReader(new StringReader(json))) {
            while (reader.hasNext()) {
                reader.next();
                count++;
            }
        }

        return count;
    }

    private String parentsAndChildren(int parents, int children, boolean childrenFirst) {
        StringBuilder parentObjects = new StringBuilder();
        StringBuilder childObjects = new StringBuilder();
        StringBuilder interleaved = new StringBuilder();
        for (int i = 0; i < parents; i++) {
            int start = childObjects.length();
            StringBuilder ids = new StringBuilder();
            for (int j = 0; j < children; j++) {
                ids.append(j > 0 ? "," : "").append("\"b").append(i).append('_').append(j).append('"');
                childObjects.append("\"b").append(i).append('_').append(j)
                        .append("\":{\"type\":\"").append(j % 2 == 0 ? "BuildingPart" : "BuildingInstallation")
                        .append("\",\"parents\":[\"b").append(i).append("\"]},");
            }

            parentObjects.append("\"b").append(i).append("\":{\"type\":\"Building\",\"children\":[")
                    .append(ids).append("]},");
            interleaved.append(parentObjects, parentObjects.lastIndexOf("\"b" + i + "\":{"), parentObjects.length())
                    .append(childObjects, start, childObjects.length());
        }

        String objects = childrenFirst ? childObjects.toString() + parentObjects : interleaved.toString();
        return "{\"type\":\"CityJSON\",\"version\":\"2.0\",\"transform\":{\"scale\":[1,1,1],\"translate\":[0,0,0]},"
                + "\"CityObjects\":{" + objects.substring(0, objects.length() - 1) + "},\"vertices\":[]}";
    }
}
