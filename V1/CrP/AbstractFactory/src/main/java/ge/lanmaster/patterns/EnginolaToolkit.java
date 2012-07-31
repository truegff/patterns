package ge.lanmaster.patterns;

public class EnginolaToolkit implements ArchitectureToolkitIF{
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    public MMU createMMU() {
        return new EnginolaMMU();
    }
}

