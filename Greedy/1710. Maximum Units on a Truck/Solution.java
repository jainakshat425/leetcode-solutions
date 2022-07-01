class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        int ans = 0;
        int max = 0;
        
        for(int[] box : boxTypes)
            max = Math.max(max, box[1]);
        
        int[] noOfBoxes = new int[max+1 ];
        
        for(int[] box : boxTypes)
            noOfBoxes[box[1]] += box[0];
        
        for(int unitsPerBox=max; unitsPerBox>=0; unitsPerBox--) {
            
            if( noOfBoxes[unitsPerBox] <= truckSize ) {
                ans += noOfBoxes[unitsPerBox] * unitsPerBox;
                truckSize -= noOfBoxes[unitsPerBox];
                
            } else {
                ans += truckSize * unitsPerBox;
                return ans;
            }
        }
        return ans;
    }
}
// class Solution {
//     public int maximumUnits(int[][] boxTypes, int truckSize) {
//         int n = boxTypes.length;
//         int ans = 0;
        
//         Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        
//         for(int[] box : boxTypes) {
//             if( box[0] <= truckSize ) {
//                 ans += box[0] * box[1];
//                 truckSize -= box[0];
//             } else {
//                 ans += truckSize * box[1];
//                 return ans;
//             }
//         }
//         return ans;
//     }
// }
