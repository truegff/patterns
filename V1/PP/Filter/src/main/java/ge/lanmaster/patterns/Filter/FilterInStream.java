package ge.lanmaster.patterns.Filter;

import java.io.IOException;

public abstract class FilterInStream implements InStreamIF{
    private InStreamIF inStream;

    /**
     * Constructor
     * @param inStream The InStreamIf object that this object should
     *                 delegate read operations to.
     * @throws IOException
     */
    public FilterInStream(InStreamIF inStream)  throws IOException{
        this.inStream = inStream;
    }

    /**
     * Read bytes from a stream of bytes and fill an array
     * with those bytes.
     */
    public int read(byte[] array) throws IOException {
        return inStream.read(array);
    }
}
