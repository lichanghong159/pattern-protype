package com.gupao.pattern.protype.test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @createby: lichanghong on 2018-05-23 14:23
 **/
public class Test {
    private static final List<Object> TEST_DATA = new LinkedList<Object>();

    private static final ReferenceQueue<Sample> QUEUE = new ReferenceQueue<Sample>();
        public static void main(String[] args) {
            //创建一个对象，new出来的对象都是分配在java堆中的
            Sample sample = new Sample();   //sample这个引用就是强引用

            //创建一个软引用指向这个对象   那么此时就有两个引用指向Sample对象
            final SoftReference<Sample> softRef = new SoftReference<Sample>(sample, QUEUE);

            //将强引用指向空指针 那么此时只有一个软引用指向Sample对象
            //注意：softRef这个引用也是强引用，它是指向SoftReference这个对象的
            //那么这个软引用在哪呢？ 可以跟一下java.lang.Reference的源码
            //private T referent; 这个才是软引用， 只被jvm使用
            sample = null;
            StringBuilder sb = new StringBuilder();
            StringBuffer sb1 = new StringBuffer();

            //可以重新获得Sample对象，并用一个强引用指向它
            //sample = softRef.get();

            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        System.out.println(softRef.get());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                        TEST_DATA.add(new byte[1024 * 1024 * 100]);
                    }
                }
            }.start();

            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        Reference<? extends Sample> poll = QUEUE.poll();
                        if (poll != null) {
                            System.out.println("--- 软引用对象被jvm回收了 ---- " + poll);
                            System.out.println("--- 回收对象 ---- " + poll.get());
                        }
                    }
                }
            }.start();

            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                System.exit(1);
            }
        }

    }

    class Sample {
        private final byte[] data;

        public Sample() {
            data = new byte[1024 * 1024 * 100];
        }
    }

