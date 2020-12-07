package ge.lanmaster.patterns.partitioning.Composite.elements;

import java.awt.*;

public abstract class AbstractDocumentElement implements DocumentElement {

	private Font font;
	private CompositeDocumentElement parent;

	public CompositeDocumentElement getParent() {
		return parent;
	}

	public void setParent(CompositeDocumentElement parent) {
		this.parent = parent;
	}

	public Font getFont() {
		if (font != null) {
			return font;
		} else if (parent != null) {
			return parent.getFont();
		} else return null;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public abstract int getCharLength();

}
