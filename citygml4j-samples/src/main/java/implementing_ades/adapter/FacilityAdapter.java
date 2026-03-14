/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.Facility;
import implementing_ades.module.TestADEModule;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "Facility", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class FacilityAdapter extends AbstractFacilityAdapter<Facility> {

    @Override
    public Facility createObject(QName name, Object parent) throws ObjectBuildException {
        return new Facility();
    }

    @Override
    public Element createElement(Facility object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "Facility");
    }
}
