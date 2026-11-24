package org.citygml4j.cityjson.model.metadata;

import org.citygml4j.cityjson.model.CityJSONVersion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceSystemTest {

    private static void assertRs(ReferenceSystem rs, String authority, String version, String code) {
        assertNotNull(rs);
        assertEquals(authority, rs.getAuthority());
        assertEquals(version, rs.getVersion());
        assertEquals(code, rs.getCode());
    }

    @Test
    void parsesNumericUrl() {
        ReferenceSystem rs = ReferenceSystem.parse("https://www.opengis.net/def/crs/EPSG/0/25832");
        assertRs(rs, "EPSG", "0", "25832");
        assertEquals("http://www.opengis.net/def/crs/EPSG/0/25832", rs.toURL());
        assertEquals("urn:ogc:def:crs:EPSG::25832", rs.toURN());
    }

    @Test
    void parsesNonNumericUrl() {
        ReferenceSystem rs = ReferenceSystem.parse("http://www.opengis.net/def/crs/OGC/1.3/CRS84");
        assertRs(rs, "OGC", "1.3", "CRS84");
        assertEquals("http://www.opengis.net/def/crs/OGC/1.3/CRS84", rs.toURL());
        assertEquals("urn:ogc:def:crs:OGC:1.3:CRS84", rs.toURN());
    }

    @Test
    void parsesUrn() {
        assertRs(ReferenceSystem.parse("urn:ogc:def:crs:EPSG::25832"), "EPSG", "0", "25832");
        assertRs(ReferenceSystem.parse("urn:ogc:def:crs:OGC:1.3:CRS84"), "OGC", "1.3", "CRS84");
    }

    @Test
    void parsesCompoundUrnUsingFirstCrs() {
        assertRs(ReferenceSystem.parse("urn:ogc:def:crs,crs:EPSG::25832,crs:EPSG::5783"), "EPSG", "0", "25832");
    }

    @Test
    void parsesShortForm() {
        assertRs(ReferenceSystem.parse("EPSG:25832"), "EPSG", "0", "25832");
        assertRs(ReferenceSystem.parse("OGC:CRS84"), "OGC", "0", "CRS84");
    }

    @Test
    void roundTripsThroughUri() {
        for (String uri : new String[]{"http://www.opengis.net/def/crs/EPSG/0/25832",
                "http://www.opengis.net/def/crs/OGC/1.3/CRS84"}) {
            ReferenceSystem rs = ReferenceSystem.parse(uri);
            assertEquals(uri, ReferenceSystem.parse(rs.toURI(CityJSONVersion.v2_0)).toURL());
            assertEquals(uri, ReferenceSystem.parse(rs.toURI(CityJSONVersion.v1_0)).toURL());
        }
    }

    @Test
    void returnsNullForUnparsable() {
        assertNull(ReferenceSystem.parse("not a crs"));
        assertNull(ReferenceSystem.parse(null));
    }

    @Test
    void intConstructorKeepsDefaults() {
        assertRs(new ReferenceSystem(4326), "EPSG", "0", "4326");
    }
}
