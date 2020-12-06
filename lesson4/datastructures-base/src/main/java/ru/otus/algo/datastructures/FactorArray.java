package ru.otus.algo.datastructures;

public class FactorArray<T> extends ResizableList<T> implements CustomList<T> {

    private double threshold = 0.7;
    private int factor = 2;
    private int size = 0;
    private T[] arr = (T[]) new Object[10];

    public FactorArray(int factor) {
        this.factor = factor;
        this.arr = (T[]) new Object[10];
    }

    public FactorArray() {
    }

    @Override
    public T add(T el) {
        if (((double)++size/arr.length) >= threshold) {
            T[] newArr = getNewArrayOfSize((arr.length * factor));
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
        if (((double)++size/arr.length) >= threshold) {
            T[] newArr = getNewArrayOfSize((arr.length * factor));
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
        if (((double)arr.length/size) >= 2 * factor) {
            T[] newArr = getNewArrayOfSize((size  * factor));
            shiftLeft(index, arr, newArr, size);
            arr = newArr;
            size--;
            return el;
        }
        shiftLeft(index, arr, arr, size);
        size--;
        return el;
    }

}
