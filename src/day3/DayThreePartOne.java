package day3;

import java.util.ArrayList;
import utils.Utils;

public class DayThreePartOne {
  public static void main(String... args){
    ArrayList<String> inputData = Utils.readStringFile("src/day3/input.data");

    // Most common bits in each position
    int gammaRate = 0;
    for(int n = 0; n < 12; n++){
      int zeroes = 0;
      int ones = 0;
      for(int m = 0; m < inputData.size(); m++){

        String currentData = inputData.get(m);
        char currentNumber = currentData.charAt(n);
        if(currentNumber == '1')
          ones += 1;
        else if(currentNumber == '0')
          zeroes += 1;

      }

      if(ones > zeroes)
        gammaRate += Math.pow(2, 11-n);
    }


    double epsilonRate = 4095-gammaRate;
    System.out.printf("Result: ");
    double result = gammaRate*epsilonRate;
    System.out.println(result);
  }
}
