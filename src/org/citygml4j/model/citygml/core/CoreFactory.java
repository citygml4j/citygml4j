package org.citygml4j.model.citygml.core;

import java.util.List;

public interface CoreFactory {
	public Address createAddress();
	public AddressProperty createAddressProperty();
	public CityModel createCityModel();
	public CityObjectMember createCityObjectMember();
	public ExternalObject createExternalObject();
	public ExternalReference createExternalReference();
	public GeneralizationRelation createGeneralizationRelation();
	public ImplicitGeometry createImplicitGeometry();
	public ImplicitRepresentationProperty createImplicitRepresentationProperty();
	public TransformationMatrix2x2 createTransformationMatrix2x2();
	public TransformationMatrix2x2 createTransformationMatrix2x2(double xx, double yx, double xy, double yy);
	public TransformationMatrix2x2 createTransformationMatrix2x2(List<Double> coordList);	
	public TransformationMatrix3x4 createTransformationMatrix3x4();
	public TransformationMatrix3x4 createTransformationMatrix3x4(
			double xx, double yx, double zx, double tx,
			double xy, double yy, double zy, double ty,
			double xz, double yz, double zz, double tz);
	public TransformationMatrix4x4 createTransformationMatrix4x4();
	public TransformationMatrix4x4 createTransformationMatrix4x4(
			double xx, double yx, double zx, double tx,
			double xy, double yy, double zy, double ty,
			double xz, double yz, double zz, double tz,
			double xt, double yt, double zt, double tt);
	public TransformationMatrix4x4 createTransformationMatrix4x4(List<Double> coordList);
	public XalAddressProperty createXalAddressProperty();
	
}
