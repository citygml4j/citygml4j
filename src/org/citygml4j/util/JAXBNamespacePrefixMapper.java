package org.citygml4j.util;

import java.util.HashMap;

import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.core.CoreModule;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class JAXBNamespacePrefixMapper extends NamespacePrefixMapper {
	private HashMap<String, String> prefixMap;

	public JAXBNamespacePrefixMapper() {
		prefixMap = new HashMap<String, String>();
		
		prefixMap.put("http://www.opengis.net/gml", "gml");
		prefixMap.put("http://www.w3.org/1999/xlink", "xlink");
		prefixMap.put("http://www.w3.org/2001/SMIL20/", "smil20");
		prefixMap.put("http://www.w3.org/2001/SMIL20/Language", "smil20lang");
		prefixMap.put("urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", "xAL");
		prefixMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
		
		// v040 prefix
		prefixMap.put(CoreModule.v0_4_0.getNamespaceUri(), CoreModule.v0_4_0.getNamespacePrefix());
		
		// prefixes of all other modules
		for (CityGMLModule module : CityGMLModules.getModules()) {
			if (module.getModuleVersion() == CityGMLModuleVersion.v0_4_0)
				continue;
			
			prefixMap.put(module.getNamespaceUri(), module.getNamespacePrefix());
		}
	}
		
	public void setNamespacePrefixMapping(String uri, String prefix) {
		prefixMap.put(uri, prefix);
	}

	public String getNamespacePrefixMapping(String uri) {
		return prefixMap.get(uri);
	}

	public String getPreferredPrefix(String uri, String suggestion, boolean requirePrefix) {
		String prefix = prefixMap.get(uri);
		if (prefix != null)
			return prefix;

		return suggestion;
	}
}
