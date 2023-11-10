import java.util.HashMap;
import java.util.Map;

public class FindAnagrams {

        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map  = new HashMap<>();
            int l = -1,res = 0,len = s.length();
            for(int i = 0;i<len;i++){
                if(map.containsKey(s.charAt(i))){
                    l = Math.max(l,map.get(s.charAt(i)));
                }
                map.put(s.charAt(i),i);
                res = Math.max(res,i-l);
            }
            return res;

        }






}
