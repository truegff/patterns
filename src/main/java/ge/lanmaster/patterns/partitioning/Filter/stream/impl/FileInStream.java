package ge.lanmaster.patterns.partitioning.Filter.stream.impl;

import ge.lanmaster.patterns.partitioning.Filter.stream.InStream;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class reads stream of bytes from a file.
 */
public class FileInStream implements InStream {

    private RandomAccessFile file;

    /**
     * Constructor
     * @param fileName The name of the file to read.
     * @throws IOException
     */
    public FileInStream(String fileName) throws IOException{
        file = new RandomAccessFile(fileName, "r");
    }

    /**
     * Read bytes from a file and fill an array with those
     * bytes.
     */
    @Override
    public int read(byte[] array) throws IOException {
        return file.read(array);
    }

}
