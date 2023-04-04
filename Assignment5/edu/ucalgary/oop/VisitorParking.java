package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class VisitorParking {
  private HashMap<String, TreeSet<LocalDate>> parkingInfo = new HashMap<>();

  public VisitorParking() {

  }

  public VisitorParking(String licence) throws IllegalArgumentException {
    licence = Parking.standardizeAndValidateLicence(licence);
    addVisitorReservation(licence, LocalDate.now());
  }

  public VisitorParking(String licence, LocalDate issued) throws IllegalArgumentException {
    licence = Parking.standardizeAndValidateLicence(licence);
    if (issued.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Invalid issued date.");
    }
    addVisitorReservation(licence, issued);
  }

  public void addVisitorReservation(String licence) throws IllegalArgumentException {
    addVisitorReservation(licence, LocalDate.now());
  }

  public void addVisitorReservation(String licence, LocalDate date) throws IllegalArgumentException {
    licence = Parking.standardizeAndValidateLicence(licence);
    if (date.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Invalid date.");
    }

    int count = 0;
    for (TreeSet<LocalDate> dates : parkingInfo.values()) {
      if (dates.contains(date)) {
        count++;
      }
    }

    if (count >= 2) {
      throw new IllegalArgumentException("Cannot have more than two visitor licences registered for a single day.");
    }

    TreeSet<LocalDate> reservationDates = parkingInfo.getOrDefault(licence, new TreeSet<>());
    if (reservationDates.contains(date)) {
      throw new IllegalArgumentException("Licence plate is already registered for the given date.");
    }

    reservationDates.add(date);
    reservationDates.add(date.plusDays(1));
    reservationDates.add(date.plusDays(2));

    parkingInfo.put(licence, reservationDates);
  }

  public HashMap<String, TreeSet<LocalDate>> getParkingInfo() {
    return parkingInfo;
  }

  public boolean licenceIsRegisteredForDate(String licence) throws IllegalArgumentException {
    licence = Parking.standardizeAndValidateLicence(licence);
    return parkingInfo.containsKey(licence);
  }

  public boolean licenceIsRegisteredForDate(String licence, LocalDate date) throws IllegalArgumentException {
    licence = Parking.standardizeAndValidateLicence(licence);
    if (date.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Invalid date.");
    }

    TreeSet<LocalDate> reservationDates = parkingInfo.getOrDefault(licence, new TreeSet<>());
    return reservationDates.contains(date);
  }

  public ArrayList<String> getLicencesRegisteredForDate() {
    ArrayList<String> licences = new ArrayList<>();
    for (String licence : parkingInfo.keySet()) {
      if (parkingInfo.get(licence).contains(LocalDate.now())) {
        licences.add(licence);
      }
    }
    return licences;
  }

  public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {
    ArrayList<String> licences = new ArrayList<>();
    for (String licence : parkingInfo.keySet()) {
      if (licenceIsRegisteredForDate(licence, date)) {
        licences.add(licence);
      }
    }
    return licences;
  }

  public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) throws IllegalArgumentException {
    licence = Parking.standardizeAndValidateLicence(licence);
    TreeSet<LocalDate> reservationDates = parkingInfo.getOrDefault(licence, new TreeSet<>());
    return new ArrayList<>(reservationDates);
  }

  public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {
    licence = Parking.standardizeAndValidateLicence(licence);
    TreeSet<LocalDate> reservationDates = parkingInfo.getOrDefault(licence, new TreeSet<>());
    ArrayList<LocalDate> startDates = new ArrayList<>();
    int index = 0;
    for (LocalDate date : reservationDates) {
      if (index % 3 == 0) {
        startDates.add(date);
      }
      index++;
    }
    return startDates;
  }

}
