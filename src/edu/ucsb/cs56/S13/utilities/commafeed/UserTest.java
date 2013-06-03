package edu.ucsb.cs56.S13.utilities.commafeed;

import java.io.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
  private static final String exampleSettings = "{\"language\": \"en\",\"readingMode\": \"unread\",\"readingOrder\": \"desc\",\"viewMode\": \"title\",\"showRead\": true,\"socialButtons\": true,\"scrollMarks\": true,\"theme\": \"default\",\"customCss\": null}";
  private static final String exampleProfile = "{\"id\": 13161,\"name\": \"demo\",\"email\": null,\"apiKey\": null,\"password\": null,\"enabled\": true,\"admin\": false}";

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

  @Test
  public void testParseProfile() throws IOException {
    User.Profile profile = User.parseProfile(exampleProfile);
    assertEquals(profile.id, 13161);
    assertEquals(profile.name, "demo");
    assertEquals(profile.email, null);
    assertEquals(profile.apiKey, null);
    assertEquals(profile.password, null);
    assertEquals(profile.enabled, true);
    assertEquals(profile.admin, false);
  }
}
