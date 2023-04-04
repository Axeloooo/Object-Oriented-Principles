package edu.ucalgary.oop;

public class ReportCard {
  private final Booking REPORT;

  public ReportCard(Booking reportInfo) {
    this.REPORT = reportInfo;
  }

  public String printReport() {
    return this.REPORT.getCareGiver().getName() + " enjoyed taking care of " + this.REPORT.getBookedPet().getName()
        + ". See you next time!";
  }
}