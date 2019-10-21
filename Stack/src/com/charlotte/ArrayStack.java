package com.charlotte;

/**
 * @Author:Charlotte Li
 * @Date:2019-06-01 14:41
 * @Description:
 * @version:1.0
 */
public class ArrayStack<T> implements Stack<T> {
    Array<T> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T arg) {
        array.addLast(arg);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.get(array.getSize()-1);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack:[");
        for (int i = 0; i< array.getSize();i++){
            stringBuilder.append(array.get(i));
            if (i!=array.getSize()-1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("] top");

        return stringBuilder.toString();
    }
}
