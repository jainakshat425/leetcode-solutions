class Solution {
    public String intToRoman(int num) {
        int[] intVals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder builder = new StringBuilder();
        int i = 0;
        
        while(num > 0) {
            while(num >= intVals[i]) {
                num -= intVals[i];
                builder.append(romans[i]);
            }
            i++;
        }
        return builder.toString();
    }
}
