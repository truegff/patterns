package ge.lanmaster.patterns.fundamental.Proxy;

class MutableInteger {
	public int val;

	public MutableInteger(int value) {
		setValue(value);
	}

	public int getValue() {
		return (val);
	}

	public void setValue(int value) {
		val = value;
	}
}