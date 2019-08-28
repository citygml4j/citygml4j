package org.citygml4j.adapter.xml.construction;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.adapter.xml.core.OccupancyPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractConstruction;
import org.citygml4j.model.construction.ADEPropertyOfAbstractConstruction;
import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.construction.ConditionOfConstructionValue;
import org.citygml4j.model.construction.ConstructionEventProperty;
import org.citygml4j.model.construction.ElevationProperty;
import org.citygml4j.model.construction.HeightProperty;
import org.citygml4j.model.core.OccupancyProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public abstract class AbstractConstructionAdapter<T extends AbstractConstruction> extends AbstractOccupiedSpaceAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractConstruction");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "occupancy":
                    object.getOccupancies().add(reader.getObjectUsingBuilder(OccupancyPropertyAdapter.class));
                    return;
                case "conditionOfConstruction":
                    reader.getTextContent().ifPresent(v -> object.setConditionOfConstruction(ConditionOfConstructionValue.fromValue(v)));
                    return;
                case "dateOfConstruction":
                    reader.getTextContent().ifDate(v -> object.setDateOfConstruction(v.toLocalDate()));
                    return;
                case "dateOfDemolition":
                    reader.getTextContent().ifDate(v -> object.setDateOfDemolition(v.toLocalDate()));
                    return;
                case "constructionEvent":
                    object.getConstructionEvents().add(reader.getObjectUsingBuilder(ConstructionEventPropertyAdapter.class));
                    return;
                case "elevation":
                    object.getElevations().add(reader.getObjectUsingBuilder(ElevationPropertyAdapter.class));
                    return;
                case "height":
                    object.getHeights().add(reader.getObjectUsingBuilder(HeightPropertyAdapter.class));
                    return;
                case "constructionSurface":
                    object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractConstructionSurfacePropertyAdapter.class));
                    return;
            }
        } else if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()) && "boundary".equals(name.getLocalPart())) {
            object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractConstructionSurfacePropertyAdapter.class));
            return;
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractConstruction> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractConstruction.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractConstruction().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAbstractConstruction().add(GenericADEPropertyOfAbstractConstruction.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            for (OccupancyProperty property : object.getOccupancies())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "occupancy"), property, OccupancyPropertyAdapter.class, namespaces);

            if (object.getConditionOfConstruction() != null)
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "conditionOfConstruction").addTextContent(object.getConditionOfConstruction().toValue()));

            if (object.getDateOfConstruction() != null)
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "dateOfConstruction").addTextContent(TextContent.ofDate(OffsetDateTime.of(object.getDateOfConstruction(), LocalTime.MIN, ZoneOffset.UTC))));

            if (object.getDateOfDemolition() != null)
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "dateOfDemolition").addTextContent(TextContent.ofDate(OffsetDateTime.of(object.getDateOfDemolition(), LocalTime.MIN, ZoneOffset.UTC))));

            for (ConstructionEventProperty property : object.getConstructionEvents())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "constructionEvent"), property, ConstructionEventPropertyAdapter.class, namespaces);

            for (ElevationProperty property : object.getElevations())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "elevation"), property, ElevationPropertyAdapter.class, namespaces);

            for (HeightProperty property : object.getHeights())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "height"), property, HeightPropertyAdapter.class, namespaces);

            for (ADEPropertyOfAbstractConstruction property : object.getADEPropertiesOfAbstractConstruction())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
