package helloAlgo;

import java.util.HashMap;
import java.util.Map;

public class MaxProduct {
//    给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
         MaxProduct max = new MaxProduct();
         int a = max.maxProduct(words);
        System.out.printf("a = %d\n", a);

    }

    public  int maxProduct(String[] words) {




        int max = 0;
        int[] bit =  new int[words.length];
        for(int i = 0; i < words.length; i++){
            String word  = words[i];
            int len = word.length();
            for(int j = 0; j < len; j++){
                bit[i] |= 1 <<(word.charAt(j) -'a')    ;        }
        }

        for(int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((bit[i]&bit[j])==0) {
                    int temp = words[i].length() * words[j].length();
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;

    }


}
