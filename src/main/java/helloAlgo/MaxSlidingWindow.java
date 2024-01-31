package helloAlgo;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
//    你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//    返回 滑动窗口中的最大值

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int left =0 , right = 0,max = Integer.MIN_VALUE;
        while (right < nums.length){
            if(right- left + 1 < k){
                max = Math.max(max, nums[right]);
                res[0] =  max;
                right++;
            }else{
                res[right-k+1] = max(nums, left, right);
                left++;
                right++;
            }
        }
        return res;
    }

    private int max(int[] nums, int left, int right){
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

//    单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer>  res = new LinkedList<>();
        int n = nums.length;
        for(int i = 0; i < k; i++){
            while (!res.isEmpty() && nums[i] >= nums[res.peekLast()]){
                res.pollLast();
            }
            res.offerLast(i);
        }
        int[] result = new int[n-k+1];
        result[0] = nums[res.peekFirst()];
        for(int i = k; i < n; i++){
            while(!res.isEmpty() && nums[i] >= nums[res.peekLast()]){
                res.pollLast();
            }
            res.offerLast(i);
            while(res.peekFirst() <= i - k){
                res.pollFirst();
            }
            result[i-k+1] = nums[res.peekFirst()];

        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new MaxSlidingWindow().maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(res));
    }

}
