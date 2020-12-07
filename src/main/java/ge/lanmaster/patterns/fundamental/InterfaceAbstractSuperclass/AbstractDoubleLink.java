package ge.lanmaster.patterns.fundamental.InterfaceAbstractSuperclass;

abstract class AbstractDoubleLink implements DoubleLink {
	private DoubleLink prev;
	private DoubleLink next;

	public DoubleLink getNext() {
		return next;
	}

	public void setNext(DoubleLink newValue) {
		next = newValue;
	}

	public DoubleLink getPrev() {
		return prev;
	}

	public void setPrev(DoubleLink newValue) {
		prev = newValue;
	}
}