package edu.ucsb.cs56.S13.utilities.commafeed;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test class for CommaFeed
 *
 * @author Mark Nguyen
 * @author Daniel Vicory
 * @version CS56, S13, UCSB
 * @see CommaFeed
 */
public class CommaFeedTest {
  @Test(expected=AuthenticationException.class)
  public void test_Constructor01() {
    // we should not be able to authenticate with empty username and password
    CommaFeed cf = new CommaFeed("", "");
  }

  @Test(expected=AuthenticationException.class)
  public void test_Constructor02() {
    // we should not be able to authenticate with null username and password
    CommaFeed cf = new CommaFeed(null, null);
  }

  @Test
  public void test_Constructor03() {
    // tests the demo commafeed account using the default constructor
    CommaFeed cf = new CommaFeed();

    assertEquals("demo", cf.getUsername());
    assertEquals("demo", cf.getPassword());
  }

  @Test
  public void test_Constructor04() {
    // tests to make sure the arg constructor works with demo commafeed account
    CommaFeed cf = new CommaFeed("demo", "demo");

    assertEquals("demo", cf.getUsername());
    assertEquals("demo", cf.getPassword());
  }
}
