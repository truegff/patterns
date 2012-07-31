package ge.lanmaster.pattern.VirtualProxy;

import java.lang.reflect.Constructor;

/**
 * @author alexander
 */
public class CabinetAssistantProxy implements CabinetAssistantIF {
    private CabinetAssistantIF assistant = null;

    // for assistant object's constructor
    private String myParam;

    public CabinetAssistantProxy(String s) {
        myParam = s;
    } // constructor(String)

    /**
     * Get the CabinetAssistant object that is used to
     * implement operations. This method creates it if it did
     * not exist.
     */
    private CabinetAssistantIF getCabinetAssistant() {
        if (assistant == null) {
            try {
                // Get the class object that represents
                // the Assistant class.
                Class clazz;
                clazz = Class.forName("ge.lanmaster.pattern.VirtualProxy.CabinetAssistant");


                // Get a constructor object to access the
                // CabinetAssistant class's constructor that
                // takes a single string argument.
                Constructor constructor;

                // Get the constructor object to create the
                // CabinetAssistant object.
                Class[] params;
                params = new Class[] {String.class};
                constructor = clazz.getConstructor(params);

                // Use the constructor object.
                Object[] actuals = new Object[] {myParam};
                assistant = (CabinetAssistantIF) constructor.newInstance(actuals);
            } catch (Exception e) {
            } // try

            if (assistant == null) {
                // Deal with failure to create
                // CabinetAssistant object
                throw new RuntimeException();
            } // if
        } // if
        return assistant;
    } // getCabinetAssistant()

    public void operation1() {
        getCabinetAssistant().operation1();
    } // operation1()

    public void operation2() {
        getCabinetAssistant().operation2();
    } // operation2()
    
} // class CabinetAssistantProxy
