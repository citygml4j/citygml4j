/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.ElectricalAppliance;
import implementing_ades.module.TestADEModule;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "ElectricalAppliance", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class ElectricalApplianceAdapter extends AbstractFacilityAdapter<ElectricalAppliance> {

    @Override
    public ElectricalAppliance createObject(QName name, Object parent) throws ObjectBuildException {
        return new ElectricalAppliance();
    }

    @Override
    public Element createElement(ElectricalAppliance object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "ElectricalAppliance");
    }
}
