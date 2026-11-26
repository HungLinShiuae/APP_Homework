public class HM3_1 {
    public static void main(String[] args) {
        System.out.println("---------------------\n---------------------");
        System.out.println("113360125-薛綋霖-應用軟體實習-Java Homework 3-1(CH4)");
        System.out.println("---------------------\n---------------------");
        System.out.println("以父類別宣告，以子類別建立物件");
        System.out.println("---------------------");
        defaultPerson group[]= new defaultPerson[4];//全體宣告為父類別
        group[0] = new defaultPerson("張三", "男", "1990-01-01");
        group[1] = new studentPerson("李四", "女", "1992-02-02"
            , "國立成功大學", "三年級");//可宣告其子類別，因為子類別是父類別的一種
        group[2] = new teacherPerson("王五", "男", "1985-03-03"
            , "國立臺北科技大學", "電腦科學", "10年");
        group[3] = group[1];//相同的物件
        for(int i = 0; i < group.length; i++){
            group[i].showInfo();
            System.out.println("---------------------");
        }
        System.out.println("---------------------");
        System.out.println("覆寫方法(Overriding)");
        System.out.println(group[1]);//覆寫方法
        System.out.println("---------------------\n---------------------");
        System.out.println("是否相同物件(equals)");
        System.out.println("李四與張三是否為同一個物件: " 
            + (group[1].equals(group[3])));//euqals方法
        System.out.println("---------------------\n---------------------");
        System.out.println("取得類別(getClass)");
        System.out.println("王五的類別為"+group[2].getClass());//getClass()方法
        System.out.println("---------------------\n---------------------");
        System.out.println("是否相同類別(instanceof)");
        System.out.println((group[2] instanceof teacherPerson)
            ?"王五是老師":"王五不是老師");//instanceof方法
        System.out.println("---------------------\n---------------------");
        System.out.println("CH4結束");
        System.out.println("---------------------\n---------------------");
    }
}
abstract class humanPerson//抽象類別
{
    protected String cplace;
    public void setDefault(String cplace){
        this.cplace = cplace;
        System.out.println("設定--通訊地: " + cplace);
    }
    abstract void showInfo();//抽象方法
}
class defaultPerson extends humanPerson{//既是父類別，也是繼承抽象類別的子類別
    protected String name;
    protected final String gender;//final經初始宣告後就不可被修改
    protected final String birth;
    //建構子
    public defaultPerson(String name, String gender, String birth){
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }
    //顯示資訊
    public void showInfo(){//覆寫抽象方法
        System.out.println("名字: " + name);
        System.out.println("性別: " + gender);
        System.out.println("出生日期: " + birth);
        System.out.println("通訊地: " + cplace);
    }
}
final class studentPerson extends defaultPerson{//子類別
    //private如果需要單獨呼叫，需要用自訂方法回傳
    //例:getSchool(){return school;}
    private String school;
    private String grade;
    //繼承建構子
    public studentPerson(String name, String gender, String birth
        , String school, String grade){
        super(name, gender, birth);//呼叫父類別建構子
        this.school = school;
        this.grade = grade;
    }
    //繼承方法
    public void showInfo(){
        super.showInfo();//呼叫父類別方法
        System.out.println("學校: " + school);//自己的方法
        System.out.println("年級: " + grade);
    }
    public String toString(){//覆寫toString()方法，讓一個看似是物件的變數可以直接印出其內容
        String str = "名字: " + name + "\n性別: " + gender + "\n出生日期: " + birth
            + "\n學校: " + school + "\n年級: " + grade;
        return str;
    }
}
final class teacherPerson extends defaultPerson{
    private String school;
    private String subject;
    private String year;
    public teacherPerson(String name, String gender, String birth
        , String school, String subject, String year){
        super(name, gender, birth);
        this.school = school;
        this.subject = subject;
        this.year = year;
    }
    public void showInfo(){
        super.showInfo();
        System.out.println("學校: " + school);
        System.out.println("專長: " + subject);
        System.out.println("教齡: " + year);
    }
}
interface building{//介面
    String material = "水泥";//介面變數
    void showM();//介面方法
}
interface shop extends building{//介面繼承介面
    String material = "木板";//介面變數
    void showM();//介面方法
}
class house implements building{//實作介面
    public void showM(){//實作介面方法
        System.out.println("房子建材: " + material);
    }
}
class school implements building{
    public void showM(){
        System.out.println("學校建材: " + material);
    }
}
class store implements shop, building{
    public void showM(){
        System.out.println("商店建材: " + shop.material);
        //實作兩個介面，要指定變數是哪個介面的
    }
}