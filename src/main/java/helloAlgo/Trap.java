package helloAlgo;

import java.util.Deque;
import java.util.LinkedList;

public class Trap {
//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水

    public int trap(int[] height) {
        int l = 0,r = height.length-1, maxLen = 0,maxRight = 0,count = 0;
        while (l<r){
             maxLen  = Math.max(height[l], maxLen);
             maxRight = Math.max(height[r], maxRight);
             if(height[l] > height[r]){
                   count += maxRight -height[r];
                   r--;
             }else {
                   count += maxLen - height[l];
                   l++;
             }


        }
        return  count;

    }
    public int dequeTrap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < height.length; i++) {
            while(stack.size()!=0&&height[stack.peek()]<height[i]){
                int top = stack.pop();
                if(stack.size()==0)
                    break;
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i],height[stack.peek()] - height[top]);
                ans += distance * bounded_height;
            }
            stack.push(i);
        }
        return ans;



    }



}
