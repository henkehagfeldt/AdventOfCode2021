package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOnePartOne {
  public static void main(String... args){
    Integer lastValue = null;
    Integer increases = 0;
    try {
      File myObj = new File("src/day1/input.data");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        Integer dataNumber = Integer.parseInt(data);
        if(lastValue != null && lastValue < dataNumber)
          increases += 1;
        lastValue = dataNumber;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    System.out.printf("Result: %d", increases);
  }
}
