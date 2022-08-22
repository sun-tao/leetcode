class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 排序+哈希
        // O(nlogn)
        int [] nums1 = new int[nums.length];
        System.arraycopy(nums,0,nums1,0,nums.length);
        Arrays.sort(nums1);
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0 ; i < nums1.length; i++){
            if (i >= 1 && nums1[i] == nums1[i-1]){
                cnt++;
                continue;
            }
            map.put(nums1[i],cnt++);
        }
        for (int i = 0 ; i < nums.length ; i++){
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}