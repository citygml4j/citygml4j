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

	@Override
	public List<String> getAxisLabels() {
		return abstractGeometryType.getAxisLabels();
	}

	@Override
	public String getGid() {
		return abstractGeometryType.getGid();
	}

	@Override
	public Integer getSrsDimension() {
		if (abstractGeometryType.isSetSrsDimension())
			return new Integer(abstractGeometryType.getSrsDimension().intValue());

		return null;
	}

	@Override
	public String getSrsName() {
		return abstractGeometryType.getSrsName();
	}

	@Override
	public List<String> getUomLabels() {
		return abstractGeometryType.getUomLabels();
	}

	@Override
	public void setSrsDimension(Integer srsDimension) {
		abstractGeometryType.setSrsDimension(new BigInteger(String.valueOf(srsDimension)));
	}

	@Override
	public void setSrsName(String srsName) {
		abstractGeometryType.setSrsName(srsName);
	}

	@Override
	public void addAxisLabel(String axisLabel) {
		abstractGeometryType.getAxisLabels().add(axisLabel);
	}

	@Override
	public void addUomLabel(String uomLabel) {
		abstractGeometryType.getUomLabels().add(uomLabel);
	}

	@Override
	public void setAxisLabels(List<String> axisLabels) {
		abstractGeometryType.unsetAxisLabels();
		abstractGeometryType.getAxisLabels().addAll(axisLabels);
	}

	@Override
	public void setUomLabels(List<String> uomLabels) {
		abstractGeometryType.unsetUomLabels();
		abstractGeometryType.getUomLabels().addAll(uomLabels);
	}

	@Override
	public boolean isSetAxisLabels() {
		return abstractGeometryType.isSetAxisLabels();
	}

	@Override
	public boolean isSetUomLabels() {
		return abstractGeometryType.isSetUomLabels();
	}

	@Override
	public void unsetAxisLabels() {
		abstractGeometryType.unsetAxisLabels();
	}

	@Override
	public void unsetUomLabels() {
		abstractGeometryType.unsetUomLabels();
	}

	@Override
	public boolean isSetSrsDimension() {
		return abstractGeometryType.isSetSrsDimension();
	}

	@Override
	public boolean isSetSrsName() {
		return abstractGeometryType.isSetSrsName();
	}

	@Override
	public void unsetSrsDimension() {
		abstractGeometryType.setSrsDimension(null);
	}

	@Override
	public void unsetSrsName() {
		abstractGeometryType.setSrsName(null);
	}

	@Override
	public boolean isSetGid() {
		return abstractGeometryType.isSetGid();
	}

	@Override
	public void setGid(String gid) {
		abstractGeometryType.setGid(gid);
	}

	@Override
	public void unsetGid() {
		abstractGeometryType.setGid(null);
	}

	@Override
	public boolean unsetAxisLabels(String axisLabel) {
		if (abstractGeometryType.isSetAxisLabels())
			return abstractGeometryType.getAxisLabels().remove(axisLabel);
		
		return false;
	}

	@Override
	public boolean unsetUomLabels(String uomLabel) {
		if (abstractGeometryType.isSetUomLabels())
			return abstractGeometryType.getUomLabels().remove(uomLabel);
		
		return false;
	}

}
