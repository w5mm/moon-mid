package easy;

import java.util.HashMap;
import java.util.Map;

public class repeatedSubstringPattern {
    public static void main(String[] args) {
        String s= "ababab";
       boolean b = repeatedSubstringPattern(s);
        System.out.printf("b = %b",b);

    }

    public  static boolean repeatedSubstringPattern(String s) {
        int  n = s.length();
        int  s1 = s.charAt(0)-'0';
        for(int i=0;i<n-1;i++){

            int s2 = s.charAt(i+1)-'0';

            s1= s1^s2;
            Map<Integer,Integer> map = new HashMap<>();
            map.put(s1,1);


        }


        return s1==0;
    }
}
