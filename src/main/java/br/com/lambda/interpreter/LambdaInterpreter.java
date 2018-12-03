package br.com.lambda.interpreter;

import br.com.lambda.antlr.LambdaLexer;
import br.com.lambda.antlr.LambdaParser;
import br.com.lambda.interpreter.types.Value;
import java.util.Arrays;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author ltosc
 */
public class LambdaInterpreter
{
    private LambdaParser getLambdaParser(String lambdaExpression) 
    {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(lambdaExpression);
        LambdaLexer lexer = new LambdaLexer(antlrInputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LambdaParser parser = new LambdaParser(tokens);
        
        return parser;
    }
    
    public void viewAST(String lambdaExpression)
    {
        LambdaParser parser = getLambdaParser(lambdaExpression);
        ParseTree tree = parser.expression();
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.open();
    }
    
    public String interpret(String expression)
    {
        StringBuilder resultStrBuilder = new StringBuilder();
        
        try 
        {
            LambdaParser lambdaParser;
            String currentExpression = expression;
            int iterateCounter = 0;
            Value result;
            
            resultStrBuilder.append(expression).append("\n");
            
            do
            {
                lambdaParser = getLambdaParser(currentExpression);
                ParseTree tree = lambdaParser.expression();

                FreeVariableVisitor freeVariableVisitor = new FreeVariableVisitor();
                freeVariableVisitor.visit(tree);
                
                ReduceVisitor reduceVisitor = new ReduceVisitor(freeVariableVisitor.getFreeVariables());
                result = reduceVisitor.visit(tree);
                
                if (!result.toString().equals(expression)) 
                {
                    resultStrBuilder.append("  =  ").append(result.toString()).append("\n");
                }
                
                currentExpression = result.toString();
                iterateCounter++;
            } 
            while (result.checkIfContinues() && (iterateCounter < 100));
            
            if (iterateCounter == 100)
            {
                resultStrBuilder.setLength(0);
                resultStrBuilder.append(expression).append("\n").append("  =  ").append(result.toString()).append("\n");
                resultStrBuilder.append(" (Redução infinita ou lambda termo não redutível)").append("\n");
            }
        } 
        catch (ParseCancellationException | ClassCastException ex) 
        {
            resultStrBuilder.append(String.format("[ ERROR ]: %s", ex.getMessage()));
        }
        
        return resultStrBuilder.toString();
    }
}
