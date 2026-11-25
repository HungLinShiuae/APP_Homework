package main;

import java.io.IOException;
import class_library.Book;

public class HM3_2_3 {
    public static void main(String[] args) throws IOException {//丟出IOException例外
        System.out.println("---------------------\n---------------------");
        System.out.println("113360125-薛綋霖-應用軟體實習-Java Homework 3-2-3(CH5-3)");
        System.out.println("---------------------\n---------------------");
        System.out.println("Thread的使用");
        System.out.println("---------------------");
        MyThread t[] = new MyThread[2];
        t[0] = new MyThread("Thread-1");
        t[0].start();
        t[1] = new MyThread("Thread-2");
        t[1].start();
        try{
            t[0].join();
            t[1].join();
        }
        catch(InterruptedException e){//捕捉執行緒中斷例外
            System.out.println("[錯誤]:執行緒中斷例外"+"("+e+")");
        }
        /*(-Line:17)*/System.out.println("(輔證明中斷工作)");
        System.out.println("---------------------\n---------------------");
        System.out.println("運用Runnable介面將類別實作成Thread");
        System.out.println("---------------------");
        Book testBook=new Book();
        Thread testThread=new Thread(testBook);
        testThread.start();
        try{
            testThread.join();
        }
        catch(InterruptedException e){
            System.out.println("[錯誤]:執行緒中斷例外"+"("+e+")");
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("同步化(synchronized)");
        System.out.println("---------------------");
        SyncExample se = new SyncExample();
        t[0]=new MyThread(se);//用同步化範例處理執行續
        t[0].start();
        t[1]=new MyThread(se);
        t[1].start();
        try{//join時，必須先執行完Thread的工作，才能做接下來的事(-Line:54)
            t[0].join();
            t[1].join();
        }
        catch(InterruptedException e){
            System.out.println("[錯誤]:執行緒中斷例外"+"("+e+")");
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("CH5-3結束,Java Homework 3結束");//否則這行會先輸出
        System.out.println("---------------------\n---------------------");
    }
}
class MyThread extends Thread{
    private SyncExample se;//同步化範例變數
    public MyThread(String name){//name是Thread的名稱變數，可用getName()呼叫
        super(name);
    }
    public MyThread(SyncExample se){//同步化範例建構子
        this.se = se;
    }
    public void run(){//run是Thread的操作區，複寫這區以執行自訂程式
        for(int i=0;i<5;i++){
            try{
                sleep(1000);
                se.increment(20);//每次增加20元(Thread的使用(-Line:11)會出現錯誤，正常)
            }
            catch(InterruptedException e){//驗證這行的正確性
                System.out.println("[錯誤]:執行緒中斷例外"+"("+e+")");
            }
        }
    } 
}
class SyncExample {
    private int count = 0;
    public synchronized void increment(int i) {
        int temp=count;
        System.out.println("目前執行續"+Thread.currentThread().getName());
        System.out.println("目前金額為:"+temp+"元");
        temp+=i;
        System.out.println("收到:"+i+"元"+",目前金額為:"+temp+"元");
        System.out.println("---------------------");
        count=temp;
    }
}