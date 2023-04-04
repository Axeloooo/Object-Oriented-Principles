package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

import java.util.Date;

public class Itinerary {
  private Trip[] trips = new Trip[20];

  // Returns a string in the format of:
  // value (key)
  public static String fmtString(String key, String value) {
    return value + " (" + key + ")";
  }

  // Constructor
  public Itinerary(String[][] myTrips) {
    for (int i = 0; i < myTrips.length; i++) {
      trips[i] = new Trip(myTrips[i]);
    }
  }

  // Getter
  public Trip[] getTrips() {
    return trips;
  }

  public String formatByArrival() {

    for (int i = 0; i < trips.length; i++) {

      if (trips[i] == null) {
        break;
      }

      String arrival = trips[i].getArrival();
      String year = arrival.substring(0, 4);
      String month = arrival.substring(5, 7);

      if (i == 0) {

        System.out.println(year + " (Year)");
        System.out.println("--" + month + " (Month)");
        System.out.println("----" + trips[i].getCity() + " (City), " + trips[i].getCountry() + " (Country) (Place)");

      } else if (trips[i].getArrival().substring(0, 4).equals(trips[i - 1].getArrival().substring(0, 4))) {

        if (trips[i].getArrival().substring(5, 7).equals(trips[i - 1].getArrival().substring(5, 7))) {

          System.out.println("----" + trips[i].getCity() + " (City), " + trips[i].getCountry() + " (Country) (Place)");

        } else if (!trips[i].getArrival().substring(5, 7).equals(trips[i - 1].getArrival().substring(5, 7))) {

          System.out.println("--" + month + " (Month)");
          System.out.println("----" + trips[i].getCity() + " (City), " + trips[i].getCountry() + " (Country) (Place)");

        }

      } else if (!trips[i].getArrival().substring(0, 4).equals(trips[i - 1].getArrival().substring(0, 4))) {

        System.out.println(year + " (Year)");
        System.out.println("--" + month + " (Month)");
        System.out.println("----" + trips[i].getCity() + " (City), " + trips[i].getCountry() + " (Country) (Place)");

      }

    }

    return "";

  }

  // The first array holds years (2021-2023).
  // The second array holds months.
  // The third array holds formatted locations occurring in the year/month
  String[][][] byDate() {

    String[][][] byDate = new String[3][12][20];
    for (int i = 0; i < trips.length; i++) {

      if (trips[i] == null)
        break;

      final String year = trips[i].getArrival().substring(0, 4);
      final String month = trips[i].getArrival().substring(5, 7);
      final Integer yearInt = Integer.parseInt(year) - 2021;
      final Integer monthInt = Integer.parseInt(month) - 1;
      final int numberOfContent = byDate[yearInt][monthInt].length - 1;

      for (int j = 0; j < numberOfContent; j++) {

        if (byDate[yearInt][monthInt][j] == null) {
          byDate[yearInt][monthInt][j] = trips[i].getCity() + " (City), " + trips[i].getCountry() + " (Country)";
          break;
        }

      }
    }

    return byDate;

  }

}
