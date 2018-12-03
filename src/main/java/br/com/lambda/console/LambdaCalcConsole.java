package br.com.lambda.console;

import br.com.lambda.interpreter.LambdaInterpreter;
import java.util.Scanner;

/**
 *
 * @author ltosc
 */
public class LambdaCalcConsole 
{
    private final LambdaInterpreter lambdaInterpreter;
    
    public LambdaCalcConsole()
    {
        this.lambdaInterpreter = new LambdaInterpreter();
    }
    
    public void showApp()
    {
        Scanner input = new Scanner(System.in);
        boolean again = true;
        String exp;

        do {
            System.out.print("Entre com a expressão lambda: ");

            exp = input.nextLine();

            if (exp.equalsIgnoreCase("exit")) {
                again = false;
            } else {
                System.out.println("Resultado: \n" + lambdaInterpreter.interpret(exp));
            }
        } while (again);
    }
}
