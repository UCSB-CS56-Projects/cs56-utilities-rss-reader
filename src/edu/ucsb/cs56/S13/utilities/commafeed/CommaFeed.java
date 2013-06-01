package edu.ucsb.cs56.S13.utilities.commafeed;

import java.io.*;

import org.apache.http.client.methods.*;
import org.apache.http.client.*;
import org.apache.http.impl.client.*;
import org.apache.http.*;

/**
 * A wrapper for the CommaFeed API in the form of a Java Object.
 * @author Mark Nguyen
 * @author Daniel Vicory
 */
public class CommaFeed {
  /** boolean flag to control debug statements */
  private static final Boolean DEBUG = true;

  /** the base URL for all CommaFeed API requests */
  public static final String API_ROOT = "https://www.commafeed.com/rest";

  /** the raw unencoded username of the client */
  private final String username;

  /** the raw unencoded password of the client */
  private final String password;

  /** the raw API key of the client, can be null if there is none */
  private final String apiKey;

  /**
   * Creates a new CommaFeed API wrapper that only has access to
   * the demo content.  To access a user's content, pass the user's
   * username and password as parameters for the constructor.
   * This is essentially calling <code>CommaFeed("demo", "demo")
   * </code>.
   * @see #CommaFeed(String username, String password)
   */
  public CommaFeed() throws IOException {
    this("demo", "demo");
  }

  /**
   * Creates a new CommaFeed API wrapper that has access to the user's
   * content. Will attempt to create an API key for further access
   * to the user's content.
   * @param username the unencoded raw username of the client
   * @param password the unencoded raw password of the client
   * @see #CommaFeed()
   */
  public CommaFeed(String username, String password) throws IOException {
    this.username = username;
    this.password = password;

    HttpClient client = new DefaultHttpClient();

    // prepare the request
    HttpGet profileRequest = getHttpGet("/user/profile");

    // execute request
    HttpResponse response = client.execute(profileRequest);

    // get the string of the response
    String profileResponse = getStringFromEntity(response.getEntity());

    if (DEBUG) {
	System.out.println(String.format("CommaFeed(username=%s, password=%s) profile response:", this.username, this.password));
	System.out.println(profileResponse);
    }

    // TODO we should try to use an API key by looking it up
    // or generating one if one does not exist
    this.apiKey = null;
  }

  /**
   * Creates a new CommaFeed API wrapper that has access to the user's
   * content. Uses the given API key to access the user's content.
   * @param apiKey the raw API key of the client
   * @see #CommaFeed()
   */
  public CommaFeed(String apiKey) throws IOException {
    // TODO get username to verify working API key
    this.username = null;
    this.password = null;
    this.apiKey = apiKey;
  }

  /**
   * Returns HttpGet that is preinitialized with the base URL and Accept header
   * @return preinitialized HttpGet
   */
  private HttpGet getHttpGet(String method) {
    // this is the base url for the api
    String url = API_ROOT + method;

    // create the new get request
    HttpGet get = new HttpGet(url);

    // add auth header
    get.addHeader("Authorization", "Basic " + StringUtils.base64Encode(username + ":" + password));

    // the accept header must be set to application/json
    get.addHeader("Accept", "application/json");

    return get;
  }

  /**
   * Returns HttpPost that is preinitialized with the base URL and Accept header
   * @return preinitialized HttpPost
   */
  private HttpPost getHttpPost(String method) {
    // this is the base url for the api
    String url = API_ROOT + method;

    // create the new post request
    HttpPost post = new HttpPost(url);

    // add auth header
    post.addHeader("Authorization", "Basic " + StringUtils.base64Encode(username + ":" + password));

    // the accept header must be set to application/json
    post.addHeader("Accept", "application/json");

    return post;
  }

  /**
   * Reads the content of an entity into a String and returns that String.  If the
   * stream is currently blocked, this function will also block until the end of
   * the stream is encountered or an exception is encountered.
   * @param entity The entity where the content will be read from.
   * @return The String representation of the content of the entity.
   * @throws IOException If an I/O error occurs
   */
  private static String getStringFromEntity(HttpEntity entity) throws IOException {
      // read content
      BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
      String line = null;
      StringBuilder stringBuilder = new StringBuilder();
      while ((line = reader.readLine()) != null) {
	  stringBuilder.append(line);
      }

      return stringBuilder.toString();
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
}
