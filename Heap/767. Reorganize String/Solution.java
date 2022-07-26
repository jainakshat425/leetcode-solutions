class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        char[] ans = new char[n];
        int[] count = new int[26];
        int max = 0;
        char maxChar = 'a';
        int pos = 0;
        
        for(int i=0; i<n; i++)
            count[s.charAt(i)-'a'] += 1;
        
        for(int i=0; i<26; i++)
            if( count[i] > max ) {
                max = count[i];
                maxChar = (char)(i + 'a');
            }
        
        if( max > (n+1)/2 )
            return "";
        
        for(;max > 0; max--, pos += 2) 
            ans[pos] = maxChar;
        
        for(int i=0; i<n; i++) {
            char character = s.charAt(i);
            
            if( character == maxChar ) continue;
            
            int charInd = character - 'a';

            while( count[charInd]-- > 0 ) {
                if( pos >= n )
                    pos = 1;
                ans[pos] = character;
                pos += 2;
            }
        }
        return new String(ans);
    }
}
// class Solution {
//     public String reorganizeString(String s) {
//         int n = s.length();
//         int[] count = new int[26];
        
//         for(int i=0; i<n; i++)
//             count[s.charAt(i)-'a'] += 1;
        
//         PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[1], a[1]));
        
//         for(int i=0; i<26; i++)
//             maxHeap.offer(new int[]{ i, count[i] } );
        
//         if( maxHeap.peek()[1] > (n+1)/2 )
//             return "";
        
//         char[] ans = new char[n];
//         int pos = 0;
        
//         while( !maxHeap.isEmpty() ) {
//             char character = (char)(maxHeap.peek()[0] + 'a');
//             int cnt = maxHeap.peek()[1];
//             maxHeap.poll();
            
//             while( cnt-- > 0 ) {
//                 if( pos >= n )
//                     pos = 1;
//                 ans[pos] = character;
//                 pos += 2;
//             }
//         }
//         return new String(ans);
//     }
// }
