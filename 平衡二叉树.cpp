class Solution {
public:
    int traversal(TreeNode* root){
        if (root == nullptr){
            return 0;
        }

        int leftHeight = traversal(root->left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = traversal(root->right);
        if (rightHeight == -1){
            return -1;
        }
        if (leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1){
            return -1;
        }
        return max(leftHeight,rightHeight) + 1;
    }
    bool isBalanced(TreeNode* root) {
        int flag = traversal(root);
        if (flag == -1){
            return false;
        }
        return true;
    }
};