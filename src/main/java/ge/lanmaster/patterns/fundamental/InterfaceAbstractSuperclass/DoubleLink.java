package ge.lanmaster.patterns.fundamental.InterfaceAbstractSuperclass;

interface DoubleLink {
	DoubleLink getNext();

	void setNext(DoubleLink newValue);

	DoubleLink getPrev();

	void setPrev(DoubleLink newValue);
}