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

        //todo 无环的情况是快指针是有结束的节点的
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //结束的条件是快指针和慢指针相等就是有环的
            if (slow == fast) return true;
        }
        return false;
    }

    //相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return new ListNode(1);
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

    public void testHasCycle(){
        ListNode head=new ListNode(1);
        ListNode tail=new ListNode(2);
        head.next=tail;

    }
}
