<?xml version="1.0" encoding="UTF-8"?>
<!--
  ~ citygml4j - The Open Source Java API for CityGML
  ~ https://github.com/citygml4j
  ~
  ~ Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~     http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" xmlns:bldg="http://www.opengis.net/citygml/building/1.0"
  version="1.0">
  <xsl:output method="xml" encoding="UTF-8"/>

  <xsl:template match="node()|@*">
    <xsl:copy>
      <xsl:apply-templates select="node()|@*"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="//bldg:address"/>

</xsl:stylesheet>
