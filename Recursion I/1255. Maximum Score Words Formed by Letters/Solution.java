class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] allowedChars = new int[26];
        
        for(char letter : letters)
            allowedChars[letter-'a'] += 1;
        
        return maxScore(0, words, allowedChars, score);
    }
    
    private int maxScore(int start, String[] words, int[] allowedChars, int[] score) {
        if( start == words.length )
            return 0;
        
        int max = 0;
        
        for(int i = start; i < words.length; i++) {
            int curScore = 0;
            int[] allowed = allowedChars.clone();
            String word = words[i];
            
            for(int j=0; j<word.length(); j++) {
                int charInd = word.charAt(j) - 'a';

                if( allowed[charInd] == 0 ) {
                    curScore = 0;
                    break;
                }
                allowed[charInd] -= 1;
                curScore += score[charInd];
            }
            if( curScore != 0 )
                max = Math.max(max, curScore + maxScore(i+1, words, allowed, score));
        }
        return max;
    }
}
// class Solution {
//     public int maxScoreWords(String[] words, char[] letters, int[] score) {
//         int[] allowedChars = new int[26];
        
//         for(char letter : letters)
//             allowedChars[letter-'a'] += 1;
        
//         int max = 0;
        
//         for(String word : words) {
//             int curScore = 0;
//             int[] seenChars = new int[26];
            
//             for(int i=0; i<word.length(); i++) {
//                 int charInd = word.charAt(i) - 'a';
                
//                 seenChars[charInd] += 1;
                
//                 if( seenChars[charInd] > allowedChars[charInd] ) {
//                     System.out.println(word + " not valid");
//                     curScore = 0;
//                     break;
//                 }
                    
//                 curScore += score[charInd];
//             }
//             max = Math.max(max, curScore);
//         }
//         return max;
//     }
// }
