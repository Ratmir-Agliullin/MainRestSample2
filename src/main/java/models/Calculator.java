package models;

import java.io.IOException;

public class Calculator {
    public static int getNewCalc(int min,int max){
        int res=0;
        try {
            res= min+Handler.getRandomNumber(max-min);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(getNewCalc(2, 8));
    }
}
