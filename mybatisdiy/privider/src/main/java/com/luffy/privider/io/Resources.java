package com.luffy.privider.io;

import java.io.InputStream;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/9/27 15:15
 */
public class Resources {
    /**
     * 根据配置文件的路径，将配置文件加载到字节输入流中
     * @param path
     * @return
     */
    public static InputStream getResouceAsStream(String path){
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }



}
