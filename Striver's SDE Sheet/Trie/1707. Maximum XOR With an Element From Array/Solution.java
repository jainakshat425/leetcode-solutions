class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        Pair[] pairs = new Pair[q];
        
        for(int i=0; i<q; i++) 
            pairs[i] = new Pair(i, queries[i]);
        
        Arrays.sort(pairs);
        Arrays.sort(nums);        
        
        int[] ans = new int[q];
        Trie trie = new Trie();
        int i = 0;
        for(Pair pair : pairs) {
            
            while(i < n && nums[i] <= pair.getM()) 
                trie.insert( nums[i++] );
            
            ans[pair.getIndex()] = i == 0 ? -1 : trie.getMaxXOR(pair.getX());
        }
        return ans;
    }
}

class Pair implements Comparable<Pair> {
    private int index;
    private int[] query;
    
    public Pair(int index, int[] query) {
        this.index = index;
        this.query = query;
    }
    
    public int getIndex() {
        return index;
    }
    
    public int getX() {
        return query[0];
    }
    
    public int getM() {
        return query[1];
    }
    
    @Override
    public int compareTo(Pair p2) {
        return query[1] - p2.query[1];
    }
}

class Node {
    private Node[] links;
    
    public Node() {
        links = new Node[2];
    }
    
    public Node get(int bit) {
        return links[bit];
    }
    
    public void put(int bit, Node node) {
        links[bit] = node;
    }
    
    public boolean contains(int bit) {
        return links[bit] != null;
    }
}

class Trie {
    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(int num) {
        Node curr = root;
        
        for(int i=31; i>=0; i--) {
            int bit = (num >> i) & 1;
            
            if( !curr.contains(bit) ) 
                curr.put(bit, new Node());
            
            curr = curr.get(bit);
        }
    }
    
    public int getMaxXOR(int num) {
        Node curr = root;
        int max = 0;
        for(int i=31; i>=0; i--) {
            int bit = (num >> i) & 1;
            
            if( curr.contains(1-bit) ) {
                max = max | (1 << i);
                curr = curr.get(1-bit);
            } else
                curr = curr.get(bit);
        }
        return max;
    }
}
