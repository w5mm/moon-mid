package helloAlgo;

public class numRollsToTarget {
    static final int MOD  = 1000000007;



    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0; // 无法组成 target
        }
        final int MOD = 1_000_000_007;
        long[] f = new long[target - n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int mx = Math.min(i * (k - 1), target - n); // i 个骰子至多掷出 i*(k-1)
            for (int j = 1; j <= mx; j++) {
                f[j] += f[j - 1]; // 原地计算 f 的前缀和
            }
            for (int j = mx; j >= k; j--) {
                f[j] = (f[j] - f[j - k]) % MOD; // f[j] 是两个前缀和的差
            }
        }
        return (int) f[target - n];
    }
}
