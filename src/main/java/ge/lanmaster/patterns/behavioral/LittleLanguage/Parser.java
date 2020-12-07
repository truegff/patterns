package ge.lanmaster.patterns.behavioral.LittleLanguage;

import ge.lanmaster.patterns.behavioral.LittleLanguage.combination.AndCombination;
import ge.lanmaster.patterns.behavioral.LittleLanguage.combination.NearCombination;
import ge.lanmaster.patterns.behavioral.LittleLanguage.combination.NotWordCombination;
import ge.lanmaster.patterns.behavioral.LittleLanguage.combination.OrCombination;
import ge.lanmaster.patterns.behavioral.LittleLanguage.combination.WordCombination;

import java.io.InputStream;

public class Parser {

	private LexicalAnalyzer lexer;
	private int token;

	/**
	 * Parse a word combination from the given input stream.
	 *
	 * @param input Read word combinations from this input stream.
	 * @return A combination object that is the root of the
	 * parse tree.
	 * @throws SyntaxException
	 */
	public Combination parse(InputStream input) throws SyntaxException {
		lexer = new LexicalAnalyzer(input);
		Combination c = orCombination();
		expect(LexicalAnalyzer.EOF);
		return c;
	}

	private Combination orCombination() throws SyntaxException {
		Combination c = andCombination();
		while (token == LexicalAnalyzer.OR) {
			c = new OrCombination(c, andCombination());
		}
		return c;
	}

	private Combination andCombination() throws SyntaxException {
		Combination c = nearCombination();
		while (token == LexicalAnalyzer.AND) {
			c = new AndCombination(c, nearCombination());
		}
		return c;
	}

	private Combination nearCombination() throws SyntaxException {
		Combination c = simpleCombination();
		while (token == LexicalAnalyzer.NEAR) {
			c = new NearCombination(c, simpleCombination());
		}
		return c;
	}

	private Combination simpleCombination() throws SyntaxException {
		if (token == LexicalAnalyzer.LEFT_PAREN) {
			nextToken();
			Combination c = orCombination();
			expect(LexicalAnalyzer.RIGHT_PAREN);
			return c;
		}
		if (token == LexicalAnalyzer.NOT) {
			return notWordCombination();
		} else {
			return wordCombination();
		}
	}

	private Combination wordCombination() throws SyntaxException {
		expect(LexicalAnalyzer.WORD);
		if (token != LexicalAnalyzer.WORD && token != LexicalAnalyzer.QUOTED_STRING) {
			// print error message and throw SyntaxException
			expect(LexicalAnalyzer.WORD);
		}

		Combination c;
		c = new WordCombination(lexer.getString());
		nextToken();
		return c;
	}

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
			String msg = "found " + tokenName(token) + " when expecting " + tokenName(t);
			throw new SyntaxException(msg);
		} //if
		nextToken();
	} // expect(int)

	private String tokenName(int t) {
		String tname;
		switch (t) {
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
		}
		return tname;
	}
}