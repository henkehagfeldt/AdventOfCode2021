package day4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import utils.Utils;

public class DayFourPartOne {
  public static void main(String... args){
    ArrayList<String> inputData = Utils.readStringFile("src/day4/input.data");

    String randomNumbers = inputData.get(0);
    String[] randomNumbersArray = randomNumbers.split(",");

    ArrayList<Board> bingoBoards = new ArrayList<>();

    // Create the bingo boards
    String[] tempBoard = new String[5];
    int boardIterator = 0;
    for(int n = 2; n < inputData.size(); n++){
      tempBoard[boardIterator++] = inputData.get(n).trim();
      if(boardIterator == 5){
        bingoBoards.add(new Board(tempBoard));
        boardIterator = 0;
        n++;
      }
    }

    // Call the numbers in order
    for(int n = 1; n < randomNumbersArray.length; n++){
      String[] calledNumbers = Arrays.copyOfRange(randomNumbersArray, 0, n);
      for(int b = 0; b < bingoBoards.size(); b++){
        if(bingoBoards.get(b).checkWin(calledNumbers)){
          System.out.format("Winner: board: %d, score: %d", b, bingoBoards.get(b).countValue(calledNumbers));
          return;
        }
      }
    }

    System.out.println("Done");
  }
}
