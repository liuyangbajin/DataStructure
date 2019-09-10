package com.bj.bs.lineartable.linked_list;

/**
 * 结点
 *
 * 结点分为两部分，一部分存储数据，称为数据域，一部分存储下一个结点的位置，称为指针域
 * n个结点连成一条链式结构
 * */
public class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

    