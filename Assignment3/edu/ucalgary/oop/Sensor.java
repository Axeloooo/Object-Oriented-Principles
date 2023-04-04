package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sensor implements Cloneable, FormattedOutput {
  private String sensor;
  private final String REGEX = "\\(([a-z]+)\\)";
  private final Pattern PATTERN = Pattern.compile(REGEX);

  public Sensor(String sensor) throws IllegalArgumentException {
    Matcher matcher = PATTERN.matcher(sensor);
    if (!matcher.find()) {
      throw new IllegalArgumentException("Invalid sensor " + sensor);
    }
    this.sensor = matcher.group(1);
  }

  public String getSensor() {
    return this.sensor;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e.toString());
    }
  }

  @Override
  public String getFormatted() {
    return "Sensor: " + this.sensor;
  }
}
