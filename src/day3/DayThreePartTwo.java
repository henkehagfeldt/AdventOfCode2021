package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import utils.Utils;

public class DayThreePartTwo {
  public static void main(String... args){
    ArrayList<String> inputData = Utils.readStringFile("src/day3/input.data");


    ArrayList<String> oxygenGeneratorRating = new ArrayList<>();
    oxygenGeneratorRating.addAll(inputData);

    ArrayList<String> co2ScrubberRating = new ArrayList<>();
    co2ScrubberRating.addAll(inputData);


    for(int n = 0; n < 12; n++){
      ArrayList<String> keepOnesGenerator = new ArrayList<>();
      ArrayList<String> keepZeroesGenerator = new ArrayList<>();

      for(int m = 0; m < oxygenGeneratorRating.size(); m++) {

        String currentData = oxygenGeneratorRating.get(m);
        char currentNumber = currentData.charAt(n);
        if (currentNumber == '1') {
          keepOnesGenerator.add(currentData);
        }
        else if(currentNumber == '0') {
          keepZeroesGenerator.add(currentData);
        }

      }

      if(keepOnesGenerator.size() >= keepZeroesGenerator.size()){
        oxygenGeneratorRating.clear();
        oxygenGeneratorRating.addAll(keepOnesGenerator);
      }
      else{
        oxygenGeneratorRating.clear();
        oxygenGeneratorRating.addAll(keepZeroesGenerator);
      }

      if(oxygenGeneratorRating.size() == 1)
        break;
    }

    for(int n = 0; n < 12; n++){
      ArrayList<String> keepOnesScrubber = new ArrayList<>();
      ArrayList<String> keepZeroesScrubber = new ArrayList<>();

      for(int m = 0; m < co2ScrubberRating.size(); m++) {

        String currentData = co2ScrubberRating.get(m);
        char currentNumber = currentData.charAt(n);
        if (currentNumber == '1') {
          keepOnesScrubber.add(currentData);
        }
        else if(currentNumber == '0') {
          keepZeroesScrubber.add(currentData);
        }

      }

      if(keepOnesScrubber.size() >= keepZeroesScrubber.size()){
        co2ScrubberRating.clear();
        co2ScrubberRating.addAll(keepZeroesScrubber);
      }
      else{
        co2ScrubberRating.clear();
        co2ScrubberRating.addAll(keepOnesScrubber);
      }

      if(co2ScrubberRating.size() == 1)
        break;
    }

    Integer generatorRating = Integer.parseInt(oxygenGeneratorRating.get(0), 2);
    Integer scrubberRating = Integer.parseInt(co2ScrubberRating.get(0), 2);

    System.out.printf("Result: %d", generatorRating*scrubberRating);

  }
}
