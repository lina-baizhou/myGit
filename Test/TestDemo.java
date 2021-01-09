import Imformation.*;
import Function.*;
import LoginAndRegister.*;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

//import static org.junit.*;

public class TestDemo {
    //测试管理员查找信息
    @Test
    public void testFindAdmin() throws Exception {
          UserAndAdminDao dao=new UserAndAdminDao();
          Object[] o=new Object[0];
          List<Admin> adminList=new LinkedList<>();
          adminList=dao.findAdmin("select * from bankadmin",o);
    }
    //测试用户查找信息
    @Test
    public void testFindUser() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[0];
        List<User> userList=new LinkedList<>();
        userList=dao.findUsers("select * from bankuser",o);
    }
    //测试存款记录查找
    @Test
    public void testFindRecordStore() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[0];
        List<RecordStore> recordStoreList=new LinkedList<>();
        recordStoreList=dao.findRecordStore("select * from storetable",o);
    }
    //测试取款记录查找
    @Test
    public void testFindRecordWithdraw() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[0];
        List<RecordWithdraw> recordWithdrawList=new LinkedList<>();
        recordWithdrawList=dao.findRecordWithdraw("select * from withdrawtable",o);
    }
    //测试转账记录查找
    @Test
    public void testFindRecordDilever() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[0];
        List<RecordDilever> recordDileverList=new LinkedList<>();
        recordDileverList=dao.findRecordDilever("select * from dilevertable",o);
    }
    //测试用户信息更新操作
    @Test
    public void testUpdateUser() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[1];
        String aa="11";
        o[0]=aa;
        int num=dao.updateUser("delete from bankuser where account=?",o);
    }
    //测试管理员信息更新操作
    @Test
    public void testUpdateAdmin() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[1];
        String aa="11";
        o[0]=aa;
        int num=dao.updateAdmin("delete from bankadmin where account=?",o);
    }
    //测试存款记录更新操作
    @Test
    public void testUpdateRecordStore() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[1];
        o[0]=100;
        int num=dao.updateRecordStore("delete from storetable where money=?",o);
    }
    //测试取款记录更新操作
    @Test
    public void testUpdateRecordWithdraw() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[1];
        o[0]=100;
        int num=dao.updateRecordWithdraw("delete from withdrawtable where money=?",o);
    }
    //测试转账更新操作
    @Test
    public void testUpdateRecordDilever() throws Exception {
        UserAndAdminDao dao=new UserAndAdminDao();
        Object[] o=new Object[1];
        o[0]=100;
        int num=dao.updateRecordDilever("delete from dilevertable where money=?",o);
    }
}
