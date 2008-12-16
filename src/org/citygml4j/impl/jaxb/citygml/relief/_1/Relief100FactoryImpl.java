package org.citygml4j.impl.jaxb.citygml.relief._1;

import org.citygml4j.impl.jaxb.citygml.AbstractReliefFactoryImpl;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;

public class Relief100FactoryImpl extends AbstractReliefFactoryImpl {

	@Override
	public BreaklineRelief createBreaklineRelief() {
		return new BreaklineReliefImpl();
	}

	@Override
	public MassPointRelief createMassPointRelief() {
		return new MassPointReliefImpl();
	}

	@Override
	public RasterRelief createRasterRelief() {
		return new RasterReliefImpl();
	}

	@Override
	public ReliefComponentProperty createReliefComponentProperty() {
		return new ReliefComponentPropertyImpl();
	}

	@Override
	public ReliefFeature createReliefFeature() {
		return new ReliefFeatureImpl();
	}

	@Override
	public TINRelief createTINRelief() {
		return new TINReliefImpl();
	}

	@Override
	public TinProperty createTinProperty() {
		return new TinPropertyImpl();
	}

}
