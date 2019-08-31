package leetcode;

import util.TreeNode;

/**
 * jh
 * 2019年08月31日  15：07
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class Q_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);



    }

    public TreeNode build(int[] preorder, int preBegin,int preEnd,   int[] inorder,int inBegin,int inEnd){
        if(preBegin>preEnd || inBegin>inEnd){
            return null;
        }


        TreeNode root = new TreeNode(preorder[preBegin]);
        int rootIndex = findRootIndex(root.val,inorder,inBegin,inEnd);
        root.left = build(preorder,preBegin+1,preBegin+rootIndex-inBegin,inorder,inBegin,rootIndex-1);
        root.right = build(preorder,preBegin+rootIndex-inBegin+1,preEnd,inorder,rootIndex+1,inEnd);
        return root;

    }



    public int findRootIndex(int rootValue,int[] inorder,int inBegin,int inEnd){
        for(int i = inBegin;i<=inEnd;i++){
            if(inorder[i] == rootValue){
                return i;
            }
        }
        return -1;
    }
}


















