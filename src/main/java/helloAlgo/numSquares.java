package helloAlgo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class numSquares {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int n  = 32;

        System.out.printf("coins: %d\n",   coinChange(coins, n));






    }

    public  static  int  numSquares(int n){
        int[] res=  new int[n+1];
        for(int i=1; i<=n; i++){
            int temp = Integer.MAX_VALUE;
            for(int j= 1;j*j<=i;j++){
                temp = Math.min(temp, res[i-j*j]);
            }
            res[i] = temp+1;        }


        return res[n];

    }

    public static int coinChange(int[] coins, int amount) {
        int  n =coins.length,Max = amount +1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Max);
        dp[0] =0;
        for (int i = 1; i <= n; i++){
            for(int j  = 1; j <= amount; j++){
                if(coins[i-1]>j){
                    dp[j] = dp[j];
                }else{
                    dp[j] = Math.min(dp[j],dp[j-coins[i-1]]+1);
                }

            }
        }



        return dp[amount] != Max ? dp[amount] : -1;

    }
}
