/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //相交的必要不充分条件是两个链表在当前结点处后续的长度一样
        //因此没有必要使用O(n^2)去遍历两个链表
        //只需要走到相同长度，然后同步往后遍历即可
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while(curA != null){
            curA = curA.next;
            lenA++;
        }
        while(curB != null){
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        while (lenA > lenB){
            curA = curA.next;
            lenA--;
        }
        while(lenA < lenB){
            curB = curB.next;
            lenB--;
        }
        while(lenA > 0){
            if (curA == curB){
                return curA;
            } 
            curA = curA.next;
            curB = curB.next;
            lenA--;
        }
        return null;
    }
}