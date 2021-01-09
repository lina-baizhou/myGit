package imformation;

import java.util.List;

/**
 * 信息管理
 */
public interface Dao {
    List<User> findUsers(String sql,Object[] o) throws Exception;//查询用户信息
    List<Admin> findAdmin(String sql,Object[] o) throws Exception;//查询管理员信息
    int updateUser(String sql,Object[] o) throws Exception;//更新用户信息
    int updateAdmin(String sql,Object[] o) throws  Exception;//更新管理员信息
    List<RecordStore> findRecordStore(String sql,Object[] o)throws Exception;//查询存款记录
    int updateRecordStore(String sql,Object[] o)throws Exception;//更新存款记录
    List<RecordWithdraw> findRecordWithdraw(String sql,Object[] o)throws Exception;//查询取款记录
    int updateRecordWithdraw(String sql,Object[] o)throws Exception;//更新取款记录
    List<RecordDilever> findRecordDilever(String sql,Object[] o)throws Exception;//查询转账记录
    int updateRecordDilever(String sql,Object[] o)throws Exception;//更新转账记录
}
