package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.regex.*;

public class RobotDataLine implements Cloneable {
  private String dataLine;
  private String robotID;
  private Sensor sensor;
  private Movement movement;
  private LocalDate date;
  private final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
  private final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
  private final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1}\\s)";
  private final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

  public RobotDataLine(String line) throws IllegalArgumentException {
    this.dataLine = line;
    Matcher dateMatcher = DATE_PATTERN.matcher(line);
    Matcher dateMatcher2 = ROBOT_PATTERN.matcher(line);
    if (!dateMatcher.find() || !dateMatcher2.find()) {
      throw new IllegalArgumentException("Invalid date or robot ID");
    }
    if (Integer.parseInt(dateMatcher.group(1)) > 30 || Integer.parseInt(dateMatcher.group(2)) > 12) {
      throw new IllegalArgumentException("Invalid date");
    }

    this.date = LocalDate.of(Integer.parseInt(dateMatcher.group(3)), Integer.parseInt(dateMatcher.group(2)),
        Integer.parseInt(dateMatcher.group(1)));
    this.robotID = dateMatcher2.group(1);
    this.sensor = new Sensor(line.substring(line.indexOf("("), line.indexOf(")") + 1));
    this.movement = new Movement(line);
  }

  public String getRobotID() {
    return this.robotID;
  }

  public String getDataLine() {
    return this.dataLine;
  }

  public Sensor getSensor() {
    return this.sensor;
  }

  public Movement getMovement() {
    return this.movement;
  }

  public LocalDate getDate() {
    return this.date;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    try {
      RobotDataLine clone = (RobotDataLine) super.clone();
      clone.sensor = (Sensor) this.sensor.clone();
      clone.movement = (Movement) this.movement.clone();
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new CloneNotSupportedException();
    }
  }
}
