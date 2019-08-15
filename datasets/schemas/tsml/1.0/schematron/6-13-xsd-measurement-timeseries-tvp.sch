<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns="http://purl.oclc.org/dsdl/schematron" fpi="http://schemas.opengis.net/tsml/1.0/xsd-measurement-timeseries-tvp.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-measurement-timeseries-tvp" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" queryBinding="xslt">
	<title>OGC TimeseriesML 1.0 measurement time series validation</title>
	<ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
	<ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
	<ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
	<ns prefix="xsi" uri="http://www.w3.org/2001/XMLSchema-instance"/>
	<ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
	<p>Verifies the timeseries is valid according the measure time series class, http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-measurement-timeseries-tvp</p>
	<pattern id="interpolation-type">
		<title>Test requirement: /req/xsd-measurement-timeseries-tvp/interpolation-type</title>
		<rule context="tsml:TimeseriesTVP">
			<assert test="tsml:point/tsml:MeasurementTVP/tsml:metadata/tsml:PointMetadata/tsml:interpolationType or 
        tsml:defaultPointMetadata/tsml:PointMetadata/tsml:interpolationType">
        The interpolation type of a point must be set explicitly or through the default point metadata.  
      </assert>
		</rule>
	</pattern>
	<pattern id="value-measure">
		<title>Test requirement: /req/xsd-measurement-timeseries-tvp/value-measure</title>
		<rule context="tsml:TimeseriesTVP/tsml:point/tsml:MeasurementTVP/tsml:value">
			<assert test="(number(../tsml:value) = ../tsml:value) or @xsi:nil">The time series points must be of type Measure (tests for a numerical value) except where an xsi:nil attribute is provided. </assert>
		</rule>
	</pattern>
	<pattern id="unit-of-measure">
		<title>Test requirement: /req/xsd-measurement-timeseries-tvp/unit-of-measure</title>
		<rule context="tsml:point/tsml:MeasurementTVP/tsml:value">
			<assert test="@code or ../../../tsml:defaultPointMetadata/tsml:PointMetadata/tsml:uom[@code]">A unit of measure
        must be supplied either through the default point metadata or by explicit attribute on the value.</assert>
		</rule>
	</pattern>
</schema>
