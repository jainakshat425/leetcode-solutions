class Solution {
    
    // Roman character to number mapping
    private static final Map<Character,Integer> romanMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    
    public int romanToInt(String s) {
        
        int n = s.length();
        
        int num = 0;
        int prev = 0;
        
        // Iterate from last roman character to first roman character
        for(int i=n-1; i>=0; i--) {
            
            // Get the number correponding to current roman character 
            int curr = romanMap.get( s.charAt(i) );
            
            // Add current number, if previous number was smaller
            if( curr >= prev ) {
                num += curr;
            } 
            // Subtract current number, if current number is smaller
            else {
                num -= curr;
            }
            
            prev = curr;
        }
        
        return num;
    }
}
