package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOnePartTwo {
  public static void main(String... args){
    ArrayList<Integer> window = new ArrayList<>();

    Integer increases = 0;
    try {
      File myObj = new File("src/input.data");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        Integer dataNumber = Integer.parseInt(data);

        window.add(dataNumber);

        if(window.size() == 4){
          int sumA = window.get(0) + window.get(1) + window.get(2);
          int sumB = window.get(1) + window.get(2) + window.get(3);
          if(sumB > sumA)
            increases += 1;
          window.remove(0);
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    System.out.printf("Result: %d", increases);
  }
}
