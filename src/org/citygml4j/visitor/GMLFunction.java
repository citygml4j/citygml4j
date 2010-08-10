package org.citygml4j.visitor;

import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.ValueArray;

public interface GMLFunction<T> extends FeatureFunction<T>, GeometryFunction<T> {
	public T accept(CompositeValue compositeValue);
	public T accept(ValueArray valueArray);
	public T accept(TexCoordGen texCoordGen);
	public T accept(TexCoordList texCoordList);
	public T accept(ImplicitGeometry implicitGeometry);
	public T accept(_Material material);
	public T accept(_SimpleTexture simpleTexture);
}
