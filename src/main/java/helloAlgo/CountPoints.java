package helloAlgo;

import java.util.ArrayList;
import java.util.List;

public class CountPoints {

    String rings  = "R2G3B2R2G3B1R2G1G2G9G2G4";
    public static  int countPoints(String rings) {
        int count = 0;



        return count;
    }
    class Solution {
        public int countPoints(String rings) {
            int n = rings.length() / 2, ans = 0;
            List[] g = new ArrayList[10];
            for (int i = 0; i < 10; i++) g[i] = new ArrayList<Character>();
            for (int i = 0; i < n; i++) g[rings.charAt(2 * i + 1) - '0'].add(rings.charAt(2 * i));
            for (int i = 0; i < 10; i++) if (g[i].contains('R') && g[i].contains('G') && g[i].contains('B')) ans++;
            return ans;
        }
    }
}
