package ru.otus.algo.datastructures;

public class SingleArray<T> extends ResizableList<T> implements CustomList<T> {

    private T[] arr = (T[]) new Object[0];
    private int size = 0;


    public T add(T el) {
        T[] newArr = (T[]) new Object[++size];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[size-1] = el;
        arr = newArr;
        return newArr[size-1];
    }

    public T remove(T el) {
        T[] newArr = (T[]) new Object[--size];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(el)) {
                i++;
            }
            newArr[j++] = arr[i];
        }
        arr = newArr;
        return el;
    }

    public T get(int index) {
        return arr[index];
    }

    public T add(T el, int index) {
        T[] newArr = (T[]) new Object[++size];
        shiftRight(index, arr, newArr, size - 1);
        newArr[index] = el;
        arr = newArr;
        return newArr[index];
    }

    public T remove(int index) {
        T[] newArr = (T[]) new Object[--size];
        T el = arr[index];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        arr = newArr;
        return el;
    }

    public int size() {
        return size;
    }

}
