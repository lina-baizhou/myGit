package base;

import java.sql.*;

/**
 * 数据库操作
 */
public class BaseUA {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/user";
    private static String user="root";
    private static String password="1234567890lina";
    static  {
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
    public void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if(conn!=null){
            conn.close();
        }
        if(stmt!=null){
            stmt.close();
        }if(rs!=null){
            rs.close();
        }
    }
    public static void closeAll(Connection conn, Statement stmt) throws SQLException {
        if(conn!=null){
            conn.close();
        }
        if(stmt!=null){
            stmt.close();
        }
    }
    public static ResultSet executeQuerySQL(String preparedSql, Object[] param) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet num=null;
        /* 处理SQL,执行SQL */
        try {
            conn = getConnection(); // 得到数据库连接
            pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            num = pstmt.executeQuery(); // 执行SQL语句
        } catch(SQLException e) {
            e.printStackTrace(); // 处理SQLException异常
        }
        return num;
    }
    public static ResultSet executeSQL1(String sql) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet num=null;
        /* 处理SQL,执行SQL */
        try {
            conn = getConnection(); // 得到数据库连接
            stmt=conn.createStatement();
            num = stmt.executeQuery(sql); // 执行SQL语句
        } catch(SQLException e) {
            e.printStackTrace(); // 处理SQLException异常
        }
        return num;
    }
     public static int excuteSQL2(String preparedSql,Object[] param){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int num;
        /* 处理SQL,执行SQL */
        try {
            conn = getConnection(); // 得到数据库连接
            pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
            if (pstmt != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            num=pstmt.executeUpdate();
            return num;
        } catch(SQLException e) {
            e.printStackTrace(); // 处理SQLException异常
        }
        return -1;
    }
}
