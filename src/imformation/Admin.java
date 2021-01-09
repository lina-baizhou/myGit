package imformation;

/**
 * 管理员
 */
public class Admin {
    private String account;//账号
    private String password;//密码

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return account;
    }
    public Admin(String account,String password){
        this.account=account;
        this.password=password;
    }

    @Override
    public String toString() {
      return "账号："+account+"，密码："+password;
    }
}
