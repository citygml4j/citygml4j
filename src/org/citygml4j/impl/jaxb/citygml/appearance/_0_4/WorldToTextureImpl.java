package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Matrix4;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml._0_4.TexCoordGenType;
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
		return AppearanceModule.v0_4_0;
	}

	@Override
	public TexCoordGenType.WorldToTexture getJAXBObject() {
		return worldToTexture;
	}

	@Override
	public Matrix4 getTransformationMatrix3x4() {
		if (worldToTexture.isSetValue()) {
			List<Double> matrix = worldToTexture.getValue();

			if (matrix.size() == 12) {
				Matrix4 m = new Matrix4(
						matrix.get(0), matrix.get(1), matrix.get(2), matrix.get(3),
						matrix.get(4), matrix.get(5), matrix.get(6), matrix.get(7),
						matrix.get(8), matrix.get(9), matrix.get(10), matrix.get(11));

				return m;
			}
		}

		return null;
	}

	@Override
	public List<Double> toList() {
		return worldToTexture.getValue();
	}

	@Override
	public void setTransformationMatrix3x4(Matrix4 transformationMatrix) {
		List<Double> worldToTextureMatrix = new ArrayList<Double>();
		double[][] matrix = transformationMatrix.getMatrix();

		worldToTextureMatrix.add(matrix[0][0]);
		worldToTextureMatrix.add(matrix[0][1]);
		worldToTextureMatrix.add(matrix[0][2]);
		worldToTextureMatrix.add(matrix[0][3]);

		worldToTextureMatrix.add(matrix[1][0]);
		worldToTextureMatrix.add(matrix[1][1]);
		worldToTextureMatrix.add(matrix[1][2]);
		worldToTextureMatrix.add(matrix[1][3]);

		worldToTextureMatrix.add(matrix[2][0]);
		worldToTextureMatrix.add(matrix[2][1]);
		worldToTextureMatrix.add(matrix[2][2]);
		worldToTextureMatrix.add(matrix[2][3]);

		worldToTexture.unsetValue();
		worldToTexture.getValue().addAll(worldToTextureMatrix);
	}

	@Override
	public List<String> getAxisLabels() {
		return worldToTexture.getAxisLabels();
	}

	@Override
	public Integer getSrsDimension() {
		if (worldToTexture.isSetSrsDimension())
			return new Integer(worldToTexture.getSrsDimension().intValue());

		return null;
	}

	@Override
	public String getSrsName() {
		return worldToTexture.getSrsName();
	}

	@Override
	public List<String> getUomLabels() {
		return worldToTexture.getUomLabels();
	}

	@Override
	public void setSrsDimension(Integer srsDimension) {
		worldToTexture.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	@Override
	public void setSrsName(String srsName) {
		worldToTexture.setSrsName(srsName);
	}

	@Override
	public void addAxisLabel(String axisLabel) {
		worldToTexture.getAxisLabels().add(axisLabel);
	}

	@Override
	public void addUomLabel(String uomLabel) {
		worldToTexture.getUomLabels().add(uomLabel);
	}

	@Override
	public void setAxisLabels(List<String> axisLabels) {
		worldToTexture.unsetAxisLabels();
		worldToTexture.getAxisLabels().addAll(axisLabels);
	}

	@Override
	public void setUomLabels(List<String> uomLabels) {
		worldToTexture.unsetUomLabels();
		worldToTexture.getUomLabels().addAll(uomLabels);
	}

	@Override
	public boolean isSetSrsDimension() {
		return worldToTexture.isSetSrsDimension();
	}

	@Override
	public boolean isSetSrsName() {
		return worldToTexture.isSetSrsName();
	}

	@Override
	public void unsetSrsDimension() {
		worldToTexture.setSrsDimension(null);
	}

	@Override
	public void unsetSrsName() {
		worldToTexture.setSrsName(null);
	}

	@Override
	public boolean isSetAxisLabels() {
		return worldToTexture.isSetAxisLabels();
	}

	@Override
	public boolean isSetUomLabels() {
		return worldToTexture.isSetUomLabels();
	}

	@Override
	public void unsetAxisLabels() {
		worldToTexture.unsetAxisLabels();
	}

	@Override
	public void unsetUomLabels() {
		worldToTexture.unsetUomLabels();
	}

	@Override
	public boolean unsetAxisLabels(String axisLabel) {
		if (worldToTexture.isSetAxisLabels())
			return worldToTexture.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	@Override
	public boolean unsetUomLabels(String uomLabel) {
		if (worldToTexture.isSetUomLabels())
			return worldToTexture.getUomLabels().remove(uomLabel);
			
		return false;
	}
	
}
