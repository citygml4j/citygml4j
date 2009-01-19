package org.citygml4j.impl.jaxb.citygml.transportation._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.tran._1.SquareType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Square;

public class SquareImpl extends TransportationComplexImpl implements Square {
	private SquareType squareType;

	public SquareImpl() {
		this(new SquareType());
	}

	public SquareImpl(SquareType suareType) {
		super(suareType);
		this.squareType = suareType;
	}

	@Override
	public SquareType getJAXBObject() {
		return squareType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SQUARE;
	}

	@Override
	public void addGenericApplicationPropertyOfSquare(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			squareType.get_GenericApplicationPropertyOfSquare().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfSquare() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : squareType.get_GenericApplicationPropertyOfSquare()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfSquare(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			squareType.unset_GenericApplicationPropertyOfSquare();
			squareType.get_GenericApplicationPropertyOfSquare().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfSquare() {
		return squareType.isSet_GenericApplicationPropertyOfSquare();
	}

	@Override
	public void unsetGenericApplicationPropertyOfSquare() {
		squareType.unset_GenericApplicationPropertyOfSquare();
	}
	
	@Override
	public boolean unsetGenericApplicationPropertyOfSquare(ADEComponent adeObject) {
		if (squareType.isSet_GenericApplicationPropertyOfSquare()) {
			Iterator<JAXBElement<?>> iter = squareType.get_GenericApplicationPropertyOfSquare().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}
	
}
