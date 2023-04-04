package edu.ucalgary.oop;

public class Pet {
  private final String NAME;
  private final String SPECIES;
  private final String BREED;
  private final String COLOUR;
  private Boolean vaccineStatus = false;
  private Client owner;
  private EmergVet vet;
  private CareProfile care;

  public Pet(String name, String species, String breed, String colour, Client owner) {
    this.NAME = name;
    this.SPECIES = species;
    this.BREED = breed;
    this.COLOUR = colour;
    this.owner = owner;
  }

  public void setVet(EmergVet vet) {
    this.vet = vet;
  }

  public EmergVet getVet() {
    return this.vet;
  }

  public void updateVaccineStatus(Boolean change) {
    this.vaccineStatus = change;
  }

  public Boolean getVaccineStatus() {
    return this.vaccineStatus;
  }

  public void setCare(String[] meds, String medInstr, String feedingInstr) {
    this.care = new CareProfile(meds, medInstr, feedingInstr);
  }

  public String getCareSummary() {
    return "Care for " + getName() + ":\n" + care.summarizeCareInstructions();
  }

  public Client getOwner() {
    return this.owner;
  }

  public void setOwner(Client updateOwner) {
    this.owner = updateOwner;
  }

  public String getName() {
    return this.NAME;
  }

  public String getSpecies() {
    return this.SPECIES;
  }

  public String getBreed() {
    return this.BREED;
  }

  public String getColour() {
    return this.COLOUR;
  }
}
