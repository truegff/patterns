package ge.lanmaster.patterns.creational.Builder.builder;

import ge.lanmaster.patterns.creational.Builder.product.Product;

public abstract class AbstractBuilder implements Builder {
	public abstract Product build();
}
