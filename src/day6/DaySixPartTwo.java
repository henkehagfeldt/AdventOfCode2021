package day6;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Utils;

public class DaySixPartTwo {

  public static void main(String... args){

    final int DAYS_PASSED = 256;
    long[] fish = parseInput();

    for(int i = 0; i < DAYS_PASSED; i++){
      System.out.format("%d days passed\n", i + 1);

      long newFish = fish[0];
      for(int f = 0; f < 8; f++)
        fish[f] = fish[f + 1];

      fish[6] = fish[6] + newFish;
      fish[8] = newFish;
    }

    long amountOfFish = Arrays.stream(fish)
            .reduce(0, (subTotal, value) -> subTotal + value);

    System.out.format("Fishes %d", amountOfFish);
  }


  public static long[] parseInput(){
    ArrayList<String> inputData = Utils.readStringFile("src/day6/input.data");
    String[] fish = inputData.get(0).split(",");

    long[] resultingFish = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    for(int i = 0; i < fish.length; i++){
      Integer fishValue = Integer.parseInt(fish[i]);
      resultingFish[fishValue] = resultingFish[fishValue] + 1;
    }

    return resultingFish;
  }
}
