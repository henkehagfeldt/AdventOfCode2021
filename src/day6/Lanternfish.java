package day6;

public class Lanternfish {

    private Integer daysToSpawn = 0;

    public Lanternfish(Integer daysToSpawn_){
        daysToSpawn = daysToSpawn_;
    }

    public boolean progress(){
        if(daysToSpawn.equals(0)){
            daysToSpawn = 6;
            return true;
        }
        else{
            daysToSpawn -= 1;
            return false;
        }
    }
}
