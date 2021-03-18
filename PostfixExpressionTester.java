import java.util.Scanner;

/**
* @author: Enock Niyonkuru
* @version 1.0 March 16, 2021
* Tester Class for PostfixExpression
*/

public class PostfixExpressionTester {

 public static void main(String[] args) {
  Scanner scn = new Scanner (System.in);

  String decision = "yes"; // initialize a decision to yes;

  while(decision.equals("yes")){
      try {
        PostfixExpression post = new PostfixExpression();
        System.out.print("Enter a postfix expression: ");
        String spr = scn.nextLine();
          double result = post.evaluate(spr);
        System.out.format("Results: " + "%.2f",result); // rounding the results to two decimal numbers
        System.out.println(" ");
        }
      catch (BadPostfixExpressionException|NumberFormatException e) {
       System.out.println("You entered a bad postfix expression.");
        }
      catch (Exception e) {
       System.out.println("Invalid input.");
       }
   System.out.println("Do you wish to continue? (yes/no) ? ");
      decision = scn.nextLine();
      }

   }
}
