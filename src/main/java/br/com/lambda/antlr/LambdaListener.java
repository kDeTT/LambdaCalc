// Generated from Lambda.g4 by ANTLR 4.7.1
package br.com.lambda.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LambdaParser}.
 */
public interface LambdaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code application}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterApplication(LambdaParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code application}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitApplication(LambdaParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code abstraction}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(LambdaParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code abstraction}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(LambdaParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LambdaParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LambdaParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(LambdaParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(LambdaParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integer}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInteger(LambdaParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInteger(LambdaParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LambdaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LambdaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(LambdaParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(LambdaParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code recursion}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRecursion(LambdaParser.RecursionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code recursion}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRecursion(LambdaParser.RecursionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addition}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddition(LambdaParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddition(LambdaParser.AdditionContext ctx);
}