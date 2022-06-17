class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList(numCourses);   
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList();
        int[] ans = new int[numCourses];
        int finished = 0;
        
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList());
        
        for(int i=0; i<n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] += 1;
        }
        
        for(int i=0; i<numCourses; i++) {
            if( indegree[i] == 0 )
                queue.offer(i);
        }
        
        while( !queue.isEmpty() ) {
            int u = queue.poll();
            ans[finished++] = u;
            
            for(int v : adj.get(u)) {
                indegree[v] -= 1;
                
                if( indegree[v] == 0 ) 
                    queue.offer(v);
            }
        }
        return finished == numCourses ? ans : new int[0];
    }
}
