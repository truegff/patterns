package ge.lanmaster.patterns.partitioning.Composite.elements.impl;

import ge.lanmaster.patterns.partitioning.Composite.elements.CompositeDocumentElement;

public class Page extends CompositeDocumentElement {

	@Override
	public int getCharLength() {
		return 1;
	}

}