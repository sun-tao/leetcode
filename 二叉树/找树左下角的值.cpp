class Solution {
public:
    int result;
    int maxDepth = 0;
    void traversal(TreeNode* root,int depth){
        //前序遍历
        if (root->left == nullptr && root->right == nullptr){
            if (depth > maxDepth){
                result = root->val;
                maxDepth = depth;
            }
        }

        if (root->left){
            depth++;
            traversal(root->left,depth);
            depth--;
        }

        if (root->right){
            depth++;
            traversal(root->right,depth);
            depth--;
        }
        return;
    }
    int findBottomLeftValue(TreeNode* root) {
        //回溯，深度
        if (root == nullptr){
            return 0;
        }

        traversal(root,1);
        return result;
    }
};