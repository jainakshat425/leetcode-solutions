// class Solution {
//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//         int n = equations.size();
//         int q = queries.size();
//         double[] ans = new double[q];
        
//         Arrays.fill(ans, -1);
        
//         Map<Integer,List<Node>> adj = new HashMap();
//         Map<String,Integer> strInd = new HashMap();
//         int count = 0;
        
//         for(int i=0; i<n; i++) {
//             String a = equations.get(i).get(0);
//             String b = equations.get(i).get(1);

//             if( !strInd.containsKey(a) )
//                 strInd.put(a, count++);
//             if( !strInd.containsKey(b) )
//                 strInd.put(b, count++);
            
//             int indA = strInd.get(a);
//             int indB = strInd.get(b);
            
//             adj.putIfAbsent(indA, new ArrayList());
//             adj.get(indA).add(new Node(indB, values[i]));
            
//             adj.putIfAbsent(indB, new ArrayList());
//             adj.get(indB).add(new Node(indA, 1/values[i]));
//         }
        
            
//         for(int i=0; i<q; i++) {
//             String a = queries.get(i).get(0);
//             String b = queries.get(i).get(1);
            
//             if( !strInd.containsKey(a) || !strInd.containsKey(b) )
//                 continue;
            
//             int indA = strInd.get(a);
//             int indB = strInd.get(b);
            
//             ans[i] = dfs(indA, indB, adj, new boolean[count]);     
//         }
//         return ans;
//     }
    
//     private double dfs(int src, int dst, Map<Integer,List<Node>> adj, boolean[] vis) {
//         vis[src] = true;
        
//         if( src == dst )
//             return 1;
        
//         if( !adj.containsKey(src) )
//             return -1;
        
//         for(Node node : adj.get(src)) {
//             if( vis[node.dst] )
//                 continue;
//             double val = dfs(node.dst, dst, adj, vis);
            
//             if( val != -1 )
//                 return node.val * val;
//         }
//         return -1;
//     }
// }
// class Node {
//     public int dst;
//     public double val;
    
//     public Node(int destination, double value) {
//         dst = destination;
//         val = value;
//     }
// }
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        int q = queries.size();
        double[] ans = new double[q];
        Map<String,List<Node>> adj = new HashMap();
        
        for(int i=0; i<n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            
            adj.putIfAbsent(a, new ArrayList());
            adj.get(a).add(new Node(b, values[i]));
            
            adj.putIfAbsent(b, new ArrayList());
            adj.get(b).add(new Node(a, 1/values[i]));
        }
        
        Arrays.fill(ans, -1);
            
        for(int i=0; i<q; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
        
            if( !adj.containsKey(a) || !adj.containsKey(b) )
                continue;
            
            ans[i] = dfs(a, b, adj, new HashSet());     
        }
        return ans;
    }
    
    private double dfs(String src, String dst, Map<String,List<Node>> adj, Set<String> vis) {
        vis.add(src);
        
        if( src.equals(dst) )
            return 1;
        
        for(Node node : adj.get(src)) {
            if( vis.contains(node.dst) )
                continue;
            
            double val = dfs(node.dst, dst, adj, vis);
            
            if( val != -1 )
                return node.val * val;
        }
        return -1;
    }
}
class Node {
    public String dst;
    public double val;
    
    public Node(String destination, double value) {
        dst = destination;
        val = value;
    }
}
