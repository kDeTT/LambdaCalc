package br.com.lambda.interpreter.types;

import java.util.Objects;

/**
 *
 * @author ltosc
 */
public class IfStatement 
{
    private final Value leftToEq;
    private final Value rightToEq;
    private final Value thenReturn;
    private final Value elseReturn;
    private final String operator;
    
    public IfStatement(Value leftToEq, Value rightToEq, Value thenReturn, Value elseReturn, String operator) 
    {
        this.leftToEq = leftToEq;
        this.rightToEq = rightToEq;
        this.thenReturn = thenReturn;
        this.elseReturn = elseReturn;
        this.operator = operator;
    }

    public Value getLeftToEq()
    {
        return leftToEq;
    }

    public Value getRightToEq() 
    {
        return rightToEq;
    }

    public Value getThenReturn() 
    {
        return thenReturn;
    }

    public Value getElseReturn() 
    {
        return elseReturn;
    }

    public String getOperator() 
    {
        return operator;
    }
    
    @Override
    public String toString() 
    {
        return "if(" + leftToEq + operator + rightToEq + ")then{" + thenReturn + "}else{" + elseReturn + "}";
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.leftToEq);
        hash = 83 * hash + Objects.hashCode(this.rightToEq);
        hash = 83 * hash + Objects.hashCode(this.thenReturn);
        hash = 83 * hash + Objects.hashCode(this.elseReturn);
        hash = 83 * hash + Objects.hashCode(this.operator);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IfStatement other = (IfStatement) obj;
        if (!Objects.equals(this.operator, other.operator)) {
            return false;
        }
        if (!Objects.equals(this.leftToEq, other.leftToEq)) {
            return false;
        }
        if (!Objects.equals(this.rightToEq, other.rightToEq)) {
            return false;
        }
        if (!Objects.equals(this.thenReturn, other.thenReturn)) {
            return false;
        }
        if (!Objects.equals(this.elseReturn, other.elseReturn)) {
            return false;
        }
        return true;
    }
}
