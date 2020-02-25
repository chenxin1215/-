package 两数相加;

/**
 * <给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。>
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @Author: chenxin
 * @Date: 2020/2/20
 */
public class Main {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode result = new ListNode(0);
        ListNode temp = result;

        int t = 0;
        while (p != null || q != null) {

            int sum;
            if (p == null) {
                sum = q.val + t;
                q = q.next;
            } else if (q == null) {
                sum = p.val + t;
                p = p.next;
            } else {
                sum = p.val + q.val + t;
                p = p.next;
                q = q.next;
            }

            t = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        if (t > 0) {
            temp.next = new ListNode(t);
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode a1 = new ListNode(9);
        a.next = a1;
        ListNode a2 = new ListNode(9);
        a1.next = a2;

        ListNode b = new ListNode(0);
        ListNode b1 = new ListNode(1);
        b.next = b1;

        ListNode listNode = new Main().addTwoNumbers(a, b);

        listNode = listNode.next;
        while (listNode != null) {
            System.out.println("result = " + listNode.val);
            listNode = listNode.next;
        }

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}