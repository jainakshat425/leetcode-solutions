class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] req = new int[26];
        List<String> ans = new ArrayList();
        
        for(String w : words2) {
            int[] count = countChars(w);
            
            for(int i=0; i<26; i++)
                req[i] = Math.max(req[i], count[i]);
        }
        
        for(String w : words1) {
            int[] count = countChars(w);
            
            boolean universal = true;
            for(int i=0; i<26; i++)
                if( req[i] > count[i] ) {
                    universal = false;
                    break;
                }
            
            if( universal )
                ans.add(w);
        }
        return ans;
    }
    
    private int[] countChars(String s) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++)
            count[s.charAt(i) - 'a'] += 1;
        return count;
    }
}
