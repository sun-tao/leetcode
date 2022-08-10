class Solution {
    private int add(int num){
        int sum = 0;
        while(num != 0){
            int yushu = num % 10 ;
            sum += yushu * yushu;
            num = num / 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        //实际本题只有两种情况
        //1.最终落到1
        //2.无限循环，有重复值,且该值<1000

        //哈希表检测重复值，若有直接return false
        //若落到1直接return true
        
        HashSet<Integer> hs = new HashSet<>();
        while(true){
            n= add(n);
            if (n == 1){
                return true;
            }
            if (hs.contains(n)){
                break;
            }
            hs.add(n);
        }
        return false;
    }
}