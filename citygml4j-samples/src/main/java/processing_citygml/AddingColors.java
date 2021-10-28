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

package processing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.appearance.*;
import org.citygml4j.model.construction.RoofSurface;
import org.citygml4j.model.construction.WallSurface;
import org.citygml4j.model.core.*;
import org.citygml4j.util.reference.ReferenceResolver;
import org.citygml4j.util.reference.ResolveMode;
import org.citygml4j.visitor.ObjectWalker;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.citygml4j.xml.writer.CityGMLWriter;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AddingColors {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(AddingColors.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the file " + file + " into main memory");

        CityModel cityModel;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            cityModel = (CityModel) reader.next();
            log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + cityModel.getId());
        }

        ReferenceResolver resolver = ReferenceResolver.newInstance()
                .withResolveMode(ResolveMode.GEOMETRIES_ONLY);

        log.print("Iterating through the city objects and assigning colors to their thematic surfaces");
        for (AbstractCityObjectProperty property : cityModel.getCityObjectMembers()) {
            AbstractCityObject cityObject = property.getObject();
            if (cityObject != null) {
                log.print("Found " + cityObject.getClass().getSimpleName() + " with gml:id " + cityObject.getId());

                X3DMaterial lightGrey = new X3DMaterial();
                lightGrey.setDiffuseColor(new Color(0.5, 0.5, 0.5));

                X3DMaterial red = new X3DMaterial();
                red.setDiffuseColor(new Color(1, 0, 0));

                X3DMaterial grey = new X3DMaterial();
                grey.setDiffuseColor(new Color(0.3, 0.3, 0.3));

                cityObject.accept(new ObjectWalker() {
                    @Override
                    public void visit(WallSurface wallSurface) {
                        List<AbstractSurface> surfaces = collectSurfaces(wallSurface.getLod2MultiSurface().getObject());
                        surfaces.forEach(s -> lightGrey.getTargets().add(new GeometryReference(s)));
                    }

                    @Override
                    public void visit(RoofSurface roofSurface) {
                        List<AbstractSurface> surfaces = collectSurfaces(roofSurface.getLod2MultiSurface().getObject());
                        surfaces.forEach(s -> red.getTargets().add(new GeometryReference(s)));
                    }

                    @Override
                    public void visit(AbstractThematicSurface thematicSurface) {
                        List<AbstractSurface> surfaces = collectSurfaces(thematicSurface.getLod2MultiSurface().getObject());
                        surfaces.forEach(s -> grey.getTargets().add(new GeometryReference(s)));
                    }

                    private List<AbstractSurface> collectSurfaces(MultiSurface multiSurface) {
                        List<AbstractSurface> surfaces = new ArrayList<>();
                        multiSurface.accept(new ObjectWalker() {
                            @Override
                            public void visit(AbstractSurface surface) {
                                surfaces.add(surface);
                            }

                            @Override
                            public void visit(GeometryProperty<?> property) {
                                if (property.getHref() != null) {
                                    AbstractGeometry geometry = resolver.resolveReference(property.getHref(), cityObject, AbstractGeometry.class);
                                    if (geometry != null)
                                        geometry.accept(this);
                                } else
                                    super.visit(property);
                            }
                        });

                        return surfaces;
                    }
                });

                Appearance appearance = new Appearance();
                appearance.setTheme("rgbColor");

                if (!lightGrey.getTargets().isEmpty())
                    appearance.getSurfaceData().add(new AbstractSurfaceDataProperty(lightGrey));

                if (!red.getTargets().isEmpty())
                    appearance.getSurfaceData().add(new AbstractSurfaceDataProperty(red));

                if (!grey.getTargets().isEmpty())
                    appearance.getSurfaceData().add(new AbstractSurfaceDataProperty(grey));

                if (!appearance.getSurfaceData().isEmpty()) {
                    log.print("Adding an appearance with " + appearance.getSurfaceData().size() + " X3D material(s) to the city object");
                    cityObject.getAppearances().add(new AbstractAppearanceProperty(appearance));
                }
            }
        }

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Writing the colored city objects as CityGML " + version + " file " + output);

        try (CityGMLWriter writer = out.createCityGMLWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndentString("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .write(cityModel);
        }

        log.finish();
    }
}
