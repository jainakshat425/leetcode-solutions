class Solution {
    
    private static final int[][] DIR = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList();
        
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++) 
                if( mat[i][j] == 1 )
                    dist[i][j] = Integer.MAX_VALUE;
                else
                    queue.offer(new int[]{i, j});
                    
        while( !queue.isEmpty() ) {
            int i = queue.peek()[0], j = queue.poll()[1];

            for(int[] dir : DIR) {

                int di = i + dir[0], dj = j + dir[1];

                if( di < 0 || dj < 0 || di == m || dj == n )
                    continue;

                if( dist[di][dj] > dist[i][j] + 1 ) {
                    dist[di][dj] = dist[i][j] + 1;
                    queue.offer(new int[]{ di, dj });
                }
            }
        }
        
        return dist;
    }
}
