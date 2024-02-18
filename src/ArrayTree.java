/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }

    @Override
    public String toString() {
        return helperString(this);
    }

    private String helperString(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return String.valueOf(node.val);
        return node.val + " " + helperString(node.left) + " " + helperString(node.right);
    }
}
public class ArrayTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeSubtree(nums,0,nums.length - 1);
    }

    private TreeNode makeSubtree(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftSubtree = null;
        TreeNode rightSubtree = null;
        if (start <= mid - 1)
            leftSubtree = makeSubtree(nums, start, mid - 1);
        if (end >= mid + 1)
            rightSubtree = makeSubtree(nums, mid + 1, end);
        root.left = leftSubtree;
        root.right = rightSubtree;
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ArrayTree tree = new ArrayTree();
        TreeNode root = tree.sortedArrayToBST(nums);
        System.out.println(root);
    }
}
