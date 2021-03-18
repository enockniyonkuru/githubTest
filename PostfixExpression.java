

/**
* @author: Enock Niyonkuru
* @version 1.0 March 16, 2021
* Implements a class to evaluate a postfix expression.
*/
import java.util.StringTokenizer;
public class PostfixExpression {
  // fields for StringTokenizer class
  private String expr;
  private LinkedStack<Double> stack;

  /**
  * constuctor
  * Creates a new expression in a postfix notation.
  * created an empty LinkedStack
  */
  public PostfixExpression() {
    stack = new LinkedStack<Double>();
  }

  /**
  * Evaluates a postfix expression expr.
  * @param expr   The String expr which contains the postfix.
  * @return double the final solution after evaluating the postfix.
  */
public double evaluate(String expr) throws BadPostfixExpressionException {
  StringTokenizer stk = new StringTokenizer(expr);
   while (stk.hasMoreTokens()){
     String next = stk.nextToken();
     if(isOperator(next)){
       if(stack.size()< 2)throw new BadPostfixExpressionException(); // Throw exception when there are too many operators in the postfix
       Double solution = evaluateOperation(next, stack.pop().doubleValue(), stack.pop().doubleValue());
       stack.push(solution);
             }
    else{
        Double nextT = stringToDouble(next);
        stack.push(nextT);
        }
   }
 if(stack.size()!=1)throw new BadPostfixExpressionException(); // Throw exception when there are too many operands in the postfix
 return (stack.pop());

}
  /**
  * A helper method for evaluate().
  * Checks if op is a valid operator (+, -, *, /)
  * @param op  a string which is an althimetic operator to be evaluated
  * @return boolean to check whether it is (+, -, *, /) false if not.
  */
private boolean isOperator(String op) {
  boolean decision;

   switch (op.charAt(0)){
        case '+':
         decision = true;
         break;
        case '-':
         decision = true;
         break;
        case '*':
         decision = true;
         break;
        case '/':
         decision = true;
         break;
        default:
         decision = false;
       }
return decision;

  }

  /**
  * A helper method for evaluate().
  * Evaluates a single postfix operation: op1 op2 operation.
  * @param operation  a String which contains the symbol of operation to be used in althimetic operations
  * @param op1   a double number to be used as the first element in the althimetic operations
  * @param op2   a double number to be used as the second element in the althimetic operations
  * @return  the double value of the solution to the althimetic operation from evaluate
  */
private double evaluateOperation(String operation, double op1, double op2) {
  double ans= 0.00;
  if(operation.equals("+")){
     ans = (op1+op2);
   }
  else if (operation.equals("-")){
     ans = (op2-op1);
   }
  else if (operation.equals("*")){
     ans = (op1*op2);
   }
  else if (operation.equals("/")){
     ans = (op2/op1);
   }
return ans;
}
/**
* a helper methor for evaluate ().
* stringToDouble converts a string to double value
* @param s  is a string to be converted into doubleValue
* @return  a double value which has been converted from string
*/
  private double stringToDouble (String s){
    return (Double.parseDouble(s));
      }
}
