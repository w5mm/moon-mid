package helloAlgo;

public class TheLongestBalancedSubstring {
    public static void main(String[] args) {
        System.out.printf(" 123123");
        String s =  "010001110101010101";
        System.out.printf("ss====="   + findTheLongestBalancedSubstring(s));
    }
//    最长平衡子字符串

    public static  int findTheLongestBalancedSubstring(String s) {
        int len = s.length(),maxlen =  0,ind =0;
        while(ind < len){
            int count0  = 0,count1 = 0;
            while(s.charAt(ind) == '0'&&ind<len){
                count0++;
                ind++;
            }
            while (ind<len&&s.charAt(ind) == '1'){
                count1++;
                ind++;
            }
            maxlen =  Math.max(Math.min(count0,count1)*2,maxlen);
        }
        return maxlen;

    }
}
