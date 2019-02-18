package leetcode.cn.explore.datastructure.link;

/**
 * edited by AndersonKim
 * at 2019/2/18
 */
public class Solution {
    //节点的CRUD操作
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //快慢指针的问题，若是有环，快指针是会追上慢指针的。
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }



    //快慢指针的模板
    // Initialize slow & fast pointers
    ListNode head;
    ListNode slow = head;
    ListNode fast = head;
    public boolean templete(){
        /**
         * Change this condition to fit specific problem.
         * Attention: remember to avoid null-pointer error
         **/
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;           // move slow pointer one step each time
            fast = fast.next.next;      // move fast pointer two steps each time
            if (slow == fast) {         // change this condition to fit specific problem
                return true;
            }
        }
        return false;   // change return value to fit specific problem
    }

}
