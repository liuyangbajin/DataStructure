package com.bj.bs.linklist;

public class T2 {

    public static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList();

        // 链表头部添加数据
        myLinkedList.addDataByFirst(5);
        myLinkedList.addDataByFirst(8);
        myLinkedList.addDataByFirst(3);
//
//        // 链表尾部添加数据
        myLinkedList.addDataByEnd(2);
        myLinkedList.addDataByEnd(1);
        myLinkedList.addDataByEnd(7);

        // 指定位置添加数据
        myLinkedList.addDataByIndex(0,8);
        myLinkedList.addDataByIndex(0,9);
        myLinkedList.addDataByIndex(0,1);

        System.out.println("在链表的第2个位置的元素是"+myLinkedList.getDataByIndex(2));
        myLinkedList.printList();
        System.out.println("\n开始删除元素后，剩余的");

        // 从头部删除元素
        myLinkedList.deleteDataByFirst();
        myLinkedList.deleteDataByFirst();
        myLinkedList.deleteDataByFirst();
        myLinkedList.printList();

        System.out.println("\n开始删除2号位元素");
        int deleteIndex = myLinkedList.deleteDataByIndex(2);
        myLinkedList.printList();
    }
}
