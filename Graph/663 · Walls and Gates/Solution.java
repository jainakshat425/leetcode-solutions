public class Solution {
    private static final int[][] DIR = new int[][]{
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( rooms[i][j] == 0 )
                    bfs(i, j, m, n, rooms);
            }
        }
    }

    private void bfs(int row, int col, int m, int n, int[][] rooms) {
        // 0 > row, 1 > column
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{row, col});

        while( !queue.isEmpty() ) {
            int i = queue.peek()[0];
            int j = queue.peek()[1];
            queue.poll();

            for(int dir=0; dir<4; dir++) {
                int di = i + DIR[dir][0];
                int dj = j + DIR[dir][1];

                // skip, if index out of bounds or their is a gate/wall/shorter distance available
                if( di < 0 || dj < 0 || di > m-1 || dj > n-1 || rooms[di][dj] <= rooms[i][j] + 1 ) 
                    continue;

                rooms[di][dj] = rooms[i][j] + 1;
                queue.offer(new int[]{di, dj});
            }
        }
    }
    /* Did not work, because short path will keep changing as we calculate for each node
    private void dfs(int i, int j, int m, int n, int[][] rooms, boolean[][] visited) {
        visited[i][j] = true;

        for(int dir=0; dir<4; dir++) {
            int di = i + DIR[dir][0];
            int dj = j + DIR[dir][1];

            // skip, if index out of bounds or their is a wall or already visited
            if( di < 0 || dj < 0 || di > m-1 || dj > n-1 || rooms[di][dj] == -1 || visited[di][dj] ) 
                continue;

            // end search, if a gate is present in the adjacent cell
            if( rooms[di][dj] == 0 ) {
                rooms[i][j] = 1;
                return;
            }  

            // find gate for current adjacent cell
            if( rooms[di][dj] == Integer.MAX_VALUE ) 
                dfs(di, dj, m, n, rooms, visited);

            // skip, if no gate is found from current adjacent cell
            if( rooms[di][dj] == Integer.MAX_VALUE )
                continue;

            rooms[i][j] = Math.min(rooms[i][j], 1 + rooms[di][dj]);
        }
    }
    */
}
