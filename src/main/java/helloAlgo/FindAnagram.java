package helloAlgo;

import java.util.*;

import static java.lang.Thread.sleep;

public class FindAnagram {

    public  static void main(String[] args){
        String s  = "hellehoworld"; String p  = "he";
        findAnagrams(s,p);
        Date date = new Date();
// 在循环外部创建Date对象

    getNextWeekDates();
    getNextWeekDate();

    }

    public static List<Date> getNextWeekDates() {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(); // 在循环外部创建Date对象
        for (int i = 0; i < 7; i++) {
            try {
                sleep(1111);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            date.setTime(calendar.getTimeInMillis()); // 复用Date对象
            dates.add(date);
        }
        for (Date date1 : dates) {
            System.out.println(date1.toString()+"outing");
        }

        return dates;
    }

    public static List<Date> getNextWeekDate() {
        List<Date> dates = new ArrayList<>();
        for (int i = 0; i < 7; i++) {

            try {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, i + 1);
                sleep(1000);
                Date date = calendar.getTime(); // 在循环中频繁创建Calendar和Date对象
                dates.add(date);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        for (Date date1 : dates) {
            System.out.println(date1.toString()+"in");
        }
        return dates;
    }
//    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。


        public static List<Integer> findAnagrams(String s, String p) {
            // 用于返回字母异位词的起始索引
            List<Integer> res = new ArrayList<>();
            // 用 map 存储目标值中各个单词出现的次数
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
            // 用另外一个 map 存储滑动窗口中有效字符出现的次数
            HashMap<Character, Integer> window = new HashMap<>();
            int left = 0; // 左指针
            int right = 0; // 右指针
            int valid = p.length(); // 只有当 valid == 0 时，才说明 window 中包含了目标子串
            while (right < s.length()) {
                // 如果目标子串中包含了该字符，才存入 window 中
                if (map.containsKey(s.charAt(right))) {
                    window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                    // 只有当 window 中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                    if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) {
                        valid--;
                    }
                }
                // 如果 window 符合要求，即两个 map 存储的有效字符相同，就可以移动左指针了
                // 但是只有二个map存储的数据完全相同，才可以记录当前的起始索引，也就是left指针所在位置
                while (valid == 0) {
                    if (right - left + 1 == p.length()) res.add(left);
                    // 如果左指针指的是有效字符,需要更改 window 中的 key 对应的 value
                    // 如果 有效字符对应的数量比目标子串少，说明无法匹配了
                    if (map.containsKey(s.charAt(left))) {
                        window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                        if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                            valid++;
                        }
                    }
                    left++;
                }
                right++;
            }
            return res;
        }

}
