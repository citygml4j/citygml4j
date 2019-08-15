<?xml version="1.0" encoding="UTF-8"?>
<schema fpi="http://schemas.opengis.net/tsml/1.0/xsd-timeseries_observations.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-observation"
  xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" queryBinding="xslt2">
  <!--
        This Schematron schema checks the restricts the OM_Observation type to be consistent 
        with a OGC TimeseriesML 1.0 Timeseries Observation. 

        OGC TimeseriesML 1.0 is an OGC Standard.
        Copyright (c) 2015 Open Geospatial Consortium.
        To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ .

        version="1.0.0"
    -->
  <title>OGC TimeseriesML 2.0 observation validation</title>
  <p>Verifies that the OM_Observation type is valid according to the core TimeseriesML 1.0 observation restrictions. Tests requirements from http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-observation</p>
  <ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
  <ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
  <ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
  <ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>

  <pattern id="procedure">
    <title>Test requirement: /req/xsd-timeseries-observation/procedure</title>
    <rule context="om:OM_Observation/om:procedure">
      <assert test="tsml:ObservationProcess | @xlink:href">The xml element om:procedure shall contain an element which is a subtype of OM_Process, such as  tsml:ObservationProcess element, or a subtype of SWE AbstractProcess or a reference to an external definition of the process using the xlink:href attribute..</assert>
        <!-- note, this schematron is not schema-aware, therefore this assertion may need to be extended to check for known members of substitution groups in particular implementations, this can be done by extending the test attribute with "| yourclassname"-->
    </rule>
  </pattern>
  <!--<pattern id="metadata">
    <title>Test requirement: /req/xsd-timeseries-observation/metadata</title>
    <rule context="//om:OM_Observation/om:metadata">
      <assert test="schema-element(tsml:ObservationMetadata) | @xlink:href">The xml element om:metadata shall contain a subelement of tsml:ObservationMetadata, a
        member of its substitution group or a reference to an external definition of the process using the xlink:href attribute.</assert>
    </rule>
  </pattern>-->
  <!--
  <pattern id="result">
    <title>Test requirement: /req/xsd-timeseries-observation/result</title>
    <rule context="om:OM_Observation/om:result">
      <assert test="tsml:TimeseriesTVP | tsml:TimeseriesDomainRange | @xlink:href">
        The xml element om:result shall contain a subelement of tsml:TimeseriesTVP or tsml:TimeseriesDomainRange (or a member of their substitution groups),
        or a reference to an external instance of the result using the xlink:href attribute.</assert>
      </rule>
  </pattern>
  -->
  <pattern id="phenomenonTime">
    <title>Test requirement: /xsd-timeseries-observation/phenomenonTime </title>
    <rule context="om:OM_Observation/om:phenomenonTime">
      <assert test="gml:TimePeriod | @xlink:href">The om:phenomenonTime element shall contain a 
        gml:TimePeriod element that represents the temporal extent of the timeseries result of the observation or a reference
       to such an element.</assert>
    </rule>
  </pattern>
</schema>
