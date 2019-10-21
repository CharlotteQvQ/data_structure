package com.charlotte;

/**
 * @Author:Charlotte Li
 * @Date:2019-06-02 00:03
 * @Description:
 * @version:1.0
 */
public interface Queue<T> {
    void enqueue(T arg);

    T dequeue();

    T getFront();

    int getSize();

    boolean isEmpty();
}
