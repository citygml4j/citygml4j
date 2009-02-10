package org.citygml4j.impl.jaxb.citygml.core._1;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.impl.jaxb.citygml.AbstractCoreFactoryImpl;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;

public class Core100FactoryImpl extends AbstractCoreFactoryImpl {

	@Override
	public Address createAddress() {
		return new AddressImpl();
	}

	@Override
	public AddressProperty createAddressProperty() {
		return new AddressPropertyImpl();
	}

	@Override
	public CityModel createCityModel() {
		return new CityModelImpl();
	}

	@Override
	public CityObjectMember createCityObjectMember() {
		return new CityObjectMemberImpl();
	}

	@Override
	public ExternalObject createExternalObject() {
		return new ExternalObjectImpl();
	}

	@Override
	public ExternalReference createExternalReference() {
		return new ExternalReferenceImpl();
	}

	@Override
	public GeneralizationRelation createGeneralizationRelation() {
		return new GeneralizationRelationImpl();
	}

	@Override
	public ImplicitGeometry createImplicitGeometry() {
		return new ImplicitGeometryImpl();
	}

	@Override
	public ImplicitRepresentationProperty createImplicitRepresentationProperty() {
		return new ImplicitRepresentationPropertyImpl();
	}

	@Override
	public TransformationMatrix2x2 createTransformationMatrix2x2() {
		return new TransformationMatrix2x2Impl();
	}

	@Override
	public TransformationMatrix2x2 createTransformationMatrix2x2(Matrix matrix) {
		return new TransformationMatrix2x2Impl(matrix);
	}

	@Override
	public TransformationMatrix3x4 createTransformationMatrix3x4() {
		return new TransformationMatrix3x4Impl();
	}
	
	@Override
	public TransformationMatrix3x4 createTransformationMatrix3x4(Matrix matrix) {
		return new TransformationMatrix3x4Impl(matrix);
	}

	@Override
	public TransformationMatrix4x4 createTransformationMatrix4x4() {
		return new TransformationMatrix4x4Impl();
	}

	@Override
	public TransformationMatrix4x4 createTransformationMatrix4x4(Matrix matrix) {
		return new TransformationMatrix4x4Impl(matrix);
	}

	@Override
	public XalAddressProperty createXalAddressProperty() {
		return new XalAddressPropertyImpl();
	}

}
