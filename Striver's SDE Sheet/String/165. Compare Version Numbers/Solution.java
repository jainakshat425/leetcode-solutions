class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
                
        int i = 0;
        int j = 0;
        
        while( i < n1 || j < n2 ) {
            int num1 = 0;
            int num2 = 0;
            
            // Get number before "."
            while( i < n1 && version1.charAt(i) != '.' ) {
                num1 = num1*10 + (version1.charAt(i) - '0');
                i++;
            }
            
            while( j < n2 && version2.charAt(j) != '.' ) {
                num2 = num2*10 + (version2.charAt(j) - '0');
                j++;
            }
            
            if( num1 > num2 ) {
                return 1;
            }
            if( num2 > num1 ) {
                return -1;
            }
            
            i++;
            j++;
        }
        
        return 0;
    }
}
/*
class Solution {
    public int compareVersion(String version1, String version2) {
        // Split both version strings on dots "."
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int n1 = ver1.length;
        int n2 = ver2.length;
        
        int n = Math.max( n1, n2 );
        
        for(int i=0; i<n; i++) {
            // Take number from array if range has not exceed, else take 0
            int num1 = i < n1 ? Integer.parseInt( ver1[i] ) : 0;
            int num2 = i < n2 ? Integer.parseInt( ver2[i] ) : 0;
            
            if( num1 > num2 ) {
                return 1;
            }
            if( num2 > num1 ) {
                return -1;
            }
        }
        
        return 0;
    }
}*/
