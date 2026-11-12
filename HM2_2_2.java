import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HM2_2_2 {
/*    public static void main(String[] args)throws IOException {
        System.out.print("請輸入一個整數:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int num=Integer.parseInt(str);
        System.out.println("您輸入的數字為:"+num);
    }
*/
    public static void main(String[] args){
        /*System.out.print("請輸入一個整數:");
        Scanner sc1=new Scanner(System.in);
        int num1=sc1.nextInt();
        System.out.println("您輸入的數字為:"+num1);
        sc1.close();
        */
        ////////
        System.out.print("請輸入一串字串:");
        Scanner sc2=new Scanner(System.in);
        String str2=sc2.nextLine();
        char ch0=str2.charAt(0);
        char ch1=str2.charAt(1);
        int len=str2.length();
        System.out.println("第一字為:"+ch0);
        System.out.println("第二字為:"+ch1);
        System.out.println("總長度為:"+len);
        System.out.println("全大寫為:"+str2.toUpperCase());
        System.out.println("全小寫為:"+str2.toLowerCase());
        System.out.print("請輸入要找的字:");
        sc2=new Scanner(System.in);
        char ch2=sc2.next().charAt(0);
        int num2=str2.indexOf(ch2);
        if(num2==-1){
            System.out.println("找不到此字");
        }
        else{
            System.out.println("找到此字在第"+(num2+1)+"位");
        }
        System.out.print("請輸入增補字串:");
        sc2=new Scanner(System.in);
        String str3=sc2.nextLine();
        StringBuffer sb=new StringBuffer(str2);
        sb.append(str3);
        System.out.println("你把"+str3+"加在"+str2+"後面會變成:\n"+sb);
        //////////
        
    }

}