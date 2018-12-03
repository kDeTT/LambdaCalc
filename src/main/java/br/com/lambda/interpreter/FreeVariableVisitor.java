package br.com.lambda.interpreter;

import br.com.lambda.antlr.LambdaParser;
import br.com.lambda.interpreter.types.Abstraction;
import br.com.lambda.interpreter.types.Value;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ltosc
 */
public class FreeVariableVisitor extends LambdaSimpleVisitor
{
    private final Set<String> freeVariables;
    private final Set<String> boundVariables;
    
    public FreeVariableVisitor()
    {
        this.freeVariables = new HashSet<>();
        this.boundVariables = new HashSet<>();
    }
    
    public Set<String> getFreeVariables()
    {
        return this.freeVariables;
    }
    
    @Override
    public Value visitAbstraction(LambdaParser.AbstractionContext ctx)
    {
        String var = ctx.VAR().getText();
        boundVariables.add(var);
        
        Value expression = this.visit(ctx.expression());
        boundVariables.remove(var);
        
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
    public Value visitVariable(LambdaParser.VariableContext ctx)
    {
        String var = ctx.getText();
        
        if(!boundVariables.contains(var))
        {
            freeVariables.add(var);
        }
        
        return super.visitVariable(ctx);
    }
}