/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.writer;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class CityGMLChunkWriterTest {
    // copies everything, but terminates on the building with gml:id "bad"
    private static final String XSLT = """
            <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                    xmlns:gml="http://www.opengis.net/gml/3.2">
              <xsl:template match="@*|node()">
                <xsl:copy><xsl:apply-templates select="@*|node()"/></xsl:copy>
              </xsl:template>
              <xsl:template match="*[@gml:id='bad']">
                <xsl:message terminate="yes">bad feature</xsl:message>
              </xsl:template>
            </xsl:stylesheet>
            """;

    @Test
    void failedMemberDoesNotBreakFollowingMembers() throws Exception {
        TransformerPipeline transformer = TransformerPipeline.newInstance(new StreamSource(new StringReader(XSLT)));
        CityGMLOutputFactory out = CityGMLContext.newInstance().createCityGMLOutputFactory(CityGMLVersion.v3_0)
                .withTransformer(transformer);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(stream, StandardCharsets.UTF_8.name())) {
            Building bad = new Building();
            bad.setId("bad");
            assertThrows(Exception.class, () -> writer.writeMember(bad));

            Building good = new Building();
            good.setId("good");
            writer.writeMember(good);
        }

        String xml = stream.toString(StandardCharsets.UTF_8);
        assertTrue(xml.contains(":id=\"good\""), xml);
        assertTrue(xml.trim().endsWith("CityModel>"), xml);
    }
}
