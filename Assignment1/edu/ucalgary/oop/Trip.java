package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

public class Trip {
  private String arrival;
  private String departure;
  private String city;
  private String country;

  // Returns a string in the format of:
  // value (key)
  public static String fmtString(String key, String value) {
    return value + " (" + key + ")";
  }

  // Constructor
  public Trip(String[] array) {
    this.arrival = array[0];
    this.departure = array[1];
    this.city = array[2];
    this.country = array[3];
  }

  // Given a date string, return just the year
  public static int getYear(String date) {
    String year = date.substring(0, 4);
    return Integer.parseInt(year);
  }

  // Given a date string, return just the month
  // Since it is an int, a date like "2022-01-12" returns 1
  public static int getMonth(String date) {
    String month = date.substring(5, 7);
    return Integer.parseInt(month);
  }

  // Return a formatted string of key/value pairs, with commas
  // between each. See the output for an example.
  public String formatTrip() {
    final String arrivalString = fmtString("Arrival", arrival);
    final String departureString = fmtString("Departure", departure);
    final String cityString = fmtString("City", city);
    final String countryString = fmtString("Country", country);
    return arrivalString + ", " + departureString + ", " + cityString + ", " + countryString;
  }

  // Getter
  public String getArrival() {
    return arrival;
  }

  // Getter
  public String getDeparture() {
    return departure;
  }

  // Getter
  public String getCity() {
    return city;
  }

  // Getter
  public String getCountry() {
    return country;
  }

  // Setter
  public void setArrival(String date) {
    this.arrival = date;
  }

  // Setter
  public void setDeparture(String date) {
    this.departure = date;
  }

  // Setter
  public void setCity(String city) {
    this.city = city;
  }

  // Setter
  public void setCountry(String country) {
    this.country = country;
  }

}
