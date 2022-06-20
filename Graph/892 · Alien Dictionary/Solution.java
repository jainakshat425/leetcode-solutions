public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        int n = words.length;
        Map<Character,Set<Character>> adj = new HashMap();
        Map<Character,Integer> indegree = new HashMap();
        Queue<Character> queue = new PriorityQueue();
        StringBuilder builder = new StringBuilder();

        // Build graph's adjacency list and indegree of each vertex
        for(int i=1; i<n; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            if( word1.length() > word2.length() && word1.startsWith(word2) )
                return "";

            int j = 0, k = 0;
            while(j < word1.length() && k < word2.length()) {
                char u = word1.charAt(j++);
                char v = word2.charAt(k++);

                if( !indegree.containsKey(u) )
                    indegree.put(u, 0);

                if( u != v ) {
                    Set<Character> neighbours = adj.getOrDefault(u, new HashSet());
                    if( !neighbours.contains(v) ) {
                        neighbours.add(v);
                        adj.put(u, neighbours);
                        indegree.put(v, indegree.getOrDefault(v, 0) + 1);
                    }
                    break;
                }
            }

            while(j < word1.length() ) {
                char u = word1.charAt(j++);
                if( !indegree.containsKey(u) )
                    indegree.put(u, 0);
            }
            while(k < word2.length()) {
                char v = word2.charAt(k++);
                if( !indegree.containsKey(v) )
                    indegree.put(v, 0);
            }
        }

        // Topological sort
        for(Character u : indegree.keySet()) {
            if( indegree.get(u) == 0 )
                queue.offer(u);
        }

        while( !queue.isEmpty() ) {
            char u = queue.poll();
            builder.append(u);

            if( adj.get(u) == null )
                continue;

            for(Character v : adj.get(u)) {
                int in = indegree.get(v) - 1;
                indegree.put(v, in);

                if( in == 0 )
                    queue.offer(v);
            }
        }
        // Check if all the characters are added to answer builder
        if( builder.length() != indegree.size() )
            return "";

        return builder.toString();
    }
}
