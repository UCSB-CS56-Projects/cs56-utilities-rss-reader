package edu.ucsb.cs56.S13.utilities.commafeed;

import org.apache.http.client.methods.*;

/**
 * A wrapper for the CommaFeed API in the form of a Java Object.
 * @author Mark Nguyen
 * @author Daniel Vicory
 */
public class CommaFeed {
  /** the base URL for all CommaFeed API requests */
  public static final String API_ROOT = "https://www.commafeed.com/rest";

  /** the raw unencoded username of the client */
  private final String username;

  /** the raw unencoded password of the client */
  private final String password;

  /**
   * Creates a new CommaFeed API wrapper that only has access to
   * the demo content.  To access a user's content, pass the user's
   * username and password as parameters for the constructor.
   * This is essentially calling <code>CommaFeed("demo", "demo")
   * </code>.
   * @see #CommaFeed(String username, String password)
   */
  public CommaFeed() {
    this.username = null;
    this.password = null;
  }

  /**
   * Creates a new CommaFeed API wrapper that has access to the user's
   * content.
   * @param username the unencoded raw username of the client
   * @param password the unencoded raw password of the client
   * @see #CommaFeed()
   */
  public CommaFeed(String username, String password) {
    this.username = null;
    this.password = null;
  }

  /**
   * Returns HttpGet that is preinitialized with the base URL and Accept header
   *
   * @return preinitialized HttpGet
   */
  private HttpGet getHTTPGet(String method) {
    // this is the base url for the api
    String url = API_ROOT + method;

    // create the new get request
    HttpGet get = new HttpGet(url);

    // the accept header must be set to application/json
    get.addHeader("Accept", "application/json");

    return get;
  }


  /**
   * Returns HttpPost that is preinitialized with the base URL and Accept header
   *
   * @return preinitialized HttpPost
   */
  private HttpPost getHTTPPost(String method) {
    // this is the base url for the api
    String url = API_ROOT + method;

    // create the new post request
    HttpPost post = new HttpPost(url);

    // the accept header must be set to application/json
    post.addHeader("Accept", "application/json");

    return post;
  }

  /**
   * Retrieves the username given during construction, or null if the
   * no args constructor was called.
   * @return the raw unencoded username of the client, or null if not
   * specified during construction.
   */
  public String getUsername() {
    return null;
  }

  /**
   * Retrieves the password given during construction, or null if the
   * no args constructor was called.
   * @return the raw unencoded password of the client, or null if not
   * specified during construction.
   */
  public String getPassword() {
    return null;
  }

}
