package ge.lanmaster.patterns.structural.DynamicLinkage;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class FoodProcessorEnvironment implements FoodProcessorEnvironmentIF {

    private static final URL[] classPath; // URL for programs

    static {
        try {
            classPath = new URL[]{new URL("file:///bin")};
        } catch (MalformedURLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Mix food at the given speed.
     */
    public void slice(int width) {
         throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Mix food at the given speed.
     */
    public void mix(int speed) {
         throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Weight food.
     */
    public double weight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Run the named program.
     */
    void run(String programName) {
        // Create a ClassLoader to load the program clases.
        // When those classes are no longer used, they can be
        // garbage-collected when their ClassLoader is garbage-
        // collected.
        URLClassLoader classLoader;
        classLoader = new URLClassLoader(classPath);

        Class programClass;
        try {
            programClass = classLoader.loadClass(programName);
        } catch (ClassNotFoundException e) {
            //Not found
            return;
        }

        AbstractFoodProcessorProgram program;
        try {
            program = (AbstractFoodProcessorProgram)programClass.newInstance();
        } catch (Exception e) {
            // Unable to run
            return;
        }

        program.setEnvironment(this);

        System.out.println(program.getName() + ".run()");

        program.start();
    }
}
