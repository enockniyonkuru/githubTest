/**
 *  An exception to throw when a user enters a bad postfix expression.
 */
public class BadPostfixExpressionException extends RuntimeException {
  public BadPostfixExpressionException() {
    super ("Bad postfix expression.");
  }
}
