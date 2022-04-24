class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums, 0, n);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=0; i<n; i++) {
            
            // Avoid duplicate number
            if(  i != 0 && nums[i-1] == nums[i] ) {
                continue;
            }
            
            for(int j=i+1; j<n; j++) {
            
                // Avoid duplicate number
                if(  j != i+1 && nums[j-1] == nums[j] ) {
                    continue;
                }
                
                int diff = target - nums[i] - nums[j];
                
                int left = j+1, right = n-1;
                
                while( left < right ) {
                    
                    // Avoid duplicate number
                    if( left != j+1 && nums[left-1] == nums[left] ) {
                        left++;
                        continue;
                    }
                    // Avoid duplicate number
                    if( right != n-1 && nums[right+1] == nums[right] ) {
                        right--;
                        continue;
                    }
                    
                    int sum = nums[left] + nums[right];
                    
                    if( sum == diff ) {
                        
                        result.add( new ArrayList<Integer>(
                            List.of(nums[i], nums[j], nums[left], nums[right])
                        ));
                        
                        right--;
                        left++;
                        
                    } else if( sum > diff ) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        
        return result;
    }
}
