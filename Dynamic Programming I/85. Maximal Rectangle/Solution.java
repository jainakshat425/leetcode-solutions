class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        int[] heights = new int[n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( matrix[i][j] == '0' )
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            ans = Math.max(ans, largestHistogramArea(heights, n));
        }
        return ans;
    }
    
    private int largestHistogramArea(int[] heights, int n) {
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        
        for(int i=0; i<=n; i++) {
            
            while( !stack.isEmpty() && ( i == n || heights[i] < heights[stack.peek()])) {
                int h = heights[stack.pop()];
                int w = i - (stack.isEmpty() ? -1 : stack.peek()) - 1;
                
                maxArea = Math.max(maxArea, h * w);
            }
            
            if( i < n )
                stack.push(i);
        }
        return maxArea;
    }
}
