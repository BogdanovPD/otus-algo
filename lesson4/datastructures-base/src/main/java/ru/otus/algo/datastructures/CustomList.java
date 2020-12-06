package ru.otus.algo.datastructures;

public interface CustomList<T> {

    T add(T el);
    T add(T el, int index);
    T remove(T el);
    T remove(int index);
    T get(int index);
    int size();

}
