package day5;

public class Line {

    Position p1 = new Position(0, 0);
    Position p2 = new Position(0, 0);

    public Line(String stringPoint1, String stringPoint2){
        Integer x1 = Integer.parseInt(stringPoint1.split(",")[0]);
        Integer y1 = Integer.parseInt(stringPoint1.split(",")[1]);
        p1.putPoints(x1, y1);

        Integer x2 = Integer.parseInt(stringPoint2.split(",")[0]);
        Integer y2 = Integer.parseInt(stringPoint2.split(",")[1]);
        p2.putPoints(x2, y2);

    }

    public Position getP1(){
        return p1;
    }

    public Position getP2(){
        return p2;
    }

    public Integer getX1(){
        return p1.getX();
    }

    public Integer getY1(){
        return p1.getY();
    }

    public Integer getX2(){
        return p2.getX();
    }

    public Integer getY2(){
        return p2.getY();
    }

    public boolean isHorizontalorDiagonal(){
        return (p1.getX().equals(p2.getX())) || (p1.getY().equals(p2.getY()));
    }

    @Override
    public String toString() {
        return String.format("%d,%d => %d,%d", p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    @Override
    public int hashCode()
    {
        String ref = this.toString();
        return ref.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        return this.toString().equals(o.toString());
    }
}
