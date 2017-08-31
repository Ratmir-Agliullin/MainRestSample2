package models;

import java.util.Random;

public class RandomNumber {



    public String newNumber(int limit){
        Random random = new Random();
        Random rand=new Random();
        Integer a = rand.nextInt(limit);
        return a.toString();
    }

}
