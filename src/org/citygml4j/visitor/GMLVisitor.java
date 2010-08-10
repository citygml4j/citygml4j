package org.citygml4j.visitor;

import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.ValueArray;

public interface GMLVisitor extends FeatureVisitor, GeometryVisitor {
	public void accept(CompositeValue compositeValue);
	public void accept(ValueArray valueArray);
	public void accept(TexCoordGen texCoordGen);
	public void accept(TexCoordList texCoordList);
	public void accept(ImplicitGeometry implicitGeometry);
	public void accept(_Material material);
	public void accept(_SimpleTexture simpleTexture);
}
