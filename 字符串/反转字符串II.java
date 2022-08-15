class Solution {
    private void reverseHelper(char [] s,int k){
        int left = 0;
        int right = k - 1;
        while(left < right){
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
        return;
    }

    //自己写的模拟有很多冗余的操作，比如反转2k个字符一定要将其复制到新的char[]数组里
    //其实没有这个复制的必要
    //直接原地对2k个字符中前k个进行交换就好了，更方便一点
    public String reverseStr(String s, int k) {
        //模拟
        char [] char_s = s.toCharArray();
        char [] temp = new char[2*k];
        int i = 0;
        for (; i < char_s.length ; i+=2*k){
            // System.out.println(i);
            if (i + 2*k > char_s.length){ 
                break;
            }
            System.arraycopy(char_s,i,temp,0,2*k);
            reverseHelper(temp,k);
            System.arraycopy(temp,0,char_s,i,2*k);
        }
        //末尾的元素处理
        if (char_s.length - i > k){
            System.arraycopy(char_s,i,temp,0,k);
            reverseHelper(temp,k);
            System.arraycopy(temp,0,char_s,i,k);
        }else{
            System.arraycopy(char_s,i,temp,0,char_s.length - i);
            reverseHelper(temp,char_s.length - i);
            System.arraycopy(temp,0,char_s,i,char_s.length - i);
        }
        String result = String.valueOf(char_s);
        return result;
    }
}