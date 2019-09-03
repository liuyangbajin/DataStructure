package com.bj.bs.linklist;

/**
 * 线性表链式存储（单链表）
 * */
public class MyLinkedList<T> {

    // 链表的头结点
    private Node<T> head = null;

    // 当前结点
    private Node<T> currentNode;

    // 链表长度
    private int size;

    /************************************* 读 *************************************/
    /**
     * 根据index获取结点元素
     * */
    private Node<T> getNodeByIndex(int index){

        // 判断插入的位置是否真实有效
        if(index < 0 || index >= size){

            throw new IndexOutOfBoundsException("插入的位置无效");
        }

        // 通过next遍历链条
        currentNode = head;
        for (int n = 0; n < index && currentNode.next != null; n++){

            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * 根据index获取数据
     * */
    public T getDataByIndex(int index){

        getNodeByIndex(index);
        return currentNode == null ? null : currentNode.data;
    }

    /************************************* 增加 *************************************/
    /**
     * 在头部添加结点
     * */
    public void addDataByFirst(T data){

        // 封装结点
        Node<T> node = new Node (data);

        // 将原头结点添加到封装结点的指针域上
        node.next = head;

        // 将封装的结点设置成头结点
        head = node;

        // 链表长度+1
        size++;
    }

    /**
     * 在尾部添加结点
     * */
    public void addDataByEnd(T data){

        // 封装结点
        Node<T> node = new Node<>(data);

        // 如果链表为空，则设置成头结点
        if(head == null){
            addDataByFirst(data);
            return;
        }

        // 如果链表不为空，则找寻尾结点,将封装的结点设置到尾结点的指针域上
        Node temp = head;
        while (temp.next != null){

            temp = temp.next;
        }
        temp.next = node;

        // 链表长度+1
        size++;
    }

    /**
     * 在指定位置添加元素
     * */
    public void addDataByIndex(int index, T data){

        // 如果头结点是空
        if(head == null){

            addDataByFirst(data);
            return;
        }

        // 封装我们的结点
        Node<T> node = new Node<>(data);

        // 如果头结点不为空，则添加到指定位置
        getNodeByIndex(index);

        node.next = currentNode.next;
        currentNode.next = node;

        // 链表数量+1
        size++;
    }

    /************************************* 删除 *************************************/

    /**
     * 从顶部开始删除结点
     * */
    public void deleteDataByFirst(){

        // 判断链表是否还有值
        if(head == null){

            throw new IndexOutOfBoundsException("链表为空");
        }

        // 将头结点的下一个元素指向当前位置
        head = head.next;

        // 链表-1
        size--;
    }

    /**
     * 在指定位置删除结点
     * */
    public T deleteDataByIndex(int index){

        // 判断链表是否还有值
        if(head == null){

            throw new IndexOutOfBoundsException("链表为空");
        }

        // 把当前指针（currentNode）定位到 需删除结点（index）的前1个结点
        getNodeByIndex(index - 1);

        // 获取被删除结点的数据
        Node<T> deleteNode = currentNode.next;

        // 将需删除结点（index）的前1个结点 的下1个结点 设置为 需删除结点（index）的下1个结点
        currentNode.next = deleteNode.next;

        return deleteNode.data;
    }

    /**
     * 链表遍历
     * */
    public void printList() {

        Node tmp = head;
        while (tmp != null) {

            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
    }
}
