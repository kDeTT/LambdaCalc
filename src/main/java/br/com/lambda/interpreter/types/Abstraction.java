package br.com.lambda.interpreter.types;

/**
 *
 * @author ltosc
 */
public class Abstraction 
{
    private final String variable;
    private Value expression;
    private boolean withParentheses;
    
    public Abstraction(String variable, Value expression, boolean withParentheses) 
    {
        this.variable = variable;
        this.expression = expression;
        this.withParentheses = withParentheses;
    }

    public String getVariable() 
    {
        return variable;
    }

    public Value getExpression()
    {
        return expression;
    }

    public void setExpression(Value expression) 
    {
        this.expression = expression;
    }

    public boolean isWithParentheses() 
    {
        return withParentheses;
    }

    public void setWithParentheses(boolean withParentheses) 
    {
        this.withParentheses = withParentheses;
    }
    
    @Override
    public String toString()
    {
        if (withParentheses) 
        {
            return "λ" + variable + "." + expression.toString();
        } 
        else 
        {
            return "(" + "λ" + variable + "." + expression.toString() + ")";
        }
    }
    
    public boolean canApply() 
    {
        return expression.toString().matches(".*\\b" + variable + "\\b.*");
    }
}
