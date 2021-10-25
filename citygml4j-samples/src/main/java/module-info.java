module org.citygml4j.samples {
    requires org.citygml4j;

    exports implementing_ades.model;
    exports implementing_ades.adapter to org.xmlobjects;
    exports implementing_ades.walker to org.citygml4j;

    uses org.citygml4j.xml.ade.ADEContext;
    provides org.citygml4j.xml.ade.ADEContext with implementing_ades.TestADEContext;

    opens implementing_ades.model to org.citygml4j;
    opens processing_citygml to org.citygml4j;
}