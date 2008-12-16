package org.citygml4j.impl.jaxb.citygml.core._0_4;

import java.util.List;

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

public class Core040FactoryImpl extends AbstractCoreFactoryImpl {

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
	public TransformationMatrix2x2 createTransformationMatrix2x2(double xx, double yx, double xy, double yy) {
		return new TransformationMatrix2x2Impl(xx, yx, xy, yy);
	}

	@Override
	public TransformationMatrix2x2 createTransformationMatrix2x2(List<Double> coordList) {
		return new TransformationMatrix2x2Impl(coordList);
	}

	@Override
	public TransformationMatrix3x4 createTransformationMatrix3x4() {
		return new TransformationMatrix3x4Impl();
	}

	@Override
	public TransformationMatrix3x4 createTransformationMatrix3x4(
			double xx, double yx, double zx, double tx, 
			double xy, double yy, double zy, double ty, 
			double xz, double yz, double zz, double tz) {
		return new TransformationMatrix3x4Impl(
				xx, yx, zx, tx, 
				xy, yy, zy, ty,
				xz, yz, zz, tz);
	}

	@Override
	public TransformationMatrix4x4 createTransformationMatrix4x4() {
		return new TransformationMatrix4x4Impl();
	}

	@Override
	public TransformationMatrix4x4 createTransformationMatrix4x4(
			double xx, double yx, double zx, double tx, 
			double xy, double yy, double zy, double ty, 
			double xz, double yz, double zz, double tz, 
			double xt, double yt, double zt, double tt) {
		return new TransformationMatrix4x4Impl(
				xx, yx, zx, tx,
				xy, yy, zy, ty,
				xz, yz, zz, tz,
				xt, yt, zt, tt);
	}

	@Override
	public TransformationMatrix4x4 createTransformationMatrix4x4(List<Double> coordList) {
		return new TransformationMatrix4x4Impl(coordList);
	}

	@Override
	public XalAddressProperty createXalAddressProperty() {
		return new XalAddressPropertyImpl();
	}

}
