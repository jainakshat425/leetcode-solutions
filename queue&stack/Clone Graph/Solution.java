/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
        
    public Node cloneGraph(Node node) {
        /* 
        1. Create map {cloneMap} to store original to clone nodes mapping.
        2. Store the first node {node} and it's clone to the map.
        3. Create a {queue} to store nodes for BFS traversal and {node} to it.
        4. Repeat while {queue} is not empty
            - Get head node {curr} from the {queue} and clone of the head node {currClone} from {cloneMap}.
            - Repeat for neighbors of {curr} node
                - If {neighbor} is not cloned
                    - Clone {neighbor} node to {neighborClone} and the mapping to {cloneMap}
                    - Add the {neighbor} node to {queue}
                - else get the {neighbor}'s clone from map {cloneMap}
                - Add {neighborClone} to the list of neighbors of {neighborClone}.
        */
        
        if( node == null ) return null;
        
        // Create map {cloneMap} to store original to clone nodes mapping.
        Map<Node,Node> cloneMap = new HashMap<>();
        // Store the first node {node} and it's clone to the map.
        cloneMap.put(node, new Node(node.val));
        
        // Create a {queue} to store nodes for BFS traversal and {node} to it.
        Queue<Node> queue = new LinkedList<Node>();        
        queue.offer( node );
        
        // Repeat while {queue} is not empty
        while( !queue.isEmpty() ) {
            
            // Get head node {curr} from the {queue} and clone of the head node {currClone} from {cloneMap}.
            Node curr = queue.poll();
            Node currClone = cloneMap.get( curr );
            
            // Repeat for neighbors of {curr} node
            for(Node neighbor : curr.neighbors) {
                
                Node neighborClone;
                
                // If {neighbor} is not cloned
                if( !cloneMap.containsKey( neighbor ) ) {
                    
                    // Clone {neighbor} node to {neighborClone} and the mapping to {cloneMap}
                    neighborClone = new Node(neighbor.val);
                    cloneMap.put(neighbor, neighborClone);
                    
                    // Add the {neighbor} node to {queue}
                    queue.offer( neighbor );
                    
                } else {
                    // else get the {neighbor}'s clone from map {cloneMap}
                    neighborClone = cloneMap.get( neighbor );
                }
                
                // Add {neighborClone} to the list of neighbors of {neighborClone}.
                currClone.neighbors.add( neighborClone );
            }
        }
        
        return cloneMap.get( node );
    }
}
