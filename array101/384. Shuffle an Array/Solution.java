class Solution {

    private int len;
    private int[] original;
    private int[] shuffled;
    private Random rand;
    
    public Solution(int[] nums) {
        len = nums.length;
        original = nums;
        shuffled = arrayCopy(nums, len);
        rand = new Random();
    }
    
    private int[] arrayCopy(int[] arr, int n) {
        int[] copy = new int[n];
        for(int i=0; i<n; i++)
            copy[i] = arr[i];
        return copy;
    }
    
    private int randomFromRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        
        for(int i=0; i<len; i++) {
            swap(shuffled, i, randomFromRange(i, len));
        }
        
        return shuffled;
    }
    
    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
