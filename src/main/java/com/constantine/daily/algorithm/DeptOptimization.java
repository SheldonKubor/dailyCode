package com.constantine.daily.algorithm;

public class DeptOptimization {
    public static void main(String[] args) {
        int [] init = {10,7,5,4};

        //十年每月分配一次人员
        for(int i = 1; i < 13; i++){
            int index = find(init);
            System.out.println(index);
            assign(init,index);
            for(int x : init){
                System.out.print(x);
            }
            System.out.println("");
        }

    }

    //找出最大值下标
    public static int find(int[] arr){

        int max = -1;
        int index = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    //分配人员
    public static void assign(int[] arr,int index){
        for(int i = 0; i < arr.length; i++){
            if(i == index){
                arr[i] = arr[i] - 3;
            } else {
                arr[i] = arr[i] + 1;
            }
        }
    }
}
