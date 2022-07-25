class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        for(int emp=0; emp<n; emp++) 
            max = Math.max(max, dfs(emp, manager, informTime));
        return max;
    }
    
    private int dfs(int emp, int[] manager, int[] informTime) {
        if( manager[emp] != -1 ) {
            informTime[emp] += dfs(manager[emp], manager, informTime);
            manager[emp] = -1;
        }
        return informTime[emp];
    }
}
// class Solution {
//     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//         ArrayList<Integer>[] adj = new ArrayList[n];
        
//         for(int i=0; i<n; i++)
//             adj[i] = new ArrayList();
        
//         for(int emp=0; emp<n; emp++) 
//             if( emp != headID )
//                 adj[manager[emp]].add(emp);
        
//         return dfs(headID, adj, informTime);
//     }
    
//     private int dfs(int manager, ArrayList<Integer>[] adj, int[] informTime) {
//         int max = 0;
        
//         for(int emp : adj[manager]) 
//             max = Math.max(max, dfs(emp, adj, informTime));
        
//         return informTime[manager] + max;
//     }
// }
