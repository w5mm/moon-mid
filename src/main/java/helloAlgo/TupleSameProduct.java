package helloAlgo;

import java.util.HashMap;

public class TupleSameProduct {


    public static void main(String[] args) {
        int [] nums = {1,2,4,5,10};
        tupleSameProduct(nums);

    }
    public static int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> product = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length;j++){
                int ket = nums[j]*nums[i];
                product.put(ket,( product.getOrDefault(ket, 0)  + 1));
            }
        }
        for (int  value:product.values()) {
            res+=(value-1)*value*4;

        }
        System.out.printf("result = %d\n", res);
        return res;

    }

}
