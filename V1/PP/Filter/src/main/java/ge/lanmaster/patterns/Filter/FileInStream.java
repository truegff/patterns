package ge.lanmaster.patterns.Filter;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class reads  stream of bytes from a file.
 */
public class FileInStream implements InStreamIF{
    private RandomAccessFile file;

    /**
     * Constructor
     * @param fName The name of the file to read.
     * @throws IOException
     */
    public FileInStream(String fName) throws IOException{
        file = new RandomAccessFile(fName, "r");
    }

    /**
     * Read bytes from a file and fill an array with those
     * bytes.
     */
    public int read(byte[] array) throws IOException {
        return file.read(array);
    }
}
