package edu.ucalgary.oop;

public class CareProfile {
  private String[] medList;
  private String medInstructions;
  private String feedingInstructions;

  public CareProfile(String[] medList, String meds, String feeding) {
    this.medList = medList;
    this.medInstructions = meds;
    this.feedingInstructions = feeding;
  }

  public String summarizeCareInstructions() {
    StringBuilder summary = new StringBuilder();
    for (int i = 0; i < medList.length - 1; i++) {
      summary.append(medList[i]).append(", ");
    }
    summary.append(medList[medList.length - 1]);
    summary.append("\n").append(medInstructions).append("\n").append(feedingInstructions);
    return summary.toString();
  }
}
