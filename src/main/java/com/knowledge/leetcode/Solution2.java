package com.knowledge.leetcode;

/*** 
 * @ClassName Solution2
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/13 12:45
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class Solution2 {

    public static void main(String []args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(l1.val+l2.val);
        if (l1.next == null || l2.next == null) {
            return newNode;
        }
        newNode.next = addTwoNumbers(l1.next, l2.next);
        return newNode;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

}