package main;
import class_library.Book;//引用class_library套件內的Book類別
import class_library.CatchException;//引用class_library套件內的CatchException類別
import java.util.Scanner;
public class HM3_2_1 {
    public static void main(String[] args) throws CatchException {//丟出CatchException例外
        System.out.println("---------------------\n---------------------");
        System.out.println("113360125-薛綋霖-應用軟體實習-Java Homework 3-2-1(CH5-1)");
        System.out.println("---------------------\n---------------------");
        System.out.println("分割檔案為類別(Book.java)與程式(HM3_2.java)");
        System.out.println("分割package為類別(class_library)與程式(main)");
        System.out.println("已實作在檔案夾內");
        System.out.println("---------------------");
        Book book[]=new Book[5];
        book[0] = new Book("L'Etranger", "Albert Camus", 123);
        book[1] = new Book("蜘蛛之糸", "芥川龍之介", 456);
        book[0].showInfo();
        book[1].showInfo();
        System.out.println("---------------------\n---------------------");
        System.out.println("利用try-catch捕捉陣列越界例外(ArrayIndexOutOfBoundsException)");
        System.out.println("---------------------");
        try {//嘗試做
            book[2]=new Book("The Terrible Thing That Happened to Barnaby Brocket", "John Boyne", 789);
            book[2].showInfo();
            book[5]=new Book("九份地底有條龍","李儀婷",264);//這行會發生陣列越界例外
            book[5].showInfo();
            book[3]=new Book("紅樓夢","曹雪芹",1000);//這行不會執行
            book[3].showInfo();
        } catch(ArrayIndexOutOfBoundsException e){//抓錯誤
            System.out.println("[錯誤]:陣列越界例外"+"("+e+")");
        }
        finally{//必須做
            System.out.println("--程式繼續執行--");
            book[3]=new Book("水滸傳","施耐庵",1000);//這行會執行
            book[3].showInfo();
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("利用throw丟出自訂例外(CatchException)");
        System.out.println("---------------------");
        System.out.print("請輸入書名:");
        Scanner sc = new Scanner(System.in);
        String bookname = sc.nextLine();
        System.out.print("請輸入作者:");
        String author = sc.nextLine();
        System.out.print("請輸入頁數(嘗試輸入負數驗證例外丟出):");
        int pages = sc.nextInt();
        if(pages<0){//如果頁數小於0
            throw new CatchException("頁數不能小於0");//丟出自訂例外
        }
        else{
            book[4] = new Book(bookname, author, pages);
            book[4].showInfo();
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("CH5-1結束,剩餘程式碼請參考Java Homework 3-2-2(CH5-2)");
        System.out.println("---------------------\n---------------------");
    }
}
