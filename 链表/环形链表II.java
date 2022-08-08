/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //哈希表法
        HashSet<ListNode> hs = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if (hs.contains(cur)){ //当前的结点是否在哈希表中已存在
                return cur;
            }
            hs.add(cur);
            cur = cur.next;
        }
        return null;
    }
}