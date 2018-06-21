/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.mytest.collection;

/**
 * @author resry.lqy
 * @version $Id: Queue.java, v 0.1 2018-06-20 22:22 resry.lqy Exp $
 */
public interface Queue<T> {
    /**
     * enqueue an {@code element} into the queue
     *
     * @param element the element to enqueue
     * @return enqueue successfully or not
     */
    boolean enqueue(T element);

    /**
     * @return the front element of the queue and remove the element from the queue
     */
    T dequeue();

    /**
     * @return size of queue
     */
    int size();

    /**
     * @return whether the queue is empty or not
     */
    boolean isEmpty();

}
