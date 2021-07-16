package com.luffy.juc;

/**
 * @author luffy
 * @version 1.0
 * @date 2021/3/24 11:14
 */
class prividerAndConsumer {
    public static void main(String[] args) {
        A a = new A();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                a.indirec();
            }},"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                a.indirec();
            }},"C").start();
        new Thread(()->{for (int i = 0; i < 10; i++) {
            a.consumer();
        }},"B").start();
        new Thread(()->{for (int i = 0; i < 10; i++) {
            a.consumer();
        }},"D").start();
    }

}
class A {

    int number= 0;
    public  synchronized  void indirec(){
            try {
                while(number!=0) {
                    this.wait();
                }
                number++;
                System.out.println("+++++++++++"+number);
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public  synchronized  void consumer(){
        try {
            while(number==0) {
                this.wait();
            }
            number--;
            System.out.println("-----------"+number);
            this.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        }
