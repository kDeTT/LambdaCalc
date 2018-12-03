package br.com.lambda;

import br.com.lambda.console.LambdaCalcConsole;
import br.com.lambda.gui.LambdaCalcGUI;
import java.util.Scanner;

/**
 *
 * @author ltosc
 */
public class LambdaCalc 
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("LambdaCalc Interpreter");
            System.out.println("[1] - GUI");
            System.out.println("[2] - Console");
            
            System.out.println();
            System.out.print("Option: ");
            int option = new Scanner(System.in).nextInt();
            System.out.println();
            
            switch (option) 
            {
                case 1:
                    LambdaCalcGUI lambdaCalcGUI = new LambdaCalcGUI();
                    lambdaCalcGUI.showApp();
                    break;
                case 2:
                    LambdaCalcConsole lambdaCalcConsole = new LambdaCalcConsole();
                    lambdaCalcConsole.showApp();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
