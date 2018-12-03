package br.com.lambda.interpreter;

import br.com.lambda.antlr.LambdaParser;
import br.com.lambda.interpreter.types.Abstraction;
import br.com.lambda.interpreter.types.Application;
import br.com.lambda.interpreter.types.IfStatement;
import br.com.lambda.interpreter.types.RecursiveFunction;
import br.com.lambda.interpreter.types.Value;
import br.com.lambda.interpreter.types.Variable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.antlr.v4.runtime.RuleContext;

/**
 *
 * @author ltosc
 */
public class ReduceVisitor extends LambdaSimpleVisitor
{
    private final Map<String, String> replaceMap;
    private final Set<String> freeVariables;
    
    public ReduceVisitor(Set<String> freeVariables)
    {
        this.replaceMap = new HashMap<>();
        this.freeVariables = freeVariables;
    }
    
    private boolean underAbstraction(RuleContext ctx)
    {
        RuleContext parent = ctx.parent;
        
        if(parent == null)
        {
            return false;
        }
        
        while(parent.getParent() != null)
        {
            if(parent instanceof LambdaParser.AbstractionContext)
            {
                return true;
            }
            
            parent = parent.getParent();
        }
        
        return false;
    }
    
    @Override
    public Value visitParenExpression(LambdaParser.ParenExpressionContext ctx)
    {
        replaceMap.clear();
        return super.visitParenExpression(ctx);
    }
    
    @Override
    public Value visitVariable(LambdaParser.VariableContext ctx)
    {
        String var = ctx.getText();
        
        if(underAbstraction(ctx))
        {
            if(replaceMap.containsKey(var))
            {
                var = replaceMap.get(var);
            }
            
            return new Value(new Variable(var));
        }
        else
        {
            return super.visitVariable(ctx);
        }
    }
    
    @Override
    public Value visitAbstraction(LambdaParser.AbstractionContext ctx)
    {
        String var = ctx.VAR().getText();
        
        if(freeVariables.contains(var))
        {
            String newVar = var;
            
            for(int i = 0; freeVariables.contains(newVar); i++)
            {
                newVar = var + i;
            }
            
            replaceMap.put(var, newVar);
            var = newVar;
        }
        
        Value expression = this.visit(ctx.expression());
        
        if(ctx.parent instanceof LambdaParser.ParenExpressionContext)
        {
            return new Value(new Abstraction(var, expression, false));
        }
        else
        {
            return new Value(new Abstraction(var, expression, true));
        }
    }
    
    @Override
    public Value visitApplication(LambdaParser.ApplicationContext ctx)
    {
        Value left = this.visit(ctx.expression(0));
        Value right = this.visit(ctx.expression(1));
        
        if(left.isRecursiveFunction())
        {
            RecursiveFunction recFunc = left.toRecursiveFunction();
            IfStatement ifStat = recFunc.getFunction().toIfStatement();
            
            String newRight = ifStat.getRightToEq().toString().replaceAll("\\b" + recFunc.getApplication().getId() + "\\b", right.toString());
            String newLeft = ifStat.getLeftToEq().toString().replaceAll("\\b" + recFunc.getApplication().getId() + "\\b", right.toString());
            
            String replaceThen = ifStat.getThenReturn().toString().replaceAll("\\b" + recFunc.getApplication().getId() + "\\b", right.toString());
            replaceThen = replaceThen.replaceAll("\\b" + recFunc.getFunctionName().getId() + "\\b", recFunc.toString());

            String replaceElse = ifStat.getElseReturn().toString().replaceAll("\\b" + recFunc.getApplication().getId() + "\\b", right.toString());
            replaceElse = replaceElse.replaceAll("\\b" + recFunc.getFunctionName().getId() + "\\b", recFunc.toString());
            
            IfStatement ifChanged = new IfStatement(new Value(newLeft), new Value(newRight), new Value(replaceThen), new Value(replaceElse), ifStat.getOperator());
            return new Value(ifChanged);
        }
        
        if(!left.isAbstraction())
        {
            if(ctx.parent instanceof LambdaParser.ParenExpressionContext)
            {
                return new Value(new Application(left, right, true));
            }
            else
            {
                return new Value(new Application(left, right, false));
            }
        }
        else
        {
            Abstraction function = left.toAbstraction();
            
            if(function.canApply())
            {
                if(function.getExpression().isVariable())
                {
                    if(underAbstraction(ctx))
                    {
                        return new Value(new Application(left, right, false));
                    }
                    
                    return right;
                }
                else if (function.getExpression().isAbstraction())
                {
                    if(right.isAbstraction())
                    {
                        right.toAbstraction().setWithParentheses(false);
                    }
                    
                    Abstraction returnAbstraction = function.getExpression().toAbstraction();
                    return new Value(new Abstraction(returnAbstraction.getVariable(), new Value(returnAbstraction.getExpression().toString().replaceAll("\\b" + function.getVariable() + "\\b", right.toString())), false));
                }
                else if(function.getExpression().isString())
                {
                    return new Value(new Application(left, right, false));
                }
                else
                {
                    if(underAbstraction(ctx))
                    {
                        return new Value(new Application(left, right, false));
                    }
                    
                    return new Value(function.getExpression().toString().replaceAll("\\b" + function.getVariable() + "\\b", right.toString()));
                }
            }
            else
            {
                if(function.getExpression().isString())
                {
                    return new Value(new Application(left, right, false));
                }
                
                return function.getExpression();
            }
        }
    }
}
