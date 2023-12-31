// Generated from Cactus.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CactusLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, ELSE=2, FI=3, IF=4, INT=5, RETURN=6, WHILE=7, READ=8, WRITE=9, 
		CONST=10, ADD=11, SUB=12, MUL=13, DIV=14, MOD=15, EQ=16, NE=17, GT=18, 
		GE=19, LT=20, LE=21, AND=22, OR=23, NOT=24, ASSIGN=25, LP=26, RP=27, LB=28, 
		RB=29, SEMICOLON=30, ID=31, WHITESPACE=32, COMMENT=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MAIN", "ELSE", "FI", "IF", "INT", "RETURN", "WHILE", "READ", "WRITE", 
			"CONST", "ADD", "SUB", "MUL", "DIV", "MOD", "EQ", "NE", "GT", "GE", "LT", 
			"LE", "AND", "OR", "NOT", "ASSIGN", "LP", "RP", "LB", "RB", "SEMICOLON", 
			"ID", "LETTER", "WHITESPACE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'else'", "'fi'", "'if'", "'int'", "'return'", "'while'", 
			"'read'", "'write'", null, "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", 
			"'!='", "'>'", "'>='", "'<'", "'<='", "'&&'", "'||'", "'!'", "'='", "'('", 
			"')'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "ELSE", "FI", "IF", "INT", "RETURN", "WHILE", "READ", "WRITE", 
			"CONST", "ADD", "SUB", "MUL", "DIV", "MOD", "EQ", "NE", "GT", "GE", "LT", 
			"LE", "AND", "OR", "NOT", "ASSIGN", "LP", "RP", "LB", "RB", "SEMICOLON", 
			"ID", "WHITESPACE", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CactusLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cactus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00c5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13u\n\13"+
		"\r\13\16\13v\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \7 \u00aa\n \f \16 \u00ad\13 \3!"+
		"\3!\3\"\6\"\u00b2\n\"\r\"\16\"\u00b3\3\"\3\"\3#\3#\3#\3#\7#\u00bc\n#\f"+
		"#\16#\u00bf\13#\3#\3#\3#\3#\3#\3\u00bd\2$\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\2C\"E#\3\2\5\3\2\62;"+
		"\5\2C\\aac|\5\2\13\f\17\17\"\"\2\u00c8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2C\3"+
		"\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5L\3\2\2\2\7Q\3\2\2\2\tT\3\2\2\2\13W\3\2"+
		"\2\2\r[\3\2\2\2\17b\3\2\2\2\21h\3\2\2\2\23m\3\2\2\2\25t\3\2\2\2\27x\3"+
		"\2\2\2\31z\3\2\2\2\33|\3\2\2\2\35~\3\2\2\2\37\u0080\3\2\2\2!\u0082\3\2"+
		"\2\2#\u0085\3\2\2\2%\u0088\3\2\2\2\'\u008a\3\2\2\2)\u008d\3\2\2\2+\u008f"+
		"\3\2\2\2-\u0092\3\2\2\2/\u0095\3\2\2\2\61\u0098\3\2\2\2\63\u009a\3\2\2"+
		"\2\65\u009c\3\2\2\2\67\u009e\3\2\2\29\u00a0\3\2\2\2;\u00a2\3\2\2\2=\u00a4"+
		"\3\2\2\2?\u00a6\3\2\2\2A\u00ae\3\2\2\2C\u00b1\3\2\2\2E\u00b7\3\2\2\2G"+
		"H\7o\2\2HI\7c\2\2IJ\7k\2\2JK\7p\2\2K\4\3\2\2\2LM\7g\2\2MN\7n\2\2NO\7u"+
		"\2\2OP\7g\2\2P\6\3\2\2\2QR\7h\2\2RS\7k\2\2S\b\3\2\2\2TU\7k\2\2UV\7h\2"+
		"\2V\n\3\2\2\2WX\7k\2\2XY\7p\2\2YZ\7v\2\2Z\f\3\2\2\2[\\\7t\2\2\\]\7g\2"+
		"\2]^\7v\2\2^_\7w\2\2_`\7t\2\2`a\7p\2\2a\16\3\2\2\2bc\7y\2\2cd\7j\2\2d"+
		"e\7k\2\2ef\7n\2\2fg\7g\2\2g\20\3\2\2\2hi\7t\2\2ij\7g\2\2jk\7c\2\2kl\7"+
		"f\2\2l\22\3\2\2\2mn\7y\2\2no\7t\2\2op\7k\2\2pq\7v\2\2qr\7g\2\2r\24\3\2"+
		"\2\2su\t\2\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\26\3\2\2\2xy\7"+
		"-\2\2y\30\3\2\2\2z{\7/\2\2{\32\3\2\2\2|}\7,\2\2}\34\3\2\2\2~\177\7\61"+
		"\2\2\177\36\3\2\2\2\u0080\u0081\7\'\2\2\u0081 \3\2\2\2\u0082\u0083\7?"+
		"\2\2\u0083\u0084\7?\2\2\u0084\"\3\2\2\2\u0085\u0086\7#\2\2\u0086\u0087"+
		"\7?\2\2\u0087$\3\2\2\2\u0088\u0089\7@\2\2\u0089&\3\2\2\2\u008a\u008b\7"+
		"@\2\2\u008b\u008c\7?\2\2\u008c(\3\2\2\2\u008d\u008e\7>\2\2\u008e*\3\2"+
		"\2\2\u008f\u0090\7>\2\2\u0090\u0091\7?\2\2\u0091,\3\2\2\2\u0092\u0093"+
		"\7(\2\2\u0093\u0094\7(\2\2\u0094.\3\2\2\2\u0095\u0096\7~\2\2\u0096\u0097"+
		"\7~\2\2\u0097\60\3\2\2\2\u0098\u0099\7#\2\2\u0099\62\3\2\2\2\u009a\u009b"+
		"\7?\2\2\u009b\64\3\2\2\2\u009c\u009d\7*\2\2\u009d\66\3\2\2\2\u009e\u009f"+
		"\7+\2\2\u009f8\3\2\2\2\u00a0\u00a1\7}\2\2\u00a1:\3\2\2\2\u00a2\u00a3\7"+
		"\177\2\2\u00a3<\3\2\2\2\u00a4\u00a5\7=\2\2\u00a5>\3\2\2\2\u00a6\u00ab"+
		"\5A!\2\u00a7\u00aa\5A!\2\u00a8\u00aa\4\62;\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac@\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\t\3\2\2\u00afB\3\2"+
		"\2\2\u00b0\u00b2\t\4\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\""+
		"\2\2\u00b6D\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00b9\7,\2\2\u00b9\u00bd"+
		"\3\2\2\2\u00ba\u00bc\13\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2"+
		"\u00bd\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00c0\u00c1\7,\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\b#\2\2\u00c4F\3\2\2\2\b\2v\u00a9\u00ab\u00b3\u00bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}