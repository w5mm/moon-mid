package hard.dynamicProgramming;

import java.util.Arrays;

/**
 * 2376. 统计特殊整数
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 *
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 *
 */
public class CountSpecialNumbers {

    //时间复杂度O(n^2) 超时
    public int countSpecialNumbers1(int n) {
        int ans = 0;
        for(int i = 1;i<=n;i++){
            boolean flag = true;
            int t = i;
            int[] cnt = new int[10];
            while(t!=0){
                int x = t%10;
                cnt[x]++;
                if(cnt[x]>1){
                    flag = false;
                    break;
                }
                t/=10;
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    }

    //数位dp
    public int countSpecialNumbers2(int n) {
        char[] s = Integer.toString(n).toCharArray();
        int m = s.length;
        int[][] dp = new int[m][1<<10];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }


        return dfs(0,0,true,true,s,dp);
    }
    private int dfs(int i,int mask,boolean isLimit,boolean isNum,char[] s,int[][] dp){
        if(i==s.length){
            return isNum?1:0;
        }
        if(!isLimit&&isNum&&dp[i][mask]>=0){
            return dp[i][mask];
        }
        int res = 0;
        if(!isNum){
            res = dfs(i+1,mask,false,false,s,dp);
        }

        int up = isLimit?s[i]:9;
        for(int d = 0;d<=up;d++){
            if((mask>>d&1)==0){
                res += dfs(i+1,mask|(1<<d),isLimit&&d==up,true,s,dp);
            }
        }

        if(!isLimit&&isNum){
            dp[i][mask] = res;
        }
        return res;
    }

}
