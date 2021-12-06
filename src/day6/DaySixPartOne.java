package day6;

import java.util.ArrayList;
import utils.Utils;

public class DaySixPartOne {

  public static void main(String... args){

    final int DAYS_PASSED = 10;

    ArrayList<Lanternfish> fish = parseInput();

    for(int i = 0; i < DAYS_PASSED; i++){
      System.out.format("%d days passed\n", i + 1);
      long amountNewFish = fish.stream().map(f -> f.progress())
              .filter(spawn -> spawn == true)
              .count();

      for(int n = 0; n < amountNewFish; n++){
        Lanternfish newFish = new Lanternfish(8);
        fish.add(newFish);
      }
    }


    System.out.format("Fishes %d", fish.size());
  }


  public static ArrayList<Lanternfish> parseInput(){
    ArrayList<String> inputData = Utils.readStringFile("src/day6/input.data");
    String[] fish = inputData.get(0).split(",");

    ArrayList<Lanternfish> resultingFish= new ArrayList<>();

    for(int i = 0; i < fish.length; i++){
      Lanternfish tempFish = new Lanternfish(Integer.parseInt(fish[i]));
      resultingFish.add(tempFish);
    }

    return resultingFish;
  }
}
