package mid;
/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RightRotate {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[n];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];

        }
        for(int j = 0; j < n - k; j++){
            temp[k + j] = nums[j];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
        for(int i = 0; i < n; i++){
            System.out.printf(temp[i] + "  ");
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        new RightRotate().rotate(nums, k);
    }


}
