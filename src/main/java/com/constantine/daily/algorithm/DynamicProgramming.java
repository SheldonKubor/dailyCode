package com.constantine.daily.algorithm;

public class DynamicProgramming {


    public static void main(String[] args){

        int num = 5; //11111 122 2111 5

//        int[] m = {1, 2, 5, 10}; // 保存基本面额的数组
//        long[] data = new long[num+1]; // 保存计算数据的数组
//        for(int i = 0; i <= num; i++) { // 边界条件A(n,1) = 1 (n>=0)
//            data[i] = 1;
//        }
//        for(int i = 1; i < 4; i++) // 基本面额从2开始，因为1元情况在数组初始化时已经写入了
//            for(int n = 1; n <= num; n++) // n从1开始，保证了边界条件A(0,m)=1 (m=1，2，5，10)
//                if(n >= m[i])
//                    data[n] += data[n - m[i]]; // 状态转移方程
        //System.out.println(data[num]);

    }

    public static int count(int n,int m){
        int[] a = {1, 2, 5, 10};// 保存基本面额的数组
        long[] data = new long[m+1]; // 保存计算数据的数组
        if(n*10 < m){
            return 0;
        }

        for(int i = 0; i <= m; i++) { // 边界条件A(n,1) = 1 (n>=0)
            data[i] = 1;
        }

        for(int i = 1; i < 4; i++) // 基本面额从2开始，因为1元情况在数组初始化时已经写入了
            for(int j = 1; n <= m; n++) // n从1开始，保证了边界条件A(0,m)=1 (m=1，2，5，10)
                if(j >= a[i])
                    data[j] += data[n - a[i]]; // 状态转移方程

        return 0;
    }
}
