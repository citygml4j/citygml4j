package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;

public class ReliefConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected ReliefConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected BreaklineRelief convertBreaklineRelief(BreaklineRelief src) {
		BreaklineRelief dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof BreaklineRelief)
				dest = (BreaklineRelief)tmp;
		} else {
			dest = citygml.createBreaklineRelief(builder.convertContext.demModule);
			if (dest != null)
				convertBreaklineRelief(src, dest);
		}

		return dest;
	}

	protected MassPointRelief convertMassPointRelief(MassPointRelief src) {
		MassPointRelief dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof MassPointRelief)
				dest = (MassPointRelief)tmp;
		} else {
			dest = citygml.createMassPointRelief(builder.convertContext.demModule);
			if (dest != null)
				convertMassPointRelief(src, dest);
		}

		return dest;
	}

	protected RasterRelief convertRasterRelief(RasterRelief src) {
		RasterRelief dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof RasterRelief)
				dest = (RasterRelief)tmp;
		} else {
			dest = citygml.createRasterRelief(builder.convertContext.demModule);
			if (dest != null)
				convertRasterRelief(src, dest);
		}

		return dest;
	}

	protected ReliefComponentProperty convertReliefComponentProperty(ReliefComponentProperty src) {
		ReliefComponentProperty dest = citygml.createReliefComponentProperty(builder.convertContext.demModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				CityObject tmp = builder.core.convertCityObject(src.getObject());
				if (tmp != null && tmp instanceof ReliefComponent)
					dest.setObject((ReliefComponent)tmp);
			}
		}

		return dest;
	}

	protected ReliefFeature convertReliefFeature(ReliefFeature src) {
		ReliefFeature dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof ReliefFeature)
				dest = (ReliefFeature)tmp;
		} else {
			dest = citygml.createReliefFeature(builder.convertContext.demModule);
			if (dest != null)
				convertReliefFeature(src, dest);
		}

		return dest;
	}

	protected TinProperty convertTinProperty(TinProperty src) {
		TinProperty dest = citygml.createTinProperty(builder.convertContext.demModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) 
				dest.setObject(src.getObject());
		}

		return dest;
	}

	protected TINRelief convertTINRelief(TINRelief src) {
		TINRelief dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof TINRelief)
				dest = (TINRelief)tmp;
		} else {
			dest = citygml.createTINRelief(builder.convertContext.demModule);
			if (dest != null)
				convertTINRelief(src, dest);
		}

		return dest;
	}

	protected void convertReliefComponent(ReliefComponent src, ReliefComponent dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetLod())
			dest.setLod(src.getLod());

		if (src.isSetExtent())
			dest.setExtent(src.getExtent());

		if (src.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfReliefComponent()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfReliefComponent(tmp);
			}
		}
	}

	protected void convertBreaklineRelief(BreaklineRelief src, BreaklineRelief dest) {
		convertReliefComponent(src, dest);

		if (src.isSetRidgeOrValleyLines())
			dest.setRidgeOrValleyLines(src.getRidgeOrValleyLines());

		if (src.isSetBreaklines())
			dest.setBreaklines(src.getBreaklines());

		if (src.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBreaklineRelief()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfBreaklineRelief(tmp);
			}
		}
	}

	protected void convertMassPointRelief(MassPointRelief src, MassPointRelief dest) {
		convertReliefComponent(src, dest);

		if (src.isSetReliefPoints())
			dest.setReliefPoints(src.getReliefPoints());

		if (src.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfMassPointRelief()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfMassPointRelief(tmp);
			}
		}
	}

	protected void convertRasterRelief(RasterRelief src, RasterRelief dest) {
		convertReliefComponent(src, dest);

		if (src.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfRasterRelief()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfRasterRelief(tmp);
			}
		}
	}

	protected void convertReliefFeature(ReliefFeature src, ReliefFeature dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetLod())
			dest.setLod(src.getLod());

		if (src.isSetReliefComponent()) {
			for (ReliefComponentProperty component : src.getReliefComponent()) {
				ReliefComponentProperty tmp = convertReliefComponentProperty(component);
				if (tmp != null)
					dest.addReliefComponent(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfReliefFeature()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfReliefFeature(tmp);
			}
		}
	}

	protected void convertTINRelief(TINRelief src, TINRelief dest) {
		convertReliefComponent(src, dest);

		if (src.isSetTin()) {
			TinProperty tmp = convertTinProperty(src.getTin());
			if (tmp != null)
				dest.setTin(tmp);
		}
		
		if (src.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTinRelief()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfTinRelief(tmp);
			}
		}
	}
}
