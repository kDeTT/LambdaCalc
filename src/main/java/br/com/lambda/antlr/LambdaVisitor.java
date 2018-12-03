// Generated from Lambda.g4 by ANTLR 4.7.1
package br.com.lambda.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LambdaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LambdaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code application}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(LambdaParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code abstraction}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstraction(LambdaParser.AbstractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LambdaParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(LambdaParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(LambdaParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(LambdaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(LambdaParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code recursion}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecursion(LambdaParser.RecursionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link LambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(LambdaParser.AdditionContext ctx);
}