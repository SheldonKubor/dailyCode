package com.constantine.daily.algorithm;

public class InviteCode {

    public static void main(String[] args) {
        String str = "ahsgdty16253jsht";
        System.out.println(verifyInviteCode(str));
    }


    public static String verifyInviteCode(String str){

        //校验字符串长度
        if(str.length() != 16){
            return "error";
        }

        //校验格式
        String reg = "[a-z0-9]+";
        if(!str.matches(reg)){
            return "error";
        }

        int evenSum = 0;
        int oddSum = 0;
        for(int i=str.length(); i>0; i--){
            char c = str.charAt(i-1);
            //偶数位
            if(i % 2 == 0){

                //偶数位数字先乘以2
                int x = char2num(c) * 2;

                //若乘积为两位数则减去9
                int result = x>10?x-9:x;

                //偶数位求和
                evenSum = evenSum + result;

            } else {

                //奇数位求和
                int x = char2num(c);
                oddSum = oddSum + x;
            }

        }
        if((evenSum+oddSum)%10 == 0){
            return "ok";
        } else {
            return "error";
        }
    }

    //字符转换为数字
    public static int char2num(char c){
        String reg = "[a-z]";
        //如果是字母
        if (String.valueOf(c).matches(reg)) {
            int result = (int) c-96;
            return result>9 ? result%9 : result;
        }
        //如果是数字
        return (int) c-48;
    }
}
