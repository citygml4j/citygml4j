package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.gml.SRSReferenceGroup;

public interface WorldToTexture extends TransformationMatrix3x4, SRSReferenceGroup {
	public boolean isSetMatrix();
}
