package main.java;

import java.io.File;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/6/24 14:23
 */
public class test11 {

    static int filecount=0;
    static int floderCount=0;
    static long filemax=0;

        public static void main(String[] args) {
             getFile("D:\\安装文件");
            System.out.println("共有"+filecount+"个文件");
            System.out.println("共有"+floderCount+"个文件夹");
            System.out.println("大小"+filemax/1024/1024+"MB");
        }

        public static void getFile(String filepath) {
            File file = new File(filepath);
            File[] listfile = file.listFiles();
            for (int i = 0; i < listfile.length; i++) {
                if (!listfile[i].isDirectory()) {
                    long totalSpace = listfile[i].getTotalSpace();
                    filemax=filemax+totalSpace;
                    String temp=listfile[i].toString().substring(7,listfile[i].toString().length()) ;
                    System.out.println("temp=="+temp);
                    filecount++;
                    System.out.println("文件"+filecount+"---path=" + listfile[i]);
                } else {
                    String temp=listfile[i].toString().substring(7,listfile[i].toString().length()) ;
                    floderCount++;
                    System.out.println("文件夹=="+temp);
                    getFile(listfile[i].toString());
                }
            }
        }
    }

