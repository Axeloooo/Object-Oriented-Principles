package edu.ucalgary.oop;

public class RewardsProfile {
  private String rewardsNum = "Not enrolled";
  private int pointsTotal = 10;

  public RewardsProfile() throws Exception {
    InvalidRewardsNumException e = new InvalidRewardsNumException();
  }

  public RewardsProfile(String newNumber) {
    this.rewardsNum = newNumber;
  }

  public void setPoints(int addPoints) {
    this.pointsTotal += addPoints;
  }

  public int getPoints() {
    return this.pointsTotal;
  }

  public String getNumber() {
    return this.rewardsNum;
  }
}
