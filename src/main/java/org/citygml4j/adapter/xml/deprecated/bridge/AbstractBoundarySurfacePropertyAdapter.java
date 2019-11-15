package org.citygml4j.adapter.xml.deprecated.bridge;

import org.citygml4j.adapter.xml.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Namespaces;

public class AbstractBoundarySurfacePropertyAdapter extends AbstractSpaceBoundaryPropertyAdapter {

    @Override
    public void writeChildElements(AbstractSpaceBoundaryProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        namespaces = namespaces.copy().removeAll(
                CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE,
                CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE,
                CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE,
                CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE,
                CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE
        );

        super.writeChildElements(object, namespaces, writer);
    }
}
