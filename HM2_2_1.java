import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class HM2_2_1 {
    public static void main(String[] args)throws IOException {
    //Class Test//
        Vehicle vcar1=new Vehicle();
        vcar1.setVehicleDefault(9527,40.01);
        vcar1.showAll();
        int carnum=vcar1.getCarNum()+25;
        double cargas=vcar1.getCarGas()+10.87;
    //Public Test
        Vehicle vcar2=new Vehicle(carnum,cargas);
        vcar2.showAll();
    //Call All Test
        Vehicle.showSum();
        Vehicle[] Car3=new Vehicle[3];
        for(int i=0;i<Car3.length;i++){
            Car3[i]=new Vehicle();
        }
        Car3[0].setVehicleDefault(5499,75.4);
        Car3[1].setVehicleDefault(5440,50.00);
        Car3[2].setVehicleDefault(5477,67.67);
        for(int i=0;i<Car3.length;i++){
            Car3[i].showAll();
        }
    }
}

class Vehicle
{
    public static int sum=0;
    private int num;
    private double gas;
    public void show()
    {
        System.out.println("預設車牌號碼:"+this.num);
        System.out.printf("預設汽油量:%.2f公升%n",gas);
        System.out.println("");
    }
    public void showAll()
    {
        System.out.println("顯示該車輛"+num+"的所有資訊");
        this.show();
    }
    public Vehicle()
    {
        num=0;
        gas=0;
        sum++;
        System.out.println("生產車輛");
        System.out.println("");
    }
    public Vehicle(int n,double g)
    {
        num=n;
        gas=g;
        sum++;
        System.out.printf("生產車輛號碼:%d，油量:%.2f公升\n",num,gas);
    }
    public void setVehicleDefault(int n,double g)
    {
        if(g<=100&&g>=0)
        {
            this.num=n;
            gas=g;
            System.out.println("預設車牌號碼:"+num);
            System.out.println("預設汽油量:"+gas);
            System.out.println("");
        }
        else{
            System.out.println("油量錯誤，請重新輸入");
        }
    }
    public int getCarNum()
    {
        System.out.println("調查車牌號碼");
        return num;
    }
    public double getCarGas()
    {
        System.out.println("調查該車油量");
        return gas;
    }
    public static void showSum()
    {
        System.out.println("目前總共有"+sum+"台車");
    }
}