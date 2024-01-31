package easy;

import java.util.HashSet;
import java.util.Set;

public class DistinctDifferenceArray {
    /**
     *nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
     *返回 nums 的 不同元素数目差 数组
     */
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] last = new int[n+1];
        for(int i = n-1 ;i>=0;i--){
            set.add(nums[i]);
            last[i]  =  set.size();
        }
        int[] res = new int[n];
        set.clear();

        for (int j = 0 ; j < n; j++) {
            set.add(nums[j]);
            res[j] = set.size() - last[j+1];
        }
        return res;


    }

}
