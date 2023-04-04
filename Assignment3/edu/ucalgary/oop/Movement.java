package edu.ucalgary.oop;

import java.util.regex.*;

public class Movement implements Cloneable, FormattedOutput {
  enum Actions {
    FORWARD, LEFT, REVERSE, RIGHT, START, STOP
  }

  enum Directions {
    E, N, NE, NW, S, SE, SW, W
  }

  private String action;
  private String direction;
  private final String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})";
  private final Pattern PATTERN = Pattern.compile(REGEX);

  public Movement(String movement) throws IllegalArgumentException {
    Matcher matcher = PATTERN.matcher(movement);
    if (!matcher.find()) {
      throw new IllegalArgumentException("Invalid movement");
    }
    this.action = matcher.group(1);
    this.direction = matcher.group(2);
  }

  public String getAction() {
    return this.action;
  }

  public String getDirection() {
    return this.direction;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      throw new CloneNotSupportedException();
    }
  }

  @Override
  public String getFormatted() {
    return "Action: " + this.action + ", Direction: " + this.direction;
  }
}
