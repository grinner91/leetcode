//876. Middle of the Linked List
//https://leetcode.com/problems/middle-of-the-linked-list/
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
    public ListNode middleNode(ListNode head) {
        /*
        step: slow and fast pointer, fast traverses 2-wice as fast than slow 
        step: iterate over nodes 
        step: slow will be in the middle and fast will be in the end 
        
        */
        
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
