package Imformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordWithdraw {
    private String account;
    private double money;
    private String time;
    /*public RecordWithdraw(String account,double money,String time){
        this.account=account;
        this.money=money;
        this.time=time;
    }*/
    public double getMoney() {
        return money;
    }

    public String getAccount() {
        return account;
    }

    public String getTime() {
        return time;
    }
}
