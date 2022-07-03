class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        combine(1, n, k, new ArrayList(), ans);
        return ans;
    }
    
    private void combine(int start, int n, int k, List<Integer> curr, List<List<Integer>> ans) {
        if( curr.size() == k ) {
            ans.add( new ArrayList(curr) );
            return;
        }
        
        for(int i=start; i<=n; i++) {
            curr.add(i);
            combine(i+1, n, k, curr, ans);
            curr.remove( curr.size()-1 );
        }
    }
}
// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> ans = new ArrayList();
//         combine(n, k, new ArrayList(), ans);
//         return ans;
//     }
    
//     private void combine(int n, int k, List<Integer> curr, List<List<Integer>> ans) {
//         if( n < 0 )
//             return;
        
//         if( curr.size() == k ) {
//             ans.add( new ArrayList(curr) );
//             return;
//         }
        
//         combine(n-1, k, curr, ans);
        
//         curr.add(n);
//         combine(n-1, k, curr, ans);
//         curr.remove( curr.size()-1 );
//     }
// }
