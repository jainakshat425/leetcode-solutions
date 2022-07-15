// class Solution {
    
//     private static final int[][] DIR = new int[][]{
//         {1, 0}, {-1, 0}, {0, 1}, {0, -1}
//     };
    
//     public int largestIsland(int[][] grid) {
//         int n = grid.length;
//         int ans = 0;
        
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<n; j++) {
                
//                 if( grid[i][j] != 0 ) continue;
                
//                 int area = dfs(i, j, n, grid, new boolean[n][n]);
//                 ans = Math.max(ans, area);
//             }
//         }
//         return ans == 0 ? n*n : ans;
//     }
    
//     private int dfs(int i, int j, int n, int[][] grid, boolean[][] visited) {
                
//         visited[i][j] = true;
        
//         int area = 1;
        
//         for(int[] dir : DIR) {
//             int di = i + dir[0];
//             int dj = j + dir[1];
            
//             if( di < 0 || dj < 0 || di == n || dj == n || grid[di][dj] != 1 || visited[di][dj] )
//                 continue;
            
//             area += dfs(di, dj, n, grid, visited);
//         }
//         return area;
//     }
// }
class Solution {
    private static final int[][] DIR = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        List<Integer> cmpSize = new ArrayList(){{ add(0); add(0); }};
        int nextColor = 2;
        
        for(int i=0; i<n; i++) 
            for(int j=0; j<n; j++) 
                if( grid[i][j] == 1 ) 
                    cmpSize.add( dfs(i, j, n, grid, nextColor++) );
         
        for(int i=0; i<n; i++) 
            for(int j=0; j<n; j++) 
                if( grid[i][j] == 0 ) {
                    Set<Integer> adjColors = new HashSet();
                    int area = 1;
                    
                    for(int[] dir : DIR) {
                        int di = i + dir[0];
                        int dj = j + dir[1];
                        
                        if( di < 0 || dj < 0 || di == n || dj == n )
                            continue;
                        
                        if( adjColors.add(grid[di][dj]) )
                            area += cmpSize.get(grid[di][dj]);
                    }
                    
                    ans = Math.max(ans, area);
                }
        
        return ans == 0 ? n*n : ans;
    }
    
    private int dfs(int i, int j, int n, int[][] grid, int color) {
        grid[i][j] = color;
        
        int area = 1;
        
        for(int[] dir : DIR) {
            int di = i + dir[0];
            int dj = j + dir[1];
            
            if( di < 0 || dj < 0 || di == n || dj == n || grid[di][dj] != 1 )
                continue;
            
            area += dfs(di, dj, n, grid, color);
        }
        return area;
    }
}
