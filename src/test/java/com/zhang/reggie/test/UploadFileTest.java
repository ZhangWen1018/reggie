package com.zhang.reggie.test;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangLi
 * @version 1.0
 */
public class UploadFileTest {
    @Test
    public void test1(){
        String fileName = "oreoerwe.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }
}
