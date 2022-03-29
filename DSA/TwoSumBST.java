import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

/// The problem meant to resovle Twosum BST. 
// I wrote a simple BST insertion method I did not focus on quality for this part I only needed to build it.
public class TwoSumBST {

    static public class TreeNode {
        
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

            
    }
    
    static public class BST{


        static public TreeNode insert(Integer v, TreeNode root){
            TreeNode t = root;
            TreeNode r = t;
           
       
            int val  = (int) v;
            if (root == null) root = new TreeNode(val, null, null);
            else{
                while(t != null){
                    r = t;
                    if(val < t.val) t = t.left;
                    else if(val > t.val) t = t.right;
                    else break;
                    
                }
                if(val < r.val) r.left = new TreeNode(val);
                else r.right = new TreeNode(val);
            }
            return root;
          
        }
    }
    
    
    
    private static boolean findTarget(TreeNode root, int k) {
        
        Set <Integer> set = new HashSet<>();
        
        return findTarget(root, set, k);
        
    }

    private static boolean findTarget(TreeNode root, Set< Integer > set, int k){
        
        // PreOrder traversal.
        if(root != null){
            
            int x = k - root.val;
            if(set.contains(x)) return true;
            set.add(root.val);
            return findTarget(root.left, set, k) || findTarget(root.right, set, k);
            
        }
        
        return false;
        
    }

 
    
    public static void main(String[] args) throws Exception {

        Integer[] arr = {5,3,6,2,4,null,7};

        

        TreeNode root = new TreeNode (arr[0]);
       
        for(int i = 0; i< arr.length; i++){
         
            int left = i * 2 + 1;

            if(left < arr.length){
                if( arr[left] != null) root.left = BST.insert(arr[left], root.left);
                else root.left =null;
            } 
            
            int right = i * 2 + 2;
            if(right < arr.length) {
                if(arr[right] != null) root.right = BST.insert(arr[right], root.right);
                else root.right = null;
            }
            //root = BST.insert(arr[i], root);

        }

        int target = 9;
        boolean res = findTarget(root, target);
       
        
        System.out.println(res);
        
    }
}
