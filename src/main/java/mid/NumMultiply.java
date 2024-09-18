package mid;
/**
 *
 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class NumMultiply {


    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            if (!(sb.length() == 0 && i == 0)) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
