import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        int[] left = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<n; i++) {
            while( !stack.isEmpty() && a[stack.peek()] >= a[i] )
                stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1; i>=0; i--) {
            while( !stack.isEmpty() && a[stack.peek()] >= a[i] )
                stack.pop();
            int right = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
            
            int windowSize = right-left[i]-2;
            ans[windowSize] = Math.max(ans[windowSize], a[i]);
        }
        
        for(int i=n-2; i>=0; i--) {
             ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }
}
/*
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] ans = new int[n];
        int[] mins = new int[n];
        Arrays.fill(mins, Integer.MAX_VALUE);
        
        for(int window=0; window<n; window++) {
            int max = Integer.MIN_VALUE;
            for(int i=window; i<n; i++) {
                int winStart = i - window;
                mins[winStart] = Math.min(mins[winStart], a[i]);                
                max = Math.max(max, mins[winStart]);
            }
            ans[window] = max;
        }
        return ans;
    }
}*/

