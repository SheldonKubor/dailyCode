package com.constantine.daily.algorithm;

/**
 * 找出数组中最大的数
 * 时间复杂度O(n)
 */
public class MaxNumberInArray {

    public static void main(String[] args) {
        int[] arr = {1,24,54,234,66,77,34};

        int max = find(arr);


        System.out.println(max);
    }

    public static int find(int[] arr){

        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

}
