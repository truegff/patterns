package ge.lanmaster.patterns.fundamental.Proxy;

import java.util.HashMap;

public class Demo {
	public static void main(String[] args) {
		System.out.println("Proxy pattern");
		HashMap m1 = new HashMap();
		try {
			LazyCloneMap map1 = new LazyCloneMap(m1);
			LazyCloneMap map2 = (LazyCloneMap) map1.clone();
		} catch (Exception ex) {
			//todo [AD]
		}
	}
}
