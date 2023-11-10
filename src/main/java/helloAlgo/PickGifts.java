package helloAlgo;

import java.util.Arrays;

public class PickGifts {
    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};

        System.out.printf(" pick    "+   pickGifts(gifts,4) );
    }

    public static long pickGifts(int[] gifts, int k) {
        int index = gifts.length - 1;long count = 0;
        for(int i = 1 ; i <= k ; i++) {
            Arrays.sort(gifts);
            gifts[index] =  (int)Math.sqrt(gifts[index]);

        }
        for(int i = 0 ; i <= index ; i++) {
            count+=gifts[i];        }
        return count;

    }
}
