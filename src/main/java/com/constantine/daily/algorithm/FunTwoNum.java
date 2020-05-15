package com.constantine.daily.algorithm;

public class FunTwoNum {
    public static void main(String[] args) {
        for(int a = 1; a < 10; a++){
            for(int b = 1; b < 10; b++){
                for(int c = 1; c < 10; c++){
                    for(int d = 1; d < 10; d++){
                        if(a*c == b*d && a != b && c != d){
                            System.out.print(a+""+b);
                            System.out.println(c+""+d);
                        }
                    }
                }
            }
        }
    }
}
