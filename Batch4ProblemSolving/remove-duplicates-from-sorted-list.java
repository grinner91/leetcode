//83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        /*
            //step: iterate over nodes 
            //step: check if prev node is same, then skip/remov this 
        */
        //handle edge cases 
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head, prev = head;
        
        while(current != null) {
            if(current.val != prev.val) {
                prev.next = current;
                prev = current;
            }
            current = current.next;
        }
        
        prev.next = null;
        
        return head;
    }
}
