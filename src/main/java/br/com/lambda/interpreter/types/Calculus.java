package br.com.lambda.interpreter.types;

import java.util.Objects;

/**
 *
 * @author ltosc
 */
public class Calculus 
{
    private final Value left;
    private final Value right;
    private final char operator;
    
    public Calculus(Value left, Value right, char operator) 
    {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Value getLeft() {
        return left;
    }

    public Value getRight() {
        return right;
    }

    public char getOperator() {
        return operator;
    }
    
    @Override
    public String toString() 
    {
        return left.toString() + operator + right.toString();
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.left);
        hash = 13 * hash + Objects.hashCode(this.right);
        hash = 13 * hash + this.operator;
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
        final Calculus other = (Calculus) obj;
        if (this.operator != other.operator) {
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
