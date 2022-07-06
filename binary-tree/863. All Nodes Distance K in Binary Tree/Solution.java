/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList();
        Map<TreeNode,TreeNode> parent = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> visited = new HashSet();
        int dist = 0;
        
        dfs(root, null, parent);

        queue.offer(target);
        visited.add(target);
        visited.add(null);
            
        while( !queue.isEmpty() && dist != k ) {
            
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                TreeNode par = parent.get(node);
                                
                if( visited.add( par ) ) 
                    queue.offer( par );
                    
                if( visited.add( node.left ) ) 
                    queue.offer( node.left );
                    
                if( visited.add( node.right ) ) 
                    queue.offer( node.right );
            }
            dist++;
        }
        System.out.println(queue.size());

        while( !queue.isEmpty() )
            ans.add( queue.poll().val );
        
        return ans;
    }
    
    private void dfs(TreeNode curr, TreeNode prev, Map<TreeNode,TreeNode> parent) {
        if( curr == null )
            return;
        parent.put(curr, prev);
        dfs(curr.left, curr, parent);
        dfs(curr.right, curr, parent);
    }
}
