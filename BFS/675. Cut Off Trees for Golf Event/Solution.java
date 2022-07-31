class Solution {
    private static final int[][] DIR = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        // [tree height, row, col]
        PriorityQueue<int[]> trees = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[0], b[0]));
        
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++) {
                int ht = forest.get(i).get(j);
                if( ht > 1 )
                    trees.offer(new int[]{ht, i, j});
            }
        
        int ans = 0;
        int currX = 0, currY = 0;
        
        while( !trees.isEmpty() ) {
            int i = trees.peek()[1], j = trees.poll()[2];
            
            int steps = bfs(currX, currY, i, j, forest);
            if( steps == -1 )
                return -1;
            ans += steps;
            currX = i;
            currY = j;
        }
        return ans;
    }
    
    private int bfs(int srcRow, int srcCol, int destRow, int destCol, List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        int steps = 0;

        queue.offer(new int[]{ srcRow, srcCol });
        visited[srcRow][srcCol] = true;
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            
            while( size-- > 0 ) {
                int i = queue.peek()[0];
                int j = queue.peek()[1];
                queue.poll();
                
                if( i == destRow && j == destCol )
                    return steps;
                
                for(int[] dir : DIR) {
                    int di = i + dir[0];
                    int dj = j + dir[1];

                    if( di < 0 || dj < 0 || di == m || dj == n )
                        continue;
                    
                    if( visited[di][dj] || forest.get(di).get(dj) == 0 ) 
                        continue;
                    
                    queue.offer(new int[]{di, dj});
                    visited[di][dj] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}
// class Solution {
//     private static final int[][] DIR = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
//     public int cutOffTree(List<List<Integer>> forest) {
//         int m = forest.size(), n = forest.get(0).size();
//         // [tree height, row, col]
//         List<int[]> trees = new ArrayList();
        
//         for(int i=0; i<m; i++) 
//             for(int j=0; j<n; j++) {
//                 int ht = forest.get(i).get(j);
//                 if( ht > 1 )
//                     trees.add(new int[]{ht, i, j});
//             }
        
//         Collections.sort(trees, (a,b) -> Integer.compare(a[0], b[0]));
        
//         int ans = 0;
//         int currX = 0, currY = 0;
        
//         for(int[] tree : trees) {
//             int steps = bfs(currX, currY, tree[1], tree[2], forest);
//             if( steps == -1 )
//                 return -1;
//             ans += steps;
//             currX = tree[1];
//             currY = tree[2];
//         }
//         return ans;
//     }
    
//     private int bfs(int srcRow, int srcCol, int destRow, int destCol, List<List<Integer>> forest) {
//         int m = forest.size(), n = forest.get(0).size();
//         boolean[][] visited = new boolean[m][n];
//         Queue<int[]> queue = new LinkedList();
//         int steps = 0;

//         queue.offer(new int[]{ srcRow, srcCol });
//         visited[srcRow][srcCol] = true;
        
//         while( !queue.isEmpty() ) {
//             int size = queue.size();
            
//             while( size-- > 0 ) {
//                 int i = queue.peek()[0];
//                 int j = queue.peek()[1];
//                 queue.poll();
                
//                 if( i == destRow && j == destCol )
//                     return steps;
                
//                 for(int[] dir : DIR) {
//                     int di = i + dir[0];
//                     int dj = j + dir[1];

//                     if( di < 0 || dj < 0 || di == m || dj == n )
//                         continue;
                    
//                     if( visited[di][dj] || forest.get(di).get(dj) == 0 ) 
//                         continue;
                    
//                     queue.offer(new int[]{di, dj});
//                     visited[di][dj] = true;
//                 }
//             }
//             steps++;
//         }
//         return -1;
//     }
// }
