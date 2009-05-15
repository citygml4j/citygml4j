package org.citygml4j.impl.jaxb.citygml.appearance._1;

import java.math.BigInteger;
import java.util.List;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.impl.jaxb.citygml.core._1.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml.app._1.TexCoordGenType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.WorldToTexture;

public class WorldToTextureImpl extends CityGMLBaseImpl implements WorldToTexture {
	private TexCoordGenType.WorldToTexture worldToTexture;

	public WorldToTextureImpl() {
		worldToTexture = new TexCoordGenType.WorldToTexture();
	}

	public WorldToTextureImpl(TexCoordGenType.WorldToTexture worldToTexture) {
		this.worldToTexture = worldToTexture;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WORLDTOTEXTURE;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v1_0_0;
	}

	@Override
	public TexCoordGenType.WorldToTexture getJAXBObject() {
		return worldToTexture;
	}

	public Matrix getMatrix() {
		if (worldToTexture.isSetValue()) {
			List<Double> vals = worldToTexture.getValue();
			if (vals.size() >= 12) {
				Matrix matrix = new Matrix(3, 4);
				matrix.setMatrix(vals.subList(0, 12));
				
				return matrix;
			}
		}

		return null;
	}

	public boolean isSetMatrix() {
		return worldToTexture.isSetValue();
	}
	
	public void setMatrix(Matrix matrix) {
		if (matrix.getRowDimension() != 3 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 3x4.");

		worldToTexture.unsetValue();
		worldToTexture.getValue().addAll(matrix.toRowPackedList());
	}

	public List<String> getAxisLabels() {
		return worldToTexture.getAxisLabels();
	}

	public Integer getSrsDimension() {
		if (worldToTexture.isSetSrsDimension())
			return new Integer(worldToTexture.getSrsDimension().intValue());

		return null;
	}

	public String getSrsName() {
		return worldToTexture.getSrsName();
	}

	public List<String> getUomLabels() {
		return worldToTexture.getUomLabels();
	}

	public void setSrsDimension(Integer srsDimension) {
		worldToTexture.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	public void setSrsName(String srsName) {
		worldToTexture.setSrsName(srsName);
	}

	public void addAxisLabel(String axisLabel) {
		worldToTexture.getAxisLabels().add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		worldToTexture.getUomLabels().add(uomLabel);
	}

	public void setAxisLabels(List<String> axisLabels) {
		worldToTexture.unsetAxisLabels();
		worldToTexture.getAxisLabels().addAll(axisLabels);
	}

	public void setUomLabels(List<String> uomLabels) {
		worldToTexture.unsetUomLabels();
		worldToTexture.getUomLabels().addAll(uomLabels);
	}

	public boolean isSetSrsDimension() {
		return worldToTexture.isSetSrsDimension();
	}

	public boolean isSetSrsName() {
		return worldToTexture.isSetSrsName();
	}

	public void unsetSrsDimension() {
		worldToTexture.setSrsDimension(null);
	}

	public void unsetSrsName() {
		worldToTexture.setSrsName(null);
	}

	public boolean isSetAxisLabels() {
		return worldToTexture.isSetAxisLabels();
	}

	public boolean isSetUomLabels() {
		return worldToTexture.isSetUomLabels();
	}

	public void unsetAxisLabels() {
		worldToTexture.unsetAxisLabels();
	}

	public void unsetUomLabels() {
		worldToTexture.unsetUomLabels();
	}
	
	public boolean unsetAxisLabels(String axisLabel) {
		if (worldToTexture.isSetAxisLabels())
			return worldToTexture.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	public boolean unsetUomLabels(String uomLabel) {
		if (worldToTexture.isSetUomLabels())
			return worldToTexture.getUomLabels().remove(uomLabel);
			
		return false;
	}
	
}
