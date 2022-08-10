class Solution {
    private void printinfo(int [] arr){
        for (int i = 0 ; i < 26 ; i++){
            System.out.println(arr[i]);
        }
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int [] hashset_s = new int[26];
        int [] hashset_t = new int[26];
        char [] s1 = s.toCharArray();
        char [] t1 = t.toCharArray();
        for (int i = 0 ; i < s.length() ; i++){
           hashset_s[s1[i] - 'a']++;
        }

        for (int i = 0 ; i < t.length() ; i++){
            hashset_s[t1[i]-'a']--;
        }

        for (int i = 0 ; i < 26 ; i++){
            if (hashset_s[i] != 0){
                return false;
            }
        }
        return true;
    }
}