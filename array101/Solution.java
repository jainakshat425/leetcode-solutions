class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroInd = 0;
        int twoInd = n-1;
        int i = 0;
        
        while( i <= twoInd ) {
            if( nums[i] == 0 ) 
                swap(i, zeroInd++, nums);
            if( nums[i] == 2 ) 
                swap(i, twoInd--, nums);
            else 
                i++;
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
