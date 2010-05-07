package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.math.BigInteger;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometryType;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractGeometryImpl extends AbstractGMLImpl implements AbstractGeometry {
	private AbstractGeometryType abstractGeometryType;

	public AbstractGeometryImpl(AbstractGeometryType abstractGeometryType) {
		super(abstractGeometryType);
		this.abstractGeometryType = abstractGeometryType;
	}

	@Override
	public AbstractGeometryType getJAXBObject() {
		return abstractGeometryType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTGEOMETRY;
	}

	public List<String> getAxisLabels() {
		return abstractGeometryType.getAxisLabels();
	}

	public String getGid() {
		return abstractGeometryType.getGid();
	}

	public Integer getSrsDimension() {
		if (abstractGeometryType.isSetSrsDimension())
			return new Integer(abstractGeometryType.getSrsDimension().intValue());

		return null;
	}

	public String getSrsName() {
		return abstractGeometryType.getSrsName();
	}

	public List<String> getUomLabels() {
		return abstractGeometryType.getUomLabels();
	}

	public void setSrsDimension(Integer srsDimension) {
		abstractGeometryType.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	public void setSrsName(String srsName) {
		abstractGeometryType.setSrsName(srsName);
	}

	public void addAxisLabel(String axisLabel) {
		abstractGeometryType.getAxisLabels().add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		abstractGeometryType.getUomLabels().add(uomLabel);
	}

	public void setAxisLabels(List<String> axisLabels) {
		abstractGeometryType.unsetAxisLabels();
		abstractGeometryType.getAxisLabels().addAll(axisLabels);
	}

	public void setUomLabels(List<String> uomLabels) {
		abstractGeometryType.unsetUomLabels();
		abstractGeometryType.getUomLabels().addAll(uomLabels);
	}

	public boolean isSetAxisLabels() {
		return abstractGeometryType.isSetAxisLabels();
	}

	public boolean isSetUomLabels() {
		return abstractGeometryType.isSetUomLabels();
	}

	public void unsetAxisLabels() {
		abstractGeometryType.unsetAxisLabels();
	}

	public void unsetUomLabels() {
		abstractGeometryType.unsetUomLabels();
	}

	public boolean isSetSrsDimension() {
		return abstractGeometryType.isSetSrsDimension();
	}

	public boolean isSetSrsName() {
		return abstractGeometryType.isSetSrsName();
	}

	public void unsetSrsDimension() {
		abstractGeometryType.setSrsDimension(null);
	}

	public void unsetSrsName() {
		abstractGeometryType.setSrsName(null);
	}

	public boolean isSetGid() {
		return abstractGeometryType.isSetGid();
	}

	public void setGid(String gid) {
		abstractGeometryType.setGid(gid);
	}

	public void unsetGid() {
		abstractGeometryType.setGid(null);
	}

	public boolean unsetAxisLabels(String axisLabel) {
		if (abstractGeometryType.isSetAxisLabels())
			return abstractGeometryType.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	public boolean unsetUomLabels(String uomLabel) {
		if (abstractGeometryType.isSetUomLabels())
			return abstractGeometryType.getUomLabels().remove(uomLabel);
		
		return false;
	}

}
