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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //常规解法，找到倒数第n个是正数第几个，删除它，两趟遍历
        ListNode dummyHead = new ListNode(0);
        int len = 0;
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        int index = len - n;
        cur = dummyHead;
        while(index > 1){
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }
    
    //一趟遍历
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while(n >= 0){
            fast = fast.next;
            n--;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}

