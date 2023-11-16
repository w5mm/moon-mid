package helloAlgo;

public class LengthOfLIS {
//    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    public  int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }


            }
            maxLength = Math.max(maxLength,dp[i]);


        }

        return maxLength;
    }


    public int lengthOfSearch(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = 1;
        int[] dp = new int[nums.length+1];
        dp[len]  = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > dp[len]){
                dp[++len] = nums[i];
            }else {

//               找到dp[] 第一个不小于nums[i] 的數然後替換，如果沒有就替換dp[1]
                int left = 1, replace = 0;
                int right = len;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (dp[mid] < nums[i]) {
                        replace = mid;
                        left = mid + 1;

                    } else {
                        right = mid - 1;
                    }
                }
                dp[replace+1] = nums[i];


            }
        }
        return len;

    }

    public static void main(String[] args) {
        LengthOfLIS leaves  = new LengthOfLIS();
        int[] nums = {10,9,2,5,3,7,11,18};
        System.out.println(leaves.lengthOfLIS(nums));

    }




}
