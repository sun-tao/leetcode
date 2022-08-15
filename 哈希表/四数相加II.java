class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums1.length ; i++){
            for (int j = 0 ; j < nums2.length ; j++){
                int temp = nums1[i] + nums2[j];
                if (map.containsKey(temp)){
                    int oldnum = map.get(temp);
                    oldnum++; 
                    //map.put(temp,oldnum)也可以，因为当键存在的时候再插入会替换value
                    map.replace(temp,oldnum);
                }
                else{
                    map.put(temp,1);
                }
            }
        }
        int result = 0;
        for (int i = 0 ; i < nums3.length; i++){
            for (int j = 0 ; j < nums4.length ; j++){
                int temp = nums3[i] + nums4[j];
                if (map.containsKey(-temp)){
                    result += map.get(-temp);
                }
            }
        }
        return result;
    }
}