// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.Scanner;
public class HM2_1 {
    public static void main(String[] args) {

        
        System.out.print("///IF/ELSE TEST///\n"+"Input Integer:");
        Scanner numscanner = new Scanner(System.in);
        int num ;
        num = numscanner.nextInt();
        if(num == 1 || num == 2) {
            System.out.println("This is "+num);
        }
        else {
            System.out.println("Please Input 1 or 2.");
        }

        
        System.out.print("///Switch TEST///\n"+"Input Charactor:");
        Scanner charscanner = new Scanner(System.in);
        char ch;
        ch = charscanner.next().charAt(0);
        switch(ch){
            case 'a':{
                System.out.println("This is "+ch);
                break;
            }
            case 'b':{
                System.out.println("This is "+ch);
                break;
            }
            default:{
                System.out.println("Please Input a or b");
            }
        }

        
        System.out.print("///Conditional Operator TEST///\n"+"Input Integer:");
        int check=numscanner.nextInt();
        char result=(check==1)?'A':'B';
        System.out.println("check="+check+",result="+result);


        System.out.print("///Loop TEST///\n"+"Input Number to Loop:");
        int loop=numscanner.nextInt();
        System.out.print("Input Number to Continue:");
        int loopcon=numscanner.nextInt();
        System.out.print("Input Number to Break:");
        int loopbreak=numscanner.nextInt();
        int loopin=0;
        for(loopin=0;loopin<loop;loopin++){
            if(loopin==loopcon){
                continue;
            } 
            else{
                System.out.println("This is "+loopin+" round");
            }
        }
        loopin=0;
        while(loopin<loop){
            if(loopin==loopcon){
                loopin++;
                continue;
            } 
            else{
                System.out.println("This is "+loopin+" round");
                loopin++;
            }
        }
        loopin=0;
        do{
            if(loopin==loopcon){
                loopin++;
                continue;
            }
            else{
                System.out.println("This is "+loopin+" round");
                loopin++;
            }
        }while(loopin<loop);
        loopin=0;
        
        System.out.println("///Nested Loop, Loop Continue=Second Loop///");
        for(int i=0;i<loop;i++){
            for(int j=0;j<loopcon;j++){
                    System.out.print("F");
                }
            System.out.print("\n");
        }


        System.out.println("///Array Test///\n"+"Please Input Students' points");
        int ar1=3,ar2=2;
        int [][] at=new int[3][2];
        at[0][0]=1;
        at[1][0]=2;
        at[2][0]=3;
        for(int i=0;i<ar1;i++){
            System.out.print("No."+(i+1)+" Student's points:");
            at[i][1]=numscanner.nextInt();
        }
        System.out.println("///I do the bubble-sorting,too///");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2 - i; j++) {
                if(at[j][1] < at[j+1][1]) {
                int tempp=at[j][1];
                int tempn=at[j][0];
                at[j][1]=at[j+1][1];
                at[j][0]=at[j+1][0];
                at[j+1][1]=tempp;
                at[j+1][0]=tempn;
                }
            }
        }
        for(int i=0;i<ar1;i++){
            System.out.println("The "+(i+1)+" Student is No."+(at[i][0])+"="+(at[i][1])+"points");
        }

        
        System.out.println("///Homework done///");
    }
}