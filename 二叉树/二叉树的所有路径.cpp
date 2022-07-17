class Solution {
private: 
    vector<string> result;
    int temp = 0;
    void traversal(TreeNode* root,string path){
        if (root->left == nullptr && root->right == nullptr){
            path += to_string(root->val);
            result.push_back(path);
            temp = (to_string(root->val)).size();
            path.resize(path.size()-temp);
            return;
        }
        path += to_string(root->val) + "->";
        if (root->left){
            traversal(root->left,path);
        }
        if (root->right){
            traversal(root->right,path);
        }
        temp = (to_string(root->val) + "->").size();
        path.resize(path.size()-temp);
        return;
    }
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        if (root == nullptr){
            return result;
        }
        string path = "";
        traversal(root,path);
        return result;
    }
};