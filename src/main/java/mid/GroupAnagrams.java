package mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 49
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,List<String>> map = new HashMap<>();
         for(String str:strs){
             int[] keys  = new int[26];
             for(int i = 0;i<str.length();i++){
                 keys[str.charAt(i)-'a']++;
             }
             StringBuffer sb =  new StringBuffer();

             for(int j = 0;j<26;j++){
                 if(keys[j]>0){
                     sb.append(keys[j]);
                     sb.append('a'+keys[j]);
                 }


             }
             String key  =sb.toString();
             List<String> list =  map.getOrDefault(key,new ArrayList<>());
             list.add(str);
             map.put(key,list);


         }
         return  new ArrayList<List<String>>(map.values());





    }

}
