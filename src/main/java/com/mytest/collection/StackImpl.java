/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.mytest.collection;

/**
 * @author resry.lqy
 * @version $Id: StackImpl.java, v 0.1 2018-06-19 21:50 resry.lqy Exp $
 */
public class StackImpl<T> implements Stack<T> {

    /** arrays */
    private T[]              elements;

    /** stack size */
    private int              top;

    /** INIT */
    private static final int INIT_SIZE = 16;

    public StackImpl() {
        elements = (T[]) new Object[INIT_SIZE];
        top = 0;
    }

    /**
     * @see com.mytest.collection.Stack#push(java.lang.Object)
     */
    @Override
    public boolean push(T element) {
        if (!adjustSize(top + 1)) {
            return false;
        }
        elements[++top] = element;
        return true;
    }

    /**
     * @see com.mytest.collection.Stack#pop()
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            return elements[top--];
        }
    }

    /**
     * @see com.mytest.collection.Stack#size()
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * @see com.mytest.collection.Stack#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * adjust size
     *
     * @param newSize
     * @return
     */
    private boolean adjustSize(int newSize) {
        if (newSize >= Integer.MAX_VALUE) {
            return false;
        }

        if (newSize >= elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        return true;
    }
}
