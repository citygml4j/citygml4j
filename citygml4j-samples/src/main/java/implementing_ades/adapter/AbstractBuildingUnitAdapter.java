/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package implementing_ades.adapter;

import implementing_ades.model.AbstractBuildingUnit;
import implementing_ades.model.BuildingUnitPartProperty;
import implementing_ades.model.EnergyPerformanceCertificationProperty;
import implementing_ades.model.FacilitiesProperty;
import implementing_ades.module.TestADEModule;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.xml.adapter.core.AbstractCityObjectAdapter;
import org.citygml4j.xml.adapter.core.AddressPropertyAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractBuildingUnitAdapter<T extends AbstractBuildingUnit> extends AbstractCityObjectAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.NAMESPACE_1_0.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "class":
                    object.setClassifier(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "function":
                    object.getFunctions().add(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "usage":
                    object.getUsages().add(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "energyPerformanceCertification":
                    object.getEnergyPerformanceCertifications().add(reader.getObjectUsingBuilder(EnergyPerformanceCertificationPropertyAdapter.class));
                    break;
                case "lod2MultiCurve":
                    object.setLod2MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    break;
                case "lod3MultiCurve":
                    object.setLod3MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    break;
                case "lod4MultiCurve":
                    object.setLod4MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    break;
                case "lod1MultiSurface":
                    object.setLod1MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    break;
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    break;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    break;
                case "lod4MultiSurface":
                    object.setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    break;
                case "lod1Solid":
                    object.setLod1Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    break;
                case "lod2Solid":
                    object.setLod2Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    break;
                case "lod3Solid":
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    break;
                case "lod4Solid":
                    object.setLod4Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    break;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    break;
                case "equippedWith":
                    object.getEquippedWith().add(reader.getObjectUsingBuilder(FacilitiesPropertyAdapter.class));
                    break;
                case "consistsOf":
                    object.getConsistsOf().add(reader.getObjectUsingBuilder(BuildingUnitPartPropertyAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getClassifier() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "class"), object.getClassifier(), CodeAdapter.class, namespaces);

        for (Code function : object.getFunctions())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "function"), function, CodeAdapter.class, namespaces);

        for (Code usage : object.getUsages())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "usage"), usage, CodeAdapter.class, namespaces);

        for (EnergyPerformanceCertificationProperty property : object.getEnergyPerformanceCertifications())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "energyPerformanceCertification"), property, EnergyPerformanceCertificationPropertyAdapter.class, namespaces);

        if (object.getLod2MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod2MultiCurve"), object.getLod2MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod4MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod4MultiCurve"), object.getLod4MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod1MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod1MultiSurface"), object.getLod1MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod4MultiSurface"), object.getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod1Solid() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod2Solid() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod2Solid"), object.getLod2Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod4Solid() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "lod4Solid"), object.getLod4Solid(), SolidPropertyAdapter.class, namespaces);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (FacilitiesProperty property : object.getEquippedWith())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "equippedWith"), property, FacilitiesPropertyAdapter.class, namespaces);

        for (BuildingUnitPartProperty property : object.getConsistsOf())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.NAMESPACE_1_0, "consistsOf"), property, BuildingUnitPartPropertyAdapter.class, namespaces);
    }
}
