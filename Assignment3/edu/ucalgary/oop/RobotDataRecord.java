package edu.ucalgary.oop;

import java.util.ArrayList;

public class RobotDataRecord implements Cloneable {
  private ArrayList<RobotDataLine> log;

  public RobotDataRecord(String[] array) {
    this.log = new ArrayList<>();
    for (String line : array) {
      this.log.add(new RobotDataLine(line));
    }
  }

  public RobotDataLine getLine(int index) {
    return this.log.get(index);
  }

  public ArrayList<RobotDataLine> getDataRecord() {
    return this.log;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    try {
      RobotDataRecord clone = (RobotDataRecord) super.clone();
      clone.log = new ArrayList<>();
      for (RobotDataLine line : this.log) {
        clone.log.add((RobotDataLine) line.clone());
      }
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new CloneNotSupportedException();
    }
  }
}
