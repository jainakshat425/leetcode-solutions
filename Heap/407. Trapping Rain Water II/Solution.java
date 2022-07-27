class Solution {
    public int trapRainWater(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[2], b[2])
        );
        
        for(int i=0; i<m; i++) {
            pq.offer(new int[]{i, 0, heights[i][0]});
            pq.offer(new int[]{i, n-1, heights[i][n-1]});
            visited[i][0] = visited[i][n-1] = true;
        }
        
        for(int j=1; j<n-1; j++) {
            pq.offer(new int[]{0, j, heights[0][j]});
            pq.offer(new int[]{m-1, j, heights[m-1][j]});
            visited[0][j] = visited[m-1][j] = true;
        }
        
        int[][] dirs = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };
        
        while( !pq.isEmpty() ) {
            int i = pq.peek()[0];
            int j = pq.peek()[1];
            int max = pq.peek()[2];
            pq.poll();
            
            for(int[] dir : dirs) {
                int di = i + dir[0];
                int dj = j + dir[1];
                
                if( di < 0 || dj < 0 || di == m || dj == n || visited[di][dj] )
                    continue;
                
                visited[di][dj] = true;
                
                ans += Math.max(0, max - heights[di][dj]);
                
                pq.offer(new int[]{ di, dj, Math.max(max, heights[di][dj])});
            }
        }
        return ans;
    }
}
