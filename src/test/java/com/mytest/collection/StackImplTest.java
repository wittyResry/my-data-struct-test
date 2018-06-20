package com.mytest.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author resry.lqy
 * @version $Id: StackImplTest.java, v 0.1 2018-06-19 22:08 resry.lqy Exp $
 */
public class StackImplTest {

    @Test
    public void push() {
        Stack<Integer> stack = new StackImpl<Integer>();
        int pushSum = 0;
        for (int i = 0; i < 10000; ++i) {
            stack.push(i);
            pushSum += i;
        }
        int popSum = 0;
        for (int i = 0; i < 10001; ++i) {
            Integer val = stack.pop();
            if (val != null) {
                popSum += val;
            }
        }
        Assert.assertEquals("test", pushSum, popSum);
    }

    @Test
    public void pop() {
        Stack<Integer> stack = new StackImpl<Integer>();
        Assert.assertEquals("test", null, stack.pop());
    }

    @Test
    public void size() {
        Stack<Integer> stack = new StackImpl<Integer>();
        Assert.assertEquals("test", 0, stack.size());
        stack.push(10);
        Assert.assertEquals("test", 1, stack.size());
        stack.pop();
        Assert.assertEquals("test", 0, stack.size());
    }

    @Test
    public void isEmpty() {
        Stack<Integer> stack = new StackImpl<Integer>();
        Assert.assertEquals("test", true, stack.isEmpty());
        stack.push(10);
        Assert.assertEquals("test", new Integer(10), stack.pop());
    }
}