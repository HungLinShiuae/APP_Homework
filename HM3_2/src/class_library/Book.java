package class_library;

import java.util.Random;

public class Book implements Runnable{//既是類別，也是Thread介面(-HM3_2_3.java)
    private String title;
    private String author;
    private int pages;
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
    public Book(){
        //用空值跑run()
    }
    public void showInfo() {
        System.out.println("標題: " + title);
        System.out.println("作者: " + author);
        System.out.println("頁數: " + pages);
    }
    public void run(){//可以用Thread的方式複寫run區功能
        String[] shelf={"Pride and Prejudice","1984","Le Petit Prince","Wuthering Heights","挪威之森"};
        String[] autherString={"Jane Austen","George Orwell","Antoine de Saint-Exupery","Emily Bronte","村上春樹"}; 
        int[] pageString={432,328,96,416,296};
        Random r=new Random();
        for(int i=0;i<5;i++){
            int j=r.nextInt(5);
            Book showToday=new Book(shelf[j],autherString[j],pageString[j]);
            showToday.showInfo();
            System.out.println("---------------------");
            try {
                Thread.sleep(1000); // 暫停1秒
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
