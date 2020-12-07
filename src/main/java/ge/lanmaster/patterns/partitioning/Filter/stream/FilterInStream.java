package ge.lanmaster.patterns.partitioning.Filter.stream;

import java.io.IOException;

public abstract class FilterInStream implements InStream {

	private final InStream inStream;

	/**
	 * Constructor
	 *
	 * @param inStream The InStreamIf object that this object should
	 *                 delegate read operations to.
	 * @throws IOException
	 */
	public FilterInStream(InStream inStream) {
		this.inStream = inStream;
	}

	/**
	 * Read bytes from a stream of bytes and fill an array
	 * with those bytes.
	 */
	@Override
	public int read(byte[] array) throws IOException {
		return inStream.read(array);
	}

}
