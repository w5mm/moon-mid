package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SeePersonsCount {
    public int[] canSeePersonsCount(int[] heights) {
        int n =  heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                result[i]++;
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[i]++;
            }
            stack.push(heights[i]);

        }
        return result;

    }
}
