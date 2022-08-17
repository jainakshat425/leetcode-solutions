class Solution {
    private static final int[][] DIRS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int initState = 0, steps = 0;
        
        // intitial state of matrix (represented as bitmask)
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                initState |= (mat[i][j] << (i*n + j));
        
        // all cell 0 already?
        if( initState == 0 ) return 0;
        
        // BFS to calculate min steps to reach state 0
        Queue<Integer> queue = new LinkedList();
        queue.offer(initState);
        
        Set<Integer> visited = new HashSet();
        visited.add(initState);
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            
            while( size-- > 0 ) {
                int state = queue.poll();
                
                // try flipping each cell of matrix from curr state
                for(int i=0; i<m; i++) {
                    for(int j=0; j<n; j++) {
                        // flip curr cell and neighbour cells 
                        int newState = flipCell(i, j, m, n, state);
                        
                        // optimization: early exist
                        if( newState == 0 ) return steps+1; 
                        
                        if( visited.add( newState ) )
                            queue.offer( newState );
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private int flipCell(int i, int j, int m, int n, int state) {
        int newState = flipBit(state, i*n + j);
                        
        for(int[] dir : DIRS) {
            int di = i+dir[0], dj = j+dir[1];

            if( di < 0 || dj < 0 || di == m || dj == n )
                continue;

            newState = flipBit(newState, di*n + dj);
        }
        return newState;
    }
    
    private int flipBit(int state, int index) {
        return state ^ (1 << index);
    }
}
