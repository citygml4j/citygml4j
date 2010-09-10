package org.citygml4j.model.common.visitor;

import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.ValueArray;

public interface GMLVisitor extends FeatureVisitor, GeometryVisitor {
	public void visit(CompositeValue compositeValue);
	public void visit(ValueArray valueArray);
	public void visit(TexCoordGen texCoordGen);
	public void visit(TexCoordList texCoordList);
	public void visit(ImplicitGeometry implicitGeometry);
	public void visit(_Material material);
	public void visit(_SimpleTexture simpleTexture);
}
