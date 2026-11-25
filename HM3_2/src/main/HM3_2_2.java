package main;
import java.io.FileReader;//檔案讀取
import java.io.BufferedReader;//緩衝器讀取
import java.io.InputStreamReader;//輸入串流讀取
import java.io.FileWriter;//檔案寫入
import java.io.BufferedWriter;//緩衝器寫入
import java.io.PrintWriter;//列印寫入
import java.io.IOException;//輸入輸出例外
public class HM3_2_2 {
    public static void main(String[] args) throws IOException {//丟出IOException例外
        System.out.println("---------------------\n---------------------");
        System.out.println("113360125-薛綋霖-應用軟體實習-Java Homework 3-2-2(CH5-2)");
        System.out.println("---------------------\n---------------------");
        System.out.println("BufferedReader與BufferedWriter的使用");
        System.out.println("---------------------");
        System.out.print("請輸入字串:");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str= br.readLine();
            System.out.println("您輸入的字串為:"+str);
        }
        catch(IOException e){//抓錯誤
            System.out.println("[錯誤]:輸入輸出例外"+"("+e+")");
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("利用BufferedWriter寫入檔案");
        System.out.println("---------------------");
        try{
            FileWriter fw = new FileWriter("src/test_text/WriteFile.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            pw.println("113360125-薛綋霖-應用軟體實習-Java Homework 3-2-2(CH5-2)");
            pw.println("BufferedReader與BufferedWriter的使用");
            pw.close();
            System.out.println("字串已寫入:[test_text/WriteFile.txt]");
        }
        catch(IOException e){//抓錯誤
            System.out.println("[錯誤]:輸入輸出例外"+"("+e+")");
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("利用BufferedReader讀取檔案");
        System.out.println("---------------------");
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/test_text/ReadFile.txt"));
            String readLine;
            System.out.println("檔案內容:");
            while((readLine = br.readLine()) != null){
                System.out.println(readLine);
            }
            br.close();
        }
        catch(IOException e){//抓錯誤
            System.out.println("[錯誤]:輸入輸出例外"+"("+e+")");
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("命令列引數");
        System.out.println("---------------------");
        if(args.length > 0){
            System.out.println("命令列引數內容:"+args[0]);
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String readLine;
            System.out.println("檔案內容:");
            while((readLine = br.readLine()) != null){
                System.out.println(readLine);
            }
            br.close();
        }else{
            System.out.println("沒有命令列引數");
        }
        System.out.println("---------------------\n---------------------");
        System.out.println("CH5-2結束,剩餘程式碼請參考Java Homework 3-2-3(CH5-3)");
        System.out.println("---------------------\n---------------------");
    }
}