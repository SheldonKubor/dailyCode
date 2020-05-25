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

        System.out.println(fib(6));
        System.out.println(climb(10));
        System.out.println(climb(10));

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

    public static int fib(int n){
        int [] dp = new int[n+1]; //定义一个数组，用来记录小问题求解的每一步结果，为了方便，dp[0]不存放数据

        // 按照状态转移方程来编写的代码
        if(n == 1 || n == 2){
            return 1;
        }

        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    public static int climb(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climb(n - 1) + climb(n - 2);

    }

    public static int climb2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int [] dp = new int[n+1]; //同样，定义一个数组，用来记录小问题求解的每一步结果，为了方便，dp[0]不存放数据
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2]; //状态转移方程
        }
        return dp[n];
    }
}
