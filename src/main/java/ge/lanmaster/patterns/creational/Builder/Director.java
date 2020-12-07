package ge.lanmaster.patterns.creational.Builder;

import ge.lanmaster.patterns.creational.Builder.builder.Builder;
import ge.lanmaster.patterns.creational.Builder.product.Product;

public class Director {
	public Product Build(Builder builder) {
		return builder.getInstance().build();
	}
}
