package day2;

import java.util.ArrayList;
import utils.Utils;

public class DayTwoPartOne {
  public static void main(String... args){
    ArrayList<String> inputData = Utils.readStringFile("src/day2/input.data");

    int horizontalPosition = 0;
    int verticalPosition = 0;

    for(int i = 0; i < inputData.size(); i++){
      String action = inputData.get(i).split(" ")[0];
      Integer value = Integer.parseInt(inputData.get(i).split(" ")[1]);

      if(action.equals("forward"))
        horizontalPosition += value;
      else if(action.equals("up"))
        verticalPosition -= value;
      else if(action.equals("down"))
        verticalPosition += value;
    }

    System.out.printf("Result: %d", horizontalPosition*verticalPosition);
  }
}
