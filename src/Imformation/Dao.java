package Imformation;

import java.util.LinkedList;
import java.util.List;

public interface Dao {
    List<User> findUsers(String sql,Object[] o) throws Exception;
    List<Admin> findAdmin(String sql,Object[] o) throws Exception;
    int updateUser(String sql,Object[] o) throws Exception;
    int updateAdmin(String sql,Object[] o) throws  Exception;
    List<RecordStore> findRecordStore(String sql,Object[] o)throws Exception;
    int updateRecordStore(String sql,Object[] o)throws Exception;
    List<RecordWithdraw> findRecordWithdraw(String sql,Object[] o)throws Exception;
    int updateRecordWithdraw(String sql,Object[] o)throws Exception;
    List<RecordDilever> findRecordDilever(String sql,Object[] o)throws Exception;
    int updateRecordDilever(String sql,Object[] o)throws Exception;
}
