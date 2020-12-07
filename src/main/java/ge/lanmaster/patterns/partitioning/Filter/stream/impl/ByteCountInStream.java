package ge.lanmaster.patterns.partitioning.Filter.stream.impl;

import ge.lanmaster.patterns.partitioning.Filter.stream.FilterInStream;
import ge.lanmaster.patterns.partitioning.Filter.stream.InStream;

import java.io.IOException;

public class ByteCountInStream extends FilterInStream {

	private long byteCount = 0;

	/**
	 * Constructor
	 *
	 * @param inStream The InStreamIf object that this object should
	 *                 delegate read operations to.
	 * @throws java.io.IOException
	 */
	public ByteCountInStream(InStream inStream) throws IOException {
		super(inStream);
	}

	/**
	 * Read bytes from a stream of bytes nto an array.
	 */
	@Override
	public int read(byte[] array) throws IOException {
		int count;
		count = super.read(array);
		if (count > 0) {
			byteCount += count;
		}
		return count;
	}

	/**
	 * @return Return the number of bytes that have been read by
	 * this object.
	 */
	public long getByteCount() {
		return byteCount;
	}

}
