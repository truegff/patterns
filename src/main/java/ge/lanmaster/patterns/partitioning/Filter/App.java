package ge.lanmaster.patterns.partitioning.Filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Filter Pattern" );
    }
}


/*
 * Here is a common arrangement of FilterReader objects for a program that reads
 * lines of text as commands and needs to track line numbers for producing error
 * messages:
 */

/*
LineNumberReader in;
void init(String fName) {
    FileReader fin;
    try {
        fin = new FileReader(fName);
        in = new LineNumberReader(new BufferedReader(fin));
    } catch (FileNotFoundException e) {
        System.out.println("Unable to open "+fName);
        //...
    }
}*/
