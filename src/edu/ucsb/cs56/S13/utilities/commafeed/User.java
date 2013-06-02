package edu.ucsb.cs56.S13.utilities.commafeed;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class User {

  public static Settings parseSettings(String json) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Settings settings = mapper.readValue(json, Settings.class);
    return settings;
  }

  public static class Settings implements Serializable {
    public static final long serialVersionUID = 20130512L;
    public String language;
    public String readingMode;
    public String readingOrder;
    public String viewMode;
    public boolean showRead;
    public boolean socialButtons;
    public boolean scrollMarks;
    public String theme;
    public Object customCss;
  }

  public static Profile parseProfile(String json) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Profile profile = mapper.readValue(json, Profile.class);
    return profile;
  }

  public static class Profile implements Serializable {
    public static final long serialVersionUID = 20130512L;
    public int id;
    public String name;
    public String email;
    public String apiKey;
    public String password;
    public boolean enabled;
    public boolean admin;
  }
}
