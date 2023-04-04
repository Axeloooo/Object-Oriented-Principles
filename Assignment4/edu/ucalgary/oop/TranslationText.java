package edu.ucalgary.oop;

import java.io.Serializable;

public class TranslationText implements Serializable {
  private static final long serialVersionUID = 19L;

  private final String sentence;
  private final String[] months;
  private final String[] days;

  public TranslationText(String[] months, String[] days, String sentence) {
    this.months = months;
    this.days = days;
    this.sentence = sentence;
  }

  public String getSentence() {
    return sentence;
  }

  public String[] getMonths() {
    return months;
  }

  public String[] getDays() {
    return days;
  }

  public String getMonth(int index) {
    if (index >= 0 && index < months.length) {
      return months[index];
    } else {
      throw new IndexOutOfBoundsException("Invalid month index");
    }
  }

  public String getDay(int index) {
    if (index >= 0 && index < days.length) {
      return days[index];
    } else {
      throw new IndexOutOfBoundsException("Invalid day index");
    }
  }
}