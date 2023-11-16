package helloAlgo;

import java.util.List;

public class WordBreak {
//    给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <=s.length(); i++){
            for (int j = 0; j<i; j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }
        }






        return dp[s.length()];
    }
}
