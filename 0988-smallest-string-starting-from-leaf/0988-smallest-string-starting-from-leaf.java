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
    /*String smallestString = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return smallestString;
    }

    // Helper function to find the lexicographically smallest string
    void dfs(TreeNode root, String currentString) {

        // If the current node is NULL, return
        if (root == null) {
            return;
        }

        // Construct the current string by appending 
        // the character corresponding to the node's value
        currentString = (char) (root.val + 'a') + currentString;

        // If the current node is a leaf node
        if (root.left == null && root.right == null) {

            // If the current string is smaller than the result 
            // or if the result is empty
            if (smallestString.isEmpty() || smallestString.compareTo(currentString) > 0) {
                smallestString = currentString;
            }
        }

        // Recursively traverse the left subtree
        if (root.left != null) {
            dfs(root.left, currentString);
        } 

        // Recursively traverse the right subtree
        if (root.right != null) {
            dfs(root.right, currentString);
        }

    }*/
    
    StringBuilder strB = new StringBuilder();
    String smallerString = "";
    
    public String smallestFromLeaf(TreeNode root) {
        getSmallestString(root);
        return smallerString;
    }
    
    private void getSmallestString(TreeNode root){
        if(root == null)
            return;
        
        //append curr value to string
        strB.append((char)(root.val + 'a'));
        
        
        //if its leaf node
        if(root.left == null && root.right == null){
            //check the strB formed , first reverse it because we need string from leaf to root, check if it is smaller than res if yes update the res
            //System.out.println("Reached Leaf Node : " + strB.toString());
            String currString = new StringBuilder(strB).reverse().toString();
            if(smallerString.isEmpty() || smallerString.compareTo(currString) > 0){
                 smallerString = currString;
            }  
        }
        
        getSmallestString(root.left);
        getSmallestString(root.right);
        
        //System.out.println("Before going back : " + strB.toString());
        strB.deleteCharAt(strB.length() - 1);  
    }     
}