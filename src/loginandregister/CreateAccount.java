package loginandregister;

import imformation.User;
import imformation.UserAndAdminDao;
import lombok.SneakyThrows;
/**
 * 随机生成账号
 */
import java.sql.*;
import java.util.*;

public class CreateAccount {
    private static String sql1="select * from bankuser";
    private static Set<Integer> myset = new HashSet<Integer>();
    public String account;

    public CreateAccount(){
        try {
            makeAcount();
            account=RandomAccount();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void makeAcount() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        List<User> userList=new LinkedList<>();
        userList=dao.findUsers(sql1,null);
        for(int i=0;i<userList.size();i++) {
            String account = userList.get(i).getAccount();
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
   /* private static String RandomPassword(){
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
        double rand = Double.parseDouble(String.valueOf(random.nextInt(100000000)))*0.01;
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


