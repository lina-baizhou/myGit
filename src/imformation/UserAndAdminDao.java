package imformation;

import base.BaseUA;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserAndAdminDao extends BaseUA implements Dao {
    @Override
    public List<Admin> findAdmin(String sql, Object[] o) throws Exception {//对管理员表进行查询操作
        ResultSet resultSet=BaseUA.executeQuerySQL(sql,o);
        List<Admin>  adminList=new ArrayList<Admin>();
        while (resultSet.next()){
            String account=resultSet.getString(1);
            String password=resultSet.getString(2);
            Admin admin=new Admin(account,password);
            adminList.add(admin);
        }
        return adminList;
    }

    @Override
    public int updateAdmin(String sql, Object[] o) throws Exception {//对管理员表进行更新操作
        int num=BaseUA.excuteSQL2(sql,o);
        return num;
    }

    @Override
    public List<RecordStore> findRecordStore(String sql, Object[] o) throws Exception {
        ResultSet resultSet=BaseUA.executeQuerySQL(sql,o);
        List<RecordStore> recordStoreArrayList=new ArrayList<RecordStore>();
        while (resultSet.next()){
            String account=resultSet.getString(1);
            Double money=resultSet.getDouble(2);
            String time=resultSet.getString(3);
            RecordStore recordStore=new RecordStore(account,money,time);
            recordStoreArrayList.add(recordStore);
        }
        return recordStoreArrayList;
    }

    @Override
    public int updateRecordStore(String sql, Object[] o) throws Exception {
       int num=BaseUA.excuteSQL2(sql,o);
       return num;
    }

    @Override
    public List<RecordWithdraw> findRecordWithdraw(String sql, Object[] o) throws Exception {
        ResultSet resultSet=BaseUA.executeQuerySQL(sql,o);
        List<RecordWithdraw> recordWithdrawArrayList=new ArrayList<RecordWithdraw>();
        while (resultSet.next()){
            String account=resultSet.getString(1);
            Double money=resultSet.getDouble(2);
            String time=resultSet.getString(3);
            RecordWithdraw recordStore=new RecordWithdraw(account,money,time);
            recordWithdrawArrayList.add(recordStore);
        }
        return recordWithdrawArrayList;
    }

    @Override
    public int updateRecordDilever(String sql, Object[] o) throws Exception {
        int num=BaseUA.excuteSQL2(sql,o);
        return num;
    }

    @Override
    public List<RecordDilever> findRecordDilever(String sql, Object[] o) throws Exception {
        ResultSet resultSet=BaseUA.executeQuerySQL(sql,o);
        List<RecordDilever> recordDeliverArrayList=new ArrayList<RecordDilever>();
        while (resultSet.next()){
            String accountA=resultSet.getString(1);
            String accountB=resultSet.getString(2);
            Double money=resultSet.getDouble(3);
            String time=resultSet.getString(4);
            RecordDilever recordDilever=new RecordDilever(accountA,accountB,money,time);
           recordDeliverArrayList.add(recordDilever);
        }
        return recordDeliverArrayList;
    }
    @Override
    public int updateRecordWithdraw(String sql, Object[] o) throws Exception {
        int num=BaseUA.excuteSQL2(sql,o);
        return num;
    }

    @Override
    public List<User> findUsers(String sql, Object[] o) throws Exception {//对用户表进行查询操作
        ResultSet resultSet=BaseUA.executeQuerySQL(sql,o);
        List<User>  userList=new ArrayList<User>();
        while (resultSet.next()){
            String account=resultSet.getString(1);
            String password=resultSet.getString(2);
            String ID=resultSet.getString(3);
            double balancy=resultSet.getDouble(4);
            String email=resultSet.getString(5);
            User user=new User(account,password,ID,balancy,email);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public int updateUser(String sql, Object[] o) throws Exception {
        int num=BaseUA.excuteSQL2(sql,o);
        return num;
    }
}
