package com.bj.bs.linearlist;

public class T1 {

    public static void main(String[] args){

        MyLinearList myLinearList = new MyLinearList(10);

        // 指定位置插入元素
        myLinearList.insertElementByIndex(new Model(3), 0);
        myLinearList.insertElementByIndex(new Model(11),0);
        myLinearList.insertElementByIndex(new Model(13),0);
        myLinearList.insertElementByIndex(new Model(7),0);

        // 删除元素
        myLinearList.deleteElementByIndex(3);
        myLinearList.showList();

        // 获取线性表中的元素
        System.out.println("获取的数组元素是：" + myLinearList.getElement(2));
    }
}
