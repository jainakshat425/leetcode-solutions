/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if( root == null ) return null;
           
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        List<String> nodes = new ArrayList<String>();
        
        while( !stack.isEmpty() ) {
            
            TreeNode curr = stack.pop();
            
            if( curr == null ) {
                nodes.add( "#" );
            } else {
                
                nodes.add( ""+ curr.val );
                
                stack.push( curr.right );
                stack.push( curr.left );
            }
        }
        
        return String.join(",", nodes);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if( data == null ) return null;
        
        nodeIndex = 0;
        
        return buildTree( data.split(",") );
    }
    
    static int nodeIndex;
    
    private TreeNode buildTree(String[] values) {
        if( values[nodeIndex].equals("#") ) return null;
        
        TreeNode node = new TreeNode( Integer.parseInt( values[nodeIndex] ) ); 
        nodeIndex++;
        node.left = buildTree(values);
        nodeIndex++;
        node.right = buildTree(values);
        
        return node;
    }
    
    /* Works only for Complete and Full Binary Tree
    public String serialize(TreeNode root) {
        if( root == null ) return null;
        
        StringBuilder str = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer( root );
        
        int nonNull = 1;

        while( !queue.isEmpty() && nonNull > 0 ) {
                
            TreeNode curr = queue.poll();

            if( curr != null ) {

                str.append(curr.val);

                queue.offer( curr.left );   
                queue.offer( curr.right ); 

                --nonNull;

                if( curr.left != null ) {
                    ++nonNull;
                }
                if( curr.right != null ) {
                    ++nonNull;
                }
            } else {
                str.append("null");
            }

            if( !queue.isEmpty() && nonNull > 0 ) {
                str.append(",");
            }
        }
        
        return str.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if( data == null ) return null;
        
        String[] values = data.split(",");
        
        int size = values.length;
        
        TreeNode[] nodes = new TreeNode[size];
        
        for(int i=size-1; i>=0; i--) {

            if( !values[i].equals( "null" ) ) {
                
                nodes[i] = new TreeNode( Integer.parseInt(values[i]) );
                
                int left = (i*2)+1; 
                
                if( left < size ) {
                    nodes[i].left = nodes[left];
                    
                    if( left+1 < size ) {
                        nodes[i].right = nodes[left+1];
                    }
                }
            }
        }
        
        return nodes.length > 0 ? nodes[0] : null;
    }
    */
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
