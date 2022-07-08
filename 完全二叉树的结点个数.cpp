class Solution {
public:
    //不考虑完全二叉树的特性解法
    int totalNode = 0;
    void traversal(TreeNode* root){
        if (root == nullptr){
            return;
        }
        //能走到这说明root不是null
        totalNode++;
        //往下走
        traversal(root->left);
        traversal(root->right);
        return;
    }
    int countNodes(TreeNode* root) {
        traversal(root);
        return totalNode;
    }
};