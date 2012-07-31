package ge.lanmaster.patterns.Filter;

import java.io.IOException;

public class TranslateInStream extends FilterInStream {
    private byte[] translationTable;
    private final static int TRANS_TBL_LENGTH = 256;

    /**
     * Constructor
     * @param inStream
     *        The InStreamIF object that this object should
     *        delegate read operations to.
     * @param table
     *        An array of bytes used to determine
     *        translation values for character codes. The
     *        value to replace character code n with is at
     *        index n of the translation table. IF the array
     *        is longer than TRANS_TBL_LENGTH elements, the
     *        additional elements are ignored. If the array
     *        is shorter than TRANS_TBL_LENGTH elements, then
     *        no translation is done on character codes
     *        greater than or equal to the length of the
     *        array.
     * @throws IOException
     */
    public TranslateInStream(InStreamIF inStream,
                             byte[] table) throws IOException {
        super(inStream);
        // Copy translation data to create translation table.
        translationTable = new byte[TRANS_TBL_LENGTH];
        System.arraycopy(table, 0, translationTable, 0,
                Math.min(TRANS_TBL_LENGTH, table.length));

        for(int i = table.length; i<TRANS_TBL_LENGTH; i++)
        {
            translationTable[i]=(byte)i;
        }
    }
    public int read(byte[] array) throws IOException {
        int count;
        count = super.read(array);
        for (int i=0; i<count; i++){
            array[i] = translationTable[array[i]];
        }
        return count;
    }
}
