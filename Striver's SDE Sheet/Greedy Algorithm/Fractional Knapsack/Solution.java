/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        /* Sort the items in the descreasing order of 
        there value per weight */
        Arrays.sort(arr, new ItemComparator());
        
        double max = 0;
        
        for(Item item : arr) {
            
            // If remaining capacity is 0, knapsack is full
            if( W == 0 ) break;
            
            /* If current item's weight not more than the capacity
            then include the item in the knapsack */
            if( item.weight <= W ) {
                max += item.value;
                W -= item.weight;
            } else {
                /* Else store the fraction of the item updating remaining 
                capacity */
                max += (double)(item.value*W) / item.weight;
                W = 0;
            }
        }
        
        return max;
    }
}
class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        double valuePerWeight1 = (double)item1.value / item1.weight;
        double valuePerWeight2 = (double)item2.value / item2.weight;
        
        if( valuePerWeight2 > valuePerWeight1 ) {
            return 1;
        } else if( valuePerWeight2 < valuePerWeight1  ) {
            return -1;
        } 
        return 0;
    }
}
