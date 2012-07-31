package ge.lanmaster.pattern.LittleLanguage;

import java.io.InputStream;

/**
 * @author alexander
 */
public class Parser {

    private LexicalAnalyzer lexer; // lexical analyzer
    private int token;

    /**
     * Parse a word combination from the given input stream.
     * @param input
     *  Read word combinations from this input stream.
     * @return A combination object that is the root of the
     *  parse tree.
     * @throws SyntaxException
     */
    public Combination parse(InputStream input) throws SyntaxException {
        lexer = new LexicalAnalyzer(input);
        Combination c = orCombination();
        expect(LexicalAnalyzer.EOF);
        return c;
    } // pacrse(InputStream)

    private Combination orCombination() throws SyntaxException {
        Combination c = andCombination();
        while (token == LexicalAnalyzer.OR) {
            c = new OrCombination(c, andCombination());
        } // while
        return c;
    } // orCombination()

    private Combination andCombination() throws SyntaxException {
        Combination c = nearCombination();
        while (token == LexicalAnalyzer.AND) {
            c = new AndCombination(c, nearCombination());
        } // while
        return c;
    } // andCombination()

    private Combination nearCombination() throws SyntaxException {
        Combination c = simpleCombination();
        while (token == LexicalAnalyzer.NEAR) {
            c = new NearCombination(c, simpleCombination());
        } // while
        return c;
    } // nearCombination()

    private Combination simpleCombination() throws SyntaxException {
        if (token == LexicalAnalyzer.LEFT_PAREN) {
            nextToken();
            Combination c = orCombination();
            expect(LexicalAnalyzer.RIGHT_PAREN);
            return c;
        } // if '('
        if (token == LexicalAnalyzer.NOT)
            return notWordCombination();
        else
            return wordCombination();
    } // simpleCombination()

    private Combination notWordCombination() throws SyntaxException {
        expect(LexicalAnalyzer.NOT);
        if (token != LexicalAnalyzer.WORD && token != LexicalAnalyzer.QUOTED_STRING) {
            // print error message and throw SyntaxException
            expect(LexicalAnalyzer.WORD);
        } // if
        Combination c;
        c = new NotWordCombination(lexer.getString());
        nextToken();
        return c;
    } // notWordCombination()

    // Get the next token from the lexer
    private void nextToken() {
        token = lexer.nextToken();
    } // nextToken()

    private void expect(int t) throws SyntaxException {
        if (token != t) {
            String msg = "found " + tokenName(token)
                    + " when expecting " + tokenName(t);
            throw new SyntaxException(msg);
        } //if
        nextToken();
    } // expect(int)

    private String tokenName(int t) {
        String tname;
        switch(t) {
            case LexicalAnalyzer.OR:
                tname = "OR";
                break;
            case LexicalAnalyzer.AND:
                tname = "AND";
                break;
            case LexicalAnalyzer.NEAR:
                tname = "NEAR";
                break;
            case LexicalAnalyzer.NOT:
                tname = "NOT";
                break;
            case LexicalAnalyzer.WORD:
                tname = "word";
                break;
            case LexicalAnalyzer.LEFT_PAREN:
                tname = "(";
                break;
            case LexicalAnalyzer.RIGHT_PAREN:
                tname = ")";
                break;
            case LexicalAnalyzer.QUOTED_STRING:
                tname = "quoted string";
                break;
            case LexicalAnalyzer.EOF:
                tname = "end of file";
                break;
            default:
                tname = "???";
                break;
        } // switch
        return tname;
    } // tokenName(int)
} // class Parser
