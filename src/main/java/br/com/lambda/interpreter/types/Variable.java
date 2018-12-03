package br.com.lambda.interpreter.types;

import java.util.Objects;

/**
 *
 * @author ltosc
 */
public class Variable
{
    private final String id;
    
    public Variable(String id) 
    {
        this.id = id;
    }
    
    public String getId() 
    {
        return id;
    }
    
    @Override
    public String toString() 
    {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Variable other = (Variable) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
