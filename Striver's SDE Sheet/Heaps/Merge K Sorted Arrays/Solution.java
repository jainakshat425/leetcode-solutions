import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
        // stores int[3] (0 > array index, 1 > number index, 2 > number)
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        
        for(int i=0; i<k; i++) 
            queue.offer(new int[] {i, 0, kArrays.get(i).get(0)});
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            int arrInd = queue.peek()[0];
            int numInd = queue.peek()[1];
            int num = queue.peek()[2];
            queue.poll();
            ans.add(num);
            
            if( numInd+1 < kArrays.get(arrInd).size() ) 
                queue.offer(new int[] {arrInd, numInd+1, kArrays.get(arrInd).get(numInd+1)});
        }
        return ans;
	}
    
}
