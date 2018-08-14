package com.sagelu.javaproblems;

import org.junit.Test;

import java.util.Stack;

/**
 一、题目
 输入个链表的头结点，从尾到头反过来打印出每个结点的值。

 二、解题思路
 使用栈的方式进行。

 将链表从头到尾压入栈内，出栈的过程就对应着从尾到头。
 */
public class ReverseLinkList {
    /**
     * 结点对象
     */
    public  class ListNode {
        int val; // 结点的值
        ListNode nxt; // 下一个结点
    }

    @Test
    public  void printListInverse()throws Exception  {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3= new ListNode();
        listNode1.val=1;
        listNode1.nxt=listNode2;
        listNode2.val=2;
        listNode2.nxt=listNode3;
        listNode3.val=3;
        printListInverselyUsingIteration(listNode1);
    }
    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root 链表头结点
     */
    public  void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.nxt;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }
}
