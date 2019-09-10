package com.bj.bs.lineartable.linear_list;

/**
 * 线性表顺序存储
 * */
public class MyLinearList {

    /**
     * 保存线性表中的元素的数组
     * */
    private Model[] arr;

    /**
     * 线性表的最大长度
     * */
    private int maxLength;

    /**
     * 线性表的当前长度
     * */
    private int currentLength;

    MyLinearList(int maxLength){

        this.maxLength = maxLength;
        arr = new Model[maxLength - 1];
    }

    /**
     * 查询元素
     * */
    public Model getElement(int index){

        if (index < 0 || index > maxLength) {

            throw new RuntimeException("查询失败，查询的位置有瑕疵");
        }

        if(currentLength <= 0){

            throw new RuntimeException("元素查询失败，该列表中暂无可查询元素");
        }

        return arr[index];
    }

    /**
     * 指定位置进行插入操作
     * */
    public void insertElementByIndex(Model m, int index){

        if(index < 0 || index > maxLength - 1){

            throw new RuntimeException("元素插入失败，插入的位置有瑕疵");
        }

        if(currentLength >= maxLength){
            throw new RuntimeException("元素插入失败，线性表已满");
        }

        for (int n = arr.length-1; n > index; n--){

            arr[n] = arr[n-1];
        }
        arr[index] = m;
        currentLength++;
    }

    /**
     * 根据位置删除元素
     *
     * @return 被删除的元素
     */
    public Model deleteElementByIndex(int index){

        if(index < 0 || index > arr.length - 1){

            throw new RuntimeException("元素删除失败，删除的位置有瑕疵");
        }

        if(currentLength <= 0){

            throw new RuntimeException("元素删除失败，该列表中暂无可删除元素");
        }

        // 被删除的元素
        Model deleteModel = arr[index];

        for (int n = index; n < arr.length - 1; n++){

            arr[n] = arr[n + 1];
        }
        currentLength--;
        return deleteModel;
    }

    /**
     * 打印该线性表中的所有元素
     * */
    public void showList(){

        for (int n = 0; n<arr.length; n++){

            System.out.println(arr[n]+" ");
        }
    }
}
