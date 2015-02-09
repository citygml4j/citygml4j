package org.citygml4j.util.internal.xml;

import javax.xml.transform.sax.TransformerHandler;

public class TransformerChain {
	private final TransformerHandler head;
	private final TransformerHandler tail;
	
	public TransformerChain(TransformerHandler head, TransformerHandler tail) {
		this.head = head;
		this.tail = tail;
	}

	public TransformerHandler head() {
		return head;
	}

	public TransformerHandler tail() {
		return tail;
	}
	
}
