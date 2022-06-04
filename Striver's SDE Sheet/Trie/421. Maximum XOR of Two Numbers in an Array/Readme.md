https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        Trie xorTrie = new Trie();
        
        for(int num : nums) 
            xorTrie.insert( num );
        
        for(int num : nums) 
            max = Math.max(max, xorTrie.getMaxXOR(num));
        
        return max;
    }
}

class Node {
    private static int N = 2;
    private Node[] links;
    
    public Node() {
        links = new Node[N];
    }
    
    public boolean contains(int bit) {
        return links[bit] != null;
    }
    
    public Node get(int bit) {
        return links[bit];
    }
    
    public void put(int bit, Node node) {
        links[bit] = node;
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
            if( curr.contains(1 - bit) ) {
                max = max | (1 << i);
                curr = curr.get(1 - bit);
            } else {
                curr = curr.get(bit);
            }
        }
        return max;      
    }
}
