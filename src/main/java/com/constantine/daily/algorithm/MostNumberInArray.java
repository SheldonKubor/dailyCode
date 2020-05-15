package com.constantine.daily.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中的众数
 */
public class MostNumberInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5,5,6};
        int result = find(arr);
        System.out.println(result);
    }

    public static int find(int[] arr){

        //借助hashmap
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int count = map.get(arr[i]);
                count++;
                map.put(arr[i],count);
            } else {
                map.put(arr[i],1);
            }
        }

        System.out.println(map.toString());

        //找出value最大的key
        int max = 0;
        int key = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        return key;
    }
}
