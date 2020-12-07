package ge.lanmaster.patterns.creational.AbstractFactory.impl.ember;

import ge.lanmaster.patterns.creational.AbstractFactory.impl.ArchitectureToolkit;
import ge.lanmaster.patterns.creational.AbstractFactory.impl.CPU;
import ge.lanmaster.patterns.creational.AbstractFactory.impl.MMU;

public class EmberToolkit implements ArchitectureToolkit {
	public CPU createCPU() {
		return new EmberCPU();
	}

	public MMU createMMU() {
		return new EmberMMU();
	}
}

