package ge.lanmaster.patterns.Filter;

import java.io.IOException;

public interface InStreamIF {
    /**
     * Read bytes and fill an array with those bytes.
     * @param array The array of bytes to fill.
     * @return  If not enough bytes are available to fill the
     *          array then this method returns after having
     *          only put that many bytes in the array. This
     *          method returns -1 if the end of the data
     *          stream is encountered.
     * @throws IOException  if an I/O error occurs.
     */
    public int read(byte[] array) throws IOException;
}
