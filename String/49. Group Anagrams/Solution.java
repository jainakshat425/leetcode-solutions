class Solution {
    
    private String calculateHash(String str) {
        char[] charCount = new char[26];
        for(int i=0; i<str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
        }
        return new String(charCount);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String,List<String>> hashToAnagrams = new HashMap();
        
        for(String str : strs) {
            String hash = calculateHash(str);
            
            List<String> anagrams = hashToAnagrams.getOrDefault(hash, new ArrayList());
            anagrams.add( str );
            hashToAnagrams.put(hash, anagrams);
        }
       
        return new ArrayList(hashToAnagrams.values());
    }
}
/* 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<Integer,List<Integer>> hashToInd = new HashMap();
        Set<Integer> visited = new HashSet();
        List<List<String>> ans = new ArrayList();
        
        // n * 100
        for(int i=0; i<n; i++) {
            int hash = calculateHash(strs[i]);
            
            List<Integer> indexes = hashToInd.getOrDefault(hash, new ArrayList());
            indexes.add(i);
            hashToInd.put(hash, indexes);
        }
        
        // n * (100 + n)
        for(int i=0; i<n; i++) {
            
            if( visited.contains(i) )
                continue;
            
            visited.add(i);
            List<String> sublist = new ArrayList();
            sublist.add(strs[i]);
            ans.add(sublist);
            int hash = calculateHash(strs[i]);
            
            for(Integer j : hashToInd.get(hash)) {
                if( visited.contains(j) )
                    continue;
                
                if( isAnagram(strs[i], strs[j]) ) {
                    sublist.add(strs[j]);
                    visited.add(j);
                }
            }
        }
        return ans;
    }
    
    private int calculateHash(String str) {
        int n = str.length();
        int hash = 0;
        
        for(int i=0; i<n; i++)
            hash += str.charAt(i);
        
        return hash;
    }
    
    private boolean isAnagram(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        Map<Character,Integer> charCount = new HashMap();
        for(int i=0; i<n; i++) {
            char currChar = str1.charAt(i);
            int count = charCount.getOrDefault(currChar, 0);
            charCount.put(currChar, count+1);
        }
        int i = 0;
        for(; i<m; i++) {
            char currChar = str2.charAt(i);
            int count = charCount.getOrDefault(currChar, 0);
            if( count == 0 )
                return false;
            charCount.put(currChar, count-1);
        }
        return i == m;       
    }
}
*/
