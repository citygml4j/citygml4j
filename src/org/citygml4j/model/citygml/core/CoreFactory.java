package org.citygml4j.model.citygml.core;

import org.citygml4j.geometry.Matrix;

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
	public TransformationMatrix2x2 createTransformationMatrix2x2(Matrix matrix);
	public TransformationMatrix3x4 createTransformationMatrix3x4();
	public TransformationMatrix3x4 createTransformationMatrix3x4(Matrix matrix);
	public TransformationMatrix4x4 createTransformationMatrix4x4();
	public TransformationMatrix4x4 createTransformationMatrix4x4(Matrix matrix);
	public XalAddressProperty createXalAddressProperty();
	
}
