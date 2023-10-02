// Generated from Cactus.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CactusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ELSE=1, ID=2, FI=3, IF=4, INT=5, MAIN=6, RETURN=7, WHILE=8, READ=9, WRITE=10, 
		CONST=11, ADD=12, SUB=13, MUL=14, DIV=15, MOD=16, EQ=17, NE=18, GT=19, 
		GE=20, LT=21, LE=22, AND=23, OR=24, NOT=25, ASSIGN=26, LPARENTHESE=27, 
		RPARENTHESE=28, LCURLYBRACKET=29, RCURLYBRACKET=30, SEMICOLON=31, WHITESPACE=32, 
		COMMENT=33;
	public static final int
		RULE_token = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"token"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'else'", null, "'fi'", "'if'", "'int'", "'main'", "'return'", 
			"'while'", "'read'", "'write'", null, "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'&&'", "'||'", "'!'", 
			"'='", "'('", "')'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ELSE", "ID", "FI", "IF", "INT", "MAIN", "RETURN", "WHILE", "READ", 
			"WRITE", "CONST", "ADD", "SUB", "MUL", "DIV", "MOD", "EQ", "NE", "GT", 
			"GE", "LT", "LE", "AND", "OR", "NOT", "ASSIGN", "LPARENTHESE", "RPARENTHESE", 
			"LCURLYBRACKET", "RCURLYBRACKET", "SEMICOLON", "WHITESPACE", "COMMENT"
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

	@Override
	public String getGrammarFileName() { return "Cactus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CactusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TokenContext extends ParserRuleContext {
		public List<TerminalNode> ELSE() { return getTokens(CactusParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(CactusParser.ELSE, i);
		}
		public List<TerminalNode> ID() { return getTokens(CactusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CactusParser.ID, i);
		}
		public List<TerminalNode> IF() { return getTokens(CactusParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(CactusParser.IF, i);
		}
		public List<TerminalNode> FI() { return getTokens(CactusParser.FI); }
		public TerminalNode FI(int i) {
			return getToken(CactusParser.FI, i);
		}
		public List<TerminalNode> INT() { return getTokens(CactusParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CactusParser.INT, i);
		}
		public List<TerminalNode> MAIN() { return getTokens(CactusParser.MAIN); }
		public TerminalNode MAIN(int i) {
			return getToken(CactusParser.MAIN, i);
		}
		public List<TerminalNode> RETURN() { return getTokens(CactusParser.RETURN); }
		public TerminalNode RETURN(int i) {
			return getToken(CactusParser.RETURN, i);
		}
		public List<TerminalNode> WHILE() { return getTokens(CactusParser.WHILE); }
		public TerminalNode WHILE(int i) {
			return getToken(CactusParser.WHILE, i);
		}
		public List<TerminalNode> READ() { return getTokens(CactusParser.READ); }
		public TerminalNode READ(int i) {
			return getToken(CactusParser.READ, i);
		}
		public List<TerminalNode> WRITE() { return getTokens(CactusParser.WRITE); }
		public TerminalNode WRITE(int i) {
			return getToken(CactusParser.WRITE, i);
		}
		public List<TerminalNode> CONST() { return getTokens(CactusParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(CactusParser.CONST, i);
		}
		public List<TerminalNode> ADD() { return getTokens(CactusParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(CactusParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(CactusParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(CactusParser.SUB, i);
		}
		public List<TerminalNode> MUL() { return getTokens(CactusParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(CactusParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(CactusParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(CactusParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(CactusParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(CactusParser.MOD, i);
		}
		public List<TerminalNode> EQ() { return getTokens(CactusParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(CactusParser.EQ, i);
		}
		public List<TerminalNode> NE() { return getTokens(CactusParser.NE); }
		public TerminalNode NE(int i) {
			return getToken(CactusParser.NE, i);
		}
		public List<TerminalNode> GT() { return getTokens(CactusParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(CactusParser.GT, i);
		}
		public List<TerminalNode> GE() { return getTokens(CactusParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(CactusParser.GE, i);
		}
		public List<TerminalNode> LT() { return getTokens(CactusParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(CactusParser.LT, i);
		}
		public List<TerminalNode> LE() { return getTokens(CactusParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(CactusParser.LE, i);
		}
		public List<TerminalNode> AND() { return getTokens(CactusParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CactusParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(CactusParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CactusParser.OR, i);
		}
		public List<TerminalNode> NOT() { return getTokens(CactusParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(CactusParser.NOT, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(CactusParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(CactusParser.ASSIGN, i);
		}
		public List<TerminalNode> LPARENTHESE() { return getTokens(CactusParser.LPARENTHESE); }
		public TerminalNode LPARENTHESE(int i) {
			return getToken(CactusParser.LPARENTHESE, i);
		}
		public List<TerminalNode> RPARENTHESE() { return getTokens(CactusParser.RPARENTHESE); }
		public TerminalNode RPARENTHESE(int i) {
			return getToken(CactusParser.RPARENTHESE, i);
		}
		public List<TerminalNode> LCURLYBRACKET() { return getTokens(CactusParser.LCURLYBRACKET); }
		public TerminalNode LCURLYBRACKET(int i) {
			return getToken(CactusParser.LCURLYBRACKET, i);
		}
		public List<TerminalNode> RCURLYBRACKET() { return getTokens(CactusParser.RCURLYBRACKET); }
		public TerminalNode RCURLYBRACKET(int i) {
			return getToken(CactusParser.RCURLYBRACKET, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CactusParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CactusParser.SEMICOLON, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CactusParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CactusParser.WHITESPACE, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(CactusParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(CactusParser.COMMENT, i);
		}
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitToken(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(5);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ELSE) | (1L << ID) | (1L << FI) | (1L << IF) | (1L << INT) | (1L << MAIN) | (1L << RETURN) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << CONST) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << EQ) | (1L << NE) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << ASSIGN) | (1L << LPARENTHESE) | (1L << RPARENTHESE) | (1L << LCURLYBRACKET) | (1L << RCURLYBRACKET) | (1L << SEMICOLON) | (1L << WHITESPACE) | (1L << COMMENT))) != 0)) {
				{
				{
				setState(2);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ELSE) | (1L << ID) | (1L << FI) | (1L << IF) | (1L << INT) | (1L << MAIN) | (1L << RETURN) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << CONST) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << EQ) | (1L << NE) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << ASSIGN) | (1L << LPARENTHESE) | (1L << RPARENTHESE) | (1L << LCURLYBRACKET) | (1L << RCURLYBRACKET) | (1L << SEMICOLON) | (1L << WHITESPACE) | (1L << COMMENT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(7);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\13\4\2\t\2\3\2\7"+
		"\2\6\n\2\f\2\16\2\t\13\2\3\2\2\2\3\2\2\3\3\2\3#\2\n\2\7\3\2\2\2\4\6\t"+
		"\2\2\2\5\4\3\2\2\2\6\t\3\2\2\2\7\5\3\2\2\2\7\b\3\2\2\2\b\3\3\2\2\2\t\7"+
		"\3\2\2\2\3\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}