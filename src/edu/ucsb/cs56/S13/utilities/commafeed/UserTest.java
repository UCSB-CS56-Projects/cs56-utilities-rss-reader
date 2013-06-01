package edu.ucsb.cs56.S13.utilities.commafeed;

import java.io.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
  private static final String exampleSettings = "{\"language\": \"en\",\"readingMode\": \"unread\",\"readingOrder\": \"desc\",\"viewMode\": \"title\",\"showRead\": true,\"socialButtons\": true,\"scrollMarks\": true,\"theme\": \"default\",\"customCss\": null}";


  @Test
  public void testParseSettings() throws IOException {
    User.Settings settings = User.parseSettings(exampleSettings);
    assertEquals(settings.language, "en");
    assertEquals(settings.readingMode, "unread");
    assertEquals(settings.readingOrder, "desc");
    assertEquals(settings.viewMode, "title");
    assertEquals(settings.showRead, true);
    assertEquals(settings.socialButtons, true);
    assertEquals(settings.scrollMarks, true);
    assertEquals(settings.theme, "default");
    assertEquals(settings.customCss, null);
  }
}
