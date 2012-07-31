package ge.lanmaster.patterns;
public class EmberToolkit implements ArchitectureToolkitIF{
    public CPU createCPU() {
        return new EmberCPU();
    }

    public MMU createMMU() {
        return new EmberMMU();
    }
}

