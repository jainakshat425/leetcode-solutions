class Solution {
    // up, bottom, left, right
    private static final int[] DI = {-1, 1, 0, 0};
    private static final int[] DJ = {0, 0, -1, 1};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, n-1, atlantic, heights);
        }
         
        for(int j=0; j<n; j++) {
            dfs(0, j, pacific, heights);
            dfs(m-1, j, atlantic, heights);
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( pacific[i][j] && atlantic[i][j] )
                    ans.add(new ArrayList(List.of(i, j)));
            }
        }
        return ans;  
    }
    
    private void dfs(int i, int j, boolean[][] visited, int[][] heights) {
        int m = heights.length, n = heights[0].length;
        visited[i][j] = true;

        for(int dir=0; dir<4; dir++) {
            int di = i + DI[dir];
            int dj = j + DJ[dir];
            
            if( di < 0 || dj < 0 || di >= m || dj >= n ) 
                continue;
            
            if( heights[di][dj] < heights[i][j] || visited[di][dj] )
                continue;
            
            dfs(di, dj, visited, heights);
        }
    }
}
/* 
class Solution {
    // up, bottom, left, right
    private static final int[] DI = {-1, 1, 0, 0};
    private static final int[] DJ = {0, 0, -1, 1};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList();
        int[][] reachPacific = new int[m][n];
        int[][] reachAtlantic = new int[m][n];
        
        for(int i=0; i<m; i++) {
            reachPacific[i][0] = 1;
            reachAtlantic[i][n-1] = 1;
        }
         
        for(int j=0; j<n; j++) {
            reachPacific[0][j] = 1;
            reachAtlantic[m-1][0] = 1;
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( reachPacific[i][j] == 0 || reachAtlantic[i][j] == 0 )
                    dfs(i, j, heights, reachPacific, reachAtlantic);
                
                if( reachPacific[i][j] == 1 && reachAtlantic[i][j] == 1 )
                    ans.add(new ArrayList(List.of(i, j)));
            }
        }
        return ans;  
    }
    
    private void dfs(int i, int j, int[][] heights, int[][] pacific, int[][] atlantic) {
        int m = heights.length, n = heights[0].length;
        
        if( pacific[i][j] == 0 )
            pacific[i][j] = -1;
        if( atlantic[i][j] == 0 )
            atlantic[i][j] = -1;
        
        for(int dir=0; dir<4; dir++) {
            int di = i + DI[dir];
            int dj = j + DJ[dir];
            
            if( di < 0 || dj < 0 || di >= m || dj >= n || heights[di][dj] > heights[i][j] ) 
                continue;
            
            if( pacific[di][dj] == 0 || atlantic[di][dj] == 0 )
                dfs(di, dj, heights, pacific, atlantic);
            
            if( pacific[di][dj] == 1 )
                pacific[i][j] = 1;
            
            if( atlantic[di][dj] == 1 )
                atlantic[i][j] = 1;
            
            if( pacific[i][j] == 1 && atlantic[i][j] == 1 )
                return;
        }
    }
}
*/
