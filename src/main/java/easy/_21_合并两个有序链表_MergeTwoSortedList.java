package easy;

import java.util.LinkedList;

public class _21_合并两个有序链表_MergeTwoSortedList {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.addNode(2);
        l1.addNode(3);
        ListNode l2 = new ListNode(5);
        l2.addNode(6);
        l2.addNode(7);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(2);
//        for (int i = 2; i < 4; i++) {
//            l1.addNode(i);
//        }
//        l1.show();
//        l2.show();
        mysolution(l1,l2).show();
    }


//    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//    示例：
//
//    输入：1->2->4, 1->3->4
//    输出：1->1->2->3->4->4

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        while (l1.next != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }

        return l1;

    }

    public static ListNode mysolution(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null)
            return null;
        ListNode end = l1;
        while (end.next != null){
            end = end.next;
        }
        end.next = l2;

        

        return l1;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        public void addNode(int x){
            ListNode node = new ListNode(x);
//            System.out.println(this);
            ListNode temp = this;
//            System.out.println(temp);
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }

        public void show(){
            ListNode temp = this;
            while (temp.next != null){
                System.out.println(temp.val);
                temp = temp.next;
            }
            System.out.println(temp.val);

        }

    }

}
