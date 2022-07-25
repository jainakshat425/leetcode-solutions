class Solution {
    
    private static final int[][] DIR = new int[][]{
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        int ans = -1;
        
        for(int i=0; i<n; i++) 
            for(int j=0; j<n; j++) 
                if( grid[i][j] == 1 )
                    queue.offer(new int[]{ i, j, 0 });
                
        while( !queue.isEmpty() ) {
            int i = queue.peek()[0];
            int j = queue.peek()[1];
            int d = queue.peek()[2];
            queue.poll();
            
            for(int[] dir : DIR) {
                int di = i + dir[0];
                int dj = j + dir[1];
                
                if( di < 0 || dj < 0 || di == n || dj == n )
                    continue;
                if( grid[di][dj] != 0 )
                    continue;
                
                grid[di][dj] = 2;
                
                int dist = d + Math.abs(i-di) + Math.abs(j-dj);
                
                ans = Math.max(ans, dist);
                
                queue.offer(new int[]{ di, dj, dist });
            }
        }
        return ans;
    }
}
