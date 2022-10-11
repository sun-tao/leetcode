class Solution {
    // 堆排序
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        buildHeap(nums,len);
        for (int i = 0 ; i < len ; i++){
            swap(nums,0,len-i-1);
            adjustHeap(nums,0,len-i-1);
        }
        return nums;   
    }

    private void buildHeap(int[] nums,int len){
        for (int i = len / 2 - 1 ; i >= 0 ; i--){
            adjustHeap(nums,i,len);
        } 
    }

    private void adjustHeap(int[] nums,int start,int len){
        // 调整大根堆，对当前给定的start所代表的子树，进行调整
        while(start * 2 + 1 < len){
            // 当前的跟节点确实是非叶子节点，所以必有孩子
            int lson = start * 2 + 1;
            int rson = start * 2 + 2;
            int large = start;
            if (lson < len && nums[lson] > nums[start]){
                large = lson;
            }
            else{
                large = start;
            }
            if (rson < len && nums[rson] > nums[large]){
                large = rson;
            }
            // 交换large和start(当前子树的跟节点)
            if (large != start){
                // 交换
                swap(nums,large,start);
                start = large;
            }
            else{
                break; // 当前根节点的子树不需要调整，在当前根节点范围内不调整，则默认在其下所有的子树
                       // 都不需要调整，原因是因为 从下往上 调整去进行排序的
            }
        }
    }
    private void swap(int[] nums,int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}