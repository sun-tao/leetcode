class Solution {
public:
    int result = INT_MAX;
    void traversal(TreeNode* root,int depth){
        //这样的写法默认root不为null
        if (root->left == nullptr && root->right == nullptr){//叶子节点
            //记录
            result = result < depth ? result : depth;
            return;
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
    int minDepth(TreeNode* root) {
        if (root == nullptr){
            return 0;
        }
        traversal(root,1);
        return result;
    }
};