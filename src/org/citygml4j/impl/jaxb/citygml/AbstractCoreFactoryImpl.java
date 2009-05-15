package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.geometry.Matrix;
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
	
	public abstract Address createAddress();

	public abstract AddressProperty createAddressProperty();

	public abstract CityModel createCityModel();

	public abstract CityObjectMember createCityObjectMember();

	public abstract ExternalObject createExternalObject();

	public abstract ExternalReference createExternalReference();

	public abstract GeneralizationRelation createGeneralizationRelation();

	public abstract ImplicitGeometry createImplicitGeometry();

	public abstract ImplicitRepresentationProperty createImplicitRepresentationProperty();

	public abstract TransformationMatrix2x2 createTransformationMatrix2x2();

	public abstract TransformationMatrix2x2 createTransformationMatrix2x2(Matrix matrix);

	public abstract TransformationMatrix3x4 createTransformationMatrix3x4();

	public abstract TransformationMatrix3x4 createTransformationMatrix3x4(Matrix matrix);
	
	public abstract TransformationMatrix4x4 createTransformationMatrix4x4();

	public abstract TransformationMatrix4x4 createTransformationMatrix4x4(Matrix matrix);

	public abstract XalAddressProperty createXalAddressProperty();

}
