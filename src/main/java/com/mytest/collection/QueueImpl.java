/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.mytest.collection;

/**
 * @author resry.lqy
 * @version $Id: QueueImpl.java, v 0.1 2018-06-20 22:22 resry.lqy Exp $
 */
public class QueueImpl<T> implements Queue<T> {

    /** init */
    private static final int INIT_SIZE        = 16;
    /** default */
    private static final int DEFAULT_MAX_SIZE = 16;
    /** queue maxSize */
    private final int        maxSize;
    private T[]              elements;
    private int              front            = 0;
    private int              tail             = 0;

    public QueueImpl() {
        this(DEFAULT_MAX_SIZE);
    }

    public QueueImpl(int maxSize) {
        this.maxSize = maxSize;
        elements = (T[]) new Object[INIT_SIZE];
    }

    /**
     * @see com.mytest.collection.Queue#enqueue(java.lang.Object)
     */
    @Override
    public boolean enqueue(T element) {
        if (!adjustSize(front, tail + 1)) {
            return false;
        }
        elements[tail++] = element;
        return true;
    }

    /**
     * @see com.mytest.collection.Queue#dequeue()
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return elements[front++];
        }
    }

    /**
     * Before enqueue, adjusts the size to fit {@code newFront} and {@code newTail}
     * and set new {@code front} and {@code tail}
     *
     * @param newFront
     * @param newTail
     * @return whether the memory allocation is successful or not
     */
    private boolean adjustSize(int newFront, int newTail) {
        int newSize = newTail - newFront;
        if (newSize > maxSize) {
            return false;
        }
        if (newTail > elements.length) {
            T[] newElements = (T[]) new Object[Math.min(maxSize, elements.length * 2)];
            System.arraycopy(elements, newFront, newElements, 0, size());
            elements = newElements;
            front = 0;
            tail = newSize - 1;
        }
        return true;
    }

    @Override
    public int size() {
        return tail - front;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }
}
