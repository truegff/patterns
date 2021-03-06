package ge.lanmaster.patterns.partitioning.Composite.elements;

import java.util.Vector;

public abstract class CompositeDocumentElement extends AbstractDocumentElement {

	private Vector<DocumentElement> children = new Vector();
	private int cachedCharLength = -1;

	public DocumentElement getChild(int index) {
		return children.elementAt(index);
	}

	public synchronized void addChild(DocumentElement child) {
		synchronized (child) {
			children.addElement(child);
			((AbstractDocumentElement) child).setParent(this);
			changeNotification();
		}
	}

	public synchronized void removeChild(AbstractDocumentElement child) {
		synchronized (child) {
			if (this == child.getParent()) {
				child.setParent(null);
			}
			children.removeElement(child);
			changeNotification();
		}
	}

	private void changeNotification() {
		cachedCharLength = -1;
		if (getParent() != null) {
			getParent().changeNotification();
		}
	}

	@Override
	public int getCharLength() {
		int len = 0;
		for (int i = 0; i < children.size(); i++) {
			AbstractDocumentElement thisChild;
			thisChild = (AbstractDocumentElement) children.elementAt(i);
			len += thisChild.getCharLength();
		}
		cachedCharLength = len;
		return len;
	}

}
