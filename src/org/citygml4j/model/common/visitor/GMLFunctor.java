package org.citygml4j.model.common.visitor;

import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.ValueArray;

public interface GMLFunctor<T> extends FeatureFunctor<T>, GeometryFunctor<T> {
	public T apply(CompositeValue compositeValue);
	public T apply(ValueArray valueArray);
	public T apply(TexCoordGen texCoordGen);
	public T apply(TexCoordList texCoordList);
	public T apply(ImplicitGeometry implicitGeometry);
	public T apply(_Material material);
	public T apply(_SimpleTexture simpleTexture);
}
