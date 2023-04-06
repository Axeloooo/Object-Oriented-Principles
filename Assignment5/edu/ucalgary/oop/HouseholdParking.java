/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.*;

public class HouseholdParking extends CalgaryProperty {
    private int maxLicences = 3;
    private String residentLicence = "";

    private VisitorParking visitorParking = new VisitorParking();

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode,
            String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber, zoning, streetName, buildingNumber, postCode, buildingAnnex);
    }

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode)
            throws IllegalArgumentException {
        super(taxRollNumber, zoning, streetName, buildingNumber, postCode);
    }

    /*
     * Add a licence to the first empty spot in residentLicence, or replace the most
     * recent
     * Ignore if the licence is already stored
     * 
     * @param licence - The licence plate to be added
     * 
     * @throws IllegalArgumentException if licence plate isn't a valid Alberta
     * licence
     */
    public void addOrReplaceResidentLicence(String licence) throws IllegalArgumentException {
        licence = Parking.standardizeAndValidateLicence(licence);
        int len = residentLicence.length();
        if (residentLicence.equals(licence)) {
            return;
        }
        if (len < maxLicences) {
            residentLicence = licence;
        } else {
            this.residentLicence = licence;
        }
    }

    /*
     * Remove all listed licences
     * 
     * @return whether the operation succeeded or not
     */
    public boolean removeResidentLicence() {
        this.residentLicence = "";
        return true;
    }

    /*
     * Remove a specific listed licence
     * 
     * @param licence - the licence to be removed
     * 
     * @return whether the operation succeeded or not
     */
    public boolean removeResidentLicence(String licence) throws IllegalArgumentException {
        try {
            licence = Parking.standardizeAndValidateLicence(licence);
        } catch (Exception e) {
            return false;
        }

        if (licence.equals(this.residentLicence)) {
            this.residentLicence = "";
            return true;
        }

        return false;
    }

    /*
     * Get all the licences stored for the resident
     * 
     * @return An array containing the resident's licences
     */
    public String getResidentLicence() {
        return this.residentLicence;
    }

    public VisitorParking getVisitors() {
        return this.visitorParking;
    }

    public void addVisitorReservation(String licence) {
        this.visitorParking.addVisitorReservation(licence);
    }

    public void addVisitorReservation(String licence, LocalDate date) {
        this.visitorParking.addVisitorReservation(licence, date);
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(this.visitorParking.getLicencesRegisteredForDate());
        return result;
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate commonDate) {
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(this.visitorParking.getLicencesRegisteredForDate(commonDate));
        return result;
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        if (this.residentLicence.equals(licence)) {
            return true;
        }
        return this.visitorParking.licenceIsRegisteredForDate(licence);
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate commonDate) {
        if (this.residentLicence.equals(licence)) {
            return true;
        }
        return this.visitorParking.licenceIsRegisteredForDate(licence, commonDate);
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) {
        ArrayList<LocalDate> result = new ArrayList<LocalDate>();
        if (this.residentLicence.equals(licence)) {
            result.addAll(this.visitorParking.getAllDaysLicenceIsRegistered(licence));
            return result;
        }
        return this.visitorParking.getAllDaysLicenceIsRegistered(licence);
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {
        ArrayList<LocalDate> result = new ArrayList<LocalDate>();
        if (this.residentLicence.equals(licence)) {
            result.addAll(this.visitorParking.getStartDaysLicenceIsRegistered(licence));
            return result;
        }
        return this.visitorParking.getStartDaysLicenceIsRegistered(licence);
    }
}
