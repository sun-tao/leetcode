class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mset = new int[26];
        char[] c_magazine = magazine.toCharArray();
        char[] c_ransomNote = ransomNote.toCharArray();
        for (int i = 0 ; i < c_magazine.length ; i++){
            mset[c_magazine[i] - 'a']++;
        }

        for (int i = 0 ; i < c_ransomNote.length ;i++){
            mset[c_ransomNote[i] - 'a']--;
        }

        for (int i = 0 ; i < mset.length ; i++){
            if (mset[i] < 0){
                return false;
            }
        }
        return true;
    }
}