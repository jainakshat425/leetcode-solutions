class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        
        Queue<Pair> queue = new LinkedList();
        queue.offer( new Pair(root, 0) );
        
        // Repeat for each level
        while( !queue.isEmpty() ) {
            
            int size = queue.size();
            // Index of the left most node at current level
            int minIdx = queue.peek().index;
            // Index of the right most node at current level
            int maxIdx = -1;
            
            for(int i=0; i<size; i++) {
                Pair pair = queue.poll();

                if( i == size-1 ) {
                    maxIdx = pair.index;
                }
                
                // To handle overflow
                int index = pair.index-minIdx;
                
                // Left node index = (2 * Parent Node Index) + 1
                if( pair.node.left != null ) {
                    queue.offer( new Pair(pair.node.left, (2*index + 1)) );
                }
                // Right node index = (2 * Parent Node Index) + 2
                if( pair.node.right != null ) {
                    queue.offer( new Pair(pair.node.right, (2*index + 2)) );
                }
            }
            
            // Width of current level is the difference of indices of left most and right most node
            max = Math.max(max, maxIdx-minIdx+1);
        }
        
        return max;
    }
    
    class Pair {
        public TreeNode node;
        public int index;
        
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
