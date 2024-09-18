package mid;

/**
 * 2028. 找出缺失的观测数据
 */
public class MissingRolls {


    public static void main(String[] args) {

    }



    public int[] missingRolls(int[] rolls, int mean, int n) {
        int length = rolls.length;
        int sum = mean * (length + n);
        for (int i : rolls) {
            sum -= i;
        }
        if(sum < n || sum > n * 6){
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sum / n + (i < sum % n ? 1 : 0);
        }
        return res;
    }


}
