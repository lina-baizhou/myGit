package LoginAndRegister;

import java.sql.*;
import java.util.*;
import Imformation.*;
import lombok.SneakyThrows;

public class CreateAccount {
    private static String sql1;
    private static Set<Integer> myset = new HashSet<Integer>();
    public String account = RandomAccount();

    public CreateAccount(String sql1){
        this.sql1=sql1;
        try {
            makeAcount();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void makeAcount() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "1234567890lina");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql1);
        while (resultSet.next()) {
            String account = resultSet.getString(1);
            myset.add(Integer.parseInt(account));
        }
    }

    public static String RandomAccount() {
        Random random = new Random();
        int rand = random.nextInt(1000000000) + 999999999;
        while (myset.contains(rand)) {
            random = new Random();
            rand = random.nextInt(1000000000) + 999999999;
        }
       return String.valueOf(rand);
    }
    /*private static String RandomPassword(){
        Random random = new Random();
        int rand = random.nextInt(100000) + 99999;
        return String.valueOf(rand);
    }
    private static String RandomID(){
        Random random = new Random();
        int rand1 = random.nextInt(1000000000) +999999999;
        int rand2=random.nextInt(10000000) +9999999;
        return String.valueOf(rand1)+String.valueOf(rand2);
    }
    private static  String RandomEmail(){
        Random random = new Random();
        int rand = random.nextInt(1000000000) + 999999999;
        return String.valueOf(rand)+"qq.com";
    }
    private static double RomdomBalancy(){
        Random random = new Random();
        double rand = random.nextInt(100000000) + 0.001;
        return rand;
    }


    @SneakyThrows
    public static void main(String[] args) {
        UserAndAdminDao dao=new UserAndAdminDao();
        int num;
        for(int i=0;i<10000;i++){
            Object[] o=new Object[5];
            o[0]=RandomAccount();
            o[1]=RandomPassword();
            o[2]=RandomID();
            o[3]=RomdomBalancy();
            o[4]=RandomEmail();
            num=dao.updateUser("insert into bankuser values(?,?,?,?,?)",o);
        }
    }*/
}


