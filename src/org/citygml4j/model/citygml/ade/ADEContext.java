package org.citygml4j.model.citygml.ade;

public class ADEContext {
	private String namespaceURI;
	
	public ADEContext(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	
	public String getNamespaceURI() {
		return namespaceURI;
	}
}
