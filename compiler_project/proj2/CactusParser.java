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
		MAIN=1, ELSE=2, FI=3, IF=4, INT=5, RETURN=6, WHILE=7, READ=8, WRITE=9, 
		CONST=10, ADD=11, SUB=12, MUL=13, DIV=14, MOD=15, EQ=16, NE=17, GT=18, 
		GE=19, LT=20, LE=21, AND=22, OR=23, NOT=24, ASSIGN=25, LP=26, RP=27, LB=28, 
		RB=29, SEMICOLON=30, ID=31, WHITESPACE=32, COMMENT=33;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_else_statement = 4, RULE_bool_expression = 5, RULE_bool_expression1 = 6, 
		RULE_bool_term = 7, RULE_bool_term1 = 8, RULE_bool_factor = 9, RULE_rel_expression = 10, 
		RULE_relation_op = 11, RULE_arith_expression = 12, RULE_arith_expression1 = 13, 
		RULE_arith_term = 14, RULE_arith_term1 = 15, RULE_arith_factor = 16, RULE_primary_expression = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declarations", "statements", "statement", "else_statement", 
			"bool_expression", "bool_expression1", "bool_term", "bool_term1", "bool_factor", 
			"rel_expression", "relation_op", "arith_expression", "arith_expression1", 
			"arith_term", "arith_term1", "arith_factor", "primary_expression"
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

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(CactusParser.MAIN, 0); }
		public TerminalNode LP() { return getToken(CactusParser.LP, 0); }
		public TerminalNode RP() { return getToken(CactusParser.RP, 0); }
		public TerminalNode LB() { return getToken(CactusParser.LB, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RB() { return getToken(CactusParser.RB, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(MAIN);
			setState(37);
			match(LP);
			setState(38);
			match(RP);
			setState(39);
			match(LB);
			setState(40);
			declarations();
			setState(41);
			statements();
			setState(42);
			match(RB);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CactusParser.INT, 0); }
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(CactusParser.SEMICOLON, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(INT);
				setState(45);
				match(ID);
				setState(46);
				match(SEMICOLON);
				setState(47);
				declarations();
				}
				break;
			case IF:
			case RETURN:
			case WHILE:
			case READ:
			case WRITE:
			case RB:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case RETURN:
			case WHILE:
			case READ:
			case WRITE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				statement();
				setState(52);
				statements();
				}
				break;
			case RB:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CactusParser.ASSIGN, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CactusParser.SEMICOLON, 0); }
		public TerminalNode IF() { return getToken(CactusParser.IF, 0); }
		public TerminalNode LP() { return getToken(CactusParser.LP, 0); }
		public Bool_expressionContext bool_expression() {
			return getRuleContext(Bool_expressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(CactusParser.RP, 0); }
		public TerminalNode LB() { return getToken(CactusParser.LB, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RB() { return getToken(CactusParser.RB, 0); }
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(CactusParser.WHILE, 0); }
		public TerminalNode READ() { return getToken(CactusParser.READ, 0); }
		public TerminalNode WRITE() { return getToken(CactusParser.WRITE, 0); }
		public TerminalNode RETURN() { return getToken(CactusParser.RETURN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(ID);
				setState(58);
				match(ASSIGN);
				setState(59);
				arith_expression();
				setState(60);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(IF);
				setState(63);
				match(LP);
				setState(64);
				bool_expression();
				setState(65);
				match(RP);
				setState(66);
				match(LB);
				setState(67);
				statements();
				setState(68);
				match(RB);
				setState(69);
				else_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(WHILE);
				setState(72);
				match(LP);
				setState(73);
				bool_expression();
				setState(74);
				match(RP);
				setState(75);
				match(LB);
				setState(76);
				statements();
				setState(77);
				match(RB);
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(READ);
				setState(80);
				match(ID);
				setState(81);
				match(SEMICOLON);
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				match(WRITE);
				setState(83);
				arith_expression();
				setState(84);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				match(RETURN);
				setState(87);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(CactusParser.ELSE, 0); }
		public TerminalNode LB() { return getToken(CactusParser.LB, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RB() { return getToken(CactusParser.RB, 0); }
		public TerminalNode FI() { return getToken(CactusParser.FI, 0); }
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitElse_statement(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_else_statement);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(ELSE);
				setState(91);
				match(LB);
				setState(92);
				statements();
				setState(93);
				match(RB);
				setState(94);
				match(FI);
				}
				break;
			case FI:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(FI);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Bool_expressionContext extends ParserRuleContext {
		public Bool_termContext bool_term() {
			return getRuleContext(Bool_termContext.class,0);
		}
		public Bool_expression1Context bool_expression1() {
			return getRuleContext(Bool_expression1Context.class,0);
		}
		public Bool_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterBool_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitBool_expression(this);
		}
	}

	public final Bool_expressionContext bool_expression() throws RecognitionException {
		Bool_expressionContext _localctx = new Bool_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			bool_term();
			setState(100);
			bool_expression1();
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

	public static class Bool_expression1Context extends ParserRuleContext {
		public TerminalNode OR() { return getToken(CactusParser.OR, 0); }
		public Bool_termContext bool_term() {
			return getRuleContext(Bool_termContext.class,0);
		}
		public Bool_expression1Context bool_expression1() {
			return getRuleContext(Bool_expression1Context.class,0);
		}
		public Bool_expression1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expression1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterBool_expression1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitBool_expression1(this);
		}
	}

	public final Bool_expression1Context bool_expression1() throws RecognitionException {
		Bool_expression1Context _localctx = new Bool_expression1Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_bool_expression1);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OR:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(OR);
				setState(103);
				bool_term();
				setState(104);
				bool_expression1();
				}
				break;
			case RP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Bool_termContext extends ParserRuleContext {
		public Bool_factorContext bool_factor() {
			return getRuleContext(Bool_factorContext.class,0);
		}
		public Bool_term1Context bool_term1() {
			return getRuleContext(Bool_term1Context.class,0);
		}
		public Bool_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterBool_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitBool_term(this);
		}
	}

	public final Bool_termContext bool_term() throws RecognitionException {
		Bool_termContext _localctx = new Bool_termContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bool_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			bool_factor();
			setState(110);
			bool_term1();
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

	public static class Bool_term1Context extends ParserRuleContext {
		public TerminalNode AND() { return getToken(CactusParser.AND, 0); }
		public Bool_factorContext bool_factor() {
			return getRuleContext(Bool_factorContext.class,0);
		}
		public Bool_term1Context bool_term1() {
			return getRuleContext(Bool_term1Context.class,0);
		}
		public Bool_term1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_term1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterBool_term1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitBool_term1(this);
		}
	}

	public final Bool_term1Context bool_term1() throws RecognitionException {
		Bool_term1Context _localctx = new Bool_term1Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_bool_term1);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(AND);
				setState(113);
				bool_factor();
				setState(114);
				bool_term1();
				}
				break;
			case OR:
			case RP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Bool_factorContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(CactusParser.NOT, 0); }
		public Bool_factorContext bool_factor() {
			return getRuleContext(Bool_factorContext.class,0);
		}
		public Rel_expressionContext rel_expression() {
			return getRuleContext(Rel_expressionContext.class,0);
		}
		public Bool_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterBool_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitBool_factor(this);
		}
	}

	public final Bool_factorContext bool_factor() throws RecognitionException {
		Bool_factorContext _localctx = new Bool_factorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bool_factor);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(NOT);
				setState(120);
				bool_factor();
				}
				break;
			case CONST:
			case SUB:
			case LP:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				rel_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Rel_expressionContext extends ParserRuleContext {
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public Relation_opContext relation_op() {
			return getRuleContext(Relation_opContext.class,0);
		}
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterRel_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitRel_expression(this);
		}
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rel_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			arith_expression();
			setState(125);
			relation_op();
			setState(126);
			arith_expression();
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

	public static class Relation_opContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(CactusParser.EQ, 0); }
		public TerminalNode NE() { return getToken(CactusParser.NE, 0); }
		public TerminalNode GT() { return getToken(CactusParser.GT, 0); }
		public TerminalNode GE() { return getToken(CactusParser.GE, 0); }
		public TerminalNode LT() { return getToken(CactusParser.LT, 0); }
		public TerminalNode LE() { return getToken(CactusParser.LE, 0); }
		public Relation_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterRelation_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitRelation_op(this);
		}
	}

	public final Relation_opContext relation_op() throws RecognitionException {
		Relation_opContext _localctx = new Relation_opContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_relation_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NE) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Arith_expressionContext extends ParserRuleContext {
		public Arith_termContext arith_term() {
			return getRuleContext(Arith_termContext.class,0);
		}
		public Arith_expression1Context arith_expression1() {
			return getRuleContext(Arith_expression1Context.class,0);
		}
		public Arith_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterArith_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitArith_expression(this);
		}
	}

	public final Arith_expressionContext arith_expression() throws RecognitionException {
		Arith_expressionContext _localctx = new Arith_expressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arith_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			arith_term();
			setState(131);
			arith_expression1();
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

	public static class Arith_expression1Context extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(CactusParser.ADD, 0); }
		public Arith_termContext arith_term() {
			return getRuleContext(Arith_termContext.class,0);
		}
		public Arith_expression1Context arith_expression1() {
			return getRuleContext(Arith_expression1Context.class,0);
		}
		public TerminalNode SUB() { return getToken(CactusParser.SUB, 0); }
		public Arith_expression1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expression1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterArith_expression1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitArith_expression1(this);
		}
	}

	public final Arith_expression1Context arith_expression1() throws RecognitionException {
		Arith_expression1Context _localctx = new Arith_expression1Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_arith_expression1);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(ADD);
				setState(134);
				arith_term();
				setState(135);
				arith_expression1();
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(SUB);
				setState(138);
				arith_term();
				setState(139);
				arith_expression1();
				}
				break;
			case EQ:
			case NE:
			case GT:
			case GE:
			case LT:
			case LE:
			case AND:
			case OR:
			case RP:
			case SEMICOLON:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Arith_termContext extends ParserRuleContext {
		public Arith_factorContext arith_factor() {
			return getRuleContext(Arith_factorContext.class,0);
		}
		public Arith_term1Context arith_term1() {
			return getRuleContext(Arith_term1Context.class,0);
		}
		public Arith_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterArith_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitArith_term(this);
		}
	}

	public final Arith_termContext arith_term() throws RecognitionException {
		Arith_termContext _localctx = new Arith_termContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arith_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			arith_factor();
			setState(145);
			arith_term1();
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

	public static class Arith_term1Context extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(CactusParser.MUL, 0); }
		public Arith_factorContext arith_factor() {
			return getRuleContext(Arith_factorContext.class,0);
		}
		public Arith_term1Context arith_term1() {
			return getRuleContext(Arith_term1Context.class,0);
		}
		public TerminalNode DIV() { return getToken(CactusParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(CactusParser.MOD, 0); }
		public Arith_term1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_term1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterArith_term1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitArith_term1(this);
		}
	}

	public final Arith_term1Context arith_term1() throws RecognitionException {
		Arith_term1Context _localctx = new Arith_term1Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_arith_term1);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(MUL);
				setState(148);
				arith_factor();
				setState(149);
				arith_term1();
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(DIV);
				setState(152);
				arith_factor();
				setState(153);
				arith_term1();
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				match(MOD);
				setState(156);
				arith_factor();
				setState(157);
				arith_term1();
				}
				break;
			case ADD:
			case SUB:
			case EQ:
			case NE:
			case GT:
			case GE:
			case LT:
			case LE:
			case AND:
			case OR:
			case RP:
			case SEMICOLON:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Arith_factorContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(CactusParser.SUB, 0); }
		public Arith_factorContext arith_factor() {
			return getRuleContext(Arith_factorContext.class,0);
		}
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public Arith_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterArith_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitArith_factor(this);
		}
	}

	public final Arith_factorContext arith_factor() throws RecognitionException {
		Arith_factorContext _localctx = new Arith_factorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arith_factor);
		try {
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(SUB);
				setState(163);
				arith_factor();
				}
				break;
			case CONST:
			case LP:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				primary_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Primary_expressionContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(CactusParser.CONST, 0); }
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public TerminalNode LP() { return getToken(CactusParser.LP, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(CactusParser.RP, 0); }
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primary_expression);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(CONST);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(ID);
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(LP);
				setState(170);
				arith_expression();
				setState(171);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\64"+
		"\n\3\3\4\3\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5[\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6d\n\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\nx\n"+
		"\n\3\13\3\13\3\13\5\13}\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0091\n\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00a3\n\21\3\22\3\22\3\22\5\22\u00a8\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00b0\n\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$\2\3\3\2\22\27\2\u00b2\2&\3\2\2\2\4\63\3\2\2\2\69\3\2\2\2\b"+
		"Z\3\2\2\2\nc\3\2\2\2\fe\3\2\2\2\16m\3\2\2\2\20o\3\2\2\2\22w\3\2\2\2\24"+
		"|\3\2\2\2\26~\3\2\2\2\30\u0082\3\2\2\2\32\u0084\3\2\2\2\34\u0090\3\2\2"+
		"\2\36\u0092\3\2\2\2 \u00a2\3\2\2\2\"\u00a7\3\2\2\2$\u00af\3\2\2\2&\'\7"+
		"\3\2\2\'(\7\34\2\2()\7\35\2\2)*\7\36\2\2*+\5\4\3\2+,\5\6\4\2,-\7\37\2"+
		"\2-\3\3\2\2\2./\7\7\2\2/\60\7!\2\2\60\61\7 \2\2\61\64\5\4\3\2\62\64\3"+
		"\2\2\2\63.\3\2\2\2\63\62\3\2\2\2\64\5\3\2\2\2\65\66\5\b\5\2\66\67\5\6"+
		"\4\2\67:\3\2\2\28:\3\2\2\29\65\3\2\2\298\3\2\2\2:\7\3\2\2\2;<\7!\2\2<"+
		"=\7\33\2\2=>\5\32\16\2>?\7 \2\2?[\3\2\2\2@A\7\6\2\2AB\7\34\2\2BC\5\f\7"+
		"\2CD\7\35\2\2DE\7\36\2\2EF\5\6\4\2FG\7\37\2\2GH\5\n\6\2H[\3\2\2\2IJ\7"+
		"\t\2\2JK\7\34\2\2KL\5\f\7\2LM\7\35\2\2MN\7\36\2\2NO\5\6\4\2OP\7\37\2\2"+
		"P[\3\2\2\2QR\7\n\2\2RS\7!\2\2S[\7 \2\2TU\7\13\2\2UV\5\32\16\2VW\7 \2\2"+
		"W[\3\2\2\2XY\7\b\2\2Y[\7 \2\2Z;\3\2\2\2Z@\3\2\2\2ZI\3\2\2\2ZQ\3\2\2\2"+
		"ZT\3\2\2\2ZX\3\2\2\2[\t\3\2\2\2\\]\7\4\2\2]^\7\36\2\2^_\5\6\4\2_`\7\37"+
		"\2\2`a\7\5\2\2ad\3\2\2\2bd\7\5\2\2c\\\3\2\2\2cb\3\2\2\2d\13\3\2\2\2ef"+
		"\5\20\t\2fg\5\16\b\2g\r\3\2\2\2hi\7\31\2\2ij\5\20\t\2jk\5\16\b\2kn\3\2"+
		"\2\2ln\3\2\2\2mh\3\2\2\2ml\3\2\2\2n\17\3\2\2\2op\5\24\13\2pq\5\22\n\2"+
		"q\21\3\2\2\2rs\7\30\2\2st\5\24\13\2tu\5\22\n\2ux\3\2\2\2vx\3\2\2\2wr\3"+
		"\2\2\2wv\3\2\2\2x\23\3\2\2\2yz\7\32\2\2z}\5\24\13\2{}\5\26\f\2|y\3\2\2"+
		"\2|{\3\2\2\2}\25\3\2\2\2~\177\5\32\16\2\177\u0080\5\30\r\2\u0080\u0081"+
		"\5\32\16\2\u0081\27\3\2\2\2\u0082\u0083\t\2\2\2\u0083\31\3\2\2\2\u0084"+
		"\u0085\5\36\20\2\u0085\u0086\5\34\17\2\u0086\33\3\2\2\2\u0087\u0088\7"+
		"\r\2\2\u0088\u0089\5\36\20\2\u0089\u008a\5\34\17\2\u008a\u0091\3\2\2\2"+
		"\u008b\u008c\7\16\2\2\u008c\u008d\5\36\20\2\u008d\u008e\5\34\17\2\u008e"+
		"\u0091\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0087\3\2\2\2\u0090\u008b\3\2"+
		"\2\2\u0090\u008f\3\2\2\2\u0091\35\3\2\2\2\u0092\u0093\5\"\22\2\u0093\u0094"+
		"\5 \21\2\u0094\37\3\2\2\2\u0095\u0096\7\17\2\2\u0096\u0097\5\"\22\2\u0097"+
		"\u0098\5 \21\2\u0098\u00a3\3\2\2\2\u0099\u009a\7\20\2\2\u009a\u009b\5"+
		"\"\22\2\u009b\u009c\5 \21\2\u009c\u00a3\3\2\2\2\u009d\u009e\7\21\2\2\u009e"+
		"\u009f\5\"\22\2\u009f\u00a0\5 \21\2\u00a0\u00a3\3\2\2\2\u00a1\u00a3\3"+
		"\2\2\2\u00a2\u0095\3\2\2\2\u00a2\u0099\3\2\2\2\u00a2\u009d\3\2\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3!\3\2\2\2\u00a4\u00a5\7\16\2\2\u00a5\u00a8\5\"\22"+
		"\2\u00a6\u00a8\5$\23\2\u00a7\u00a4\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8#"+
		"\3\2\2\2\u00a9\u00b0\7\f\2\2\u00aa\u00b0\7!\2\2\u00ab\u00ac\7\34\2\2\u00ac"+
		"\u00ad\5\32\16\2\u00ad\u00ae\7\35\2\2\u00ae\u00b0\3\2\2\2\u00af\u00a9"+
		"\3\2\2\2\u00af\u00aa\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0%\3\2\2\2\r\639"+
		"Zcmw|\u0090\u00a2\u00a7\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}