// Generated from Cactus.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CactusParser}.
 */
public interface CactusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CactusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CactusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CactusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(CactusParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(CactusParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(CactusParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(CactusParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CactusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CactusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(CactusParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(CactusParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void enterBool_expression(CactusParser.Bool_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void exitBool_expression(CactusParser.Bool_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#bool_expression1}.
	 * @param ctx the parse tree
	 */
	void enterBool_expression1(CactusParser.Bool_expression1Context ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#bool_expression1}.
	 * @param ctx the parse tree
	 */
	void exitBool_expression1(CactusParser.Bool_expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#bool_term}.
	 * @param ctx the parse tree
	 */
	void enterBool_term(CactusParser.Bool_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#bool_term}.
	 * @param ctx the parse tree
	 */
	void exitBool_term(CactusParser.Bool_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#bool_term1}.
	 * @param ctx the parse tree
	 */
	void enterBool_term1(CactusParser.Bool_term1Context ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#bool_term1}.
	 * @param ctx the parse tree
	 */
	void exitBool_term1(CactusParser.Bool_term1Context ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#bool_factor}.
	 * @param ctx the parse tree
	 */
	void enterBool_factor(CactusParser.Bool_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#bool_factor}.
	 * @param ctx the parse tree
	 */
	void exitBool_factor(CactusParser.Bool_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void enterRel_expression(CactusParser.Rel_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void exitRel_expression(CactusParser.Rel_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#relation_op}.
	 * @param ctx the parse tree
	 */
	void enterRelation_op(CactusParser.Relation_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#relation_op}.
	 * @param ctx the parse tree
	 */
	void exitRelation_op(CactusParser.Relation_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#arith_expression}.
	 * @param ctx the parse tree
	 */
	void enterArith_expression(CactusParser.Arith_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#arith_expression}.
	 * @param ctx the parse tree
	 */
	void exitArith_expression(CactusParser.Arith_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#arith_expression1}.
	 * @param ctx the parse tree
	 */
	void enterArith_expression1(CactusParser.Arith_expression1Context ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#arith_expression1}.
	 * @param ctx the parse tree
	 */
	void exitArith_expression1(CactusParser.Arith_expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#arith_term}.
	 * @param ctx the parse tree
	 */
	void enterArith_term(CactusParser.Arith_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#arith_term}.
	 * @param ctx the parse tree
	 */
	void exitArith_term(CactusParser.Arith_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#arith_term1}.
	 * @param ctx the parse tree
	 */
	void enterArith_term1(CactusParser.Arith_term1Context ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#arith_term1}.
	 * @param ctx the parse tree
	 */
	void exitArith_term1(CactusParser.Arith_term1Context ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#arith_factor}.
	 * @param ctx the parse tree
	 */
	void enterArith_factor(CactusParser.Arith_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#arith_factor}.
	 * @param ctx the parse tree
	 */
	void exitArith_factor(CactusParser.Arith_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(CactusParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(CactusParser.Primary_expressionContext ctx);
}