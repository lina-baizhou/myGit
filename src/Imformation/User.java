package Imformation;

public class User implements java.io.Serializable{
    private String account;
    private String password;
    private String ID;
    private double balancy;
    private String email;
    public User(String account,String password,String ID, double balancy,String email){
        this.account=account;
        this.password=password;
        this.ID=ID;
        this.balancy=balancy;
        this.email=email;
    }
    public String getAccount()
    {
        return account;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public double getBalancy() {
        return balancy;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalancy(double balancy) {
        this.balancy = balancy;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){
        return "账号："+this.getAccount()+"，密码："+this.getPassword()+"ID："+this.getID()+"余额："+balancy;
    }

}

