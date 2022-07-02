class RandomizedCollection {
    // number -> (0 > index, 1 > count)
    private Map<Integer,LinkedHashSet<Integer>> numMap;
    private List<Integer> nums;
    private Random rand;
    
    public RandomizedCollection() {
        numMap = new HashMap();
        nums = new ArrayList();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        int newInd = nums.size();
        
        nums.add(val);
        
        LinkedHashSet<Integer> indices = numMap.getOrDefault(val, new LinkedHashSet());
        indices.add(newInd);        
        numMap.put(val, indices);
        
        return indices.size() == 1;
    }
    
    public boolean remove(int val) {
        LinkedHashSet<Integer> indices = numMap.get(val);
        
        if( indices == null || indices.size() == 0 )
            return false;
        
        int valInd = indices.iterator().next();
        indices.remove(valInd);
        int lastInd = nums.size() - 1;
        
        if( valInd != lastInd ) {
            
            int lastVal = nums.get(lastInd);
            nums.set(valInd, lastVal);
            
            LinkedHashSet<Integer> lastValIndices = numMap.get(lastVal);
            lastValIndices.remove(lastInd);
            lastValIndices.add(valInd);
        }
        nums.remove(lastInd);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
// class RandomizedCollection {
//     // number -> (0 > index, 1 > count)
//     private Map<Integer,PriorityQueue<Integer>> numMap;
//     private List<Integer> nums;
//     private Random rand;
    
//     public RandomizedCollection() {
//         numMap = new HashMap();
//         nums = new ArrayList();
//         rand = new Random();
//     }
    
//     public boolean insert(int val) {
//         int newInd = nums.size();
        
//         nums.add(val);
        
//         PriorityQueue<Integer> indexes = numMap.getOrDefault(
//             val, 
//             new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a))
//         );
//         indexes.offer(newInd);        
//         numMap.put(val, indexes);
        
//         return indexes.size() == 1;
//     }
    
//     public boolean remove(int val) {
//         PriorityQueue<Integer> indexes = numMap.get(val);
        
//         if( indexes == null || indexes.size() == 0 )
//             return false;
        
//         int valInd = indexes.poll();
//         int lastInd = nums.size() - 1;
        
//         if( valInd != lastInd ) {
            
//             int lastVal = nums.get(lastInd);
//             nums.set(valInd, lastVal);
            
//             PriorityQueue<Integer> pq = numMap.get(lastVal);
//             pq.poll();
//             pq.offer(valInd);
//         }
//         nums.remove(lastInd);
//         return true;
//     }
    
//     public int getRandom() {
//         return nums.get(rand.nextInt(nums.size()));
//     }
// }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
