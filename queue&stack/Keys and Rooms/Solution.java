class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        /* 
        1. Created {visited} to store indices of the visited rooms.
        2. Create {queue} to store the keys and add 0 to the queue, as room 0 is not locked. 
        3. While there is key present in the queue
            - Get the key from the {queue} and add it to the the {visited}.
            - Get all the keys from current room, and if the respective room is not visited then add the key {room} to queue.
        4. Return true if the number of visited rooms matches total number of rooms
        */
        
        // Created {visited} to store indices of the visited rooms.
        Set<Integer> visited = new HashSet<Integer>();
        // Create {queue} to store the keys and add 0 to the queue, as room 0 is not locked. 
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer( 0 );
        
        // While there is key present in the queue
        while( !queue.isEmpty() ) {
            
            // Get the key from the {queue} and add it to the the {visited}.
            int roomNumber = queue.poll();
            visited.add( roomNumber );
            
            // Get all the keys from current room, and if the respective room is not visited then add the key {room} to queue.
            for(int room : rooms.get(roomNumber)) {
                if( !visited.contains( room ) ) {
                    queue.offer( room );
                }
            }
        }
        
        // Return true if the number of visited rooms matches total number of rooms
        return visited.size() == rooms.size();
    }
}
