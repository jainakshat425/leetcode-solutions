class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String> ans = new ArrayList();
        solveWordBreak(0, n, s, listToSet(wordDict), new ArrayList(), ans);
        return ans;
    }
    
    private void solveWordBreak(int start, int n, String s, Set<String> dict, 
                           List<String> curr, List<String> ans) {
        if( start == n ) {
            ans.add( listToString(curr, ' ') );
            return;
        }
        
        for(int end=start; end<n; end++) {
            String word = s.substring(start, end+1);
            
            if( dict.contains(word) ) {
                curr.add( word );
                solveWordBreak(end+1, n, s, dict, curr, ans);
                curr.remove( curr.size()-1 );
            }
        }
    }
    
    private Set<String> listToSet(List<String> list) {
        Set<String> set = new HashSet();
        for(String str : list)
            set.add( str );
        return set;
    }
    
    private String listToString(List<String> list, char delimiter) {
        StringBuilder str = new StringBuilder();
        
        for(String item : list) {
            str.append(item);
            str.append(delimiter);
        }
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }
}
/*
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, listToSet(wordDict), new HashMap());
    }
    
    private List<String> wordBreak(String s, Set<String> dict, Map<String,List<String>> dp) {
        
        if( dp.containsKey(s) )
            return dp.get(s);
        
        List<String> ans = new ArrayList();
        
        if( dict.contains(s) ) {
            ans.add( s );
        }
        
        int n = s.length();
        
        for(int end=0; end<n; end++) {
            String word = s.substring(0, end+1);
            
            if( dict.contains(word) ) {
                List<String> subAns = wordBreak(s.substring(end+1, n), dict, dp);
                
                for(String str : subAns)
                    ans.add( word + " " + str );
            }
        }
        dp.put(s, ans);
        
        return ans;        
    }
    
    private Set<String> listToSet(List<String> list) {
        Set<String> set = new HashSet();
        for(String str : list)
            set.add( str );
        return set;
    }
}*/

