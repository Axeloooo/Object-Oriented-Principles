package edu.ucalgary.oop;

import java.io.IOException;

public class DayMemory {
  public static void main(String[] args) {
    try {
      checkCommandLineArgument(args);
      String languageRegionCode = args[0];
      Translator translator = new Translator(languageRegionCode);

      String translatedSentence = translator.translate(10, 11, -200);
      System.out.println(translatedSentence);

    } catch (IOException e) {
      System.err.println("Error processing file: " + e.getMessage());
      System.exit(1);

    } catch (ClassNotFoundException e) {
      System.err.println("Error deserializing file: " + e.getMessage());
      System.exit(1);

    } catch (ArgFileNotFoundException | CommandArgumentNotProvidedException | IllegalArgumentException e) {
      System.err.println(e.getMessage());
      System.exit(1);

    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);

    }
  }

  private static void checkCommandLineArgument(String[] args) throws CommandArgumentNotProvidedException {
    if (args.length < 1) {
      throw new CommandArgumentNotProvidedException("Command-line argument not provided.");
    }
  }
}