package edu.ucalgary.oop;

public class Booking {
  private final String STARTDATE;
  private final String ENDDATE;
  private final Pet BOOKEDPET;
  private final Employee CAREGIVER;

  public Booking(Pet pet, Employee assigned, String startDate, String endDate) {
    this.STARTDATE = startDate;
    this.ENDDATE = endDate;
    this.BOOKEDPET = pet;
    this.CAREGIVER = assigned;
  }

  public String getStartDate() {
    return this.STARTDATE;
  }

  public String getEndDate() {
    return this.ENDDATE;
  }

  public Pet getBookedPet() {
    return this.BOOKEDPET;
  }

  public Employee getCareGiver() {
    return this.CAREGIVER;
  }
}
