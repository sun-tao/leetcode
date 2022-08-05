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
 
 //这题用虚拟头结点变得复杂了
 //而且最好使用pre和cur,不应该使用cur和cur_next，使用cur和cur_next造成需要对头结点进行单独处理，否则出现环
class Solution {
    //迭代法
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
    
    //迭代法
    public ListNode reverseList(ListNode head){
        //不用虚拟头结点，且用pre指针替代cur_next指针
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
        return pre;
    }
    
    //递归法
    public ListNode traversal(ListNode pre, ListNode cur){
        //边界条件
        if (cur == null){
            return pre;
        } 
        //单层逻辑
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        pre = traversal(pre,cur);
        return pre;
    }
    public ListNode reverseList(ListNode head){
        return traversal(null,head);
    }
}