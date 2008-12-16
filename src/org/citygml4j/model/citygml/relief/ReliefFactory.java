package org.citygml4j.model.citygml.relief;

public interface ReliefFactory {
	public BreaklineRelief createBreaklineRelief();
	public MassPointRelief createMassPointRelief();
	public RasterRelief createRasterRelief();
	public ReliefComponentProperty createReliefComponentProperty();
	public ReliefFeature createReliefFeature();
	public TinProperty createTinProperty();
	public TINRelief createTINRelief();
}
