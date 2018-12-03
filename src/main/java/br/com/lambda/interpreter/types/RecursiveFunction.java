package br.com.lambda.interpreter.types;

import java.util.Objects;

/**
 *
 * @author ltosc
 */
public class RecursiveFunction
{
    private final Variable functionName;
    private final Variable application;
    private final Value function;
    
    public RecursiveFunction(Variable functionName, Variable application, Value function)
    {
        this.functionName = functionName;
        this.application = application;
        this.function = function;
    }
    
    @Override
    public String toString() 
    {
        return "(rec " + functionName + " " + application + "." + function + ")";
    }

    public Variable getFunctionName() 
    {
        return functionName;
    }

    public Variable getApplication() 
    {
        return application;
    }
    
    public Value getFunction()
    {
        return function;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.functionName);
        hash = 37 * hash + Objects.hashCode(this.application);
        hash = 37 * hash + Objects.hashCode(this.function);
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
        final RecursiveFunction other = (RecursiveFunction) obj;
        if (!Objects.equals(this.functionName, other.functionName)) {
            return false;
        }
        if (!Objects.equals(this.application, other.application)) {
            return false;
        }
        if (!Objects.equals(this.function, other.function)) {
            return false;
        }
        return true;
    }
}
