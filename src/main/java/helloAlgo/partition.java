package helloAlgo;

public class partition {
    public static void main(String[] args) {
        int[] nums = {1,5,6,3,5332,23,4324,43,2,4};

        partition p = new partition();
        p.quickSort(nums,0,nums.length-1);



        for(int i =0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }

    int quickSort(int[] nums,int left,int right){
        int l =left,r =right;
        while(l<r){
            while(l<r && nums[r]>=nums[l]){
                r--;
            }

            while(l<r && nums[l]<=nums[l+1]){
                l++;
            }
            int temp  = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
        int temp  = nums[left];
        nums[left] = nums[l];
        nums[l] = temp;
        return l;
    }


}
