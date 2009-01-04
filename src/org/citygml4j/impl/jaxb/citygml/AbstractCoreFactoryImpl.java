package org.citygml4j.impl.jaxb.citygml;

import java.util.List;

import org.citygml4j.impl.jaxb.citygml.core._0_4.Core040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.core._1.Core100FactoryImpl;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.CoreFactory;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;

public abstract class AbstractCoreFactoryImpl implements CoreFactory {
	private static Core040FactoryImpl factory040 = new Core040FactoryImpl();
	private static Core100FactoryImpl factory100 = new Core100FactoryImpl();
	
	public static CoreFactory getInstance(CoreModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract Address createAddress();

	@Override
	public abstract AddressProperty createAddressProperty();

	@Override
	public abstract CityModel createCityModel();

	@Override
	public abstract CityObjectMember createCityObjectMember();

	@Override
	public abstract ExternalObject createExternalObject();

	@Override
	public abstract ExternalReference createExternalReference();

	@Override
	public abstract GeneralizationRelation createGeneralizationRelation();

	@Override
	public abstract ImplicitGeometry createImplicitGeometry();

	@Override
	public abstract ImplicitRepresentationProperty createImplicitRepresentationProperty();

	@Override
	public abstract TransformationMatrix2x2 createTransformationMatrix2x2();

	@Override
	public abstract TransformationMatrix2x2 createTransformationMatrix2x2(double xx,
			double yx, double xy, double yy);

	@Override
	public abstract TransformationMatrix2x2 createTransformationMatrix2x2(
			List<Double> coordList);

	@Override
	public abstract TransformationMatrix3x4 createTransformationMatrix3x4();

	@Override
	public abstract TransformationMatrix3x4 createTransformationMatrix3x4(double xx,
			double yx, double zx, double tx, double xy, double yy, double zy,
			double ty, double xz, double yz, double zz, double tz);

	@Override
	public abstract TransformationMatrix3x4 createTransformationMatrix3x4(
			List<Double> coordList);
	
	@Override
	public abstract TransformationMatrix4x4 createTransformationMatrix4x4();

	@Override
	public abstract TransformationMatrix4x4 createTransformationMatrix4x4(double xx,
			double yx, double zx, double tx, double xy, double yy, double zy,
			double ty, double xz, double yz, double zz, double tz, double xt,
			double yt, double zt, double tt);

	@Override
	public abstract TransformationMatrix4x4 createTransformationMatrix4x4(
			List<Double> coordList);

	@Override
	public abstract XalAddressProperty createXalAddressProperty();

}
