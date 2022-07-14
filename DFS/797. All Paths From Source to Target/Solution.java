class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList();
        dfs(0, n-1, graph, new LinkedList(){{ add(0); }}, ans);
        return ans;
    }
    
    private void dfs(int src, int dest, int[][] graph, LinkedList<Integer> path, List<List<Integer>> ans) {
        if( src == dest ) {
            ans.add( new ArrayList(path) );
            return;
        }
        
        for(int adj : graph[src]) {
            path.add(adj);
            dfs(adj, dest, graph, path, ans);
            path.removeLast();
        }
    }
}
