class MyHashSet {
    private static final int INITIAL_SIZE = 1000;
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList<Integer>[] data;
    private int capacity, size;
    
    public MyHashSet() {
        capacity = INITIAL_SIZE;
        data = new LinkedList[capacity];
        size = 0;
    }
    
    public void add(int key) {
        if( contains(key) ) return;
        
        if( size == LOAD_FACTOR * capacity ) 
            rehash();
        
        addKey(key);
    }
    
    public void remove(int key) {
        int hash = hash(key);
        
        if( data[hash] == null ) return;
        
        Iterator<Integer> it = data[hash].listIterator();

        while( it.hasNext() ) {
            if( it.next() == key ) {
                it.remove();
                size--;
                break;
            }
        }
    }
    
    public boolean contains(int key) {
        int hash = hash(key);
        
        return data[hash] != null && data[hash].contains(key);
    }
    
    private void addKey(int key) {
        int hash = hash(key);
        
        if( data[hash] == null )
            data[hash] = new LinkedList();
        
        data[hash].add(key);
        size++;
    }
    
    private void rehash() { 
        LinkedList<Integer>[] old = data;
            
        capacity *= 2;
        size = 0;
        data = new LinkedList[capacity];

        for(int i=0; i<old.length; i++) {
            if( old[i] == null ) continue;

            for(int key : old[i]) addKey(key);
        }
    }
    
    private int hash(int key) {
        return key % capacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
