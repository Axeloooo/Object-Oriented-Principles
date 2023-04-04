package edu.ucalgary.oop;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Translator {

  private final String languageRegionCode;
  private TranslationText translation;

  public Translator(String languageRegionCode) throws ArgFileNotFoundException, IOException, ClassNotFoundException {
    if (!languageRegionCode.matches("^[a-z]{2}-[A-Z]{2}$")) {
      throw new IllegalArgumentException("Invalid language and region code format");
    }
    this.languageRegionCode = languageRegionCode;
    importTranslation();
  }

  private void importTranslation() throws ArgFileNotFoundException, IOException, ClassNotFoundException {
    String serFileName = languageRegionCode + ".ser";
    File serFile = new File(serFileName);
    if (serFile.exists()) {
      deserialize();
    } else {
      importFromText();
      serialize();
    }
  }

  private void importFromText() throws ArgFileNotFoundException, IOException {
    String txtFileName = languageRegionCode + ".txt";
    File txtFile = new File(txtFileName);

    if (!txtFile.exists()) {
      throw new ArgFileNotFoundException("File not found: " + txtFileName);
    }

    try (Scanner scanner = new Scanner(new FileInputStream(txtFile), StandardCharsets.UTF_8)) {
      List<String> monthsList = new ArrayList<>();
      List<String> daysList = new ArrayList<>();

      for (int i = 0; i < 12; i++) {
        if (scanner.hasNextLine()) {
          monthsList.add(scanner.nextLine());
        }
      }

      for (int i = 0; i < 31; i++) {
        if (scanner.hasNextLine()) {
          daysList.add(scanner.nextLine());
        }
      }

      String sentence = null;
      if (scanner.hasNextLine()) {
        sentence = scanner.nextLine();
      }

      String[] months = monthsList.toArray(new String[0]);
      String[] days = daysList.toArray(new String[0]);

      translation = new TranslationText(months, days, sentence);
    }
  }

  private void serialize() throws IOException {
    String serFileName = languageRegionCode + ".ser";
    File serFile = new File(serFileName);
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFile))) {
      oos.writeObject(translation);
    }
  }

  private void deserialize() throws IOException, ClassNotFoundException {
    String serFileName = languageRegionCode + ".ser";
    File serFile = new File(serFileName);
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFile))) {
      translation = (TranslationText) ois.readObject();
    }
  }

  public TranslationText getTranslation() {
    return translation;
  }

  public String translate(int monthNum, int dayNum, int year) {
    if (monthNum < 1 || monthNum > 12 || dayNum < 1 || dayNum > 31) {
      throw new IllegalArgumentException("Invalid month or day number");
    }

    String month = translation.getMonth(monthNum - 1);
    String day = translation.getDay(dayNum - 1);

    return String.format(translation.getSentence(), day, month, year);
  }
}