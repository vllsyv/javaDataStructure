package LeetCodeSolution.middle;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers

 */

public class addTwoNumbers{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);

        while(listNode != null ) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode h1 = l1;
        ListNode h2 = l2;
        boolean flag = false;
        ListNode sum = new ListNode(l1.val+l2.val);
        ListNode sumHead = sum;
        if(sum.val>=10) {
            flag = true;
            sum.val = sum.val%10;
        }
        l1=l1.next;
        l2=l2.next;

        while(l1!=null && l2!=null) {
            if(flag) {
                sum.next = new ListNode(l1.val+l2.val+1);
            } else {
                sum.next = new ListNode(l1.val+l2.val);
            }
            sum = sum.next;
            if(sum.val>=10) {
                flag = true;
                sum.val = sum.val%10;
            } else {
                flag = false;
            }

            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null) {
            if (flag) {
                sum.next = new ListNode(l1.val+1);
            } else {
                sum.next = new ListNode(l1.val);
            }
            sum = sum.next;
            if(sum.val>=10) {
                flag = true;
                sum.val = sum.val%10;
            } else {
                flag = false;
            }
            l1 = l1.next;
        }
        while (l2!=null) {
            if (flag) {
                sum.next = new ListNode(l2.val+1);
            } else {
                sum.next = new ListNode(l2.val);
            }
            sum = sum.next;
            if(sum.val>=10) {
                flag = true;
                sum.val = sum.val%10;
            } else {
                flag = false;
            }
            l2 = l2.next;
        }
        if(flag) {
            sum.next = new ListNode(1);
            sum.val = sum.val%10;
        }


        return sumHead;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
