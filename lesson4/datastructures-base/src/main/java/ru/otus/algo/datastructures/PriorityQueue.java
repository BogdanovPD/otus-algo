package ru.otus.algo.datastructures;

public interface PriorityQueue<T> {

    void enqueue(int priority, T item);
    T dequeue();

    int size();
}
