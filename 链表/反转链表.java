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
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur_next = head;
        ListNode cur = dummyHead;
        while(cur_next != null){
            ListNode cur_next_next = cur_next.next;
            cur_next.next = cur;
            //头结点特殊处理，防止出现环
            if (cur == dummyHead){
                cur.next = null;
            }
            cur = cur_next;
            cur_next = cur_next_next; 
        }
        //切断虚拟头结点
        ListNode newHead = cur;
        while(cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
}