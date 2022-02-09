package main.java.StringTable;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2022/1/14 14:23
 */
public class STTest {
    public static void main(String[] args) {
        new StringBuilder()
        new StringBuffer()
        String a = "ab";
        String c = "a"+"b";
        String intern = a.intern();
        String b= new String("ab");
        String intern1 = b.intern();
        System.out.println(a == intern1);
        System.out.println(a == b);
        System.out.println(a == intern);

    }
}
