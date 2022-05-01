class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        int n = s.length();
        
        int substrCount = (1<<n) - 1;
        
        List<String> result = new ArrayList<>(substrCount);
        
        for(int i=1; i<=substrCount; i++) {
            
            StringBuilder substr = new StringBuilder();
            
            for(int j=0; j<n; j++) {
                
                // Check if jth bit of current combination is set or not
                if( (i & 1<<j) != 0 ) {
                    // If set, current character will be included
                    substr.append( s.charAt(j) );
                }
            }
            
            result.add( substr.toString() );
        }
        
        Collections.sort( result );
        
        return result;
    }
    /*
    public List<String> AllPossibleStrings(String s)
    {
        List<String> result = new ArrayList<>();
        
        AllPossibleStrings(s, 0, new StringBuilder(), result);
        
        Collections.sort( result );
        
        return result;
    }
    
    private void AllPossibleStrings(String str, int index, StringBuilder substr, List<String> result) {
        
        if( index == str.length() ) {
            if( substr.length() > 0 ) {
                result.add( substr.toString() );
            }
            return;
        }
        
        substr.append( str.charAt( index ) );
        AllPossibleStrings(str, index+1, substr, result);
        substr.deleteCharAt( substr.length() - 1 );
        
        AllPossibleStrings(str, index+1, substr, result);
    }
    */
}
