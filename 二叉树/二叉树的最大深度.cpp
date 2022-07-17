//Method1,直接求深度
class Solution {
public:
    int result = 0;
    void traversal(TreeNode* root,int depth){
        if (root == nullptr){
            return;
        }
        result = result > depth ? result : depth;
        traversal(root->left,depth + 1);
        traversal(root->right,depth + 1);
    }
    int maxDepth(TreeNode* root) {
        traversal(root,1);
        return result;
    }
};


//Method2,间接求深度，求根节点高度
class Solution {
public:
    int maxDepth(TreeNode* root) {
        //后序遍历,相当于求根节点的高度了
         if (root == nullptr){
             return 0;
         }
         int left_h = maxdepth(root->left);
         int right_h = maxdepth(root->right);
         return max(left_h,right_h) + 1;
    }
};