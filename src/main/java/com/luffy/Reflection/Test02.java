package com.luffy.Reflection;

/**
 * @author luffy
 * @version 1.0
 * @desc class类的几种创建方式
 * @date 2021/5/28 11:10
 */
public class Test02 {

    public static void main(String[] args) throws ClassNotFoundException {
        Person student =new Student();
        System.out.println(student.name);
        //1.通过对象获取
        Class<? extends Person> aClass = student.getClass();
        System.out.println(aClass.hashCode());
        //2.forname
        Class<?> aClass1 = Class.forName("com.luffy.Reflection.Student");
        System.out.println(aClass1.hashCode());
        //3.通过。class活得
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass.hashCode());
        //4.基本内置类型的包装类型都有一个Type属性
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        //获得父类类型
        Class<?> superclass = aClass.getSuperclass();
    }
}
class Person{
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
class Student extends Person{
    public Student(){
        this.name="学生";
    }
}
class Teache extends Person{
    public Teache(){
        this.name="老师";
    }
}
