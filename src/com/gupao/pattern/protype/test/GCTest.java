package com.gupao.pattern.protype.test;

/**
 * @createby: lichanghong on 2018-05-23 13:47
 **/
public class GCTest {
    private Object instance = null;

    private static final int _1MB = 1024*1024;
    private byte [] bigSize = new byte[4*_1MB];

    public static void main(String[] args) throws InterruptedException {
        String a= "abc"; String b = "abc"; String c = new String("abc"); String d = "ab" + "c";
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(c==d);
      /*  GCTest gcA = new GCTest();
        GCTest gcb = new GCTest();
        gcA.instance = gcb;
        gcb.instance = gcA;

        gcA=null;
        gcb=null;

        System.gc();
        Thread.sleep(50000);*/
    }
}
