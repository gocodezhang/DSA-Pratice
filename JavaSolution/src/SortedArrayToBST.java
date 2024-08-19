public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }
    public TreeNode dfs(int left, int right, int[] nums) {
        // base case
        if (left > right) {
            return null;
        }
        // recursive case
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(left, mid - 1, nums);
        root.right = dfs(mid + 1, right, nums);

        return root;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        System.out.println(sortedArrayToBST.sortedArrayToBST(nums));
    }
}
