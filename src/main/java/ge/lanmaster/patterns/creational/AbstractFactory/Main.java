package ge.lanmaster.patterns.creational.AbstractFactory;

import ge.lanmaster.patterns.creational.AbstractFactory.impl.ArchitectureToolkit;
import ge.lanmaster.patterns.creational.AbstractFactory.impl.CPU;
import ge.lanmaster.patterns.creational.AbstractFactory.impl.MMU;

public class Main {

	public static void main(String[] args) {

		ToolkitFactory myFactory;
		myFactory = ToolkitFactory.getInstance();
		ArchitectureToolkit af;
		af = myFactory.createToolkit(ToolkitFactory.EMBER);
		CPU cpu = af.createCPU();
		MMU mmu = af.createMMU();

	}

}
