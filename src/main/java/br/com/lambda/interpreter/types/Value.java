package br.com.lambda.interpreter.types;

import java.util.Objects;

/**
 *
 * @author ltosc
 */
public class Value 
{
    private final Object value;
    
    public Value(Object value)
    {
        this.value = value;
    }
    
    public Object getValue()
    {
        return this.value;
    }
    
    public Integer toInteger()
    {
        return (Integer)value;
    }
    
    @Override
    public String toString() 
    {
        return String.valueOf(value);
    }
    
    public Abstraction toAbstraction()
    {
        return (Abstraction)value;
    }
    
    public Calculus toCalculus() 
    {
        return (Calculus)value;
    }

    public RecursiveFunction toRecursiveFunction()
    {
        return (RecursiveFunction)value;
    }

    public IfStatement toIfStatement() 
    {
        return (IfStatement)value;
    }
    
    public boolean isInteger() 
    {
        return (value instanceof Integer);
    }
    
    public boolean isString() 
    {
        return (value instanceof String);
    }

    public boolean isAbstraction()
    {
        return (value instanceof Abstraction);
    }
    
    public boolean isCalcul()
    {
        return (value instanceof Calculus);
    }
    
    public boolean isRecursiveFunction() 
    {
        return (value instanceof RecursiveFunction);
    }

    public boolean isVariable() 
    {
        return (value instanceof Variable);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Value other = (Value) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    public boolean checkIfContinues()
    {
        return !(isAbstraction() || isVariable() || isInteger());
    }
}
