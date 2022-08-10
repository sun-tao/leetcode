class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 双指针
        int p_s1 = 0;
        int p_s2 = 0;
        //sort
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> result = new HashSet<>();
        while(p_s1 < nums1.length && p_s2 < nums2.length){
            if (nums1[p_s1] < nums2[p_s2]){
                p_s1++;
            }
            else if (nums1[p_s1] > nums2[p_s2]){
                p_s2++;
            }
            else{ //nums1[p_s1] = nums1[p_s2]
                result.add(nums1[p_s1]);
                p_s1++;
                p_s2++;
            }
        }
        int [] f_result = result.stream().mapToInt(Integer::intValue).toArray();
        return f_result;
    }
}