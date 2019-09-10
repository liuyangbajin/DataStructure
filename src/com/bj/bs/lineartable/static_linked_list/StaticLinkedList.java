package com.bj.bs.lineartable.static_linked_list;

/**
 * 静态链表
 * */
public class StaticLinkedList<T> {

    // 封装的数组
    private Node<T>[] arr;

    /**
     * 初始化
     * */
    public StaticLinkedList(int length){

        arr = new Node[length];

        for(int i = 0; i < arr.length ;i++){

            arr[i] = new Node<>();
             // 非特殊点的元素游标为下一个元素的下标,
             // 第一个元素游标为除特殊点外，第一个没有数据的元素下标，现在链表为空，所以第一个元素的游标为1
            arr[i].cur = i + 1;
        }

        // 最后一个元素的游标为第一个存储数据元素的下标，但是现在链表为空，所以它的游标为0
        arr[arr.length - 1].cur = 0;
    }

    /**
     * 获取空闲结点的下标
     * */
    private int getEmptyNodeIndex(){

        // 获取第一个元素的游标，也就是一个数组中，第一个空闲元素的下标。默认为0
        int i = arr[0].cur;
        if(i != 0){

            // 第一个元素的游标指向的是数组中第一个数据无值的元素下标，因为要将空闲位置插入元素，
            // 所以将第一个元素（下标为0）的游标指向要插入值的元素之后的空闲元素下标
            arr[0].cur = arr[i].cur;
        }
        return i;
    }

    /**
     * 插入数据
     * */
    public void addDataByIndex(int index, T value){

        // 判断插入的位置是否有效
        if(index < 0 || index > arr.length){

            throw new IllegalArgumentException("位置无效");
        }

        // 第一步：获取可插入的位置下标
        int emptyNodeIndex = getEmptyNodeIndex();

        // 将数据插入
        arr[emptyNodeIndex].data = value;

        // 更新最后一个元素的游标，它指向的是第一个有数据元素的下标
        int k = arr.length - 1;

        // 第二步：根据要插入的是第几个位置，安装个数，从最后一个元素的游标开始往前推导，找出该元素所在游标
        for(int i = 1; i <= index - 1; i++){

            k = arr[k].cur;
        }

        // 更新刚插入数据的元素的游标为，他上一个元素的游标，也就是0，因为是从最后一个元素开始推的
        arr[emptyNodeIndex].cur = arr[k].cur;

        // 更新它上一个元素的游标为当前元素下标
        arr[k].cur = emptyNodeIndex;
    }
}
