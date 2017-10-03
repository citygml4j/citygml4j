package org.citygml4j.builder.json.objects;

import java.util.List;

public class TransformType {
	List<Double> scale;
	List<Double> translate;
	
	public boolean isSetScale() {
		return scale != null && scale.size() >= 3;
	}
	
	public List<Double> getScale() {
		return isSetScale() ? scale.subList(0, 3) : null;
	}

	public void setScale(List<Double> scale) {
		if (scale == null)
			this.scale = null;
		else if (scale != null && scale.size() >= 3)
			this.scale = scale.subList(0, 3);
	}
	
	public boolean isSetTranslate() {
		return translate != null && translate.size() >= 3;
	}
	
	public List<Double> getTranslate() {
		return isSetTranslate() ? translate.subList(0, 3) : null;
	}

	public void setTranslate(List<Double> translate) {
		if (translate == null)
			this.translate = null;
		else if (translate != null && translate.size() >= 3)
			this.translate = translate.subList(0, 3);
	}
	
}
