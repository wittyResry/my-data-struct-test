package com.mytest.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author resry.lqy
 * @version $Id: QueueImplTest.java, v 0.1 2018-06-21 09:23 resry.lqy Exp $
 */
public class QueueImplTest {

    @Test
    public void enqueue() {
        Queue<Integer> queue = new QueueImpl<Integer>(10000);
        for (int i = 0; i < 10000; ++i) {
            Assert.assertEquals("test", true, queue.enqueue(i));
        }
        Assert.assertEquals("test", 10000, queue.size());
        Assert.assertEquals("test", false, queue.enqueue(10001));
        Assert.assertEquals("test", 10000, queue.size());
    }

    @Test
    public void dequeue() {
        Queue<Integer> queue = new QueueImpl<Integer>(10000);
        Integer val = queue.dequeue();
        Assert.assertEquals("test", null, val);
        int enqueueSum = 0;
        for (int i = 0; i < 10000; ++i) {
            Assert.assertEquals("test", true, queue.enqueue(i));
            enqueueSum += i;
        }
        int dequeueSum = 0;
        for (int i = 0; i < 5000; ++i) {
            val = queue.dequeue();
            if (val != null) {
                dequeueSum += val;
            }
        }
        for (int i = 0; i < 5000; ++i) {
            Assert.assertEquals("test", true, queue.enqueue(i));
            enqueueSum += i;
        }
        for (int i = 0; i < 10000; ++i) {
            val = queue.dequeue();
            if (val != null) {
                dequeueSum += val;
            }
        }
        Assert.assertEquals("test", enqueueSum, dequeueSum);
    }

    @Test
    public void size() {
        Queue<Integer> queue = new QueueImpl<Integer>();
        Assert.assertEquals("test", 0, queue.size());
        Assert.assertEquals("test", true, queue.enqueue(10));
        Assert.assertEquals("test", 1, queue.size());
        Assert.assertEquals("test", 10, (long) queue.dequeue());
        Assert.assertEquals("test", 0, queue.size());
    }
}