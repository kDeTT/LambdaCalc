package br.com.lambda.interpreter.types;

import java.util.Objects;

/**
 *
 * @author ltosc
 */
public class Application
{
    private final Value left;
    private final Value right;
    private final boolean shouldPair;
    
    public Application(Value left, Value right, boolean shouldPair) 
    {
        this.left = left;
        this.right = right;
        this.shouldPair = shouldPair;
    }

    public Value getLeft() 
    {
        return left;
    }

    public Value getRight()
    {
        return right;
    }
    
    @Override
    public String toString() 
    {
        if (shouldPair)
        {
            return "(" + left + " " + right + ")";
        } 
        else 
        {
            return left + " " + right;
        }
    }

    @Override
    public int hashCode() 
    {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.left);
        hash = 71 * hash + Objects.hashCode(this.right);
        hash = 71 * hash + (this.shouldPair ? 1 : 0);
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
        final Application other = (Application) obj;
        if (this.shouldPair != other.shouldPair) {
            return false;
        }
        if (!Objects.equals(this.left, other.left)) {
            return false;
        }
        if (!Objects.equals(this.right, other.right)) {
            return false;
        }
        return true;
    }
}