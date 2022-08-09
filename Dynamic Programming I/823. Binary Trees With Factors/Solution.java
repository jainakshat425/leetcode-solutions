class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Map<Integer,Long> dp = new HashMap();
        
        Arrays.sort(arr);
        
        long trees = 0;
        int mod = 1000000007;
        
        for(int i=0; i<n; i++) {
            int root = arr[i];
            long count = 1L;
            
            for(int j=0; j<i; j++) {
                if( root % arr[j] != 0 || !dp.containsKey(root/arr[j]) )
                    continue;
                
                long subtree1 = dp.get(arr[j]);
                long subtree2 = dp.get(root/arr[j]);
                
                count = (count + (subtree1 * subtree2) % mod) % mod;
            }
            dp.put(root, count);
            trees = (trees + count) % mod;
        }
        return (int)trees;
    }
}
