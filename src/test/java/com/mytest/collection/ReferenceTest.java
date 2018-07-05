/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.mytest.collection;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Test;

/**
 * ������Ӱ���������գ����������ò�Ӱ����������
 *
 * @author resry.lqy
 * @version $Id: ReferenceTest.java, v 0.1 2018-06-21 13:37 resry.lqy Exp $
 */
public class ReferenceTest {
    @Test
    public void test() {
        // �ڶ��ڴ��д���String����
        String str = new String("abc");

        SoftReference<String> srf = new SoftReference<String>(str);
        WeakReference<String> wrf = new WeakReference<String>(str);

        // ȥ��ǿ����
        str = null;

        // ȥ�������ã�����GC�޷�����str
        srf.clear();

        // ������Ӱ���������գ����������ò�Ӱ����������
        System.gc();


        String srfString = srf.get();

        String wrfString = wrf.get();

        System.out.println("srfString:"+srfString);
        System.out.println("wrfString:"+wrfString);
    }
}
