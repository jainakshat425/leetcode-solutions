class Solution {
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Count of fresh oranges
        int freshCount = 0;
        
        // To hold all rotten oranges
        Queue<Coordinates> queue = new LinkedList<>();
        
        // Count total number of oranges and put all the rotten oranges into queue
        for(int row = 0; row < m; row++) {
            
            for(int col = 0; col < n; col++) {
                
                // If fresh orange? increase fresh oranges count
                if( grid[row][col] == 1 ) {
                    freshCount++;
                } 
                // If rotten orange, put it in queue
                else if( grid[row][col] == 2 ) {
                    queue.offer( new Coordinates(row, col) );
                }
            }
        }
        
        // No fresh oranges? return 0
        if( freshCount == 0 ) return 0;
        
        // Clockwise direction coordinates - Up, Left, Down, Right
        int[] dx = new int[]{0,-1,0,1};
        int[] dy = new int[]{1,0,-1,0};
        
        int minutes = 0;
        
        // Repeat for each rotten orange
        while( !queue.isEmpty() ) {
                        
            // Rotten all the nearby oranges of current rotten oranges in the queue
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                // Get the coordinates of a rotten orange from queue 
                Coordinates coord = queue.poll();
                
                // Check in all the 4 directions 
                for(int j=0; j<4; j++) {
                    int x = coord.col + dx[j];
                    int y = coord.row + dy[j];
                    
                    /* If move in current direction is not valid or orange is not present in 
                    this direction, then check for next direction */
                    if( x < 0 || y < 0 || x == n || y == m || grid[y][x] != 1 ) {
                        continue;
                    }
                    
                    // Mark current orange as rotten and decrease fresh oranges count (obviously)
                    grid[y][x] = 2;
                    freshCount--;
                    
                    // And check for it's nearby positions by putting current coordinates in queue
                    queue.offer( new Coordinates(y, x) );
                }
            }
            
            if( !queue.isEmpty() ) {
                minutes++;
            }
        }
        
        // If all the oranges are rotten, return minutes, else it's not possible to rotten all of them.
        return freshCount == 0 ? minutes : -1;
    }
        
    class Coordinates {
        public int row;
        public int col;
        
        public Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
    
