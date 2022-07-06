class MyHashMap {
    
    private static final int SIZE = 769;
    private LinkedList<Entry>[] data;
    
    public MyHashMap() {
        data = new LinkedList[SIZE];
    }
    
    public void put(int key, int value) {
        int h = hash(key);
        
        if( data[h] == null ) 
            data[h] = new LinkedList(){{ add(new Entry(key,value)); }};
        else {
            for(Entry e : data[h]) 
                if( e.key == key ) {
                    e.val = value;
                    return;
                }
            data[h].add(new Entry(key,value));
        }
    }
    
    public int get(int key) {
        int h = hash(key);
        
        if( data[h] == null ) return -1;
        
        for(Entry e : data[h]) 
            if( e.key == key )
                return e.val;
        
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        
        if( data[h] == null ) return;
        
        Entry toRemove = null;
        
        for(Entry e : data[h]) 
            if( e.key == key ) {
                toRemove = e;
                break;
            }
         
        if( toRemove != null )
            data[h].remove( toRemove );
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    class Entry {
        public int key, val;
        
        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
