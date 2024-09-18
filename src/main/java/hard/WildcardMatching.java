package hard;

public class WildcardMatching {
    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
     *
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     */

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] res = new boolean[m + 1][n + 1];
        res[0][0]  = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                res[0][i] = true;
            } else {
                break;
            }
        }

        for(int i = 1;i<=m;i++){
            for (int j  = 1;j<= n;j++){
                if(p.charAt(j-1) == '*'){
                    res[i][j] =res[i][j-1]||(i>0&&res[i-1][j]);
                }else  if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                    res[i][j] = res[i-1][j-1];
                }
            }
        }

        return res[m][n];

    }

    //方法二
  
        public boolean isMatch2(String s, String p) {
            char[] ss = s.toCharArray();
            char[] ps = p.toCharArray();
            int m=ps.length, n=ss.length;
            int idx1=0, idx2=0, start=-1;
            while (idx2<n){
                if (idx1<m && (ps[idx1]==ss[idx2]||ps[idx1]=='?')){
                    idx1 ++;
                    idx2 ++;
                }else if (idx1<m && ps[idx1]=='*'){
                    start = idx1;
                    idx1 ++;
                }else if (start!=-1){
                    idx2 = idx2-(idx1-start-1)+1;
                    idx1 = start+1;
                }else return false;
            }
            while (idx1<m && ps[idx1]=='*') idx1++;
            return idx1==m? true:false;
        }


}
