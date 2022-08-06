/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // 每次站在当前待交换的两个结点的角度考虑，处理当前结点的交换和后面结点的指向问题,而不用考虑前面结
    // 点对于当前结点的指向，写起来较复杂
    public ListNode swapPairs(ListNode head) {
       if (head == null){
           return head;
       }
       ListNode cur = head;
       //特殊情况，只有一个元素的链表,不需要交换
       if (cur.next == null){
           return head;
       }
       ListNode cur_next = cur.next;
       head = cur_next;
       while(cur != null && cur_next != null){
           ListNode cur_next_next = cur_next.next;
           cur_next.next = cur;
           if (cur_next_next != null && cur_next_next.next != null){
               cur.next = cur_next_next.next;
               cur = cur_next_next;
               cur_next = cur_next_next.next;
           }
           else{
               cur.next = cur_next_next;
               cur = cur_next_next;
               if (cur_next_next != null){
                   cur_next = cur_next_next.next;
               }
               else{
                   cur_next = null;
               }
           }
       }
       return head;
   }
    
    //每次站在前面一轮已经交换好了的结点的位置出发进行考虑(待交换的两个结点的前一个结点)
    public ListNode swapPairs(ListNode head){
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next != null && cur.next.next != null){
            ListNode cur_next = cur.next;
            ListNode cur_next_next = cur.next.next;
            ListNode cur_next_next_next = cur.next.next.next;
            cur.next = cur_next_next;
            cur_next_next.next = cur_next;
            cur_next.next = cur_next_next_next;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}