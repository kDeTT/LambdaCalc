package br.com.lambda.interpreter;

import br.com.lambda.antlr.LambdaBaseVisitor;
import br.com.lambda.antlr.LambdaParser;
import br.com.lambda.interpreter.types.Abstraction;
import br.com.lambda.interpreter.types.Application;
import br.com.lambda.interpreter.types.Calculus;
import br.com.lambda.interpreter.types.IfStatement;
import br.com.lambda.interpreter.types.RecursiveFunction;
import br.com.lambda.interpreter.types.Value;
import br.com.lambda.interpreter.types.Variable;

/**
 *
 * @author ltosc
 */
public class LambdaSimpleVisitor extends LambdaBaseVisitor<Value>
{
    @Override
    public Value visitParenExpression(LambdaParser.ParenExpressionContext ctx) 
    {
        return this.visit(ctx.expression());
    }
    
    @Override
    public Value visitInteger(LambdaParser.IntegerContext ctx)
    {
        return new Value(Integer.valueOf(ctx.getText()));
    }
    
    @Override
    public Value visitAddition(LambdaParser.AdditionContext ctx)
    {
        Value left = this.visit(ctx.expression(0));
        Value right = this.visit(ctx.expression(1));
        
        switch (ctx.op.getType())
        {
            case LambdaParser.PLUS:
            {
                if (left.isInteger() && right.isInteger())
                {
                    return new Value(left.toInteger() + right.toInteger());
                }
                else
                {
                    return new Value(new Calculus(new Value(left), new Value(right), '+'));
                }
            }
            case LambdaParser.MINUS:
            {
                if (left.isInteger() && right.isInteger())
                {
                    return new Value(left.toInteger() - right.toInteger());
                }
                else
                {
                    return new Value(new Calculus(new Value(left), new Value(right), '-'));
                }
            }
            default:
                throw new RuntimeException(String.format("Operador inválido para a expressão: %s", ctx.expression().toString()));
        }
    }
    
    @Override
    public Value visitMultiplication(LambdaParser.MultiplicationContext ctx)
    {
        Value left = this.visit(ctx.expression(0));
        Value right = this.visit(ctx.expression(1));
        
        switch (ctx.op.getType())
        {
            case LambdaParser.MULT:
            {
                if (left.isInteger() && right.isInteger())
                {
                    return new Value(left.toInteger() * right.toInteger());
                }
                else
                {
                    return new Value(new Calculus(new Value(left), new Value(right), '*'));
                }
            }
            case LambdaParser.DIV:
            {
                if (left.isInteger() && right.isInteger())
                {
                    return new Value(left.toInteger() / right.toInteger());
                }
                else
                {
                    return new Value(new Calculus(new Value(left), new Value(right), '/'));
                }
            }
            default:
                throw new RuntimeException(String.format("Operador inválido para a expressão: %s", ctx.expression().toString()));
        }
    }
    
    @Override
    public Value visitVariable(LambdaParser.VariableContext ctx)
    {
        return new Value(new Variable(ctx.getText()));
    }
    
    @Override
    public Value visitAbstraction(LambdaParser.AbstractionContext ctx)
    {
        String lambdaVar = ctx.VAR().getText();
        Value expression = this.visit(ctx.expression());
        
        if(ctx.parent instanceof LambdaParser.ParenExpressionContext)
        {
            return new Value(new Abstraction(lambdaVar, expression, false));
        }
        else
        {
            return new Value(new Abstraction(lambdaVar, expression, true));
        }
    }
    
    @Override
    public Value visitApplication(LambdaParser.ApplicationContext ctx)
    {
        Value left = this.visit(ctx.expression(0));
        Value right = this.visit(ctx.expression(1));
        
        if(ctx.parent instanceof LambdaParser.ParenExpressionContext)
        {
            return new Value(new Application(left, right, true));
        }
        else
        {
            return new Value(new Application(left, right, false));
        }
    }
    
    @Override
    public Value visitIfStatement(LambdaParser.IfStatementContext ctx)
    {
        Value left = this.visit(ctx.expression(0));
        Value right = this.visit(ctx.expression(1));
        
        if(!(left.isInteger() && right.isInteger()))
        {
            return new Value(new IfStatement(left, right, visit(ctx.expression(2)), visit(ctx.expression(3)), ctx.op.getText()));
        }
        else
        {
            int leftInt = left.toInteger();
            int rightInt = right.toInteger();
            
            switch(ctx.op.getType())
            {
                case LambdaParser.EQ:
                {
                    if(leftInt == rightInt)
                    {
                        Value trueReturn = this.visit(ctx.expression(2));
                        return new Value(trueReturn.getValue());
                    }
                    else
                    {
                        Value falseReturn = this.visit(ctx.expression(3));
                        return new Value(falseReturn.getValue());
                    }
                }
                case LambdaParser.GT:
                {
                    if(leftInt > rightInt)
                    {
                        Value trueReturn = this.visit(ctx.expression(2));
                        return new Value(trueReturn.getValue());
                    }
                    else
                    {
                        Value falseReturn = this.visit(ctx.expression(3));
                        return new Value(falseReturn.getValue());
                    }
                }
                case LambdaParser.LT:
                {
                    if(leftInt < rightInt)
                    {
                        Value trueReturn = this.visit(ctx.expression(2));
                        return new Value(trueReturn.getValue());
                    }
                    else
                    {
                        Value falseReturn = this.visit(ctx.expression(3));
                        return new Value(falseReturn.getValue());
                    }
                }
                case LambdaParser.GTEQ:
                {
                    if(leftInt >= rightInt)
                    {
                        Value trueReturn = this.visit(ctx.expression(2));
                        return new Value(trueReturn.getValue());
                    }
                    else
                    {
                        Value falseReturn = this.visit(ctx.expression(3));
                        return new Value(falseReturn.getValue());
                    }
                }
                case LambdaParser.LTEQ:
                {
                    if(leftInt <= rightInt)
                    {
                        Value trueReturn = this.visit(ctx.expression(2));
                        return new Value(trueReturn.getValue());
                    }
                    else
                    {
                        Value falseReturn = this.visit(ctx.expression(3));
                        return new Value(falseReturn.getValue());
                    }
                }
                case LambdaParser.NEQ:
                {
                    if(leftInt != rightInt)
                    {
                        Value trueReturn = this.visit(ctx.expression(2));
                        return new Value(trueReturn.getValue());
                    }
                    else
                    {
                        Value falseReturn = this.visit(ctx.expression(3));
                        return new Value(falseReturn.getValue());
                    }
                }
                default:
                    throw new RuntimeException(String.format("Operador inválido para a expressão: %s", ctx.expression().toString()));
            }
        }
    }
    
    @Override
    public Value visitRecursion(LambdaParser.RecursionContext ctx)
    {
        String functionName = ctx.VAR(0).getText();
        String application = ctx.VAR(1).getText();
        Value function = this.visit(ctx.expression());
        
        return new Value(new RecursiveFunction(new Variable(functionName), new Variable(application), function));
    }
}