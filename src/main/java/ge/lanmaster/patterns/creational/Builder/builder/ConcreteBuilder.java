package ge.lanmaster.patterns.creational.Builder.builder;

import ge.lanmaster.patterns.creational.Builder.product.Product;
import ge.lanmaster.patterns.creational.Builder.product.ProductInstance;

public class ConcreteBuilder extends AbstractBuilder {

	@Override
	public AbstractBuilder getInstance() {
		return new ConcreteBuilder();
	}

	@Override
	public Product build() {
		return new ProductInstance();
	}
}
