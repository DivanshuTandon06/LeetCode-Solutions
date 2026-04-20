/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue <TreeNode> q =new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr ;
            List<Integer> level = new ArrayList<>();
            int s =q.size();

            for(int i = 0 ; i < s ;i++) {
                curr= q.poll();

                level.add(curr.val);
                if(curr.left != null) {
                q.add(curr.left);
                }
                if(curr.right != null) {
                q.add(curr.right);
                }
            }
        result.add(level);   
        }
    return result;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
