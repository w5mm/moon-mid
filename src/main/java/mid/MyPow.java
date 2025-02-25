package mid;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm;

/**
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * 时间复杂度O(logn)
 * @time 2025-02-25
 */
public class MyPow {
   /**
    * @Author: Ming
    * @DateTime: 2025-02-25
    * @Description: 快速幂+递归
    */
    public double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * @Author: Ming
     * @DateTime: 2025-02-25
     * @Description: 迭代
     */
    public double myPow2(double x, int n) {
        long N = n;
        double res = 1.0;
        while (N != 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1 / res : res;
    }
}
