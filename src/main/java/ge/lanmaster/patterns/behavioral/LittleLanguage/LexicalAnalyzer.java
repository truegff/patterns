package ge.lanmaster.patterns.behavioral.LittleLanguage;

import java.io.InputStream;
import java.io.StreamTokenizer;

public class LexicalAnalyzer {

	// constants to identify the type of the last token.
	static final int INVALID_CHAR = -1; // unexpected character.
	static final int NO_TOKEN = 0; // No tokens recognized yet.
	static final int OR = 1;
	static final int AND = 2;
	static final int NEAR = 3;
	static final int NOT = 4;
	static final int WORD = 5;
	static final int LEFT_PAREN = 6;
	static final int RIGHT_PAREN = 7;
	static final int QUOTED_STRING = 8;
	static final int EOF = 9;

	private StreamTokenizer input;
	private int lastToken;

	/**
	 * Constructor
	 *
	 * @param in The input stream to read.
	 */
	public LexicalAnalyzer(InputStream in) {
		input = new StreamTokenizer(in);
		input.resetSyntax();
		input.eolIsSignificant(false);
		input.wordChars('a', 'z');
		input.wordChars('A', 'Z');
		input.wordChars('0', '9');
		input.wordChars('\u0000', ' ');
		input.ordinaryChar('(');
		input.ordinaryChar(')');
		input.quoteChar('"');
	}

	public String getString() {
		throw new UnsupportedOperationException();
	}

	public int nextToken() {
		throw new UnsupportedOperationException();
	}
}
