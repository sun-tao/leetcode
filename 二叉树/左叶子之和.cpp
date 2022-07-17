class Solution {
public:
    int result = 0;
    void traversal(TreeNode* root,bool isLeft){
        if (root->left == nullptr && root->right == nullptr){
            if (isLeft){
                result += root->val;
            }
            return;
        }

        if (root->left){
            traversal(root->left,true);
        }
        if (root->right){
            traversal(root->right,false);
        }
        return;
    }
    int sumOfLeftLeaves(TreeNode* root) {
        if (root == nullptr){
            return result;
        }

        traversal(root,false);
        return result;
    }
};