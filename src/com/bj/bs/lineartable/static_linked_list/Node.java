package com.bj.bs.lineartable.static_linked_list;

/**
 * 静态链表中的对象
 * */
public class Node<T> {

    // 数据
    T data;

    // 游标
    int cur;

    @Override
    public String toString() {
        return  "[ " + data + "_" +cur +" ]";
    }
}
