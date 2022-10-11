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
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode tmp = head;
        List<Integer> l = new ArrayList<>();
        while(tmp != null){
            l.add(tmp.val);
            tmp = tmp.next;
        }
        int left = 0;
        int right = l.size() - 1;
        while(left < right){
            if (l.get(left) != l.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true; 
    }
}