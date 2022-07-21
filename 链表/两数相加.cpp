class Solution {
public:
    void addList(ListNode* l1,ListNode* l2){ //l1永远是长的
        ListNode* cur1 = l1;
        ListNode* cur2 = l2;
        int extra = 0; // 进位
         while(cur1 && cur2){
                cur1->val += cur2->val + extra;
                if (cur1->val >= 10){
                    cur1->val -= 10;
                    extra = 1;
                }else{
                    extra = 0;
                }
                if (cur1->next == nullptr && cur2->next == nullptr){
                    break;
                }
                cur1 = cur1->next;
                cur2 = cur2->next;
            }
            //此时是针对,cur1比cur2长的情况进行处理的
            //如果cur1和cur2都不为null，则肯定是cur1和cur2一样长，此时就不能再进入这边
            //否则余数处理就会出错
            while(cur1 && !cur2){
                cur1->val += extra;
                if (cur1->val == 10){
                    cur1->val -= 10;
                    extra = 1;
                }else{
                    extra = 0;
                }
                if (cur1->next == nullptr){
                    break;
                }
                cur1 = cur1->next;
            }
            //遍历完了,现在到最后一个元素了
            if (extra == 1){
                cur1->next = new ListNode(1);
            }
            return;
    }
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode* cur = l1;
        while(cur != nullptr){
            len1 ++;
            cur = cur->next;
        }
        cur = l2;
        while(cur != nullptr){
            len2 ++;
            cur = cur->next;
        }

        if (len1 < len2){
            ListNode* temp = l2;
            l2 = l1;
            l1 = temp;
        }
        addList(l1,l2);
        return l1;
    }
};