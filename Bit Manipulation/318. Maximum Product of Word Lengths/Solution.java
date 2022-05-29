class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmask = new int[n]; 
        int max = 0;

        for(int i=0; i<n; i++) {
            // Calculate bitmask for current word
            for(int j=0; j<words[i].length(); j++) {
                // index will be - for a -> 0, b -> 1, c -> 2 and so on
                int index = words[i].charAt(j) - 'a';
                
                // left shift 1 by index and OR it with the current bitmask
                bitmask[i] |= (1 << index);
            }
            
            // Compare bitmask of current string with previous strings bitmask
            for(int j=0; j<i; j++) {
                /* If there is a 1 at the same index of current string {i} and {j},
                then bitmask of i and j string will result in a number greater than 0,
                else it will result in 0 */
                if( (bitmask[i] & bitmask[j]) == 0 ) 
                    max = Math.max(max, words[i].length()*words[j].length());	
            }
        }

        return max;
    }
}

/*
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        List<Set<Character>> lst = new ArrayList(n);
        int max = 0;

        for(String word : words) {	
            Set<Character> set = new HashSet();
            lst.add(set);
            for(int i=0; i<word.length(); i++) {
                set.add( word.charAt(i) );
            }
        }

        for(int i=0; i<n; i++) {
            Set<Character> setI = lst.get(i);
            for(int j=i+1; j<n; j++) {
                boolean hasCommon = false;
                Set<Character> setJ = lst.get(j);
                for(Character c : setI) {
                    if( setJ.contains(c) ) {
                        hasCommon = true;
                        break;
                    }
                }

                if( !hasCommon ) 
                    max = Math.max(max, words[i].length()*words[j].length());	
            }
        }
        return max;
    }
}
*/
