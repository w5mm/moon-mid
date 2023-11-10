package helloAlgo;

import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxArea {



    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int m  =  horizontalCuts.length, n = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(horizontalCuts[0], h-horizontalCuts[m-1]), maxW = Math.max(verticalCuts[0], w-verticalCuts[n-1]);
        for(int i = 1; i < m; i++) { maxH = Math.max(maxH, horizontalCuts[i]-horizontalCuts[i-1]);}
        for(int i = 1; i < n; i++) { maxW = Math.max(maxW, verticalCuts[i]-verticalCuts[i-1]);}
        return
            (int) (maxH * maxW)%1000000007;


    }



}

