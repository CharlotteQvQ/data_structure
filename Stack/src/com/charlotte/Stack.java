package com.charlotte;

/**
 * @Author:Charlotte Li
 * @Date:2019-06-01 14:37
 * @Description:
 * @version:1.0
 */
public interface Stack<T> {
    int getSize();

    boolean isEmpty();

    void push(T arg);

    T pop();

    T peek();
}
