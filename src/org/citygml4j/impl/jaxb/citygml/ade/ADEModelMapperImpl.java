package org.citygml4j.impl.jaxb.citygml.ade;

import java.util.HashMap;
import java.util.LinkedList;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.ADEModelMapper;

public class ADEModelMapperImpl implements ADEModelMapper {
	private HashMap<String, LinkedList<ADEModelMapper>> modelMapperMap;

	public ADEModelMapperImpl() {
		modelMapperMap = new HashMap<String, LinkedList<ADEModelMapper>>();
	}

	public void registerADEModelMapper(String namespaceURI, ADEModelMapper adeModelMapper) {
		LinkedList<ADEModelMapper> adeModelMapperList = modelMapperMap.get(namespaceURI);
		if (adeModelMapperList == null) {
			adeModelMapperList = new LinkedList<ADEModelMapper>();
			modelMapperMap.put(namespaceURI, adeModelMapperList);
		}

		if (!adeModelMapperList.contains(adeModelMapper))
			adeModelMapperList.addLast(adeModelMapper);
	}

	public void unregisterADE(String namespaceURI) {
		modelMapperMap.remove(namespaceURI);
	}
	
	@Override
	public ADEComponent toADEComponent(Object jaxbObject, QName name) {
		ADEComponent adeObject = null;
		LinkedList<ADEModelMapper> adeModelMapperList = modelMapperMap.get(name.getNamespaceURI());

		if (adeModelMapperList != null) {
			for (ADEModelMapper mapper : adeModelMapperList) {
				adeObject = mapper.toADEComponent(jaxbObject, name);
				if (adeObject != null)
					break;
			}
		}				

		return adeObject;
	}

	@Override
	public JAXBElement<?> toJAXB(ADEComponent adeObject) {
		JAXBElement<?> jaxbElement = null;
		LinkedList<ADEModelMapper> adeModelMapperList = modelMapperMap.get(adeObject.getADENamespaceURI());
		
		if (adeModelMapperList != null) {
			for (ADEModelMapper mapper : adeModelMapperList) {
				jaxbElement = mapper.toJAXB(adeObject);
				if (jaxbElement != null)
					break;
			}
		}

		return jaxbElement;
	}

}
