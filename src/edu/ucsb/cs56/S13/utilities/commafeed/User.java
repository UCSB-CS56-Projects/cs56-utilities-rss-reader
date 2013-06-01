package edu.ucsb.cs56.S13.utilities.commafeed;

import java.io.*;

public class User {

  public static Settings parseSettings(String json) throws IOException {
    return null;
  }

  public static class Settings implements Serializable {
    public String language;
    public String readingMode;
    public String readingOrder;
    public String viewMode;
    public Boolean showRead;
    public Boolean socialButtons;
    public Boolean scrollMarks;
    public String theme;
    public Object customCss;
  }

}
