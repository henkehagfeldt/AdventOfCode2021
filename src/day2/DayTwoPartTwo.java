package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import utils.Utils;

public class DayTwoPartTwo {
  public static void main(String... args){
    ArrayList<String> inputData = Utils.readStringFile("src/day2/input.data");

    int horizontalPosition = 0;
    int depth = 0;
    int aim = 0;

    for(int i = 0; i < inputData.size(); i++){
      String action = inputData.get(i).split(" ")[0];
      Integer value = Integer.parseInt(inputData.get(i).split(" ")[1]);

      if(action.equals("forward")) {
        horizontalPosition += value;
        depth += aim*value;
      }
      else if(action.equals("up")) {
        aim -= value;
      }
      else if(action.equals("down")) {
        aim += value;
      }
    }

    System.out.printf("Result: %d", horizontalPosition*depth);

  }
}
