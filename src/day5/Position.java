package day5;

public class Position {

    Integer x = 0;
    Integer y = 0;
    public Position(Integer tempX, Integer tempY){
       x = tempX;
       y = tempY;
    }

    public Integer getX(){
        return x;
    }

    public Integer getY(){
        return y;
    }

    public void putPoints(Integer tempX, Integer tempY){
        x = tempX;
        y = tempY;
    }

    @Override
    public String toString() {
        return String.format("%d,%d", getX(), getY());
    }

    @Override
    public int hashCode()
    {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        return this.toString().equals(o.toString());
    }

}

