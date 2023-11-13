package helloAlgo;

import java.util.*;

public class MaxKelements {

    public static void main(String[] args) {
        int[] elements ={1,10,3,3,3};


       maxKelement(elements,5);

    }

    public static  long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer>  maxQueue = new PriorityQueue<>((a,b) -> b-a);
        for (int num: nums
             ) {
            maxQueue.offer(num);

        }
        long res = 0;
        for(int i=0; i<k; i++) {
            int maxNum =  maxQueue.poll();
            res+=maxNum;
            maxQueue.offer((maxNum+2)/3);
        }
        System.out.printf("res: %d",res);
        return res;


    }
    public static long maxKelement(int[] nums,int k){
        Arrays.sort(nums);
        Deque<Integer> deque  =new LinkedList<Integer>();
        int n  = nums.length-1;long res = 0;
        while(k-->0){
            if( n  == nums.length-1) {
                res+=nums[n];
                deque.add((nums[n]+2)/3);
                n--;

            }else if(n>-1&&nums[n]>deque.peekFirst()){
                res+= nums[n];
                n--;
                deque.add((nums[n]+2)/3);
            }else {
                int d =deque.pollFirst();
                res+= d;
                deque.add((d+2)/3);

            }

        }
        System.out.printf("result %d\n", res);
        return res;



    }



}
