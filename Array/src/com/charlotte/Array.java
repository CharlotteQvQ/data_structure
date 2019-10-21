package com.charlotte;

/**
 * @Author:Charlotte Li
 * @Date:2019-05-23 17:05
 * @Description:
 * @version:1.0
 */
public class Array<T> {
    //源数组
    private T[] data;
    //实际大小
    private int size;

    //带参构造函数
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    //无参构造函数(默认长度为10)
    public Array() {
        this(10);
    }

    //获取数组中元素个数
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向数组末尾添加一个元素
    public void addLast(T arg) {
        if (size == data.length)
            throw new IllegalArgumentException("addLast failed, array is already full.");

        data[size] = arg;
        size++;
    }

    //向数组某一位添加一个元素
    public void add(int index, T arg) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Require index > 0 and index <= size.");

        if (size == data.length)
            resize(data.length * 2);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = arg;
        size++;
    }

    //查询数组中某个元素
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");

        return data[index];
    }

    //修改数组中某个元素
    public void set(int index, T arg) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");

        data[index] = arg;
    }

    //删除数组中某个位置的元素,返回被删除的元素
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Delete failed.Index is illegal.");

        T result = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        //lazy
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return result;
    }

    //删除数组中的第一个元素,返回被删除的元素
    public T removeFirst() {
        return remove(0);
    }

    //删除数组中的最后一个元素,返回被删除的元素
    public T removeLast() {
        return remove(size - 1);
    }

    //删除数组中某个值为arg的元素
    public void removeElement(T arg) {
        int index = find(arg);
        if (index != -1)
            remove(index);
    }

    //查找数组中是否有该元素
    public boolean contains(T arg) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(arg))
                return true;
        }
        return false;
    }

    //查找数组中元素arg的索引，若不存在则返回-1
    public int find(T arg) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(arg))
                return i;
        }
        return -1;
    }

    //动态数组：自动扩容
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];

        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Size:%d，Capacity:%d \n", size, data.length));
        stringBuilder.append("Data:[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
