public class Rob4 {


    public static void main(String[] args) {
        int[] nums =  { 1,2,35,33,0,0};

        System.out.printf("MAX: %d\n", rob(nums));

    }
    public static int rob( int[] nums){

        int  p = 0, q= 0,result  = 0;
        for( int i=0; i<nums.length; i++){
             result =  Math.max(result,p+nums[i]);
             p = q;
             q = result;

        }






       return result ;
    }


}
