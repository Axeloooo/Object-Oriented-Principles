package edu.ucalgary.oop;

public class Client {
  private String name;
  private String phoneNumber;
  private String address;
  private RewardsProfile rewardsInfo;

  public Client(String name, String phoneNumber, String address) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public Boolean enrollRewards(String newNumber) {
    if (newNumber.matches("-?\\d+(\\.\\d+)?") && newNumber.length() == 7) {
      this.rewardsInfo = new RewardsProfile(newNumber);
      return true;
    }
    InvalidRewardsNumException e = new InvalidRewardsNumException();
    System.out.println(e.getMessage());
    return false;
  }

  public int getRewardsPoints() {
    if (rewardsInfo == null) {
      return 0;
    }
    return this.rewardsInfo.getPoints();
  }

  public String getRewardsNumber() {
    if (rewardsInfo == null) {
      return "Not enrolled";
    }
    return this.rewardsInfo.getNumber();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String num) {
    this.phoneNumber = num;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void updatePoints(int addPoints) {
    this.rewardsInfo.setPoints(addPoints);
  }
}
