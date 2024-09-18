package easy;

import java.util.Arrays;
import java.util.List;

public class wordPattern {
    public static void main(String[] args) {

        wordPattern wordPattern = new wordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
    }

    boolean wordPattern(String pattern, String s) {

        List<String> words = Arrays.asList(s.split(" "));
        if (pattern.length() != words.size()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.indexOf(pattern.charAt(i)) != words.indexOf(words.get(i))) {
                pattern.indexOf(pattern.charAt(i));
                words.indexOf(words.get(i));
                return false;
            }
        }
        return true;

    }
}
