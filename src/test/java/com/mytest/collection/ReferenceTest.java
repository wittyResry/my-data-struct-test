/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.mytest.collection;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Test;

/**
 * 软引用影响垃圾回收，但是弱引用不影响垃圾回收
 *
 * @author resry.lqy
 * @version $Id: ReferenceTest.java, v 0.1 2018-06-21 13:37 resry.lqy Exp $
 */
public class ReferenceTest {
    @Test
    public void test() {
        // 在堆内存中创建String类型
        String str = new String("abc");

        SoftReference<String> srf = new SoftReference<String>(str);
        WeakReference<String> wrf = new WeakReference<String>(str);

        // 去除强引用
        str = null;

        // 去除软引用，否则GC无法回收str
        srf.clear();

        // 软引用影响垃圾回收，但是弱引用不影响垃圾回收
        System.gc();


        String srfString = srf.get();

        String wrfString = wrf.get();

        System.out.println("srfString:"+srfString);
        System.out.println("wrfString:"+wrfString);
    }
}
