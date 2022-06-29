class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DSU dsu = new DSU(n);
        Map<Integer,List<Integer>> groups = new HashMap();
        
        for(List<Integer> pair : pairs)
            dsu.union(pair.get(0), pair.get(1));
        
        for(int i=0; i<n; i++) {
            int par = dsu.find(i);
            groups.putIfAbsent(par, new ArrayList());
            groups.get(par).add(i);
        }
        
        char[] ans = s.toCharArray();
        
        for(List<Integer> grp : groups.values()) {
            int m = grp.size();
            char[] grpChars = new char[m];
            
            for(int i=0; i<m; i++)
                grpChars[i] = ans[grp.get(i)];
            
            Arrays.sort(grpChars);
            
            for(int i=0; i<m; i++) 
                ans[grp.get(i)] = grpChars[i];
        }
        
        return new String(ans);
    }
}
class DSU {
    private int[] parent;
    private int[] rank;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++) 
            parent[i] = i;
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
