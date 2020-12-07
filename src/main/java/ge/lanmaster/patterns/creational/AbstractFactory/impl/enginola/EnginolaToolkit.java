package ge.lanmaster.patterns.creational.AbstractFactory.impl.enginola;

import ge.lanmaster.patterns.creational.AbstractFactory.impl.ArchitectureToolkit;
import ge.lanmaster.patterns.creational.AbstractFactory.impl.CPU;
import ge.lanmaster.patterns.creational.AbstractFactory.impl.MMU;

public class EnginolaToolkit implements ArchitectureToolkit {
	public CPU createCPU() {
		return new EnginolaCPU();
	}

	public MMU createMMU() {
		return new EnginolaMMU();
	}
}

