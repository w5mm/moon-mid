package helloAlgo;

public class CountSort {

    public static void main(String[] args) {
        int[] a = {1,13,5,12,12,5,14,3,4,5,6,3,5,6,8,9,9,4};
        countingSort(a);
       for (int i = 0; i < a.length; i++) {
           System.out.printf(a[i] + " ");       }
    }
    public  static  void countingSort (int[] nums) {
        int m =  0;
        for (int i = 0; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }
        int[] counting  = new int[m+1];
        for(int num: nums){
            counting[num] ++;
        }
        for(int i = 0 ;i<m;i++) {
            counting[i+1] += counting[i];
        }
        int n = nums.length;
        int[] result = new int[n];
        for(int i = n-1;i>=0;i--) {
            int num = nums[i];
            result[counting[num] -1] = num;
            counting[num] --;
        }
        for(int i = 0 ;i<n;i++) {
            nums[i] = result[i];
        }



    }
}
