class Solution {
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        int ans = 0;
        TrieNode trieRoot = new TrieNode();
        Map<TrieNode,Integer> nodeToInd = new HashMap();
        
        for(int i=0; i<n; i++) {
            int m = words[i].length();
            TrieNode curr = trieRoot;
        
            for(int j=m-1; j>=0; j--) {
                char c = words[i].charAt(j);

                if( !curr.containsKey(c) ) 
                    curr.put(c, new TrieNode());  
                
                curr = curr.get(c);
            }
            nodeToInd.put(curr, i);
        }
        
        for(TrieNode node : nodeToInd.keySet()) {
            if( node.isLeaf() ) 
                ans += words[nodeToInd.get(node)].length() + 1;
        }
        return ans;
    }
}
class TrieNode {
    private static final int N = 26;
    private TrieNode[] links;
    private int count;
    
    public TrieNode() {
        links = new TrieNode[N];
        count = 0;
    }
    
    private int charIndex(char c) {
        return c - 'a';
    }
    
    public boolean containsKey(char c) {
        return links[charIndex(c)] != null;
    }
    
    public TrieNode get(char c) {
        return links[charIndex(c)];
    }
    
    public void put(char c, TrieNode node) {
        links[charIndex(c)] = node;
        count++;
    }
    
    public boolean isLeaf() {
        return this.count == 0;
    }
}
// class Solution {
//     public int minimumLengthEncoding(String[] words) {
        
//         int ans = 0;
//         TrieNode trieRoot = new TrieNode();
        
//         for(String word : words) {
//             int n = word.length();
//             TrieNode curr = trieRoot;
        
//             boolean isNewPath = false;
//             for(int i=n-1; i>=0; i--) {
//                 char c = word.charAt(i);

//                 if( !curr.containsKey(c) ) 
//                     curr.put(c, new TrieNode());    

//                 if( curr.isPathEnd() ) {
//                     isNewPath = true;
//                     curr.setPathEnd(false);
//                 }
//                 int pathLen = curr.getPathLen();
//                 curr = curr.get(c);
//                 curr.setPathLen(pathLen+1);
//             }
//             if( isNewPath)
//                 curr.setPathEnd(true);
//         }
//         return countEachPathNodes(trieRoot);
//     }
    
//     private int countEachPathNodes(TrieNode curr) {
//         if( curr.isPathEnd() )
//             return 1 + curr.getPathLen();
        
//         int count = 0;
//         for(char c = 'a'; c <= 'z'; c++ ) {
//             if( curr.containsKey(c) ) {
//                 // System.out.println(c);
//                 count += countEachPathNodes(curr.get(c));
//             }
//         }
//         return count;
//     }
// }
// class TrieNode {
//     private static final int N = 26;
//     private TrieNode[] links;
//     private boolean pathEnd;
//     private int pathLen;
    
//     public TrieNode() {
//         links = new TrieNode[N];
//         pathLen = 0;
//         pathEnd = true;
//     }
    
//     private int charIndex(char c) {
//         return c - 'a';
//     }
    
//     public boolean containsKey(char c) {
//         return links[charIndex(c)] != null;
//     }
    
//     public TrieNode get(char c) {
//         return links[charIndex(c)];
//     }
    
//     public void put(char c, TrieNode node) {
//         links[charIndex(c)] = node;
//     }
    
//     public void setPathEnd(boolean pathEnd) {
//         this.pathEnd = pathEnd;
//     }
    
//     public boolean isPathEnd() {
//         return this.pathEnd;
//     }
    
//     public void setPathLen(int len) {
//         this.pathLen = len;
//     }
    
//     public int getPathLen() {
//         return this.pathLen;
//     }
// }
