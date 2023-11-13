package helloAlgo;

public class InsertionSort {

    int[] indices =  {1,5,6,3,5332,23,4324,43,2,4};
    public void insertionSort(int[] nums) {
        for(int  i =1 ;i<=nums.length;i++)  {
            int j = i-1;
            while(j>=0 && nums[j]>nums[j+1]) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                j--;
            }
        }

    }
}
