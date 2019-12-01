package org.citygml4j.visitor;

import org.citygml4j.model.appearance.TextureAssociation;
import org.citygml4j.model.cityobjectgroup.Role;
import org.citygml4j.model.core.CityObjectRelation;
import org.citygml4j.model.core.ImplicitGeometry;

public interface ObjectVisitor extends org.xmlobjects.gml.visitor.ObjectVisitor, FeatureVisitor {
    void visit(CityObjectRelation cityObjectRelation);
    void visit(ImplicitGeometry implicitGeometry);
    void visit(Role role);
    void visit(TextureAssociation textureAssociation);
}
