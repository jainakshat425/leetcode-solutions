class RandomizedSet {
    
    private List<Integer> list;
    private Map<Integer,Integer> map;
    private Random rand;
    
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if( map.containsKey(val) )
            return false;
        
        map.put(val, list.size());
        list.add( val );
        return true;
    }
    
    public boolean remove(int val) {
        if( !map.containsKey(val) )
            return false;
        
        int ind = map.get(val);
        int lastInd = list.size()-1;
        
        if( ind < lastInd ) {
            int lastVal = list.get( lastInd );
            list.set(ind, lastVal);
            map.put(lastVal, ind);
        }
        map.remove(val);
        list.remove(lastInd);
        return true;
    }
    
    public int getRandom() {
        return list.get( rand.nextInt( list.size() ) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
