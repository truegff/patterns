package ge.lanmaster.patterns.Prototype;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class PrototypeBuilder {
    private App app;

    public PrototypeBuilder(App app) {
        this.app = app;
    }

    int loadPrototypes(String fname){

        int objectCount = 0;

        try {
            InputStream in;
            in = new FileInputStream(fname);
            in = new BufferedInputStream(in);
            ObjectInputStream objectInputStream=new ObjectInputStream(in);
            while(true){
                Object c = objectInputStream.readObject();
                if (c instanceof Prototype) {
                    app.registerPrototype((Prototype) c);
                }
            }
        } catch (Exception e) {
        }
        return objectCount;
    }
}
