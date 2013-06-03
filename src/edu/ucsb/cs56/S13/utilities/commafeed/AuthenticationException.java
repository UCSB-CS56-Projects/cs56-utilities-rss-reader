package edu.ucsb.cs56.S13.utilities.commafeed;

/**
 * Indicates that the credentials provided and used for authentication
 * did not resolve successfully.  Could indicate incorrect username
 * and password combination.
 */
public class AuthenticationException extends Exception {
  public static final long serialVersionUID = 20130602L;
  public AuthenticationException() { super(); }
  public AuthenticationException(String message) { super(message); }
  public AuthenticationException(String message, Throwable cause) { super(message, cause); }
  public AuthenticationException(Throwable cause) { super(cause); }
}
