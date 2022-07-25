class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
    
        for(String eq : equations) 
            if( eq.charAt(1) == '=' )
                dsu.union(eq.charAt(0)-'a', eq.charAt(3)-'a');
        
        for(String eq : equations) {
            char op = eq.charAt(1);
            
            boolean equal = dsu.find(eq.charAt(0)-'a') == dsu.find(eq.charAt(3)-'a');
             
            if( (op == '=' && !equal) || (op == '!' && equal) )
                return false;
        }
        return true;
    }
}
class DSU {
    private int[] parent;
    private int[] rank;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if( parent[x] != x )
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        
        if( xp == yp )
            return false;
        
        if( rank[xp] > rank[yp] ) 
            parent[yp] = xp;
        else if( rank[xp] < rank[yp] )
            parent[xp] = yp;
        else {
            parent[yp] = xp;
            rank[xp] += 1;
        }
        return true;
    }
}
// class Solution {
//     public boolean equationsPossible(String[] equations) {
//         Map<Character,Set<Character>> adj = new HashMap();
        
//         for(String eq : equations) {
//             char x = eq.charAt(0), y = eq.charAt(3), op = eq.charAt(1);
            
//             adj.putIfAbsent(x, new HashSet());
//             adj.putIfAbsent(y, new HashSet());
            
//             if( op == '=' ) {
//                 adj.get(x).add(y);
//                 adj.get(y).add(x);
//             } else {
//                 adj.get(x).remove(y);
//                 adj.get(y).remove(x);
//             }
//         }
        
//         for(String eq : equations) {
//             char x = eq.charAt(0), y = eq.charAt(3), op = eq.charAt(1);
            
//             boolean equal = dfs(x, y, adj, new HashSet());
             
//             if( (op == '=' && !equal) || (op == '!' && equal) )
//                 return false;
//         }
//         return true;
//     }
    
//     private boolean dfs(char src, char dest, Map<Character,Set<Character>> adj, Set<Character> visited) {
//         if( src == dest )
//             return true;
        
//         visited.add(src);
        
//         for(char v : adj.get(src)) 
//             if( !visited.contains(v) && dfs(v, dest, adj, visited) )
//                 return true;
        
//         return false;
//     }
// }
// class Solution {
//     public boolean equationsPossible(String[] equations) {
//         ArrayList<Integer>[] adj = new ArrayList[26];
        
//         for(String eq : equations) {
//             if( eq.charAt(1) == '!' ) continue;
            
//             int x = eq.charAt(0) - 'a', y = eq.charAt(3) - 'a';
            
//             if( adj[x] == null ) adj[x] = new ArrayList();
//             if( adj[y] == null ) adj[y] = new ArrayList();
            
//             adj[x].add(y);
//             adj[y].add(x);
//         }
        
//         for(String eq : equations) {
//             int x = eq.charAt(0) - 'a', y = eq.charAt(3) - 'a';
//             char op = eq.charAt(1);
            
//             boolean equal = dfs(x, y, adj, new HashSet());
             
//             if( (op == '=' && !equal) || (op == '!' && equal) )
//                 return false;
//         }
//         return true;
//     }
    
//     private boolean dfs(int src, int dest, ArrayList<Integer>[] adj, Set<Integer> visited) {
//         if( src == dest )
//             return true;
//         if( adj[src] == null )
//             return false;
        
//         visited.add(src);
        
//         for(int v : adj[src]) 
//             if( !visited.contains(v) && dfs(v, dest, adj, visited) )
//                 return true;
        
//         return false;
//     }
// }
// class Solution {
//     public boolean equationsPossible(String[] equations) {
//         Map<Character,Set<Character>> adj = new HashMap();
        
//         for(String eq : equations) {
//             char x = eq.charAt(0), y = eq.charAt(3), op = eq.charAt(1);
            
//             adj.putIfAbsent(x, new HashSet());
//             adj.putIfAbsent(y, new HashSet());
            
//             if( op == '=' ) {
//                 adj.get(x).add(y);
//                 adj.get(y).add(x);
//             } else {
//                 adj.get(x).remove(y);
//                 adj.get(y).remove(x);
//             }
//         }
        
//         for(String eq : equations) {
//             char x = eq.charAt(0), y = eq.charAt(3), op = eq.charAt(1);
            
//             boolean equal = dfs(x, y, adj, new HashSet());
             
//             if( (op == '=' && !equal) || (op == '!' && equal) )
//                 return false;
//         }
//         return true;
//     }
    
//     private boolean dfs(char src, char dest, Map<Character,Set<Character>> adj, Set<Character> visited) {
//         if( src == dest )
//             return true;
        
//         visited.add(src);
        
//         for(char v : adj.get(src)) 
//             if( !visited.contains(v) && dfs(v, dest, adj, visited) )
//                 return true;
        
//         return false;
//     }
// }
