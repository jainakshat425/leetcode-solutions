class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,Map<Integer,List<Integer>>> colToRowToNodes = new TreeMap();
        Queue<Pair> queue = new LinkedList();
        queue.add( new Pair(root, 0) );
        
        int row = 0;
        
        while( !queue.isEmpty() ) {
            
            // Iterate for all the nodes in current level/row
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Pair pair = queue.poll();
                int col = pair.col;

                // Get the rows corresponding to current column
                Map<Integer,List<Integer>> rowToNodes = colToRowToNodes.get(col);
                if( rowToNodes == null ) {
                    rowToNodes = new TreeMap();
                    colToRowToNodes.put( col, rowToNodes );
                }

                // Get the nodes in current row and add current node to it
                List<Integer> nodes = rowToNodes.get( row );
                if( nodes == null ) {
                    nodes = new ArrayList();
                    rowToNodes.put( row, nodes );
                }
                nodes.add( pair.node.val );

                // Add left and right child to queue for next level
                if( pair.node.left != null ) {
                    queue.offer( new Pair( pair.node.left, col-1 ));
                }
                if( pair.node.right != null ) {
                    queue.offer( new Pair( pair.node.right, col+1 ));
                }
            }
            // Move to next row
            row++;
        }
        
        List<List<Integer>> ans = new ArrayList();
        for(Map<Integer,List<Integer>> rowToNodes : colToRowToNodes.values()) {
            List<Integer> nodesInCol = new ArrayList();
            ans.add( nodesInCol );
            
            for(List<Integer> nodesInRow : rowToNodes.values()) {
                
                // If there are more than one node in current (row, col) then sort them.
                if( nodesInRow.size() > 1 ) {
                    Collections.sort( nodesInRow );
                }
                
                for(Integer node : nodesInRow) {
                    nodesInCol.add( node );
                }
            }
        }
        
        return ans;
    }
    
    class Pair {
        public TreeNode node;
        public int col;
        
        public Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
