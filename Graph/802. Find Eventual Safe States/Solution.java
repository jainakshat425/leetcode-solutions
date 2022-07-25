class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] safe = new int[n];
        List<Integer> ans = new ArrayList();
        
        for(int i=0; i<n; i++)
            if( isSafe(i, safe, graph) )
                ans.add(i);
        return ans;
    }
    
    private boolean isSafe(int u, int[] safe, int[][] graph) {
        if( safe[u] != 0 )
            return safe[u] == 1;
        
        safe[u] = -1;
        
        for(int v : graph[u])
            if( !isSafe(v, safe, graph) )
                return false;
        
        safe[u] = 1;
        return true;
    }
}
