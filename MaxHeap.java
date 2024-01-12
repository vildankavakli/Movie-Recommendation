/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresproject3;

/**
 *
 * @author Techno
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {

    T[] heap;
    int size;

    public MaxHeap(int capacity) {
        heap = (T[]) new Comparable[capacity];
        size = 0;
    }

    int parent(int idx) {
        return ((idx - 1) / 2);
    }

    void swap(int idx1, int idx2) {
        T temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }

    void insert(T data) { // Inserts an element into the heap
        if (size < heap.length) {
            heap[size] = data;
            int current = size++;

            while (heap[current].compareTo(heap[parent(current)]) > 0) {
                swap(current, parent(current));
                current = parent(current);
            }
        } else {
            System.out.println("Heap is full");
        }
    }

    void topDownHeapify(int idx) {
        // Performs top-down heapify operation starting from the given index

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int max = idx;

        if (left < size && heap[left].compareTo(heap[max]) > 0) {
            max = left;
        }
        if (right < size && heap[right].compareTo(heap[max]) > 0) {
            max = right;
        }

        if (max != idx) {
            swap(max, idx);
            topDownHeapify(max);
        }

    }

    T deleteMax() {
        // Deletes and returns the maximum element from the heap

        T deletedNode = heap[0];
        heap[0] = heap[size - 1];
        size--;
        topDownHeapify(0);
        return deletedNode;
    }

    void decreaseKey(int key, int amount) {
        // Decreases the value of the given key by the specified amount

        for (int i = 0; i < size; i++) {
            if (heap[i].equals(key)) {
                heap[i] = (T) Integer.valueOf(key - amount);
                while (heap[i].compareTo(heap[parent(i)]) < 0) {
                    swap(i, parent(i));
                    i = parent(i);

                }
                return;
            }
        }
    }

    void inreaseKey(int key, int amount) {
        // Increases the value of the given key by the specified amount

        for (int i = 0; i < size; i++) {
            if (heap[i].equals(key)) {
                heap[i] = (T) Integer.valueOf(key - amount);
                topDownHeapify(i);
                return;
            }
        }
    }

    void print() {
        // Prints the heap structure with parent, left child, and right child information

        for (int i = 0; i < parent(size - 1); i++) {//kaç seviye varsa 1 eksiği kadar gitmek yeterli olur
            int level = ((int) Math.log(i + 1) / (int) Math.log(2));
            System.out.println("Level: " + level);
            System.out.print("Parent: " + heap[i]);

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size) {
                System.out.print("\t\tLeft Child: " + heap[left]);
            } else {
                System.out.print("\t\tLeft Child: - ");
            }
            if (right < size) {
                System.out.print("\t\tRight Child: " + heap[right]);
            } else {
                System.out.print("\t\tRight Child: -");
            }
        }
    }
}
