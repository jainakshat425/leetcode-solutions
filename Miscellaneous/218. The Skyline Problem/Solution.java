class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        Pair[] pairs = new Pair[n*2];
        List<List<Integer>> ans = new ArrayList();
        int currMax = 0;
        TreeMap<Integer,Integer> heightCount = new TreeMap(Collections.reverseOrder());
        int i = 0;
        
        for(int[] building : buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];
            
            pairs[i++] = new Pair(start, -height);
            pairs[i++] = new Pair(end, height);
        }
        
        Arrays.sort(pairs);
        
        heightCount.put(0, 1);
        
        for(Pair pair : pairs) {
            // Is start?
            if( pair.ht < 0 ) 
                heightCount.put(-pair.ht, heightCount.getOrDefault(-pair.ht, 0) + 1);
            else { 
                // is end
                int count = heightCount.get(pair.ht);
                
                if( count == 1 )
                    heightCount.remove( pair.ht );
                else 
                    heightCount.put(pair.ht, count-1);
            }
            
            int newMax = heightCount.firstKey();
            if( newMax != currMax ) {
                currMax = newMax;
                ans.add(new ArrayList(){{ add(pair.x); add(newMax); }});
            }
        }
        return ans;
    }
    
    class Pair implements Comparable<Pair> {
        public int x, ht;
        
        public Pair(int x, int ht) {
            this.x = x;
            this.ht = ht;
        }
        
        @Override
        public int compareTo(Pair p2) {
            if( this.x != p2.x )
                return this.x - p2.x;
            else
                return this.ht - p2.ht;
        }
    }
}
/* 
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        Pair[] pairs = new Pair[n*2];
        List<List<Integer>> ans = new ArrayList();
        int currMax = 0;
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        int i = 0;
        
        for(int[] building : buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];
            
            pairs[i++] = new Pair(start, -height);
            pairs[i++] = new Pair(end, height);
        }
        
        Arrays.sort(pairs);
        
        queue.offer(0);
        
        for(Pair pair : pairs) {
            // Is start?
            if( pair.ht < 0 )
                queue.offer( -pair.ht );
            else // is end
                queue.remove( pair.ht );
            
            int newMax = queue.peek();
            if( newMax != currMax ) {
                currMax = newMax;
                ans.add(new ArrayList(){{ add(pair.x); add(newMax); }});
            }
        }
        return ans;
    }
    
    class Pair implements Comparable<Pair> {
        public int x, ht;
        
        public Pair(int x, int ht) {
            this.x = x;
            this.ht = ht;
        }
        
        @Override
        public int compareTo(Pair p2) {
            if( this.x != p2.x )
                return this.x - p2.x;
            else
                return this.ht - p2.ht;
        }
    }
}
*/
