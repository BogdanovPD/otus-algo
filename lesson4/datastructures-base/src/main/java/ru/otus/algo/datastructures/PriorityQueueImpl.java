package ru.otus.algo.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueueImpl<T> implements PriorityQueue<T> {

    private List<LinkedList<T>> listOfLists = new ArrayList<>();
    private int size = 0;

    @Override
    public void enqueue(int priority, T item) {
        if (priority < 0) {
            throw new IllegalArgumentException("Priority must be positive");
        }
        LinkedList<T> queue = getQueue(priority);
        queue.push(item);
        size++;
    }

    @Override
    public T dequeue() {
        for (LinkedList<T> queue : listOfLists) {
            if (queue != null) {
                T el = queue.pollFirst();
                if (el != null) {
                    size--;
                    return el;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private LinkedList<T> getQueue(int priority) {
        if (priority >= listOfLists.size()) {
            for (int i = listOfLists.size(); i <= priority; i++) {
                listOfLists.add(null);
            }
        }
        return getPriorityList(priority);
    }

    private LinkedList<T> getPriorityList(int priority) {
        LinkedList<T> queue = listOfLists.get(priority);
        if (queue == null) {
            listOfLists.set(priority, new LinkedList<>());
        }
        return listOfLists.get(priority);
    }

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueueImpl<>();
        priorityQueue.enqueue(4, "p");
        priorityQueue.enqueue(2, "e");
        priorityQueue.enqueue(3, "a");
        priorityQueue.enqueue(1, "h");
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.dequeue());
        }
    }
}
