package ru.otus.algo.datastructures;

public abstract class ResizableList<T> {

    protected T[] getNewArrayOfSize(int size) {
        return (T[]) new Object[size];
    }

    protected void shiftRight(int index, T[] initArr, T[] newArr, int size) {
        if (index < 0) {
            throw new IllegalArgumentException("Element hasn't been found");
        }
        T prev = null;
        T curr;
        for (int i = 0; i < size; i++) {
            if (i >= index) {
                curr = initArr[i];
                newArr[i] = prev;
                prev = curr;
            } else {
                newArr[i] = initArr[i];
            }
        }
        if (newArr.length > size) {
            newArr[size] = initArr[size - 1];
        }
    }

    protected void shiftLeft(int index, T[] initArr, T[] newArr, int size) {
        if (index < 0) {
            throw new IllegalArgumentException("Element hasn't been found");
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                i++;
            }
            newArr[j++] = initArr[i];
        }
    }

    public int firstIndexOf(T el, T[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(el)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Element hasn't been found");
    }


}
