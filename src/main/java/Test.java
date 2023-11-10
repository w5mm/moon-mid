import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {





    public static void main(String[] args) {
        int[] nums = {0,0,0};

        System.out.printf("ss"+threeSum(nums));

    }
    public  static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length-1;
        if(len<2||nums==null)return result;
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            if(nums[i] > 0) break;
            if(i>0&&nums[i]==nums[i-1])continue;
            int l= i+1,r=len;
            while(l<r){
                int sum =  nums[i]+nums[l]+nums[r];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    if(l<r&&nums[r]==nums[r-1])r++;
                    if(l<r&&nums[l+1]==nums[l])l++;
                    l++;
                    r--;

                }else if(sum>0){
                    r--;
                }else{
                    l++;
                }
            }


        }





        return result;
    }
}

