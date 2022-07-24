class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accCount = accounts.size();
        DSU dsu = new DSU(accCount);
        Map<String,Integer> emailToGroup = new HashMap();
    
        for(int i=0; i<accCount; i++) {    
            List<String> acc = accounts.get(i);
            
            for(int j=1; j<acc.size(); j++) {
                String email = acc.get(j);
                if( !emailToGroup.containsKey(email) )
                    emailToGroup.put(email, i);
                else
                    dsu.union(i, emailToGroup.get(email));
            }
        }
        Map<Integer,List<String>> groupIdToMergedAccs = new HashMap();
        
        for(String email : emailToGroup.keySet()) { 
            int groupId = dsu.find( emailToGroup.get( email ) );

            groupIdToMergedAccs.putIfAbsent(groupId, new ArrayList());
                
            groupIdToMergedAccs.get(groupId).add(email);
        }
        
        for(int groupId : groupIdToMergedAccs.keySet()) {            
            List<String> acc = groupIdToMergedAccs.get( groupId );
            
            Collections.sort(acc);
            
            acc.add(0, accounts.get(groupId).get(0));
        }
        return new ArrayList(groupIdToMergedAccs.values());
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
    
    public void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        
        if( xp == yp ) return;
        
        if( rank[xp] > rank[yp] ) 
            parent[yp] = xp;
        else if( rank[yp] > rank[xp] ) 
            parent[xp] = yp;
        else {
            parent[yp] = xp;
            rank[xp] += 1;
        }
    }
}
