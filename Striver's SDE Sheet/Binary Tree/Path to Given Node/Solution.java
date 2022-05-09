public class Solution {
    public int[] solve(TreeNode A, int B) {
        List<Integer> ans = new ArrayList();
        solve( A, B, ans );
        return listToArray( ans );
    }

    private boolean solve(TreeNode A, int B, List<Integer> ans) {
        if( A == null ) {
            return false;
        }

        ans.add( A.val );

        if( A.val == B ) {
            return true;
        }
        // Find in left subtree, if not found, find in right subtree
        if( solve( A.left, B, ans ) || solve( A.right, B, ans ) ) return true;

        // Remove current val from path if it's not the right path
        ans.remove( ans.size() - 1 );

        return false;
    }

    private int[] listToArray(List<Integer> list) {
        int n = list.size();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) 
            arr[i] = list.get(i);
        
        return arr;
    }
}
