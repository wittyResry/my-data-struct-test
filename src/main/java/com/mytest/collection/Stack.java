/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.mytest.collection;

/**
 * @author resry.lqy
 * @version $Id: Stack.java, v 0.1 2018-06-19 21:40 resry.lqy Exp $
 */
public interface Stack<T> {

    /**
     * pushes an element into the stack.
     *
     * @param element
     * @return
     */
    boolean push(T element);

    /**
     * the top element of the stack and remove the element from the stack
     *
     * @return the top element of the stack
     */
    T pop();

    /**
     * the size of the stack
     *
     * @return
     */
    int size();

    /**
     * whether the stack is empty or not
     *
     * @return
     */
    boolean isEmpty();

}
