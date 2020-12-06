package ru.otus.algo.datastructures;

public class VectorArray<T> extends ResizableList<T> implements CustomList<T> {

    private int size = 0;
    private int vector = 10;
    private T[] arr = (T[]) new Object[vector];

    public VectorArray(int vector) {
        this.vector = vector;
        this.arr = (T[]) new Object[vector];
    }

    public VectorArray() {
    }

    @Override
    public T add(T el) {
        if (++size == arr.length) {
            T[] newArr = getNewArrayOfSize(arr.length + vector);
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size-1] = el;
        return arr[size-1];
    }

    @Override
    public T remove(T el) {
        int index = firstIndexOf(el, arr, size);
        return removeElement(el, index);
    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public T add(T el, int index) {
        if (++size == arr.length) {
            T[] newArr = getNewArrayOfSize(arr.length + vector);
            shiftRight(index, arr, newArr, size);
            arr = newArr;
        } else {
            shiftRight(index, arr, arr, size);
        }
        arr[index] = el;
        return arr[index];
    }

    @Override
    public T remove(int index) {
        T el = arr[index];
        return removeElement(el, index);
    }

    @Override
    public int size() {
        return size;
    }

    private T removeElement(T el, int index) {
        if ((arr.length - size) == (2 * vector)) {
            T[] newArr = getNewArrayOfSize(arr.length  - vector);
            shiftLeft(index, arr, newArr, size);
            size--;
            arr = newArr;
            return el;
        }
        shiftLeft(index, arr, arr, size);
        size--;
        return el;
    }

}
