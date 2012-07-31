package ge.lanmaster.patterns;

public class ToolkitFactory {
    private static ToolkitFactory myInstance = new ToolkitFactory();
    public final static int ENGINOLA = 900;
    public final static int EMBER = 901;

    public static ToolkitFactory getInstance() {
        return myInstance;
    }

    public ArchitectureToolkitIF createToolkit(int architecture) {
        switch (architecture) {
            case ENGINOLA: return new EnginolaToolkit();
            case EMBER: return new EmberToolkit();
        }
        String errMsg = Integer.toString(architecture);
        throw new IllegalArgumentException(errMsg);
    }
}
