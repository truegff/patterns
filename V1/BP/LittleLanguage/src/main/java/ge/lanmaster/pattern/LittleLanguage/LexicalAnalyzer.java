package  ge.lanmaster.pattern.LittleLanguage;

import java.io.InputStream;
import java.io.StreamTokenizer;

/**
 * @author alexander
 */
public class LexicalAnalyzer {
    private StreamTokenizer input;
    private int lastToken;

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

    /**
     * Constructor
     * @param input The input stream to read.
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
    } // constructor(InputStream)

}
