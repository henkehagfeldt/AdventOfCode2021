package day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import utils.Utils;

public class DayFivePartTwo {
  public static void main(String... args){

    ArrayList<Line> lines = parseInput();
    HashMap<Position, Integer> dangerousSpots = new HashMap<>();

    for(int i = 0; i < lines.size(); i++){
      Line l = lines.get(i);

      boolean doneApproaching = false;
      Position nextPosition = l.getP1();

      while(!doneApproaching){

        if(nextPosition.equals(l.getP2()))
          doneApproaching = true;

        if(dangerousSpots.containsKey(nextPosition))
          dangerousSpots.replace(nextPosition, dangerousSpots.get(nextPosition) + 1);
        else
          dangerousSpots.put(nextPosition, 1);

        nextPosition = approachPoint(nextPosition, l.getP2());
      }
    }

    long veryMuchDanger = numberOfDangerspots(dangerousSpots);

    System.out.format("Dangerspots %d", veryMuchDanger);
  }

  public static long numberOfDangerspots(HashMap<Position, Integer> spots){
    return spots.values().stream()
            .filter(x -> x >= 2)
            .count();
  }

  public static Position approachPoint(Position source, Position target){
    Integer resultX = source.getX();
    Integer resultY = source.getY();

    if(source.getX() < target.getX())
      resultX += 1;
    else if(source.getX() > target.getX())
      resultX -= 1;

    if(source.getY() < target.getY())
      resultY += 1;
    else if(source.getY() > target.getY())
      resultY -= 1;

    return new Position(resultX, resultY);
  }

  public static ArrayList<Line> parseInput(){
    ArrayList<String> inputData = Utils.readStringFile("src/day5/input.data");
    ArrayList<Line> parseLines = new ArrayList<>();

    for(int i = 0; i < inputData.size(); i++){
      String[] points = inputData.get(i).split(" -> ");
      Line l = new Line(points[0], points[1]);
      parseLines.add(l);
    }

    return parseLines;
  }
}
