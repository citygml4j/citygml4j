package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.TrackType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Track;

public class TrackImpl extends TransportationComplexImpl implements Track {
	private TrackType trackType;

	public TrackImpl() {
		this(new TrackType());
	}

	public TrackImpl(TrackType trackType) {
		super(trackType);
		this.trackType = trackType;
	}

	@Override
	public TrackType getJAXBObject() {
		return trackType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRACK;
	}

	public void addGenericApplicationPropertyOfTrack(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			trackType.get_GenericApplicationPropertyOfTrack().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTrack() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : trackType.get_GenericApplicationPropertyOfTrack()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfTrack(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			trackType.unset_GenericApplicationPropertyOfTrack();
			trackType.get_GenericApplicationPropertyOfTrack().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfTrack() {
		return trackType.isSet_GenericApplicationPropertyOfTrack();
	}

	public void unsetGenericApplicationPropertyOfTrack() {
		trackType.unset_GenericApplicationPropertyOfTrack();
	}

	public boolean unsetGenericApplicationPropertyOfTrack(ADEComponent adeObject) {
		if (trackType.isSet_GenericApplicationPropertyOfTrack()) {
			Iterator<JAXBElement<?>> iter = trackType.get_GenericApplicationPropertyOfTrack().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}

}
