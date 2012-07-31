package ge.lanmaster.pattern.Snapshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 * Hello world!
 */
public class App 
{
    private class SomeClass implements Serializable {
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
        }
        
        Integer a;
        Integer b;
    }

    public void run() throws IOException {
        FileOutputStream fout = //new FileOutputStream("filename.ser");
        new FileOutputStream(new File("filename.fnm"));

        //ObjectOutputStream obOut = new ObjectOutputStream(System.out);
        ObjectOutputStream obOut = new ObjectOutputStream(fout);

        SomeClass sc = new SomeClass();
        sc.a = new Integer(4);
        sc.b = new Integer(5);

        obOut.writeObject(sc);
        obOut.close();
        fout.close();
    }

    public void run2() throws Exception {
        FileInputStream fin = //new FileOutputStream("filename.ser");
        new FileInputStream(new File("filename.fnm"));

        //ObjectOutputStream obOut = new ObjectOutputStream(System.out);
        ObjectInputStream obIn = new ObjectInputStream(fin);

        SomeClass sc2 = new SomeClass();

        try {
        sc2 = (SomeClass) obIn.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println( sc2.a + "  "+ sc2.b );

        obIn.close();
        fin.close();
    }

    public static void main( String[] args )
    {
        System.out.println( "Snapshot Pattern" );

        App app = new App();
        try {
            app.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            app.run2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
